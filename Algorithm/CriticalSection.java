package com.csdhsm.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//not thread safe
class Pair{
	
	private int x,y;
	public Pair(int x, int y){
		
		this.x = x;
		this.y = y;
	}
	
	public Pair() {
		
		this(0,0);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void incrementX(){
		
		x++;
	}
	
	public void incrementY(){
		
		y++;
	}
	
	@Override
	public String toString() {
		
		return "x:" + x + " y:" + y;
	}
	
	@SuppressWarnings("serial")
	public class PairValueNotEquealException extends RuntimeException{
		
		public PairValueNotEquealException() {
			
			super("Pari values not equal： " + Pair.this);
		}
	}
	
	public void checkState(){
		
		if(x != y){
			throw new PairValueNotEquealException();
		}
	}
}

abstract class PairManager{
	
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair pair = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
	
	public synchronized Pair getPair(){
		
		//Make a copy to keep the original safe
		return new Pair(pair.getX(), pair.getY());
	}
	
	protected void store(Pair p){
		
		storage.add(p);
		
		try {
			TimeUnit.SECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public abstract void increment();
}

//Synchronized the entire method
class PairManager1 extends PairManager{

	@Override
	public synchronized void increment() {
		
		pair.incrementX();
		pair.incrementY();
		store(pair);
	}
}

//Use a critical section
class PairManager2 extends PairManager{

	@Override
	public void increment() {
		
		Pair temp;
		synchronized(this){
			
			pair.incrementX();
			pair.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}

class PairManipulator implements Runnable{

	private PairManager pm;
	
	public PairManipulator(PairManager pm) {
		
		this.pm = pm;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			pm.increment();
		}
	}
	
	@Override
	public String toString() {
		
		return "Pair: " + pm.getPair() + " checkCounter =" + pm.checkCounter.get(); 
	}
}

class PairChecker implements Runnable{

	PairManager pm;
	
	public PairChecker(PairManager pm) {
		
		this.pm = pm;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}
}

public class CriticalSection {
	
	//Test the two different approaches
	static void testApproaches(PairManager pman1, PairManager pman2){
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		PairManipulator pm1 = new PairManipulator(pman1);
		PairManipulator pm2 = new PairManipulator(pman2);
		
		PairChecker pcheck1 = new PairChecker(pman1);
		PairChecker pcheck2 = new PairChecker(pman2);
		
		service.execute(pm1);
		service.execute(pm2);
		service.execute(pcheck1);
		service.execute(pcheck2);
		
		try{
			
			TimeUnit.MILLISECONDS.sleep(500);
		}catch (Exception e) {
			System.out.println("Sleep Interrupted");
		}
		
		System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		
		PairManager pman1 = new PairManager1();
		PairManager pman2 = new PairManager2();
		
		testApproaches(pman1, pman2);
	}
}




