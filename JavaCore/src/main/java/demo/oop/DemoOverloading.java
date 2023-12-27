package demo.oop;

public class DemoOverloading{
	public static void main(String[] args) {
		System.out.println("Demo Overloading: ");
		System.out.println("sum 2 nums: " + sum(2, 4));
		System.out.println("sum 3 nums: " + sum(2, 4, 2));
		System.out.println("sum 4 nums: " + sum(2, 4, 4, 7));
	}
	
	private static int sum(int a, int b) {
		return a + b;
	}
	
	private static int sum(int a, int b, int c) {
		return a + b + c;
	}
	
	private static int sum(int a, int b, int c, int d) {
		return a + b + c + d;
	}
}
