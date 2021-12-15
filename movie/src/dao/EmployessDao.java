package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class EmployessDao {
	private EmployessDao() {}
	private static EmployessDao instance;
	public static EmployessDao getInstance() {
		if (instance == null) {
			instance = new EmployessDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	//직원 조회
	public List<Map<String, Object>> employess(){
		String sql = "Select EMP_NO, EMP_NAME, EMP_HP, EMP_POSITION"
				+ " From EMPLOYEES"
//				+ " LEFT OUTER JOIN EMPLOYEES B ON A.EMP_NO=B.EMP_NO"
				+ " ORDER BY EMP_NO" ;
		
		return jdbc.selectList(sql);
	}
	
	//신입직원 등록
	public int update(Map<String, Object> param) {
		String sql = "INSERT INTO EMPLOYEES"
				+ "     VALUES ("
				+ " (SELECT NVL(MAX(EMP_NO), 0) + 1 FROM EMPLOYEES)"
				+ " , ?, ?, ?, ?, ?, ?)";
		
		List<Object> p = new ArrayList<>();
		p.add(param.get("EMP_NAME"));
		p.add(param.get("EMP_HP"));
		p.add(param.get("EMP_SALARY"));
		p.add(param.get("EMP_POSITION"));
		p.add(param.get("EMP_ID"));
		p.add(param.get("EMP_PASS"));
		
		return jdbc.update(sql, p);
	}
	
	
	// 급여지급
	public Map<String, Object> pay(int empNo) {
		
		String sql = "SELECT EMP_SALARY FROM EMPLOYEES WNERE EMP_NO = ?";
		
		List<Object> p = new ArrayList<>();
		p.add(empNo);
		
		return jdbc.selectOne(sql);
	}
	
	
	// 직원 연락처 급여,부서 변경
	//부서
	public int insert(int empNo, String empPostion) {
		String sql = "UPDATE EMPLOYEES"
				+ "     SET EMP_POSITION = ?"
				+ "  WHERE EMP_NO = ?";
	
		List<Object> p = new ArrayList<>();
		p.add(empPostion);
		p.add(empNo);
		
		
		return jdbc.update(sql, p);
	}
	//연락처
	public int insert2(int empNo, String empHp) {
		String sql = "UPDATE EMPLOYEES"
				+ "     SET EMP_HP = ?"
				+ "  WHERE EMP_NO = ?";
	
		List<Object> p = new ArrayList<>();
		p.add(empHp);
		p.add(empNo);
		
		
		return jdbc.update(sql, p);
	}
	//급여
	public int insert3(int empNo, String empSalary) {
		String sql = "UPDATE EMPLOYEES"
				+ "     SET EMP_SALARY = ?"
				+ "  WHERE EMP_NO = ?";
	
		List<Object> p = new ArrayList<>();
		p.add(empSalary);
		p.add(empNo);
		
		
		return jdbc.update(sql, p);
	}
	
	
	// 직원 개별 조회
	public Map<String, Object> one(int empNo){
		String sql = "Select *"
				+ "      FROM EMPLOYEES"
				+ " WHERE EMP_NO = ?";
				
		List<Object> param = new ArrayList<>();
		param.add(empNo);
		
		return jdbc.selectOne(sql, param);
	}
	
	//퇴사직원 기록 삭제
	public int delete(int empNo) {
		String sql = "DELETE FROM EMPLOYEES WHERE EMP_NO";
		return jdbc.update(sql);
				
	}
	
	
	
}
