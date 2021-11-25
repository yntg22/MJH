2021-124-01)조인 cont...

사용예)장바구니테이블을 이용하여 2005년 4-6월 월별,회원별 구매집계를
      조회하시오
      Alias는 월,회원번호,회원명,구매수량합계,구매금액합계
      SELECT SUBSTR(A.CART_NO,5,2) AS 월,
             A.CART_MEMBER AS 회원번호,
             C.MEM_NAME AS 회원명,
             SUM(A.CART_QTY) AS 구매수량합계,
             SUM(A.CART_QTY*B.PROD_PRICE) AS 구매금액합계
      FROM CART A,PROD B, MEMBER C
      WHERE A.CART_PROD=B.PROD_ID
        AND A.CART_MEMBER=C.MEM_ID
        AND SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506'
        GROUP BY C.MEM_NAME,A.CART_MEMBER,SUBSTR(A.CART_NO,5,2)
        ORDER BY 1;
        
        
     /*ANSI JOIN*/
        SELECT SUBSTR(A.CART_NO,5,2) AS 월,
             A.CART_MEMBER AS 회원번호,
             C.MEM_NAME AS 회원명,
             SUM(A.CART_QTY) AS 구매수량합계,
             SUM(A.CART_QTY*B.PROD_PRICE) AS 구매금액합계
         FROM CART A
         INNER JOIN PROD B ON (A.CART_PROD=B.PROD_ID)
         INNER JOIN MEMBER C ON (A.CART_MEMBER=C.MEM_ID
                                AND SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506')
        GROUP BY C.MEM_NAME,A.CART_MEMBER,SUBSTR(A.CART_NO,5,2)
        ORDER BY 1;
       
        
사용예)장바구니테이블을 이용하여 2005년 4-6월 분류별 판매집계를 조회하시오
      Alias는 분류코드,분류명,판매수량합계,판매금액합계
      SELECT B.PROD_LGU AS 분류코드,
             C.LPROD_NM AS 분류명,
             SUM(A.CART_QTY) AS 판매수량합계,
             SUM(A.CART_QTY*B.PROD_PRICE) AS 판매금액합계
        FROM CART A, PROD B, LPROD C
        WHERE A.CART_PROD=B.PROD_ID
          AND B.PROD_LGU=C.LPROD_GU
          AND SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506'
        GROUP BY C.LPROD_NM, B.PROD_LGU
        ORDER BY 1;
        
      (ANSI JOIN)  
        SELECT B.PROD_LGU AS 분류코드,
             C.LPROD_NM AS 분류명,
             SUM(A.CART_QTY) AS 판매수량합계,
             SUM(A.CART_QTY*B.PROD_PRICE) AS 판매금액합계
        FROM CART A
        INNER JOIN PROD B ON (A.CART_PROD=B.PROD_ID)
        INNER JOIN LPROD C ON (B.PROD_LGU=C.LPROD_GU AND 
                               SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506') 
        GROUP BY C.LPROD_NM, B.PROD_LGU
        ORDER BY 1;
      
사용예)사원테이블에서 미국 이외의 국가에서 근무하는 사원정보를 조회하시오
      Alias는 사원번호,사원명,부서코드,부서명,국가코드
      SELECT A.EMPLOYEE_ID AS 사원번호,
             A.EMP_NAME AS 사원명,
             B.DEPARTMENT_ID AS 부서코드,
             B.DEPARTMENT_NAME AS 부서명,
             C.STREET_ADDRESS||', '||C.CITY||' '||C.STATE_PROVINCE AS 주소,
             D.COUNTRY_NAME AS 국가명
        FROM HR.EMPLOYEES A, HR.DEPARTMENTS B,
             HR.LOCATIONS C, HR.COUNTRIES D
       WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID --조인조건,부서명 추출 
         AND B.LOCATION_ID=C.LOCATION_ID --조인조건,주소 추출
         AND C.COUNTRY_ID=D.COUNTRY_ID --조인조건,국가 추출
         AND D.COUNTRY_NAME != 'United States of America'
         ORDER BY 3;
         
    (ANSI JOIN)
         SELECT A.EMPLOYEE_ID AS 사원번호,
             A.EMP_NAME AS 사원명,
             B.DEPARTMENT_ID AS 부서코드,
             B.DEPARTMENT_NAME AS 부서명,
             C.STREET_ADDRESS||', '||C.CITY||' '||C.STATE_PROVINCE AS 주소,
             D.COUNTRY_NAME AS 국가명
        FROM HR.EMPLOYEES A
        INNER JOIN HR.DEPARTMENTS B ON (A.DEPARTMENT_ID=B.DEPARTMENT_ID)
        INNER JOIN HR.LOCATIONS C ON (B.LOCATION_ID=C.LOCATION_ID)
        INNER JOIN HR.COUNTRIES D ON (C.COUNTRY_ID=D.COUNTRY_ID
                   AND D.COUNTRY_NAME != 'United States of America')
         ORDER BY 3;
         