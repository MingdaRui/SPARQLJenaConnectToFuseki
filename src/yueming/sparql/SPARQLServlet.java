package yueming.sparql;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.jena.atlas.web.HttpException;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

import yueming.test.*;

@WebServlet("/SPARQLServlet")
public class SPARQLServlet extends HttpServlet {

	String serviceURI = "http://localhost:3030/fuseki/test/query";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		String firstName = request.getParameter("fn");
		
		String queryString =
				"PREFIX vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> " +
						"SELECT ?fullname " + 
						"WHERE	{" +
						"		?person vcard:FN ?fullname . " +
						"		?person vcard:N ?name . " +
						"		?name vcard:Given \"" + firstName + "\" . " + 
						"		}";
		
		System.out.println("Enter SPARQLServlet!");
		
//		QueryYuemingInfo qyi = new QueryYuemingInfo();
//		ResultSet results = qyi.getSPARQLResult(queryString);
		
		QueryExecution q = QueryExecutionFactory.sparqlService(serviceURI, queryString);
		
		// get result-set
		try{
		ResultSet results = q.execSelect();
		request.setAttribute("queryResults", results);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
		} catch(HttpException he) {
			he.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
//		try {
//			view.forward(request, response);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
