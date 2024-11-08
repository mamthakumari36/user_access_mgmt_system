package user_mgmt_system;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import util.DBConnection;

import java.sql.*;

@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String action = request.getParameter("action");  // 'approve' or 'reject'

        String status = action.equals("approve") ? "Approved" : "Rejected";

        try (Connection conn = DBConnection.getConnection()) {
            String query = "UPDATE requests SET status = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, status);
                stmt.setInt(2, requestId);
                stmt.executeUpdate();
            }
            response.sendRedirect("pendingRequest.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("pendingRequest.jsp");
        }
       
    }
}

