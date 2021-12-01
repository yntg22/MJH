2021-1129-03)
 2. SEQUENCE
  - 순차적인 값을 생성하기위한 개체
  - 테이블과 독립적인 값 생성
  - 시퀀스가 사용되는 곳
  . 적당한 기본키를 찾지 못한 경우
  . 자동적으로 증가(감소)되는 값이 필요한 경우(ex)CART_NO의 뒷자리 5글자 등)
  (사용형식)
 CREATE SEQUENCE 시퀀스명
   [START WITH n] --시작값 설정 기본은 MIN_VALUE
   [INCREMENT BY n] --증가[감소] 값
   [MAXVALUE n|NOMAXVALUE] --최대값 설정, default NOMAXVALUE 이며 10 ^ 27
   [MINVALUE n|NOMINVALUE] --최소값 설정, default NOMINVALUE 이며 1이다
   [CYCLE|NOCYCLE] --최대[최소] 값까지 도달한 후 다시 생성여부 설정 default는 NOCYCLE
   [CACHE n|NOCACHE] --메모리에 미리 시퀀스 생성 할지 여부 default는 CACHE 20
   [ORDER|NOORDER] --제시된 조건대로 시퀀스 생성보장 여부

 **의사컬럼(Pseudo Column)
 -------------------------------------------------------------------
    의사컬럼                의미
 ----------------------------------------------------------------------
  시퀀스명.nextval      '시퀀스'의 다음 값
  시퀀스명.currval      '시퀀스'의 현재 값
 ---------------------------------------------------------------------
  **** 시퀀스가 생성된 후 적어도 최초의 한번은 nextval가 호출되어야
       해당 시퀀스가 값을 배정 받음

사용예) 다음 자료를 분류테이블에 삽입하시오.
     [자료]
     순번 : 10
     분류코드 : 'p501'
     분류명 : 농산물
     
     순번 : 11
     분류코드 : 'p502'
     분류명 : 농산가공식품
     
     순번 : 12
     분류코드 : 'p503'
     분류명 : 임산물
     
     **순번은 시퀀스를 사용할 것
     
     (시퀀스 생성)
     CREATE SEQUENCE SEQ_LPROD
        START WITH 10;
        
        SELECT SEQ_LPROD.CURRVAL FROM DUAL;
     (자료 삽입)
        INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
            VALUES(SEQ_LPROD.NEXTVAL,'P501','농산물');
        
        INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
            VALUES(SEQ_LPROD.NEXTVAL,'P502','농산가공식품');
        
        INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
            VALUES(SEQ_LPROD.NEXTVAL,'P503','임산물');
                  
        SELECT * FROM LPROD;
                                                                                                                           

    CREATE SEQUENCE SEQ_CART_NO
    START WITH 1
    MAXVALUE 99999;
    
        SELECT SEQ_CART_NO.NEXTVAL FROM DUAL;
        
        DROP SEQUENCE SEQ_CART_NO; --삭제
        
 3. 동의어(synonym)
  - 오라클 객체에 부여된 별도의 또다른 이름
  - 별칭(테이블)과의 차이점은 참조영역의 차이(테이블별칭 : 사용되는 sql 내부, 
    동의어는 모든 곳에서 사용)
  (사용형식)
    CREATE [OR REPLACE] SYNONYM 동의어 FOR 객체명;
     . '객체명' : 원본 객체명

사용예)HR계정의 사원테이블(HR.EMPLOYEES)에 동의어 EMP를 설정하시오
        CREATE OR REPLACE SYNONYM EMP FOR HR.EMPLOYEES;
        
        SELECT * FROM EMP; 
        DROP SYNONYM EMP; --삭제

