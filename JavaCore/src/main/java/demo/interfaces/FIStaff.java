package demo.interfaces;

import demo.entities.Staff;

@FunctionalInterface
public interface FIStaff {
	String execute(Staff staff);
}
