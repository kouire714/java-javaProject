package ch02_variable_type;

public class Type_conversion2 {
	public static void main(String[] args) {
		
		short ss1 = 10, ss2;
		int ii1 = 100, ii2, ii3=1000000;
		
//		ss1 = ii1;
		ii2 = ss1;
		System.out.println("ii2 = " + ii2);
		
		ss1 = (short)ii1;
		System.out.println("ss1 = " + ss1);
		
		ss2 = (short)ii3;
		System.out.println("ss2 = " + ss2);
		
	}
}
