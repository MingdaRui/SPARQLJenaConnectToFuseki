package yueming.sparql.control;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

import yueming.sparql.model.QueryByAuthor;
import yueming.sparql.model.QueryByTitle;
import yueming.sparql.model.SPARQLCommand;
import yueming.sparql.rdftable.RDFTables;
import yueming.sparql.util.RDFTableFormatter;

/**
 * Servlet implementation class SPARQLServletFactory
 */
@WebServlet("/SPARQLServletFactory")
public class SPARQLServletFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SPARQLServletFactory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String queryType = request.getParameter("queryType");
		String queryString = request.getParameter("queryString");
		System.out.println(queryType+"\n"+queryString);
		ResultSet rs = null;
		SPARQLCommand sc = null;
		
		if(queryType != null && !queryType.isEmpty()) {
			
			if(queryType.equals("foaf:title")) {sc = new QueryByTitle(request, response);}
			if(queryType.contains("foaf:author")) {sc = new QueryByAuthor(request, response);}
			
			rs = sc.DoQuery();
//			ResultSetFormatter.out(System.out, rs);
			
//			request.setAttribute("results", rs);

			
			
			String rowData = ResultSetFormatter.asText(rs);
			RDFTableFormatter rtf = new RDFTableFormatter();
			RDFTables rt = rtf.generateRDFTable(rowData);
			
			request.setAttribute("RDFTable", rt);
			
//			QuerySolution qs;
//			List<String> ls = rs.getResultVars(); 
//			Iterator<String> is = ls.iterator(); 
//			String next;
//			while(is.hasNext()) {
//				next = is.next();
//				System.out.println("title: " + next);
//				if(rs.hasNext()) {
//					qs = rs.next();
//					System.out.println(qs.get(next));
//				} else {System.out.println("result sets no next object");}
//			}
			
			
			
			try {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("SPARQLServletFactory -> title == null || empty");
		}
		
	}

}
