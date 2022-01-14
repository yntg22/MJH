2021-1130-05)CURSOR
 - SQL��ɿ� ���Ͽ� ������� ����� ����
 - SELECT ���� ��� ����
 - ������ Ŀ�� (Implicit Cursor)�� ����� Ŀ��(Explicit Cursor)�� ����
 1)������ Ŀ�� (Implicit Cursor)
  . �̸��� ���� Ŀ��
  . SQL������ ����� ���ÿ� ���������� ������ Ŀ���� �������
  (Ŀ���Ӽ�)
  -------------------------------------------------------------------
  �Ӽ�                    �ǹ�
  -------------------------------------------------------------------
  SQL%FOUND         ������տ� FETCH ROW��(���� ����)�� 1���� ������ ��
  SQL%NOTFOUND      ������տ� FETCH ROW���� ������ ��, ������ ����
  SQL%ROWCOUNT      ��������� ROW�� ��ȯ
  SQL%ISOPEN        Ŀ���� OPEN���¸� ��(������Ŀ���� �׻� ������)
  
 2)����� Ŀ�� (Explicit Cursor)
  . �̸��� �ִ� Ŀ��
  . Ŀ���� ����� ���� => OPEN => FETCH => CLOSE �ܰ�� ����
  (1)Ŀ�� ����
    . DECLARE �������� ����
    (��������)
    CURSOR Ŀ����[(�Ű�����list)]
    IS
      SELECT ��;
     .'�Ű�����list':Ŀ�� ����� ���� �����͸� ���޹��� ������
      ������ ������Ÿ�� �������� ����Ǹ� �����ʹ� OPEN������ �����Ѵ�
      
  (2)OPEN ��
    . ����� Ŀ������
    . BEGIN ��Ͽ��� ���
    
    (�������)
       OPEN Ŀ����[(�Ű�����list)]
       
  (3)FETCH ��
    . Ŀ������ �ڷḦ ������� �о���� ���(READ���� ���� ���)
    . ���� ������� �ȿ� ��ġ
    (�������)
    FETCH Ŀ���� INTO ����,����,...����;
    . Ŀ������ SELECT ���� �÷����� INTO���� ������ ����, ����, ������ Ÿ���� ��ġ�ؾ� ��
    . Ŀ������ ���̻� FETCH�� ROW�� ������ Ŀ���Ӽ� Ŀ����%NOTFOUND�� ���̵�
    . Ŀ���Ӽ��� ������ Ŀ���Ӽ��� ������ 'SQL'��� Ŀ������ ����� --FOR���� �Ƚᵵ��
      ex)Ŀ����%FOUND,Ŀ����%NOTFOUND,Ŀ����%ISOPEN,Ŀ����%ROWCOUNT,...
      
  (4)CLOSE ��
    . ����� ����� Ŀ���� �ݵ�� CLOSE �ؾ���
    (�������)
    CLOSE Ŀ����
    
��뿹)������̺��� 80���μ��� ���� ����� �̸�,�Ի���,�����ڵ带
      ����ϴ� ����� Ŀ���� �̿��Ͽ� �ۼ��Ͻÿ�.
      
   (Ŀ���κ�:�ش�μ��� ���� �����,�����ڵ�,�Ի����� ���)
       SELECT EMP_NAME,JOB_ID,HIRE_DATE
         FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID=80; 
   
   (LOOP��� ���)     
       DECLARE
         CURSOR CUR_EMP(P_DID HR.EMPLOYEES.DEPARTMENT_ID%TYPE)
         IS
            SELECT EMP_NAME,JOB_ID,HIRE_DATE
              FROM HR.EMPLOYEES
             WHERE DEPARTMENT_ID=P_DID;
        V_ENAME HR.EMPLOYEES.EMP_NAME%TYPE;
        V_JID HR.EMPLOYEES.JOB_ID%TYPE;
        V_HDATE DATE;
       BEGIN
         OPEN CUR_EMP(80);
         LOOP
          FETCH CUR_EMP INTO V_ENAME,V_JID,V_HDATE;--EXIT �Ʒ��� FETCH�� �������� �ȵȴ�. 
          EXIT WHEN CUR_EMP%NOTFOUND;
          DBMS_OUTPUT.PUT_LINE('����� : '||V_ENAME);
          DBMS_OUTPUT.PUT_LINE('�����ڵ� : '||V_JID);
          DBMS_OUTPUT.PUT_LINE('�Ի��� : '||V_HDATE);
          DBMS_OUTPUT.PUT_LINE('--------------------------');
         END LOOP;
         DBMS_OUTPUT.PUT_LINE('����� : '||CUR_EMP%ROWCOUNT);
         CLOSE CUR_EMP;
       END;
       
��뿹)ȸ�����̺��� ���ϸ����� ���� 5����� ��ȸ�ϰ�, �� ȸ������ 2005�⵵
      �������踦 ��ȸ�Ͻÿ�.
   (���ϸ����� ���� 5�� ����)
     SELECT A.MEM_ID AS MID,A.MEM_NAME AS MNAME 
       FROM(SELECT MEM_ID,MEM_NAME,MEM_MILEAGE
              FROM MEMBER
             ORDER BY 3 DESC)A
      WHERE ROWNUM<=5;
     
            
      DECLARE
        CURSOR CUR_MILEAGE
        IS
          SELECT A.MEM_ID AS MID,A.MEM_NAME AS MNAME 
            FROM(SELECT MEM_ID,MEM_NAME,MEM_MILEAGE
                   FROM MEMBER
                  ORDER BY 3 DESC)A
           WHERE ROWNUM<=5;
        V_MID MEMBER.MEM_ID%TYPE;
        V_MNAME MEMBER.MEM_NAME%TYPE;
        V_SUM NUMBER:=0;
        
      BEGIN
        OPEN CUR_MILEAGE;
        LOOP
          FETCH CUR_MILEAGE INTO V_MID,V_MNAME;
          EXIT WHEN CUR_MILEAGE%NOTFOUND;
          SELECT SUM(A.CART_QTY*B.PROD_PRICE) INTO V_SUM
            FROM CART A,PROD B
           WHERE A.CART_PROD=B.PROD_ID
             AND A.CART_NO LIKE '2005%'
             AND A.CART_MEMBER=V_MID;
             
         DBMS_OUTPUT.PUT_LINE('ȸ����ȣ : '||V_MID);    
         DBMS_OUTPUT.PUT_LINE('ȸ���� : '||V_MNAME);
         DBMS_OUTPUT.PUT_LINE('���űݾ� : '||V_SUM);
         DBMS_OUTPUT.PUT_LINE('--------------------------------');
       END LOOP;
       CLOSE CUR_MILEAGE;             
      END;
       