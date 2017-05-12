package yueming.sparql.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

/**
 * Servlet implementation class SPARQLServletTest3
 */
@WebServlet("/SPARQLServletTest")
public class SPARQLServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String serviceURI = "http://localhost:3030/fuseki/test/query";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SPARQLServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String firstName = request.getParameter("fn");
		String queryString =
				"PREFIX vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> " +
						"SELECT ?fullname " + 
						"WHERE	{" +
						"		?person vcard:FN ?fullname . " +
						"		?person vcard:N ?name . " +
						"		?name vcard:Given \"" + firstName + "\" . " + 
						"		}";
		
		System.out.println("Enter SPARQLServletTest!");
		
		QueryExecution q = QueryExecutionFactory.sparqlService(this.serviceURI, queryString);
		ResultSet results = q.execSelect();

//		ResultSetFormatter.out(System.out, results);
		
		request.setAttribute("results", results);
		
		try {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
