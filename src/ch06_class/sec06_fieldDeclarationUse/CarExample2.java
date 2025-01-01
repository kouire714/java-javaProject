package ch06_class.sec06_fieldDeclarationUse;

public class CarExample2 {

	public static void main(String[] args) {
		//Car2 객체 생성
		Car2 myCar = new Car2();
		
		//Car2 객체의 필드값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.maxSpeed);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		
		//Car2 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도: " + myCar.speed);
	}

}
