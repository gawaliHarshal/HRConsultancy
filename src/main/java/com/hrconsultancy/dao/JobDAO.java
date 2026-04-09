package com.hrconsultancy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hrconsultancy.model.Job;
import com.hrconsultancy.util.DBConnection;

public class JobDAO {

    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();

        String query = "SELECT * FROM jobs ORDER BY created_at DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Job job = new Job();

                job.setId(rs.getInt("id"));
                job.setTitle(rs.getString("title"));
                job.setCompanyName(rs.getString("company_name"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getString("salary"));
                job.setExperienceRequired(rs.getString("experience_required"));
                job.setDescription(rs.getString("description"));
                job.setCreatedAt(rs.getTimestamp("created_at"));

                jobs.add(job);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobs;
    }
    
    public int getJobCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM jobs";

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