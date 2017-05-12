package yueming.sparql.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.ResultSet;

public abstract class SPARQLCommand {

	
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	String serviceURI = "http://localhost:3030/fuseki/TCDTest-persistent/query";
	String queriedKeyWord;
	
	public SPARQLCommand(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public abstract ResultSet DoQuery();
	
}
