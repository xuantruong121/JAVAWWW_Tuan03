package iuh.fit.se.lab03jsp_mvc.dao;

import iuh.fit.se.lab03jsp_mvc.database.DBConnection;
import iuh.fit.se.lab03jsp_mvc.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void insertUser(User user) {
        String sql = "INSERT INTO users(first_name, last_name, email, password, birthday, gender) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            LocalDate localDate = LocalDate.parse(user.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            ps.setDate(5, java.sql.Date.valueOf(localDate));
            ps.setString(6, user.getGender());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT id, first_name, last_name, email, birthday, gender FROM users";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                User u = new User();
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setDateOfBirth(rs.getString("birthday"));
                u.setGender(rs.getString("gender"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
