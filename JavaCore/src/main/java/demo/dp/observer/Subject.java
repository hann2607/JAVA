package demo.dp.observer;

public interface Subject {
	void attach(Observer o);
	void detach(Observer o);
	void createImage(Message m);
}