2021-1124-02)
   3)�񵿵�����(Non Eqi-Join)
    - �������ǿ� '='������ �̿��� �����ڰ� ���� ���
    - ������̺��� � ���� �������̺��� ���� ���� ������ ���
��뿹)������̺��� �޿��� ��ձ޿����� ���� ����� �����ȣ,�����,�޿�,
      �μ��ڵ�,��ձ޿��� ��ȸ�Ͻÿ�
      SELECT A.EMPLOYEE_ID AS �����ȣ,
             A.EMP_NAME AS �����,
             A.SALARY AS �޿�,
             A.DEPARTMENT_ID AS �μ��ڵ�,
             B.ASAL AS ��ձ޿�
      FROM HR.EMPLOYEES A, (SELECT ROUND(AVG(SALARY)) AS ASAL
                              FROM HR.EMPLOYEES) B
      WHERE B.ASAL<A.SALARY       
      ORDER BY 3;
      
    4)��������(Self-Join)
     - �ϳ��� ���̺� ���� �ٸ� ��Ī�� �ο��Ͽ� ���� �ٸ� ���̺��
       ����ϸ鼭 �����ϴ� ����
       
��뿹)ȸ����ȣ 'b001'ȸ���� ���ϸ������� ���� ���ϸ�����
      ������ ȸ���� ȸ����ȣ,ȸ����,����,���ϸ���
      --��
      SELECT A.MEM_ID AS ȸ����ȣ,
             A.MEM_NAME AS ȸ����,
             A.MEM_JOB AS ����,
             A.MEM_MILEAGE AS ���ϸ���,
             B.MEM_MILEAGE AS ���ظ��ϸ���
        FROM MEMBER A, (SELECT MEM_MILEAGE
                        FROM MEMBER
                        WHERE MEM_ID='b001') B
        WHERE A.MEM_MILEAGE > B.MEM_MILEAGE
        ORDER BY 4;
        
        --������
        SELECT A.MEM_ID AS ȸ����ȣ,
             A.MEM_NAME AS ȸ����,
             A.MEM_JOB AS ����,
             A.MEM_MILEAGE AS ���ϸ���,
             B.MEM_MILEAGE AS ���ظ��ϸ���
          FROM MEMBER A, MEMBER B
          WHERE B.MEM_ID='b001'
            AND A.MEM_MILEAGE > B.MEM_MILEAGE
            ORDER BY 4;
            
��뿹)������� �޿��� �ڽ��� ���� �μ��� ��ձ޿����� ���� ������� �����ȣ,
      �����,�μ���ȣ,�޿�,�μ���ձ޿��� ��ȸ�Ͻÿ�.
      
��뿹)������ '�ڿ���'�� ��� ȸ������ ������ ���ϸ������� ���� ���ϸ�����
      �������ִ� ȸ���� ȸ����ȣ,ȸ����,����,���ϸ����� ��ȸ�Ͻÿ�
     
           SELECT A.MEM_ID AS ȸ����ȣ,
                  A.MEM_NAME AS ȸ����,
                  A.MEM_JOB AS ����,
                  A.MEM_MILEAGE AS ���ϸ���
           FROM MEMBER A
           WHERE A.MEM_MILEAGE >ANY (SELECT MEM_MILEAGE --ANY
                                        FROM MEMBER
                                        WHERE MEM_JOB='�ڿ���');
��뿹)������ '�ڿ���'�� ȸ������ ������ ��� ���ϸ������� ���� ���ϸ�����
      �������ִ� ȸ���� ȸ����ȣ,ȸ����,����,���ϸ����� ��ȸ�Ͻÿ�
      
        SELECT A.MEM_ID AS ȸ����ȣ,
                  A.MEM_NAME AS ȸ����,
                  A.MEM_JOB AS ����,
                  A.MEM_MILEAGE AS ���ϸ���
           FROM MEMBER A
           WHERE A.MEM_MILEAGE >ALL (SELECT MEM_MILEAGE --ALL
                                        FROM MEMBER
                                        WHERE MEM_JOB='�ڿ���');