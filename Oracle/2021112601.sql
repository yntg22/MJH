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
        UPDATE REMAIN A
           SET (A.REMAIN_I,A.REMAIN_J_99,A.REMAIN_DATE)=
               (SELECT A.REMAIN_I+B.BSUM,A.REMAIN_J_99+B.BSUM,
                       TO_DATE('20050131')
          FROM (SELECT BUY_PROD,
                       SUM(BUY_QTY) AS BSUM
                  FROM BUYPROD
                 WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
                 GROUP BY BUY_PROD)B
            WHERE B.BUY_PROD=A.PROD_ID)
        WHERE A.REMAIN_YEAR='2005'
          AND A.PROD_ID IN (SELECT DISTINCT BUY_PROD
                              FROM BUYPROD
                             WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131'));
      
      
      ROLLBACK;
            