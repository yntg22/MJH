20201-1104-01)
  2) ���ڿ� ��
  . �Ǽ� �Ǵ� ������ �����ϴ� �ڷ���
  . NUMBER Ÿ�Ը� ������
  (�������)
   �÷��� NUMBER[(*|���е�[,������])]
    .'*|���е�' : ��ü �ڸ���(1~30���� ����)
    . '*'�� ����ϸ� �ý��ۿ��� �ڸ��� ������ ����
    . '������' : �Ҽ��� ������ �ڸ���(84~127)
    .ǥ������ : 1.0 x E-130 ~ 9.9999... E+125(�Ҽ�������'9'�� ���� 38��)
    .�ڷ��� ����
     - �������� ����� ��� : �����Ϸ��� �ڷ��� �Ҽ������� (������+1)�ڸ�����
                            �ݿø��Ͽ� (������)�ڸ��� ��ŭ ����
     - �������� ������ ��� : �����κп��� (������) ��ġ�� ���� �κп��� �ݿø�
     . ex)
     --------------------------------------------------------------------
      Ÿ�� ����          ������         ����Ǵ� ��
     --------------------------------------------------------------------
      NUMBER          12345.9876      12345.9876 
      NUMBER(*,3)     12345.9876      12345.988
      NUMBER(4)       12345.9876         ����
      NUMBER(7,3)     12345.9876         ����
      NUMBER(10.2)    12345.9876         12345.99   (��3�ڸ� ����)
      NUMBER(7.0)     12345.9876        12346       (��2�ڸ� ����)
      NUMBER(7)       12345.9876        12346
      ------------------------------------------------------------------
      
      
      (��뿹) CREATE TABLE TEMP5 (
                COL1 NUMBER,
                COL2 NUMBER(*,3),
                COL3 NUMBER(4),
                COL4 NUMBER(7.3),
                COL5 NUMBER(10.2),
                COL6 NUMBER(7.0),
                COL7 NUMBER(7),
                );
                
                INSERT INTO TEMP5 
                    VALUES(12345.9876,12345.9876,2345.9876,1234.9876,
                           12345.9876,12345.9876,12345.9876);
      SELECT * FROM TEMP5;
      
      **���е� < ������
       . ���е��� '0'�̾ƴ� ��ȿ ������ ��
       . ������ : �Ҽ��������� �ڸ���
       . ������ - ���е� : �Ҽ������Ͽ� �� ���� ���;��� '0'�� ����
       
       EX)
       ------------------------------------------------------------
         �Է� ��         ����             ���Ǵ� ��
         0.12345       NUMBER(3,5)         ����       
         0.012345      NUMBER(4,5)       0.01235
         0.0012345     NUMBER(3,5)       0.00123
         1.23          NUMBER(1,3)         ����
         0.012         NUMBER(2,5)         ����
       ------------------------------------------------------------
       
       
       