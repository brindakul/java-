<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="style.css">
 <style>

table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
} 

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}

 ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #E0E0E0;
  
} 
li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
} 
div1{
	 background-color: lightgrey;
  width: 300px;
  
  padding: 25px;
  margin: 25px;
}
</style>
</head>
<body>
<% String un=request.getParameter("un");%>

<ul>
<li><h3>GRIZZLY STORE</h3></li> 
 <li><input type="search" placeholder="Search"></li>
<li style="float:right; margin-right:100px">   WELCOME,<%out.print(un); %></li>
<li style="float:right"><a href="/grizzly-store-admin-web/index.html">LOGOUT</a></li>
</ul>
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center">Profile</h4>
         <p class="w3-center"><img src="/w3images/avatar3.png" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
         <hr>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i>CONTACT</p>
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i>ADDRESS</p>
        </div>
      </div>
      <br>
      </div>
      <div class="w3-col m8">
    
      <div class="w3-row-padding">
        <div class="w3-col m12">
                    <div class="w3-card w3-round w3-white">
          
            <div class="w3-container w3-padding">
           <button type="button" class="w3-button w3-theme">Product</button>
            <button type="button" class="w3-button w3-theme">Vendor</button> 
            </div>
            </div>
            </div>
            </div>
<table>
<tr>
<th>ProductsList</th>
<th>ID</th>
<th>Brand</th>
<th>Category</th>
<th>Rating</th>
</tr>

<c:forEach items="${prods}" var="a">
<tr>
<td>${a.name}</td>
<td>${a.id}</td>
 <td>${a.brand}</td>
   <td>${a.category}</td>
   <td>${a.rating}</td>
   <td><a href="viewproduct?name=${a.name}"><button type="submit" value="Log in" class="btn btn-primary btn-large btn-block" >VIEW </button>
     <td><a href="deleteproduct?name=${a.name}"><button type="submit" value="Log in1" class="btn btn-primary btn-large btn-block" >ADD</button></a>
 
    <td><a href="deleteproduct?name=${a.name}"><button type="submit" value="Log in1" class="btn btn-primary btn-large btn-block" >REMOVE</button></a>
   </tr>
</c:forEach>

</table>
      
</body>
</html>