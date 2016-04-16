package com.csdhsm.concurrent;

/** 
 * @Title: EvenGenerator.java
 * @Package: com.csdhsm.concurrent
 * @Description synchronized 关键字
 * @author Han
 * @date 2016-4-9 下午8:58:42 
 * @version V1.0
 */ 
  	
public class EvenGenerator extends IntGenerator{

	private int currentEvenValue = 0;
	
	@Override
	public synchronized int next() {
		
		++currentEvenValue;//danger point in here
		++currentEvenValue;
		return currentEvenValue;
	}
	
	public static void main(String[] args) {
		
		EvenChecker.test(new EvenGenerator());
	}
}
