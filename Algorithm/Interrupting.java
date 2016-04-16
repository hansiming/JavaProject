package com.csdhsm.concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable{

	@Override
	public void run() {
		
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException With SleepBlocked");
		}
		
		System.out.println("Exiting SleepBlocked.run()");
	}
}

class IOBlocked implements Runnable{

	private InputStream in;
	
	public IOBlocked(InputStream is) {
		
		in = is;
	}
	
	@Override
	public void run() {
		
		try {
			System.out.println("Waiting for read():");
			in.read();
		} catch (IOException e) {
			if(Thread.currentThread().isInterrupted()){
				
				System.out.println("Interrupted from blocked I/O");
			}else{

				System.out.println("NOT Interrupted from blocked I/O");
				throw new RuntimeException(e);
			}
		}
		
		System.out.println("Exiting IOBlocked.run()");
	}
}

class SynchronziedBlocked implements Runnable{

	public synchronized void f(){
		
		while(true){
			
			//Never releases lock
			Thread.yield();
		}
	}
	
	public SynchronziedBlocked() {
		
		new Thread(){
			
			@Override
			public void run() {
				
				f();
			}
		}.start();
	}
	
	@Override
	public void run() {
		
		System.out.println("Trying to call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run()");
	}
}

public class Interrupting {
	
	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	static void test(Runnable r) throws Exception{
		
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting -->" + r.getClass().getName());
		f.cancel(true);
		System.out.println("Interrupt sent to -->" + r.getClass().getName());
	}
	
	public static void main(String[] args) throws Exception {
		
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronziedBlocked());
		
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aboring with System.exit(0)");
		System.exit(0);
	}
}
