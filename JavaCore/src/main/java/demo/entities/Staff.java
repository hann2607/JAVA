package demo.entities;

import java.util.Objects;

public class Staff implements Comparable<Staff> {
	private String fullname;
	private Integer age;
	private String address;

	public Staff() {
		super();
	}

	public Staff(String fullname, Integer age, String address) {
		super();
		this.fullname = fullname;
		this.age = age;
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getAge() {
		return age;
	}

	public void setage(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Staff)) {
			return false;
		}
		Staff staff = (Staff) obj;
		return this.fullname == staff.getFullname() && this.age.equals(staff.getAge())
				&& this.address.equals(staff.getAddress());
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullname, age, address);
	}

	@Override
	public int compareTo(Staff otherStaff) {
		return this.fullname.compareTo(otherStaff.fullname);
	}

	public String[] toArray() {
		return new String[] { this.fullname, String.valueOf(this.age), this.address };
	}
}
