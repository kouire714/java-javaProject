package xDatabase;

public class InsaVO {
	private int idx;
	private String name;
	private int age;
	private String gender;
	private String ipsail;
	
	private String strYY;
	private String strMM;
	private String strDD;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIpsail() {
		return ipsail;
	}
	public void setIpsail(String ipsail) {
		this.ipsail = ipsail;
	}
	public String getStrYY() {
		return strYY;
	}
	public void setStrYY(String strYY) {
		this.strYY = strYY;
	}
	public String getStrMM() {
		return strMM;
	}
	public void setStrMM(String strMM) {
		this.strMM = strMM;
	}
	public String getStrDD() {
		return strDD;
	}
	public void setStrDD(String strDD) {
		this.strDD = strDD;
	}
	
	@Override
	public String toString() {
		return "InsaVO [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", ipsail=" + ipsail
				+ ", strYY=" + strYY + ", strMM=" + strMM + ", strDD=" + strDD + "]";
	}
}
