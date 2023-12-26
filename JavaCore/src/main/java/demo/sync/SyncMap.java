package demo.sync;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyncMap {
	private static Map<String, Integer> map = new HashMap<>();
	private static Map<String, Integer> mapHashTable = new Hashtable<>();
	private static Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
            	// Demo HashMap in multi-thread
            	map.put("Key" + i, i);
            	
            	// Demo HashTable in multi-thread
            	mapHashTable.put("Key" + i, i);
            	
            	// Demo Map in multi-thread use concurrentMap
                concurrentMap.putIfAbsent("Key" + i, i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
            	// Demo hashMap in multi-thread
            	map.put("Key" + i, i);
            	
            	// Demo hashTable in multi-thread
            	mapHashTable.put("Key" + i, i);
            	
            	// Demo Map in multi-thread use concurrentMap
                concurrentMap.putIfAbsent("Key" + i, i);
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
        
        System.out.println("Size of HashMap: " + map.size());
        System.out.println("Size of HashTable: " + mapHashTable.size());
        System.out.println("Size of concurrentMap: " + concurrentMap.size());
    }
}
