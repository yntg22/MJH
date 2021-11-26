2021-1116-01)
 4. 변환함수
   - 오라클에서 사용하는 데이터의 형변환을 담당
   - CAST, TO_CHAR, TO_DATE, TO_NUMBER 함수 제공
   
   1)CAST(expr AS 타입명)
    . 'expr'로 제시된 데이터나 컬럼 값이 '타입명'으로 형이 변환됨
    
사용예) SELECT 1234,CAST(1234 AS VARCHAR(10)) AS "COL1",
            CAST(1234 AS CHAR(10)) AS "COL2"
        FROM DUAL;
사용예)2005년 7월 일자별 판매집계를 조회하시오
        Alias는 일자,판매수량합계,판매금액합계
        
        SELECT CAST(SUBSTR(A.CART_NO,1,8) AS DATE) AS 일자,
               SUM(A.CART_QTY) AS 판매수량합계,
               SUM(A.CART_QTY*B.PROD_PRICE) AS 판매금액합계
          FROM CART A, PROD B
          WHERE A.CART_PROD=B.PROD_ID
            AND A.CART_NO LIKE '200507%'
            GROUP BY SUBSTR(A.CART_NO,1,8)
            ORDER BY 1;
            CREATE TABLE OPOP(OPOP1 NUMBER(1));
            DROP TABLE OPOP;
 2)TO_CHAR(expr[, 'fmt'])
  . 숫자, 날짜, 문자열 타입을 문자열 타입으로 변환
  . 'expr'이 문자열인 경우 CHAR,CLOB타입을 VARCHAR2로 변환만 가능
  . 'fmt' : 변환하려는 형식지정문자열로 날짜와 숫자형으로 분리
  . 날짜형 FORMAT STRING
  -------------------------------------------------------------
  형식지정문자열       의미          사용예
  -------------------------------------------------------------
  AD, BC             서기           SELECT TO_CHAR(SYSDATE,'BC') FROM DUAL;
  CC                 세기           SELECT TO_CHAR(SYSDATE,'BC CC') FROM DUAL;            
  YYYY,YYY,YY,Y      년도           SELECT TO_CHAR(SYSDATE,'CC YYYY') FROM DUAL;
  MONTH.MON.MM.RM    월             SELECT TO_CHAR(SYSDATE,'YYYYMMDD MONTH') FROM DUAL;
  DD,DDD,J           일             SELECT TO_CHAR(SYSDATE,'YYMMDD DDD D') FROM DUAL;
  DAY,DY,D           요일           SELECT TO_CHAR(SYSDATE,'YYMMDD DAY DY J') FROM DUAL;           
  Q                  분기           SELECT TO_CHAR(SYSDATE, 'YYMMDD Q') FROM DUAL;
  AM,PM,A.M., P.M.   오전/오후       SELECT TO_CHAR(SYSDATE, 'YYMMDD AM PM A.M. P.M.') FROM DUAL;
  HH,HH24,HH12       시             SELECT TO_CHAR(SYSDATE,'YYMMDD HH, HH12 HH24') FROM DUAL;
  MI                 분             SELECT TO_CHAR(SYSDATE, 'YYMMDD HH24 : MI : SS') FROM DUAL;
  SS,SSSSS           초             SELECT TO_CHAR(SYSDATE, 'YYMMDD HH24:MI:SS SSSSS') FROM DUAL;
  "사용자지정"                       SELECT TO_CHAR(SYSDATE, 'YY"년" MM"월" DD"일" HH24:MI:SS SSSSS') FROM DUAL;
  ----------------------------------------------------------------
  . 숫자형 FORMAT STRING
  ------------------------------------------------------------------
  형식지정문자열           의미                      사용예
  -------------------------------------------------------------------
       9          무효의 0을 공백처리                SELECT TO_CHAR(1234, '99,999') FROM DUAL;
       0          무효의 0을 '0'출력처리             SELECT TO_CHAR(1234, '00,000') FROM DUAL;
      $,L         숫자 왼쪽에 화폐기호               SELECT TO_CHAR (1234, 'L00,000') FROM DUAL;
       MI         음수인 경우 우측에 '-' 부호 출력    SELECT TO_CHAR(-1234, '00,000MI') FROM DUAL;
       PR         음수를 '< >'안에 표현              SELECT TO_CHAR(-1234, '00,000PR') FROM DUAL;
    ,(COMMA)      3자리마다의 자리점                 SELECT TO_CHAR(1234567, '99,999')FROM DUAL;
     .(DOT)       소수점                           SELECT TO_CHAR(12.323, '99.9999') FROM DUAL;
  ----------------------------------------------------------------------
 
  3) TO_NUMBER(expr[,'fmt'])
   . 'expr'(문자열 자료)을 숫자형 자료로 변환  
   . 'expr'은 반드시 숫자로 변환 가능해야함
   . 'fmt'는 TO_CHAR의 숫자 형식지정문자열과 동일하나 숫자로 취급될수 있는
     문자열만 가능('9', '.' 등)
사용예) SELECT TO_NUMBER(MEM_BIR)
         FROM MEMBER;
    
    SELECT TO_NUMBER('12,345', '99999'),
           TO_NUMBER('<12,345>', '99999PR'),
           TO_NUMBER('￦12,345', 'L00000')
    FROM DUAL; 
    
 4)TO_DATE(expr[,'fmt'])
  . 사용되는 'fmt'는 TO_CHAR변환함수에 사용하는 형식지정문자열이 사용되나 날짜로 변환될 수
    있는 문자열 이어야함
  . 문자열자료('expr')을 날짜로 변환
            
사용예)SELECT TO_DATE('20210228'),
             TO_DATE('20210220161759','YYYYMMDDHH24MISS')
        FROM DUAL;
            
            
            
            
            
            
            
            
            
            