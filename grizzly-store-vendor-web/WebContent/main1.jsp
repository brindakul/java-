<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>GRIZZLY BEAR</title>
  <meta charset="utf-8"> 
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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

<% String user = (String) session.getAttribute("un");
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("un")) userName = cookie.getValue();
		}
		}
		%>
<ul>
<li><h3>GRIZZLY <p> <img src="C:\Users\765148\Desktop\grizzly.png"></p> STORE</h3></li> 
 <li><input type="search" placeholder="Search"></li>
<li style="float:right; margin-right:100px">   WELCOME,<%out.print(user); %></li>
<li style="float:right"><a href="vendorlogout"><button type="submit" value="Log out" class="btn btn-primary btn-large btn-block" >Logout </button></a></li>
</ul>
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m2">
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
<br>

<div class="container">

  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#product">Product</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#vendor">Inventory</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="product" class="container tab-pane active"><br>
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
   <td><a href="viewproduct?name=${a.name}"><button type="submit" value="Log in" class="btn btn-primary btn-large btn-block">VIEW </button>
     <td><a href="addproduct?name=${a.id}"><button type="submit" value="Log in1" class="btn btn-primary btn-large btn-block">ADD</button></a>
 
    <td><a href="deleteproduct?name=${a.id}"><button type="submit" value="Log in1" class="btn btn-primary btn-large btn-block">REMOVE</button></a>
   </tr>
</c:forEach>

</table>
</table>
    </div>
<div id="vendor" class="container tab-pane fade"><br>
     <table>
<tr>
<th>ProductsList</th>
<th>ID</th>
<th>In Stock</th>
<th>Req</th>
<th>Buffer</th>
<th>Price/Item</th>
<th>Rating</th>
</tr>

<c:forEach items="${vend1}" var="a">

<tr>
<td>${a.name}</td>
<td>${a.id}</td>
 <td>${a.stock}</td>
   <td>${a.req}</td>
   <td>${a.buffer}</td>
   <td>${a.price}</td>
   <td>${a.rating}</td>
   <td><a href="viewproduct?name=${a.id}"><button type="submit" value="Log in" class="btn btn-primary btn-large btn-block">MANAGE</button>
   </tr>
</c:forEach>

</table>
</table>
</div>

</body>
</html>
