package t10_sale;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleService {
	Scanner scanner = new Scanner(System.in);

	//ProductDAO dao = null;
	SaleDAO dao = new SaleDAO();
	ProductVO pVo = null;
	SaleVO sVo = null;
	
	String pName = "";
	int res = 0;
	String ans = "N";
	
	// 판매관리 주 메뉴
	public void getSaleMenu() {
		boolean run = true;
		
		while(run) {
			System.out.print("\n1:판매내역등록  2:상품검색  3:날짜검색  4:판매내역리스트  5:삭제  6:종료 ==> ");
			int no = scanner.nextInt();
			
			switch (no) {
				case 1:
					saleInput();		// 판매내역 등록하기
					break;
				case 2:
					saleSearch();		// 판매상품 검색하기
					break;
				case 3:
					saleDateSearch();	// 판매 일자별 검색
					break;
				case 4:
					saleList();				// 전체 판매내역 검색
					break;
				case 5:
					//saleDelete();
					break;
				default:
					run = false;
			}
		}
		dao.connClose();
	}

	// 전체 판매내역 검색
	private void saleList() {
		ArrayList<SaleVO> vos = dao.getSaleList();
		
		System.out.println("\n*** 판매상품 리스트(전체)연습용 ***");
		System.out.println("=====================================");
		System.out.println("번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-------------------------------------");
		for(int i=0; i<vos.size(); i++) {
			sVo = vos.get(i);
			System.out.print(sVo.getIdx() + "\t");
			System.out.print(sVo.getpName() + "\t");
			System.out.print(sVo.getEa() + "\t");
			System.out.print((sVo.getSalePrice() * sVo.getEa()) + "\t");
			System.out.print(sVo.getpDate().substring(0,10) + "\n");
		}
		System.out.println("-------------------------------------");
		System.out.println("\t총 판매상품건수 : "+vos.size()+"건");
		System.out.println("=====================================");
	}

	// 판매 일자별 검색
	private void saleDateSearch() {
		System.out.print("검색할 판매일자를 입력하세요? ");
		String pDate = scanner.next();
		ArrayList<SaleVO> vos = dao.getSaleDateSearch(pDate);
		
		System.out.println("\n*** 판매상품 리스트(일자별) ***");
		System.out.println("=====================================");
		System.out.println("번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-------------------------------------");
		for(int i=0; i<vos.size(); i++) {
			sVo = vos.get(i);
			System.out.print(sVo.getIdx() + "\t");
			System.out.print(sVo.getpName() + "\t");
			System.out.print(sVo.getEa() + "\t");
			System.out.print((sVo.getSalePrice() * sVo.getEa()) + "\t");
			System.out.print(sVo.getpDate().substring(0,10) + "\n");
		}
		System.out.println("-------------------------------------");
		System.out.println("\t총 판매상품건수 : "+vos.size()+"건");
		System.out.println("=====================================");
	}

	// 판매상품 검색
	private void saleSearch() {
		System.out.print("검색할 판매상품명을 입력하세요? ");
		pName = scanner.next();
		ArrayList<SaleVO> vos = dao.getSaleNameSearch(pName);
		
		System.out.println("\n*** 판매상품 리스트(판매상품별) ***");
		System.out.println("=====================================");
		System.out.println("번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-------------------------------------");
		for(int i=0; i<vos.size(); i++) {
			sVo = vos.get(i);
			System.out.print(sVo.getIdx() + "\t");
			System.out.print(sVo.getpName() + "\t");
			System.out.print(sVo.getEa() + "\t");
			System.out.print((sVo.getSalePrice() * sVo.getEa()) + "\t");
			System.out.print(sVo.getpDate().substring(0,10) + "\n");
		}
		System.out.println("-------------------------------------");
		System.out.println("\t총 판매상품건수 : "+vos.size()+"건");
		System.out.println("=====================================");
	}

	// 판매내역등록
	private void saleInput() {
		while(true) {
			System.out.print("판매상품명을 입력하세요? ");
			pName = scanner.next();
			
			// 판매상품이 상품테이블에 등록된 상품인지 검색
		  pVo = dao.getNameSearch(pName);
			if(pVo.getpName() == null) System.out.println("==> 등록된 상품이 아닙니다.");
			else {
				sVo = new SaleVO();
				sVo.setpName(pName);
				System.out.print("판매수량을 입력하세요? ");
				sVo.setEa(scanner.nextInt());
				System.out.print("판매날짜(년(yyyy)-월-일)를 입력하세요? ");
				sVo.setpDate(scanner.next());
				res = dao.setSaleInput(sVo);
				if(res == 0) System.out.println("==> 판매상품 등록 실패~~");
				System.out.println("==> 판매상품이 등록되었습니다.");
				
				System.out.print("상품을 계속 등록하시겠습니까?(y/n) ");
				ans = scanner.next().toUpperCase();
				if(ans.equals("N")) break;
			}
		}
	}
}
