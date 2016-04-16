package com.csdhsm.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @Title: AttemptLocking.java
 * @Package: com.csdhsm.concurrent
 * @Description 虽然显性Lock方法比Synchronized要写得多一点，但是显性的Lock方法可以解决一些特殊的方法
 * @author Han
 * @date 2016-4-9 下午9:11:40 
 * @version V1.0
 */ 
  	
public class AttemptLocking {
	
	/**
	 * 重入锁
	 */
	private ReentrantLock lock = new ReentrantLock();
	
	public void untimed(){
		
		boolean captured = lock.tryLock();
		
		try{
			
			System.out.println("lock.tryLock()" + ":" + captured);
		}finally{
			
			if(captured){
				
				lock.unlock();
			}
		}
	}
	
	public void timed(){
		
		boolean captured = false;
		
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try{
			
			System.out.println("lock.tryLock(2, TimeUnit.SECONDS)" + captured);
		}finally{
			
			if(captured){
				
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		
		final AttemptLocking locking = new AttemptLocking();
		locking.untimed();
		locking.timed();
		
		new Thread(){
			
			public void run() {
				
				locking.lock.lock();
				System.out.println("acquired");
			};
		}.start();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.yield();
		
		locking.untimed();
		locking.timed();
	}
}
