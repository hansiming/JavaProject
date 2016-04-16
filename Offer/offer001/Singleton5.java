package com.csdhsm.singleton;

/** 
 * @Title: Singleton5.java
 * @Package: com.csdhsm.singleton
 * @Description  singleton5
 * @author Han
 * @date 2016-4-12 上午9:42:55 
 * @version V1.0
 */ 
  	
public class Singleton5 {
	
	private static class SingletonHolder{
		
		static Singleton5 singleton5 = new Singleton5();
	}
	
	private Singleton5(){};
	
	public Singleton5 getInstance(){
		
		return SingletonHolder.singleton5;
	}
}
