package service;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import dao.UserDao;
import util.ScanUtil;
import util.View;

public class UserService {
	
	//싱글톤 패턴
	private UserService() {}
	private static UserService instance;
	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	private UserDao userDao = UserDao.getInstance();
	
	public int join() {
		System.out.println("============= 회원가입 ==============");
		System.out.print("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password= ScanUtil.nextLine();
		System.out.print("이름>");
		String memName = ScanUtil.nextLine();
		//아이디 중복 확인 생략 
		//비밀번호 확인 생략 //두번입력받아서 확인하는것
		//유효성 검사(정규표현식) 생략 //아디비번 둘다
		Map<String, Object> param = new HashMap<>();
		param.put("M_NO", 1);
		param.put("M_ID", memId);
		param.put("M_PASS", password);
		param.put("M_NAME", memName);
		param.put("M_HP", "01012341234");
	
		
		int result = userDao.insertMember(param);
		
		if(0 < result) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		return View.HOME;
	}
	
	public int login()	{
		System.out.println("=============== 로그인 ================");
		System.out.print("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		
		Map<String, Object> member = userDao.selectMember(memId, password);
		
		if(member == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else { 
			System.out.println("로그인 성공");
			
			Controller.loginMember = member; //로그인한 사람 저장할 변수에 저장 (HashMap)
			
			return View.USER_TIKETING; //성공하면 게시판으로
		}
		
		return View.LOGIN; //실패하면 다시 로그인화면
	}
}
