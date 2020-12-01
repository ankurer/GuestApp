<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#select_all').on('click', function() {
			if (this.checked) {
				$('.checkbox').each(function() {
					this.checked = true;
				});
			} else {
				$('.checkbox').each(function() {
					this.checked = false;
				});
			}
		});

		$('.checkbox').on('click', function() {
			if ($('.checkbox:checked').length == $('.checkbox').length) {
				$('#select_all').prop('checked', true);
			} else {
				$('#select_all').prop('checked', false);
			}
		});
	});

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">

</script>


<style>
body {
	background-image: url('../../resources/sky.jpg');
	background-size: 100% 100%;
	width: 100%;
	 	/* height:100vh;  */
}

.form-container {
	/* border: 1px solid grey;  */
	/* padding: 40px 40px ; */
	margin-top: 05vh;
}

.btn-success {
	width: 85px;
	/* margin-left:125px;
	width: 85px;
	position: center; */
}

.btn-warning {
	width: 95px;
}

.btn-primary {
	width: 85px;
}

/* .btn-primary{
	margin-top:20px;
	margin-left:65px;
	width: 85px;
	position: center;
}  */
.my-container {
	/* border: 5px solid green; */
	/* background-color:red  */
	
}
</style>
</head>
<body>

	<c:set value="${list}" var="total"></c:set>

	<div class="container my-container">

		<sf:form class="form-container" modelAttribute="form" method="POST">

			<h1 style="color: red; text-align: center; font-variant: small-caps;">
				BookList
			</h1>

			<c:if test="${success!=null }">
				<div class="alert alert-success alert-dismissible fade show">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Success..!</strong>${success}
				</div>
			</c:if>

			<c:if test="${error!=null }">
				<div class="alert alert-danger alert-dismissible fade show">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Error..!</strong>${error }
				</div>
			</c:if>


			<c:set value="${ ((form.pageNo-1)*pageSize)+1 }" var="index"></c:set>

			<sf:hidden path="pageNo" />
			<sf:hidden path="pageSize" />

			 <c:if test="${!empty list}">

				<div class="row">
					 <div class="col-sm-3">
						<div class="form-group">
							<font color="white"> 
							<sf:label path="firstName">
									FirstName:
									<span style="color: red">*</span>
								</sf:label></font>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope"
										aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="firstName" class="form-control"
								 />

								<c:set var="firstNameErrors">
									<sf:errors path="firstName" />
								</c:set>
								<c:if test="${not empty firstNameErrors}">

									<div class="input-group-append">
										<span class="input-group-text"><i
											class="fa fa-times fg-2px" style="color: red"></i> </span>

									</div>
								</c:if>
							</div>
							<font color="red"><sf:errors path="firstName" /></font>

						</div>
					</div> 

					<div class="col-sm-3">

						<div class="form-group">
							<font color="white"> <sf:label path="lastName">
									LastName
									<span style="color: red">*</span>
								</sf:label></font>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope"
										aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="lastName" class="form-control"
									 />

								<c:set var="lastNameErrors">
									<sf:errors path="lastName" />
								</c:set>
								<c:if test="${not empty lastNameErrors}">

									<div class="input-group-append">
										<span class="input-group-text"><i
											class="fa fa-times fg-2px" style="color: red"></i> </span>

									</div>
								</c:if>
							</div>
							<font color="red"><sf:errors path="lastName" /></font>

						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<font color="white"> <sf:label path="email">
									EmailId
									<span style="color: red">*</span>
								</sf:label></font>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-envelope"
										aria-hidden="true"></i></span>
								</div>
								<sf:input type="text" path="email" class="form-control"
									 />

								<c:set var="emailErrors">
									<sf:errors path="email" />
								</c:set>
								<c:if test="${not empty emailErrors}">

									<div class="input-group-append">
										<span class="input-group-text"><i
											class="fa fa-times fg-2px" style="color: red"></i> </span>

									</div>
								</c:if>
							</div>
							<font color="red"><sf:errors path="email" /></font>

						</div>

					</div>

					<div class="col-sm-3">

						<button type="submit" class="btn btn-success" name="operation" style="margin-top: 30px;"
							value="Search">Search</button>
						<button type="submit" class="btn btn-warning" name="operation" style="margin-top: 30px;"
							value="Reset">Reset</button>

					</div>

				</div>

 
              <br>
				<center>
					<div class="row">
						<div class="col">

							<button type="submit" class="btn btn-success" name="operation"
								value="New">New</button>
							<button type="submit" class="btn btn-danger" name="operation"
								value="Delete">Delete</button>


						</div>
					</div>
				</center>

				 <div class="table-responsive col-xs-12">     
                 <table class="table table-bordered table-striped" >
   
                    <thead  style="background-color:  #000066">
                     <tr>
							 <th style="text-align: center;color: white;"><input type="checkbox" id = "select_all" >Select All</th> 
								<th style="text-align: center; color: white;">S.NO.</th>
								<th style="text-align: center; color: white;">Name</th>
								<th style="text-align: center; color: white;">Registered Date</th>
								<th style="text-align: center; color: white;">Email</th>
								<th style="text-align: center; color: white;">PhoneNumber</th>
								<th style="text-align: center; color: white;"><i
									class="fa fa-edit"></i></th>
							 </tr>
							</thead>


							 <c:forEach items="${list}" var="book" varStatus="ct">
								 <tr>
									<td style="text-align: center; color: white"><input type="checkbox" name="chk_1" class="checkbox" >
									</td>
									<td style="text-align: center; color: white"><c:out
											value="${((form.pageNo-1)*pageSize)+ct.index+1}"></c:out> <c:set
											var="index" value="${((form.pageNo-1)*pageSize)+ct.index+1}"></c:set>

									</td>
									<td style="text-align: center; color: white">${book.firstName} ${book.lastName}</td>
									<td style="text-align: center; color: white">${book.createdDateTime}</td> 
									<td style="text-align: center; color: white">${book.email}</td>
									
									
									<td style="text-align: center; color: white">${book.phoneNumber}</td>
					             <td style="text-align: center;color: white">
	                               <c:url var="editUrl" value="/ctl/Book/AddBook?id=" />				
                       
	      <a style="color: white" href="${editUrl}${book.id}"><i class="fa fa-edit"></i></a>
	   
	   
	   <%-- <c:otherwise>
	     <a style="color: white" href="${editUrl}${user.id}" onclick="return false;"><i class="fa fa-edit" ></i></a>
	     <button class="btn btn-outline-secondary btn-block btn-round w-100" disabled><i class="fa fa-plus" aria-hidden="true"></i>Edit</button>	  
	 
       </c:otherwise> --%>
	  
	 
      </td>
							</tr>
							</c:forEach>
 						
					</table>
				</div> 

				<center>
					<div class="row">
						<div class="col">

							<c:choose>
								<c:when test="${form.pageNo==1 }">

									<input type="submit" name="operation" class="btn btn-primary"
										value="Previous" disabled>

								</c:when>
								<c:otherwise>

									<input type="submit" name="operation" class="btn btn-primary"
										value="Previous">

								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${nextlistsize!=0}">

									<input type="submit" name="operation" class="btn btn-primary"
										value="Next">

								</c:when>
								<c:otherwise>
									<input type="submit" name="operation" class="btn btn-primary"
										value="Next" disabled>

								</c:otherwise>
							</c:choose>


						</div>
					</div>
				</center>


			</c:if> 
			<c:if test="${empty list}">

				<input type="submit" name="operation" class="btn btn-primary "
					style="margin-left: 54px; margin-top: 24px;" value="Back">
				Back

			</c:if>


		</sf:form>
	</div>
<br><br>
</body>
</html>