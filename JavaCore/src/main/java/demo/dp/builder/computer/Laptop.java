package demo.dp.builder.computer;

import demo.dp.builder.components.CPU;
import demo.dp.builder.components.Card;
import demo.dp.builder.components.Ram;
import demo.dp.builder.components.Rom;

public class Laptop {
	private final String name;
	private final CPU cpu;
	private final Ram ram;
	private final Rom rom;
	private final Card card;

	public Laptop(String name, CPU cpu, Ram ram, Rom rom, Card card) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public CPU getCpu() {
		return cpu;
	}

	public Ram getRam() {
		return ram;
	}

	public Rom getRom() {
		return rom;
	}

	public Card getCard() {
		return card;
	}
	
	public String getType() {
		return "Name: " + name + ", CPU: " + cpu.getName() + ", RAM: " 
				+ ram.getName() + ", ROM: " + rom.getName() + ", CARD: " + card.getName();
	}
}
