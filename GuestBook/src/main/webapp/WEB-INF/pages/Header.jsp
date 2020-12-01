<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.example.dto.UserDTO"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- Datepicker script code should be written in particular jsp files  -->

<%-- <script>
	$(function() {
		$("#datepicker1").datepicker({
			changeMonth : true,
			changeYear : true,
			yearRange : '-58:-18',
			dateFormat : 'dd-mm-yy',
		//  mindefaultDate : "01-01-1962"
		});
	});
</script> --%>

<style>
.header {
	font-size: 11px !important;
	background-color: #00001a;
	/* background-image: url('resources/navbarimage.png'); */
}
</style>
</head>
<body>

	<%-- <s:message code="label.welcomeors"/> --%>

	<!-- <nav class="navbar navbar-expand-md bg-dark navbar-dark"> -->
	<div class="container-fluid header">
		<nav class="navbar navbar-expand-md  navbar-dark">
		 <a class="navbar-brand">
		   <img src='<c:url value="../resources/sun.jpg" ></c:url>' width="90px" height="40px" >
		</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>


		<div class="collapse navbar-collapse " id="collapsibleNavbar">
			<!-- Links -->
			<ul class="navbar-nav ml-auto">

<li class="nav-item"><a class="nav-link" href='<c:url value="/Welcome"></c:url>'><i class="fa fa-home" style="font-size: 11px; color: white"></i></a></li>




				<c:choose>
					<c:when test="${not empty sessionScope.user}">

      


  <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown" style="color: white;"><i class="fa fa-user-tie"></i>User</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href='<c:url value="/ctl/User/AddUser"></c:url>'><i class="fa fa-user-plus"></i>Add User</a> 
					<a class="dropdown-item" href='<c:url value="/ctl/User/UserList"></c:url>'><i class="fa fa-list"></i>User List</a>
					
	 </div>
 </li>

	     
    

  <li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown" style="color: white;"><i class="fa fa-book-open "></i>Book</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href='<c:url value="/ctl/Book/AddBook"></c:url>'><i class="fa fa-book"></i>Add Book</a>
				<a class="dropdown-item" href='<c:url value="/ctl/Book/BookList"></c:url>'><i class="fa fa-users"></i>Book List</a> 
	</div>
 </li> 
  
  

	
	<li class="nav-item dropdown ss">
		<a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown" style="color: white">
			<i class="fa fa-user fa-lg"></i> 
			<c:if test="${not empty sessionScope.user}">
				<c:set var="name" value="${sessionScope.user.firstName}" />
				 
				<c:out value="${name}"></c:out>
			</c:if>
			 <c:if test="${empty sessionScope.user}">
				Hi Guest
			</c:if></a>

  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
	<a  class="dropdown-item" href='<c:url value="/Login"></c:url>'><i class="fa fa-sign-out-alt"> </i>Logout</a>
	</div></li>





					</c:when>

					<c:otherwise>
						<li class="nav-item dropdown ss">
						<a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown" style="color: white">
						 <i class="fa fa-user"></i>
						  <c:if test="${empty sessionScope.user}">
							Hi Guest
						</c:if>
					</a>

							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href='<c:url value="/UserRegistration"></c:url>'> 
								<i class="fa fa-user" style="font-size: 16px"></i>
								<small>User Registration</small></a>
								 <a class="dropdown-item" href='<c:url value="/Login"></c:url>'>
								  <i class="fa fa-user" style="font-size: 16px"></i><small>Login</small></a>

							</div>
						</li>

					</c:otherwise>
				</c:choose>

			</ul>


		</div>
		</nav>
	</div>

</body>
</html>


