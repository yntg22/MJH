2021-1118-02)NULLó���Լ�
 - ����Ŭ�� ��� �ڷ�Ÿ���� �ڷᰡ �Էµ��� ���� ��� �⺻����
   NULL�� ����(NOT NULL ���������� �ο��� ��� ����)
 - NULL���� ����� ��� ����� NULL��
 - �̸� �ذ��ϱ����� �Լ��� NVL, NVL2, NULLIF ���� ������
 1) NULL���θ� �Ǵ��ϴ� ������
  . IS NULL, IS NOT NULL�� ����ؾ� ��.(=NULL, !=NULL�� ������ �ƴ����� ������ ���� ����)
��뿹)������̺��� ���������ڵ�(COMMISSION_PCT)�� NULL�� �ƴ� ���������
      ��ȸ�Ͻÿ�. Alias�� �����ȣ,�����,�μ��ڵ�,���������ڵ�
      SELECT EMPLOYEE_ID,EMP_NAME,DEPARTMENT_ID,COMMISSION_PCT
        FROM HR.EMPLOYEES
       -- WHERE COMMISSION_PCT != NULL;
       WHERE COMMISSION_PCT IS NOT NULL;
       
 2)NVL(col,val)
   .'col' ���� �Ǵ��Ͽ� �� ���� NULL�̸� 'VAL'���� ��ȯ�ϰ�, NULL�� �ƴϸ� 'col'
    ���� ��ȯ
   .'col'�� 'val'�� �ݵ�� ���� ������ Ÿ���̾�� ��
   .�ܺ����ο� ���� ����

��뿹)������̺��� ���������� ���� ���ʽ��� ����ϰ�
      �޿��� ���޾��� ����Ͽ� �����Ϸ��Ѵ� ���޸����� ����Ͻÿ�
      ���ʽ�=�޿�*���������ڵ�
      ���޾�=�޿�+���ʽ��̸�
      ����� �����ȣ,�����,�μ��ڵ�,���������ڵ�,�޿�,���ʽ�,���޾��̴�
      
      SELECT EMPLOYEE_ID AS �����ȣ,
             EMP_NAME AS �����,
             DEPARTMENT_ID AS �μ��ڵ�,
             NVL(COMMISSION_PCT,0) AS ���������ڵ�,
             SALARY AS �޿�,
             NVL(SALARY*COMMISSION_PCT,0) AS ���ʽ�,
             SALARY+NVL(SALARY*COMMISSION_PCT,0)���޾�
        FROM HR.EMPLOYEES
        ORDER BY 3;
**��ǰ���̺��� �з��ڵ尡 'P101'~'P202'�� ���ϴ� 
  ��ǰ�� ���ϸ���(PROD_MILEAGE)�÷� ���� �ǸŰ����� 0.05%�� �����Ͻÿ�
  
  UPDATE PROD 
     SET PROD_MILEAGE=ROUND(PROD_PRICE*0.0005)
   WHERE PROD_LGU>='P101' AND PROD_LGU<='P202';
      
    COMMIT;
    
��뿹)��ǰ���̺��� ��ǰ������ ���ϸ����� ��ȸ�ϵ�, �� ���� NULL�̸�
      '���ϸ����� �ο��������� ��ǰ'�̶�� �޽����� ���ϸ��� ���
      ����Ͻÿ�. Alias�� ��ǰ�ڵ�,��ǰ��,�ǸŰ���,���ϸ����̴�
      
      SELECT PROD_ID AS ��ǰ�ڵ�,
             PROD_NAME AS ��ǰ��,
             PROD_PRICE AS �ǸŰ���,
             PROD_MILEAGE AS ���ϸ���
      
      