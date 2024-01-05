package demo.dp.proxy.virtual;

public class DemoVirtualProxy {
	public static void main(String[] args) {
		ProxyImage proxyImage = new ProxyImage("https://dfstudio-d420.kxcdn.com/wordpress/"
				+ "wp-content/uploads/2019/06/digital_camera_photo-1080x675.jpg");
		
		System.out.println("First load: ");
		proxyImage.load();
		System.out.println("Seconds load: ");
		proxyImage.load();
	}
}
