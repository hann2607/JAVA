package demo.interfaces;

public interface InterfaceDefaultMethod {
	int sum (int a, int b);
	
	int sub (int a, int b);
	
	// Default method
	default void printInt (int result) {
		System.out.println("Result: " + result);
	}
	
	// Default method2
	default void printString (String result) {
		System.out.println("Result: " + result);
	}
}
