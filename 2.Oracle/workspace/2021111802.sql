2021-1118-02)NULL처리함수
 - 오라클의 모든 자료타입은 자료가 입력되지 않은 경우 기본값이
   NULL로 설정(NOT NULL 제약조건이 부여된 경우 제외)
 - NULL값과 연산된 모든 결과는 NULL임
 - 이를 해결하기위한 함수로 NVL, NVL2, NULLIF 등이 제공됨
 1) NULL여부를 판단하는 연산자
  . IS NULL, IS NOT NULL을 사용해야 함.(=NULL, !=NULL은 오류는 아니지만 실행은 되지 않음)
사용예)사원테이블에서 영업실적코드(COMMISSION_PCT)가 NULL이 아닌 사원정보를
      조회하시오. Alias는 사원번호,사원명,부서코드,영업실적코드
      SELECT EMPLOYEE_ID,EMP_NAME,DEPARTMENT_ID,COMMISSION_PCT
        FROM HR.EMPLOYEES
       -- WHERE COMMISSION_PCT != NULL;
       WHERE COMMISSION_PCT IS NOT NULL;
       
 2)NVL(col,val)
   .'col' 값을 판단하여 그 값이 NULL이면 'VAL'값을 반환하고, NULL이 아니면 'col'
    값을 반환
   .'col'과 'val'은 반드시 같은 데이터 타입이어야 함
   .외부조인에 많이 사용됨

사용예)사원테이블에서 영업실적에 따른 보너스를 계산하고
      급여의 지급액을 계산하여 지급하려한다 지급명세서를 출력하시오
      보너스=급여*영업실적코드
      지급액=급여+보너스이며
      출력은 사원번호,사원명,부서코드,영업실적코드,급여,보너스,지급액이다
      
      SELECT EMPLOYEE_ID AS 사원번호,
             EMP_NAME AS 사원명,
             DEPARTMENT_ID AS 부서코드,
             NVL(COMMISSION_PCT,0) AS 영업실적코드,
             SALARY AS 급여,
             NVL(SALARY*COMMISSION_PCT,0) AS 보너스,
             SALARY+NVL(SALARY*COMMISSION_PCT,0)지급액
        FROM HR.EMPLOYEES
        ORDER BY 3;
**상품테이블의 분류코드가 'P101'~'P202'에 속하는 
  상품의 마일리지(PROD_MILEAGE)컬럼 값을 판매가격의 0.05%로 설정하시오
  
  UPDATE PROD 
     SET PROD_MILEAGE=ROUND(PROD_PRICE*0.0005)
   WHERE PROD_LGU>='P101' AND PROD_LGU<='P202';
      
    COMMIT;
    
사용예)상품테이블에서 상품에대한 마일리지를 조회하되, 그 값이 NULL이면
      '마일리지가 부여되지않은 상품'이라는 메시지를 마일리지 대신
      출력하시오. Alias는 상품코드,상품명,판매가격,마일리지이다
      
      SELECT PROD_ID AS 상품코드,
             PROD_NAME AS 상품명,
             PROD_PRICE AS 판매가격,
             PROD_MILEAGE AS 마일리지
      
      