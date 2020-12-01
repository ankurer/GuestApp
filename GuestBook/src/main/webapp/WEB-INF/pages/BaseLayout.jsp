<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width, initial-scale=1" />



<!-- 
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
-->

<style>
/* .error {
    color: red;
    font-weight: bold;
}

.success {
    color: green;
    font-weight: bold;
} */
@media only screen and (max-width: 960px) {
  .col-xs-12 {
    display: flex;
    flex-direction: column-reverse;
  }
</style>


</head>
<body>
   
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	
	<tiles:insertAttribute name="menu"></tiles:insertAttribute>
    
	<div class="container">

		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
	
</body>
</html>