package ch02_variable_type;

public class Test2 {

	public static void main(String[] args) {
		int a1 = 100;
		int a2 = 00100;
		int b1 = 010;
		int c1 = 0x10;
		
		System.out.println("a1 : " + a1);
		System.out.println("a2 : " + a2);
		System.out.println("b1 : " + b1);
		System.out.println("c1 : " + c1);
		System.out.println();

		double d1 = 3.14;
		double d2 = 3E5;
		double d3 = 3E-2;
		System.out.println("d1 : " + d1);
		System.out.println("d2 : " + d2);
		System.out.println("d3 : " + d3);
		System.out.println();
		
		boolean l1 = true;
		boolean l2 = false;
		System.out.println("l1 : " + l1);
		System.out.println("l2 : " + l2);
		
	}

}
