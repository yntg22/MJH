2021-1201-03)Stored Procedure
 - �������ν����� Ư�� ����� �����ϴ� ����� �̸� �ۼ��Ͽ�
   �������� �� ���� ������ ���·� ������ ����
 - ���ν����� ��ȯ���� ����
  (�������)
  CREATE OR REPLACE PROCEDURE ���ν�����[(
    �Ű����� [IN|OUT|INOUT]������Ÿ��[:=�⺻��],
                    :
    �Ű����� [IN|OUT|INOUT]������Ÿ��[:=�⺻��])]
  IS|AS   --DECLARE ������ ����
    ���𿵿�;
  BEGIN
    ���࿵��;
  
  END;
  . 'IN|OUT|INOUT':�Ű������� ��Ȱ(IN->�Է¿�, OUT->��¿�, INOUT->��,��¿�)
  . '������Ÿ��' : ũ�⸦ �������� ����(�����ϸ� ����)
  . '�⺻��' : ����ڰ� �������� ������ �ڵ� ����Ǵ� ��
  
  (������)
    EXEC|EXECUTE ���ν�����[(�Ű�����list)]; --��������
    OR
    ���ν�����[(�Ű�����list)]; --�͸���,�Լ�,�ٸ����ν��� ���ο��� ����
    
��뿹)��ǰ�ڵ�� ������ �Է¹޾� T_PROD���̺��� PROD_TOTALSTOCK ����
      �����ϴ� ���ν����� �ۼ��Ͻÿ�
      
      CREATE OR REPLACE PROCEDURE PROC_TPROD_UPDATE(
        P_PID IN PROD.PROD_ID%TYPE,
        P_AMT IN NUMBER)
      IS
      BEGIN
        UPDATE T_PROD
           SET PROD_TOTALSTOCK=PROD_TOTALSTOCK+P_AMT
         WHERE PROD_ID=P_PID;
         COMMIT;
      END;
      
 (����)
  EXEC PROC_TPROD_UPDATE('P201000001',37);
  COMMIT;
  
��뿹)�Ⱓ(�⵵�Ϳ�)�� ȸ����ȣ�� �Է¹޾� �� �Ⱓ���� ���űݾ� �հ踦 ���Ͽ�
      ��ȯ�ϴ� ���ν����� �ۼ��Ͻÿ�
      
      CREATE OR REPLACE PROCEDURE PROC_CART_SUM(
        P_PERIOD IN VARCHAR2,
        P_MID MEMBER.MEM_ID%TYPE,
        P_SUM OUT NUMBER)
      IS
        V_PERIOD CHAR(7):=P_PERIOD||'%';
      BEGIN
        SELECT SUM(A.CART_QTY*B.PROD_PRICE) INTO P_SUM
          FROM CART A, PROD B
         WHERE A.CART_PROD=B.PROD_ID
           AND A.CART_NO LIKE V_PERIOD
           AND A.CART_MEMBER=P_MID;
      END;
      
  (����)
  DECLARE
    V_SUM NUMBER:=0;  --��������
  BEGIN
    PROC_CART_SUM('200505','c001',V_SUM);  
    
    DBMS_OUTPUT.PUT_LINE(V_SUM);
    END;
    
��뿹)��(2�� ����) 2���� �Է� �޾� 2005�� �ش�Ⱓ ���� ��ǰ�� �������踦 ���ϰ�
      ���������̺��� �����Ͻÿ�.
      
      CREATE OR REPLACE PROCEDURE PROC_BUYPROD_PERIOD(
        P_STARTM VARCHAR2,
        P_ENDM VARCHAR2)
      IS
        V_SDATE DATE:=TO_DATE('2005'||P_STARTM||'01');
        V_EDATE DATE:=LAST_DAY(TO_DATE('2005'||P_ENDM||'01'));
      BEGIN
        UPDATE REMAIN
           SET (REMAIN_I,REMAIN_J_99,REMAIN_DATE)=(
                SELECT REMAIN_I+A.BSUM,
                       REMAIN_J_99+A.BSUM,
                       V_EDATE
                  FROM (SELECT BUY_PROD,
                               SUM(BUY_QTY) AS BSUM
                          FROM BUYPROD
                         WHERE BUY_DATE BETWEEN V_SDATE AND V_EDATE
                         GROUP BY BUY_PROD)A
                 WHERE PROD_ID=A.BUY_PROD)
        WHERE REMAIN_YEAR='2005'
          AND PROD_ID IN(SELECT DISTINCT BUY_PROD
                           FROM BUYPROD
                          WHERE BUY_DATE BETWEEN V_SDATE AND V_EDATE);
        COMMIT;
      END;
    --PROD ���̺��� FROM������ �ҷ����� �ʾҴµ� ���? PROD_ID�� ���̴°�
    (����)
    INSERT INTO BUYPROD
        VALUES(TO_DATE('20050703'),'P101000003',20,410000);
    INSERT INTO BUYPROD
        VALUES(TO_DATE('20050703'),'P302000013',35,17000);

     COMMIT;
        
    EXEC PROC_BUYPROD_PERIOD('07','07');
    
��뿹)ȸ����ȣ�� �Է¹޾� �� ȸ���� �ּҿ� ���ϸ����� ��ȯ�ް�
      ȸ����ȣ,ȸ����,�ּ�,���ϸ����� ����Ͻÿ�
      
      CREATE OR REPLACE PROCEDURE PROC_MEM_INFO(
        P_MID MEMBER.MEM_ID%TYPE,
        P_ADDR OUT VARCHAR2,
        P_MILEAGE OUT MEMBER.MEM_MILEAGE%TYPE)
        IS
            
        BEGIN
            SELECT MEM_ADD1||' '||MEM_ADD2,MEM_MILEAGE
                INTO P_ADDR, P_MILEAGE
              FROM MEMBER
             WHERE MEM_ID=P_MID;
        END;
        
      (����)  
    ACCEPT PID PROMPT 'ȸ����ȣ : ';
    DECLARE
        V_ADDR VARCHAR(200);
        V_MILEAGE MEMBER.MEM_MILEAGE%TYPE;
        V_NAME MEMBER.MEM_NAME%TYPE;
        V_MID MEMBER.MEM_ID%TYPE:='&PID';
    BEGIN
       PROC_MEM_INFO(V_MID,V_ADDR,V_MILEAGE); 
       SELECT MEM_NAME INTO V_NAME
         FROM MEMBER
        WHERE MEM_ID=V_MID;
        
       DBMS_OUTPUT.PUT_LINE('ȸ����ȣ : '||V_MID);
       DBMS_OUTPUT.PUT_LINE('ȸ���� : '||V_NAME);
       DBMS_OUTPUT.PUT_LINE('�ּ� : '||V_ADDR);
       DBMS_OUTPUT.PUT_LINE('���ϸ��� : '||V_MILEAGE);
       DBMS_OUTPUT.PUT_LINE('--------------------------');
    END;
    