<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>Login - MFEC</title>

<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

function doSubmit(){
	$("#username").val('${requestScope.username}');
	$("#password").val('${requestScope.password}');
	
	//alert('username : ' + $("#username").val() + '\npassword : ' + $("#password").val());
	
	$("#mainForm").submit();
}
</script>

</head>

<body onload="doSubmit()">
		<div>
			<br/>
			<div>
				<div>
					<br/>
					<form name='loginForm' id="mainForm" action="initLoginAdmin" method="post">
						<input type="hidden" id="username" name="username" value="" />
						<input type="hidden" id="password" name="password" value="" />
					</form>
				</div>
			</div>
		</div>
</body>
</html>