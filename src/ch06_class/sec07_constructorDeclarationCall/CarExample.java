package ch06_class.sec07_constructorDeclarationCall;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car("그랜져", "검정", 250);
		//Car myCar = new Car();	//기본 생성자 호출 못함
	}

}
