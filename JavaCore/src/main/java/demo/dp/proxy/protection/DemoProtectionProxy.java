package demo.dp.proxy.protection;

public class DemoProtectionProxy {
	public static void main(String[] args) {
        UserService admin = new UserServiceProxy("admin", "admin");
        admin.load();
        admin.insert();
 
        UserService customer = new UserServiceProxy("customer", "guest");
        customer.load();
        customer.insert();
    }
}
