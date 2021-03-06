package kr.or.ddit.basic.tcp;

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
	클라이언트가 'd:/d_other/국화.jpg'파일을 서버로 전송하고
	서버는 클라이언트가 보내온 파일을 받아서 'd:/d_other/upload/'폴더에 '국화.jpg'로 저장하는
	네트우커ㅡ 프로그램을 작성하시오
	
	클라이언트 => 파일을 읽어서 소켓으로 출력
	서버 ==> 소케셍서 읽어서 파일로 출력
*/

public class TcpFileClient {
	private Socket socket;
	//파일은 크기가 크니까 버퍼를 이용한다?
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
	
	//파일명을 위한 dataoutputstream
	private DataOutputStream dos;

	public static void main(String[] args) {
		new TcpFileClient().clientStart();

	}

	private void clientStart() {
		// 전송할 파일을 이용한 File객체 생성
//		File file = new File("d:/d_other/보노보노.jpg");
		File file = selectFile();
		
		if(file==null) {
			System.out.println("전송할 파일을 선택하지 않았습니다.");
			return;
		}
		
		String fileName = file.getName();
		
		if(!file.exists()) {
			System.out.println(fileName + " 파일이 없습니다...");
			return;
		}
		
		try {
			socket = new Socket("localhost", 7777);
			//접속 완료 후 
			System.out.println("파일 전송 시작...");
			
			// 전송할 파일의 이름을 전송하는 작업을 진행한다.
			// 서버에 접속하면 제일 먼저 파일명을 전송한다.
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(fileName);
			
			// 파일 데이터 전송하는 작업 진행하기
			
			// 파일 읽기용 스트림 객체 생성
			bis = new BufferedInputStream(new FileInputStream(file));
			
			// 서버로 전송할 스트림 객체 생성
			bos = new BufferedOutputStream(socket.getOutputStream());
			
			byte[] temp = new byte[1024];
			int len = 0;
			
			// 파일 내용을 읽어서 소켓으로 출력한다.
			while((len=bis.read(temp))>0) {
				bos.write(temp, 0, len);
			}
			bos.flush();
			System.out.println("파일 전송 완료...");
			
			
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!!");
			e.printStackTrace();
		} finally {
			// 사용했던 스트림과 소켓을 닫아준다.
			if(dos!=null) try {dos.close();} catch(IOException e) {}
			if(bos!=null) try {bos.close();} catch(IOException e) {}
			if(bis!=null) try {bis.close();} catch(IOException e) {}
			if(socket!=null) try {socket.close();} catch(IOException e) {}
		}
		
	}
	
	// 전송할 파일을 선택하고 선택한 파일 정보를 갖는 File객체를 반환하는 메서드
	private File selectFile() {
		// SWING의 파일 열기, 저장 창 연습
				JFileChooser chooser = new JFileChooser();
				
				// 선택할 파일의 확장자 설정
				FileNameExtensionFilter doc =
						new FileNameExtensionFilter("MS Word File", "docs", "doc");
				FileNameExtensionFilter img =
						new FileNameExtensionFilter("Image File", new String[] {"png", "jpg", "gif"});
				FileNameExtensionFilter txt =
						new FileNameExtensionFilter("Text File", "txt");
				
				chooser.addChoosableFileFilter(doc);
				chooser.addChoosableFileFilter(img);
				chooser.addChoosableFileFilter(txt);
				
				chooser.setFileFilter(txt); //확장자 목록 중에 기본적으로 선택될 확장자 지정
				
				// Dialog창이 나타낼 기본 경로 설정
				chooser.setCurrentDirectory(new File("d:/d_other"));
				
				int result = chooser.showOpenDialog(new Panel()); //열기용 창
//				int result = chooser.showSaveDialog(new Panel()); //저장용 창
				
				File seletedFile = null;
				
				// '저장' 또는 '열기' 버튼을 눌렀을 경우....
				if(result == JFileChooser.APPROVE_OPTION) {
					// 선택한 파일 정보 가져오기
					seletedFile = chooser.getSelectedFile();
//					System.out.println("선택한 파일 : " + seletedFile.getAbsolutePath());
				}
				return seletedFile;
	}
	
	
}
