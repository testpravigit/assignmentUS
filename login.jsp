<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input{
padding: 5px;
margin: 5px;


}
form{
position: relative;
left: 400px;
}
</style>
</head>
<body>


<form action="loginHandler">
<h1>Login page</h1>
<table>
<tr>
<td><label>UserName</label></td>
<td><input type="text" name="uname" value=""></td>
</tr>
<tr>
<td><label>Password</label></td>
<td><input type="text" name="password" value=""></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login"></td>
</tr>

</table>

</form>

</body>
</html>