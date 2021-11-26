2021-1108-01)

    (3)��������
     - �������� ������� ����
     - NOT,AND,OR ����, �켱���� NOT>AND>OR
     --------------------------------
      �Է�(A)  �Է�(B)  AND  OR  EX-OR(������ 0 �ٸ���1)
     --------------------------------
        0        0      0   0     0
        0        1      0   1     1
        1        0      0   1     1
        1        1      1   1     0
     --------------------------------
       ** 0 : FALSE, 1 : TRUE 
       
��뿹)������̺�(HR.EMPLOYEES)���� 60���μ� �Ǵ� 80���μ�,
      �Ǵ� 100���μ��� ���� ����� �����ȣ,�����,�μ���ȣ,�Ի����� ��ȸ�Ͻÿ�
      (OR ������)
      SELECT EMPLOYEE_ID AS �����ȣ,
             FIRST_NAME||' '||LAST_NAME AS �����,
             DEPARTMENT_ID AS �μ���ȣ,
             HIRE_DATE AS �Ի���
      FROM HR.EMPLOYEES
      WHERE DEPARTMENT_ID = 60 OR DEPARTMENT_ID = 80 OR
            DEPARTMENT_ID = 100
        ORDER BY 3,4;
       
      (IN ������)
      SELECT EMPLOYEE_ID AS �����ȣ,
             FIRST_NAME||' '||LAST_NAME AS �����,
             DEPARTMENT_ID AS �μ���ȣ,
             HIRE_DATE AS �Ի���
      FROM HR.EMPLOYEES
      WHERE DEPARTMENT_ID IN(60,80,100)
        ORDER BY 3,4;
       
      (ANY,SOME ������)
      SELECT EMPLOYEE_ID AS �����ȣ,
             FIRST_NAME||' '||LAST_NAME AS �����,
             DEPARTMENT_ID AS �μ���ȣ,
             HIRE_DATE AS �Ի���
      FROM HR.EMPLOYEES
      
      WHERE DEPARTMENT_ID ANY(60,80,100)
      WHERE DEPARTMENT_ID SOME(60,80,100)
      
        ORDER BY 3,4;
        
(AND ������)
��뿹1)
        ȸ�����̺��� �������� �����̸鼭 �����̰� ���ϸ����� 3000�̻���
        ȸ���� ��ȸ�Ͻÿ�
        Alias�� ȸ����ȣ,ȸ����,�ּ�,�ֹι�ȣ,���ϸ����̴�
        SELECT MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����,
               MEM_ADD1||' '||MEM_ADD2 AS �ּ�,
               MEM_REGNO1||' '||MEM_REGNO2 AS �ֹι�ȣ,
               MEM_MILEAGE AS ���ϸ���
          FROM MEMBER
          WHERE SUBSTR(MEM_ADD1,1,2)='����' --MEM_ADD1 LIKE '����%'
            AND (MEM_REGNO2 LIKE '2%' OR MEM_REGNO2 LIKE '4%')--(SUBSTR(MEM_REGNO2,1,1)='2' OR SUBSTR(MEM_REGNO2,1,1)='4')
            AND MEM_MILEAGE >= 3000;
        
        
��뿹2)��ǰ���̺�(PROD)���� �ǸŰ�(PROD_PRICE)�� 20��������
       ��ǰ������ ��ȸ�Ͻÿ�
       Alias�� ��ǰ�ڵ�(prod_ID),��ǰ��(PROD_NAME),�ǸŰ�(PROD_PRICE),
               �Ǹ�����(�ǸŰ�-���԰�(PROD_COST))
           SELECT PROD_ID AS ��ǰ�ڵ�,
                  PROD_NAME AS ��ǰ��,
                  PROD_PRICE AS �ǸŰ�,
                  PROD_PRICE-PROD_COST AS �Ǹ�����
             FROM PROD
            WHERE PROD_PRICE >= 200000 AND
                     PROD_PRICE < 300000
                     ORDER BY 4 DESC;              
                               

��뿹3)��ǰ���̺�(PROD)���� 'P300'�� �з��� ���� ��ǰ������ ��ȸ�Ͻÿ�
        Alias�� ��ǰ�ڵ�,��ǰ��,���԰ŷ�ó�ڵ�(PROD_BUYER),�з��ڵ�(PROD_LGU)
        SELECT PROD_ID AS ��ǰ�ڵ�,
               PROD_NAME AS ��ǰ��,
               PROD_BUYER AS ���԰ŷ�ó�ڵ�,
               PROD_LGU AS �з��ڵ�
        FROM PROD
        WHERE PROD_LGU >='P300' AND PROD_LGU<'P400'--PROD_LGU LIKE 'P3%'; --SUBSTR(PROD_LGU,2,1) ='3'; 
        ORDER BY 1;
        -- ���ڿ��� ������ ��(�����ٶ󸶹ٻ�)
       
       
    4)��Ÿ������
     (1) '||'
      - ���ڿ� ���� ������
       (�������)
        EXPR || EXPR[||EXPR ....]
         . 'EXPR'�� ǥ���� ���ڿ� �ڷḦ �����Ͽ� ���ο� ���ڿ� �ڷḦ ��ȯ
         . ���ڿ� �Լ� CONCAT( )�� ġȯ ����
��뿹)ȸ�����̺��� ������ '�ֺ�'�� ȸ�� ������ ��ȸ�Ͻÿ�
      Alias�� ȸ����ȣ,ȸ����,�ֹε�Ϲ�ȣ,�ּ��̸� �ֹε�Ϲ�ȣ��
      'XXXXXX-XXXXXXX'��������, �ּҴ� �⺻�ּҿ� ���ּҸ� ' '�� �����Ͽ� 
      ����Ͻÿ�.
      SELECT MEM_ID AS ȸ����ȣ,
             MEM_NAME AS ȸ����,
             MEM_REGNO1||'-'||MEM_REGNO2 AS �ֹε�Ϲ�ȣ,
             CONCAT(CONCAT(MEM_ADD1,' '),MEM_ADD2) AS �ּ�
      FROM MEMBER
      WHERE MEM_JOB='�ֺ�'; --MEM_JOB LIKE '�ֺ�'

** ALTER ���
 - DDL(Date Definition Language) ���
 - ���̺��̸� ����, �÷��߰�/����/����, ���̺� ��������� �߰�/����/���� ��� ����
 
  (1)���̺�� ����
    (�������)
    ALTER TABLE ���̺��_OLD RENAME TO ���̺��_NEW;
     . '���̺��_OLD'�� '���̺��_NEW'�� ����
 
��뿹)CREATE TABLE TEMP AS
      SELECT * FROM PROD; --���̺���(KEY ������ �����͸�)
  
      SELECT * FROM TEMP;
  
      ALTER TABLE TEMP RENAME TO T_PROD;
      
    (2)�÷� �̸� ����
      (�������)
      ALTER TABLE ���̺�� RENAME COLUMN �÷���_OLD TO �÷���_NEW;
      .'���̺��'�� �����ϴ� '�÷���_OLD'�� '�÷���_NEW'�� ����
      
��뿹)T_PROD ���̺��� PROD_LGU�÷����� LPROD_GU�� �����Ͻÿ�
      ALTER TABLE T_PROD RENAME COLUMN PROD_GU TO LPROD_GU;
     
      SELECT * FROM T_PROD; 
       
      
    (3)�÷��߰�
       (�������)
       ALTER TABLE ���̺�� ADD(�÷��� ������Ÿ��[ũ��]);
        .'���̺��'�� '�÷���'�� �߰�
        
��뿹)������̺� VARCHAR2(80)�� ���̸� ���� EMP_NAME�÷�����
      �߰��Ͻÿ�.
      ALTER TABLE HR.EMPLOYEES ADD (EMP_NAME VARCHAR2(80));
      
��뿹)������̺��� �̸�(FIRST_NAME�� LAST_NAME)�� �����Ͽ� EMP_NAME �÷��� 
      �����Ͻÿ�.
      
      UPDATE HR.EMPLOYEES
         SET EMP_NAME=FIRST_NAME||' '||LAST_NAME;
      SELECT EMP_NAME FROM HR.EMPLOYEES;
       
       COMMIT;
       
    (4)�÷�����
      (�������)
       ALTER TABLE ���̺�� DROP COLUMN �÷���;
       .'���̺��'���̺� ���� '�÷���'�� �ش��ϴ� �÷� ����
��뿹)���̺� T_PROD�� �����ϴ� �÷� PROD_IMG�� �����Ͻÿ�
        ALTER TABLE T_PROD DROP COLUMN PROD_IMG;
       
    (5)�÷�����
     (�������)
     ALTER TABLE ���̺�� MODIFY(�÷��� ������Ÿ��(ũ��));
      .'���̺��'���̺� ���� '�÷���'�� �ش��ϴ� �÷��� �ڷ���(������Ÿ��)��
        ũ�⸦ �����ų�� ����
��뿹)ALTER TABLE T_PROD MODIFY(PROD_TOTALSTOCK NUMBER(15)); --���� ���������..ũ�⺯�游
       ALTER TABLE T_PROD MODIFY(PROD_MILEAGE VARCHAR2(20));
       COMMIT;
       ALTER TABLE T_PROD MODIFY(PROD_TOTALSTOCK NUMBER(9)); 
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
       
       
       