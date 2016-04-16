package com.csdhsm.singleton;

/** 
 * @Title: Singleton1.java
 * @Package: com.csdhsm.singleton
 * @Description Singleton1 
 * @author Han
 * @date 2016-4-12 上午9:26:15 
 * @version V1.0
 */ 
  	
public class Singleton1 {
	
	/**
	 * Description set the constructor to private
	 */
	private Singleton1() {}
	
	
	/** @Fields singleton1: */
	  	
	private Singleton1 singleton1;
	
	 
	/** 
	 * @Description get the singleton1`s instance
	 * @author Han
	 * @return  
	 */
	  	
	public Singleton1 getInstance(){
		
		if(singleton1 == null){
			
			singleton1 = new Singleton1();
		}
		
		return singleton1;
	}
}
