package demo.entities.singleton;

public class Computer{
	private static Computer instance;
	private String name;
	private String cpu;
	private String ram;

	private Computer() {
		super();
	}

	public static Computer getInstance() {
		if (instance == null) {
			synchronized (Computer.class) {
                if (instance == null) {
                    instance = new Computer();
                }
            }
		}
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
	
	public String displayInfo() {
		return "Name: " + this.name + "CPU: " + this.cpu + "RAM: " + this.ram;
	}
}
