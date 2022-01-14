2021-1129-02)����Ŭ ��ü
1. VIEW ��ü
 - ������ ���̺�(���̺� ��ü�� ������ ����)
 - SELECT ���� ������
 - �ʿ��� ������ ���� ���̺� �л� ����Ȱ��
 - Ư�� ���̺��� ������ �����ϰ��� �ϴ� ��� �ַ� ���
   (��������)
   CREATE [OR REPLACE] VIEW ���̸�[(�÷�list)]
   AS
    SELECT ��;
    [WITH CHECK OPTION]
    [WITH READ ONLY]
  . 'OR REPLACE' : �̹� �����ϴ� ���� ��쿡�� ��ġ�ϰ� �ű� ��� ����
  . '�÷�list' : �信 ���� �÷����
                 �����Ǹ� SELECT���� ��Ī�� ���� �̸����� �ο��Ǹ�, 
  . 'WITH CHECK OPTION' : SELECT���� WHERE �������� �����ϴ� DML�����
                          �信 ����Ҽ� ����(�������̺��� ���Ѿ��� ���)
  . 'WITH READ ONLY' : �б����� �並 ����
  
��뿹) ȸ�����̺��� ���ϸ����� 3000�̻��� ȸ���� 
        ȸ����ȣ,ȸ����,��ȭ��ȣ,���ϸ����� ������ �並 �����Ͻÿ�
        
        CREATE OR REPLACE VIEW V_MEM01(MEM_ID,MEM_NAME,MEM_HP,MEM_MILEAGE)
        AS
            SELECT MEM_ID AS ȸ����ȣ,
                   MEM_NAME AS ȸ����,
                   MEM_HP AS ��ȭ��ȣ,
                   MEM_MILEAGE AS ���ϸ���
              FROM MEMBER
              WHERE MEM_MILEAGE >= 3000;
              
           SELECT * FROM V_MEM01;
           
 **�������̺� ����
  1. ������ȸ��(e001)�� ���� ���ϸ����� 2500���� ����  
    UPDATE MEMBER
       SET MEM_MILEAGE=2500
     WHERE MEM_ID='e001'; 
     
    SELECT *FROM V_MEM01; 
    
    ROLLBACK;
    COMMIT;
    
           
 2. �ű�ȸ����� 
    [�ڷ�]
    ȸ����ȣ : d002
    �̸� : �����
    ��ȣ : 1234
    �ֹι�ȣ : 010625-4236789
    �����ȣ : 34940
    �ּ�1 : ������ �߱� �߾ӷ� 76
    �ּ�2 : ���κ��� 3�� ������簳�߿�
    ����ȭ��ȣ : 042-222-8203
    ȸ����ȭ��ȣ : 042-222-8202
    ���� : hungil@naver.com
    
    INSERT INTO MEMBER(MEM_ID,MEM_PASS,MEM_NAME,MEM_REGNO1,MEM_REGNO2,
                       MEM_ZIP,MEM_ADD1,MEM_ADD2,MEM_HOMETEL,MEM_COMTEL,
                       MEM_MAIL,MEM_MILEAGE)
            VALUES('d002','1234','�����','010625','4236789','34940',
                    '������ �߱� �߾ӷ� 76','���κ��� 3�� ������簳�߿�',
                    '042-222-8203','042-222-8202','hungil@naver.com',6700);
                       
    SELECT * FROM V_MEM01;
    COMMIT;
    
**���� �ڷḦ ����
  1. �䳻�� ������ȸ��(v001)�� ���ϸ����� 1300���� ����
    UPDATE V_MEM01 
       SET MILE=1300
     WHERE MID='v001';
    
    SELECT * FROM V_MEM01;
    
    SELECT MEM_ID,MEM_NAME,MEM_MILEAGE
      FROM MEMBER
     WHERE MEM_ID='v001'; 
  2. �信�� ������ȸ���ڷḦ ����
    DELETE
      FROM V_MEM01
      WHERE MEM_ID='e001';
      
      
       CREATE OR REPLACE VIEW V_MEM01(MEM_ID,MEM_NAME,MEM_HP,MEM_MILEAGE)
        AS
            SELECT MEM_ID AS ȸ����ȣ,
                   MEM_NAME AS ȸ����,
                   MEM_HP AS ��ȭ��ȣ,
                   MEM_MILEAGE AS ���ϸ���
              FROM MEMBER
              WHERE MEM_MILEAGE>=3000
              
              WITH CHECK OPTION;
              
           SELECT * FROM V_MEM01;
           COMMIT;
           
**�������̺� ����
  1. ������ȸ��(v001)�� ���ϸ����� 5300���� ����
    UPDATE MEMBER
       SET MEM_MILEAGE=5300
       WHERE MEM_ID='v001'   
  2.�����ȸ��(d002)�� �ڷ����
    DELETE
      FROM MEMBER
     WHERE MEM_ID='d002';
     
     SELECT * FROM V_MEM01;
     
    
 **���� �ڷ� ����
 1. ������ȸ��(v001)�� ���ϸ����� 2300���� ����
    UPDATE V_MEM01
    SET MEM_MILEAGE=2300
    WHERE MEM_ID='v001';
    
 2. ������ȸ��(s001)�� ���ϸ����� 7200���� ����
    UPDATE V_MEM01
    SET MEM_MILEAGE=7200
    WHERE MEM_ID='s001';
    
     CREATE OR REPLACE VIEW V_MEM01
        AS
            SELECT MEM_ID, 
                   MEM_NAME, 
                   MEM_HP, 
                   MEM_MILEAGE
              FROM MEMBER
             WHERE MEM_MILEAGE>=3000
              
              WITH READ ONLY;
    
��뿹)2005�� 5�� ��ǰ�� ��������踦 ���̾�׷��� �����ϱ� ���� �並 �����Ͻÿ�
      ���̾�׷��� �����ϱ����� �ڷ�� ��ǰ��,�����,�������
      �б����� ��� �����Ͻÿ�.(���̸��� V_SUM01�̴�)
      (SELECT ��)
      CREATE OR REPLACE VIEW V_SUM01
      AS
        SELECT B.PROD_NAME AS PNAME,
               SUM(A.CART_QTY*B.PROD_PRICE) AS PSUM,
               SUM(A.CART_QTY) AS PCNT
          FROM CART A, PROD B
         WHERE A.CART_PROD=B.PROD_ID
           AND A.CART_NO LIKE '200505%'
         GROUP BY B.PROD_NAME
        
        WITH READ ONLY;

    SELECT * FROM V_SUM01;