package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		String sql = "select * from cart"
				+ " where cart_member = ?"
				+ " and cart_qty > ?";
		
		ArrayList<Object> param = new ArrayList<>();
		param.add("a001");
		param.add(5);
		
		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		
		System.out.println(list);
	}

}
