package demo.dp.builder.director;

import demo.dp.builder.builders.Builder;
import demo.dp.builder.components.CPU;
import demo.dp.builder.components.Card;
import demo.dp.builder.components.Ram;
import demo.dp.builder.components.Rom;

public class Director {
	public void constructPC(Builder builder) {
		builder.setName("Asus");
		builder.setCPU(new CPU("I9", "Intel", "Intel"));
		builder.setRam(new Ram("DDR5 32GB (2x16GB) 5200MHz", "DDR5", 16, "Asus"));
		builder.setRom(new Rom("Kingston SSD 512GB", "SSD", 512, "Kingston"));
		builder.setCard(new Card("GTX 1650", "Nvidia"));
	}
	
	public void constructLaptop(Builder builder) {
		builder.setName("MSI Bravo 15");
		builder.setCPU(new CPU("Ryzen 5", "AMD", "AMD"));
		builder.setRam(new Ram("DDR4 16GB 3200MHz", "DDR4", 16, "Kingston"));
		builder.setRom(new Rom("Kingston SSD 512GB", "SSD", 512, "Kingston"));
		builder.setCard(new Card("Radeon RX 5300M", "AMD"));
	}
}
