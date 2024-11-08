package user_mgmt_system;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import util.DBConnection;

import java.sql.*;

@WebServlet("/SoftwareServlet")
public class SoftwareServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("softwareName");
        String description = request.getParameter("description");
        String[] accessLevels = request.getParameterValues("accessLevels");
//        System.out.println(name + " " + description);
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, description);
                stmt.setArray(3, conn.createArrayOf("VARCHAR", accessLevels));
                stmt.executeUpdate();
                System.out.println("Success");
            }
            response.sendRedirect("createSoftware.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("createSoftware.jsp");
        }
    }
}

