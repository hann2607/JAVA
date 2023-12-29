package demo.entities.prototype;

import java.util.Objects;

public abstract class Shape {
	private int x;
	private int y;
	private String color;

	public Shape() {
		super();
	}

	public Shape(Shape shape) {
		super();
		this.x = shape.x;
		this.y = shape.y;
		this.color = shape.color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract Shape clone();

	@Override
	public boolean equals(Object object2) {
		if (!(object2 instanceof Shape))
			return false;
		Shape shape2 = (Shape) object2;
		return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
	}
}
