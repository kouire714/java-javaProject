package t10_sale;

import java.util.List;
import java.util.Scanner;

public class ProductService {
	Scanner scanner = new Scanner(System.in);

	ProductDAO dao = new ProductDAO();
	ProductVO vo = null;
	String pName = "";
	int res = 0;
	String ans = "N";

//	public ProductService(ProductDAO dao) {
//		this.dao = dao;
//	}

	// 상품관리 주 메뉴
	public void getProductMenu() {
		boolean run = true;
		
		while(run) {
			System.out.print("\n1:상품등록  2:상품검색  3:상품리스트  4:삭제  5:종료 ==> ");
			int no = scanner.nextInt();
			
			switch (no) {
				case 1:
					productInput();
					break;
				case 2:
					productSearch();
					break;
				case 3:
					productList();
					break;
				case 4:
					productDelete();
					break;
				default:
					run = false;
			}
		}
		dao.connClose();
	}

	// 상품 삭제
	private void productDelete() {
		System.out.print("삭제할 상품명을 입력하세요? ");
		pName = scanner.next();
		vo = dao.getNameSearch(pName);
		
		if(vo.getpName() == null) System.out.println("==> 검색하신 상품이 없습니다.");
		else {
			res = dao.setProductDelete(vo.getIdx());
			if(res == 0) System.out.println("상품 삭제 실패~~");
			else System.out.println(pName + " 상품이 삭제되었습니다.");
		}
	}

	// 전체 상품 조회
	private void productList() {
		List<ProductVO> vos = dao.getProductList();
		
		System.out.println("\n*** 전체 상품 리스트 ***");
		System.out.println("================================");
		System.out.println("번호\t상품명\t상품가격");
		System.out.println("--------------------------------");
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			System.out.print(vo.getIdx() + "\t");
			System.out.print(vo.getpName() + "\t");
			System.out.print(vo.getPrice() + "\n");
		}
		System.out.println("--------------------------------");
		System.out.println("\t총 상품건수 : "+vos.size()+"건");
		System.out.println("================================");
	}

	// 상품 개별 검색
	private void productSearch() {
		System.out.print("검색할 상품명을 입력하세요? ");
		pName = scanner.next();
		vo = dao.getNameSearch(pName);
		
		if(vo.getpName() == null) System.out.println("==> 검색하신 상품이 없습니다.");
		else {
			System.out.println("상품고유번호 : " + vo.getIdx());
			System.out.println("상품명 : " + vo.getpName());
			System.out.println("상품가격 : " + vo.getPrice());
		}
	}

	// 상품 등록처리
	private void productInput() {
		while(true) {
			System.out.print("상품명을 입력하세요? ");
			pName = scanner.next();
			
			// 상품명 중복처리
			vo = dao.getNameSearch(pName);
			if(vo.getpName() != null) System.out.println("==> 동일한 상품이 존재합니다.");
			else {
				vo.setpName(pName);
				System.out.print("상품가격을 입력하세요? ");
				vo.setPrice(scanner.nextInt());
				res = dao.setProductInput(vo);
				if(res == 0) System.out.println("==> 상품 등록 실패~~");
				System.out.println("==> 상품이 등록되었습니다.");
				
				System.out.print("상품을 계속 등록하시겠습니까?(y/n) ");
				ans = scanner.next().toUpperCase();
				if(ans.equals("N")) break;
			}
		}
	}
	
	
}
