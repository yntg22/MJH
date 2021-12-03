package k_jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		String sql = "select * from cart"
				+ " where cart_member = ?"
				+ " and cart_qty > ?";
		
		ArrayList<Object> param = new ArrayList<>();
		param.add("a001");
		param.add(5);
		
		
		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		
		System.out.println(list);
		
		
//		String sql =  "delete from product"
//				+ " where prod_id= ?"
//				+ " and prod_name = ?";
//		ArrayList<Object> param = new ArrayList<>();
//		param.add("a00001");
//		param.add("asdf");		
//				
//		int result = 0;
//		
//		
//		
//		result = jdbc.update(sql,param);
//		System.out.println(result);
		
	}

}
