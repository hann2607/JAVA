package demo.dp.builder.demo;

import demo.dp.builder.builders.LaptopBuilder;
import demo.dp.builder.builders.PCBuilder;
import demo.dp.builder.computer.Laptop;
import demo.dp.builder.computer.PC;
import demo.dp.builder.director.Director;

public class demoBuilder {
	public static void main(String[] args) {
		Director director = new Director();
		
		// Create PC
		PCBuilder pcBuilder = new PCBuilder(); 
		director.constructPC(pcBuilder);
		PC pc = pcBuilder.getResult();
		System.out.println("PC Build: " + pc.getType());
		
		// Create Laptop
		LaptopBuilder laptopBuilder = new LaptopBuilder(); 
		director.constructLaptop(laptopBuilder);
		Laptop laptop = laptopBuilder.getResult();
		System.out.println("Laptop Build: " + laptop.getType());
	}
}
