2021-1116-02) �����Լ�
 - Ư���÷��� �������� �ڷḦ �׷�ȭ�ϰ� �׷�ȭ�� �ڷḦ ������� ����ó����
   ���Ǵ� �Լ�
 - SUM,AVG,COUNT,MIN,MAX�� ������
 (ǥ������)
  SELECT �÷���1 [AS ��Ī][,]
         [�÷���2 [AS ��Ī]][,]
         �����Լ�(expr)[,]
         [�����Լ�(expr)[,]
                :
    FROM ���̺��
  [WHERE ����]
  [GROUP BY �÷���1[,�÷���2,...]
  [HAVING ����]
  [ORDER BY �÷���|�÷��ε���[ASC|DESC]
  
��뿹)ȸ�����̺��� ȸ����ü�� ���ϸ����հ踦 ��ȸ�Ͻÿ�

    SELECT SUM(MEM_MILEAGE),
           AVG(MEM_MILEAGE),
           COUNT(*)
    FROM MEMBER;
    
 1)SUM(expr)
  . 'expr'�� ǥ���� �÷��̳� ������ ������� �հ踦 ��ȯ

��뿹)ȸ�����̺��� �������� ����SELECT SUM(MEM_MILEAGE)
    FROM MEMBER
    GROUP BY SUBSTR(MEM_ADD1,1,2)
    ORDER BY 1;
���� �հ踦 ���Ͻÿ�
    SELECT  SUBSTR(MEM_ADD1,1,2) AS ������,
            SUM(MEM_MILEAGE) AS "���ϸ��� �հ�"
    FROM MEMBER
    GROUP BY SUBSTR(MEM_ADD1,1,2);
��뿹)�������̺��� 2005�� 1-3�� ���� �������踦 ���Ͻÿ�
    SELECT EXTRACT(MONTH FROM BUY_DATE) AS ����,
           SUM(BUY_QTY) AS ���Լ����հ�,
           SUM(BUY_COST) AS ���Աݾ��հ�
    FROM BUYPROD
    WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050331')
    GROUP BY EXTRACT(MONTH FROM BUY_DATE)
    ORDER BY 1;
    
��뿹)�������̺��� 2005�� 1-3�� ��ǰ�� �������踦 ���Ͻÿ�
    SELECT BUY_PROD AS ��ǰ�ڵ�,
           SUM(BUY_QTY) AS ���Լ����հ�,
           SUM(BUY_QTY*BUY_COST) AS ���Աݾ��հ�
    FROM BUYPROD
    WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050331')
    GROUP BY BUY_PROD
    ORDER BY 1;
��뿹)�������̺��� 2005�� 1-3�� ��ǰ�� �������踦 ���ϵ�
      ���Աݾ��հ谡 500���� �̻��� ��ǰ�� ��ȸ�Ͻÿ�
      SELECT BUY_PROD AS ��ǰ�ڵ�,
             SUM(BUY_QTY) AS ���Լ����հ�,
             SUM(BUY_QTY*BUY_COST) AS ���Աݾ��հ�
        FROM BUYPROD
        WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050331')
        GROUP BY BUY_PROD
        HAVING SUM(BUY_QTY*BUY_COST)>=5000000
        ORDER BY 1;
        
��뿹)ȸ�����̺��� ���� ���ϸ��� �հ踦 ���Ͻÿ�
        SELECT CASE WHEN SUBSTR(MEM_REGNO2,1,1)='1' OR
                         SUBSTR(MEM_REGNO2,1,1)='3' THEN
                         '����ȸ��'
                    ELSE 
                         '����ȸ��'
                    END AS ����,
                    SUM(MEM_MILEAGE) AS "���ϸ��� �հ�"
        FROM MEMBER
        GROUP BY CASE WHEN SUBSTR(MEM_REGNO2,1,1)='1' OR
                         SUBSTR(MEM_REGNO2,1,1)='3' THEN
                         '����ȸ��'
                    ELSE 
                         '����ȸ��'
                    END;

 ** CASE WHEN ǥ����
   - �б��ɰ� ������ ��Ȱ
   - SELECT �������� ��� ����
   (ǥ�����1)
   CASE ���� WHEN ��1 THEN
                 expr1
             WHEN ��2 THEN
                 expr2
                   :
    ELSE
        expr_n
    END [AS �÷���Ī]

    (ǥ�����2)
   CASE WHEN ���ǽ�1 THEN
             expr1
        WHEN ���ǽ�2 THEN
             expr2
               :
    ELSE
        expr_n
    END [AS �÷���Ī]

��뿹)ȸ�����̺��� ���ɴ뺰 ���ϸ��� �հ踦 ���Ͻÿ�
    SELECT TRUNC(EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR),-1)||'��' AS ���ɴ�,
           SUM(MEM_MILEAGE) AS "���ϸ��� �հ�"
        FROM MEMBER
        GROUP BY TRUNC(EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR),-1)
        ORDER BY 1;

��뿹)��ٱ������̺��� 2005�� 6�� ���ں�, ȸ���� �������踦 ��ȸ�Ͻÿ�.
        Alias�� ����,ȸ����ȣ,���ż����հ�
        SELECT TO_DATE(SUBSTR(CART_NO,1,8)) AS ����,
               CART_MEMBER AS ȸ����ȣ,
               SUM(CART_QTY) AS ���ż����հ�
          FROM CART
        WHERE SUBSTR(CART_NO,1,8) BETWEEN TO_DATE('20050601') AND LAST_DAY(TO_DATE('20050620'))
        GROUP BY CART_MEMBER, TO_DATE(SUBSTR(CART_NO,1,8))
        ORDER BY 1;
        
��뿹)��ٱ������̺��� 2005�� 6�� ���ں�,ȸ���� �������踦 ��ȸ�Ͻÿ�.��,
        ���ż����հ谡 10�̻�Ǵ� �ڷḸ ��ȸ�Ͻÿ�.
        Alias�� ����,ȸ����ȣ,���ż����հ�
         SELECT TO_DATE(SUBSTR(CART_NO,1,8)) AS ����,
               CART_MEMBER AS ȸ����ȣ,
               SUM(CART_QTY) AS ���ż����հ�
          FROM CART
        WHERE SUBSTR(CART_NO,1,8) LIKE '200506%'
        GROUP BY CART_MEMBER, TO_DATE(SUBSTR(CART_NO,1,8))
        HAVING SUM(CART_QTY)>=10
        ORDER BY 1;
        
    




