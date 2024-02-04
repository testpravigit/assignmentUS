<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add page</h1>
<form action="addCustomer">
<label>fname</label>
<input type="text" name="first_name" value=""></br>
<label>lname</label>
<input type="text" name="last_name" value=""></br>
<label>address</label>
<input type="text" name="address" value=""></br>
<label>city</label>
<input type="text" name="city" value=""></br>
<label>state</label>
<input type="text" name="state" value=""></br>
<label>mail</label>
<input type="email" name="email" value=""></br>
<label>phone</label>
<input type="text" name="phone" value=""></br>

<input type="submit" value="add">
</form>

</body>
</html>