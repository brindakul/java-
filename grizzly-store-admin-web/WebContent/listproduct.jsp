<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grizzly Store</title>
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
</style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>

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
<th>Brand</th>
<th>Category</th>
<th>Rating</th>
</tr>

<c:forEach items="${prods}" var="a">
<tr>
<td>${a.name}</td>

 <td>${a.brand}</td>
   <td>${a.category}</td>
   <td>${a.rating}</td>
   <td><a href="viewproduct?name=${a.name}"><button type="submit" value="Log in" class="btn btn-primary btn-large btn-block" >VIEW </button>
 
    <td><a href="deleteproduct?name=${a.name}"><button type="submit" value="Log in1" class="btn btn-primary btn-large btn-block" >REMOVE</button></a>
   </tr>
</c:forEach>

</table>



</body>
</html>