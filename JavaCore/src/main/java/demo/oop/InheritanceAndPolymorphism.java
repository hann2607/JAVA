package demo.oop;

import demo.entities.Animal;
import demo.entities.Cat;
import demo.entities.Dog;

public class InheritanceAndPolymorphism {
	public static void main(String[] args) {
		DemoInterfaceImpl demoInterface = new DemoInterfaceImpl();
		Cat cat = new Cat();
		Animal dog = new Dog();
		
		// Use method extend from Animal
		cat.setName("Cat");
		dog.setName("Dog");
		
		// Demo Inheritance + abstract class
		System.out.println("Demo Inheritance and abstract class:");
		System.out.println(cat.getName() + ": " + cat.doAction());
		System.out.println(dog.getName() + ": " + dog.doAction());
		System.out.println("implements interface: " + cat.abstractMethod2());

		// demo Inheritance and Interface
		System.out.println("\nDemo Inheritance and Interface:");
		demoInterface.abstractMethod1();
		System.out.println(demoInterface.abstractMethod2());
		System.out.println("implements abstract method 3 of interface DemoInteface.class: " 
		+ demoInterface.abstractMethod3());
		System.out.println("implements abstract method sum of interface InterfaceDefaultMethod.class: " 
		+ demoInterface.sum(3, 4));
		System.out.println("implements abstract method sub of interface InterfaceDefaultMethod.class: " 
		+ demoInterface.sum(5, 4));
	}
}
