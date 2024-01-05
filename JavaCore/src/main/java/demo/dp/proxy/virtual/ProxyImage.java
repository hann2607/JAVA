package demo.dp.proxy.virtual;

public class ProxyImage implements Image {
	private String url;
	private RealImage realImage;

	public ProxyImage(String url) {
		this.url = url;
	}

	@Override
	public void load() {
		if(realImage == null) {
			realImage = new RealImage(url);
		} else {
			System.out.println("Image existed!");
		}
		realImage.load();
	}
}
