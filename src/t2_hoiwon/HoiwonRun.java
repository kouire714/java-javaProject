package t2_hoiwon;

public class HoiwonRun {
	public static void main(String[] args) {
		HoiwonDAO dao = new HoiwonDAO();
		//HoiwonDAO2 dao = new HoiwonDAO2();
		//HoiwonDAO3 dao = new HoiwonDAO3();
		
		// hoiwon테이블의 전체 회원 조회....
		dao.getList();
		
		// DB conn 객체 clowe
		dao.connClose();
	}
}
