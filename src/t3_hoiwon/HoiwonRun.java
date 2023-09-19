package t3_hoiwon;

import java.util.Scanner;

public class HoiwonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//HoiwonDAO dao = new HoiwonDAO();
		HoiwonDAO2 dao = new HoiwonDAO2();
		boolean run = true;
		
		while(run) {
			System.out.print("1.전체조회  2:개별조회  3:종료 ==> ");
			int no = scanner.nextInt();
			
			switch(no) {
				case 1:
					dao.getList();
					break;
				case 2:
					System.out.print("검색할 회원명을 입력하세요? => ");
					String name = scanner.next();
					dao.getSearch(name);
					break;
				default:
					run = false;
			}
			System.out.println("==========================");
		}
		System.out.println("작업끝....");
		
		// DB conn객체 close
		dao.connClose();
		
		scanner.close();
	}
}
