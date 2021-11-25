2021-1124-03)조인 cont...

 2. 외부조인
   - 자료가 많은 테이블을 기준으로 부족한 테이블에 NULL값의 행을 채우고 조인 수행
   - 조인조건 기술시 부족한 데이터를 보유한 테이블의 컬럼명 뒤에
     외부조인 연산자 '(+)'를 추가함
   - (주의할 점)
      . 외부조인이 필요한 모든 조건식에 외부조인 연산자'(+)' 기술해야 함.
      . 한번에 하나의 테이블만 외부조인될 수 있음. 예를들어 A,B,C 테이블이
        외부조인 될때 A를 기준으로 B가 확장되어 조인되고, 동시에 C를 기준으로
        B가 확장되어 외부조인 될 수 없다. 즉, WHERE A=B(+)
                                            AND C=B(+) 는 허용되지 않음
      . 일반 외부조인조건과 일반조건이 동시에 적용되면 내부조인 결과로 변환되며
        이는 서브쿼리나 ANSI 외부조인으로 해결해야 함.
    (ANSI OUTER JOIN)
      SELECT 컬럼list
        FROM 테이블명1 [별칭1]
        LEFT|RIGTH|FULL OUTER JOIN 테이블명2 [별칭2]ON(조인조건1 [AND 일반조건1])
                                    :
        LEFT|RIGTH|FULL OUTER JOIN 테이블명n [별칭n]ON(조인조건n [AND 일반조건n])
       [WHERE 조건]
            :
        - 'LEFT' : FROM 다음에 기술된 '테이블명1'의 자료가 '테이블명2'의 자료보다 더
                   많은 경우
        - 'RIGHT' : FROM 다음에 기술된 '테이블명1'의 자료가 '테이블명2'의 자료보다 더
                   적은 경우
        - 'FULL' : '테이블명1','테이블명2'의 자료가 서로 부족한 경우           
        - 'WHERE 조건' : 조인 연산 후 반영될 조건
        

        