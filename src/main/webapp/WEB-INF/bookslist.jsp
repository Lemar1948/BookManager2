<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- <script type="text/javascript" src="./js/jquery-2.1.4.min.js"></script> -->

<script type="text/javascript">
	$(document).ready(function() {
		
		<sec:authorize url="/book/add.do">
		
		$("#addBookSubmitBtn").click(function(){
			var book = {
					title : $("#bookTitle").val(),
					description : $("#bookDescription").val()
				};
			
			$.ajax({
				url: "add.do",
				contentType: 'application/json',
				data: JSON.stringify(book),
				type: 'POST',
				success: function(data) {
					location.reload();
				},
				error: function(xhr, status, errorThrown) {
					arelt('adding book failed with status: ' + status + ". " + errorThrown);
				}
			});
			
		});
		
		</sec:authorize>
		
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of books</title>
</head>
<body>

<sec:authentication property="authorities" var="roles" scope="page" />
Your roles are:<c:forEach var="role" items="${roles}"> ${role} <br /></c:forEach>

---------------<br />
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
  <input type="submit" value="Log out" />
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
---------------<br />

<sec:authorize access="hasRole('USER')"><h3>YOU ARE USER</h3><br/></sec:authorize>
<sec:authorize access="hasRole('ADMIN')"><h3>YOU ARE ADMIN</h3><br/></sec:authorize>

<c:forEach items="${books}" var="book">
${book.id}	|	
<sec:authorize access="hasAnyRole('ADMIN', 'USER')">${book.title}</sec:authorize>	|	
<sec:authorize access="hasRole('ADMIN')">${book.description}</sec:authorize><br/>
</c:forEach>
<br />

<sec:authorize url="/book/add.do">
	<form action="" method="POST">
		<label for="bookTitle">Title:</label>
		<input type="text" name="title" id="bookTitle" class="input" /><br/>
		<label for="bookDescription">Description:</label>
		<textarea id="bookDescription" name="description" class="input"></textarea><br/>
		<input type="button" id="addBookSubmitBtn" class="button" value="Submit" />
	</form>
</sec:authorize>

</body>
</html>