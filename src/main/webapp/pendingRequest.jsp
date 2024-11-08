<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pending Requests</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>Pending Access Requests</h2>

<table border="1">
        <thead>
            <tr>
                <th>Employee Name</th>
                <th>Software Name</th>
                <th>Access Type</th>
                <th>Reason</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Map<String, Object>> pendingRequests = (List<Map<String, Object>>) request.getAttribute("pendingRequests");

                if (pendingRequests != null && !pendingRequests.isEmpty()) {
                    for (Map<String, Object> requestData : pendingRequests) {
            %>
            <tr>
            <td><%= requestData.get("employee_name") %></td>
                <td><%= requestData.get("software_name") %></td>
                <td><%= requestData.get("access_type") %></td>
                <td><%= requestData.get("reason") %></td>
                <td>
                    <form action="ApprovalServlet" method="POST">
                        <input type="hidden" name="requestId" value="<%= requestData.get("id") %>">
                        <button type="submit" name="action" value="approve">Approve</button>
                        <button type="submit" name="action" value="reject">Reject</button>
                    </form>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No pending requests.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
