package user_mgmt_system;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import util.DBConnection;
import java.sql.*;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String softwareName = request.getParameter("software");
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");

        try (Connection conn = DBConnection.getConnection()) {
            
            String sql = "SELECT id FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            int userId = -1;
            if (rs.next()) {
                userId = rs.getInt("id");
            }

            sql = "SELECT id FROM software WHERE name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, softwareName);
            rs = stmt.executeQuery();
            int softwareId = -1;
            if (rs.next()) {
                softwareId = rs.getInt("id");
            }

            sql = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, softwareId);
            stmt.setString(3, accessType);
            stmt.setString(4, reason);
            stmt.setString(5, "Pending");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        response.sendRedirect("requestAccess.jsp");
    }
}
