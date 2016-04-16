package com.csdhsm.concurrent;

public class SerialNumberGenerator {
	
	private static volatile int serialNumber = 0;
	
	public static synchronized int nextSerialNumber(){
		
		return serialNumber++;
	}
}
