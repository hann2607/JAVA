package demo.java8;

import java.util.Optional;

import demo.entities.Staff;


public class DemoOptional {
	public static void main(String[] args) {
		// Demo Optional
//		runDemoOptional();
		Staff staff = new Staff("Nguyen Van A", 20, "HCM");
		testMethod(staff);
	}

	private static void runDemoOptional() {
		Staff staff = new Staff("Nguyen Van A", 20, "HCM");
		Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("Nested Value"));
		Optional<String> flatMappedValue = Optional.empty();
		Optional<String> optionalValue = Optional.of("10");
		Optional<Integer> mappedValue = Optional.empty();
		
		// Create Optional empty
		Optional<String> optionalEmpty = Optional.empty();

		// Create Optional non-null
		String str = "xin chao!";
		Optional<String> optionalNN = Optional.of(str);

		// Create Optional obj or null
		Optional<Staff> optionalObj = Optional.ofNullable(staff);

		// Demo get()
		System.out.println("Demo get() of Optional: " + optionalObj.get());

		// Demo Boolean isPresent() --> check null
		System.out.println("Demo isPresent() of Optional: " + optionalObj.isPresent());

		// Demo ifPresent() --> check null
		System.out.print("Demo ifPresent(): ");
		optionalObj.ifPresent(t -> System.out.println(t.getFullname()));

		// Demo orElse() --> return optional value or param(Optional null)
		System.out.print("Demo orElse(): ");
		System.out.println(optionalNN.orElse("Optional null!"));

		// Demo orElseGet()
		System.out.print("Demo orElseGet(): ");
		System.out.println(optionalEmpty.orElseGet(() -> "Optional null!"));

		// Demo map() optional<String> --> optional<Integer>
		mappedValue = optionalValue.map(s -> Integer.parseInt(s));
		System.out.println("Demo map(): " + mappedValue.get());

		// Demo flatMap() --> Optional<Optional<String>> --> Optional<String>
		flatMappedValue = nestedOptional.flatMap(innerOptional -> innerOptional);
		System.out.println("Demo flatMap(): " + flatMappedValue.get());

		// Demo filter()
		System.out.print("Demo filter(): ");
		optionalObj.filter(t -> t.getAddress().equals("HCM")).ifPresent(System.out::println);

		// Demo orElseThrow()
		System.out.print("Demo orElseThrow(): ");
		optionalEmpty.orElseThrow(() -> new IllegalStateException("Demo orElseThrow!"));
	}
	
	private static void testMethod(Staff staff) {
		Optional<Staff> checkStaff = Optional.ofNullable(staff);
		checkStaff.filter(st -> st.getAge() > 18).map(s -> (String) s.getFullname() + " Lớn hơn 18!")
								.ifPresent(System.out::println);
	}
}
