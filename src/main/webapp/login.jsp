<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form action="login" method="post">
<input type="hidden" name="_spring_security_remember_me" value="true" />
<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
<p>
	<label for="username">Username: </label>
	<input type="text" id="username" name="username" />
</p>
<p>
	<label for="password">Password: </label>
	<input type="password" id="password" name="password" />
</p>
<p>
	<input type="submit" value="Login" />
</p>
</form>
<p style="color:red">
	<c:if test="${param.error == 'LoginRequired'}">
	You are currently logged off. Please, log in.
	</c:if>
</p>
<p style="color:red">
	<c:if test="${param.error == 'invalidLoginPassword'}">
	Invalid Login or Password.
	</c:if>
</p>
</body>
</html>