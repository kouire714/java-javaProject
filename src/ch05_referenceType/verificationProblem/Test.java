package ch05_referenceType.verificationProblem;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
//		1.
		System.out.println("1---------------------------------");
//		4번
//		참조 타입은 null값으로 초기화 할 수 있다.
		
//		2.
		System.out.println("2---------------------------------");
//		3번
//		참조되지 않은 객체는 자바에서 자동으로 제거한다.
		
//		3.
		System.out.println("3---------------------------------");
//		2번
//		문자열 비교는 .equals()메소드를 사용해 비교할 수 있다.
		
//		4.
		System.out.println("4---------------------------------");
//		2번
//		배열의 크기는 선언 이후 변경할 수 없다.
		
//		5.
		System.out.println("5---------------------------------");
//		3번
//		boolean 타입 배열 항목의 기본 초기값은 false다.
		
//		6.
		System.out.println("6---------------------------------");
//		3, 5
		
//		7.
		System.out.println("7---------------------------------");
		int val2 = 0;
		int[] array = { 1, 5, 3, 8, 2 };
		for(int i=0; i<array.length; i++) {
			int val = 0;
			val += array[i];
			for(int j=0; j<array.length; j++) {
				if(val<array[j]) {
					val2 = array[j];
				}
			}
		}
		System.out.println("array의 최대값 : " + val2);
		
//		8.
		System.out.println("8---------------------------------");
		int[][] array2 = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		int sum2 = 0;
		int avg = 0;
		for(int i=0; i<array2.length; i++) {
			sum += array2[i].length;
			for(int j=0; j<array2[i].length; j++) {
				sum2 += array2[i][j];
			}
		}
		avg = sum2 / sum;
		System.out.println("array2의 전체 합 : " + sum2);
		System.out.println("array2의 전체 평균 : " + avg);
		
//		9.
		System.out.println("9---------------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		String inputStdTot = null;
		int inputStdTotNum = 0;
		
		String stdScore = null;
		int stdScoreNum = 0;
		
		int[] allStdScore = null;
		
		int highScore = 0;
		int highScore2 = 0;
		
		int totScore = 0;
		int avgScore = 0;
		
		Label: while(true) {
				
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
	
			
			System.out.println("선택>");
			String inputData = scanner.nextLine();
			int inputDataNum = Integer.parseInt(inputData);
		
			switch(inputDataNum) {
			case 1:
				System.out.println("학생수>");
				inputStdTot = scanner.nextLine();
				inputStdTotNum = Integer.parseInt(inputStdTot);
				allStdScore = new int[inputStdTotNum];
				break;
			case 2:
				if(inputStdTot != null) {
					for(int i=0; i<inputStdTotNum; i++) {
						System.out.println("scores[" + i + "] :");
						stdScore = scanner.nextLine();
						stdScoreNum = Integer.parseInt(stdScore);
						allStdScore[i] = stdScoreNum;
					}
				} else {
					System.out.println("학생 수를 입력하세요.");
				}
				break;
			case 3:
				if(inputStdTot != null) {
					for(int i=0; i<inputStdTotNum; i++) {
						System.out.println("scores[" + (i + 1) + "] : " + allStdScore[i]);
					}
				} else {
					System.out.println("학생 수를 입력하세요.");
				}
				break;
			case 4:
				if(inputStdTot != null) {
					for(int i=0; i<allStdScore.length; i++) {
						highScore += allStdScore[i];
						for(int j=0; j<allStdScore.length; j++) {
							if(highScore<allStdScore[j]) {
								highScore2 = allStdScore[j];
							}
						}
					}
					
					for(int i=0; i<allStdScore.length; i++) {
						totScore += allStdScore[i];
					}
					
					avgScore = totScore / allStdScore.length;
					
					System.out.println("최고점수 : " + highScore2);
					System.out.println("평균점수 : " + avgScore);
				} else {
					System.out.println("학생 수를 입력하세요.");
				}
				break;
			case 5:
				System.out.println("프로그램 종료");
				break Label;
			}
		}
		
	}

}
