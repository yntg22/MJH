2021-1102-02)SQL���
 - �˻���� (SELECT), 
   ������ ���۾�(Data Manipulation Language(DML) : 
               --INSERT,UPDATE,DELETE)
   ���������Ǿ�(Data Definition Language(DDL) :
               --CREATE,ALTER,DROP)
   �����������(Data Control Language(DCL) :
               --GRANT(���Ѻο�),REVOKE(����ȸ��),COMMIT,ROLLBACK(������) ��)
               
                --�ѱ�3BYTE ����1BYTE
   1.�ڷ���
    - ����Ŭ���� ����ϴ� �ڷ������� ���ڿ�,����,��¥,2���ڷ����� ����
                                                               UTF-8 �ٱ��� �ڵ� N�� ���� NVARCHAR,NCLOB ��
    1)���ڿ� ��
     . ����Ŭ�� ���ڿ� �ڷ� Ÿ���� �������� Ÿ�԰� �������� Ÿ������ ����
     . CHAR, VARCHAR,VARCHAR2,NVARCHAR,LONG,CLOB,NCLOB ���� ���� (variable �پ���) 
     . ���ڿ� �ڷ�� ' ' �� ���� �ڷ�� ��ҹ��� ����
     (1)CHAR(n [BYTE|CHAR]) 
      -- �������� ���ڿ� ����
      - �ִ� 2000BYTE ���� ó�� ����
      -- �ַ� �⺻Ű�� ���̰� ������ �׸�(�ֹε�Ϲ�ȣ ��)�� ���
      - ���ʺ��� ����ǰ� ���� ������ ������ ä����      
      - '[BYTE|CHAR]': n�� BYTE ������ ���ڼ�(CHAR)���� ����
      - default �� BYTE��
      - �ѱ� �ѱ��ڴ� 3BYTE�� ���(���� CHAR(2000CHAR)��
        ����ǵ� 666���ڸ� �ʰ��� �� ����
        
��뿹)
      CREATE TABLE TEMP1(
        COL1 CHAR(20),
        COL2 CHAR(20BYTE),
        COL3 CHAR(20 CHAR));
        
        INSERT INTO TEMP1
          VALUES('������ �߱�','������','������ �߱�');
        INSERT INTO TEMP1
          VALUES('������ �߱�','������','������ ���ﵿ'); 
        
        SELECT * FROM TEMP1;
        
        SELECT LENGTHB(COL1), --LENGHT + (BYTE)
               LENGTHB(COL2),
               LENGTHB(COL3)
            FROM TEMP1;
        
     (2)VARCHAR2 (n [BYTE|CHAR])
       -- �������� ������ ����
       -- VARCHAR�� ���ϱ��
       -- �ִ� 4000BYTE ���� ���� ����
       -- ���� �θ� ���Ǵ� �ڷ�Ÿ��
       - NVARCHAR2�� �ٱ��� ���� ������
��뿹)
        CREATE TABLE TEMP2(
            COL1 VARCHAR(4000),
            COL2 VARCHAR2(4000 BYTE),
            COL3 VARCHAR2(4000 CHAR));
            
        INSERT INTO TEMP2 VALUES('APPLE,PERSIMMON,APPLE',
            '���ѹα��� ���� ��ȭ���̴�','IL POSTINO');
            
        SELECT * FROM TEMP2;
        SELECT LENGTHB(COL1),
               LENGTHB(COL2),
               LENGTHB(COL3)
            FROM TEMP2;
    
    (3)LONG
     -- �������� ���ڿ� ����
     - �ִ� 2GB���� ������ ����
     -- �� ���̺� �ϳ��� �÷��� LONG Ÿ���� ���� ����(���ѻ���)
     - ��ɰ����� �����(CLOB�� ��ü)
     - SELECT���� SECLECT��, INSERT���� VALUES��, UPDATE���� SET���� ��밡��
     - �Ϻ� ���ڿ� �Լ��� LONGŸ���� �÷��� ����� �� ����
     - ���ڼ�,�����ͱ���? ���� 
     
��뿹)
    CREATE TABLE TEMP3(
            COL1 VARCHAR2(200),
            COL2 LONG,
            COL3 CLOB);
            
            INSERT INTO TEMP3 VALUES('APPLE,PERSIMMON,BANANA',
            '���ѹα��� ���� ��ȭ���̴�','IL POSTINO');
            
            SELECT * FROM TEMP3;
            
            SELECT LENGTHB(COL1),
                   LENGTH(COL3)
            FROM TEMP3;
           
     (4)CLOB (Character Large OBjects)
      - �������� ������ ����
      -- �ִ� 4GB���� ���� ����
      -- �� ���̺� �������� clob Ÿ�� ��� ���� (LONG�� ��)
      - �Ϻ� ��ɵ��� DBMS_LOB API ������ �޾ƾ� ��

��뿹)
    CREATE TABLE TEMP4(
        COL1 CLOB,
        COL2 CLOB,
        COL3 VARCHAR2(4000));
      
      INSERT INTO TEMP4 VALUES('APPLE,PERSIMMON,BANANA',
            '���ѹα��� ���� ��ȭ���̴�','IL POSTINO');
   
    SELECT * FROM TEMP4;
    SELECT LENGTH(COL1),
           LENGTH(COL2),
           LENGTH(COL3)
           FROM TEMP4;
           
           
           
           
           
           
        
            
    
            
            