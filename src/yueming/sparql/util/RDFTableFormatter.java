package yueming.sparql.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import yueming.sparql.rdftable.RDFTables;
import yueming.sparql.rdftable.Rows;

public class RDFTableFormatter {

	String rowData;
	RDFTables rt = new RDFTables();
	
	public RDFTables generateRDFTable(String rowData){
		
		this.rowData = rowData;
		
		System.out.println("rowData: \n" + rowData);
		
		String[] parts = rowData.split("\\|");
		for(int i =0; i < 10; i++) {
			System.out.println(parts[i] + ",");
		}
		
		List<String> ls = Arrays.asList(parts);
		Iterator<String> is = ls.iterator();
		String next;
		
		while(is.hasNext()) {
			next = (String)is.next().trim();
			if( next.contains("===") ) {break;}
			if( !next.startsWith("---") ) {
				rt.addHeaders(next);
			}
		}
		
		int width = rt.getHeaderLength();
		rt.setTableWidth(width);
		
		
		int i = 0;
		int j = 0;
		rt.addRow(new Rows());
		Rows currentRow = rt.getCurrentRow(j);
		
		while(is.hasNext()) {
			
			next = (String)is.next().trim();
			if(!next.equals("") && !next.contains("---")) {
				System.out.println("1"+next+"2");
				if(i >= width) {
					j++;
					rt.addRow(new Rows());
					currentRow = rt.getCurrentRow(j);
					i = 0;
				}
				currentRow.addElements(next);
				i++;
			}
			
		}
		
		rt.printRDFTable();
		
//		String[] parts = rowData.split("- | ", 2);
//		System.out.println("Parts 0: \n" + parts[0]);
//		System.out.println("Parts 1: \n" + parts[1]);
//		
//		String[] headers = parts[1].split(" | =", 2);
//		System.out.println("headers 0:" + headers[0]);
//		System.out.println("headers 1:" + headers[1]);
		
		return rt;
		
	}
	
}
