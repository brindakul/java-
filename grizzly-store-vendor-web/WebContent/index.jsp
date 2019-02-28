<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Grizzle Store</title>
       <link rel="stylesheet" href="style.css">
   </head>
   <body>
    <img src="images/grizzly.png"> 
    <h2>Welcome to</h2>
<h1>GRIZZLY STORE</h1>
<hr width="75%" color="#e6e6e6">
<br/>
 
        <form method="GET" action="vendorlogin">
        <div class="control-group">
               <input type="text" class="input100" name="un">
            	<label class="login-field-icon fui-user" for="login-uname"></label>
            	</div>
              
              <div class="control-group">
               <input type="password" class="login-field" name="pw" value="${pw}">
            	<label class="login-field-icon fui-lock" for="login-pass"></label>
					</div>
              	<button type="submit" value="Log in" class="btn btn-primary btn-large btn-block" >Login </button>
                                
          
      </form> 
   </body>
</html>