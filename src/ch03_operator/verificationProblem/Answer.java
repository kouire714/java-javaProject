package ch03_operator.verificationProblem;

public class Answer {
	
	/*
	 * Ch03 - 연산자
	 * sec01 - 부호/증감 연산자
	 * sec02 - 산술 연산자
	 * sec03 - 오버플로우와 언더플로우
	 * sec04 - 정확한 계산은 정수 연산으로
	 * sec05 - 나눗셈 연산 후 NaN과 Infinity 처리
	 * sec06 - 비교 연산자
	 * sec07 - 논리 연산자
	 * sec08 - 비트 논리 연산자
	 * sec09 - 비트 이동 연산자
	 * sec10 - 대입 연산자
	 * sec11 - 삼항(조건) 연산자
	 * sec12 - 연산의 방향과 우선순위
	 */
	
	public static void main(String[] args) {
		System.out.println("1. 31");
		System.out.println("2. 가");
		
		int pencils = 534;
		int students = 30;
		int pencilsPerStudent = pencils / students;
		int pencilsLeft = pencils % students;
		System.out.println("3. " + pencilsPerStudent + " " + pencilsLeft);
		
		int value = 356;
		double result = value % 100;
		int result2 = value - (int)result;
		System.out.println("4. " + result + " " + result2);
//		A : value / 100 * 100
		
		System.out.println("5. 1, 2, 3");
//		fail
		
		int x = 10;
		int y = 5;
		boolean result3 = (x>7) && (y<=5);
		boolean result4 = (x%3 == 2) || (y%2 != 1);
		System.out.println("6. true, false");
		
		System.out.println("7. double.isNaN(z)");
	}
}
