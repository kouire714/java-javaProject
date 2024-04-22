package ch05_reference_type.sec04_null_NullPointerException;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
		int[] intArray = null;
//		intArray[0] = 10;	//NullPointerException
		
		String str = null;
//		System.out.println("총 문자 수: " + str.length() );	//NullPointerException
	}

}
