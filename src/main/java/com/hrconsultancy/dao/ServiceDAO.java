package com.hrconsultancy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hrconsultancy.model.Service;
import com.hrconsultancy.util.DBConnection;

public class ServiceDAO {

    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();

        String query = "SELECT * FROM services";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setTitle(rs.getString("title"));
                service.setDescription(rs.getString("description"));

                services.add(service);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return services;
    }
}