2021-1125-01)��������
 - ���� �ȿ� �� �ٸ� ������ ����
 - ���������� ���� JOIN���� ����� �� ����
 - ���������� ������(��������)���� ����� �߰������ �����ϱ����� ����
 - ���������� '( )'�ȿ� �����
 - ���������� ������ �����ʿ� ��ġ�ؾ� ��
  (���������� �з�)
 - ���������� ��ġ�� ����
  . �Ϲݼ������� : SELECT���� ��ġ
  . �ζ���(in-line) �������� : FROM ���� ��ġ (���������� ����)
  . ��ø�������� : WHERE���� ��ġ
 - ������������ ������ ���ο� ����
  . ������ ���� �������� : ���������� ���� ���̺�� ���������� ���� ����
    ���̿� JOIN�� �߻� ���� �ʴ� ����
  . ������ �ִ� �������� : ���������� ���� ���̺�� ���������� ���� ���̺�
    ���̿� JOIN���� ����� ����
 - ��ȯ�Ǵ� ���� ������ ����
  . ������ �������� : �ϳ��� �ุ ��ȯ(�Ϲ� ������ ���)
  . ������ �������� : �������� ���� ��ȯ(������ �����ڸ� ����Ͽ� ó��)
  
1) ���������� �������� 
 - ���������� �������� ���̿� �������� ������� ���� ��������
 
��뿹) ������̺��� ��ձ޿����� ���� �޿��� �޴� ����� �����ȣ,�����,
        �μ���ȣ,�޿��� ����Ͻÿ�
        (�������� : ����� �����ȣ,�����,�μ���ȣ,�޿��� ���)
        SELECT EMPLOYEE_ID AS �����ȣ,
               EMP_NAME AS �����,
               DEPARTMENT_ID AS �μ���ȣ,
               SALARY AS �޿�
          FROM HR.EMPLOYEES
          WHERE SALARY > ( ��ձ޿� : ��������);
          
        (�������� : ��ձ޿� ���)
        SELECT AVG(SALARY)
          FROM HR.EMPLOYEES;
    
    (����)      
    SELECT EMPLOYEE_ID AS �����ȣ,
               EMP_NAME AS �����,
               DEPARTMENT_ID AS �μ���ȣ,
               SALARY AS �޿�
          FROM HR.EMPLOYEES
          WHERE SALARY > (SELECT AVG(SALARY)
                          FROM HR.EMPLOYEES);

    (����2)
    SELECT EMPLOYEE_ID AS �����ȣ,
               EMP_NAME AS �����,
               DEPARTMENT_ID AS �μ���ȣ,
               SALARY AS �޿�
          FROM HR.EMPLOYEES A,(SELECT AVG(SALARY) AS BSUM
                          FROM HR.EMPLOYEES) B
          WHERE SALARY > B.BSUM    
    
��뿹)�����������̺��� ���� �μ���ȣ�� �μ����̺��� �μ���ȣ�� ���� ������ ��ȸ�Ͻÿ�
        Alias�� �μ���ȣ,�μ���
    (��������)
        SELECT �μ���ȣ,�μ���
          FROM HR.DEPARTMENTS
          WHERE DEPARTMENT_ID=(�μ����̺��� �μ���ȣ�� ������ �����������̺��� �μ���ȣ))
          
    (��������)
        SELECT B.DEPARTMENT_ID
          FROM HR.DEPARTMENTS A,HR.JOB_HISTORY B
         WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID; 
  
    (EXISTS ���)
          SELECT A.DEPARTMENT_ID AS �μ���ȣ,
                 A.DEPARTMENT_NAME AS �μ���
          FROM HR.DEPARTMENTS A
          WHERE EXISTS (SELECT 1 --�ǹ̾��¼���
                          FROM HR.JOB_HISTORY B
                         WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID);
                
     (IN ������ ���)           
          SELECT A.DEPARTMENT_ID AS �μ���ȣ,
                 A.DEPARTMENT_NAME AS �μ���
          FROM HR.DEPARTMENTS A
          WHERE A.DEPARTMENT_ID IN (SELECT B.DEPARTMENT_ID --�ǹ̾��¼���
                                      FROM HR.JOB_HISTORY B);  
  
          SELECT /*B.EMPLOYEE_ID AS �����ȣ,
                (SELECT EMP_NAME
                   FROM HR.EMPLOYEES A
                  WHERE A.EMPLOYEE_ID=B.EMPLOYEE_ID) AS �����,*/
                        DISTINCT B.DEPARTMENT_ID AS �μ���ȣ,
                 (SELECT DEPARTMENT_NAME
                    FROM HR.DEPARTMENTS C
                   WHERE C.DEPARTMENT_ID=B.DEPARTMENT_ID) AS �μ���
            FROM HR.JOB_HISTORY B;
            
��뿹) 2005�� 5�� ���űݾ��� �������� ���� ���� ���Ÿ� ����� ȸ����
        ȸ����ȣ,ȸ����,����,���ϸ����� ��ȸ�Ͻÿ�.
        SELECT A.MEM_ID AS ȸ����ȣ,
               A.MEM_NAME AS ȸ����,
               A.MEM_JOB AS ����,
               A.MEM_MILEAGE AS ���ϸ���,
               B.SSUM AS ���űݾ��հ�
        FROM MEMBER A, (SELECT CART_MEMBER AS MEM,
                               SUM(CART_QTY*PROD_PRICE) AS SSUM
                        FROM CART, PROD
                        WHERE CART_PROD=PROD_ID AND CART_NO LIKE '200505%'
                        GROUP BY CART_MEMBER
                        ORDER BY 2 DESC) B
         WHERE A.MEM_ID=B.MEM AND ROWNUM=1;                     
  
  (��������)
     SELECT A.MEM_ID AS ȸ����ȣ,
            A.MEM_NAME AS ȸ����,
            A.MEM_JOB AS ����,
            A.MEM_MILEAGE AS ���ϸ���
       FROM MEMBER A
       WHERE A.MEM_ID=(SELECT D.CID AS DID
                          FROM (SELECT B.CART_MEMBER AS CID,
                                SUM(B.CART_QTY*C.PROD_PRICE) AS CSUM
                                FROM CART B, PROD C
                                WHERE B.CART_PROD=C.PROD_ID
                                AND B.CART_NO LIKE '200505%'
                                GROUP BY B.CART_MEMBER
                                ORDER BY 2 DESC) D
                                WHERE ROWNUM=1);
  
**���� ������ �����ϴ� ������ ���̺��� �����Ͻÿ�
  1)���̺�� : REMAIN
  2)�÷� �� ��������
  ---------------------------------------------------------------------
    �÷���              ������Ÿ��          NULLABLE   DEFAULT      PK/FK
  ---------------------------------------------------------------------
   REMAIN_YEAR          CHAR(4)           N.N                      PK
   PROD_ID              VARCHAR2(10)      N.N                     PK/FK
   REMAIN_J_00          NUMBER(5)                       0  --(ȸ�������)�������+(ȸ�������)�԰����-������ �⸻���     
   REMAIN_I             NUMBER(5)                       0
   REMAIN_O             NUMBER(5)                       0
   REMAIN_J_99          NUMBER(5)                       0
   REMAIN_DATE          DATE
  ----------------------------------------------------------------------
  
  CREATE TABLE REMAIN(
    REMAIN_YEAR          CHAR(4),         
    PROD_ID              VARCHAR2(10),    
    REMAIN_J_00          NUMBER(5) DEFAULT 0,                 
    REMAIN_I             NUMBER(5) DEFAULT 0,                      
    REMAIN_O             NUMBER(5) DEFAULT 0,                     
    REMAIN_J_99          NUMBER(5) DEFAULT 0,                     
    REMAIN_DATE          DATE,
    
    CONSTRAINT pk_remain PRIMARY KEY(REMAIN_YEAR,PROD_ID),
    CONSTRAINT fk_re_prod FOREIGN KEY(PROD_ID) REFERENCES PROD(PROD_ID));
  -------------------------------------------
 ** ������ ���������̺� ���� �ڷḦ �Է��Ͻÿ�.
   REMAIN_YEAR : '2005'
   PROD_ID : ��ǰ���̺��� ��ǰ�ڵ�
   
   INSERT INTO REMAIN(REMAIN_YEAR,PROD_ID) 
   SELECT '2005',PROD_ID FROM PROD;
 --------------------------------------------     
 ** ������ ���������̺� �������� ��¥�� �Է��Ͻÿ�.
    �������� ��ǰ���̺��� ������� ����ϰ� ��¥�� 2004-12-31�� �Է�
   UPDATE REMAIN
      SET �÷���1=(��������),
          �÷���2=(��������),
          �÷���3=(��������)
    WHERE ����;
             ��
    UPDATE REMAIN
       SET (�÷���1,�÷���2,�÷���3)=(��������)  --�÷��� ����(n) = �������� SELECT(n)
     WEHRE ����;
     
    UPDATE REMAIN A
       SET (A.REMAIN_J_00,A.REMAIN_J_99,A.REMAIN_DATE)=
            (SELECT B.PROD_PROPERSTOCK,
                    A.REMAIN_J_99 + B.PROD_PROPERSTOCK, --���� �� + �߰��� �� = �⸻���
                    TO_DATE('20041231')
               FROM PROD B
               WHERE A.PROD_ID=B.PROD_ID)
         WHERE A.REMAIN_YEAR='2005'
         
         SELECT * FROM REMAIN;
         
         