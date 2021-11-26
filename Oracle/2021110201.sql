 2021-1102-01)사용자 등록
 1)계정 생성(사용자 생성)
 - 오라클 사용자계정 생성
 - 오라클 사용자는 객체(object)로 취급
  (사용형식)
  CREATE USER 유저명 IDENTIFIED BY 암호;
  
  CREATE USER MJH96 IDENTIFIED BY java;
  
  2)권한부여
   - 생성된 사용자의 수행 범위 지정
   (사용형식)
   GRANT 권한명1,권한명2,... TO 계정명;
    ABC|DEF CONNECT RESOURCE DBA 
    
    GRANT CONNECT,RESOURCE,DBA TO MJH96;
    
  3)HR계정 활성화
   - HR계정의 잠금 상태를 활성화 상태로 변경
   ALTER USER 계정명 ACCOUNT UNLOCK;
    . 계정명에 HR계정명 기술
   
    ALTER USER HR ACCOUNT UNLOCK;
   
        --NULL로 암호가 설정되었기때문에 변경해주어야함
   - ALTER USER 유저명 IDENTIFIED BY 암호;
   
   ALTER USER HR IDENTIFIED BY java;
  