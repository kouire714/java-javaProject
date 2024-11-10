package ch09.sec03.exam01;

public class A {

	public static class B {}
	
	//A k = new A();
	
	B field1 = new B();
	
	static B field2 = new B();
	
	A() {
		B b = new B();
	}
	
	void method1() {
		B b = new B();
	}
	
	static void method2() {
		B b = new B();
	}
	
}
