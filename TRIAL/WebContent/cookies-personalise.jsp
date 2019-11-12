<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<%
//read form data
String favlang=request.getParameter("favoriteLanguage");
 
//create cookie
Cookie theCookie = new Cookie("myApp.favoriteLangauage",favlang);

//set the life span 
theCookie.setMaxAge(60*60*24*365);

//send cookie to browser
response.addCookie(theCookie);


%>
<body>
Thanks! we set our favorite language to:${param.favoriteLanguage}
</br></br>
<a href="cookies-homapage.jsp">Return to homepage</a>

 }
</body>
</html>