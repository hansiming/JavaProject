package com.csdhsm.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();

	@Override
	public int next() {

		lock.lock();
		
		try {
			++currentEvenValue;
			++currentEvenValue;
			Thread.sleep(1000);
			System.out.println("1");
			
			return currentEvenValue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			//lock.unlock();
		}
		return currentEvenValue;
	}

	public static void main(String[] args) {

		EvenChecker.test(new MutexEvenGenerator());
	}
}
