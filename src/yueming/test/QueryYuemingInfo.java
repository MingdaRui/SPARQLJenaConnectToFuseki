package yueming.test;

import java.io.*;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

public class QueryYuemingInfo {

	String serviceURI = "http://localhost:3030/fuseki/test/query";
	String dbpedia = "http://dbpedia.org/sparql";
	
	String firstName = "Yueming";
	
	String queryString =
			"PREFIX vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> " +
			"SELECT ?fullname " + 
			"WHERE	{" +
			"		?person vcard:FN ?fullname . " +
			"		?person vcard:N ?name . " +
			"		?name vcard:Given \"Yueming\" . " + 
			"		?name vcard:Family \"Zheng\" . " + 
			"		}";
	
	String queryFirstName =
			"PREFIX vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> " +
			"SELECT ?fullname " + 
			"WHERE	{" +
			"		?person vcard:FN ?fullname . " +
			"		?person vcard:N ?name . " +
			"		?name vcard:Given \"" + firstName + "\" . " + 
			"		}";
	
	String queryAllString =
			"PREFIX vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> " +
			"SELECT ?s ?p ?o " + 
			"WHERE	{" +
			"		?s ?p ?o" +
			"		}";
	
	public void printSPARQLResult() {
		
		
		
		QueryExecution q = QueryExecutionFactory.sparqlService(this.serviceURI, queryFirstName);
		
		// get result-set
		ResultSet results = q.execSelect();
		
		// print results
		ResultSetFormatter.out(System.out, results);
		
	}
	
	
	public ResultSet getSPARQLResult(String queryString) {
		QueryExecution q = QueryExecutionFactory.sparqlService(this.serviceURI, queryString);
		
		// get result-set
		ResultSet results = q.execSelect();
		
		return results;
		
	}
	
	
	public void printLocalSPARQLResult() throws IOException {
		
		InputStream in = new FileInputStream(new File("C:\\Users\\Mingda Rui\\Desktop\\yueming.test.rdf"));
		
		Model model = ModelFactory.createDefaultModel();
		model.read(in, null);
		in.close();
		
		Query query = QueryFactory.create(queryString);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		
		// Output query results
		ResultSetFormatter.out(System.out, results, query);
		
		// Important - free up resources used running the query
		qe.close();
		
	}
	
}















