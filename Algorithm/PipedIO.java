package com.csdhsm.concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable{

	private PipedWriter out = new PipedWriter();
	
	public PipedWriter getWriter(){
		
		return out;
	}
	
	@Override
	public void run() {
		
		try {
			while(true){
				
				for(char c = 'A'; c <= 'Z'; c++){
					
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(500);
				}
			}
		} catch (IOException e) {

			System.out.println(e + " Sender write exception");
		} catch (InterruptedException e) {
			System.out.println(e + " Sender sleep interrupted");
		}
	}
}

class Receiver implements Runnable{

	private PipedReader reader = new PipedReader();
	
	public Receiver(Sender sender) {
		
		try {
			reader = new PipedReader(sender.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		try {
			while(true){
				
				System.out.println("Read : " + (char)reader.read() + ". ");
			}
		} catch (IOException e) {
			
			System.out.println(e + " Receiver read Exception");
		}
	}
}

public class PipedIO {
	
	public static void main(String[] args) throws InterruptedException {
		
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.execute(sender);
		service.execute(receiver);
		
		TimeUnit.SECONDS.sleep(4);
		
		service.shutdownNow();
	}
}
