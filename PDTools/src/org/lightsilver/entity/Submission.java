package org.lightsilver.entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Submission {

	private ArrayList<String> lines;
	private HashMap<String, Double> features = new HashMap<String, Double>();
	public ArrayList<String> getLines() {
		return lines;
	}
	
	public Submission(String file) throws IOException
	{
		lines = new ArrayList<String>();
		FileReader reader = new FileReader(file);
	    BufferedReader br = new BufferedReader(reader); 
	    String s1 = null;
	    while((s1 = br.readLine()) != null) {   
	    	if(s1.length() > 0){
	    		//System.out.println("IN FILE" + file + ": " + s1);
	    		lines.add(s1);
	    	}
	    }
	}
	
	public void removeMulLines(ArrayList<Integer> removal)
	{
		int count = 0;
		for(int i : removal)
		{
			lines.remove(i - count);
			//count += 1;
		}
	}
	public void addFeature(String name, Double value)
	{
		features.put(name, value);
	}
}
