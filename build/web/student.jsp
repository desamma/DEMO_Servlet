<%-- 
    Document   : student
    Created on : 20 May 2024, 15:16:03
    Author     : lethimcook
--%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="Model.Student" %>

<%
//    hmu hmu
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    List<Student> students = (List<Student>) request.getAttribute("students");
    Integer numStudents = (Integer) request.getAttribute("numStudents");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    <form action="StudentServlet" method="get">
        Number of Students: <input type="text" name="numStudents" value="<%= numStudents %>" />
        <input type="submit" value="Generate" />
    </form>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>DOB</th>
        </tr>
        <% if (students != null) {
               for (Student student : students) { %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><input type="checkbox" <%= student.isGender() ? "checked" : "" %> disabled/></td>
            <td><%= sdf.format(student.getDob()) %></td>
        </tr>
        <%     }
             }
        %>
    </table>
</body>
</html>