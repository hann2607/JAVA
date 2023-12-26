package demo.java8;

import demo.services.DefaultMethodService;

public class DemoDefaultMethod{
	public static void main(String[] args) {
		DefaultMethodService defaultMethod = new DefaultMethodService();
		System.out.println("Default interface: " + defaultMethod.sum(2, 4));
		defaultMethod.printInt(defaultMethod.sub(4, 2));
		defaultMethod.printString("Demo Default Method");
	}
}
