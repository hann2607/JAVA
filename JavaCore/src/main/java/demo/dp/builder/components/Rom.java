package demo.dp.builder.components;

public class Rom {
	private String name;
	private String type;
	private int memory;
	private String supplier;

	public Rom(String name, String type, int memory, String supplier) {
		super();
		this.name = name;
		this.type = type;
		this.memory = memory;
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}
