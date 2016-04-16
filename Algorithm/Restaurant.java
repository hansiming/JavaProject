package com.csdhsm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal {

	private final int orderNum;

	public Meal(int orderNum) {

		this.orderNum = orderNum;
	}

	public String toString() {

		return "Meal " + orderNum;
	}
}

class WaitPerson implements Runnable {

	private Restaurant restaurant;

	public WaitPerson(Restaurant restaurant) {

		this.restaurant = restaurant;
	}

	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {

				synchronized (this) {

					while (restaurant.meal == null) {

						wait();
					}
				}
				System.out.println("Waitperson + got " + restaurant.meal);
				synchronized (restaurant.chef) {

					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}
			}
		} catch (InterruptedException e) {

			System.out.println("WaitPerson interrupted");
		}
	}
}

class Chef implements Runnable {

	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant restaurant) {

		this.restaurant = restaurant;
	}

	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {

				synchronized (this) {

					while (restaurant.meal != null) {

						wait();// ... for the meal to be taken
					}
				}
				if (++count == 10) {

					System.out.println("Out of food,closing");
					restaurant.service.shutdownNow();
				}
				System.out.println("Order up! ");
				synchronized (restaurant.person) {

					restaurant.meal = new Meal(count);
					restaurant.person.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {

			System.out.println("Chef interrupted");
		}
	}
}

public class Restaurant {

	Meal meal;
	ExecutorService service = Executors.newCachedThreadPool();
	WaitPerson person = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant() {

		service.execute(chef);
		service.execute(person);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
}
