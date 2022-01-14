2021-1130-05)CURSOR
 - SQL명령에 의하여 영향받은 행들의 집합
 - SELECT 문의 결과 집합
 - 묵시적 커서 (Implicit Cursor)와 명시적 커서(Explicit Cursor)로 구분
 1)묵시적 커서 (Implicit Cursor)
  . 이름이 없는 커서
  . SQL문장이 실행과 동시에 내부적으로 묵시적 커서가 만들어짐
  (커서속성)
  -------------------------------------------------------------------
  속성                    의미
  -------------------------------------------------------------------
  SQL%FOUND         결과집합에 FETCH ROW수(행의 갯수)가 1개라도 있으면 참
  SQL%NOTFOUND      결과집합에 FETCH ROW수가 없으면 참, 있으면 거짓
  SQL%ROWCOUNT      결과집합의 ROW수 반환
  SQL%ISOPEN        커서가 OPEN상태면 참(묵시적커서는 항상 거짓임)
  
 2)명시적 커서 (Explicit Cursor)
  . 이름이 있는 커서
  . 커서의 사용은 선언 => OPEN => FETCH => CLOSE 단계로 수행
  (1)커서 선언
    . DECLARE 영역에서 선언
    (선언형식)
    CURSOR 커서명[(매개변수list)]
    IS
      SELECT 문;
     .'매개변수list':커서 실행시 사용될 데이터를 전달받을 변수로
      변수명 데이터타입 형식으로 기술되며 데이터는 OPEN문에서 제공한다
      
  (2)OPEN 문
    . 사용할 커서열기
    . BEGIN 블록에서 사용
    
    (사용형식)
       OPEN 커서명[(매개변수list)]
       
  (3)FETCH 문
    . 커서내의 자료를 행단위로 읽어오는 명령(READ문과 유사 기능)
    . 보통 번복명령 안에 위치
    (사용형식)
    FETCH 커서명 INTO 변수,변수,...변수;
    . 커서내의 SELECT 절의 컬럼수와 INTO절의 변수의 갯수, 순서, 데이터 타입이 일치해야 함
    . 커서내에 더이상 FETCH할 ROW가 없으면 커서속성 커서명%NOTFOUND가 참이됨
    . 커서속성은 묵시적 커서속성과 같으나 'SQL'대신 커서명이 기술됨 --FOR문은 안써도됨
      ex)커서명%FOUND,커서명%NOTFOUND,커서명%ISOPEN,커서명%ROWCOUNT,...
      
  (4)CLOSE 문
    . 사용이 종료된 커서는 반드시 CLOSE 해야함
    (사용형식)
    CLOSE 커서명
    
사용예)사원테이블에서 80번부서에 속한 사원의 이름,입사일,직무코드를
      출력하는 블록을 커서를 이용하여 작성하시오.
      
   (커서부분:해당부서에 속한 사원명,직무코드,입사일을 출력)
       SELECT EMP_NAME,JOB_ID,HIRE_DATE
         FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID=80; 
   
   (LOOP명령 사용)     
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
          FETCH CUR_EMP INTO V_ENAME,V_JID,V_HDATE;--EXIT 아래로 FETCH가 내려오면 안된다. 
          EXIT WHEN CUR_EMP%NOTFOUND;
          DBMS_OUTPUT.PUT_LINE('사원명 : '||V_ENAME);
          DBMS_OUTPUT.PUT_LINE('직무코드 : '||V_JID);
          DBMS_OUTPUT.PUT_LINE('입사일 : '||V_HDATE);
          DBMS_OUTPUT.PUT_LINE('--------------------------');
         END LOOP;
         DBMS_OUTPUT.PUT_LINE('사원수 : '||CUR_EMP%ROWCOUNT);
         CLOSE CUR_EMP;
       END;
       
사용예)회원테이블에서 마일리지가 많은 5사람을 조회하고, 그 회원들이 2005년도
      구매집계를 조회하시오.
   (마일리지가 많은 5인 추출)
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
             
         DBMS_OUTPUT.PUT_LINE('회원번호 : '||V_MID);    
         DBMS_OUTPUT.PUT_LINE('회원명 : '||V_MNAME);
         DBMS_OUTPUT.PUT_LINE('구매금액 : '||V_SUM);
         DBMS_OUTPUT.PUT_LINE('--------------------------------');
       END LOOP;
       CLOSE CUR_MILEAGE;             
      END;
       