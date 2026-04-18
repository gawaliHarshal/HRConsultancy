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
    
    public boolean addService(Service service) {
        boolean status = false;

        String sql = "INSERT INTO services (title, description) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, service.getTitle());
            ps.setString(2, service.getDescription());

            int rows = ps.executeUpdate();
            status = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public boolean deleteService(int id) {
        boolean status = false;

        String sql = "DELETE FROM services WHERE id = ?";

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
    
    public Service getServiceById(int id) {
        Service service = null;

        String sql = "SELECT * FROM services WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                service = new Service();
                service.setId(rs.getInt("id"));
                service.setTitle(rs.getString("title"));
                service.setDescription(rs.getString("description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return service;
    }
    
    public boolean updateService(Service service) {
        boolean status = false;

        String sql = "UPDATE services SET title = ?, description = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, service.getTitle());
            ps.setString(2, service.getDescription());
            ps.setInt(3, service.getId());

            int rows = ps.executeUpdate();
            status = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}