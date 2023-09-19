package t8_sungjuk;

import java.util.Scanner;

public class SungjukRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SungjukService service = new SungjukService();
		
		boolean run = true;
		
		while(run) {
			System.out.println("\n\t**  성 적 표  **");
			System.out.print("메뉴선택?(1:입력  2:전체조회  3:개별조회  4:수정  5:삭제  0:종료) => ");
			int no = scanner.nextInt();
			
			switch (no) {
				case 1:		// 성적입력처리(중복처리)
					service.setInput();
					break;
				case 2:		// 전체조회처리
					service.setList();
					break;
				case 3:		// 개별조회처리
					service.setSearch();
					break;
				case 4:		// 성적수정처리
					//service.setUpdate();
					break;
				case 5:		// 성적삭제처리
					//service.setDelete();
					break;
				default:
					run = false;
			}
		}
		System.out.println("작업 종료!");
		
		scanner.close();
	}
}