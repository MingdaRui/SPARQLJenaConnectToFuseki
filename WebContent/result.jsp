<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="org.apache.jena.query.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Here</title>
</head>
<body>

<%ResultSet results = (ResultSet) request.getAttribute("results"); %>
<% QuerySolution qs; %>
<%while(results.hasNext()){
	qs = results.next();%>
	<%=qs.get("fullname") %>
	<%}%>


</body>
</html>
