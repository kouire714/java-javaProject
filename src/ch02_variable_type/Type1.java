package ch02_variable_type;

// 정수 자료형의 표현방법
public class Type1 {
	public static void main(String[] args) {
		
		byte bb;
		bb = 100;
		
		System.out.println("bb : " + bb);
		
		byte bb2 = 127;
//		byte bb3 = 128;
		System.out.println("bb2 : " + bb2);
		
		byte bb3 = -128;
//		byte bb4 = -129;
		System.out.println("bb3 : " + bb3);
		System.out.println();
		
		short ss1 = 128;		
		System.out.println("ss1 : " + ss1);
		
		short ss2 = -129;		
//		short ss3 = 33000;
		System.out.println("ss2 : " + ss2);
		System.out.println();
		
		int ii1 = 33000;
		System.out.println("ii1 : " + ii1);
		
		int ii2 = -33000;
		System.out.println("ii2 : " + ii2);
		System.out.println();
		
//		int ii3 = 2300000000;
		long ll1 = 2300000000L;
		System.out.println("ll1 : " + ll1);
		
	}
}
