<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.mod.Customer"%>
     <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>update page</h1>
<% 
Customer c=(Customer)request.getAttribute("cus");

%>
<form action="${pageContext.request.contextPath }/up">

<label>fname</label>
<input type="text" name="first_name" value="<%=c.getFirst_name()%>"></br>
<label>lname</label>
<input type="text" name="last_name" value="<%=c.getLast_name()%>"></br>
<label>address</label>
<input type="text" name="address" value="<%=c.getAddress()%>"></br>
<label>city</label>
<input type="text" name="city" value="<%=c.getCity()%>"></br>
<label>state</label>
<input type="text" name="state" value="<%=c.getState()%>"></br>
<label>mail</label>
<input type="email" name="email" value="<%=c.getEmail()%>"></br>
<label>phone</label>
<input type="text" name="phone" value="<%=c.getPhone()%>"></br>
<input type="hidden" name="id" value="<%=c.getId()%>"></br>
<input type="submit" value="update">
</form>

</body>
</html>