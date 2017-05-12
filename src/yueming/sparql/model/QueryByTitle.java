package yueming.sparql.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;

public class QueryByTitle extends SPARQLCommand {

	String queryString;
	
	public QueryByTitle(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		queriedKeyWord = request.getParameter("queryString");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultSet DoQuery() {
		
		queryString =
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
				"PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
				"SELECT ?rdfs_DOI ?rdfs_availability ?rdfs_collections ?rdfs_isDefinedBy ?rdfs_seriesORreportNO ?foaf_author " + 
				"WHERE	{" +
				"		?rdfsDescription rdfs:DOI ?rdfs_DOI . " +
				"		?rdfsDescription rdfs:availability ?rdfs_availability . " +
				"		?rdfsDescription rdfs:collections ?rdfs_collections . " +
				"		?rdfsDescription rdfs:isDefinedBy ?rdfs_isDefinedBy . " +
				"		?rdfsDescription rdfs:seriesORreportNO ?rdfs_seriesORreportNO . " +
				"		?rdfsDescription foaf:author ?foaf_author . " +
				"		?rdfsDescription foaf:title \"" + queriedKeyWord + "\" . " +
				"		}";
		
		QueryExecution q = QueryExecutionFactory.sparqlService(this.serviceURI, queryString);
		
		// get result-set
		ResultSet results = q.execSelect();
		
		return results;
		// TODO Auto-generated method stub
		
	}

}
