<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<style>
body{
	 background-image:url('resources/sky.jpg');  
     background-size:100%100%;
	 width: 100%;
}
 
.form-container{

	border: 3px solid grey;
	 padding: 20px 20px ;
	  margin-top: 12vh;
	  margin-bottom: 20vh;
}

.btn-primary{
	margin-top:20px;
	/* margin-left:125px; */
	width: 85px;
	position: center;
}
</style>
</head>
<body>

<div class="container-fluid">

		<div class=row>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">


       


<!-- SUCCESS AND ERROR MESSAGE  Started-->

   

<sf:form class="form-container" method="POST" modelAttribute="form"> 
  
  <h3 style="color: red; text-align: center; font-variant: small-caps;">
				Login Page
	</h3>
	
	<div class="container">
						<!-- Success -->
				<c:if test="${success != null}">
						<div class="alert alert-success alert-dismissible fade show">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Success..!</strong> ${success}
						</div>
					</c:if>
						
						<!-- Error -->
	                   
	                   <c:if test="${error != null}">

						<div class="alert alert-danger alert-dismissible fade show">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Error..!</strong> ${error}
						</div>
					</c:if>
						
	</div>
	        	<!--END SUCCESS AND ERROR MESSAGE  -->
	
	    <sf:hidden path="uri" value="${URI}"/>
	    
<div class="form-group" >
						<font color="white">
						<sf:label path="emailId"> 
						LoginId:<span style="color:red ">*</span></sf:label></font>						 	
						<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="emailId"  class="form-control" />
								
								<c:set var="emailErrors"><sf:errors path="emailId"/></c:set>
								<c:if test="${not empty emailErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="emailId"/></font>									
						 	
	</div>

<div class="form-group" >
						<font color="white">
						<sf:label path="password"> 
						Password:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-lock" aria-hidden="true"></i></span>
								</div>
								<sf:input type="password" path="password" class="form-control"  />
								
								<c:set var="passwordErrors"><sf:errors path="password"/></c:set>
								<c:if test="${not empty passwordErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="password"/></font> 								
						 	
	</div>

   
                  <center>
					<button type="submit" class="btn btn-primary" name="operation"  value="SignIn">Login</button>
					</center>
  
             <br>
             
		       
  
  		 </sf:form>       	
		        	</div>
			<div class="col-md-4 col-sm-4 col-xs-12">
		 	</div>
		 	
          </div>


</body>
</html>