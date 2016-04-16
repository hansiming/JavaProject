package com.csdhsm.singleton;

/** 
 * @Title: Singleton3.java
 * @Package: com.csdhsm.singleton
 * @Description Singleton3
 * @author Han
 * @date 2016-4-12 上午9:35:26 
 * @version V1.0
 */ 
  	
public class Singleton3 {
	/**
	 * Description set the constructor to private
	 */
	private Singleton3(){};
	
	/** @Fields singleton3: Singleton3*/
	  	
	private Singleton3 singleton3;
	
	 
	/** 
	 * @Description  get the singleton3`s instance
	 * @author Han
	 * @return  
	 */
	  	
	public Singleton3 getInstance(){
		
		//if 1
		if(singleton3 == null){
			
			synchronized(this){
				
				//if2
				if(singleton3 == null){
					
					singleton3 = new Singleton3();
				}
			}
		}
		
		return singleton3;
	}
}
