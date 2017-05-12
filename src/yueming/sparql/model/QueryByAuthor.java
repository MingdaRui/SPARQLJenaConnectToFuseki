package yueming.sparql.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;

public class QueryByAuthor extends SPARQLCommand{

	String queryString;
	
	public QueryByAuthor(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		queriedKeyWord = request.getParameter("queryString");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultSet DoQuery() {
		
		queryString =
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
				"PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
				"SELECT ?rdf_Description ?rdfs_seeAlso ?rdfs_DOI ?rdfs_availability ?rdfs_collections ?rdfs_isDefinedBy ?rdfs_seriesORreportNO ?foaf_author ?foaf_title " + 
				"WHERE	{" +
//				"		?rdfsDescription rdfs:about ?rdfs_about . " +
				"		?rdf_Description rdfs:seeAlso ?rdfs_seeAlso . " +
				"		?rdf_Description rdfs:DOI ?rdfs_DOI . " +
				"		?rdf_Description rdfs:availability ?rdfs_availability . " +
				"		?rdf_Description rdfs:collections ?rdfs_collections . " +
				"		?rdf_Description rdfs:isDefinedBy ?rdfs_isDefinedBy . " +
				"		?rdf_Description rdfs:seriesORreportNO ?rdfs_seriesORreportNO . " +
				"		?rdf_Description foaf:author \"" + queriedKeyWord + "\" . " +
				"		?rdf_Description foaf:author ?foaf_author . " +
				"		?rdf_Description foaf:title ?foaf_title . " +
				"		}";
		
		QueryExecution q = QueryExecutionFactory.sparqlService(this.serviceURI, queryString);
		
		// get result-set
		ResultSet results = q.execSelect();
		
		// TODO Auto-generated method stub
		return results;
	}

}
