package user_mgmt_system;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import util.DBConnection;

import java.sql.*;
import java.util.*;

public class SoftwareDetails extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, Object>> softwareList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, name FROM software";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Map<String, Object> software = new HashMap<>();
                    software.put("id", rs.getInt("id"));
                    software.put("name", rs.getString("name"));
                    softwareList.add(software);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("softwareList", softwareList);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("requestAccess.jsp");
        dispatcher.forward(request, response);
    }
}

