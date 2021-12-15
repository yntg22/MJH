package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.EmployessDao;
import util.ScanUtil;
import util.View;

public class EmployeesService {
	private EmployeesService() {}
	private static EmployeesService instance;
	public static EmployeesService getInstance() {
		if (instance == null) {
			instance = new EmployeesService();
		}
		return instance;
	}
	private EmployessDao empDao = EmployessDao.getInstance();
	/* 직원채용, 직원배치, 직원급여, 직원상세사항...*/
	
	//전체직원조회
	public int employees() {
		List<Map<String, Object>> employeesList = empDao.employess();
		System.out.println("==============전체 직원 조회===============");
		System.out.println("직원번호\t이름\t전화번호\t\t직책");
		System.out.println("======================================");
		
		for(int i =  0; i < employeesList.size(); i++) {
			Map<String, Object> list = employeesList.get(i);
			System.out.print(list.get("EMP_NO") + "\t");
			System.out.print(list.get("EMP_NAME") + "\t");
			System.out.print(list.get("EMP_HP") + "\t");
			System.out.println(list.get("EMP_POSITION") + "\t");
		}
		System.out.println("======================================");
		System.out.println("1.신입직원등록 2.직원개별조회  9.로그아웃 0.목록 ");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			return View.EMPLOYEES_NEW;
		case 2:
			return View.EMPLOYEES_ONE;
		case 9:
			Controller.loginMember = null;
			return View.HOME;	
		case 0:
			return View.R_TIME;
				
				
		}
		return View.R_TIME;
	}	
	
	
		public static int empNo;
		//신입직원 등록
		public int boardUpdate() {
			System.out.println("------------ [ 새로운 글 등록하기 ]-------------");
			System.out.print("이름  >> ");
			String name = ScanUtil.nextLine();
			System.out.println("연락처 >> ");
			String hp = ScanUtil.nextLine();
			System.out.println("급여 >> ");
			String pay = ScanUtil.nextLine();
			System.out.println("직책 >> ");
			String positon = ScanUtil.nextLine();
			System.out.println("부여 아이디 >> ");
			String id = ScanUtil.nextLine();
			System.out.println("부여 비밀번호 >> ");
			String password = ScanUtil.nextLine();
			
			Map<String, Object> param = new HashMap<>();
			param.put("EMP_NAME", name);
			param.put("EMP_HP", hp);
			param.put("EMP_SALARY", pay);
			param.put("EMP_POSITION", positon);
			param.put("EMP_ID", id);
			param.put("EMP_PASS", password);
			
			
			int result = empDao.update(param);
			
			if (0 < result) {
				System.out.println("게시물 등록 완료");
			} else {
				System.out.println("게시물 등록 실패");
			}

			
			
			return View.EMPLOYEES_SYSTEM;
		}
		
		
		//급여 지급
		public int pay() {
//			System.out.println("급여 지급할 직원번호을 입력해주세요");
//			empNo = ScanUtil.nextInt(); 
//			
//			Map<String, Object> pay = empDao.one(empNo);
			System.out.println("급여를 지급하겠습니까? Y/N >> ");
			String choice = ScanUtil.nextLine();
			if(choice.equals("Y")||choice.equals("y")) {
				System.out.println("급여를 지급하였습니다.");
			}else {
				System.out.println("급여 지급에 실패하였습니다.");
			}
			
			return View.EMPLOYEES_SYSTEM;
		}
		
		
		
		
		
		
		//직원개별조회
		public int boardLook() {
			System.out.println("조회할 직원번호를 입력해주세요 >");
				// 게시물 100개 이상이면 switch-case썼을때 100개 만들어 줘야 해
				empNo = ScanUtil.nextInt();
				Map<String, Object> board = empDao.one(empNo);
				System.out.println("=====================================");
				System.out.println("사원번호 : " + board.get("EMP_NO"));
				System.out.println("사원명  : " + board.get("EMP_NAME"));
				System.out.println("연락처  : " + board.get("EMP_HP"));
				System.out.println("급여  : " + board.get("EMP_SALARY") );
				System.out.println("사원 직책 : " + board.get("EMP_POSITION"));
				System.out.println("=====================================");
				System.out.println("1.직원정보수정  2.급여지급  3.퇴사  9.로그아웃  0.목록  ");
				//수정은 연락처, 급여, 직책
				int input = ScanUtil.nextInt();
				switch(input) {
				case 1:
					return View.EMPLOYEES_INSERT;
				case 2:
					return View.EMPLOYEES_PAY;
				case 3:
					return View.EMPLOYEES_DELETE;
				case 9:
					Controller.loginMember = null;
					return View.HOME;	
				case 0:
					return View.EMPLOYEES_SYSTEM;	
				}
		
		
		return View.EMPLOYEES_SYSTEM;
	}
	
		//직원정보수정
		public int insert() {
			System.out.println("수정할 항목을 입력해주세요.");
			System.out.println("1.부서 및 직책\t2.연락처\t3.급여");
			int insert = ScanUtil.nextInt();
			if (insert == 1) {
				System.out.println("---------------[ 수정 해주세요 ]----------------");
				System.out.print("부서 및 직책>");
				String empPostion = ScanUtil.nextLine();

				int change = empDao.insert(empNo, empPostion);
				
				if(0 < change) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패ㅠㅠ");
					
				}
				
		
			} else if (insert == 2) {
				System.out.println("---------------[ 수정 해주세요]----------------");
				System.out.print("연락처 >");
				String empHp = ScanUtil.nextLine();

				int change = empDao.insert2(empNo, empHp);
				
				if(0 < change) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패ㅠㅠ");
					
				}

			} else if (insert == 3) {
				System.out.println("---------------[ 수정 해주세요]----------------");
				System.out.print("급여 >");
				String empSalary = ScanUtil.nextLine();
				

				int change = empDao.insert3(empNo, empSalary);
				
				if(0 < change) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패ㅠㅠ");
					
				}
			}
			return View.EMPLOYEES_LOOK;
		}
	
	
	//직원 퇴사
		public int delete() {
			System.out.println("삭제 할 유실물 번호를 입력해주세요");
			empNo = ScanUtil.nextInt();
			
			System.out.println("---------------[ 삭제 ]----------------");
			System.out.print("정말 삭제하시겠습니까?(Y/N)>");
			String delete = ScanUtil.nextLine();
			
			if(delete.equals("Y") ||delete.equals("y")) {
			int delete2 = empDao.delete(empNo);
							
			if(0 < delete2 ) {
				System.out.println("======== 삭제되었습니다.========");
			}else {
				System.out.println("삭제에 실패하였습니다.");
				}			
			}
			
			return View.EMPLOYEES_SYSTEM;
		}
	
	//수정 후 조회화면
		public int look() {
			Map<String, Object> board = empDao.one(empNo);
			System.out.println("=====================================");
			System.out.println("사원번호 : " + board.get("EMP_NO"));
			System.out.println("사원명  : " + board.get("EMP_NAME"));
			System.out.println("연락처  : " + board.get("EMP_HP"));
			System.out.println("급여  : " + board.get("EMP_SALARY") );
			System.out.println("사원 직책 : " + board.get("EMP_POSITION"));
			System.out.println("=====================================");
			return View.EMPLOYEES_SYSTEM;
		}
}	
	
	
	
	
	
	

