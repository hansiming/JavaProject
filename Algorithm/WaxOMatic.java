package com.csdhsm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
	
	private boolean waxOn = false;
	
	public synchronized void waxed(){
		
		waxOn = true;//Ready to buff
		notifyAll();
	}
	public synchronized void buffed(){
		
		waxOn = false;//Ready for another coat of wax
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		
		while(waxOn == false){
			
			wait();
		}
	}
	public synchronized void waitForBuffing() throws InterruptedException{
		
		while(waxOn == true){
			
			wait();
		}
	}
}

class WaxOn implements Runnable{

	private Car car;
	
	public WaxOn(Car c){ car = c;}
	
	@Override
	public void run() {
		
		try {
			while(!Thread.interrupted()){
				
				System.out.print("Wax On ! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ending Wax On task");
	}
}

class WaxOff implements Runnable{

	private Car car;
	
	public WaxOff(Car car) {
		
		this.car = car;
	}
	
	@Override
	public void run() {
		
		try {
			while(!Thread.interrupted()){
				
				car.waitForWaxing();
				System.out.print("WaxOff ! ");
				
				TimeUnit.MILLISECONDS.sleep(200);
				
				car.buffed();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Ending Wax Off task");
	}
}

public class WaxOMatic {
	
	public static void main(String[] args) throws InterruptedException {
		
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		
		TimeUnit.SECONDS.sleep(5);
		
		exec.shutdownNow();
	}
}
