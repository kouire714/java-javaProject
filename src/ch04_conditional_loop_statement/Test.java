package ch04_conditional_loop_statement;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
//		1.
		System.out.println("1---------------------------------");
//		2번
//		switch문에서 double타입은 사용할 수 없음
		
		
//		2.
		System.out.println("2---------------------------------");
		String grade = "B";

		int score1 = switch (grade) {
		case "A" -> 100;
		case "B" -> {
				int result = 100 - 20;
				yield result;
			}
		default -> 60;
		};

		System.out.println(score1);

//		3.
		System.out.println("3---------------------------------");		

		for(int i=1; i<100; i++) {
			int j = 0;
			while(j < 100) {
				j += 3;
				if(i==j) {
					System.out.println(i);
				}
			}
		}

//		4.
		System.out.println("4---------------------------------");
		while(true) {
			int i = (int)(Math.random()*6)+1;
			int j = (int)(Math.random()*6)+1;
			
			System.out.println(i + j);
			
			if(i + j == 5) {
				break;
			}
		}
		
//		5.
		System.out.println("5---------------------------------");
		
//		6.
		System.out.println("6---------------------------------");
		for(int i=0; i<5; i++) {
			for(int j=0; j<i+1; j++) {				
				System.out.print("*");
			}
			System.out.println();
		}
			
//		7.		
		System.out.println("7---------------------------------");
		int bankbook = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.println("선택>");
			String input = scanner.nextLine();
			
			int i = Integer.parseInt(input);
			
			if(i==1) {
				System.out.println("예금액>");
				String inputDeposit = scanner.nextLine();
				int deposit = Integer.parseInt(inputDeposit);
				bankbook += deposit;
			}
			
			if(i==2) {
				System.out.println("출금액>");
				String inputWithdraw = scanner.nextLine();
				int withdraw = Integer.parseInt(inputWithdraw);
				bankbook -= withdraw;
			}

			if(i==3) {
				System.out.println("잔고>" + bankbook);
			}
			
			if(i==4) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

}
