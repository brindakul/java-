
<html>
<body>
<h3>Training portal</h3>
<!-- read the favorite programming language cookie -->
<%
//the default ... if there are no cookies
String favlang="JAVA";
//get cookies from browser request
Cookie[] theCookies=request.getCookies();
//find fav lang cookie
if(theCookies!=null){
	for(Cookie tempCookie:theCookies){
		if("myApp.favoriteLanguage".equals(tempCookie.getName())) {
			favlang=tempCookie.getValue();
			break;
		}
	}
}
%>

<!--  now show a personalised page... use favlang variable -->
<!-- show new books for this lang -->
<h4>New Books for <%=favlang %></h4>
<ul>
	<li>blah<li>
	</ul>
	
<h4>New Books for <%=favlang %></h4>
<ul>
	<li>blah<li>
	</ul>
	
	<hr>
	<a href="cookies-personalize.html">Personalise this page</a>	
</body></html>