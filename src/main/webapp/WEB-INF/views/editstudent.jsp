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
        <title>Update Student</title>
    </head>
    <body>
        <h1>Update a Student</h1>
        
        <% 
            String updateUrlFINAL = request.getContextPath() + "/" + request.getAttribute("updateurl");
            session.setAttribute("updateUrlFINAL", updateUrlFINAL);
        %>
        <form:form method="POST" action="${updateUrlFINAL}" modelAttribute="student">
            <form:input type="hidden" path="id" id="id"/>
            First Name: <form:input path="firstName"  /><br />
            Last Name: <form:input path="lastName" /><br />
            Date Of Birth : <form:input path="dateOfBirth"  type="date" /><br />
            Tuition Fees : <form:input path="tuitionFees" /><br />
            <input type="submit" value="Update">
        </form:form>
        <div id="msg">${message}</div>
        <div id="list"><a href="<c:url value='/${listurl}' />">Back to the list of Students</a></div>
    </body>
</html>
