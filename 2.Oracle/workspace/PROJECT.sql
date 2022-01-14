SELECT 티켓번호 FROM 티켓 A , 상영정보 B, 상영관 C, 좌석 D, 예약좌석 F,
WHERE B.상영정보=A.상영정보
   AND B.상영관번호=C.상영관번호
   AND C.상영관번호=D.상영관번호
   AND A.티켓번호=F.좌석번호
   --이렇게하면 예약되어있는 좌석번호를 알 수 있다?
   
   SELECT
   --아이디
   INSERT INTO MEMBER VALUES(1,'진홍',SYSDATE,010,0,'admin','1234');
   --결제방법
   INSERT INTO PAYMENT VALUES('1','현금');
   
   INSERT INTO BOOKING VALUES('1',136,500);
   
   --티켓
   INSERT INTO RESERVATION VALUES(1,4,1,'1',1,1,SYSDATE);
   
   --티켓정보조회 / 예약한 좌석까지
   SELECT *
   FROM RESERVATION A, BOOKING B
   WHERE A.T_NO = 1
     AND A.T_NO = B.T_NO;
   
   --예약된좌석
   SELECT F.SEAT_NO
   FROM RESERVATION A, R_TIME B, SCREEN C, SEAT D, BOOKING F
   WHERE A.TIME_NO=B.TIME_NO
     AND B.SC_NO=C.SC_NO
     AND C.SC_NO=D.SC_NO
     AND A.T_NO=F.T_NO
     GROUP BY F.SEAT_NO;
     
   SELECT SEAT_NO
   FROM BOOKING 
   LEFT OUTER JOIN
     
    SELECT B.T_NO,B.TIME_NO,A.SEAT_NO
    FROM BOOKING A
    LEFT OUTER JOIN RESERVATION B ON RESERVATION.T_NO=BOOKING.T_NO;
    
    SELECT F.SEAT_NO
   FROM RESERVATION A, R_TIME B, SCREEN C, SEAT D, BOOKING F
   WHERE A.TIME_NO=B.TIME_NO
     AND B.SC_NO=C.SC_NO
     AND C.SC_NO=D.SC_NO
     AND A.T_NO=F.T_NO;
    --LEFT OUTER JOIN
    
    --예약이 없는 좌석만 검색하는 쿼리인데..
    SELECT C.SEAT_NO,C.SEAT_NAME
    FROM R_TIME A,SCREEN B, SEAT C
    WHERE A.TIME_NO = 4
      AND A.SC_NO = B.SC_NO
      AND B.SC_NO = C.SC_NO
      AND C.SEAT_NO != (SELECT F.SEAT_NO
          FROM RESERVATION A
          LEFT OUTER JOIN R_TIME B ON A.TIME_NO=B.TIME_NO
          LEFT OUTER JOIN SCREEN C ON B.SC_NO=C.SC_NO
          LEFT OUTER JOIN SEAT D ON C.SC_NO=D.SC_NO
          LEFT OUTER JOIN BOOKING F ON A.T_NO=F.T_NO
          GROUP BY F.SEAT_NO);
          
          
          SELECT *
            FROM R_TIME A, SCREEN B, MOVIE C
            WHERE A.TIME_NO = 4
              AND A.SC_NO=B.SC_NO
              AND A.MOVIE_NO=C.MOVIE_NO
    
    SELECT
     A.SEAT_NO,
     CASE WHEN A.SEAT_NO = (SELECT A.SEAT_NO FROM BOOKING A LEFT OUTER JOIN RESERVATION B ON B.T_NO=A.T_NO)
                                THEN A.SEAT_NAME||'■'
                                ELSE A.SEAT_NAME
                                END AS SEAT_NAME,
                  A.SEAT_CHARGE
                  
				  FROM SEAT A, (SELECT SC_NO FROM SCREEN WHERE SC_NAME = '4상영관')B
				 WHERE A.SC_NO=B.SC_NO
				 ORDER BY A.SEAT_NAME;
                
                
                
    SELECT C.SEAT_NO,C.SEAT_NAME
    FROM R_TIME A,SCREEN B, SEAT C
    WHERE A.TIME_NO = 4
      AND A.SC_NO = B.SC_NO
      AND B.SC_NO = C.SC_NO
      AND C.SEAT_NO != (SELECT F.SEAT_NO
          FROM RESERVATION A
          LEFT OUTER JOIN R_TIME B ON A.TIME_NO=B.TIME_NO
          LEFT OUTER JOIN SCREEN C ON B.SC_NO=C.SC_NO
          LEFT OUTER JOIN SEAT D ON C.SC_NO=D.SC_NO
          LEFT OUTER JOIN BOOKING F ON A.T_NO=F.T_NO
          GROUP BY F.SEAT_NO);
          
          예약된좌석을 검색하려면..
          부킹의 좌석번호로 상영관번호와 상영정보를 알아내?
          
          SELECT BOOKING 
          
          SELECT  A.SEAT_NO,
                 CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO FROM BOOKING A 
                                             LEFT OUTER JOIN RESERVATION B ON B.T_NO=A.T_NO
                                             LEFT OUTER JOIN R_TIME C ON C.TIME_NO = 5 AND C.TIME_NO=B.TIME_NO
                                             LEFT OUTER JOIN SCREEN D ON C.SC_NO = D.SC_NO)
		 		                               THEN A.SEAT_NAME||'■'
		 		                                ELSE A.SEAT_NAME||'□'
                                            END AS SEAT_NAME,
		 		                 A.SEAT_CHARGE
            				  FROM SEAT B, (SELECT A.SC_NO,C.SEAT_NO,C.SEAT_NAME,C.SEAT_CHARGE  FROM SCREEN A, R_TIME B, SEAT C WHERE B.TIME_NO = 5 AND B.SC_NO = A.SC_NO AND A.SC_NO=C.SC_NO)A
            				 WHERE A.SC_NO=B.SC_NO
		 					 GROUP BY A.SEAT_NO, A.SEAT_NAME, A.SEAT_CHARGE
                             ORDER BY A.SEAT_NO
                             
                             
                             " SELECT CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO FROM BOOKING A,RESERVATION B,R_TIME C, SCREEN D,SEAT E WHERE B.TIME_NO=?   AND B.TIME_NO=C.TIME_NO  AND C.SC_NO = D.SC_NO    AND D.SC_NO = E.SC_NO     AND A.SEAT_NO = E.SEAT_NO   GROUP BY A.SEAT_NO)"+							
		 		"                                THEN A.SEAT_NAME||'■'" + 
		 		"                                ELSE A.SEAT_NAME||'□'" + 
		 		"                                END AS SEAT_NAME," + 
		 		"                  A.SEAT_CHARGE" + 
		 		"				  FROM SEAT A, SCREEN B, R_TIME C, RESERVATION D" + 
		 		"				 WHERE D.TIME_NO=?"
		 		+ " 				AND D.TIME_NO=C.TIME_NO"
		 		+ "                 AND C.SC_NO=B.SC_NO"
		 		+ "					AND B.SC_NO=A.SC_NO "+
		 		"				 ORDER BY A.SEAT_NO,A.SEAT_CHARGE";
                             
                             
                             
                             
                              "SELECT  A.SEAT_NO, "+
                 "CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO FROM BOOKING A LEFT OUTER JOIN RESERVATION B ON B.T_NO=A.T_NO) "+
		 		                               "THEN A.SEAT_NAME||'■' "+
		 		                                "ELSE A.SEAT_NAME||'□' "+
                                            "END AS SEAT_NAME, "+
		 		                 "A.SEAT_CHARGE "+
            				  "FROM SEAT A, (SELECT A.SC_NO FROM SCREEN A, R_TIME B WHERE B.TIME_NO = ? AND B.SC_NO = A.SC_NO)B "+
            				 "WHERE A.SC_NO=B.SC_NO "+
		 					 "ORDER BY A.SEAT_NAME";
                             
                             
                             
                             
                            SELECT A.SEAT_NO, 
                            CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO
                                                                FROM BOOKING A, RESERVATION B, R_TIME C, SCREEN D WHERE A.T_NO=B.T_NO 
                                                                                                AND C.TIME_NO = 2
                                                                                                AND B.TIME_NO = C.TIME_NO
                                                                                                AND C.SC_NO = D.SC_NO)
		 		                               THEN A.SEAT_NAME||'■'
		 		                                ELSE A.SEAT_NAME||'□'
                                            END AS SEAT_NAME,
                                            A.SEAT_CHARGE
                                            FROM SEAT A, R_TIME B, SCREEN C
                                            WHERE B.TIME_NO = 2
                                            AND B.SC_NO = C.SC_NO
                                            AND A.SC_NO = C.SC_NO
                                            GROUP BY A.SEAT_NO,SEAT_NAME,A.SEAT_CHARGE
                                            ORDER BY A.SEAT_NAME;
                             
                             
                             
                             
    SELECT A.SEAT_NO FROM BOOKING A LEFT OUTER JOIN RESERVATION B ON B.T_NO=A.T_NO;