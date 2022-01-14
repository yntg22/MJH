package dao;

import util.JDBCUtil;

public class MainWindowDao {

	private MainWindowDao() {}
	private static MainWindowDao instance;
	public static MainWindowDao getInstance() {
		if (instance == null) {
			instance = new MainWindowDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
}
