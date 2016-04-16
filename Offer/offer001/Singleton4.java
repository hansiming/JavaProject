package com.csdhsm.singleton;

/** 
 * @Title: Singleton4.java
 * @Package: com.csdhsm.singleton
 * @Description singleton4
 * @author Han
 * @date 2016-4-12 上午9:43:26 
 * @version V1.0
 */ 
  	
public class Singleton4 {
	
	private Singleton4(){};
	
	
	/** @Fields singleton4: instance in there*/
	  	
	private static Singleton4 singleton4 = new Singleton4();
	
	 
	/** 
	 * @Description  get the singleton4`s instance
	 * @author Han
	 * @return  
	 */
	  	
	public Singleton4 getInstance(){
		
		return singleton4;
	}
}
