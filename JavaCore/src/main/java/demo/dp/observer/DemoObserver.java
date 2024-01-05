package demo.dp.observer;

public class DemoObserver {
	public static void main(String[] args) {
		MessageSubscriberOne s1 = new MessageSubscriberOne();
		MessageSubscriberTwo s2 = new MessageSubscriberTwo();
		MessageSubscriberThree s3 = new MessageSubscriberThree();
		MessagePublisher publisher = new MessagePublisher();
		
		publisher.attach(s1);
		publisher.attach(s2);
		System.out.println("First create:");
		publisher.createImage(new Message("Image created successfully!"));
		
		publisher.detach(s1);
		publisher.attach(s3);
		System.out.println("\nSeconds create:");
		publisher.createImage(new Message("Image created successfully!"));
	}
}
