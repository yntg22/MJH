2021-1130-01)INDEX ��ü --ã�� �ӵ��� �������ϱ� ���� ���
 - �������� �˻� ȿ���� ���� ��Ű�� ���� ��ü
 - DBMS�� ���ϸ� �ٿ� ��ü DB�� ������ ���
 - WHERE ����, GROUP BY�� �����÷�, ORDER BY�� ���� �÷� �
   �ε����� ����ϸ� ó�� �ӵ��� ���� ��Ŵ
 - ������ �������� �ڿ��� �ҿ��
 - ���ؽ��� ����
  . Unique/Non-Unique
   - �ߺ�������� ���ο� �ٸ� �з��� Unique�ε����� ��� null��
     �ϳ��� ���(��, Primary �Ǵ� Foreign ����� ��� �ȵ�)
  . Normal Index(B-Tree Index)
   - �⺻�ε���
   - �÷� ���� rowid(������ ��ġ����)�� ������� �ּҰ��
   
  . Bitmap Index
   - Cardinality�� ������� ȿ������ �ε���
   - �÷� ���� rowid(������ ��ġ����)�� �����ڷ�� ��ȯ�Ͽ� �� ��Ʈ��
     �������� �ּ� ����
   - ������ ������ ���� ��� ��ȿ����
   
  . Function-Based Normal Index
   - �Լ��� ����� �÷��� �������� �ε��� ����
   - ���������� �ش� �Լ��� �״�� ���Ǵ� ��� ȿ����
 (�������)  
     CREATE [UNIQUE|BITMAP] INDEX �ε�����
        ON ���̺��(�÷���1[,�÷���2,...]) [ASC|DESC];
      . '���̺��' : �ε����� ����̵Ǵ� ���̺� 
      . 'ASC|DESC' :  �ε����� ������ ��������/������������ ����,default�� ASC
      
��뿹)��ǰ���̺��� ��ǰ�̸����� �⺻ �ε����� �����Ͻÿ�
      CREATE INDEX IDX_PROD_NAME
         ON PROD(PROD_NAME);
      
  ** �ε��� ����
     DROP INDEX �ε�����;
      DROP INDEX IDX_PROD_NAME;
      
     SELECT * FROM PROD
      WHERE PROD_NAME ='��� VTR 6���';
   
��뿹)��ٱ������̺��� ��ǰ�ڵ�� �⺻ �ε����� �����Ͻÿ� 
      CREATE INDEX IDX_CART_PROD
        ON CART(CART_PROD);
        
        
      SELECT * FROM CART
       WHERE CART_PROD='P202000003'
        

��뿹)ȸ�����̺��� ȸ���� ������Ϸ� �⺻ �ε����� �����Ͻÿ� 
      CREATE INDEX IDX_MEM_BIR
        ON MEMBER(MEM_BIR);
        
        
      SELECT * 
        FROM MEMBER
       WHERE MEM_BIR=TO_DATE('1976/05/06'); 
       
��뿹)ȸ�����̺��� ȸ���� �ֹι�ȣ �ι�° �׷� ���ڸ� 5�ڸ��� �ε����� �����Ͻÿ� 
      CREATE INDEX IDX_MEM_REGNO
        ON MEMBER(SUBSTR(MEM_REGNO2,1,5));
        
(�ε��� �籸��)
  - ���̺�� �ε��� ������ ������ġ�� ����Ȱ��(���̺� �����̽� ����)
  - �������� ����(����/���� ��)�� ���� �߻��� ���
  (�������)
    ALTER INDEX �ε����� REBUILD;
        
        
