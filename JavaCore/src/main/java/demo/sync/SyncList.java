package demo.sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class SyncList {
	private static List<Integer> arrayList = new ArrayList<Integer>();
	private static List<Integer> vector = new Vector<Integer>();
	private static List<Integer> synchronizedList = Collections.synchronizedList(arrayList);

    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
            	// Demo arrayList in Multi-thread
            	 arrayList.add(i);
            	
            	// Demo vector in Multi-thread
//            	vector.add(i);
            	
            	// Demo arrayList in Multi-thread use synchronizedList
            	synchronizedList.add(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
            	// Demo arrayList in Multi-thread
            	arrayList.add(i);
            	
            	// Demo vector in Multi-thread
//            	vector.add(i);
            	
            	// Demo arrayList in Multi-thread use synchronizedList
            	synchronizedList.add(i);
            }
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

        System.out.println("Size of arrayList: " + arrayList.size());
//        System.out.println("Size of vector: " + synchronizedList.size());
        System.out.println("Size of arrayList use synchronizedList: " + synchronizedList.size());
    }
}
