2021-1116-01)
 4. ��ȯ�Լ�
   - ����Ŭ���� ����ϴ� �������� ����ȯ�� ���
   - CAST, TO_CHAR, TO_DATE, TO_NUMBER �Լ� ����
   
   1)CAST(expr AS Ÿ�Ը�)
    . 'expr'�� ���õ� �����ͳ� �÷� ���� 'Ÿ�Ը�'���� ���� ��ȯ��
    
��뿹) SELECT 1234,CAST(1234 AS VARCHAR(10)) AS "COL1",
            CAST(1234 AS CHAR(10)) AS "COL2"
        FROM DUAL;
��뿹)2005�� 7�� ���ں� �Ǹ����踦 ��ȸ�Ͻÿ�
        Alias�� ����,�Ǹż����հ�,�Ǹűݾ��հ�
        
        SELECT CAST(SUBSTR(A.CART_NO,1,8) AS DATE) AS ����,
               SUM(A.CART_QTY) AS �Ǹż����հ�,
               SUM(A.CART_QTY*B.PROD_PRICE) AS �Ǹűݾ��հ�
          FROM CART A, PROD B
          WHERE A.CART_PROD=B.PROD_ID
            AND A.CART_NO LIKE '200507%'
            GROUP BY SUBSTR(A.CART_NO,1,8)
            ORDER BY 1;
            CREATE TABLE OPOP(OPOP1 NUMBER(1));
            DROP TABLE OPOP;
 2)TO_CHAR(expr[, 'fmt'])
  . ����, ��¥, ���ڿ� Ÿ���� ���ڿ� Ÿ������ ��ȯ
  . 'expr'�� ���ڿ��� ��� CHAR,CLOBŸ���� VARCHAR2�� ��ȯ�� ����
  . 'fmt' : ��ȯ�Ϸ��� �����������ڿ��� ��¥�� ���������� �и�
  . ��¥�� FORMAT STRING
  -------------------------------------------------------------
  �����������ڿ�       �ǹ�          ��뿹
  -------------------------------------------------------------
  AD, BC             ����           SELECT TO_CHAR(SYSDATE,'BC') FROM DUAL;
  CC                 ����           SELECT TO_CHAR(SYSDATE,'BC CC') FROM DUAL;            
  YYYY,YYY,YY,Y      �⵵           SELECT TO_CHAR(SYSDATE,'CC YYYY') FROM DUAL;
  MONTH.MON.MM.RM    ��             SELECT TO_CHAR(SYSDATE,'YYYYMMDD MONTH') FROM DUAL;
  DD,DDD,J           ��             SELECT TO_CHAR(SYSDATE,'YYMMDD DDD D') FROM DUAL;
  DAY,DY,D           ����           SELECT TO_CHAR(SYSDATE,'YYMMDD DAY DY J') FROM DUAL;           
  Q                  �б�           SELECT TO_CHAR(SYSDATE, 'YYMMDD Q') FROM DUAL;
  AM,PM,A.M., P.M.   ����/����       SELECT TO_CHAR(SYSDATE, 'YYMMDD AM PM A.M. P.M.') FROM DUAL;
  HH,HH24,HH12       ��             SELECT TO_CHAR(SYSDATE,'YYMMDD HH, HH12 HH24') FROM DUAL;
  MI                 ��             SELECT TO_CHAR(SYSDATE, 'YYMMDD HH24 : MI : SS') FROM DUAL;
  SS,SSSSS           ��             SELECT TO_CHAR(SYSDATE, 'YYMMDD HH24:MI:SS SSSSS') FROM DUAL;
  "���������"                       SELECT TO_CHAR(SYSDATE, 'YY"��" MM"��" DD"��" HH24:MI:SS SSSSS') FROM DUAL;
  ----------------------------------------------------------------
  . ������ FORMAT STRING
  ------------------------------------------------------------------
  �����������ڿ�           �ǹ�                      ��뿹
  -------------------------------------------------------------------
       9          ��ȿ�� 0�� ����ó��                SELECT TO_CHAR(1234, '99,999') FROM DUAL;
       0          ��ȿ�� 0�� '0'���ó��             SELECT TO_CHAR(1234, '00,000') FROM DUAL;
      $,L         ���� ���ʿ� ȭ���ȣ               SELECT TO_CHAR (1234, 'L00,000') FROM DUAL;
       MI         ������ ��� ������ '-' ��ȣ ���    SELECT TO_CHAR(-1234, '00,000MI') FROM DUAL;
       PR         ������ '< >'�ȿ� ǥ��              SELECT TO_CHAR(-1234, '00,000PR') FROM DUAL;
    ,(COMMA)      3�ڸ������� �ڸ���                 SELECT TO_CHAR(1234567, '99,999')FROM DUAL;
     .(DOT)       �Ҽ���                           SELECT TO_CHAR(12.323, '99.9999') FROM DUAL;
  ----------------------------------------------------------------------
 
  3) TO_NUMBER(expr[,'fmt'])
   . 'expr'(���ڿ� �ڷ�)�� ������ �ڷ�� ��ȯ  
   . 'expr'�� �ݵ�� ���ڷ� ��ȯ �����ؾ���
   . 'fmt'�� TO_CHAR�� ���� �����������ڿ��� �����ϳ� ���ڷ� ��޵ɼ� �ִ�
     ���ڿ��� ����('9', '.' ��)
��뿹) SELECT TO_NUMBER(MEM_BIR)
         FROM MEMBER;
    
    SELECT TO_NUMBER('12,345', '99999'),
           TO_NUMBER('<12,345>', '99999PR'),
           TO_NUMBER('��12,345', 'L00000')
    FROM DUAL; 
    
 4)TO_DATE(expr[,'fmt'])
  . ���Ǵ� 'fmt'�� TO_CHAR��ȯ�Լ��� ����ϴ� �����������ڿ��� ���ǳ� ��¥�� ��ȯ�� ��
    �ִ� ���ڿ� �̾����
  . ���ڿ��ڷ�('expr')�� ��¥�� ��ȯ
            
��뿹)SELECT TO_DATE('20210228'),
             TO_DATE('20210220161759','YYYYMMDDHH24MISS')
        FROM DUAL;
            
            
            
            
            
            
            
            
            
            