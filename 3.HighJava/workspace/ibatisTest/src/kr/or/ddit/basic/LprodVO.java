package kr.or.ddit.basic;

//	변수명 == 컬럼이름
// 달라도 괜찮지만 똑같아야 알아서 맞춰서 들어감
// 그렇지 않으면 직접 매핑해줘야함?
// +소문자로 쓴다

public class LprodVO {
	private int lprod_id;
	private String lprod_nm;
	private String lprod_gu;
	
	public int getLprod_id() {
		return lprod_id;
	}
	public void setLprod_id(int lprod_id) {
		this.lprod_id = lprod_id;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
	public String getLprod_gu() {
		return lprod_gu;
	}
	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}
	
	
}
