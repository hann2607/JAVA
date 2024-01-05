package demo.dp.builder.components;

public class Card {
	private String name;
	private String supplier;

	public Card(String name, String supplier) {
		super();
		this.name = name;
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}
