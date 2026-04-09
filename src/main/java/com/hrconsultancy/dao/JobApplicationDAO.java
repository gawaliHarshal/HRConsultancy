package com.hrconsultancy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hrconsultancy.model.JobApplication;
import com.hrconsultancy.util.DBConnection;

public class JobApplicationDAO
{

    public boolean applyForJob(JobApplication application)
    {
        boolean status = false;

        String query = "INSERT INTO job_applications (candidate_id, job_id) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query))
        {

            ps.setInt(1, application.getCandidateId());
            ps.setInt(2, application.getJobId());

            int rows = ps.executeUpdate();

            if (rows > 0)
            {
                status = true;
            }

        } catch (Exception e)
        {
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
                app.setApplicationStatus(rs.getString("application_status"));
                app.setAppliedAt(rs.getTimestamp("applied_at"));

                // NEW DATA (temporary, we will store properly next)
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
}