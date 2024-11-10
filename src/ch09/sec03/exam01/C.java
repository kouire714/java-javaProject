package ch09.sec03.exam01;

public class C {

	public static void main(String[] args) {
		A d = new A();
		
		System.out.println(d.field1);
		
//		System.out.println(A.B);
		
		A.B e = new A.B();
		
		System.out.println(e);
		
		System.out.println(A.field2);
	}

}
