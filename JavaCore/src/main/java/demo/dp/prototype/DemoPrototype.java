package demo.dp.prototype;

public class DemoPrototype {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		
		rectangle.setX(5);
        rectangle.setY(10);
        rectangle.setHeight(15);
        rectangle.setHeight(20);
        rectangle.setColor("red");
        
        Rectangle anotherRectangle = (Rectangle) rectangle.clone();
        System.out.println("Rectangle: " + rectangle);
        System.out.println("anotherRectangle: " + anotherRectangle);
        System.out.println("equals: " + rectangle.equals(anotherRectangle));
	}
}
