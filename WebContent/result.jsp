<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="org.apache.jena.query.*"
    import="java.util.*"
    import="yueming.sparql.rdftable.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Here</title>
</head>
<body>
<h1>Result Page</h1>

<%RDFTables rt = (RDFTables) request.getAttribute("RDFTable"); %>



<%="Print the RDFTable" %><br>

<table border="1">
<tr>
<%for(int i = 0; i < rt.getHeaders().size(); i++) {  %>
	<th>
	<%=rt.getHeaders().get(i)%>
	</th>
<%} %>
</tr>

<%String replace; %>
<%for(int i = 0; i < rt.getRows().size(); i++) { %>
	<!-- Row <%=i %>:<br>
	row length: <%=rt.getRows().get(i).getLength()%> <br> -->
	<tr>
	<%for(int j = 0; j < rt.getRows().get(i).getLength(); j++) { %>
		<td>
		<%if(!rt.getRows().get(i).getElement(j).equals("")){ %>
			
			<%if( rt.getRows().get(i).getElement(j).startsWith("<") ) { %>
				<%replace = rt.getRows().get(i).getElement(j).replaceAll("<", "&#60;").replaceAll(">", "&#62;"); %>
				<%=replace %>
			<%} else {%>
				<%=rt.getRows().get(i).getElement(j) %>
			<%} %>
			<%System.out.println(rt.getRows().get(i).getElement(j).toString()); %>
		<%} %>
		</td>
	<%} %>
	</tr>
<%} %>

</table>


</body>
</html>
