 	package demo.sync;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SyncSet {
	private static Set<Integer> hashSet = new HashSet<Integer>();
	private static Set<Integer> synchronizedHashSet = Collections.synchronizedSet(hashSet);

    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
            	// Demo Set in multi-thread
//            	hashSet.add(i);
            	
            	// Demo Set in multi-thread use synchronizedSet
            	synchronizedHashSet.add(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
            	// Demo Set in multi-thread
//            	hashSet.add(i);
            	
            	// Demo Set in multi-thread use synchronizedSet
            	synchronizedHashSet.add(i);
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

//        System.out.println("Size of Set: " + hashSet.size());
        System.out.println("Size of synchronizedSet: " + synchronizedHashSet.size());
    }
}
