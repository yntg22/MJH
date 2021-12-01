2021-1201-01)

커서사용예)2005년 4월 매입상품 중 수량기준으로 많이 매입된 3개 상품의 동 기간 중
          매출정보를 조회하시오
          Alias는 상품코드,상품명,매출액
        (수량기준으로 많이 매입된 3개 상품) --CURSOR가 될 SELECT문
            SELECT A.BUY_PROD AS BID,
                   A.BSUM AS ABSUM
            FROM (SELECT BUY_PROD,
                         SUM(BUY_QTY) AS BSUM
                    FROM BUYPROD
                   WHERE BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050430')
                   GROUP BY BUY_PROD
                   ORDER BY 2 DESC) A
             WHERE ROWNUM<=3; --ROWNUM 사용하려면 서브쿼리
          
--   (LOOP 사용)
          DECLARE --FETCH에서 받을 변수들을 선언한다
            V_BID PROD.PROD_ID%TYPE; --V_BID(변수)는 PROD테이블의 PROD_ID의컬럼타입과 같게 선언 (상품코드)
            --V_CNT NUMBER:=0; --초기값 0 (매입수량)
            V_SUM NUMBER:=0; --(매출금액)
            V_BNAME PROD.PROD_NAME%TYPE; --(상품명)
            CURSOR CUR_BUYPROD
            IS SELECT A.BUY_PROD
                 FROM (SELECT BUY_PROD,
                              SUM(BUY_QTY) AS BSUM
                         FROM BUYPROD
                        WHERE BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050430')
                        GROUP BY BUY_PROD
                        ORDER BY 2 DESC) A
                WHERE ROWNUM<=3;
            BEGIN
                OPEN CUR_BUYPROD;
                LOOP
                    FETCH CUR_BUYPROD INTO V_BID;
                    EXIT WHEN CUR_BUYPROD%NOTFOUND;
                    SELECT SUM(B.CART_QTY*A.PROD_PRICE)
                        INTO V_SUM
                        FROM PROD A, CART B
                        WHERE A.PROD_ID=B.CART_PROD
                          AND B.CART_NO LIKE '200504%'
                          AND B.CART_PROD=V_BID;
                      
                      SELECT PROD_NAME INTO V_BNAME
                        FROM PROD
                        WHERE PROD_ID=V_BID;
                        
                        DBMS_OUTPUT.PUT_LINE('상품코드 : '||V_BID);
                        DBMS_OUTPUT.PUT_LINE('상품명 : '||V_BNAME);
                        DBMS_OUTPUT.PUT_LINE('매출액 : '||V_SUM);
                        
                END LOOP;
                CLOSE CUR_BUYPROD;
            END;
            
 -- (WHILE 사용)
            DECLARE --FETCH에서 받을 변수들을 선언한다
            V_BID PROD.PROD_ID%TYPE; --V_BID(변수)는 PROD테이블의 PROD_ID의컬럼타입과 같게 선언 (상품코드)
            --V_CNT NUMBER:=0; --초기값 0 (매입수량)
            V_SUM NUMBER:=0; --(매출금액)
            V_BNAME PROD.PROD_NAME%TYPE; --(상품명)
            CURSOR CUR_BUYPROD
            IS SELECT A.BUY_PROD
                 FROM (SELECT BUY_PROD,
                              SUM(BUY_QTY) AS BSUM
                         FROM BUYPROD
                        WHERE BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050430')
                        GROUP BY BUY_PROD
                        ORDER BY 2 DESC) A
                WHERE ROWNUM<=3;
            BEGIN
                OPEN CUR_BUYPROD;
                FETCH CUR_BUYPROD INTO V_BID; --FETCH를 먼저 해야 WHILE 조건을 알 수 있음
               WHILE CUR_BUYPROD%FOUND LOOP
                    SELECT SUM(B.CART_QTY*A.PROD_PRICE)
                        INTO V_SUM
                        FROM PROD A, CART B
                        WHERE A.PROD_ID=B.CART_PROD
                          AND B.CART_NO LIKE '200504%'
                          AND B.CART_PROD=V_BID;
                      
                      SELECT PROD_NAME INTO V_BNAME
                        FROM PROD
                        WHERE PROD_ID=V_BID;
                        
                        DBMS_OUTPUT.PUT_LINE('상품코드 : '||V_BID);
                        DBMS_OUTPUT.PUT_LINE('상품명 : '||V_BNAME);
                        DBMS_OUTPUT.PUT_LINE('매출액 : '||V_SUM);
                FETCH CUR_BUYPROD INTO V_BID; --WHILE안에 FETCH문이 반드시 들어와야함
                END LOOP;
                CLOSE CUR_BUYPROD;
            END;
            
            
    -- (FOR문 사용) FOR문을 쓰면 OPEN FETCH CLOSE 안써도 된다
            DECLARE --FETCH에서 받을 변수들을 선언한다
            V_SUM NUMBER:=0; --(매출금액)
            V_BNAME PROD.PROD_NAME%TYPE; --(상품명)
            CURSOR CUR_BUYPROD
            IS SELECT A.BUY_PROD
                 FROM (SELECT BUY_PROD,
                              SUM(BUY_QTY) AS BSUM
                         FROM BUYPROD
                        WHERE BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050430')
                        GROUP BY BUY_PROD
                        ORDER BY 2 DESC) A
                WHERE ROWNUM<=3;
            BEGIN
               FOR REC IN CUR_BUYPROD LOOP
                    SELECT SUM(B.CART_QTY*A.PROD_PRICE)
                        INTO V_SUM
                        FROM PROD A, CART B
                        WHERE A.PROD_ID=B.CART_PROD
                          AND B.CART_NO LIKE '200504%'
                          AND B.CART_PROD=REC.BID;
                      
                      SELECT PROD_NAME INTO V_BNAME
                        FROM PROD
                        WHERE PROD_ID=REC.BID;
                        
                        DBMS_OUTPUT.PUT_LINE('상품코드 : '||REC.BID);
                        DBMS_OUTPUT.PUT_LINE('상품명 : '||V_BNAME);
                        DBMS_OUTPUT.PUT_LINE('매출액 : '||V_SUM);
                END LOOP;
            END;
            
            
            
