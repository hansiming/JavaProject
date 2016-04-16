package com.csdhsm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Car1{
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean waxOn = false;
	
	public void waxed(){
		
		lock.lock();
		try {
			waxOn = true;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}	
	
	public void buffed(){
		
		lock.lock();
		try {
			waxOn = false;
			condition.signalAll();
		} finally{
			lock.unlock();
		}
	}
	
	public void waitForWaxing() throws InterruptedException{
		
		lock.lock();
		
		try {
			while(waxOn == false){
				
				condition.await();
			}
		} finally {
			
			lock.lock();
		}
	}
	
	public void waitForBuffing() throws InterruptedException{
		
		lock.lock();
		
		try {
			while(waxOn == true){
				
				condition.await();
			}
		} finally {
			
			lock.lock();
		}
	}
}

class WaxOn1 implements Runnable{

	private Car1 car;
	
	public WaxOn1(Car1 c){
		
		this.car = c;
	}
	
	@Override
	public void run() {
		
		try {
			while(!Thread.interrupted()){
				
				System.out.println("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
		
		System.out.println("Ending Wax On task");
	}
}

class WaxOff1 implements Runnable{

	private Car1 car;
	
	public WaxOff1(Car1 c) {
		
		this.car = c;
	}
	
	@Override
	public void run() {
		
		try {
			while(!Thread.interrupted()){
				
				car.waitForWaxing();
				System.out.println("Wax Off！ ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}
}

public class WaxOMatic2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Car1 car1 = new Car1();
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.execute(new WaxOn1(car1));
		service.execute(new WaxOff1(car1));
		
		TimeUnit.SECONDS.sleep(5);
		
		service.shutdownNow();
	}
}
