package demo.javautil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import demo.entities.Staff;

public class DemoJavautilMain {
	public static void main(String[] args) {
		System.out.println("============================================");
		runDemoArrayList();
		
		System.out.println("============================================\n");
		System.out.println("LinkedList:");
		runDemoLinkedList();
		
		System.out.println("============================================\n");
		System.out.println("Stack:");
		runDemoStack();
		
		System.out.println("============================================\n");
		System.out.println("Vector:");
		runDemoVector();
		
		System.out.println("============================================\n");
		System.out.println("HashMap:");
		runDemoHashMap();
		
		System.out.println("============================================\n");
		System.out.println("HashTable:");
		runDemoHashTable();
		
		System.out.println("============================================\n");
		System.out.println("EnumSet:");
		runDemoEnumSet();
		
		System.out.println("============================================\n");
		System.out.println("HashSet:");
		runDemoHashSet();
		
		System.out.println("============================================\n");
		System.out.println("LinkedHashSet:");
		runDemoLinkedHashSet();
		
		System.out.println("============================================\n");
		System.out.println("TreeSet:");
		runDemoTreeSet();
		
		System.out.println("============================================\n");
		System.out.println("Collections:");
		runDemoCollections();
		
		System.out.println("============================================\n");
		System.out.println("Properties:");
		runDemoProperties();
		
		System.out.println("============================================\n");
		System.out.println("Resource Bundle:");
		runDemoResourceBundle();
	}
	
	private static void runDemoArrayList() {
		List<Staff> listStaffs = new ArrayList<Staff>(9); // ArrayList
		Iterator<Staff> litr; // Iterator
		Staff[] arrStaffs; // Array Object
		Staff staffContain = new Staff("Nguyen Van A", 20, "HCM");

		// Demo add(E e)
		listStaffs.add(new Staff("Nguyen Van A", 20, "HCM"));
		listStaffs.add(new Staff("Nguyen Van B", 18, "HN"));
		listStaffs.add(new Staff("Nguyen Van D", 23, "HCM"));
		listStaffs.add(new Staff("Nguyen Van E", 22, "GL"));

		// Demo Iterator
		System.out.println("ArrayList:");
		litr = listStaffs.listIterator();
		while (litr.hasNext()) {
			Staff element = litr.next();
			System.out.println(element.getFullname() + " - " 
			+ element.getAge() + " - " + element.getAddress());
		}

		// Demo size()
		System.out.println("\nSize of ArrayList: " + listStaffs.size());

		// Demo set(int index, E e)
		listStaffs.get(1).setFullname("Tran Van C");;
		System.out.println("\nDemo set(int index, E e) of ArrayList:");
		for (int i = 0; i < listStaffs.size(); i++) {
			System.out.println(listStaffs.get(i).getFullname() + " - " 
			+ listStaffs.get(i).getAge() + " - " + listStaffs.get(i).getAddress());
		}

		// Demo remove(int index)
		listStaffs.remove(1);
		System.out.println("\nDemo remove(int index) of ArrayList:");
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
		+ staff.getAge() + " - " + staff.getAddress());
		}

		// Demo Contains(Object o)
		System.out.println("\nDemo Contains(Object o) search 'Nguyen Van A': " 
		+ listStaffs.contains(staffContain));

		// Demo indexOf(Object o)
		System.out.println("\nDemo indexOf(Object o) search 'Nguyen Van A': " 
		+ listStaffs.indexOf(staffContain));

		// Demo isEmpty()
		System.out.println("\nDemo isEmpty(): " + listStaffs.isEmpty());

		// Demo toArray()
		arrStaffs = listStaffs.toArray(new Staff[0]);
		System.out.println("\nDemo toArray(): ");
		for (Staff staff : arrStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}

		// Demo clear()
		listStaffs.clear();
		System.out.println("\nDemo clear(), size of ArrayList: " 
		+ listStaffs.size());
	}
	
	private static void runDemoLinkedList() {
		LinkedList<Staff> listStaffs = new LinkedList<Staff>(); // LinkedList
		Staff staffContain = new Staff("Nguyen Van A", 20, "HCM");

		// Demo add(Object o)
		listStaffs.add(new Staff("Nguyen Van A", 20, "HCM"));
		listStaffs.add(new Staff("Nguyen Van B", 18, "HN"));
		System.out.println("Demo add() of LinkedList:");
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}

		// Demo addFirst(Object o)
		listStaffs.addFirst(new Staff("Nguyen Van G", 25, "BP"));
		System.out.println("\nDemo addFirst(Object o) of LinkedList:");
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}

		// Demo addLast(Object o)
		listStaffs.addLast(new Staff("Nguyen Van L", 22, "DN"));
		System.out.println("\nDemo addLast(Object o) of LinkedList:");
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}

		// Demo size()
		System.out.println("\nDemo size() of LinkedList: " + listStaffs.size());

		// Demo contains(Object o)
		System.out.println("\nDemo contains(Object o), search 'Nguyen Van A': " 
		+ listStaffs.contains(staffContain));

		// Demo remove(Object o)
		listStaffs.remove(staffContain);
		System.out.println("\nDemo remove(Object o), remove 'Nguyen Van A':");
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo getFirst()
		System.out.println("\nDemo getFirst(): " + listStaffs.getFirst().getFullname());
		
		// Demo getLast()
		System.out.println("\nDemo getLast(): " + listStaffs.getLast().getFullname());
	}
	
	private static void runDemoStack() {
		Stack<Staff> stacks = new Stack<Staff>();
		Staff stackPush = new Staff("Nguyen Van A", 20, "HCM");
		
		stacks.add(new Staff("Nguyen Van A", 20, "HCM"));
		stacks.add(new Staff("Nguyen Van B", 18, "HN"));
		stacks.add(new Staff("Nguyen Van D", 23, "HCM"));
		stacks.add(new Staff("Nguyen Van E", 22, "GL"));
		for (Staff staff : stacks) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo empty()
		System.out.println("\nDemo empty() of Stack: " + stacks.empty());
		
		// Demo peek()
		System.out.println("\nDemo peek() of Stack: " + stacks.peek().getFullname());
		for (Staff staff : stacks) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo pop()
		System.out.println("\nDemo pop() of Stack: " + stacks.pop().getFullname());
		for (Staff staff : stacks) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo push(Object o)
		System.out.println("\nDemo push(Object o) of Stack: " + stacks.push(stackPush).getFullname());
		for (Staff staff : stacks) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo search(Object o)
		System.out.println("\nDemo search(Object o) of Stack: " + stacks.search(stackPush));
	}
	
	@SuppressWarnings("unchecked")
	private static void runDemoVector() {
		Vector<Staff> listStaffs = new Vector<Staff>();
		Vector<Staff> vectorClone;
		Staff[] arrStaffs = new Staff[2]; 
		Staff staffContain = new Staff("Nguyen Van A", 20, "HCM");
		Staff insertStaff = new Staff("Nguyen Van F", 27, "HCM");
		
		// Demo addElement(Object o)
		listStaffs.addElement(new Staff("Nguyen Van A", 20, "HCM"));
		listStaffs.addElement(new Staff("Nguyen Van B", 18, "HN"));
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo clone()
		vectorClone = (Vector<Staff>) listStaffs.clone();
		System.out.println("\nDemo clone() of Vector:");
		for (Staff staff : vectorClone) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo contains(Object o)
		System.out.println("\nDemo contains(Object o) of Vector, search 'Nguyen Van A': " 
		+ listStaffs.contains(staffContain));
		
		// Demo copyInto(Object [])
		listStaffs.copyInto(arrStaffs);
		System.out.println("\nDemo copyInto(Object []) of Vector: ");
		for (Staff staff : arrStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo ElementAt(int index)
		System.out.println("\nDemo ElementAt(int index) of Vector, element of index 1: " 
		+ listStaffs.elementAt(1).getFullname());
		
		// Demo elements()
		System.out.println("\nDemo Elements() of Vector: ");
		Enumeration<Staff> enumeration = listStaffs.elements();
        while (enumeration.hasMoreElements()) {
            Staff staff = enumeration.nextElement();
            System.out.println(staff.getFullname() + " - " 
        	+ staff.getAge() + " - " + staff.getAddress());
        }
        
        // Demo FirstElement()
        System.out.println("\nDemo FirstElement() of Vector: " 
        + listStaffs.firstElement().getFullname());
     
        // Demo indexOf(Object o)
        System.out.println("\nDemo indexOf(Object o) of Vector, search index of 'Nguyen Van A': " 
        + listStaffs.indexOf(staffContain));
    
        // Demo insertElementAt(Object o, int index)
        System.out.println("\nDemo insertElementAt(Object o, int index) of Vector: ");
        listStaffs.insertElementAt(insertStaff, 1);
        for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
        
        // Demo isEmpty()
        System.out.println("\nDemo isEmpty() of Vector: " + listStaffs.isEmpty());
      
        // Demo lastElement()
        System.out.println("\nDemo lastElement() of Vector: " + listStaffs.lastElement().getFullname());
        
        // Demo lastIndexOf(Object o)
        System.out.println("\nDemo lastIndexOf(Object o) of Vector, search 'Nguyen Van A': " 
        + listStaffs.lastIndexOf(staffContain));
        
        // Demo size()
        System.out.println("\nDemo size() of Vector: " 
        + listStaffs.size());
        
        // Demo setElementAt(Object o, int index)
        System.out.println("\nDemo setElementAt(Object o, int index) of Vector: ");
        listStaffs.setElementAt(insertStaff, 0);
        for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
        
        // Demo toString()
        System.out.println("\nDemo toString() of Vector: " + listStaffs.toString());
        
        // Demo removeElement(Object o)
        System.out.println("\nDemo removeElement(Object o) of Vector: ");
        listStaffs.removeElement(insertStaff);
        for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
        
        // Demo removeAll()
        listStaffs.removeAllElements();
        System.out.println("\nDemo removeAll() of Vector, size of Vector: " + listStaffs.size());
	}
	
	@SuppressWarnings("unchecked")
	private static void runDemoHashMap() {
		HashMap<Integer, Staff> mapStaffs = new HashMap<Integer, Staff>();
		HashMap<Integer, Staff> hashmapClone = new HashMap<Integer, Staff>();
		HashMap<Integer, Staff> hashmapPutAll = new HashMap<Integer, Staff>();
		Staff staffContain = new Staff("Nguyen Van A", 20, "HCM");
		
		// Demo HashMap put(Object Key, Object Value)
		mapStaffs.put(0, new Staff("Nguyen Van A", 20, "HCM"));
		mapStaffs.put(1, new Staff("Nguyen Van E", 22, "DN"));
		mapStaffs.put(2, new Staff("Nguyen Van B", 25, "HN"));
		mapStaffs.put(3, new Staff("Nguyen Van C", 27, "GL"));
		
		for (Entry<Integer, Staff> staff : mapStaffs.entrySet()) {
			System.out.println(staff.getValue().getFullname() + " - " 
			+ staff.getValue().getAge() + " - " + staff.getValue().getAddress());
		}
		
		// Demo HashMap Clone()
		hashmapClone = (HashMap<Integer, Staff>) mapStaffs.clone();
		System.out.println("\nDemo HashMap Clone(): ");
		for (Entry<Integer, Staff> staff : hashmapClone.entrySet()) {
			System.out.println(staff.getValue().getFullname() + " - " 
			+ staff.getValue().getAge() + " - " + staff.getValue().getAddress());
		}
		
		// Demo ContainsKey(Object Key)
		System.out.println("\nDemo HashMap ContainsKey(Object Key), search key '0': " 
		+ mapStaffs.containsKey(0));
		
		// Demo ContainsValue(Object Value)
		System.out.println("\nDemo HashMap ContainsValue(Object Value), search value 'Nguyen Van A': " 
		+ mapStaffs.containsValue(staffContain));
		
		// Demo isEmpty()
		System.out.println("\nDemo HashMap isEmpty(): " 
		+ mapStaffs.isEmpty());
		
		// Demo keySet()
		System.out.println("\nDemo HashMap keySet(): ");
		for (Integer keyStaff : mapStaffs.keySet()) {
			System.out.println(keyStaff);
		}
		
		// Demo putAll(Map T)
		hashmapPutAll.putAll(mapStaffs);
		System.out.println("\nDemo HashMap putAll(Map T): ");
		for (Entry<Integer, Staff> staff : hashmapPutAll.entrySet()) {
			System.out.println(staff.getValue().getFullname() + " - " 
			+ staff.getValue().getAge() + " - " + staff.getValue().getAddress());
		}
		
		// Demo size()
		System.out.println("\nDemo HashMap size(): " 
		+ mapStaffs.size());
		
		// Demo values()
		System.out.println("\nDemo HashMap values(): " );
		for (Staff staff : mapStaffs.values()) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo remove(Object key)
		System.out.println("\nDemo HashMap remove(Object key): " );
		mapStaffs.remove(0);
		for (Staff staff : mapStaffs.values()) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
	}
	
	private static void runDemoHashTable() {
		Hashtable<Integer, Staff> htStaffs = new Hashtable<Integer, Staff>();
		Staff staffContain = new Staff("Nguyen Van A", 20, "HCM");
		
		// Demo Hashtable put(Object Key, Object Value)
		htStaffs.put(0, new Staff("Nguyen Van A", 20, "HCM"));
		htStaffs.put(1, new Staff("Nguyen Van E", 22, "DN"));
		htStaffs.put(2, new Staff("Nguyen Van B", 25, "HN"));
		htStaffs.put(3, new Staff("Nguyen Van C", 27, "GL"));
		for (Entry<Integer, Staff> staff : htStaffs.entrySet()) {
			System.out.println(staff.getValue().getFullname() + " - " 
			+ staff.getValue().getAge() + " - " + staff.getValue().getAddress());
		}
		
		// Demo Hashtable isEmpty()
		System.out.println("\nDemo Hashtable isEmpty(): " + htStaffs.isEmpty());
		
		// Demo Hashtable contains(Object o)
		System.out.println("\nDemo Hashtable contains(Object o): " + htStaffs.contains(staffContain));
		
		// Demo Hashtable containsKey(Object o)
		System.out.println("\nDemo Hashtable containsKey(Object o), search key '0': " 
		+ htStaffs.containsKey(0));
		
		// Demo elements()
		System.out.println("\nDemo Hashtable elements(): ");
		Enumeration<Staff> enumeration = htStaffs.elements();
	    while (enumeration.hasMoreElements()) {
	         Staff value = enumeration.nextElement();
	         System.out.println(value.getFullname() + " - " 
	     	+ value.getAge() + " - " + value.getAddress());
	    }
	    
	    // Demo keys()
	 	System.out.println("\nDemo Hashtable keys(): ");
	 	Enumeration<Integer> enumerationKey = htStaffs.keys();
	    while (enumerationKey.hasMoreElements()) {
	         Integer value = enumerationKey.nextElement();
	         System.out.println(value);
	    }
	    
	    // Demo Hashtable size()
	 	System.out.println("\nDemo Hashtable size(): " + htStaffs.size());
	 	
	 	// Demo Hashtable remove(Object key)
	 	htStaffs.remove(0);
	 	System.out.println("\nDemo Hashtable remove(Object key): ");
	 	for (Entry<Integer, Staff> staff : htStaffs.entrySet()) {
			System.out.println(staff.getValue().getFullname() + " - " 
			+ staff.getValue().getAge() + " - " + staff.getValue().getAddress());
		}
	}
	
	enum games {LMHT, VALORANT, PUBG}
	private static void runDemoEnumSet() {
		EnumSet<games> gamesEnumSet = EnumSet.allOf(games.class);
		System.out.println(gamesEnumSet);
		
		// Demo copyOf()
		EnumSet<games> gamesEnumSet2 = EnumSet.copyOf(gamesEnumSet);
		System.out.println("\nDemo copyOf() of EnumSet: " + gamesEnumSet2);
		
		// Demo contains()
		System.out.println("\nDemo contains() of EnumSet, search game 'LMHT': " 
		+ gamesEnumSet.contains(games.LMHT));
		
		// Demo isEmpty()
		System.out.println("\nDemo isEmpty() of EnumSet: " 
		+ gamesEnumSet.isEmpty());
		
		// Demo size()
		System.out.println("\nDemo size() of EnumSet: " 
		+ gamesEnumSet.size());
		
		// Demo clear()
		gamesEnumSet.clear();
		System.out.println("\nDemo clear() of EnumSet: " 
		+ gamesEnumSet.size());
	}
	
	private static void runDemoHashSet() {
		HashSet<Staff> staffs = new HashSet<Staff>(); 
		HashSet<Staff> staffsRetainAll = new HashSet<Staff>(); 
		Staff[] arrStaffs; // Array Object
		Staff staffTest = new Staff("Nguyen Van A", 20, "HCM");
		
		//Demo add(Object o) 
		staffs.add(new Staff("Nguyen Van A", 20, "HCM"));
		staffs.add(new Staff("Nguyen Van B", 18, "HN"));
		staffs.add(new Staff("Nguyen Van D", 23, "HCM"));
		staffs.add(new Staff("Nguyen Van E", 22, "GL"));
		staffsRetainAll.add(new Staff("Nguyen Van D", 23, "HCM"));
		staffsRetainAll.add(new Staff("Nguyen Van E", 22, "GL"));
		System.out.println("Demo add(Object o) of HashSet: ");
		for (Staff staff : staffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		//Demo contains(Object o)
		System.out.println("\nDemo contains(Object o) of HashSet, search 'Nguyen Van A': " 
		+ staffs.contains(staffTest));
		
		//Demo isEmpty()
		System.out.println("\nDemo isEmpty() of HashSet: " 
		+ staffs.isEmpty());
		
		//Demo remove(object o)
		System.out.println("\nDemo remove(object o) of HashSet: ");
		staffs.remove(staffTest);
		for (Staff staff : staffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		//Demo retainAll(Collection c)
		System.out.println("\nDemo retainAll(Collection c) of HashSet: ");
		staffs.retainAll(staffsRetainAll);
		for (Staff staff : staffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		//Demo size()
		System.out.println("\nDemo size() of HashSet: " + staffs.size());
		
		// Demo toArray()
		arrStaffs = staffs.toArray(new Staff[0]);
		System.out.println("\nDemo toArray(): ");
		for (Staff staff : arrStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
	}
	
	private static void runDemoLinkedHashSet() {
		LinkedHashSet<Staff> staffs = new LinkedHashSet<Staff>(); 
		
		//Demo add(Object o) 
		staffs.add(new Staff("Nguyen Van E", 22, "GL"));
		staffs.add(new Staff("Nguyen Van A", 20, "HCM"));
		staffs.add(new Staff("Nguyen Van B", 18, "HN"));
		staffs.add(new Staff("Nguyen Van D", 23, "HCM"));
		for (Staff staff : staffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void runDemoTreeSet() {
		TreeSet<Staff> staffs = new TreeSet<Staff>();
		TreeSet<Staff> staffsClone = new TreeSet<Staff>();
		Staff staffTest = new Staff("Nguyen Van A", 20, "HCM");
		
		// Demo add(Object o)
		System.out.println("Demo add(Object o) of TreeSet: ");
		staffs.add(new Staff("Nguyen Van A", 20, "HCM"));
		staffs.add(new Staff("Nguyen Van B", 18, "HN"));
		staffs.add(new Staff("Nguyen Van D", 23, "HCM"));
		staffs.add(new Staff("Nguyen Van E", 22, "GL"));
		for (Staff staff : staffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo Clone()
		System.out.println("\nDemo Clone() of TreeSet: ");
		staffsClone = (TreeSet<Staff>) staffs.clone();
		for (Staff staff : staffsClone) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo Contains(Object o)
		System.out.println("\nDemo Contains(Object o) of TreeSet: " + staffs.contains(staffTest));
		
		// Demo first()
		System.out.println("\nDemo first() of TreeSet: " + staffs.first().getFullname());
		
		// Demo last()
		System.out.println("\nDemo last() of TreeSet: " + staffs.last().getFullname());
		
		// Demo size()
		System.out.println("\nDemo size() of TreeSet: " + staffs.size());
		
		// Demo isEmpty()
		System.out.println("\nDemo isEmpty() of TreeSet: " + staffs.isEmpty());
		
		// Demo clear()
		staffs.clear();
		System.out.println("\nDemo clear() of TreeSet: " + staffs.size());
	}
	
	private static void runDemoCollections() {
		List<Staff> listStaffs = new ArrayList<Staff>(9); // ArrayList
		Staff staffTest = new Staff("Nguyen Van A", 20, "HCM");

		// Demo add(E e)
		listStaffs.add(new Staff("Nguyen Van A", 20, "HCM"));
		listStaffs.add(new Staff("Nguyen Van B", 18, "HN"));
		listStaffs.add(new Staff("Nguyen Van D", 23, "HCM"));
		listStaffs.add(new Staff("Nguyen Van E", 22, "GL"));
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo sort(List<T> list)
		Collections.sort(listStaffs);
		System.out.println("\nDemo sort of Collections: ");
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo reverse(List<T> list)
		Collections.reverse(listStaffs);
		System.out.println("\nDemo reverse of Collections: ");
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo shuffle(List<T> list)
		Collections.shuffle(listStaffs);
		System.out.println("\nDemo shuffle of Collections: ");
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
		
		// Demo binarySearch(List<? extends Comparable<? super T>> list, T key)
		System.out.println("\nDemo binarySearch of Collections: " 
		+ Collections.binarySearch(listStaffs, staffTest));
		
		// Demo replaceAll(List<T> list, T oldVal, T newVal)
		System.out.println("\nDemo replaceAll of Collections: ");
		Collections.replaceAll(listStaffs, staffTest, new Staff("Tran Van H", 23, "DN"));
		for (Staff staff : listStaffs) {
			System.out.println(staff.getFullname() + " - " 
			+ staff.getAge() + " - " + staff.getAddress());
		}
	}
	
	private static void runDemoProperties(){
		try {
			Path resourceDirectory = Paths.get("src","main","resources");
			String absolutePath = resourceDirectory.toFile().getAbsolutePath();
			FileReader fr = new FileReader(absolutePath + "\\properties\\Demo.properties");
			FileWriter fw;
			Properties properties = new Properties();
			
			// Demo Load(Reader r)
			properties.load(fr);
			fr.close();
			
			// Demo get(String key)
			System.out.println(properties.getProperty("username"));
			System.out.println(properties.getProperty("password"));
			
			// Demo set(String key)
			properties.setProperty("fullname", "Nguyen Van B");
			
			// Demo store(OutputStream os, String comment)
			fw =  new FileWriter(absolutePath + "\\properties\\Demo.properties");
			properties.store(fw, "Comment here");
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
		    // Get path resources
		    Path resourceDirectory = Paths.get("src", "main", "resources");
		    String absolutePath = resourceDirectory.toFile().getAbsolutePath();

		    // Create param work with file XML
		    File propertiesFile = new File(absolutePath + "\\properties\\DemoProperties.xml");
		    FileInputStream fis = new FileInputStream(propertiesFile);
		    File tempFile = new File(absolutePath + "\\properties\\DemoProperties_temp.xml");
		    FileOutputStream fos = new FileOutputStream(tempFile);
		    Properties properties = new Properties();
		    
		    // Read param from XML
		    properties.loadFromXML(fis);
		    fis.close();        // close FileInputStream
		    System.out.println("\nDemo read properties from XML: ");
		    System.out.println("username: " + properties.getProperty("username"));
		    System.out.println("username: " + properties.getProperty("password"));

		    // Write param to XML
		    properties.put("username", "admin1234");
		    
		    // Store into a XML
		    properties.storeToXML(fos, "Comment here");
		    fos.close();        // Close FileOutputStream

		    // Rename the temporary file to the original file
		    if (propertiesFile.exists()) {
		        propertiesFile.delete();
		    }
		    tempFile.renameTo(propertiesFile);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	private static void runDemoResourceBundle(){
		Locale localeEn = new Locale("en");
		Locale localeVi = new Locale("vi");
		ResourceBundle resourceBundle = ResourceBundle.getBundle("hello", localeEn);
		
		// Resource Bundle EN
		System.out.println("Xin chào trong tiếng anh: " + resourceBundle.getString("hello"));
		
		// Resource Bundle VI
		resourceBundle = ResourceBundle.getBundle("hello", localeVi);
		System.out.println("Xin chào trong tiếng việt: " + resourceBundle.getString("hello"));
	}
}
