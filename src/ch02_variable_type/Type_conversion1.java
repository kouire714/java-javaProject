package ch02_variable_type;

// 자동 타입변환(promotion)
public class Type_conversion1 {
	public static void main(String[] args) {
		
		int su1 = 100;
		double su2 = 3.14;
		
		su1 = su1 + 200;
		System.out.println("su1 : " + su1);
		
//		su1 = su1 + su2;
		su2 = su1 + su2;
		System.out.println("su2 : " + su2);
		
		double res;
		
		res = su1 + su2;
		System.out.println("res : " + res);
		
		int atom;
		atom = 1 + 2 * 3;
		System.out.println("atom : " + atom);
		
		char cc1 = 'A';
		int res2 = cc1 + 1;
		System.out.println("res2 : " + res2);
		System.out.printf("res2 = %d\n", res2);
		System.out.printf("res2 = %c\n", res2);
		
		String ss1 = "안녕";
		String res3 = ss1 + 3 + "!!!!";
		System.out.println("res3 : " + res3);
		
		res3 = su1 + 100 + "";
		System.out.println("res3 : " + res3);
		
		res3 = "" + su1 + 100;
		System.out.println("res3 : " + res3);
		System.out.printf("res3 = %s\n", res3);
		
		double res4;
		res4 = 100;
		System.out.println("res4 : " + res4);
		
		res4 = 3.14 + 3.14;
		System.out.println("res4 : " + res4);
		System.out.printf("res4 = %f\n", res4);
		System.out.printf("res4 = %.2f\n", res4);
		System.out.printf("res4 = %8.2f\n", res4);
		System.out.printf("res3 = %s, res4 = %5.2f\n", res3, res4);
		System.out.printf("res3=%s\tres4=%5.2f\n", res3, res4);
		
	}
}
