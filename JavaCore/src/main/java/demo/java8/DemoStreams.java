package demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

import demo.entities.Staff;

public class DemoStreams {
	public static void main(String[] args) {
		// Demo streams
		runDemoStreams();
		
		// Demo ParallelStreams
		runDemoParallelStreams();
	}
	
	private static void runDemoStreams() {
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		List<Staff> newStaffs = new ArrayList<Staff>();
		List<String> strings = Arrays.asList("map", "and", "flatMap");
		List<List<Character>> mapCharacters = null;
		List<Character> flatMapCharacters = null;
		Map<Long, Staff> mapStaffs = new HashMap<Long, Staff>();
		Optional<Staff> newStaff = Optional.ofNullable(new Staff());
		AtomicLong key = new AtomicLong(0);

		staffs.add(new Staff("Nguyen Van A", 20, "HCM"));
		staffs.add(new Staff("Nguyen Van B", 18, "HN"));
		staffs.add(new Staff("Nguyen Van D", 23, "HCM"));
		staffs.add(new Staff("Nguyen Van E", 22, "GL"));
		
		// Demo forEach()
		staffs.stream().forEach(staff -> System.out.println(staff.getFullname() + " " 
		+ staff.getAge() + " " + staff.getAddress()));
		
		// Demo map() vd: numbers = Arrays.asList(1, 2, 3, 4, 5); numbers.stream().map(n -> n * n);
		System.out.println("\nDemo map(): ");
		staffs.stream().map(staff -> staff.getFullname().toLowerCase() + " " 
				+ staff.getAge() + " " + staff.getAddress())
						.forEach(System.out::println);
		
		// Demo Map() and flatMap()
		System.out.println("\nDemo map() and flatMap(): \nmap(): ");
		mapCharacters = strings.stream().map(str -> str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.toList()))
			    .collect(Collectors.toList());
		for (List<Character> sublist : mapCharacters) {
		    for (char ch : sublist) {
		        System.out.print(ch + " ");
		    }
		    System.out.println();
		}
		
		System.out.println("\nflatMap(): ");
		flatMapCharacters = strings.stream()
                .flatMap(str -> str.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
		for (Character sublist : flatMapCharacters) {
		    System.out.print(sublist + " ");
		}
		System.out.println();
		
		// Demo filter()
		System.out.println("\nDemo filter(): ");
		staffs.stream().filter(staff -> staff.getAge() >= 22)
						.forEach(staff -> System.out.println(staff.getFullname() + " " 
							+ staff.getAge() + " " + staff.getAddress()));
		
		// Demo limit(2)
		System.out.println("\nDemo limit(2): ");
		staffs.stream().limit(2).forEach(staff -> System.out.println(staff.getFullname() + " " 
							+ staff.getAge() + " " + staff.getAddress()));
		
		// Demo sorted()
		System.out.println("\nDemo sorted() by Age: ");
		staffs.stream().sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge()))
						.forEach(staff -> System.out.println(staff.getFullname() + " " 
							+ staff.getAge() + " " + staff.getAddress()));
		
		// Demo min()
		newStaff = staffs.stream().min((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
		System.out.println("\nDemo min() by Age: " + newStaff.get().getFullname() + " " 
							+ newStaff.get().getAge() + " " + newStaff.get().getAddress());
		
		// Demo max()
		newStaff = staffs.stream().max((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
		System.out.println("\nDemo max() by Age: " + newStaff.get().getFullname() + " " 
							+ newStaff.get().getAge() + " " + newStaff.get().getAddress());
		
		// Demo collect()
		System.out.println("\nDemo collect() -> create new list from stream: ");
		newStaffs = staffs.stream().collect(Collectors.toList());
		newStaffs.stream().forEach(staff -> System.out.println(staff.getFullname() + " " 
				            + staff.getAge() + " " + staff.getAddress()));
		
		// Demo collect()
		System.out.println("\nDemo collect() list -> map from stream: ");
		mapStaffs = staffs.stream().collect(Collectors.toMap(e -> key.getAndIncrement(), Function.identity()));
		mapStaffs.forEach((k, v) -> System.out.println(v.getFullname() + " " 
				            + v.getAge() + " " + v.getAddress()));
	}
	
	private static void runDemoParallelStreams() {
		List<String> strings = Arrays.asList("code", "learn", "...");
		List<Integer> integers = Arrays.asList(1, 2, 3 ,4 ,5 ,6 ,7 ,8, 9);
		String streamString = null;
		String parallelString = null;
		Integer streamInteger = 0;
		Integer parallelInteger = 0;
		
	    streamString = strings.stream().reduce(" I'm-", String::concat);
	    parallelString = strings.parallelStream().reduce(" I'm-", String::concat);
	    System.out.println("\nStream: "+streamString +"\nParallelStream: "+parallelString);
	    
	    streamInteger = integers.stream().reduce(0, Integer::sum);        // sum = 1 + 1 + 2 +.... = 45
	    parallelInteger = integers.parallelStream().reduce(0, Integer::sum);
	    System.out.println("\nStream: "+streamInteger +"\nParallelStream: "+parallelInteger);
	}
}
