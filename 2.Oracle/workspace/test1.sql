

SELECT 
FROM T_PRICE
WHERE P_NAME = '기준가격'
  AND 
  
  SELECT 
    FROM MEMBER
    WHERE SUBSTR(M_BIR,1,4) BETWEEN 1900 AND 1950
    
    12000      -500      +500
    기준금액 + 나이할인 + 좌석요금
    --나이할인
    SELECT CASE WHEN B.AGE<30 THEN
    (SELECT P_COST FROM T_PRICE WHERE P_NAME = '청소년할인') END AS 할인
    FROM T_PRICE A,
    (SELECT TRUNC(ROUND(MONTHS_BETWEEN(SYSDATE,M_BIR)/12)) AS AGE
    FROM MEMBER
    WHERE M_NAME = '지롱') B;
    --좌석요금 
    SELECT 좌석요금
    FROM 티켓,상영,상영관,좌석
    티켓의 상영번호 = 상영시간의 상영번호
    상영시간의 상영관번호 = 상영관의 상영관번호
    상영관의 상영관번호 = 좌석의 상영관번호
    선택한 좌석번호 = ?
    SELECT D.SEAT_CHARGE,D.SEAT_NO
    FROM RESERVATION A, R_TIME B, SCREEN C , SEAT D
    WHERE B.TIME_NO = 4
      AND A.TIME_NO = B.TIME_NO
      AND B.SC_NO = C.SC_NO
      AND C.SC_NO = D.SC_NO
      AND D.SEAT_NAME = 'A1';
      
    SELECT C.SEAT_NO,C.SEAT_NAME
    FROM R_TIME A,SCREEN B, SEAT C
    WHERE A.TIME_NO = 4
      AND A.SC_NO = B.SC_NO
      AND B.SC_NO = C.SC_NO
      AND C.SEAT_NAME = 'A1'
      
    
    SELECT TRUNC(ROUND(MONTHS_BETWEEN(SYSDATE,M_BIR)/12)) AS 나이
    FROM MEMBER
    WHERE M_NO = 1;
    
    INSERT INTO MEMBER VALUES(2,'지롱',to_date('1996-04-23','yyyy-mm-dd'),10,0,'jinhong',1234);
    SELECT TRUNC(ROUND(MONTHS_BETWEEN(SYSDATE,M_BIR)/12)) AS AGE
		 		    FROM MEMBER
		 	    WHERE M_NO = 2
   
   INSERT INTO 티켓 VALUES(티켓번호,상영정보번호,고객번호,결제번호(입력전 먼저등록),사용마일리지,결제가격,발행일)
   INSERT INTO RESERVATION VALUES(2,4,2,1,0,12800,SYSDATE);
   INSERT INTO RESERVATION VALUES((SELECT NVL(MAX(TIME_NO), 0) + 1 FROM R_TIME),
   INSERT INTO 예약좌석 VALUES(티켓번호,좌석번호,좌석가격);
   INSERT INTO BOOKING VALUES(2,125,12800);
   INSERT INTO PAYMENT VALUES(2,'카드')
   COMMIT;
   SELECT 
   COMMIT;
   
   
   SELECT D.SEAT_NO
				 		   FROM RESERVATION A, R_TIME B, SCREEN C , SEAT D 
				 		   WHERE B.TIME_NO = 6
				 		     AND A.TIME_NO = B.TIME_NO
				 		     AND B.SC_NO = C.SC_NO
                        AND C.SC_NO = D.SC_NO
                          AND D.SEAT_NAME = 'G1' 
				 		    GROUP BY D.SEAT_NO
                            
                            
                            rtimeno = ?
                            SELECT A.SEAT_NO FROM BOOKING A 
                            LEFT OUTER JOIN RESERVATION B ON (B.T_NO=A.T_NO)
                            INNER JOIN R_TIME C ON (C.TIME_NO=1)
                            
                            SELECT A.SEAT_NO, E.SEAT_NAME 
                            FROM BOOKING A,RESERVATION B,R_TIME C, SCREEN D,SEAT E 
                            WHERE B.TIME_NO=3
                              AND B.TIME_NO=C.TIME_NO
                              AND C.SC_NO = D.SC_NO
                              AND D.SC_NO = E.SC_NO
                              AND A.SEAT_NO = E.SEAT_NO
                              GROUP BY A.SEAT_NO,E.SEAT_NAME;
                            SELECT A.SEAT_NO FROM BOOKING A,RESERVATION B,R_TIME C, SCREEN D,SEAT E WHERE B.TIME_NO=5   AND B.TIME_NO=C.TIME_NO  AND C.SC_NO = D.SC_NO    AND D.SC_NO = E.SC_NO     AND A.SEAT_NO = E.SEAT_NO   GROUP BY A.SEAT_NO;
                           
                            SELECT A.SEAT_NO,A.SEAT_CHARGE
                              FROM SEAT A, SCREEN B, R_TIME C, RESERVATION D
                             WHERE D.TIME_NO=5
                             AND D.TIME_NO=C.TIME_NO
                            AND C.SC_NO=B.SC_NO
                            	AND B.SC_NO=A.SC_NO
                            GROUP BY A.SEAT_NO,A.SEAT_CHARGE
                                 SELECT A.SEAT_NO FROM BOOKING A,RESERVATION B,R_TIME C, SCREEN D,SEAT E WHERE B.TIME_NO=5   AND B.TIME_NO=C.TIME_NO  AND C.SC_NO = D.SC_NO    AND D.SC_NO = E.SC_NO     AND A.SEAT_NO = E.SEAT_NO   GROUP BY A.SEAT_NO
                                 
                            SELECT    A.SEAT_NO,
		 		     CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO FROM BOOKING A LEFT OUTER JOIN RESERVATION B ON B.T_NO=A.T_NO)
		 		                                THEN A.SEAT_NAME||'■'
		 		                                ELSE A.SEAT_NAME||'□'
		 		                                END AS SEAT_NAME,
		 		                  A.SEAT_CHARGE
		 						  FROM SEAT A, (SELECT SC_NO FROM SCREEN WHERE SC_NO = 4)B 
		 						 WHERE A.SC_NO=B.SC_NO
		 						 ORDER BY A.SEAT_NAME
                                 
                                 COMMIT;
                                 
                                 
                                 
                                 SELECT  CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO FROM BOOKING A,RESERVATION B,R_TIME C, SCREEN D,SEAT E WHERE B.TIME_NO=5   AND B.TIME_NO=C.TIME_NO  AND C.SC_NO = D.SC_NO    AND D.SC_NO = E.SC_NO     AND A.SEAT_NO = E.SEAT_NO   GROUP BY A.SEAT_NO)							
		 		                               THEN A.SEAT_NAME||'■'
		 		                                ELSE A.SEAT_NAME||'□'
		 		                                END AS SEAT_NAME,
		 		                  A.SEAT_CHARGE
		 						  FROM SEAT A, SCREEN B, R_TIME C, RESERVATION D
		 					 WHERE D.TIME_NO=5
		 						AND D.TIME_NO=C.TIME_NO
		 		                 AND C.SC_NO=B.SC_NO
		 							AND B.SC_NO=A.SC_NO 
		 						 ORDER BY A.SEAT_NO,A.SEAT_CHARGE