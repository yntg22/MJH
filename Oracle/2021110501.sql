2021-1105-01) �˻����(SELCET)
 - ǥ�� SQL��� �� ���� ���� ���Ǵ� ���
 - SELECT *|[DISTINCT/*�ߺ�����*/]�÷��� [AS ��Ī][,]
          �÷��� [AS ��Ī][,]
               :
          �÷��� [AS ��Ī]
    FROM ���̺�� [��Ī]
   [WHERE ����] --�� ������ �����
   [GROUP BY �÷���[, �÷���, ...]] sum avg count max min 
   [HAVING ����]
    [ORDER BY �÷���|�÷��ε��� [ASC|DESC][, �÷���|�÷��ε��� [ASC|DESC],...]];
    
    .'AS ��Ī':�÷��� �ο��Ǵ� �Ǵٸ� �̸����� ��½� �÷��������� ����
               ��Ī�� Ư������(���� ��)�� ����ϴ� ���, �÷���Ī���� ����
               ����ϱ� ���ؼ��� �ݵ�� " "�ȿ� ��� �ؾ���
    .'���̺� ��Ī' : ���̺� �ο��� �� �ٸ� �̸����� ���δٸ� ���̺� �̸���
               ������ �÷��� �����ϱ� ���Ͽ� ���
    .'�÷��ε���' : SELECT ������ �÷����� ���� ������ 1������ �ο�
    .'ASC|DESC' : ���� ������� �⺻���� ASC(��������)�̸� DESC�� ��������
    
��뿹) ������̺��� 80�� �μ��� �ҼӵǾ��ְ� �޿��� 8000�̻��� �����
        �����ȣ,�����,�Ի���,�����ڵ�,�޿��� ��ȸ�Ͻÿ�.�� �Ի��ϼ����� ���
        
        SELECT EMPLOYEE_ID AS �����ȣ,FIRST_NAME||' '||LAST_NAME AS �����,
                HIRE_DATE AS �Ի���,JOB_ID AS "���� �ڵ�",SALARY AS �޿�
        FROM EMPLOYEES 
        WHERE SALARY >= 8000
        AND DEPARTMENT_ID = 80 
        ORDER BY �Ի���,�޿�/*3 ��밡�� SELECT 3��°, HIRE_DATE*/ ASC;
        
    1)������
     . ��Ģ������(+,-,/,*)--������ MOD(0.0)
     . ���迬����(>,<,>=,<=,=,!=(<>)):�� �ڷ��� ũ�� �� �� ���(��,����)
       ��ȯ
     . ��������(NOT,AND,OR)
     . ��Ÿ������('||',IN,ANY,SOME,ALL,EXISTS,LIKE,BETWEEN ��)
     
     (1)��Ģ������
      - ���׿��� ���� �� ����� ��ȯ
      - ����Ŭ�� ���� �켱 ����ȯ ����
      - ������ ����, ���������� �������� ����
��뿹)SELECT 238+78,238/23,238*78,238-78,MOD(10,4)
        FROM DUAL;
        /* *DUAL : �ý����� �����ϴ� ������ ���̺�
                  FROM���� ����� ���̺��� ���� ��� ��� */       
      
      SELECT MEM_ID AS ȸ����ȣ,
      MEM_NAME AS ȸ����,
      MEM_REGNO1||' '||MEM_REGNO2 AS �ֹι�ȣ,
      EXTRACT(YEAR FROM SYSDATE)- 
          TO_NUMBER('19'||SUBSTR(MEM_REGNO1,1,2)) AS ����,/*�������� EXTRACT(YTEAR FROM SYSDATE) = 2021 SUBSTR'19'||MEM_REGNO1,2)19+�� ���ڸ� + ���ڷ� ����ȯ = 1976  2021-1976= 45 */
      TRUNC(EXTRACT (YEAR FROM SYSDATE)-
          TO_NUMBER('19'||SUBSTR(MEM_REGNO1,1,2)),-1)||'��' AS ���ɴ�
      FROM MEMBER;
      
      SELECT EMPLOYEE_ID AS �����ȣ,
             FIRST_NAME||' '||LAST_NAME AS �����,
             TO_CHAR(SALARY,'99,999') AS �޿�, /*TO_CHAR (���ڰ�,����) */
             TO_CHAR(NVL(SALARY*COMMISSION_PCT,0),'99,999') AS ���ʽ�, /*NVL = NULL ġȯ*/
             TO_CHAR(SALARY+NVL(SALARY*COMMISSION_PCT,0),'99,999') AS ���޾�
             FROM HR.EMPLOYEES;
             
            (DISTINCT ��뿹: ȸ�����̺��� ȸ������ �������� ȸ������ ��ȸ�Ͻÿ�)
                SELECT SUBSTR(MEM_ADD1,1,2) AS ������,
                       COUNT(*) AS ȸ����
                FROM MEMBER
                GROUP BY SUBSTR(MEM_ADD1,1,2);
                
            DISTINCT ��뿹 : ȸ�����̺��� ȸ������ �������� ��ȸ�Ͻÿ�
                SELECT DISTINCT SUBSTR(MEM_ADD1,1,2) AS ������
                FROM MEMBER;
                
            DISTINCT ��뿹 : ��ǰ���̺��� ���� �з��ڵ带 ��ȸ�Ͻÿ� 
                SELECT DISTINCT A.PROD_LGU AS �з��ڵ�, /*��Ī��� A , B*/
                       B.LPROD_NM AS �з���
                FROM PROD A, LPROD B
                WHERE A.PROD_LGU=B.LPROD_GU
                ORDER BY 1; /*�������� ��������*/
                
            (2)���迬����
             - �������� ũ�⸦ ���Ҷ� ���
             - ����� ��(TRUE)�� ����(FALSE)���� ��ȯ
             - ���ǹ� ������ ���Ǹ� �ַ� WHERE���� ���� � ���
             - >, <, =, <=, >=, !=(<>)
            
��뿹)ȸ�����̺��� �������ϸ����� 5000�̻��� ȸ���� ��ȸ�Ͻÿ�.
      Alias�� ȸ����ȣ, ȸ����, �������, ���ϸ����̴�
        SELECT MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����,
               MEM_BIR AS �������,
               MEM_MILEAGE AS ���ϸ���
        FROM MEMBER
        WHERE MEM_MILEAGE >= 5000
        ORDER BY MEM_MILEAGE,2;
        
��뿹)��ٱ��� ���̺��� 2005�� 4�� �Ǹ����踦 ��ȸ�Ͻÿ�
      Alias�� ȸ����ȣ, �Ǹż����հ�, �Ǹűݾ��հ�
        
        SELECT A.CART_MEMBER AS ȸ����ȣ,
               SUM(A.CART_QTY) AS �Ǹż����հ�,
               SUM(A.CART_QTY*B.PROD_PRICE) AS �Ǹűݾ��հ�
        FROM CART A, PROD B
        WHERE A.CART_PROD=B.PROD_ID
        AND SUBSTR(CART_NO,1,8)>='20050401' AND SUBSTR(CART_NO,1,8)>='20050430'
        GROUP BY A.CART_MEMBER
        ORDER BY 3 DESC;
                
             
             SELECT TO_CHAR(NVL(0+1,0)) FROM DUAL; 

��뿹)ȸ�����̺��� ���￡ �����ϴ�ȸ�������� ��ȸ�Ͻÿ�
    Alias�� ȸ����ȣ,ȸ����,�ּ�,����
    SELECT MEM_ID AS ȸ����ȣ,
    MEM_NAME AS ȸ����,
    MEM_ADD1||' '||MEM_ADD2 AS �ּ�,
    CASE WHEN SUBSTR(MEM_REGNO2,1,1)='1' OR
              SUBSTR(MEM_REGNO2,1,1)='3' THEN 
                    '����ȸ��'
              ELSE
                    '����ȸ��'
              END AS ����
              FROM MEMBER
              WHERE SUBSTR(MEM_ADD1,1,2) = '����'; 

��뿹)�������̺�(BUYPROD)���� 2005�� 1�� ��¥�� �Ǹ����踦 ��ȸ�Ͻÿ�.
      Alias�� ��¥,���Լ����հ�,���Աݾ��հ�
      SELECT BUY_DATE AS ��¥,
             SUM(BUY_QTY) AS ���Լ����հ�,
             SUM(BUY_QTY*BUY_COST) AS ���Աݾ��հ�
        FROM BUYPROD
       WHERE BUY_DATE >= TO_DATE('20050101') AND --����>��¥>���ڿ�
             BUY_DATE <= TO_DATE('20050131')
        GROUP BY BUY_DATE
        ORDER BY 1;
        
*** ���̺� ����
    DROP TABLE ���̺��;
    . ���̺� ������ ���谡 �����Ǿ� ������ �ڽ����̺����
      �����ؾ� ��(�Ǵ� ���踦 ������ �� �� ���̺� ���� ����)
    ** TEMP1 ~ TEMP10 ���̺��� �����Ͻÿ�
    DROP TABLE TEMP1;
    DROP TABLE TEMP2;
    DROP TABLE TEMP3;
    DROP TABLE TEMP4;
    DROP TABLE TEMP5;
    DROP TABLE TEMP6;
    DROP TABLE TEMP7;
    DROP TABLE TEMP8;
    DROP TABLE TEMP9;
    DROP TABLE TEMP10;
    
    COMMIT;
    



















      
    
