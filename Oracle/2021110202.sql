2021-1102-02)SQL명령
 - 검색명령 (SELECT), 
   데이터 조작어(Data Manipulation Language(DML) : 
               --INSERT,UPDATE,DELETE)
   데이터정의어(Data Definition Language(DDL) :
               --CREATE,ALTER,DROP)
   데이터제어어(Data Control Language(DCL) :
               --GRANT(권한부여),REVOKE(권한회수),COMMIT,ROLLBACK(명령취소) 등)
               
                --한글3BYTE 영어1BYTE
   1.자료형
    - 오라클에서 사용하는 자료형에는 문자열,숫자,날짜,2진자료형이 존재
                                                               UTF-8 다국적 코드 N이 붙은 NVARCHAR,NCLOB 등
    1)문자열 형
     . 오라클의 문자열 자료 타입은 고정길이 타입과 가변길이 타입으로 구분
     . CHAR, VARCHAR,VARCHAR2,NVARCHAR,LONG,CLOB,NCLOB 등이 제공 (variable 다양한) 
     . 문자열 자료는 ' ' 로 묶인 자료로 대소문자 구별
     (1)CHAR(n [BYTE|CHAR]) 
      -- 고정길이 문자열 저장
      - 최대 2000BYTE 까지 처리 가능
      -- 주로 기본키나 길이가 고정된 항목(주민등록번호 등)에 사용
      - 왼쪽부터 저장되고 남는 공간은 공백이 채워짐      
      - '[BYTE|CHAR]': n이 BYTE 수인지 글자수(CHAR)인지 구별
      - default 는 BYTE임
      - 한글 한글자는 3BYTE로 취급(따라서 CHAR(2000CHAR)로
        선언되도 666글자를 초과할 수 없음
        
사용예)
      CREATE TABLE TEMP1(
        COL1 CHAR(20),
        COL2 CHAR(20BYTE),
        COL3 CHAR(20 CHAR));
        
        INSERT INTO TEMP1
          VALUES('대전시 중구','대전시','대전시 중구');
        INSERT INTO TEMP1
          VALUES('대전시 중구','대전시','대전시 대흥동'); 
        
        SELECT * FROM TEMP1;
        
        SELECT LENGTHB(COL1), --LENGHT + (BYTE)
               LENGTHB(COL2),
               LENGTHB(COL3)
            FROM TEMP1;
        
     (2)VARCHAR2 (n [BYTE|CHAR])
       -- 가변길이 데이터 저장
       -- VARCHAR와 동일기능
       -- 최대 4000BYTE 까지 저장 가능
       -- 가장 널리 사용되는 자료타입
       - NVARCHAR2는 다국어 지원 형식임
사용예)
        CREATE TABLE TEMP2(
            COL1 VARCHAR(4000),
            COL2 VARCHAR2(4000 BYTE),
            COL3 VARCHAR2(4000 CHAR));
            
        INSERT INTO TEMP2 VALUES('APPLE,PERSIMMON,APPLE',
            '대한민국은 민주 공화국이다','IL POSTINO');
            
        SELECT * FROM TEMP2;
        SELECT LENGTHB(COL1),
               LENGTHB(COL2),
               LENGTHB(COL3)
            FROM TEMP2;
    
    (3)LONG
     -- 가변길이 문자열 저장
     - 최대 2GB까지 데이터 저장
     -- 한 테이블에 하나의 컬럼만 LONG 타입을 선언 가능(제한사항)
     - 기능개선이 종료됨(CLOB로 대체)
     - SELECT문의 SECLECT절, INSERT문의 VALUES절, UPDATE문의 SET절에 사용가능
     - 일부 문자열 함수는 LONG타입의 컬럼에 적용될 수 없음
     - 글자수,데이터길이? 못샘 
     
사용예)
    CREATE TABLE TEMP3(
            COL1 VARCHAR2(200),
            COL2 LONG,
            COL3 CLOB);
            
            INSERT INTO TEMP3 VALUES('APPLE,PERSIMMON,BANANA',
            '대한민국은 민주 공화국이다','IL POSTINO');
            
            SELECT * FROM TEMP3;
            
            SELECT LENGTHB(COL1),
                   LENGTH(COL3)
            FROM TEMP3;
           
     (4)CLOB (Character Large OBjects)
      - 가변길이 데이터 저장
      -- 최대 4GB까지 저장 가능
      -- 한 테이블에 복수개의 clob 타입 사용 가능 (LONG과 비교)
      - 일부 기능들은 DBMS_LOB API 지원을 받아야 함

사용예)
    CREATE TABLE TEMP4(
        COL1 CLOB,
        COL2 CLOB,
        COL3 VARCHAR2(4000));
      
      INSERT INTO TEMP4 VALUES('APPLE,PERSIMMON,BANANA',
            '대한민국은 민주 공화국이다','IL POSTINO');
   
    SELECT * FROM TEMP4;
    SELECT LENGTH(COL1),
           LENGTH(COL2),
           LENGTH(COL3)
           FROM TEMP4;
           
           
           
           
           
           
        
            
    
            
            