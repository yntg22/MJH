2021-1117-01)�����Լ�...cont
 2)AVG([DISTINC|ALL] expr) 
  .'expr'�� ����� ����,�Լ�,�÷� � ����� �������� �������� ��ȯ
  .'DISTINCT' : �ߺ��� �� ����
  .'ALL' : �ߺ��� �� ����, default��
  .'expr'�� �÷��� ���Ǹ� NULL ���� ���ܵǾ� ����
  
��뿹)������̺��� �� �μ��� ����ӱ��� ��ȸ�Ͻÿ�
    SELECT DEPARTMENT_ID AS �μ��ڵ�,
           ROUND(AVG(SALARY)) AS ����ӱ�
      FROM HR.EMPLOYEES
      GROUP BY DEPARTMENT_ID
      ORDER BY 1;
��뿹)������� ����ӱ��� ��ȸ�Ͻÿ�
    SELECT SUM(SALARY),
           ROUND(AVG(SALARY)) AS ����ӱ�
    FROM HR.EMPLOYEES;
��뿹)������̺��� �μ��� ����ӱ��� ��ü����� ����ӱݺ���
      ���� �μ��� ��ȸ�Ͻÿ�
      SELECT A.DEPARTMENT_ID AS �μ��ڵ�,
             B.DEPARTMENT_NAME AS �μ���,
             ROUND(AVG(SALARY)) AS ��ձ޿�
        FROM HR.EMPLOYEES A, HR.DEPARTMENTS B  --EMP DEP ����
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID  --�μ��ڵ尡 ����
         GROUP BY A.DEPARTMENT_ID,B.DEPARTMENT_NAME --�μ��ڵ�� �μ����� �׷�
         HAVING AVG(SALARY)>=(SELECT AVG(SALARY) --��ü��ձ޿����� 
                 FROM HR.EMPLOYEES)
         ORDER BY 1;
��뿹)��ǰ���̺��� �з��� ��ո��԰���,����ǸŰ����� ��ȸ�Ͻÿ�
        SELECT PROD_LGU AS �з���,
               B.LPROD_NM AS �з���,
               ROUND(AVG(PROD_COST)) AS ��ո��԰���,
               TRUNC(AVG(PROD_PRICE)) AS ����ǸŰ���
          FROM PROD A, LPROD B
          WHERE A.PROD_LGU=B.LPROD_GU
          GROUP BY A.PROD_LGU,B.LPROD_NM
          ORDER BY 1;
        
        
��뿹)��ٱ������̺��� ȸ������ ���� ��ձ��űݾ��� ��ȸ�Ͻÿ�
        SELECT SUBSTR(CART_NO,5,2)||'��' AS ��,
               ROUND(AVG(PROD_PRICE*CART_QTY)) AS ��ձ��űݾ�
          FROM CART A, PROD B
          WHERE A.CART_PROD = B.PROD_ID
          GROUP BY SUBSTR(CART_NO,5,2)
          ORDER BY 1;
          
    /*      SELECT SUBSTR(A.CART_NO,5,2)||'��' AS ��,
                 ROUND(AVG(A.CART_QTY*B.PROD_PRICE)) AS ��ձ��űݾ�
            FROM CART A, PROD B
            WHERE CART_NO LIKE '2005%' --�Ϲ�����
              AND A.CART_PROD=B.PROD_ID --��������(PROD_PRICE ����)
            GROUP BY SUBSTR(A.CART_NO,5,2)
            ORDER BY 1;
           */ 
           
    3)COUNT(*|expr)
    .�� �׷쳻�� �ڷ��� ��(���� ��)�� ��ȯ
    .�ܺ����ο� COUNT�Լ��� ���� ��� '*' ��� �ش� ���̺��� �⺻Ű �÷���
     ����ؾ� ��
    .NULL���� �����Ͽ� ����� ��ȯ��
    
��뿹)�� �μ��� ������� ����ӱ��� ��ȸ�Ͻÿ�
        SELECT  DEPARTMENT_ID AS �μ��ڵ�,
                COUNT(EMPLOYEE_ID) AS �����1,
                COUNT(*) AS �����2,
                ROUND(AVG(SALARY)) AS ����ӱ�
          FROM HR.EMPLOYEES
          GROUP BY DEPARTMENT_ID
          ORDER BY 1;
           
��뿹)��ٱ������̺��� 2005�� 5�� ���ں� �ǸŰǼ��� ��ȸ�Ͻÿ�.
      ��, �ǸŰǼ��� 10ȸ �̻�Ǵ� �ڷḸ ��ȸ�Ͻÿ�
      SELECT SUBSTR(CART_NO,7,2)||'��' AS ��,
             COUNT(*) AS �ǸŰǼ�
        FROM CART
        WHERE CART_NO LIKE '200505%' 
        GROUP BY SUBSTR(CART_NO,7,2)
        HAVING COUNT(*)>=5
          ORDER BY 2 DESC;
          
��뿹)2005�� 2�� ��� ��ǰ�� �������踦 ��ȸ�Ͻÿ�
      Alias�� ��ǰ�ڵ�,��ǰ��,���԰Ǽ�,���Լ����հ�,���Աݾ��հ��̸�
      ���Թ߻����� ���� ��ǰ�� ����� 0���� ǥ���Ͻÿ�
      
      (2005�� 2�� ���Ե� ��ǰ�� ������)
          SELECT COUNT(DISTINCT BUY_PROD)
          FROM BUYPROD
          WHERE BUY_DATE BETWEEN TO_DATE('20050201') AND LAST_DAY(TO_DATE('20050203'));
          
        (ANSI OUTER JOIN)
            SELECT B.PROD_ID AS ��ǰ�ڵ�,
                   B.PROD_NAME AS ��ǰ��,
                   COUNT(A.BUY_PROD) AS ���԰Ǽ�,
                   NVL(SUM(A.BUY_QTY),0) AS ���Լ����հ�,
                   NVL(SUM(A.BUY_QTY*B.PROD_COST),0) AS ���Աݾ��հ�
              FROM BUYPROD A
              RIGHT OUTER JOIN PROD B ON(A.BUY_PROD=B.PROD_ID AND
                    A.BUY_DATE BETWEEN TO_DATE('20050201') AND LAST_DAY(TO_DATE('20050201')))
                GROUP BY B.PROD_ID,B.PROD_NAME
                ORDER BY 1;
             
           
           
           
           
           
           
           
           