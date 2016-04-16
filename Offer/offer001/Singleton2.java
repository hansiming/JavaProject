package com.csdhsm.singleton;

/** 
 * @Title: Singleton2.java
 * @Package: com.csdhsm.singleton
 * @Description Singleton2
 * @author Han
 * @date 2016-4-12 上午9:30:24 
 * @version V1.0
 */ 
  	
public class Singleton2 {
	
	/**
	 * Description set the constructor to private
	 */
	private Singleton2(){}
	
	
	/** @Fields singleton2: Singleton2*/
	  	
	private Singleton2 singleton2;
	
	 
	/** 
	 * @Description get the singleton2`s instance
	 * @author Han
	 * @return  
	 */
	  	
	public Singleton2 getInstance(){
		
		//add synchronized to avoid creating the instance simultaneously
		synchronized(this){
			
			if(singleton2 == null){
				
				singleton2 = new Singleton2();
			}
		}
		
		return singleton2;
	}
}
