package demo.oop;


import demo.interfaces.DemoInterface;
import demo.interfaces.InterfaceDefaultMethod;

public class DemoInterfaceImpl implements InterfaceDefaultMethod, DemoInterface{

	@Override
	public void abstractMethod1() {
		System.out.println("implement abstract method 1 of interface DemoInteface.class");
	}

	@Override
	public String abstractMethod2() {
		return "implement abstract method 2 of interface DemoInteface.class";
	}

	@Override
	public int abstractMethod3() {
		return 2 + 3;
	}

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

}
