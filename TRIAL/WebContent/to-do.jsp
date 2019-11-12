<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Step 1:create HTML form--> 
<form action="to-do.jsp">
Add new item: <input type="text" name="theItem"/>

<input type="submit" value="submit"/>
</form>
<br>
<!--  add new item to To do list -->
<% 
// get to do items from session
List<String> items=(List<String>) session.getAttribute("mytodolist");
// if to do items doesn't exist, then create new one
 if(items==null) {
	 items= new ArrayList<String>();
	 session.setAttribute("mytodolist",items);
 }
//see if there is form data to add
String theItem=request.getParameter("theItem");
if((theItem!=null)&&(!theItem.trim().equals(""))){
	items.add(theItem);
	response.sendRedirect("to-do.jsp"); 
}
%>
<!-- Display all to do item from session -->
<hr>
<b>to do items:</b> <br/>
<ol>
<% 
	for(String temp:items){
		out.println("<li>"+temp+"</li>");
	}
%>
</ol>
</body>
</html>