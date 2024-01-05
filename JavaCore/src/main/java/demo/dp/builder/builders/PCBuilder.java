package demo.dp.builder.builders;

import demo.dp.builder.components.CPU;
import demo.dp.builder.components.Card;
import demo.dp.builder.components.Ram;
import demo.dp.builder.components.Rom;
import demo.dp.builder.computer.PC;

public class PCBuilder implements Builder{
	private String name;
	private CPU cpu;
	private Ram ram;
	private Rom rom;
	private Card card;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setCPU(CPU cpu) {
		this.cpu = cpu;
	}

	@Override
	public void setRam(Ram ram) {
		this.ram = ram;
	}

	@Override
	public void setRom(Rom rom) {
		this.rom = rom;
	}

	@Override
	public void setCard(Card card) {
		this.card = card;
	}

	public PC getResult() {return new PC(name, cpu, ram, rom, card);}
}
