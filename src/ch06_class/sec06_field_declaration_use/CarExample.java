package ch06_class.sec06_field_declaration_use;

public class CarExample {

	public static void main(String[] args) {
		//Car 객체 생성
		Car myCar = new Car();
		
		//Car 객체의 필드값 읽기
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.start);
		System.out.println("현재속도: " + myCar.speed);
	}
	
}
