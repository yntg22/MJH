2021-1126-01)

��뿹)2005�� 1�� ��ǰ�� �԰������ ��ȸ�Ͽ� ���������̺��� �����Ͻÿ�
      ��¥�� 2005�� 1�� 31���̴�
      
      (��������:2005�� 1�� ��ǰ�� �԰��������)
        SELECT BUY_PROD,
               SUM(BUY_QTY)
          FROM BUYPROD
          WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
          GROUP BY BUY_PROD
      
      (�������� : ���������̺� ����)
        UPDATE REMAIN A   --REMAIN�� ������Ʈ �ϰڴ�.
           SET (A.REMAIN_I,A.REMAIN_J_99,A.REMAIN_DATE)= --�԰�,�⸻���,��¥�� �ְڴ�.
               (SELECT A.REMAIN_I+B.BSUM,A.REMAIN_J_99+B.BSUM, --BSUM���� �԰�,�⸻��� �ְڴ�.
                       TO_DATE('20050131') --��¥�� 20050131�� �ϰڴ�
          FROM (SELECT BUY_PROD, --REMAIN������Ʈ�� �� �ڷῡ�� ���ڴ�.
                       SUM(BUY_QTY) AS BSUM --BUY_PROD�� BSUM�� ���Ѵ�.
                  FROM BUYPROD --BUYPROD����
                 WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131') --��¥�� 2005 01�� %�� �ڷ�
                 GROUP BY BUY_PROD)B --BUY_PROD �׷�
            WHERE B.BUY_PROD=A.PROD_ID) 
        WHERE A.REMAIN_YEAR='2005'
          AND A.PROD_ID IN (SELECT DISTINCT BUY_PROD
                              FROM BUYPROD
                             WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131'));
      
��뿹)2005�� 4�� �������踦 ��ȸ�Ͽ� ���������̺��� �����Ͻÿ�.
    (2005�� 4�� ��ǰ�� ������� ����)
    SELECT CART_PROD AS CID,
           SUM(CART_QTY) AS CSUM
      FROM CART
      WHERE CART_NO LIKE '200504%' /*SUBSTR(CART_NO,1,6)='200504'*/
      GROUP BY CART_PROD;
      
      UPDATE REMAIN A
         SET (A.REMAIN_O,A.REMAIN_J_99,A.REMAIN_DATE)=  --�ѹ��� ������ �ٲܶ� ��ȣ ������
             (SELECT A.REMAIN_O+B.CSUM,A.REMAIN_J_99-B.CSUM,TO_DATE('20050430')
                FROM (SELECT CART_PROD AS CID,
                        SUM(CART_QTY) AS CSUM
                       FROM CART
                      WHERE CART_NO LIKE '200504%' /*SUBSTR(CART_NO,1,6)='200504'*/
                      GROUP BY CART_PROD)B
                WHERE A.PROD_ID=B.CID)
      WHERE A.REMAIN_YEAR='2005' --������ �߻��Ѱ͸� �ٲ۴ٴ� ����
        AND A.PROD_ID IN (SELECT CART_PROD 
                            FROM CART
                            WHERE CART_NO LIKE '200504%')
      
      
      
      
      
            