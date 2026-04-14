package com.hrconsultancy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hrconsultancy.model.Candidate;
import com.hrconsultancy.util.DBConnection;

public class CandidateDAO {

    public boolean saveCandidate(Candidate candidate) {
        boolean status = false;

        String query = "INSERT INTO candidates (full_name, email, phone, qualification, experience_years, skills, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, candidate.getFullName());
            ps.setString(2, candidate.getEmail());
            ps.setString(3, candidate.getPhone());
            ps.setString(4, candidate.getQualification());
            ps.setString(5, candidate.getExperienceYears());
            ps.setString(6, candidate.getSkills());
            ps.setString(7, candidate.getPassword());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();

        String query = "SELECT * FROM candidates ORDER BY created_at DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Candidate candidate = new Candidate();

                candidate.setId(rs.getInt("id"));
                candidate.setFullName(rs.getString("full_name"));
                candidate.setEmail(rs.getString("email"));
                candidate.setPhone(rs.getString("phone"));
                candidate.setQualification(rs.getString("qualification"));
                candidate.setExperienceYears(rs.getString("experience_years"));
                candidate.setSkills(rs.getString("skills"));
                candidate.setCreatedAt(rs.getTimestamp("created_at"));

                candidates.add(candidate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return candidates;
    }

    public int getCandidateCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM candidates";

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

    public Candidate getCandidateByEmailAndPassword(String email, String password) {
        Candidate candidate = null;

        String sql = "SELECT * FROM candidates WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    candidate = new Candidate();
                    candidate.setId(rs.getInt("id"));
                    candidate.setFullName(rs.getString("full_name"));
                    candidate.setEmail(rs.getString("email"));
                    candidate.setPhone(rs.getString("phone"));
                    candidate.setQualification(rs.getString("qualification"));
                    candidate.setExperienceYears(rs.getString("experience_years"));
                    candidate.setSkills(rs.getString("skills"));
                    candidate.setPassword(rs.getString("password"));
                    candidate.setCreatedAt(rs.getTimestamp("created_at"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return candidate;
    }
}