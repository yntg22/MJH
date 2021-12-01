2021-1110-01)
  (5)BETWEEN ������
   . ������ �����Ҷ� ���Ǵ� ������
   . AND �����ڷ� ��ġ�� �� ����
   (�������)
   expr BETWEEN ������1 AND ������2
    - 'expr' ���� '������1'���� '������2' ���̿� �����ϸ� ����� ��
    - '������1'�� '������2'�� ���� Ÿ���̾�� ��
    - ����� �� �ִ� ������ Ÿ���� ��� Ÿ�� ����
    - Ư��, --��¥ ���� ������ ���� ���
    
��뿹)������̺��� �Ի����� 2006��~2007�⿡ �Ի��� ����� ��ȸ�Ͻÿ�
      ��ȸ�� ���� �����ȣ,�����,�μ��ڵ�,�Ի���,�����ڵ��̸�
      �Ի��� ��, �μ��ڵ������ ����Ͻÿ�.
    (AND ������ ���)
      SELECT EMPLOYEE_ID AS �����ȣ,
             EMP_NAME AS �����,
             DEPARTMENT_ID AS �μ��ڵ�,
             HIRE_DATE AS �Ի���,
             JOB_ID AS �����ڵ�
        FROM HR.EMPLOYEES
        WHERE HIRE_DATE>=TO_DATE('20060101') AND
              HIRE_DATE<=TO_DATE('20071231')
        ORDER BY 4,3; 
        
    (BETWEEN ������ ���)
       SELECT EMPLOYEE_ID AS �����ȣ,
             EMP_NAME AS �����,
             DEPARTMENT_ID AS �μ��ڵ�,
             HIRE_DATE AS �Ի���,
             JOB_ID AS �����ڵ�
        FROM HR.EMPLOYEES
        WHERE HIRE_DATE BETWEEN TO_DATE('20060101') AND TO_DATE('20071231')
        ORDER BY 4,3; 
        
��뿹)�������̺�(BUYPROD)���� 2005�� 2�� ����LIST�� ����Ͻÿ�
      Alias�� ��¥,��ǰ�ڵ�,����,�ݾ��̴�.
      SELECT BUY_DATE AS ��¥,
             BUY_PROD AS ��ǰ�ڵ�,
             BUY_QTY AS ����,
             (BUY_QTY*BUY_COST) AS �ݾ�
        FROM BUYPROD
        WHERE BUY_DATE BETWEEN TO_DATE('20050201') AND LAST_DAY(TO_DATE('20050201')); --LAST_DAY
       
    (6)LIKE ������
     . ������ ���ϴ� ���ڿ� �� ������
     . ���Ϲ���(���ϵ�ī��)�δ� '%','_'�� ���
     (a) '%'
       - '%'�� ���� ��ġ���� �� ������ ��� ���ڿ��� ���� ��
        ex) 'ȫ%' : ù ���ڰ� 'ȫ'�̰� ���������ڴ� � ���ڿ͵� �����Ǿ�
                    ���� ��� ��ȯ
            '%ȫ' : �� ���ڰ� 'ȫ'�� ��� ���ڿ��� ���� ��
            '%ȫ%' : ���ڿ� ���ο� 'ȫ'���ڰ� �ִ� ��� ���ڿ��� ����
            
     (b) '_'
      - '_'�� ���� ��ġ�� �� ���ڿ� ����
        ex) 'ȫ_' : �� ���ڷ� �����ǰ� ù ���ڰ� 'ȫ'�� ���ڿ��� ����
            '_ȫ' : �� ���ڰ� 'ȫ'�� 2�ڷ� ������ ���ڿ��� ���� ��
            '_ȫ_' : ���ڿ� ���ο� 'ȫ'���ڰ� �ִ� �����ڷ� ������ ���ڿ��� ����
            
��뿹)ȸ�����̺��� �������� '����'�� ȸ�� ������ ��ȸ�Ͻÿ�
      Alias�� ȸ����ȣ,ȸ����,�ּ�,����
      SELECT MEM_ID AS ȸ����ȣ,
             MEM_NAME AS ȸ����,
             MEM_ADD1||' '||MEM_ADD2 AS �ּ�,
             MEM_JOB AS ����
        FROM MEMBER
        WHERE MEM_ADD1 LIKE '����%';

��뿹)��ٱ������̺��� 2005�� 7�� �����̷��� �ִ� ȸ����ȣ��
      ��ȸ�Ͻÿ�
      SELECT DISTINCT CART_MEMBER AS ȸ����ȣ --DISTINCT �ߺ����� 
        FROM CART
        WHERE CART_NO LIKE '200507%';
        
       
        
��뿹)��ǰ���� '���'�� ���Ե� ��� ��ǰ�� ��ȸ�Ͻÿ�
      Alias�� ��ǰ��ȣ,��ǰ��,�ŷ�ó�ڵ�,�з��ڵ�
      SELECT PROD_ID AS ��ǰ��ȣ,
             PROD_NAME AS ��ǰ��,
             PROD_BUYER AS �ŷ�ó�ڵ�,
             PROD_LGU AS �з��ڵ� 
        FROM PROD
        WHERE PROD_NAME LIKE '%���%';
        
        
        
        
        
��뿹)������̺��� �Ի����� 2006��~2007�⿡ �Ի��� ����� ��ȸ�Ͻÿ�
      ��ȸ�� ���� �����ȣ,�����,�μ��ڵ�,�Ի���,�����ڵ��̸�
      �Ի��� ��, �μ��ڵ������ ����Ͻÿ�.
      
      SELECT EMP_NAME AS �̸�,
             HIRE_DATE AS �Ի���
        FROM HR.EMPLOYEES
        WHERE HIRE_DATE BETWEEN TO_DATE('20060101') AND LAST_DAY(TO_DATE('20070101'))
        ORDER BY 2;
      
      
      
      
      
      
      
      
      
      
      