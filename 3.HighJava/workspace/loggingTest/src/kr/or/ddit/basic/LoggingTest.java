package kr.or.ddit.basic;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggingTest {
	
	// Logger 클래스의 인스턴스를 받아온다.
	static Logger logger = Logger.getLogger(LoggingTest.class);
	
	public static void main(String[] args) {
		// 로그 메시지 출력하기
		// 형식1) logger객체변수.로그레벨명("출력할 메시지")
		//		==>	로그레벨명은 소문자로 기술한다.
//		logger.trace("이것은 Log4j의 [TRACE]모드의 메시지이다.");
//		logger.debug("이것은 Log4j의 [debug]모드의 메시지이다.");
//		logger.info("이것은 Log4j의 [info]모드의 메시지이다.");
//		logger.warn("이것은 Log4j의 [warn]모드의 메시지이다.");
//		logger.error("이것은 Log4j의 [error]모드의 메시지이다.");
//		logger.fatal("이것은 Log4j의 [fatal]모드의 메시지이다.");
		
		// 형식2) Logger객체변수.log(Level.레벨명, "출력할메시지")
		//		==> 로그레벨명은 대문자로 기술한다.
		logger.log(Level.TRACE, "log()메서드를 이용한 [TRACE]모드 출력하기");
		logger.log(Level.DEBUG, "log()메서드를 이용한 [DEBUG]모드 출력하기");
		logger.log(Level.INFO, "log()메서드를 이용한 [INFO]모드 출력하기");
		logger.log(Level.WARN, "log()메서드를 이용한 [WARN]모드 출력하기");
		logger.log(Level.ERROR, "log()메서드를 이용한 [ERROR]모드 출력하기");
		logger.log(Level.FATAL, "log()메서드를 이용한 [FATAL]모드 출력하기");
		
		
	}

}
