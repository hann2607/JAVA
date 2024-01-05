package demo.dp.builder.builders;

import demo.dp.builder.components.CPU;
import demo.dp.builder.components.Card;
import demo.dp.builder.components.Ram;
import demo.dp.builder.components.Rom;

public interface Builder {
	void setName(String name);
	void setCPU(CPU cpu);
	void setRam(Ram ram);
	void setRom(Rom rom);
	void setCard(Card card);
}
