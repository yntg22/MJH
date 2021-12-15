package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class AdminReBoardDao {

	private AdminReBoardDao() {}
	private static AdminReBoardDao instance;
	public static AdminReBoardDao getInstance() {
		if (instance == null) {
			instance = new AdminReBoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//문의 게시판 출력
	public List<Map<String, Object>> selectReBoardList(){
		String sql = "SELECT A.BOARD_NO,A.BOARD_TITLE,B.M_NAME,"
				         + " TO_CHAR(BOARD_DATE, 'MM-DD') AS BOARD_DATE"
				         + " , A.BOARD_RE" 
			   	   + "  FROM BOARD A" + 
				     "  LEFT OUTER JOIN MEMBER B ON A.M_NO=B.M_NO" + 
				     " ORDER BY A.BOARD_NO DESC"; 
		
		return jdbc.selectList(sql);
		}
	
	//문의게시판 조회
	public Map<String, Object> reBoard(int adminReBoardNo){
		String sql = "SELECT A.BOARD_NO,A.BOARD_TITLE,B.M_NAME," 
				          + " TO_CHAR(BOARD_DATE, 'MM-DD') AS BOARD_DATE "
				          + " ,A.BOARD_CONTENT" + 
				      "  FROM BOARD A" + 
				      "  LEFT OUTER JOIN MEMBER B ON A.M_NO=B.M_NO"
				     + " WHERE BOARD_NO = ?	"
				+ " ORDER BY A.BOARD_NO DESC";  
		
			List<Object> param = new ArrayList<>();
			param.add(adminReBoardNo);
		
		
		return jdbc.selectOne(sql, param);
	}
	
	//문의게시판 답변 등록
	public int reupdate(String typing, String ok, int adminReBoardNo) {
	  String sql = "UPDATE BOARD SET BOARD_CONTENT=BOARD_CONTENT||'\n'||?, BOARD_RE=? WHERE BOARD_NO=?";
	  
	  List<Object> p = new ArrayList<>();
	  p.add(typing);
	  p.add(ok);
	  p.add(adminReBoardNo);
	  return jdbc.update(sql, p);
  }
	
	
	//문의 게시판 삭제(제목과 내용을 변경해 버리기)
	public int delete (int adminReboardNo) {
		String sql = "UPDATE BOARD "
				+ " SET BOARD_TITLE = '비공개 게시물', "
				+ " BOARD_CONTENT = '운영원칙에 맞지 않는 내용을 포함하고 있기에\n\t운영진에 의해 삭제되었습니다.'"
				+ " WHERE BOARD_NO = ?";
			List<Object> p = new ArrayList<>();
			p.add(adminReboardNo);
			
		return jdbc.update(sql, p);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
