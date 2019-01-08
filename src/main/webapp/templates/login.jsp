<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>
	<title>TICKET CENTER</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" type="text/css" th:href="@{/css/login.css}" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style type="text/css">
    body {
        color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
</style>

<body>

	<div class="container">
		<form action="/login"  method = "GET" class="form-signin" style =" margin: 0 auto; width:450px;">
			 <br/>
			 <br/>
			 <br/>
			 <h2 style="text-align:center;"><b>TICKET</b> CRUD DEMO</h2> 
			 <br/>
			 <br/>
			<input type="text" id="email" name="email" 
				class="form-control" placeholder="USERNAME"/> <br/> 
			<input type="password"  
				id="password" name="password" class="form-control"  placeholder="PASSWORD" /> <br /> 
			<button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">LOGIN</button>
			<button class="btn btn-md btn-warning btn-block" name="Submit" value="Login" type="Submit">SIGN UP</button>
		</form>
	</div>
</body>
</html>