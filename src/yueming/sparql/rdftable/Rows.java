package yueming.sparql.rdftable;

import java.util.ArrayList;

public class Rows {

	int length;
	ArrayList<String> elements = null;
	
	public Rows() {
		length = 0;
		elements = new <String>ArrayList();
	}
	
	public void addElements(String element) {
		elements.add(element);
	}
	
	public int getLength() {
		if(length == 0) {
			length = elements.size();
		}
		return length;
	}
	
	public String getElement(int j) {
		return (String)elements.get(j);
	}
	
}
