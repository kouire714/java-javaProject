package ch05_referenceType.verificationProblem;

/*
 * Ch05 - 참조 타입
 * sec01 - 데이터 타입 분류
 * sec02 - 메모리 사용 영역
 * sec03 - 참조 타입 변수의 ==, != 연산
 * sec04 - null과 nullPointException
 * sec05 - 문자열(String) 타입
 * sec06 - 배열(Array) 타입
 * sec07 - 다차원 배열
 * sec08 - 객체를 참조하는 배열
 * sec09 - 배열 복사
 * sec10 - 배열 항목 반복을 위한 향상된 for문
 * sec11 - main() 메소드의 String[] 매개변수 용도
 * sec12 - 열거 타입
 */

public class Answer {
	public static void main(String[] args) {
		System.out.println("1. 4");
		System.out.println("2. 3");
		System.out.println("3. 2");
		System.out.println("4. 2");
		System.out.println("5. 3");
		System.out.println("6. 3, 5");
		
		// fail
		int[] array = { 1, 5, 3, 8, 2 };
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(array[i] > array[j]) {
					
				}
			}
		}
		System.out.println("7. ");
		
		// fail
		System.out.println("8. ");
		
		// fail
		System.out.println("9. ");
	}
}
