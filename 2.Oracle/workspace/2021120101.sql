2021-1201-01)

Ŀ����뿹)2005�� 4�� ���Ի�ǰ �� ������������ ���� ���Ե� 3�� ��ǰ�� �� �Ⱓ ��
          ���������� ��ȸ�Ͻÿ�
          Alias�� ��ǰ�ڵ�,��ǰ��,�����
        (������������ ���� ���Ե� 3�� ��ǰ) --CURSOR�� �� SELECT��
            SELECT A.BUY_PROD AS BID,
                   A.BSUM AS ABSUM
            FROM (SELECT BUY_PROD,
                         SUM(BUY_QTY) AS BSUM
                    FROM BUYPROD
                   WHERE BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050430')
                   GROUP BY BUY_PROD
                   ORDER BY 2 DESC) A
             WHERE ROWNUM<=3; --ROWNUM ����Ϸ��� ��������
          
--   (LOOP ���)
          DECLARE --FETCH���� ���� �������� �����Ѵ�
            V_BID PROD.PROD_ID%TYPE; --V_BID(����)�� PROD���̺��� PROD_ID���÷�Ÿ�԰� ���� ���� (��ǰ�ڵ�)
            --V_CNT NUMBER:=0; --�ʱⰪ 0 (���Լ���)
            V_SUM NUMBER:=0; --(����ݾ�)
            V_BNAME PROD.PROD_NAME%TYPE; --(��ǰ��)
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
                        
                        DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||V_BID);
                        DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||V_BNAME);
                        DBMS_OUTPUT.PUT_LINE('����� : '||V_SUM);
                        
                END LOOP;
                CLOSE CUR_BUYPROD;
            END;
            
 -- (WHILE ���)
            DECLARE --FETCH���� ���� �������� �����Ѵ�
            V_BID PROD.PROD_ID%TYPE; --V_BID(����)�� PROD���̺��� PROD_ID���÷�Ÿ�԰� ���� ���� (��ǰ�ڵ�)
            --V_CNT NUMBER:=0; --�ʱⰪ 0 (���Լ���)
            V_SUM NUMBER:=0; --(����ݾ�)
            V_BNAME PROD.PROD_NAME%TYPE; --(��ǰ��)
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
                FETCH CUR_BUYPROD INTO V_BID; --FETCH�� ���� �ؾ� WHILE ������ �� �� ����
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
                        
                        DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||V_BID);
                        DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||V_BNAME);
                        DBMS_OUTPUT.PUT_LINE('����� : '||V_SUM);
                FETCH CUR_BUYPROD INTO V_BID; --WHILE�ȿ� FETCH���� �ݵ�� ���;���
                END LOOP;
                CLOSE CUR_BUYPROD;
            END;
            
            
    -- (FOR�� ���) FOR���� ���� OPEN FETCH CLOSE �Ƚᵵ �ȴ�
            DECLARE --FETCH���� ���� �������� �����Ѵ�
            V_SUM NUMBER:=0; --(����ݾ�)
            V_BNAME PROD.PROD_NAME%TYPE; --(��ǰ��)
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
                        
                        DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||REC.BID);
                        DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||V_BNAME);
                        DBMS_OUTPUT.PUT_LINE('����� : '||V_SUM);
                END LOOP;
            END;
            
            
            
