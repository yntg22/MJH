SELECT Ƽ�Ϲ�ȣ FROM Ƽ�� A , ������ B, �󿵰� C, �¼� D, �����¼� F,
WHERE B.������=A.������
   AND B.�󿵰���ȣ=C.�󿵰���ȣ
   AND C.�󿵰���ȣ=D.�󿵰���ȣ
   AND A.Ƽ�Ϲ�ȣ=F.�¼���ȣ
   --�̷����ϸ� ����Ǿ��ִ� �¼���ȣ�� �� �� �ִ�?
   
   SELECT
   --���̵�
   INSERT INTO MEMBER VALUES(1,'��ȫ',SYSDATE,010,0,'admin','1234');
   --�������
   INSERT INTO PAYMENT VALUES('1','����');
   
   INSERT INTO BOOKING VALUES('1',136,500);
   
   --Ƽ��
   INSERT INTO RESERVATION VALUES(1,4,1,'1',1,1,SYSDATE);
   
   --Ƽ��������ȸ / ������ �¼�����
   SELECT *
   FROM RESERVATION A, BOOKING B
   WHERE A.T_NO = 1
     AND A.T_NO = B.T_NO;
   
   --������¼�
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
    
    --������ ���� �¼��� �˻��ϴ� �����ε�..
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
                                THEN A.SEAT_NAME||'��'
                                ELSE A.SEAT_NAME
                                END AS SEAT_NAME,
                  A.SEAT_CHARGE
                  
				  FROM SEAT A, (SELECT SC_NO FROM SCREEN WHERE SC_NAME = '4�󿵰�')B
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
          
          ������¼��� �˻��Ϸ���..
          ��ŷ�� �¼���ȣ�� �󿵰���ȣ�� �������� �˾Ƴ�?
          
          SELECT BOOKING 
          
          SELECT  A.SEAT_NO,
                 CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO FROM BOOKING A 
                                             LEFT OUTER JOIN RESERVATION B ON B.T_NO=A.T_NO
                                             LEFT OUTER JOIN R_TIME C ON C.TIME_NO = 5 AND C.TIME_NO=B.TIME_NO
                                             LEFT OUTER JOIN SCREEN D ON C.SC_NO = D.SC_NO)
		 		                               THEN A.SEAT_NAME||'��'
		 		                                ELSE A.SEAT_NAME||'��'
                                            END AS SEAT_NAME,
		 		                 A.SEAT_CHARGE
            				  FROM SEAT B, (SELECT A.SC_NO,C.SEAT_NO,C.SEAT_NAME,C.SEAT_CHARGE  FROM SCREEN A, R_TIME B, SEAT C WHERE B.TIME_NO = 5 AND B.SC_NO = A.SC_NO AND A.SC_NO=C.SC_NO)A
            				 WHERE A.SC_NO=B.SC_NO
		 					 GROUP BY A.SEAT_NO, A.SEAT_NAME, A.SEAT_CHARGE
                             ORDER BY A.SEAT_NO
                             
                             
                             " SELECT CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO FROM BOOKING A,RESERVATION B,R_TIME C, SCREEN D,SEAT E WHERE B.TIME_NO=?   AND B.TIME_NO=C.TIME_NO  AND C.SC_NO = D.SC_NO    AND D.SC_NO = E.SC_NO     AND A.SEAT_NO = E.SEAT_NO   GROUP BY A.SEAT_NO)"+							
		 		"                                THEN A.SEAT_NAME||'��'" + 
		 		"                                ELSE A.SEAT_NAME||'��'" + 
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
		 		                               "THEN A.SEAT_NAME||'��' "+
		 		                                "ELSE A.SEAT_NAME||'��' "+
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
		 		                               THEN A.SEAT_NAME||'��'
		 		                                ELSE A.SEAT_NAME||'��'
                                            END AS SEAT_NAME,
                                            A.SEAT_CHARGE
                                            FROM SEAT A, R_TIME B, SCREEN C
                                            WHERE B.TIME_NO = 2
                                            AND B.SC_NO = C.SC_NO
                                            AND A.SC_NO = C.SC_NO
                                            GROUP BY A.SEAT_NO,SEAT_NAME,A.SEAT_CHARGE
                                            ORDER BY A.SEAT_NAME;
                             
                             
                             
                             
    SELECT A.SEAT_NO FROM BOOKING A LEFT OUTER JOIN RESERVATION B ON B.T_NO=A.T_NO;