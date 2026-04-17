package com.hrconsultancy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hrconsultancy.model.Job;
import com.hrconsultancy.util.DBConnection;

public class JobDAO {

    public List<Job> getAllJobs()
    {
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
    
    public int getJobCount()
    {
        int count = 0;
        String query = "SELECT COUNT(*) FROM jobs";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery())
        {

            if (rs.next())
            {
                count = rs.getInt(1);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return count;
    }
    
    public boolean addJob(Job job)
    {
        boolean status = false;

        String sql = "INSERT INTO jobs (title, company_name, location, salary, experience_required, description) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getCompanyName());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getSalary());
            ps.setString(5, job.getExperienceRequired());
            ps.setString(6, job.getDescription());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public boolean deleteJob(int id)
    {
        boolean status = false;

        String sql = "DELETE FROM jobs WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            status = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public Job getJobById(int id)
    {
        Job job = null;

        String sql = "SELECT * FROM jobs WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    job = new Job();
                    job.setId(rs.getInt("id"));
                    job.setTitle(rs.getString("title"));
                    job.setCompanyName(rs.getString("company_name"));
                    job.setLocation(rs.getString("location"));
                    job.setSalary(rs.getString("salary"));
                    job.setExperienceRequired(rs.getString("experience_required"));
                    job.setDescription(rs.getString("description"));
                    job.setCreatedAt(rs.getTimestamp("created_at"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return job;
    }
    
    public boolean updateJob(Job job) {
        boolean status = false;

        String sql = "UPDATE jobs SET title = ?, company_name = ?, location = ?, salary = ?, experience_required = ?, description = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getCompanyName());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getSalary());
            ps.setString(5, job.getExperienceRequired());
            ps.setString(6, job.getDescription());
            ps.setInt(7, job.getId());

            int rows = ps.executeUpdate();
            status = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}