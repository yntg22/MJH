2021-1105-01) 검색명령(SELCET)
 - 표준 SQL명령 중 가장 많이 사용되는 명령
 - SELECT *|[DISTINCT/*중복제거*/]컬럼명 [AS 별칭][,]
          컬럼명 [AS 별칭][,]
               :
          컬럼명 [AS 별칭]
    FROM 테이블명 [별칭]
   [WHERE 조건] --행 생략시 모든행
   [GROUP BY 컬럼명[, 컬럼명, ...]] sum avg count max min 
   [HAVING 조건]
    [ORDER BY 컬럼명|컬럼인덱스 [ASC|DESC][, 컬럼명|컬럼인덱스 [ASC|DESC],...]];
    
    .'AS 별칭':컬럼에 부여되는 또다른 이름으로 출력시 컬럼제목으로 사용됨
               별칭에 특수문자(공백 등)를 사용하는 경우, 컬럼별칭으로 예약어를
               사용하기 위해서는 반드시 " "안에 기술 해야함
    .'테이블 별칭' : 테이블에 부여된 또 다른 이름으로 서로다른 테이블에 이름이
               동일한 컬럼을 참조하기 위하여 사용
    .'컬럼인덱스' : SELECT 절에서 컬럼명이 사용된 순서로 1번부터 부여
    .'ASC|DESC' : 정렬 방법으로 기본값은 ASC(오름차순)이며 DESC는 내림차순
    
사용예) 사원테이블에서 80번 부서에 소속되어있고 급여가 8000이상인 사원의
        사원번호,사원명,입사일,직무코드,급여를 조회하시오.단 입사일순으로 출력
        
        SELECT EMPLOYEE_ID AS 사원번호,FIRST_NAME||' '||LAST_NAME AS 사원명,
                HIRE_DATE AS 입사일,JOB_ID AS "직무 코드",SALARY AS 급여
        FROM EMPLOYEES 
        WHERE SALARY >= 8000
        AND DEPARTMENT_ID = 80 
        ORDER BY 입사일,급여/*3 사용가능 SELECT 3번째, HIRE_DATE*/ ASC;
        
    1)연산자
     . 사칙연산자(+,-,/,*)--나머지 MOD(0.0)
     . 관계연산자(>,<,>=,<=,=,!=(<>)):두 자료의 크기 비교 후 결과(참,거짓)
       반환
     . 논리연산자(NOT,AND,OR)
     . 기타연산자('||',IN,ANY,SOME,ALL,EXISTS,LIKE,BETWEEN 등)
     
     (1)사칙연산자
      - 이항연산 수행 후 결과값 반환
      - 오라클은 숫자 우선 형변환 수행
      - 나머지 연산, 증감연산은 제공되지 않음
사용예)SELECT 238+78,238/23,238*78,238-78,MOD(10,4)
        FROM DUAL;
        /* *DUAL : 시스템이 제공하는 가상의 테이블
                  FROM절에 사용할 테이블이 없는 경우 사용 */       
      
      SELECT MEM_ID AS 회원번호,
      MEM_NAME AS 회원명,
      MEM_REGNO1||' '||MEM_REGNO2 AS 주민번호,
      EXTRACT(YEAR FROM SYSDATE)- 
          TO_NUMBER('19'||SUBSTR(MEM_REGNO1,1,2)) AS 나이,/*연도추출 EXTRACT(YTEAR FROM SYSDATE) = 2021 SUBSTR'19'||MEM_REGNO1,2)19+앞 두자리 + 숫자로 형변환 = 1976  2021-1976= 45 */
      TRUNC(EXTRACT (YEAR FROM SYSDATE)-
          TO_NUMBER('19'||SUBSTR(MEM_REGNO1,1,2)),-1)||'대' AS 연령대
      FROM MEMBER;
      
      SELECT EMPLOYEE_ID AS 사원번호,
             FIRST_NAME||' '||LAST_NAME AS 사원명,
             TO_CHAR(SALARY,'99,999') AS 급여, /*TO_CHAR (문자값,형식) */
             TO_CHAR(NVL(SALARY*COMMISSION_PCT,0),'99,999') AS 보너스, /*NVL = NULL 치환*/
             TO_CHAR(SALARY+NVL(SALARY*COMMISSION_PCT,0),'99,999') AS 지급액
             FROM HR.EMPLOYEES;
             
            (DISTINCT 사용예: 회원테이블에서 회원들의 거주지별 회원수를 조회하시오)
                SELECT SUBSTR(MEM_ADD1,1,2) AS 거주지,
                       COUNT(*) AS 회원수
                FROM MEMBER
                GROUP BY SUBSTR(MEM_ADD1,1,2);
                
            DISTINCT 사용예 : 회원테이블에서 회원들의 거주지를 조회하시오
                SELECT DISTINCT SUBSTR(MEM_ADD1,1,2) AS 거주지
                FROM MEMBER;
                
            DISTINCT 사용예 : 상품테이블에서 사용된 분류코드를 조회하시오 
                SELECT DISTINCT A.PROD_LGU AS 분류코드, /*별칭사용 A , B*/
                       B.LPROD_NM AS 분류명
                FROM PROD A, LPROD B
                WHERE A.PROD_LGU=B.LPROD_GU
                ORDER BY 1; /*오름차순 내림차순*/
                
            (2)관계연산자
             - 데이터의 크기를 비교할때 사용
             - 결과가 참(TRUE)과 거짓(FALSE)으로 반환
             - 조건문 구성에 사용되며 주로 WHERE절의 조건 등에 사용
             - >, <, =, <=, >=, !=(<>)
            
사용예)회원테이블에서 보유마일리지가 5000이상인 회원을 조회하시오.
      Alias는 회원번호, 회원명, 생년월일, 마일리지이다
        SELECT MEM_ID AS 회원번호,
               MEM_NAME AS 회원명,
               MEM_BIR AS 생년월일,
               MEM_MILEAGE AS 마일리지
        FROM MEMBER
        WHERE MEM_MILEAGE >= 5000
        ORDER BY MEM_MILEAGE,2;
        
사용예)장바구니 테이블에서 2005년 4월 판매집계를 조회하시오
      Alias는 회원번호, 판매수량합계, 판매금액합계
        
        SELECT A.CART_MEMBER AS 회원번호,
               SUM(A.CART_QTY) AS 판매수량합계,
               SUM(A.CART_QTY*B.PROD_PRICE) AS 판매금액합계
        FROM CART A, PROD B
        WHERE A.CART_PROD=B.PROD_ID
        AND SUBSTR(CART_NO,1,8)>='20050401' AND SUBSTR(CART_NO,1,8)>='20050430'
        GROUP BY A.CART_MEMBER
        ORDER BY 3 DESC;
                
             
             SELECT TO_CHAR(NVL(0+1,0)) FROM DUAL; 

사용예)회원테이블에서 서울에 거주하는회원정보를 조회하시오
    Alias는 회원번호,회원명,주소,성별
    SELECT MEM_ID AS 회원번호,
    MEM_NAME AS 회원명,
    MEM_ADD1||' '||MEM_ADD2 AS 주소,
    CASE WHEN SUBSTR(MEM_REGNO2,1,1)='1' OR
              SUBSTR(MEM_REGNO2,1,1)='3' THEN 
                    '남성회원'
              ELSE
                    '여성회원'
              END AS 성별
              FROM MEMBER
              WHERE SUBSTR(MEM_ADD1,1,2) = '서울'; 

사용예)매입테이블(BUYPROD)에서 2005년 1월 날짜별 판매집계를 조회하시오.
      Alias는 날짜,매입수량합계,매입금액합계
      SELECT BUY_DATE AS 날짜,
             SUM(BUY_QTY) AS 매입수량합계,
             SUM(BUY_QTY*BUY_COST) AS 매입금액합계
        FROM BUYPROD
       WHERE BUY_DATE >= TO_DATE('20050101') AND --숫자>날짜>문자열
             BUY_DATE <= TO_DATE('20050131')
        GROUP BY BUY_DATE
        ORDER BY 1;
        
*** 테이블 삭제
    DROP TABLE 테이블명;
    . 테이블 삭제시 관계가 설정되어 있으면 자식테이블부터
      삭제해야 함(또는 관계를 삭제한 후 각 테이블 삭제 가능)
    ** TEMP1 ~ TEMP10 테이블을 삭제하시오
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
    



















      
    
