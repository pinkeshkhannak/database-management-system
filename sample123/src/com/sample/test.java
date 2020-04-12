package com.sample;

import java.util.ArrayList;

public class test {
	
	  public static void main(String args[]) {
		  ArrayList<String> obj = new ArrayList<String>();

		  obj.add("Ajeet");
		  obj.add("Harry");
		  obj.add("Chaitanya");
		  obj.add("Steve");
		  obj.add("Anuj");
		  
		  /*Add element at the given index*/
		  obj.add(0, "Rahul");
		  obj.add(1, "Justin");

		  System.out.println("Currently the array list has following elements:"+obj);

}
}
