<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="com.mod.Customer"%>
   <%@page import="java.util.List"%>
   <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*DROP DOWN STYLING  */
        ul {
       
            list-style: none;
           
            color:white;

        }
        
        ul li{
            display: inline-block;
            position: relative;

        }
        ul li a{
            display: block;
           background-color:black;
            color: white;
            text-decoration: none;
        }
        ul li .drop li{
            display: block;

        }
        ul li .drop{
            width: 100%;
            position: absolute;
            z-index: 999;
            display: none;
        }
         ul li a:hover{
             background:rebeccapurple;

        } 
        ul li:hover .drop{
            display: block;
        }
        a{
        text-decoration: none;
        }
        nav{
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        font-size: large;
        border: 1px solid black;
        margin: 20px;
        }
        .add{
        border: 1px solid black;
        background-color: black;
        color: white;
        padding: 5px;
        margin: 5px;
        }
        .edit{
        background-color: green;
        color: white;
        padding: 3px;
        margin: 5px;
        }
         .delete{
        background-color: red;
        color: white;
        padding: 3px;
         margin: 5px;
        }

</style>
</head>
<body>
<nav>

<a>Customer List</a>
<a href="home">Home</a>
<a href="${pageContext.request.contextPath }/">Logout</a>

</nav>
<a  class="add" href="addC">Add</a>
<ul>
<li><a href="">Select</a>
<ul class="drop">
<li><a href="Bname">First_name</a></li>
<li><a href="Bcity">city</a></li>

</ul>
</li>
</ul>
<!-- <select>
<option>Select</option>
<option><a href="byname.jsp">first_name</a></option>
<option><a href="state.jsp">state</a></option>
</select> -->
<form action="byName">
<input type="text" name="name" value="" placeholder="Enter the details">
<input type="submit" value="search">
</form>



<%
List<Customer> l=(List<Customer>)request.getAttribute("name");

%>
<table>
<tr>
<th>first_name</th>
<th>last_name</th>
<th>address</th>
<th>city</th>
<th>state</th>
<th>email</th>
<th>phone</th>
<th>Action</th>
</tr>
<%for(Customer c:l){


%>
<tr>
<th><%=c.getFirst_name() %></th>
<th><%=c.getLast_name() %></th>
<th><%=c.getAddress() %></th>
<th><%=c.getCity() %></th>
<th><%=c.getState() %></th>
<th><%=c.getEmail() %></th>
<th><%=c.getPhone()%></th>
<th><a class="edit"  href="updatedCustomer/<%= c.getId()%>">Edit</a> <a class="delete"  href="deleteCustomer/<%= c.getId()%>">Delete</a> </th>
</tr>
<%} %>

</table>


</body>
</html>