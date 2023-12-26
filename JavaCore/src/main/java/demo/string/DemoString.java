package demo.string;

public class DemoString {
	public static void main(String[] args) {
		// Demo String
		runDemoString();

		// Demo StringBuilder
		System.out.println("============================================");
		runDemoStringBuilder();

		// Demo StringBuffer
		System.out.println("============================================");
		runDemoStringBuffer();
	}

	private static void runDemoString() {
		String string = "Demo string";
		String string2 = "chuoi 2";
		String[] arrString = null;

		// print string
		System.out.println(string);

		// Demo length()
		System.out.println("\nDemo length(): " + string.length());

		// Demo substring()
		System.out.println("\nDemo substring(): " + string.substring(5, 11));

		// Demo contains()
		System.out.println("\nDemo contains(), search 'Demo': " + string.contains("Demo"));

		// Demo join()
		System.out.println("\nDemo join(): " + String.join("-", string, string2));

		// Demo equals()
		System.out.println("\nDemo equals(): " + string.equals(string2));

		// Demo isEmpty()
		System.out.println("\nDemo isEmpty(): " + string.isEmpty());

		// Demo concat()
		System.out.println("\nDemo concat(): " + string.concat(string2));

		// Demo replace()
		System.out.println("\nDemo replace(): " + string.replace("string", "string new"));

		// Demo equalsIgnoreCase()
		System.out.println("\nDemo equalsIgnoreCase(): " + string.equalsIgnoreCase("demo string"));

		// Demo split()
		System.out.println("\nDemo split(): ");
		arrString = string.split(" ");
		for (String string3 : arrString) {
			System.out.println(string3);
		}

		// Demo indexOf()
		System.out.println("\nDemo indexOf(): " + string.indexOf("string"));

		// Demo toUpperCase()
		System.out.println("\nDemo toLowerCase(): " + string.toLowerCase());

		// Demo toUpperCase()
		System.out.println("\nDemo toUpperCase(): " + string.toUpperCase());

		// Demo trim()
		System.out.println("\nDemo trim(): " + string.trim());
	}

	private static void runDemoStringBuilder() {
		StringBuilder stringBuilder = new StringBuilder("Demo stringBuilder");

		// Demo append()
		System.out.println("\nDemo append() SringBuilder: " + stringBuilder.append(" in java"));

		// Demo insert()
		System.out.println("\nDemo insert() SringBuilder: " + stringBuilder.insert(0, "Hello "));

		// Demo replace()
		System.out.println("\nDemo replace() SringBuilder: " + stringBuilder.replace(0, 5, "I can"));

		// Demo delete()
		System.out.println("\nDemo delete() SringBuilder: " + stringBuilder.delete(25, 32));

		// Demo reverse()
		System.out.println("\nDemo reverse() SringBuilder: " + stringBuilder.reverse());

		// Demo capacity()
		System.out.println("\nDemo capacity() SringBuilder: " + stringBuilder.capacity());
	}

	private static void runDemoStringBuffer() {
		StringBuffer stringBuffer = new StringBuffer("Demo stringBuffer");
		StringBuilder stringBuilder = new StringBuilder("Demo stringBuilder");
		
		Runnable task1 = () -> {
			for (int i = 0; i < 500; i++) {
				synchronized (stringBuffer) {
		            stringBuffer.append(" thread1");
		        }
			}
        };

        Runnable task2 = () -> {
        	for (int i = 0; i < 500; i++) {
        		synchronized (stringBuffer) {
        			stringBuffer.append(" thread2");
                }
			}
        };
        
        Runnable task3 = () -> {
			for (int i = 0; i < 500; i++) {
				synchronized (stringBuffer) {
					stringBuilder.append(" thread3");
		        }
			}
        };

        Runnable task4 = () -> {
        	for (int i = 0; i < 500; i++) {
        		synchronized (stringBuffer) {
        			stringBuilder.append(" thread4");
                }
			}
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        Thread thread4 = new Thread(task4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(stringBuffer);
        System.out.println(stringBuilder);
	}
}
