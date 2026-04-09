package com.hrconsultancy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.hrconsultancy.model.Contact;
import com.hrconsultancy.util.DBConnection;
import com.hrconsultancy.model.ContactMessage;

public class ContactDAO {

    public boolean saveContact(Contact contact)
    {
        String query = "INSERT INTO contact_messages (name, email, message) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query))
        {

            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getMessage());

            return ps.executeUpdate() > 0;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }
    
    public List<ContactMessage> getAllMessages() {
        List<ContactMessage> messages = new ArrayList<>();

        String query = "SELECT * FROM contact_messages ORDER BY created_at DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ContactMessage message = new ContactMessage();

                message.setId(rs.getInt("id"));
                message.setName(rs.getString("name"));
                message.setEmail(rs.getString("email"));
                message.setMessage(rs.getString("message"));
                message.setCreatedAt(rs.getTimestamp("created_at"));

                messages.add(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return messages;
    }
    
    public int getMessageCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM contact_messages";

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