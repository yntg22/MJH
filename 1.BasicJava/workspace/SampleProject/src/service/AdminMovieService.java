package service;

import controller.Controller;
import dao.AdminMovieDao;
import dao.BoardDao;
import util.ScanUtil;
import util.View;

public class AdminMovieService {

	private AdminMovieService() {}
	private static AdminMovieService instance;
	public static AdminMovieService getInstance() {
		if (instance == null) {
			instance = new AdminMovieService();
		}
		return instance;
	}
	
	
}
