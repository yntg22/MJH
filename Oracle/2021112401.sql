2021-124-01)���� cont...

��뿹)��ٱ������̺��� �̿��Ͽ� 2005�� 4-6�� ����,ȸ���� �������踦
      ��ȸ�Ͻÿ�
      Alias�� ��,ȸ����ȣ,ȸ����,���ż����հ�,���űݾ��հ�
      SELECT SUBSTR(A.CART_NO,5,2) AS ��,
             A.CART_MEMBER AS ȸ����ȣ,
             C.MEM_NAME AS ȸ����,
             SUM(A.CART_QTY) AS ���ż����հ�,
             SUM(A.CART_QTY*B.PROD_PRICE) AS ���űݾ��հ�
      FROM CART A,PROD B, MEMBER C
      WHERE A.CART_PROD=B.PROD_ID
        AND A.CART_MEMBER=C.MEM_ID
        AND SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506'
        GROUP BY C.MEM_NAME,A.CART_MEMBER,SUBSTR(A.CART_NO,5,2)
        ORDER BY 1;
        
        
     /*ANSI JOIN*/
        SELECT SUBSTR(A.CART_NO,5,2) AS ��,
             A.CART_MEMBER AS ȸ����ȣ,
             C.MEM_NAME AS ȸ����,
             SUM(A.CART_QTY) AS ���ż����հ�,
             SUM(A.CART_QTY*B.PROD_PRICE) AS ���űݾ��հ�
         FROM CART A
         INNER JOIN PROD B ON (A.CART_PROD=B.PROD_ID)
         INNER JOIN MEMBER C ON (A.CART_MEMBER=C.MEM_ID
                                AND SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506')
        GROUP BY C.MEM_NAME,A.CART_MEMBER,SUBSTR(A.CART_NO,5,2)
        ORDER BY 1;
       
        
��뿹)��ٱ������̺��� �̿��Ͽ� 2005�� 4-6�� �з��� �Ǹ����踦 ��ȸ�Ͻÿ�
      Alias�� �з��ڵ�,�з���,�Ǹż����հ�,�Ǹűݾ��հ�
      SELECT B.PROD_LGU AS �з��ڵ�,
             C.LPROD_NM AS �з���,
             SUM(A.CART_QTY) AS �Ǹż����հ�,
             SUM(A.CART_QTY*B.PROD_PRICE) AS �Ǹűݾ��հ�
        FROM CART A, PROD B, LPROD C
        WHERE A.CART_PROD=B.PROD_ID
          AND B.PROD_LGU=C.LPROD_GU
          AND SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506'
        GROUP BY C.LPROD_NM, B.PROD_LGU
        ORDER BY 1;
        
      (ANSI JOIN)  
        SELECT B.PROD_LGU AS �з��ڵ�,
             C.LPROD_NM AS �з���,
             SUM(A.CART_QTY) AS �Ǹż����հ�,
             SUM(A.CART_QTY*B.PROD_PRICE) AS �Ǹűݾ��հ�
        FROM CART A
        INNER JOIN PROD B ON (A.CART_PROD=B.PROD_ID)
        INNER JOIN LPROD C ON (B.PROD_LGU=C.LPROD_GU AND 
                               SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506') 
        GROUP BY C.LPROD_NM, B.PROD_LGU
        ORDER BY 1;
      
��뿹)������̺��� �̱� �̿��� �������� �ٹ��ϴ� ��������� ��ȸ�Ͻÿ�
      Alias�� �����ȣ,�����,�μ��ڵ�,�μ���,�����ڵ�
      SELECT A.EMPLOYEE_ID AS �����ȣ,
             A.EMP_NAME AS �����,
             B.DEPARTMENT_ID AS �μ��ڵ�,
             B.DEPARTMENT_NAME AS �μ���,
             C.STREET_ADDRESS||', '||C.CITY||' '||C.STATE_PROVINCE AS �ּ�,
             D.COUNTRY_NAME AS ������
        FROM HR.EMPLOYEES A, HR.DEPARTMENTS B,
             HR.LOCATIONS C, HR.COUNTRIES D
       WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID --��������,�μ��� ���� 
         AND B.LOCATION_ID=C.LOCATION_ID --��������,�ּ� ����
         AND C.COUNTRY_ID=D.COUNTRY_ID --��������,���� ����
         AND D.COUNTRY_NAME != 'United States of America'
         ORDER BY 3;
         
    (ANSI JOIN)
         SELECT A.EMPLOYEE_ID AS �����ȣ,
             A.EMP_NAME AS �����,
             B.DEPARTMENT_ID AS �μ��ڵ�,
             B.DEPARTMENT_NAME AS �μ���,
             C.STREET_ADDRESS||', '||C.CITY||' '||C.STATE_PROVINCE AS �ּ�,
             D.COUNTRY_NAME AS ������
        FROM HR.EMPLOYEES A
        INNER JOIN HR.DEPARTMENTS B ON (A.DEPARTMENT_ID=B.DEPARTMENT_ID)
        INNER JOIN HR.LOCATIONS C ON (B.LOCATION_ID=C.LOCATION_ID)
        INNER JOIN HR.COUNTRIES D ON (C.COUNTRY_ID=D.COUNTRY_ID
                   AND D.COUNTRY_NAME != 'United States of America')
         ORDER BY 3;
         