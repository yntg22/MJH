package kr.or.ddit.basic.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/*
	
	- Servlet 3.0 이상에서는 파일 업로드를 하려면 서블릿에 @MultipartConfig 어노테이션을
	   설정해야 한다.
	- @MultipartConfig 어노테이션에서 설정할 변수들...
	  1) location : 업로드한 파일이 임시적으로 저장될 경로 지정(기본값 : "")
	  2) fileSizeThreshold : 이 곳에 지정한 값보다 큰 파일이 전송되면 location에 지정한
	  						  임시 디렉토리에 저장한다. (단위 : byte, 기본값 : 0 (무조건 임시 디렉토리 사용)
	  3) maxFileSize : 1개 파일의 최대 크기 (단위 : byte, 기본값 : -1L(무제한)
	  4) maxRequestSize : 서버로 전송되는 request데이터 전체의 최대 크기
	  						(모든 파일 크기 + formData) (단위 : byte, 기본값 : -1L(무제한)
	  
	
*/


@WebServlet("/fileUploadServlet.do")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
	maxRequestSize = 1024 * 1024 * 100
		
)

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 저장될 폴더가 없으면 새로 만들어 놓는다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		// 파일이 아닌 일반 데이터는 getParameter() 메서드나 getParameterValues()메서드를
		// 이용해서 구한다.
		String userId = request.getParameter("userid");
		System.out.println("일반 파라미터 데이터 : " + userId);
		
		// --------------------------------------------------
		// 수신 받은 파일 데이터를 처리하기 
		String fileName = ""; // 파일명이 저장될 변수 선언
		
		// Upload한 파일 목록이 저장될 List객체 생성
		List<FileInfoVO> fileList = new ArrayList<>();
		
		/*
			- Servlet 3.0이상에서 새롭게 추가된 Upload용 메서드
			1) request.getParts() ==> 전체 Part객체를 Collection객체에 담아서 반환한다.
			2) request.getPart("이름"); ==> 지정된 '이름'을 가진 개별 Part객체를 반환한다.
							'이름' ==> form태그 안의 입력요소의 name속성값으로 구별한다.	
		*/
		
		// 전체 Part객체 개수만큼 반복처리
		for(Part part : request.getParts()) {
			fileName = extractFileName(part); //파일명 구하기
			
			// 찾은 파일명이 공백("")이면 이것은 파일이 아닌 일반 파라미터라는 의미이다.
			if(!"".equals(fileName)) { // 파일인지 검사
				//1개의 Upload파일에 대한 정보를 저장할 VO객체 생성
				FileInfoVO fvo = new FileInfoVO();
				fvo.setFileName(fileName);
				// part.getSize() ==> upload된 파일의 크기반환 (단위 : byte)
				fvo.setFileSize((long)(Math.ceil(part.getSize()/1024.0)));	
				try {
				// part.write()메서드 ==> upload된 파일을 저장하는 메서드
				part.write(uploadPath + File.separator + fileName); // 파일 저장
				fvo.setUploadStatus("success");
				}catch(IOException e) {
					fvo.setUploadStatus("fail : " + e.getMessage());
				}
				fileList.add(fvo); // upload된 파일 정보를 List에 추가
			}
		}
		
		// 업로드 완류 후 업로드 결과를 View페이지로 전달한다.
		request.setAttribute("userID", userId);
		request.setAttribute("fileList", fileList);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/basic/fileupload/uploadResult.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
	}
	
	// ---------------------------------------
	/*
	- Part 구조
	1) 파일이 아닌 일반 데이터일 경우
	------------35234sdaf1234 ==> Part를 구분하는 구분선
	content-disposition : form-data; name="userid" ==> 파라미터명
								==> 빈줄
	a001						==> 파라미터 값
	*/
	
	/*
	2) 파일일 경우
	------------35234sdaf1234 ==> Part를 구분하는 구분선
	content-disposition : form-data; name="upFile1"; filename="test1.txt" ==> 파일정보
	content-type : text/plain		==> 파일의 종류
									==> 빈줄
	abcd1234하이						==> 파일 내용
	*/
	
	// Part 구조안에서 파일명을 찾는 메서드
	private String extractFileName(Part part) {
		String fileName = "";
													//키 값을 주고 value를 구해오라는뜻
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=")+2,item.length()-1);
			}
		}
		
		
		
		return fileName;
	}
	
	
	
	

}

