package demo.java8;

import java.time.LocalDate;
import java.util.function.Supplier;

import demo.entities.Staff;
import demo.interfaces.FICalcAge;
import demo.interfaces.FICalculator;
import demo.interfaces.FIStaff;

public class DemoFunctionalInterface {
	public static void main(String[] args) {
		// add and sub
		FICalculator addition = (a, b) -> a + b;        // Use Lambda Expression 
		FICalculator subtraction = (a, b) -> a - b;        // Use Lambda Expression 
		System.out.println("5 + 3 = " + performOperation(5, 3, addition));
		System.out.println("5 - 3 = " + performOperation(5, 3, subtraction));
		
		// Calculate Age
		LocalDate currentDate = LocalDate.now();
		FICalcAge calcAge = (year) -> currentDate.getYear() - year;
		System.out.println("Age: " + calcAgeMethod(2002, calcAge));
		
		// Demo Functional Interface + lambda + Method References
		Staff staff = new Staff("Nguyen Van A", 20, "HCM");
		FIStaff get = (s)-> s.getFullname() + " " + s.getAge() + " " + s.getAddress();
		System.out.println("Demo Functional Interface + lambda + Method References: " 
		+ getFullname(staff, get::execute));
		
		Supplier<String> name = staff::getFullname;
		System.out.println(name.get());
	}

	/**
	 * Method use Functional Interface
	 */
	private static int performOperation(int a, int b, FICalculator calculator) {
		return calculator.calculate(a, b);
	}
	
	private static int calcAgeMethod(int year, FICalcAge calcAge) {
		return calcAge.calculateAge(year);
	}
	
	private static String getFullname(Staff staff, FIStaff fiStaff) {
		return fiStaff.execute(staff);
	}
}
