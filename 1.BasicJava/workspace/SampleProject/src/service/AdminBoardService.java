package service;

public class AdminBoardService {

	private AdminBoardService() {}
	private static AdminBoardService instance;
	public static AdminBoardService getInstance() {
		if (instance == null) {
			instance = new AdminBoardService();
		}
		return instance;
	}
}
