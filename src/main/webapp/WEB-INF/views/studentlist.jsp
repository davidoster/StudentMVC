<%-- 
    Document   : studentlist
    Created on : 07-May-2020, 13:37:33
    Author     : mac
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students' List</title>
    </head>
    <body>
        <h1>Students' List</h1>
        <table>
		<tr>
                    <td>ID</td><td>FIRST NAME</td><td>LAST NAME</td><td>DATE OF BIRTH</td><td>TUITION FEES</td><td></td>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
                            <!-- edit: http://localhost:8081/edit/{id} -->
                            <td><a href="<c:url value='${editurl}/${student.id}' />">${student.id}</a></td>
                            <td>${student.firstName}</td>
                            <td>${student.lastName}</td>
                            <td>${student.dateOfBirth}</td>
                            <td>${student.tuitionFees}</td>
                            <td><a href="<c:url value='${deleteurl}/${student.id}' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
        <div id="msg">${msg}</div>
    </body>
</html>
