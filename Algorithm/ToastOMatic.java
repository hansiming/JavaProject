package com.csdhsm.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Toast {

	public enum Status {
		DRY, BUTTRED, JAMMED
	}

	private Status status = Status.DRY;
	private final int id;

	public Toast(int ind) {

		this.id = ind;
	}

	public void butter() {

		status = Status.BUTTRED;
	}

	public void jam() {

		status = Status.JAMMED;
	}

	public int getId() {

		return id;
	}

	public Status getStatus() {
		
		return status;
	}
	
	@Override
	public String toString() {

		return "Toast " + id + ": " + status;
	}
}

@SuppressWarnings("serial")
class ToastQueue extends LinkedBlockingQueue<Toast> {
}

class Toaster implements Runnable {

	private ToastQueue queue;
	private int count = 0;
	private Random rand = new Random(47);

	public Toaster(ToastQueue queue) {

		this.queue = queue;
	}

	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {

				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				Toast t = new Toast(count++);
				System.out.println(t);
				queue.put(t);
			}
		} catch (InterruptedException e) {

			System.out.println("Toaster interrupted");
		}

		System.out.println("Toaster off");
	}
}

class Butterer implements Runnable {

	private ToastQueue dryQueue, butterdQueue;

	public Butterer(ToastQueue queue1, ToastQueue queue2) {

		this.dryQueue = queue1;
		this.butterdQueue = queue2;
	}

	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {
				Toast t = dryQueue.take();
				t.butter();
				System.out.println(t);
				butterdQueue.put(t);
			}
		} catch (InterruptedException e) {
			
			System.out.println("Butterer intrrupted");
		}
		System.out.println("Butterer off");
	}
}

class Jammer implements Runnable{

	private ToastQueue butteredQueue, finishedQueue;
	
	public Jammer(ToastQueue queue1,ToastQueue queue2) {
		
		butteredQueue = queue1;
		finishedQueue = queue2;
	}
	
	@Override
	public void run() {
		
		try {
			while(!Thread.interrupted()){
				
				Toast t = butteredQueue.take();
				t.jam();
				System.out.println(t);
				finishedQueue.put(t);
			}
		} catch (InterruptedException e) {
			
			System.out.println("Jammer interrupted");
		}
		
		System.out.println("Jammer off");
	}
}

class Eater implements Runnable{

	private ToastQueue finnishedQueue;
	private int counter = 0;
	
	public Eater(ToastQueue queue) {
		
		this.finnishedQueue = queue;
	}
	
	@Override
	public void run() {
		
		try {
			while(!Thread.interrupted()){
				
				Toast t = finnishedQueue.take();
				
				if(t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED){
					
					System.out.println(">>>>>>Error: " + t);
					System.exit(1);
				}else{
					
					System.out.println("Chomp! " + t);
				}
			}
		} catch (InterruptedException e) {
			
			System.out.println("Eater interrupted");
		}
		
		System.out.println("Eater off");
	}
}

public class ToastOMatic {
	
	public static void main(String[] args) throws InterruptedException {
		
		ToastQueue dryQueue = new ToastQueue(),
				butteredQueue = new ToastQueue(),
				finishedQueue = new ToastQueue();
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.execute(new Toaster(dryQueue));
		service.execute(new Butterer(dryQueue, butteredQueue));
		service.execute(new Jammer(butteredQueue, finishedQueue));
		service.execute(new Eater(finishedQueue));
		
		TimeUnit.SECONDS.sleep(5);
		service.shutdownNow();
	}
}
