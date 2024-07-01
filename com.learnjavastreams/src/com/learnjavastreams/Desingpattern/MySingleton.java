package com.learnjavastreams.Desingpattern;

public class MySingleton {
	
	static MySingleton singleton;
	
	private MySingleton() {
		
					
	}
	public static MySingleton singleobjcreation() {
		if( singleton ==null) {
			System.out.println("in the in loop");
			singleton = new MySingleton();
			return singleton;
		}
		System.out.println("object already created");
		return singleton;
			
	}

	

}
