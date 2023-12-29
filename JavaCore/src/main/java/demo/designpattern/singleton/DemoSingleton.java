package demo.designpattern.singleton;

import demo.entities.singleton.Computer;

public class DemoSingleton {
	public static void main(String[] args) {
		Computer computer = Computer.getInstance();
		
		computer.setName("MSI Baravo 15");
		computer.setRam("8 GB");
		computer.setCpu("AMD 5");
		
		System.out.println("Demo create object with singleton: ");
		System.out.println(computer.displayInfo());
		
		System.out.println("\nDemo global variable with singleton: ");
		demoSingleton();
		
		System.out.println("\nDemo singleton in multi-thread:");
		runSingletonMultiThread();
	}
	
	private static void demoSingleton() {
		Computer computer = Computer.getInstance();
		System.out.println(computer.displayInfo());
	}
	
	private static void runSingletonMultiThread() {
		Runnable task1 = () -> {
			Computer computer = Computer.getInstance();
			System.out.println(computer);
        };

        Runnable task2 = () -> {
        	Computer computer1 = Computer.getInstance();
        	System.out.println(computer1);
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
