
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Demo JSP</title>
    </head>
<body>

<form:form action="/ninja" method="post" modelAttribute="ninja">
    <p>
    	<form:select path="dojo">
    		<c:forEach var="dojo" items="${dojos}">
    		<form:option value="${dojo.id }"><c:out value="${dojo.name }"></c:out></form:option>
    		</c:forEach>
    	</form:select>
    <p>
    <p>
        <form:label path="firstName">f name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>

    <p>
        <form:label path="lastName">l name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">age</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>
    <input type="submit" value="create ninja"/>
</form:form>    
</body>
</html>