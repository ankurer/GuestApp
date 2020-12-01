<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

    <%@taglib prefix="botDetect" uri="https://captcha.com/java/jsp"%> 
   
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	 background-image:url('../../resources/sky.jpg');  
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
<div class="container">

		<div class=row>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">

       <!-- SUCCESS AND ERROR MESSAGE  Started-->

   

<sf:form class="form-container" method="POST" modelAttribute="form" enctype = "multipart/form-data"> 
  
  <h3 style="color: red; text-align: center; font-variant: small-caps;">
				Add Guest
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
      <sf:hidden path="createdDateTime"/> 
      

<div class="form-group" >
						<font color="white">
						<sf:label path="firstName"> 
						FirstName<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
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
								<sf:input type="text" path="lastName" class="form-control"  />
								
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
						<sf:label path="email"> 
						EmailId:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="email" class="form-control" />
								
								<c:set var="emailErrors"><sf:errors path="email"/></c:set>
								<c:if test="${not empty emailErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="email"/></font> 								
						 	
	</div>	
	
<div class="form-group" >
						<font color="white">
						<sf:label path="phoneNumber"> 
						phoneNumber:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="phoneNumber" class="form-control" />
								
								<c:set var="passwordErrors"><sf:errors path="phoneNumber"/></c:set>
								<c:if test="${not empty phoneNumberErrors}">
								
						  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="phoneNumber"/></font> 								
						 	
	</div>	

<div>
<input type = "file" name = "file" />
</div>

<br>

  <div>
<fieldset>
      <!-- <legend>Java CAPTCHA validation</legend>
      <label for="captchaCode">Retype the characters from the picture:</label>
 -->
      <!-- Adding BotDetect Captcha to the page -->
<botDetect:captcha id="exampleCaptchaTag" 
              userInputID="captchaCode"
              codeLength="3"
              imageWidth="150"
              imageStyle="GRAFFITI2" />

      <%-- <botDetect:captcha id="exampleCaptchaTag" userInputID="captchaCode" />
 --%>


      <div class="validationDiv">
        <input name="captchaCode" type="text" id="captchaCode" />
        <!-- <input type="submit" name="validateCaptchaButton" value="Validate" id="validateCaptchaButton" />
         -->
        <span class="incorrect" style="color:red">${messages.captchaIncorrect}</span>
      </div>
    </fieldset>

</div> 
 




<%-- <div>
<c:if test="${!form.captchaVerified}">
        <label for="captchaCode">Retype the characters from the picture:</label>

        <!-- Adding BotDetect Captcha to the page -->
        <botDetect:captcha id="springFormCaptcha" 
              userInputID="captchaCode"
              codeLength="3"
              imageWidth="150"
              imageStyle="GRAFFITI2" />

        <div >
          <input id="captchaCode" type="text" name="captchaCode" /><br>
          <form:errors path="captchaCode" />
        </div>
      </c:if>
</div>
 --%>
 
 <%-- <div class="form-group" >
						<font color="white">
						<sf:label path="captchaCode" > 
						captchaCode:<span style="color:red ">*</span></sf:label></font>						 	<div class="input-group">
						 		<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" id="captchaCode"  name="captchaCode" path="captchaCode" class="form-control" />
								
								<c:set var="captchaCodeErrors"><sf:errors path="captchaCode"/></c:set>
								<c:if test="${!form.captchaVerified}">
         <label for="captchaCode" class="prompt">Retype the characters from the picture:</label>
		 				
						<!-- Adding BotDetect Captcha to the page -->
         <botDetect:captcha id="springFormCaptcha" 
              userInputID="captchaCode"
              codeLength="3"
              imageWidth="150"
              imageStyle="GRAFFITI2" />		
		 				  	<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-times fg-2px" style="color: red"></i>	</span> 
	                          
							</div>
							</c:if>
						</div>
								<font color="red"><sf:errors path="captchaCode"/></font> 								
						 	
	</div> --%> 



  <c:choose>
     <c:when test="${form.id==0}">
      <button type="submit" class="btn btn-success" name="operation"  value="Save">Save</button>
	
      <button type="submit" class="btn btn-warning" name="operation"  value="Reset">Reset</button>
     </c:when>
     
    <c:otherwise>
       <button type="submit" class="btn btn-success" name="operation"  value="Update">Update</button>
	
      <button type="submit" class="btn btn-warning" name="operation"  value="Cancel">Cancel</button>
       
      
   </c:otherwise>
</c:choose>   
      
</sf:form>

        </div>
			<div class="col-md-4 col-sm-4 col-xs-12">
		 	</div>
		 	
          </div>
   </div>       
</body>
</html>