2021-1110-02)�Լ�
 - ����Ŭ�翡�� �����ϴ� �̸� �����ϵǾ� ���డ���� ���
 - ���ڿ�,����,��¥,����ȯ,NULLó��,�����Լ� ���� ������
 1.���ڿ� �Լ�
  1)CONCAT(c1,c2)
   - �־��� ���ڿ� �ڷ� 'c1'�� 'c2'�� �����Ͽ� ���ο� ���ڿ��� ��ȯ
   - ���ڿ� ���տ����ڿ� ('||')�� ���ϱ�� ����
   
��뿹)ȸ�����̺��� ������ �ڿ����� ȸ���� ȸ����ȣ,ȸ����,�ֹι�ȣ,�ּҸ�
      ��ȸ�ϵ� �ֹι�ȣ�� 'XXXXXX-XXXXXXX'��������, �ּҴ� �⺻�ּҿ�
      ���ּҸ� ' '�� �����Ͽ� ����Ͻÿ�>CONCAT�Լ� ���
      c ���ڿ� n����
      SELECT MEM_ID AS ȸ����ȣ,
             MEM_NAME AS ȸ����,
             CONCAT(CONCAT(MEM_REGNO1,'-'),MEM_REGNO2) AS �ֹι�ȣ,
            -- MEM_REGNO1||'-'||MEM_REGNO2 AS �ֹι�ȣ2, 
             CONCAT(CONCAT(MEM_ADD1,' '),MEM_ADD2) AS �ּ�
      FROM MEMBER
      WHERE MEM_JOB = '�ڿ���';
      
-- 2)LOWER(c1), UPPER(c1), INITCAP(c1)
   -LOWER(c1) : c1���ڿ��� ���Ե� ��� ���ڿ��� �ҹ��ڷ� ��ȯ
   -UPPER(c1) : c1���ڿ��� ���Ե� ��� ���ڿ��� �빮�ڷ� ��ȯ
   -INITCAP(c1) : c1���ڿ��� ���Ե� �ܾ��� ù���ڸ� �빮�ڷ� ��ȯ
   
��뿹)ȸ����ȣ 'D001'ȸ���� 2005�� 5�� ������ ������ ��ȸ�Ͻÿ�
        Alias�� ��¥,��ǰ��ȣ,���ż���
        
        SELECT SUBSTR(CART_NO,1,8) AS ��¥,
               CART_PROD AS ��ǰ��ȣ,
               CART_QTY AS ���ż���
          FROM CART
         WHERE CART_NO LIKE '200505%'
           AND INITCAP(CART_MEMBER)='D001'; --UPPER�� ����
           
           SELECT INITCAP(LOWER(FIRST_NAME)||'. '||LOWER(LAST_NAME))
             FROM HR.EMPLOYEES;
           
--     3)LPAD(c1,n[,c2]), RPAD(c1,n[,c2])
         - n��ŭ Ȯ���� �������� c1�� ����(LPAD), ������(RPAD)���� �����ϰ�
           ���� �������� c2�� ä�� ��ȯ
         - c2�� �����Ǹ� ������ ä����
         
��뿹)SELECT LPAD(TO_CHAR(PROD_COST),10,'*'),
             RPAD(TO_CHAR(PROD_COST),10,'*'),
             LPAD(TO_CHAR(PROD_NAME),30),
             RPAD(TO_CHAR(PROD_NAME),30)
        FROM PROD;
        
--       4)LTRIM(c1[,c2]), RTRIM(c1[,c2])
         - �־��� ���ڿ� c1���� ���ʺ���(LTRIM), �����ʺ���(RTRIM) c2���ڿ���
           ��ġ�ϴ� �κ��� ���� 
         - c1���� c2�� ã���� �ݵ�� c1�� ù��° ���ڿ����� c2�� �����ؾ���
         - c2�� �����Ǹ� ������ ã�� ����
         - c1 ������ ������ �������� ����
         
��뿹)
        SELECT LTRIM('PERSIMON APPLE BANANA','RP'),
               RTRIM('PERSIMON APPLE BANANA','NA'),
               LTRIM('    PERSIMON APPLE BANANAN    '),
               RTRIM('    PERSIMON APPLE BANANAN    ')
          FROM DUAL;
             
 -- 5)TRIM(c1)
     -- ���ڿ� c1�� ���ʰ� �����ʿ� �����ϴ� ������ ����
     -- ���ڿ� ������ �������Ŵ� �Ұ���

��뿹)
    SELECT TRIM('    PERSIMON APPLE BANANA    ')
      FROM DUAL;
      
��뿹)������̺��� EMP_NAM�÷��� ������ Ÿ���� �������� ���ڿ� ������
      �����Ͻÿ�
      
      ALTER TABLE HR.EMPLOYEES
        MODIFY(EMP_NAME CHAR(80));
             
      ALTER TABLE HR.EMPLOYEES
        MODIFY(EMP_NAME VARCHAR2(80));
    
      UPDATE HR.EMPLOYEES
         SET EMP_NAME=TRIM(EMP_NAME);
         
        COMMIT;             
      
    (6)SUBSTR(c, sindex[, cnt)
     - �־��� ���ڿ� c���� sindex��ġ ���� cnt���� ��ŭ�� ���ڿ��� �����Ͽ�
       ��ȯ��
     - ������ġ�� 1���� ���۵�
     - cnt �� �����Ǹ� sindex ���� ������ ��� ���ڿ� ��ȯ
     - sindex�� �����̸� ������ ���� ó����
     
��뿹)
    SELECT SUBSTR('ILPOSTINO BOYHOOD', 2,5), 
           SUBSTR('ILPOSTINO BOYHOOD', 2),
           SUBSTR('ILPOSTINO BOYHOOD', -12,5)
      FROM DUAL;
    
��뿹)��ٱ������̺��� 2005�� 4���� 6���� �Ǹŵ� ��ǰ��
      �Ǹ����踦 ��ȸ�Ͻÿ�.
      Alias�� ��ǰ�ڵ�,�Ǹż���,�Ǹűݾ�
      SELECT A.CART_PROD AS ��ǰ�ڵ�,
             SUM(A.CART_QTY) AS �Ǹż���,
             SUM(A.CART_QTY*B.PROD_PRICE) AS �Ǹűݾ�
        FROM CART A, PROD B
       WHERE A.CART_PROD=B.PROD_ID
         AND (SUBSTR(A.CART_NO,1,6)='200504' OR --IN('200504','200506')
             SUBSTR(A.CART_NO,1,6)='200506')
         GROUP BY A.CART_PROD
         ORDER BY 1;
      
    (7)REPLACE(c1, c2[,c3])
      - �־��� ���ڿ� c1���� c2���ڿ��� ã�� c3���ڿ��� ġȯ
      - c3�� �����ϸ� c2�� ã�� ���� ��
      
      SELECT REPLACE('PERSIOM ALLPE BANANA','A','M'),
             REPLACE('PERSIOM ALLPE BANANA','A'),
             REPLACE('PERSIOM ALLPE BANANA',' ')
        FROM DUAL;
    
    
    
    
    
    
    