package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
클라이언트가 'd:/d_other/국화.jpg'파일을 서버로 전송하고
서버는 클라이언트가 보내온 파일을 받아서 'd:/d_other/upload/'폴더에 '국화.jpg'로 저장하는
네트우커ㅡ 프로그램을 작성하시오

클라이언트 => 파일을 읽어서 소켓으로 출력
서버 ==> 소케셍서 읽어서 파일로 출력
*/

public class TcpFileServer {

	private ServerSocket server;
	private Socket socket;
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
	private DataInputStream dis;
	
	public static void main(String[] args) {
		new TcpFileServer().serverStart();
	}

	private void serverStart() {
		// 저장할 폴더 정보를 갖는 File객체 생성
		File saveDir = new File("d:/d_other/upload"); 
		
		// 저장할 폴더가 없으면 새로 생성한다.
		if(!saveDir.exists()) {
			saveDir.mkdir();
		}
		
		try {
			server = new ServerSocket(7777);
			
			System.out.println("서버가 준비되었습니다...");
			
			socket = server.accept(); // 클라이언트의 요청을 기다린다.
			
			System.out.println("파일 다운로드 시작...");
			
			dis = new DataInputStream(socket.getInputStream());
						
			// 클라이언트가 처음으로 보낸 '파일명'을 받는다.
			String fileName = dis.readUTF();
			
			// 저장할 파일위치와 파일명을 지정하여 File객체 생성
			File saveFile = new File(saveDir, fileName);
			
			// 수신용 스트림 객체 생성
			bis = new BufferedInputStream(socket.getInputStream());
			
			// 파일 저장용 스트림 객체 생성
			bos = new BufferedOutputStream(new FileOutputStream(saveFile));
			
			byte[] temp = new byte[1024];
			int len = 0;
			// 소켓으로 읽어서 파일로 출력한다
			while((len=bis.read(temp)) > 0) {
				bos.write(temp, 0, len);
			}
			bos.flush();
			
			System.out.println("파일 다운로드 완료...");
			
			
		} catch (Exception e) {
			System.out.println("파일 다운로드 실패!!!");
			e.printStackTrace();
		} finally {
			if(dis != null) try { dis.close(); } catch (IOException e){}
			if(bis != null) try { bis.close(); } catch (IOException e){}
			if(bos != null) try { bos.close(); } catch (IOException e){}
			if(socket != null) try { socket.close(); } catch (IOException e){}
			if(server != null) try { server.close(); } catch (IOException e){}
		}
	}
	
	

}
