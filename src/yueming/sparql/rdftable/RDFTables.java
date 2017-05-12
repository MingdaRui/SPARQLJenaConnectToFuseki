package yueming.sparql.rdftable;

import java.util.ArrayList;

public class RDFTables {

	int width;
	ArrayList<String> headers = null;
	ArrayList<Rows> rows = null;
	
	public RDFTables() {
		headers = new <String>ArrayList();
		rows = new <Rows>ArrayList();
	}
	
	public ArrayList<String> getHeaders() {
		return headers;
	}
	
	public ArrayList<Rows> getRows() {
		return rows;
	}
	
	public void addHeaders(String header) {
		headers.add(header);
	}
	
	public int getHeaderLength() {
		return headers.size();
	}
	
	public int getWidth() {
		return width;
	}
	
	public void addRow(Rows row) {
		rows.add(row);
	}
	
	public Rows getCurrentRow(int i) {
		return rows.get(i);
	}
	
	public void setTableWidth(int width) {
		this.width = width;
	}
	
//	public void trimRDFTable() {
//		String newString;
//		for(int i = 0; i < headers.size(); i++) {
//			headers.get(i).trim();
//		}
//	}
	
	public void printRDFTable() {
		System.out.println("Print the RDFTable");
		System.out.println("Headers:");
		for(int i = 0; i < headers.size(); i++) {
			System.out.print("1"+headers.get(i) + "2 ");
		}
		System.out.println("");
		for(int i = 0; i < rows.size(); i++) {
			System.out.println("Row " + i + ":");
			System.out.println("row length: " + rows.get(i).getLength());
			for(int j = 0; j < rows.get(i).getLength(); j++) {
				
				if(!rows.get(i).getElement(j).equals("")){
				System.out.print("1" + rows.get(i).getElement(j) + "2 ");}
			}
			System.out.println("");
		}
	}
}
