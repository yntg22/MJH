package dao;

public class AdminBoardDao {

	private AdminBoardDao() {}
	private static AdminBoardDao instance;
	public static AdminBoardDao getInstance() {
		if (instance == null) {
			instance = new AdminBoardDao();
		}
		return instance;
	}
}
