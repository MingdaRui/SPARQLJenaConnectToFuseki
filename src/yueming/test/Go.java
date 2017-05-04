package yueming.test;

import java.io.IOException;

import yueming.test.*;

public class Go {

	
	public static void main(String args[]) throws IOException {
		
		CreateTestModel tm = new CreateTestModel();
		tm.CreateResourceYueming();
		tm.WriteToRDF();
//		tm.WriteToExternalRDF();

		
		QueryYuemingInfo qyi = new QueryYuemingInfo();
		qyi.printSPARQLResult();
//		qyi.printLocalSPARQLResult();
		
		
	}
	
}
