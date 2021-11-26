2021-1104-02)
  3)��¥ �ڷ���
   . ��¥ (��,��,��,��,��,��)�ڷḦ �����ϴ� ������Ÿ������ DATE, TIMESTAMP���� ����
   . TIMESTAMP�� 10����� 1���� �ð��ڷ�� �ð���(TIME ZONE)������ ����
   (1) DATE
    - �⺻ ��¥��
    - '+', '-' ������ ���
    ** SYSDATE : ��¥ �Լ� �� �ý����� ��¥ ������ ��ȯ�ϴ� �Լ�
(��뿹) CREATE TABLE TEMP6(
            COL1 DATE,
            COL2 DATE,
            COL3 DATE);
            
            INSERT INTO TEMP6
                VALUES(SYSDATE,SYSDATE-10,SYSDATE+10);
                
            SELECT * FROM TEMP6;
            --ȯ�漳������ ������ ��¥ ���Ĵ�� �����
            
            SELECT TO_CHAR(COL1,'YYYY-MM-DD HH24:MI:SS'),
                   TO_CHAR(COL2,'YYYY-MM-DD HH24:MI:SS'), 
                   TO_CHAR(COL3,'YYYY-MM-DD HH24:MI:SS')
                   FROM TEMP6;
            
  (2) TIME STAMP
     - ������ �ð������� �ð��� ������ ��ȯ�ϴ� ������ Ÿ��
     - TIMESTAMP, TIMESTAMP WITH TIME ZONE,
       TIMESTAMP WITH LOCAL TIME ZONE ZONE�� 3���� ���°� ����
    (�������)
      �÷��� TIMESTAMP |                          -- �ð��� ���� ���� ������ �ð����� ���� 
            TIMESTAMP WITH TIME ZONE |           -- �ð��� ������ ������ �ð����� ����
            TIMESTAMP WITH LOCAL TIME ZONE       -- ���ü����� �ð��� ������ ������ �ð����� ���� (TIMESTAMP�� ����)
      
��뿹) CREATE TABLE TEMP7(
        COL1 TIMESTAMP,
        COL2 TIMESTAMP WITH TIME ZONE,
        COL3 TIMESTAMP WITH LOCAL TIME ZONE);
         
        INSERT INTO TEMP7
        VALUES (SYSDATE,SYSDATE,SYSDATE);
        
        SELECT * FROM TEMP7;   
        
  4)��Ÿ �ڷ���
   . �����ڷḦ �����ϱ� ���� ������ Ÿ��
   . RAW, BFILE, BLOB Ÿ�� ����
   
   (1)RAW
    - ��������� ���� �����ڷ� ����
    - �ε��� ó�� ����
    - �ִ� 2000BYTE ���尡��
    - �ַ� ����, �����ڷ� ����
    - 16������ 2���� ���·� ���� ����
    - �����ͺ��̽����� �ؼ��̳� ��ȯ����� �������� ����
    (�������)
     �÷��� RAW(ũ��)
��뿹) CREATE TABLE TEMP8(
        COL1 RAW(200));

        INSERT INTO TEMP8 VALUES('10000100');
        INSERT INTO TEMP8 VALUES(HEXTORAW('84'));
         
        SELECT * FROM TEMP8;   
        
   (2)BFILE
    - ���� �ڷḦ ����
    - ���� �ڷ�� �����ͺ��̽� �ۿ� ����ǰ� �����ͺ��̽�����
      ��ο� ���ϸ� ����
    - 4GB ���� ���尡��
     (�������)
       �÷��� BFILE
       
     (���� ����)
      (a) �����ڷ� ����(�׸� ��) ����
          SAMPLE.jpg
      (b) �ش� �����ڷ� ������ ����� ��θ��� ���� ���丮��ü ����
          CREATE DIRECTORY ���丮�� AS ��θ�;
          
          CREATE DIRECTORY TEST_DIR AS 'D:\A_TeachingMaterial\2.Oracle';
      (c) '(a)'�� �ڷ� ����
          INSERT INTO TEMP9
            VALUES(BFILENAME('TEST_DIR','SAMPLE.jpg'));
      
��뿹) CREATE TABLE TEMP9(
        COL1 BFILE);
        
       SELECT * FROM TEMP9;
       
    (3)BLOB (Binary Large OBjects)
     - �����ڷḦ ����
     - �ִ� 4GB���� ���� ����
     - �����ڷḦ �����ͺ��̽� ���ο� ����
     (�������)
      �÷��� BLOB;
      
     (���� ����)
       (a)���̺� ����
          CREATE TABLE TEMP10 (
            COL1 BLOB);
            
       (b)���丮��ü ���� �� �������� �غ�
          TEST_DIR, SAMPLE.jpg
          
       (c)PL/SQL�� ��� ������ Ȱ���Ͽ� �ڷ� ����
          --�͸���
          DECLARE
            L_DIR VARCHAR2(30):='TEST_DIR';
            L_FILE VARCHAR2(30):='SAMPLE.jpg';
            L_BFILE BFILE;
            L_BLOB BLOB;
          BEGIN
            INSERT INTO TEMP10(COL1) VALUES(EMPTY_BLOB())
              RETURN COL1 INTO L_BLOB; --�÷��ʱ�ȭ �� ����
            
            L_BFILE:=BFILENAME(L_DIR,L_FILE);
            DBMS_LOB.FILEOPEN(L_BFILE,DBMS_LOB.FILE_READONLY);
            DBMS_LOB.LOADFROMFILE(L_BLOB,L_BFILE,DBMS_LOB.GETLENGTH(L_BFILE));
            DBMS_LOB.FILECLOSE(L_BFILE);
            
            COMMIT;
        END;
       
       SELECT * FROM TEMP10;
       
       
      
        
        
        
        
        
        