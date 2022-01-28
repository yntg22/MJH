package kr.or.ddit.basic.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadedFileList
 */
@WebServlet("/uploadedFileList.do")
public class UploadedFileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 upload폴더에 저장된 파일 목록을 만들어서 View로 보내는 Servlet
		*/
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
				
		// 저장될 폴더가 없으면 새로 만들어 놓는다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		// 파일이 저장된 폴더에서 파일 목록을 구해와서 List에 담아준다.
		List<FileInfoVO> fileList = new ArrayList<>();
		
		//폴더안의 파일목록을 가져온다 배열에?
		File[] allFiles = f.listFiles(); // 전체 파일 목록 구하기
		for(File file : allFiles) {
			if(file.isFile()) {
				FileInfoVO fvo = new FileInfoVO();
				fvo.setFileName(file.getName()); // 파일명
				fvo.setFileSize((long)(Math.ceil(file.length()/1024.0)));
				fvo.setUploadStatus("success");
				fileList.add(fvo);
			}
		}
		
		// 만들어진 파일 목록 정보를 View페이지로 보낸다.
		request.setAttribute("fileList", fileList);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/basic/fileupload/uploadResult.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
