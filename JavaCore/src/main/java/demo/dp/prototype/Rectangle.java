package demo.dp.prototype;

public class Rectangle extends Shape {
	private int height;
	private int width;

	public Rectangle(Rectangle rectangle) {
		super(rectangle);
		this.height = rectangle.height;
		this.width = rectangle.width;
	}

	public Rectangle() {
		super();
	}

	@Override
	public Shape clone() {
		return new Rectangle(this);
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }
}
