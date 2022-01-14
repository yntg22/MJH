package kr.or.ddit.mvc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;


public class MemberDaoImpl implements IMemberDao{
	private SqlMapClient smc; // ibatis를 사용하기 위해 SqlMapClinet객체 변수 선언
	
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() {
		// ibatis의 사용 환경을 구성하고 객체 생성
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("mymember.insertMember",memVo);
			if(obj == null) {
				cnt = 1;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("mymember.deleteMember",memId);	
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}	
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mymember.updateMember",memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = new ArrayList<>();
		try {
			
			memList = smc.queryForList("mymember.getAllMember");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int count = 0; 
		try {
			count = (int) smc.queryForObject("mymember.getMemberCount",memId);

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return count;
	}
	
	@Override
	   public int updateMember2(Map<String, String> paramMap) {
	     
	      int cnt= 0;
	      
	      try {
	    	  cnt = smc.update("mymember.updateMember2",paramMap);
	 
		} catch (SQLException e) {
			// TODO: handle exception
		}
	      return cnt;
	   }
	
}
