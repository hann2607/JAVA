package demo.dp.proxy.virtual;

public class RealImage implements Image{

	private String url;
	
	public RealImage(String url) {
		this.url = url;
		System.out.println("Init");
	}
	
	@Override
	public void load() {
		System.out.println("Load from " + this.url);
	}
}
