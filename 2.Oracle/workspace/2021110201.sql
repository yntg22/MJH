 2021-1102-01)����� ���
 1)���� ����(����� ����)
 - ����Ŭ ����ڰ��� ����
 - ����Ŭ ����ڴ� ��ü(object)�� ���
  (�������)
  CREATE USER ������ IDENTIFIED BY ��ȣ;
  
  CREATE USER MJH96 IDENTIFIED BY java;
  
  2)���Ѻο�
   - ������ ������� ���� ���� ����
   (�������)
   GRANT ���Ѹ�1,���Ѹ�2,... TO ������;
    ABC|DEF CONNECT RESOURCE DBA 
    
    GRANT CONNECT,RESOURCE,DBA TO MJH96;
    
  3)HR���� Ȱ��ȭ
   - HR������ ��� ���¸� Ȱ��ȭ ���·� ����
   ALTER USER ������ ACCOUNT UNLOCK;
    . ������ HR������ ���
   
    ALTER USER HR ACCOUNT UNLOCK;
   
        --NULL�� ��ȣ�� �����Ǿ��⶧���� �������־����
   - ALTER USER ������ IDENTIFIED BY ��ȣ;
   
   ALTER USER HR IDENTIFIED BY java;
  