2021-1129-01)���տ�����     --NVL(�����Ͱ�NULL���̸�,0����)
  - ���շп��� �����ϴ� ������ db���� �����ϱ� ���� ������
  - UNION, UNION ALL, INTERSECT, MINUS ����
  - �� SELECT����SELECT ���� ���� �÷��� ���� �÷��� ������Ÿ���� ��ġ�ؾ���
  - ù ��° SELECT���� SELECT���� ����� �����̵�
  - CLOB,BLOB,BFILEŸ���� ��� �Ұ�
  - ORDER BY ���� �� ������ SELECT������ ��� ����
  
  1)UNION, UNION ALL
   - �������� ����� ��ȯ
   - UNION : �ߺ��� ������ �������� ��ȯ
   - UNION ALL : �ߺ��� ����� �������� ��ȯ

��뿹)ȸ������ ������ '�л�'�� ȸ�� ���� �Ǵ� �븶�� '���'�� ȸ������
      ȸ����ȣ,ȸ����,�ּ�,���,������ ��ȸ�Ͻÿ�.
      
      SELECT MEM_ID AS ȸ����ȣ,
             MEM_NAME AS ȸ����,
             MEM_ADD1||' '||MEM_ADD2 AS �ּ�,
             MEM_LIKE AS ���,
             MEM_JOB AS ����
        FROM MEMBER
       WHERE MEM_JOB='�л�'
       UNION ALL
        SELECT MEM_ID AS ȸ����ȣ,
             MEM_NAME AS ȸ����,
             MEM_ADD1||' '||MEM_ADD2 AS �ּ�,
             MEM_LIKE AS ���,
             MEM_JOB AS ����
        FROM MEMBER
        WHERE MEM_LIKE='���';
        
��뿹)2005�� 4����6���� �Ǹŵ� ��� ��ǰ���� ��ȸ�Ͻÿ�
      Alias�� ��ǰ�ڵ�,��ǰ��,���Դܰ�,����ܰ�
      ��, �ߺ�����
      
      SELECT DISTINCT A.CART_PROD AS ��ǰ�ڵ�,
             B.PROD_NAME AS ��ǰ��,
             B.PROD_COST AS ���Դܰ�,
             B.PROD_PRICE AS ����ܰ�
        FROM CART A, PROD B
        WHERE A.CART_NO LIKE '200504%'
        AND A.CART_PROD=B.PROD_ID
        UNION ALL
         SELECT DISTINCT A.CART_PROD AS ��ǰ�ڵ�,
             B.PROD_NAME AS ��ǰ��,
             B.PROD_COST AS ���Դܰ�,
             B.PROD_PRICE AS ����ܰ�
        FROM CART A, PROD B
        WHERE A.CART_NO LIKE '200506%'
        AND A.CART_PROD=B.PROD_ID
        
��뿹)2005�� 6���� ���Ե� ��ǰ��� 2005�� 6�� ����� ��ǰ���� ��ȸ�Ͻÿ�
      Alias�� ��ǰ�ڵ�,��ǰ��
      SELECT DISTINCT BUY_PROD AS ��ǰ�ڵ�,
             PROD_NAME AS ��ǰ��
        FROM BUYPROD, PROD
        WHERE BUY_PROD=PROD_ID
          AND BUY_DATE BETWEEN TO_DATE('20050601') AND TO_DATE('20050630')
        UNION
      SELECT DISTINCT CART_PROD AS ��ǰ�ڵ�,
             PROD_NAME AS ��ǰ��
             FROM CART, PROD
             WHERE CART_PROD=PROD_ID
              AND CART_NO LIKE'200506%'
            ORDER BY 1; --ORDER BY���� ������ SELECT������ ����Ѵ�
            --���� ������ ���� �ߺ��� ���� ���� = �ΰ��� ������ ���?
            
  2)INTERSECT
   - �������� ����� ��ȯ
   
��뿹)2005�� 1���� 4���� ��� ������ �߻��� ��ǰ�� ��ȸ�Ͻÿ�.
      Alias�� ��ǰ�ڵ�,��ǰ��,�ŷ�ó�ڵ�
      
      SELECT A.PROD_ID AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             A.PROD_BUYER AS �ŷ�ó�ڵ�
        FROM BUYPROD B, PROD A
        WHERE A.PROD_ID=B.BUY_PROD
          AND B.BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
        INTERSECT
        SELECT A.PROD_ID AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             A.PROD_BUYER AS �ŷ�ó�ڵ�
        FROM BUYPROD B, PROD A
        WHERE A.PROD_ID=B.BUY_PROD
          AND B.BUY_DATE BETWEEN TO_DATE('20050401') AND LAST_DAY(TO_DATE('20050401'))
          
��뿹)2005�� 1���� 4���� ��� ������ �߻��� ��ǰ �� 5���� �Ǹŵ� ��ǰ�� ��ȸ�Ͻÿ�------
      Alias�� ��ǰ�ڵ�,��ǰ��,�ŷ�ó�ڵ�
      
      SELECT DISTINCT B.BUY_PROD AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             A.PROD_BUYER AS �ŷ�ó�ڵ�
      FROM PROD A, BUYPROD B
      WHERE A.PROD_ID=B.BUY_PROD
      AND B.BUY_DATE BETWEEN TO_DATE('20050101') AND LAST_DAY(TO_DATE('20050101'))
      
      INTERSECT 
      
      SELECT DISTINCT B.BUY_PROD AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             A.PROD_BUYER AS �ŷ�ó�ڵ�
      FROM PROD A, BUYPROD B
      WHERE A.PROD_ID=B.BUY_PROD
      AND B.BUY_DATE BETWEEN TO_DATE('20050401') AND LAST_DAY(TO_DATE('20050401'))
      
      INTERSECT 
      
      SELECT DISTINCT A.CART_PROD AS ��ǰ�ڵ�,
             B.PROD_NAME AS ��ǰ��,
             B.PROD_BUYER AS �ŷ�ó�ڵ�
        FROM CART A, PROD B
          WHERE A.CART_PROD=B.PROD_ID
      AND A.CART_NO LIKE '200505%';
        
 3)MINUS ������
    
��뿹)2005�� 1���� 4�� �� 1������ ���Ե� ��ǰ������ ��ȸ�Ͻÿ�
      Alias�� ��ǰ�ڵ�,��ǰ��,�з��ڵ�
      
      SELECT DISTINCT B.BUY_PROD AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             A.PROD_LGU AS �з��ڵ�
        FROM PROD A, BUYPROD B
        WHERE A.PROD_ID=B.BUY_PROD
        AND B.BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
        MINUS
        SELECT DISTINCT B.BUY_PROD AS ��ǰ�ڵ�,
             A.PROD_NAME AS ��ǰ��,
             A.PROD_LGU AS �з��ڵ�
        FROM PROD A, BUYPROD B
        WHERE A.PROD_ID=B.BUY_PROD
        AND B.BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050430');
        
        (���տ����ڸ� ������� ���� ���)
        SELECT A.PROD_ID,
               A.PROD_NAME,
               A.PROD_LGU
        FROM (SELECT DISTINCT BUY_PROD AS APID
                FROM BUYPROD
               WHERE BUY_DATE BETWEEN TO_DATE('20050101')
                 AND TO_DATE('20050131'))TBLA,
               PROD A
        WHERE TBLA.APID NOT IN (SELECT DISTINCT BUY_PROD AS BPID
                                  FROM BUYPROD
                                 WHERE BUY_DATE BETWEEN TO_DATE('20050401')
                                 AND TO_DATE('20050430'))
        AND A.PROD_ID=TBLA.APID;
        
        SELECT BUY_PROD,
               PROD_NAME,
               PROD_LGU
        FROM BUYPROD,PROD
        WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
                                AND BUY_PROD NOT IN (SELECT DISTINCT BUY_PROD AS BPID
                                                       FROM BUYPROD
                                                      WHERE BUY_DATE BETWEEN TO_DATE('20050401')
                                                        AND TO_DATE('20050430'))
                                                        AND PROD_ID=BUY_PROD
        