2021-1117-01)집계함수...cont
 2)AVG([DISTINC|ALL] expr) 
  .'expr'로 기술된 수식,함수,컬럼 등에 저장된 데이터의 산술평균을 반환
  .'DISTINCT' : 중복된 값 제외
  .'ALL' : 중복된 값 포함, default임
  .'expr'에 컬럼이 사용되면 NULL 값은 제외되어 연산
  
사용예)사원테이블에서 각 부서별 평균임금을 조회하시오
    SELECT DEPARTMENT_ID AS 부서코드,
           ROUND(AVG(SALARY)) AS 평균임금
      FROM HR.EMPLOYEES
      GROUP BY DEPARTMENT_ID
      ORDER BY 1;
사용예)사원들의 평균임금을 조회하시오
    SELECT SUM(SALARY),
           ROUND(AVG(SALARY)) AS 평균임금
    FROM HR.EMPLOYEES;
사용예)사원테이블에서 부서별 평균임금이 전체사원의 평균임금보다
      많은 부서를 조회하시오
      SELECT A.DEPARTMENT_ID AS 부서코드,
             B.DEPARTMENT_NAME AS 부서명,
             ROUND(AVG(SALARY)) AS 평균급여
        FROM HR.EMPLOYEES A, HR.DEPARTMENTS B  --EMP DEP 에서
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID  --부서코드가 같은
         GROUP BY A.DEPARTMENT_ID,B.DEPARTMENT_NAME --부서코드와 부서명을 그룹
         HAVING AVG(SALARY)>=(SELECT AVG(SALARY) --전체평균급여보다 
                 FROM HR.EMPLOYEES)
         ORDER BY 1;
사용예)제품테이블에서 분류별 평균매입가격,평균판매가격을 조회하시오
        SELECT PROD_LGU AS 분류별,
               B.LPROD_NM AS 분류명,
               ROUND(AVG(PROD_COST)) AS 평균매입가격,
               TRUNC(AVG(PROD_PRICE)) AS 평균판매가격
          FROM PROD A, LPROD B
          WHERE A.PROD_LGU=B.LPROD_GU
          GROUP BY A.PROD_LGU,B.LPROD_NM
          ORDER BY 1;
        
        
사용예)장바구니테이블에서 회원들의 월별 평균구매금액을 조회하시오
        SELECT SUBSTR(CART_NO,5,2)||'월' AS 월,
               ROUND(AVG(PROD_PRICE*CART_QTY)) AS 평균구매금액
          FROM CART A, PROD B
          WHERE A.CART_PROD = B.PROD_ID
          GROUP BY SUBSTR(CART_NO,5,2)
          ORDER BY 1;
          
    /*      SELECT SUBSTR(A.CART_NO,5,2)||'월' AS 월,
                 ROUND(AVG(A.CART_QTY*B.PROD_PRICE)) AS 평균구매금액
            FROM CART A, PROD B
            WHERE CART_NO LIKE '2005%' --일반조건
              AND A.CART_PROD=B.PROD_ID --조인조건(PROD_PRICE 추출)
            GROUP BY SUBSTR(A.CART_NO,5,2)
            ORDER BY 1;
           */ 
           
    3)COUNT(*|expr)
    .각 그룹내의 자료의 수(행의 수)를 반환
    .외부조인에 COUNT함수가 사용될 경우 '*' 대신 해당 테이블의 기본키 컬럼을
     기술해야 함
    .NULL값도 포함하여 행수를 반환함
    
사용예)각 부서별 사원수와 평균임금을 조회하시오
        SELECT  DEPARTMENT_ID AS 부서코드,
                COUNT(EMPLOYEE_ID) AS 사원수1,
                COUNT(*) AS 사원수2,
                ROUND(AVG(SALARY)) AS 평균임금
          FROM HR.EMPLOYEES
          GROUP BY DEPARTMENT_ID
          ORDER BY 1;
           
사용예)장바구니테이블에서 2005년 5월 일자별 판매건수를 조회하시오.
      단, 판매건수가 10회 이상되는 자료만 조회하시오
      SELECT SUBSTR(CART_NO,7,2)||'일' AS 일,
             COUNT(*) AS 판매건수
        FROM CART
        WHERE CART_NO LIKE '200505%' 
        GROUP BY SUBSTR(CART_NO,7,2)
        HAVING COUNT(*)>=5
          ORDER BY 2 DESC;
          
사용예)2005년 2월 모든 상품별 매입집계를 조회하시오
      Alias는 상품코드,상품명,매입건수,매입수량합계,매입금액합계이며
      매입발생되지 않은 상품의 집계는 0으로 표시하시오
      
      (2005년 2월 매입된 상품의 가지수)
          SELECT COUNT(DISTINCT BUY_PROD)
          FROM BUYPROD
          WHERE BUY_DATE BETWEEN TO_DATE('20050201') AND LAST_DAY(TO_DATE('20050203'));
          
        (ANSI OUTER JOIN)
            SELECT B.PROD_ID AS 상품코드,
                   B.PROD_NAME AS 상품명,
                   COUNT(A.BUY_PROD) AS 매입건수,
                   NVL(SUM(A.BUY_QTY),0) AS 매입수량합계,
                   NVL(SUM(A.BUY_QTY*B.PROD_COST),0) AS 매입금액합계
              FROM BUYPROD A
              RIGHT OUTER JOIN PROD B ON(A.BUY_PROD=B.PROD_ID AND
                    A.BUY_DATE BETWEEN TO_DATE('20050201') AND LAST_DAY(TO_DATE('20050201')))
                GROUP BY B.PROD_ID,B.PROD_NAME
                ORDER BY 1;
             
           
           
           
           
           
           
           
           