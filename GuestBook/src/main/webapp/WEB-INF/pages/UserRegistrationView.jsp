<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserRegistration</title>
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
				UserRegistration
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


      <sf:hidden path="id"/> 
      
<div class="form-group" >
						<font color="white">
						<sf:label path="firstName"> 
						FirstName:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="firstName" class="form-control" />
								
								<c:set var="firstNameErrors"><sf:errors path="firstName"/></c:set>
								<c:if test="${not empty firstNameErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="firstName"/></font> 								
						 	
	</div>

<div class="form-group" >
						<font color="white">
						<sf:label path="lastName"> 
						LastName:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="lastName" class="form-control" />
								
								<c:set var="lastNameErrors"><sf:errors path="lastName"/></c:set>
								<c:if test="${not empty lastNameErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="lastName"/></font> 								
						 	
	</div>
	
 <div class="form-group" >
						<font color="white">
						<sf:label path="login"> 
						EmailId:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="login" class="form-control"  />
								
								<c:set var="emailErrors"><sf:errors path="login"/></c:set>
								<c:if test="${not empty emailErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="login"/></font> 								
						 	
	</div>	
	
<div class="form-group" >
						<font color="white">
						<sf:label path="password"> 
						Password:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="password" path="password" class="form-control" />
								
								<c:set var="passwordErrors"><sf:errors path="password"/></c:set>
								<c:if test="${not empty passwordErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="password"/></font> 								
						 	
	</div>	

<div class="form-group" >
						<font color="white">
						<sf:label path="confirmPassword"> 
						Confirmpassword:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="password" path="confirmPassword"  class="form-control"/>
								
								<c:set var="confirmPasswordErrors"><sf:errors path="confirmPassword"/></c:set>
								<c:if test="${not empty confirmPasswordErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="confirmPassword"/></font> 								
						 	
	</div>	

<div class="form-group" >
						<font color="white">
						<sf:label path="address"> 
						Address:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="address"  class="form-control" placeholder="${enteraddress}" />
								
								<c:set var="addressErrors"><sf:errors path="address"/></c:set>
								<c:if test="${not empty addressErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="address"/></font> 								
						 	
	</div>	

 
<div class="form-group" >
						<font color="white">
						<sf:label path="dob"> 
						Dob:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								 <sf:input  readonly="readonly" path="dob" id="dob1" class="form-control" autocomplete="off"  />
								 
								<%-- <sf:input readonly="readonly" path="dob" class="form-control datetimepicker"
					placeholder="${enterdob}" autocomplete="off" />
					 --%>
								<c:set var="dobErrors"><sf:errors path="dob"/></c:set>
								<c:if test="${not empty dobErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="dob"/></font> 								
						 	
	</div>	

  	
  	
	<button type="submit" class="btn btn-success" name="operation"  value="SignUp">Signup</button>
	
   <button type="submit" class="btn btn-warning" name="operation"  value="Reset">Reset</button>
   
   <script>
    $(function() {
        $("#dob1").datepicker({
        	changeMonth : true,
			changeYear : true,
			yearRange : '-58:-18'
        });
    });
    </script>
   
   
   
   <%-- <script type="text/javascript">
					$('.datetimepicker').datetimepicker({
						format : 'MM/DD/YYYY',
						maxDate : moment().add(-18, 'years'),
					});
					$('.datetimepicker').datetimepicker().val('${form.dob}');
				</script>
 --%>
 
</sf:form>
   
           </div>
			<div class="col-md-4 col-sm-4 col-xs-12">
		 	</div>
		 	
          </div>
<!-- </div> -->

</body>
</html>