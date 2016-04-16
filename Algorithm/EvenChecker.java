package com.csdhsm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Title: EvenChecker.java
 * @Package: com.csdhsm.concurrent
 * @Description 
 * @author Han
 * @date 2016-4-9 下午8:24:57 
 * @version V1.0
 */ 
  	
public class EvenChecker implements Runnable{

	private IntGenerator generator;
	@SuppressWarnings("unused")
	private final int id;
	
	public EvenChecker(IntGenerator generator, int id) {
		
		this.generator = generator;
		this.id = id;
	}
	
	@Override
	public void run() {
		
		while(!generator.isCanceled()){
			
			int val = generator.next();
			if(val % 2 != 0){
				
				System.out.println(val + " not even!");
				generator.setCanceled(true);
			}
		}
	}
	
	public static void test(IntGenerator generator, int count){
		
		ExecutorService service = Executors.newFixedThreadPool(count);
		for(int i = 0 ; i < count ; i++){
			
			service.execute(new EvenChecker(generator, i));
		}
		service.shutdown();
	}
	
	public static void test(IntGenerator generator){
		
		test(generator, 10);
	}
}
