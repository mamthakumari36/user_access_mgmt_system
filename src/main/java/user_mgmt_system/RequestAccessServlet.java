package user_mgmt_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnection;

public class RequestAccessServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
