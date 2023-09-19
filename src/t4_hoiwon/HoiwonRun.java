package t4_hoiwon;

import java.util.ArrayList;
import java.util.Scanner;

public class HoiwonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoiwonDAO dao = new HoiwonDAO();
		boolean run = true;
		String name = "";
		HoiwonVO vo = null;
		
		while(run) {
			System.out.print("1.전체조회  2:개별조회  3:수정  4:삭제  5:종료 ==> ");
			int no = scanner.nextInt();
			
			switch(no) {
				case 1:
					ArrayList<HoiwonVO> vos = dao.getList();		// 전체검색 호출
					
					System.out.println("\t\t** 주 소 록 **");
					System.out.println("=".repeat(38));
					System.out.println("번호\t성명\t나이\t주소\t성별");
					System.out.println("-".repeat(38));
//					for(HoiwonVO v : vos) {
//						System.out.print(v.getIdx() + "\t");
//						System.out.print(v.getName() + "\t");
//						System.out.print(v.getAge() + "\t");
//						System.out.print(v.getAddress() + "\t");
//						System.out.print(v.getGender());
//						System.out.println();
//					}
					vo = new HoiwonVO();
					for(int i=0; i<vos.size(); i++) {
						vo = vos.get(i);
						System.out.print(vo.getIdx() + "\t");
						System.out.print(vo.getName() + "\t");
						System.out.print(vo.getAge() + "\t");
						System.out.print(vo.getAddress() + "\t");
						System.out.print(vo.getGender());
						System.out.println();
					}
					System.out.println("=".repeat(38));
					System.out.println("총 회원 : "+vos.size()+" 명");
					
					break;
				case 2:		// 개별조회
					System.out.print("검색할 회원명을 입력하세요? => ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					
					vo = dao.getSearch(name);		// 개별검색 호출
					// if(vo != null) {	// vo값은 null값이 되지 않기에 왼쪽과 같이 비교하지 않는다.
					if(vo.getName() != null) {
						//System.out.println(vo);
						System.out.println("번호 : " + vo.getIdx());
						System.out.println("성명 : " + vo.getName());
						System.out.println("나이 : " + vo.getAge());
						System.out.println("주소 : " + vo.getAddress());
						System.out.println("성별 : " + vo.getGender());
					}
					else {
						System.out.println(name + "님 자료가 없습니다.");
					}
					break;
				case 3:  // 수정
					break;
				case 4:  // 삭제처리
					System.out.print("삭제할 회원명을 입력하세요? => ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					
					vo = dao.getSearch(name);	// 개별자료 검색
					if(vo.getName() == null) System.out.println(name + "님 자료가 없습니다.");
					else {
						dao.setDelete(name);
						System.out.println(name + "님 자료가 삭제되었습니다.");
					}
					
//					int res = dao.setDelete2(name);
//					System.out.println("res : " + res);
					
					break;
				default:
					run = false;
			}
			System.out.println("===========================================");
		}
		System.out.println("작업끝....");
		
		// DB conn객체 close
		dao.connClose();
		
		scanner.close();
	}
}
