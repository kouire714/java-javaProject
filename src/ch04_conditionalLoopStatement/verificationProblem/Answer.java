package ch04_conditionalLoopStatement.verificationProblem;

import java.util.Scanner;

public class Answer {

	/*
	 * Ch04 - 조건문과 반복문
	 * sec01 - 코드 실행 흐름 제어
	 * sec02 - if 문
	 * sec03 - switch 문
	 * sec04 - for 문
	 * sec05 - while 문
	 * sec06 - do-while 문
	 * sec07 - break 문
	 * sec08 - continue 문
	 */
	
	public static void main(String[] args) {
		System.out.println("1. 2");
		
		String grade = "B";
		int score1 = switch(grade) {
		case "A" -> 100;
		case "B" -> {
			int result = 100 - 20;
			yield result;
		}
		default -> 60;
		};
		System.out.println("2. " + score1);
		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			if(i%3 == 0) {
				sum += i;
			}
		}
		System.out.println("3. " + sum);
		
		while(true) {
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			int add = dice1 + dice2;
			if(add == 5) {
				System.out.println("dice1 : " + dice1 + " dice2 : " + dice2);
				System.out.println("4. 주사위의 합이 " + add + " 입니다.");
				break;
			}
			System.out.println("dice1 : " + dice1 + " dice2 : " + dice2);
			System.out.println("주사위의 합이 " + add + " 입니다.");
			System.out.println();
			
		}
		
		System.out.println("5.");
		// fail
		
		System.out.println("6.");
		// fail
		
		Scanner scanner = new Scanner(System.in);
		int balance = 0;
		while(true) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4. 종료");
			System.out.println("------------------------------");
			System.out.println("선택> ");
			String choice = scanner.nextLine();
			if(choice.equals("1")) {
				System.out.println("선택> 1");
				System.out.println("예금액> ");
				String depositString = scanner.nextLine();
				int deposit = Integer.parseInt(depositString);
				balance += deposit;
				System.out.println("예금되었습니다.");
			}
			if(choice.equals("2")) {
				System.out.println("선택> 2");
				System.out.println("출금액> ");
				String withDrawalString = scanner.nextLine();
				int withDrawal = Integer.parseInt(withDrawalString);
				balance -= withDrawal;
				System.out.println("출금되었습니다.");
			}
			if(choice.equals("3")) {
				System.out.println("선택> 3");
				System.out.println("잔고: " + balance);
			}
			if(choice.equals("4")) {
				System.out.println("선택> 4");
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		// try switch
	}

}
