2021-1124-03)���� cont...

 2. �ܺ�����
   - �ڷᰡ ���� ���̺��� �������� ������ ���̺� NULL���� ���� ä��� ���� ����
   - �������� ����� ������ �����͸� ������ ���̺��� �÷��� �ڿ�
     �ܺ����� ������ '(+)'�� �߰���
   - (������ ��)
      . �ܺ������� �ʿ��� ��� ���ǽĿ� �ܺ����� ������'(+)' ����ؾ� ��.
      . �ѹ��� �ϳ��� ���̺� �ܺ����ε� �� ����. ������� A,B,C ���̺���
        �ܺ����� �ɶ� A�� �������� B�� Ȯ��Ǿ� ���εǰ�, ���ÿ� C�� ��������
        B�� Ȯ��Ǿ� �ܺ����� �� �� ����. ��, WHERE A=B(+)
                                            AND C=B(+) �� ������ ����
      . �Ϲ� �ܺ��������ǰ� �Ϲ������� ���ÿ� ����Ǹ� �������� ����� ��ȯ�Ǹ�
        �̴� ���������� ANSI �ܺ��������� �ذ��ؾ� ��.
    (ANSI OUTER JOIN)
      SELECT �÷�list
        FROM ���̺��1 [��Ī1]
        LEFT|RIGTH|FULL OUTER JOIN ���̺��2 [��Ī2]ON(��������1 [AND �Ϲ�����1])
                                    :
        LEFT|RIGTH|FULL OUTER JOIN ���̺��n [��Īn]ON(��������n [AND �Ϲ�����n])
       [WHERE ����]
            :
        - 'LEFT' : FROM ������ ����� '���̺��1'�� �ڷᰡ '���̺��2'�� �ڷẸ�� ��
                   ���� ���
        - 'RIGHT' : FROM ������ ����� '���̺��1'�� �ڷᰡ '���̺��2'�� �ڷẸ�� ��
                   ���� ���
        - 'FULL' : '���̺��1','���̺��2'�� �ڷᰡ ���� ������ ���           
        - 'WHERE ����' : ���� ���� �� �ݿ��� ����
        
��뿹) ��� �з��� ��ǰ�� ���� ��ȸ�Ͻÿ�
       Alias�� �з��ڵ�,�з���,��ǰ�� ��
       --(�Ϲ� OUTER JOIN)
       SELECT A.LPROD_GU AS �з��ڵ�,
              A.LPROD_NM AS �з���,
              COUNT(B.PROD_ID) AS "��ǰ�� ��"
         FROM LPROD A,PROD B
        WHERE A.LPROD_GU=B.PROD_LGU(+)
         GROUP BY A.LPROD_GU, A.LPROD_NM
         ORDER BY 1;
         
       --(ANSI OUTER JOIN)
       SELECT A.LPROD_GU AS �з��ڵ�,
              A.LPROD_NM AS �з���,
              COUNT(B.PROD_ID) AS "��ǰ�� ��"
         FROM LPROD A
        LEFT OUTER JOIN PROD B ON (A.LPROD_GU=B.PROD_LGU)
        GROUP BY A.LPROD_GU, A.LPROD_NM
        ORDER BY 1;
         
        SELECT DISTINCT PROD_LGU FROM PROD;
        
��뿹)��� �μ��� ������� ��ȸ�Ͻÿ�.
--�Ϲ� OUTER JOIN�� FULL ������ �������� �ʴ´�.
    SELECT A.DEPARTMENT_ID AS �μ��ڵ�,
           A.DEPARTMENT_NAME AS �μ���,
           COUNT(B.EMP_NAME) AS �����
      FROM HR.DEPARTMENTS A, HR.EMPLOYEES B
      WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID(+)
    GROUP BY A.DEPARTMENT_ID, A.DEPARTMENT_NAME
    ORDER BY 1;
------------------------------------------------
    
   --(ANSI OUTER JOIN) 
    SELECT A.DEPARTMENT_ID AS �μ��ڵ�,
           A.DEPARTMENT_NAME AS �μ���,
           COUNT(B.EMP_NAME) AS �����
      FROM HR.DEPARTMENTS A
      FULL OUTER JOIN HR.EMPLOYEES B ON (A.DEPARTMENT_ID=B.DEPARTMENT_ID)
      GROUP BY A.DEPARTMENT_ID, A.DEPARTMENT_NAME
      ORDER BY 1;
      
��뿹)2005�� 6�� ��� ��ǰ�� �������踦 ��ȸ�Ͻÿ�
   --(�Ϲ�)�Ϲ� �ܺ��������ǰ� �Ϲ������� ���ÿ� ����Ǹ� �������� ����� ��ȯ�Ǹ�
   --      �̴� ���������� ANSI �ܺ��������� �ذ��ؾ� ���� ����
      SELECT A.CART_PROD AS ��ǰ�ڵ�,
             B.PROD_NAME AS ��ǰ��,
             SUM(A.CART_QTY*B.PROD_PRICE) AS ����ݾ��հ�
        FROM CART A,PROD B
        WHERE A.CART_PROD(+)=B.PROD_ID
          AND A.CART_NO LIKE '200506%'
          GROUP BY A.CART_PROD, B.PROD_NAME
          ORDER BY 1;
          
  -- (ANSI)
        SELECT B.PROD_ID AS ��ǰ�ڵ�,
             B.PROD_NAME AS ��ǰ��,
             NVL(SUM(A.CART_QTY*B.PROD_PRICE),0) AS ����ݾ��հ�
        FROM CART A
        RIGHT OUTER JOIN PROD B ON (A.CART_PROD=B.PROD_ID AND
                A.CART_NO LIKE '200506%')
          GROUP BY B.PROD_ID, B.PROD_NAME
          ORDER BY 1;
          
  --(���������� �̿��� �Ϲ� OUTER JOIN)
        SELECT B.PROD_ID AS ��ǰ�ڵ�,
               B.PROD_NAME AS ��ǰ��,
               NVL(A.ASUM,0) AS ����ݾ��հ�
          FROM PROD B, (SELECT CART_PROD AS CID,
                               SUM(CART_QTY*PROD_PRICE) AS ASUM
                          FROM CART,PROD
                          WHERE CART_PROD=PROD_ID
                            AND CART_NO LIKE '200506%'
                            GROUP BY CART_PROD)A
        WHERE A.CID(+)=B.PROD_ID
          ORDER BY 1;    
          
��뿹)2005�� 4�� ��� ��ǰ�� �������踦 ��ȸ�Ͻÿ�
      Alias�� ��ǰ�ڵ�,��ǰ��,���Աݾ��հ�
      (ANSI �ܺ�����)
      SELECT A.PROD_ID AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             NVL(SUM(B.BUY_QTY*B.BUY_COST),0) AS ���Աݾ��հ�
        FROM PROD A
        LEFT OUTER JOIN BUYPROD B ON(B.BUY_PROD=A.PROD_ID AND
                                    B.BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050430'))
        GROUP BY A.PROD_ID,A.PROD_NAME
        ORDER BY 1;
        
        (�Ϲ� �ܺ�����)
      SELECT A.PROD_ID AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             NVL(B.ASUM,0) AS ���Աݾ��հ�
        FROM PROD A, (SELECT BUY_PROD AS CID,
                             SUM(BUY_QTY*BUY_COST) AS ASUM
                        FROM BUYPROD,PROD
                        WHERE BUY_PROD=PROD_ID
                          AND BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050430')
                        GROUP BY BUY_PROD) B
        WHERE A.PROD_ID=B.CID(+)
        ORDER BY 1;
        
��뿹)2005�� ��� ��ǰ�� ����/���� ��Ȳ�� ��ȸ�Ͻÿ�
      Alias�� ��ǰ�ڵ�,��ǰ��,���Աݾ��հ�,����ݾ��հ�
     (ANSI)
      SELECT A.PROD_ID AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             SUM(B.BUY_QTY*B.BUY_COST) AS ���Աݾ��հ�,
             SUM(C.CART_QTY*A.PROD_PRICE) AS ����ݾ��հ�
        FROM PROD A
        LEFT OUTER JOIN BUYPROD B ON(A.PROD_ID=B.BUY_PROD AND
                                    B.BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20051231'))
        LEFT OUTER JOIN CART C ON(A.PROD_ID=C.CART_PROD AND
                                C.CART_NO LIKE '2005%')
        GROUP BY A.PROD_ID,A.PROD_NAME
        ORDER BY 1;
        
        
        
        (�Ϲ�)
        SELECT A.PROD_ID AS ��ǰ�ڵ�,
               A.PROD_NAME AS ��ǰ��,
               B.BSUM AS ���Աݾ��հ�,
               C.CSUM AS ����ݾ��հ�
        FROM PROD A, (SELECT BUY_PROD AS BID,
                             SUM(BUY_QTY*BUY_COST) AS BSUM
                        FROM BUYPROD,PROD
                        WHERE PROD_ID=BUY_PROD
                          AND BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20051231')
                          GROUP BY BUY_PROD) B,
                          (SELECT CART_PROD AS CID,
                                  SUM(CART_QTY*PROD_PRICE) AS CSUM
                             FROM CART,PROD
                             WHERE CART_PROD=PROD_ID
                               AND CART_NO LIKE '2005%'
                               GROUP BY CART_PROD) C
        WHERE A.PROD_ID=B.BID(+)
          AND A.PROD_ID=C.CID(+)
          ORDER BY 1;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

