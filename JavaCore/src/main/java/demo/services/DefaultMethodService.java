package demo.services;

import demo.interfaces.InterfaceDefaultMethod;

public class DefaultMethodService implements InterfaceDefaultMethod{

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public void printInt(int result) {
		System.out.println("Demo Override default Method: " + result);
	}
}
