package demo.entities;

import demo.interfaces.DemoInterface;

public class Cat extends Animal implements DemoInterface{
		
	public Cat() {
		super();
	}
	
	// extends Animal
	@Override
	public String doAction() {
		return "meow meow";
	}

	// Implements DemoInteface
	@Override
	public void abstractMethod1() {
		System.out.println("abstractMethod1 of interface");
	}

	// Implements DemoInteface
	@Override
	public String abstractMethod2() {
		return "abstractMethod2 of interface";
	}

	// Implements DemoInteface
	@Override
	public int abstractMethod3() {
		return 7;
	}
}
