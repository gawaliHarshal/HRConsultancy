package com.hrconsultancy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hrconsultancy.model.JobApplication;
import com.hrconsultancy.util.DBConnection;

public class JobApplicationDAO {

    public boolean applyForJob(JobApplication application) {
        boolean status = false;

        String query = "INSERT INTO job_applications (candidate_id, job_id, application_status) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

        	ps.setInt(1, application.getCandidateId());
        	ps.setInt(2, application.getJobId());
        	ps.setString(3, "Pending");

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<JobApplication> getAllApplications() {
        List<JobApplication> applications = new ArrayList<>();

        String query = "SELECT ja.*, c.full_name, j.title " +
                       "FROM job_applications ja " +
                       "JOIN candidates c ON ja.candidate_id = c.id " +
                       "JOIN jobs j ON ja.job_id = j.id " +
                       "ORDER BY ja.applied_at DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                JobApplication app = new JobApplication();

                app.setId(rs.getInt("id"));
                app.setCandidateId(rs.getInt("candidate_id"));
                app.setJobId(rs.getInt("job_id"));
                app.setApplicationStatus(rs.getString("application_status")); // change to "status" if needed
                app.setAppliedAt(rs.getTimestamp("applied_at"));
                app.setCandidateName(rs.getString("full_name"));
                app.setJobTitle(rs.getString("title"));

                applications.add(app);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return applications;
    }

    public int getApplicationCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM job_applications";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public boolean hasCandidateApplied(int candidateId, int jobId) {
        boolean applied = false;

        String sql = "SELECT COUNT(*) FROM job_applications WHERE candidate_id = ? AND job_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, candidateId);
            ps.setInt(2, jobId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    applied = rs.getInt(1) > 0;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return applied;
    }
    
    public java.util.Set<Integer> getAppliedJobIdsByCandidate(int candidateId) {
        java.util.Set<Integer> appliedJobIds = new java.util.HashSet<>();

        String sql = "SELECT job_id FROM job_applications WHERE candidate_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, candidateId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    appliedJobIds.add(rs.getInt("job_id"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appliedJobIds;
    }
    
    public boolean updateApplicationStatus(int id, String status) {
        boolean result = false;

        String sql = "UPDATE job_applications SET application_status = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            result = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public java.util.Map<Integer, String> getApplicationStatusByCandidate(int candidateId) {
        java.util.Map<Integer, String> statusMap = new java.util.HashMap<>();

        String sql = "SELECT job_id, application_status FROM job_applications WHERE candidate_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, candidateId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    statusMap.put(
                        rs.getInt("job_id"),
                        rs.getString("application_status")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return statusMap;
    }
}