<%-- 
    Document   : newstudent
    Created on : 07-May-2020, 16:45:23
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
        <h1>Register a new Student</h1>
        <form:form method="POST" action="newstudent" modelAttribute="student">
            <form:input type="hidden" path="id" id="id"/>
            First Name: <form:input path="firstName" /><br />
            Last Name: <form:input path="lastName" /><br />
            Date Of Birth : <form:input path="dateOfBirth" type="datetime-local" /><br />
            Tuition Fees : <form:input path="tuitionFees" /><br />
            <input type="submit">
        </form:form>
    </body>
</html>
