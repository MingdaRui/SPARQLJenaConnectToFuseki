package yueming.test;

import java.io.*;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;


public class CreateTestModel {
	
	// some definitions
	static String personURI = "http://somewhere/YuemingZheng";
	static String givenName = "Yueming";
	static String familyName = "Zheng";
	static String fullName = givenName + " " + familyName;
	static String englishName = "Charlene";
	
	Model model;
	
	
	public void CreateResourceYueming() {
		
		// create an empty Model
		model = ModelFactory.createDefaultModel();
		
		//create the resource
		Resource yuemingZheng = model.createResource(personURI);
		
		// add the property
		yuemingZheng.addProperty(VCARD.FN, fullName)
					.addProperty(VCARD.N, 
								model.createResource()
									.addProperty(VCARD.Given, givenName)
									.addProperty(VCARD.Family, familyName));
		
	}
	
	
	public void WriteToRDF() {
		
		// now write the model in XML form to a file
		model.write(System.out, "RDF/XML-ABBREV");
				
		// now write the model in N-TRIPLES form to a file
//		model.write(System.out, "N-TRIPLES");
	
	}
	
	
	public void WriteToExternalRDF() throws IOException {
		
		String fileName = "yueming.test.rdf";
		File file = new File("C:\\Users\\Mingda Rui\\Desktop\\" + fileName);
		FileWriter out = new FileWriter( file );
		try {
			model.write(out, "RDF/XML-ABBREV");
		}
		finally {
			try {
				out.close();
			}
			catch (IOException closeException) {
				// ignore
			}
		}
		
	}
	
}
