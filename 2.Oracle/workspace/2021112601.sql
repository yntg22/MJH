2021-1126-01)

사용예)2005년 1월 상품별 입고수량을 조회하여 재고수불테이블을 갱신하시오
      날짜는 2005년 1월 31일이다
      
      (서브쿼리:2005년 1월 상품별 입고수량집계)
        SELECT BUY_PROD,
               SUM(BUY_QTY)
          FROM BUYPROD
          WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
          GROUP BY BUY_PROD
      
      (메인쿼리 : 재고수불테이블 갱신)
        UPDATE REMAIN A   --REMAIN을 업데이트 하겠다.
           SET (A.REMAIN_I,A.REMAIN_J_99,A.REMAIN_DATE)= --입고,기말재고,날짜에 넣겠다.
               (SELECT A.REMAIN_I+B.BSUM,A.REMAIN_J_99+B.BSUM, --BSUM값을 입고,기말재고에 넣겠다.
                       TO_DATE('20050131') --날짜는 20050131로 하겠다
          FROM (SELECT BUY_PROD, --REMAIN업데이트를 이 자료에서 쓰겠다.
                       SUM(BUY_QTY) AS BSUM --BUY_PROD와 BSUM을 구한다.
                  FROM BUYPROD --BUYPROD에서
                 WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131') --날짜가 2005 01월 %인 자료
                 GROUP BY BUY_PROD)B --BUY_PROD 그룹
            WHERE B.BUY_PROD=A.PROD_ID) 
        WHERE A.REMAIN_YEAR='2005'
          AND A.PROD_ID IN (SELECT DISTINCT BUY_PROD
                              FROM BUYPROD
                             WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131'));
      
사용예)2005년 4월 매출집계를 조회하여 재고수불테이블을 갱신하시오.
    (2005년 4월 제품별 매출수량 집계)
    SELECT CART_PROD AS CID,
           SUM(CART_QTY) AS CSUM
      FROM CART
      WHERE CART_NO LIKE '200504%' /*SUBSTR(CART_NO,1,6)='200504'*/
      GROUP BY CART_PROD;
      
      UPDATE REMAIN A
         SET (A.REMAIN_O,A.REMAIN_J_99,A.REMAIN_DATE)=  --한번에 여러개 바꿀때 괄호 묶어줌
             (SELECT A.REMAIN_O+B.CSUM,A.REMAIN_J_99-B.CSUM,TO_DATE('20050430')
                FROM (SELECT CART_PROD AS CID,
                        SUM(CART_QTY) AS CSUM
                       FROM CART
                      WHERE CART_NO LIKE '200504%' /*SUBSTR(CART_NO,1,6)='200504'*/
                      GROUP BY CART_PROD)B
                WHERE A.PROD_ID=B.CID)
      WHERE A.REMAIN_YEAR='2005' --매출이 발생한것만 바꾼다는 내용
        AND A.PROD_ID IN (SELECT CART_PROD 
                            FROM CART
                            WHERE CART_NO LIKE '200504%')
      
      
      
      
      
            