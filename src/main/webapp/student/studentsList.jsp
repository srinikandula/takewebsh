<%@ page import="com.web.model.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: skandula
  Date: 3/31/16
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border ="2" style="width: 25%">

 <%-- <tbody>
    <%
      List<Student> students = (List<Student>) request.getAttribute("students");%>
      for(Student student:students) {
        out.print("<tr><td>"+student.getStudentId()+"</td><td>"+student.getFirstName()+"</td><td>"+student.getLastName()+"</td>");
        out.print("/<td><a href='loadStudent?id="+student.getStudentId()+"'>Update</a></td>");
        out.print("<td><a href='deleteStudent?id="+student.getStudentId()+"'>Delete</a></td></tr>");
      }--%>

  <tbody>
    <c:forEach items="${students}" var="st">
    <tr>
      <td><c:out value=" ${st.studentId}"/></td>
      <td><c:out value=" ${st.firstName}"/></td>
      <td><c:out value="${st.lastName}"/></td>

        <td><button onclick="updateAccount(<c:out value='${st.studentId}'/>)">Update</button> </td>
        <td><button onclick="deleteAccount(<c:out value='${st.studentId}'/>)">Delete</button> </td>
    </tr>
    </c:forEach>
  </tbody>
</table>



</body>
</html>
