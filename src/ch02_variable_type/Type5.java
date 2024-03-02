package ch02_variable_type;

// 문자열의 표현
public class Type5 {
	public static void main(String[] args) {
		
		String name, job, address;
		name = "김말숙";
		job = "회사원";
		address = "청주";
		
		System.out.println("name+job+address : " + name + job + address);
		System.out.println("name+job+address : " + name + "는(은) " + job + "이고 " + address + "에 산다.");
		
		System.out.println();
		
		System.out.println("__는 __이고 __에 산다." );
		System.out.println(name + "는 " + job + "이고 " + address + "에 산다.");
		
		int age = 29;
		String sosok = "단독주택";
		
		// 내친구 홍길동은 25살 학생이며, 서울에 있는 아파트에 산다.
		System.out.println("내친구 "+name+"은 "+age+"살 "+job+"이며, "+address+"에 있는 "+sosok+"에 산다.");
		
	}
}
