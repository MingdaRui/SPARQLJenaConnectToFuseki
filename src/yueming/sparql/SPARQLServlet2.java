package yueming.sparql;

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

import yueming.test.*;

/**
 * Servlet implementation class SPARQLServlet2
 */
@WebServlet("/SPARQLServlet2")
public class SPARQLServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SPARQLServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String serviceURI = "http://localhost:3030/fuseki/test/query";
		
		String firstName = request.getParameter("fn");
		
		String queryString =
				"PREFIX vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> " +
						"SELECT ?fullname " + 
						"WHERE	{" +
						"		?person vcard:FN ?fullname . " +
						"		?person vcard:N ?name . " +
						"		?name vcard:Given \"" + firstName + "\" . " + 
						"		}";
		
		System.out.println("Enter SPARQLServlet2!");
		
		QueryYuemingInfo qyi = new QueryYuemingInfo();
		
		QueryExecution q = QueryExecutionFactory.sparqlService(serviceURI, queryString);
		
		// get result-set
		ResultSet results = q.execSelect();
		
		request.setAttribute("queryResults", results);
		
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		try {
			view.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
