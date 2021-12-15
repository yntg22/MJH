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
		Map<String, Object> param = new HashMap<>();
			//아이디 중복 확인 생략 			
		/*
		 * 1.아이디 입력을 받는다
		 * 2.입력받은 아이디의 유효성검사를 실행한다.
		 * 3.유효성 검사를 통과하면 비밀번호를 입력받고
		 * 4.유효성 검사에 실패하면 다시 아이디를 입력받는다.
		 * 
		 *  * 아이디 입력을 다시 받고,
		 *    또 다시 받으려면?
		 *    
		 *    while(true){
		 *    id 입력 >
		 *    유효성검사 >
		 *    if ( 성공시 )
		 *     break; (while문을 빠져나간다.
		 *     else(실패시)
		 *        (아무것도 안하고 다시 실행
		 *      }
		 */
		
			String id = "";
			String password = "";	
			String name = "";
			String hp = "";
			String birth = "";
				
			/*
			 * 아이디를 입력받고,
			 * 쿼리로 아이디를 보내서
			 * select id where id = 입력받은 아이디
			 * 결과를 Map<String,Object>로 받아서
			 *	if( id.get("id") == null)
			 *체크후, null이면 패스
			 *값이 있으면 다시입력
			 *
			 *아이디를 입력받아서
			 *쿼리로 검색해서
			 *결과가 있으면 중복,
			 *없으면 패스
			 *
			*/
			
//			String pattern = "[a-z0-9_-]+";
			while(true) {
				System.out.println("아이디 입력>");
				id = ScanUtil.nextLine();
				
				
				Map<String,Object> check = userDao.idCheck(id);
//				if(id.matches(pattern)) {
					if(check == null) {
						System.out.println("사용 가능한 아이디 입니다.");
						break;

					} else {
						System.out.println("아이디가 중복되었습니다.");	
					}

//				} else {
//					System.out.println("올바른 아이디 형식이 아닙니다.");
//				}	
				
				
//				if(id.matches(pattern)) {
//					break;
//				} else {
//					System.out.println("올바른 아이디 형식이 아닙니다.");
//				}
//			}			
//		
//			
//			while(true) {
//				System.out.println("아이디 입력>");
//				id = ScanUtil.nextLine();
//				
//				Map<String,Object> check = userDao.idCheck(id);
//				if(check.get("M_ID") != null) {
//					System.out.println("아이디가 중복되었습니다.");
//
//				} else {
//					System.out.println("사용 가능한 아이디 입니다.");
//					break;
//				}
			}
			
			String pattern = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
			while(true) {
				
				System.out.println("숫자, 문자, 특수문자 포함 8~15자리 이내로 입력해주세요.");
				System.out.print("비밀번호>");
				password = ScanUtil.nextLine();
				if(password.matches(pattern)) {
				    break;
				} else { 
					System.out.println("올바른 비밀번호 형식이 아닙니다.");
				}
			}
			
			while(true) {
			System.out.print("다시 입력해 주세요>");
			String password2 = ScanUtil.nextLine();
			if(password.equals(password2)) {
				break;
			}else {
				System.out.println("입력하신 비밀번호와 일치하지 않습니다.");
				}
			}
		
			System.out.println("생년월일>");
			birth = ScanUtil.nextLine();
			
			System.out.println("이름>");
			name = ScanUtil.nextLine();
			
			System.out.println("전화번호>");
			hp = ScanUtil.nextLine();
			
			param.put("M_ID", id);
			param.put("M_PASS", password);
			param.put("M_NAME", name);
			param.put("M_HP", hp);
			param.put("M_BIR", birth);
			
			int result = userDao.insertMember(param);
			
			if(0 < result) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
			
		
			
		return 0;
		
		
			/*do {
			System.out.print("아이디>");
			String memId = ScanUtil.nextLine();
			String pattern = "^[a-zA-Z0-9]*$";
			if(memId.matches(pattern)) {
			    System.out.println("올바른 아이디 형식입니다.");
			} else {            
			    System.out.println("올바른 아이디 형식이 아닙니다.");
			    
			    continue;
			}
			
			System.out.println("숫자, 문자, 특수문자 포함 8~15자리 이내로 입력해주세요.");
			System.out.print("비밀번호>");
			pattern = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
			String password = ScanUtil.nextLine();
			if(password.matches(pattern)) {
			    System.out.println("올바른 비밀번호 형식입니다.");
			} else {            
			    System.out.println("올바른 비밀번호 형식이 아닙니다.");
			    continue;
			}

			System.out.print("다시 입력해 주세요>");
			String password2 = ScanUtil.nextLine();
			if(!password.equals(password2)) {
				System.out.println("입력하신 비밀번호와 일치하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
				continue;
			}
			
			System.out.print("생년월일>");
			String birthday = ScanUtil.nextLine();
			System.out.print("이름>");
			String memName = ScanUtil.nextLine();
			System.out.print("전화번호>");
			pattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
			String phonenum = ScanUtil.nextLine();
			if(phonenum.matches(pattern)) {
			    System.out.println("올바른 전화번호 형식입니다.");
			} else {            
			    System.out.println("올바른 전화번호 형식이 아닙니다.");
			    continue;
			}
			
			param.put("M_ID", memId);
			param.put("M_PASS", password);
			param.put("M_BIR", birthday);
			param.put("M_NAME", memName);
			param.put("M_HP", phonenum);
			
			int result = userDao.insertMember(param);
			
			if(0 < result) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
			
			return View.HOME;
			}while(true);
			
			
	*/
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
			
	
		}
		else { 
			System.out.println("로그인 성공");
			
			
			Controller.loginMember = member; //로그인한 사람 저장할 변수에 저장 (HashMap)
			System.out.println("회원번호 : "+Controller.loginMember.get("M_NO"));
			
			return View.USER_MAIN_SERVICE; //성공하면 게시판으로
		}
		
		return View.LOGIN; //실패하면 다시 로그인화면
	}
	
	
	public int adminlogin()	{
		System.out.println("=============== 로그인 ================");
		System.out.print("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		
		Map<String, Object> member = userDao.selectAdmin(memId, password);
		
		
		if(member == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			
		}else if(memId.equals("admin")) {
			Controller.loginMember = member;
			return View.R_TIME;
			
		}
		else { 
			System.out.println("로그인 성공");
			
			Controller.loginMember = member; //로그인한 사람 저장할 변수에 저장 (HashMap)
			
			
			return View.BOARD_LIST; //성공하면 게시판으로
		}
		
		return View.ADMIN_LOGIN; //실패하면 다시 로그인화면
	}
	
	
	
}
