package t6_hoiwon;

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
			System.out.print("1.전체조회  2:개별조회  3.회원가입  4:수정  5:삭제  6:종료 ==> ");
			int no = scanner.nextInt();
			
			switch(no) {
				case 1:
					ArrayList<HoiwonVO> vos = dao.getList();		// 전체검색 호출
					
					System.out.println("\t\t** 주 소 록 **");
					System.out.println("=".repeat(38));
					System.out.println("번호\t성명\t나이\t주소\t성별");
					System.out.println("-".repeat(38));
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
				case 3:  // 회원가입
					vo = new HoiwonVO();
					while(true) {
						System.out.print("회원 성명을 입력하세요? ");
						name =scanner.next();
						
						// 성명 중복 체크.....
						vo = dao.getSearch(name);		// 성명 중복체크
						if(vo.getName() == null) break;
						System.out.println("같은 이름이 존재합니다. 다시 입력하세요.");
					}
					vo.setName(name);
					System.out.print("회원 나이를 입력하세요? ");
					vo.setAge(scanner.nextInt());
					System.out.print("회원 주소를 입력하세요? ");
					vo.setAddress(scanner.next());
					System.out.print("회원 성별을 입력하세요?(1:남자, 2:여자) ");
					int gender = scanner.nextInt();
					if(gender == 1) vo.setGender("남자");
					else vo.setGender("여자");
					
					int res = dao.setHoiwonInput(vo);	// 회원가입메소드 호출
					
					if(res == 0) System.out.println("회원에 가입 실패~~");
					else System.out.println("회원에 가입 되셨습니다.");
					break;
				case 4:  // 수정
					System.out.print("수정할 회원명을 입력하세요? => ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					
					boolean flag = true;
					while(flag) {
						vo = dao.getSearch(name);	// 개별자료 검색
						if(vo.getName() == null) System.out.println(name + "님 자료가 없습니다.");
						else {
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("성명 : " + vo.getName());
							System.out.println("나이 : " + vo.getAge());
							System.out.println("주소 : " + vo.getAddress());
							System.out.println("성별 : " + vo.getGender());
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("수정할 항목의 번호를 입력하세요?");
							System.out.print("1:나이  2.주소  3.성별  4.수정종료 ==> ");
							no = scanner.nextInt();
							
							int age = vo.getAge();
							String address = vo.getAddress();
							String strGender = vo.getGender();
							
							switch(no) {
								case 1:
									System.out.print("수정할 나이를 입력하세요? ");
									age = scanner.nextInt();
									break;
								case 2:
									System.out.print("수정할 주소를 입력하세요? ");
									address = scanner.next();
									break;
								case 3:
									System.out.print("수정할 성별을 입력하세요?(1:남자 2:여자) ");
									gender = scanner.nextInt();
									if(gender == 1) strGender = "남자";
									else strGender = "여자";
									break;
								default:
									flag = false;
							}
							res = dao.setHoiwonUpdate(name,age,address,strGender);
							if(res == 0) System.out.println("수정 실패~~~");
							else System.out.println(name + "님 자료가 수정되었습니다.");
						}
					}
					break;
				case 5:  // 삭제처리
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
