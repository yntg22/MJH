2021-1109-01)
  (2) IN
    - ���õ� �������� �� �� ��� �ϳ��� ��ġ�ϸ� ��ü ������ ���̵Ǵ� ������
    - OR, =ANY, =SOME �����ڷ� ��ġ�� �� ����
    (�������)
    expr IN(��1[,��2,...��n]) --���� expr�� ��ġ�ϸ� ��

��뿹)������̺��� 20,50,90,110�� �μ��� ���� ����� �����ȣ,�����,
      �Ի���,�μ��ڵ�,�����ڵ带 ��ȸ�Ͻÿ�.
      (OR ������ ���)
      SELECT EMPLOYEE_ID AS �����ȣ,
             EMP_NAME AS �����,
             HIRE_DATE AS �Ի���,
             DEPARTMENT_ID AS �μ��ڵ�,
             JOB_ID AS �����ڵ�
        FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID = 20 OR DEPARTMENT_ID = 50 OR
              DEPARTMENT_ID = 90 OR DEPARTMENT_ID = 110
      ORDER BY 4;
      
      (IN ������ ���)
      SELECT EMPLOYEE_ID AS �����ȣ,
             EMP_NAME AS �����,
             HIRE_DATE AS �Ի���,
             DEPARTMENT_ID AS �μ��ڵ�,
             JOB_ID AS �����ڵ�
        FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID IN(20,50,90,110)
      ORDER BY 4;
      
��뿹)���ϸ����� 5000�̻�Ǵ� ȸ������ 2005�� 5�� ������Ȳ�� ��ȸ�Ͻÿ�
      Alias�� ȸ����ȣ,���ż����հ�,���űݾ��հ�

      SELECT A.CART_MEMBER AS ȸ����ȣ,
             SUM(A.CART_QTY) AS ���ż����հ�,
             SUM(A.CART_QTY*B.PROD_PRICE) AS ���űݾ��հ�
        FROM CART A, PROD B
       WHERE A.CART_MEMBER IN(SELECT MEM_ID
                              FROM MEMBER
                             WHERE MEM_MILEAGE>=5000)
         AND A.CART_PROD=B.PROD_ID
         AND A.CART_NO LIKE '200505%'
         GROUP BY A.CART_MEMBER
         ORDER BY 1;
         
    (3) ANY(SOME)������
     - IN �����ڿ� ����� ��� ����
     - ���õ� ������(( )�ȿ� ����� ������) �� ��� �ϳ��� ���ǿ� �����ϸ�
       ��ü ������ ����� TRUE�� �Ǵ� ������
       (�������)
        expr ���迬����ANY|SOME(��1[,��2,...,��n]) --���������� *üũ
        
��뿹)ȸ�����̺��� ������ '�ֺ�'�� ȸ���� ���ϸ������� �� ���� ���ϸ�����
      ������ ȸ�������� ��ȸ�Ͻÿ�.
      Alias�� ȸ����ȣ,ȸ����,����,���ϸ���
      
      SELECT MEM_ID AS ȸ����ȣ,
             MEM_NAME AS ȸ����,
             MEM_JOB AS ����,
             MEM_MILEAGE AS ���ϸ���
        FROM MEMBER
       --WHERE MEM_MILEAGE >ANY(SELECT MEM_MILEAGE
       WHERE MEM_MILEAGE >SOME(SELECT MEM_MILEAGE
                                FROM MEMBER
                               WHERE MEM_JOB='�ֺ�');
                               (1000,2700,800,2700,8700)
      
��뿹)������̺��� �� �μ��� ��ձ޿����� ���� �޿��� �޴� �����
      �����ȣ,�����,�μ���ȣ,�޿��� ����Ͻÿ�
      
      SELECT EMPLOYEE_ID AS �����ȣ,
             EMP_NAME AS �����,
             DEPARTMENT_ID AS �μ���ȣ,
             SALARY AS �޿�
        FROM HR.EMPLOYEES
       WHERE SALARY>SOME(SELECT A.SSAL
                            FROM (SELECT DEPARTMENT_ID,
                                ROUND(AVG(SALARY)) AS SSAL
                           FROM HR.EMPLOYEES
                          GROUP BY DEPARTMENT_ID)A);
                               
    (4)ALL ������
     - ���õ� ������ ��� �Ͱ� ������ �����ؾ� ��ü������ ���̵Ǵ� ������
     (�������)
        expr ���迬����ALL(��1[,��2,...,��n])
         .'���迬����' �� '=', '!='�� ������ ����(���Ǹ� �ش��÷���
          ���߰��� ���� ��찡�Ǿ� ��1 ������ ����)
         . AND �����ڷ� ġȯ ����
         
��뿹)ȸ�����̺��� ������'�л�'�� ��� ȸ���� ���ϸ������� �� ���� ���ϸ�����
      ������ ȸ�������� ��ȸ�Ͻÿ�.
      Alias�� ȸ����ȣ,ȸ����,����,���ϸ���
      (������ �л��� ȸ������ ���ϸ���)
       SELECT MEM_MILEAGE
         FROM MEMBER
        WHERE MEM_JOB ='�л�';
        
        SELECT MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����,
               MEM_JOB AS ����,
               MEM_MILEAGE AS ���ϸ���
          FROM MEMBER
         WHERE MEM_MILEAGE >ALL(SELECT MEM_MILEAGE
                                  FROM MEMBER
                                 WHERE MEM_JOB='�л�');
                                 