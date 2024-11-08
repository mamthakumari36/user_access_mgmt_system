package user_mgmt_system;

import javax.servlet.*;
import javax.servlet.http.*;

import util.DBConnection;

import java.io.*;
import java.sql.*;
import java.util.*;

public class PendingRequestsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Map<String, Object>> pendingRequests = new ArrayList<>();
        
        String sql = "SELECT r.id, u.username AS employee_name, s.name AS software_name, r.access_type, r.reason "
                   + "FROM requests r "
                   + "JOIN users u ON r.user_id = u.id "
                   + "JOIN software s ON r.software_id = s.id "
                   + "WHERE r.status = 'Pending'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> requestData = new HashMap<>();
                requestData.put("id", rs.getInt("id"));
                requestData.put("employee_name", rs.getString("employee_name"));
                requestData.put("software_name", rs.getString("software_name"));
                requestData.put("access_type", rs.getString("access_type"));
                requestData.put("reason", rs.getString("reason"));
                
                pendingRequests.add(requestData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pendingRequests", pendingRequests);
        
        request.getRequestDispatcher("pendingRequest.jsp").forward(request, response);
    }
}

