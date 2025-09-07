<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2025
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="iuh.fit.se.lab03jsp_form.model.Student, iuh.fit.se.lab03jsp_form.model.Qualification, java.util.*" %>
<jsp:useBean id="student" class="iuh.fit.se.lab03jsp_form.model.Student" scope="request"/>
<html>
<head>
    <title>Kết quả Đăng ký</title>
    <style>
        body {
            background-color: #f1f8e9;
            font-family: Arial;
        }

        table {
            border-collapse: collapse;
            width: 70%;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid black;
            padding: 5px;
        }

        th {
            background-color: #aed581;
        }
    </style>
</head>
<body>
<h2>Thông tin Sinh viên Đã Đăng ký</h2>

<p><b>First Name:</b>
    <jsp:getProperty name="student" property="firstName"/>
</p>
<p><b>Last Name:</b>
    <jsp:getProperty name="student" property="lastName"/>
</p>
<p><b>Date of Birth:</b>
    <jsp:getProperty name="student" property="dateOfBirth"/>
</p>
<p><b>Email:</b>
    <jsp:getProperty name="student" property="email"/>
</p>
<p><b>Mobile Number:</b>
    <jsp:getProperty name="student" property="mobileNumber"/>
</p>
<p><b>Gender:</b>
    <jsp:getProperty name="student" property="gender"/>
</p>
<p><b>Address:</b>
    <jsp:getProperty name="student" property="address"/>
</p>
<p><b>City:</b>
    <jsp:getProperty name="student" property="city"/>
</p>
<p><b>Pin Code:</b>
    <jsp:getProperty name="student" property="pinCode"/>
</p>
<p><b>State:</b>
    <jsp:getProperty name="student" property="state"/>
</p>
<p><b>Country:</b>
    <jsp:getProperty name="student" property="country"/>
</p>

<h3>Hobbies:</h3>
<ul>
    <%
        List<String> hobbies = student.getHobbies();
        if (hobbies != null) {
            for (String h : hobbies) {
    %>
    <li><%= h %>
    </li>
    <%
            }
        }
    %>
</ul>

<h3>Qualification:</h3>
<table>
    <tr>
        <th>Examination</th>
        <th>Board</th>
        <th>Percentage</th>
        <th>Year of Passing</th>
    </tr>
    <%
        List<Qualification> quals = student.getQualifications();
        if (quals != null) {
            for (Qualification q : quals) {
    %>
    <tr>
        <td><%= q.getExamination() %>
        </td>
        <td><%= q.getBoard() %>
        </td>
        <td><%= q.getPercentage() %>
        </td>
        <td><%= q.getYearOfPassing() %>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<p><b>Course Applied For:</b>
    <jsp:getProperty name="student" property="courseAppliedFor"/>
</p>
</body>
</html>


