
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
</head>
<body>

  
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

<jsp:include page="main.jsp"></jsp:include>
<form action="addproduct" method="GET">
 <div class="w3-col m7">
    
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
            <div class="w3-col m12">
            <div class="w3-container w3-card w3-white w3-round w3-margin"><br>
             <input type="text" name="id" placeholder="Enter Product ID"><br>
              <select name="Category" placeholder="Category">
					<option value="xyz">XYZ</option>
				</select><br>
				<input type="text" name="name"placeholder="Name"><br>
             <input type="text" name="description"placeholder="Description"><br>
<input type="text" name="price"placeholder="Price"><br>
<input type="submit" name="Add" value="Add"><br>
<input type="reset" name="Add" value="Cancel">
            </div>      
      </form>
</body>
</html>