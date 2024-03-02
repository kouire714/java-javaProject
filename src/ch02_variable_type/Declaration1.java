package ch02_variable_type;

public class Declaration1 {
	
	public static void main(String[] args) {
		
		int iA;
		iA = 100;
		System.out.println("iA = " + iA + "\n");
		
		String sA = "Seoul";
		System.out.println("sA = " + sA);
		
		System.out.println();
		
		double dA = 3.14;
		System.out.println("dA = " + dA);
		
		System.out.println();
		
		System.out.println("iA=" + iA + " , sA=" + sA + " , dA=" + dA);
		System.out.println("iA=" + iA + "\nsA=" + sA + "\ndA=" + dA);
		System.out.println("iA=" + iA + "\tsA=" + sA + "\tdA=" + dA);
		
		int _su = 100;
		System.out.println("_su : " + _su);
		
		int $su = 100;
		System.out.println("$su : " + $su);
		
		// int 5su = 100;	// 변수명의 첫글자로 숫자가 올 수 없다.
		// int +su = 100;	// 변수명의 첫글자로 '_'과 '$'를 제외한 특수문자가 올수 없다.
		
		int 수1 = 100;
		System.out.println("수1 : " + 수1);
		
		int seoul_su1 = 100;
		int seoul_su2 = 200;
		
		int seoulSu3 = 300;
		int seoulSu4 = 400;
		
		// String seoulSu4 = "서울";	// 이미 선언된 변수는 다른 타입으로 사용할 수 없다.
		
		// int main = 100;			// 메소드명을 변수로 사용하는 경우는 특별한 경우를 제외하고는 사용하지 않는것이 관례다.
		// int if = 100;			// 예약어는 변수명으로 사용할 수 없다.
		
		int su5 = 200;
		
		int res = seoulSu4;
		System.out.println("res : " + res);
		
		int res2 = su5;
		System.out.println("res2 : " + res2);
		
	}
}
