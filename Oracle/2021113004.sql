2021-1130-04)�ݺ����� Ŀ��
1.�ݺ���
  - ���α׷��־���� �ݺ����� ���Ұ� ����
  - LOOP, WHILE, FOR�� ����
 1) LOOP ��
  . ���ѷ����� ����
  . �ݺ����� �⺻ ���� ����
  (�������)
    LOOP
      �ݺ���ɹ�(��);
     [EXIT WHEN ����;]
    END LOOP;
    - 'EXIT WHEN ����': ������ ���� ��� �ݺ��� ���
��뿹)�������� 7���� ����Ͻÿ�.
      DECLARE
        V_CNT NUMBER:=1;
        V_SUM NUMBER:=0;
      BEGIN
        LOOP
          V_SUM:=7*V_CNT;
          EXIT WHEN V_CNT>9;
          DBMS_OUTPUT.PUT_LINE(7||'*'||V_CNT||'='||V_SUM);
          V_CNT:=V_CNT+1;
        END LOOP;
      END;  
      
��뿹)ù���� 100��, ��°�� ���� ������ 2�辿 ������ ��� 100������ �Ѵ³��� 
      ����°�̸� �׶����� ������ �ѱݾ���?
      DECLARE
        V_DAYS NUMBER:=1;
        V_SUM NUMBER:=0;
        V_CNT NUMBER:=100;
      BEGIN
       LOOP
         V_SUM:=V_SUM+V_CNT;
         EXIT WHEN V_SUM>1000000;
         V_DAYS:=V_DAYS+1;
         V_CNT:=V_CNT*2;          
        END LOOP;
            DBMS_OUTPUT.PUT_LINE('����= '||V_DAYS);
            DBMS_OUTPUT.PUT_LINE('�ݾ�= '||V_SUM);
      END;  
      
 2) WHILE ��--����Ŭ���� �ݺ����� Ŀ���� ����ϱ����ؼ� 
  . �����Ǵ� �� �ݺ� ����
  . �ݺ�Ƚ���� �߿����� �ʰų� Ƚ���� ���� ���Ҷ�
  . �ݺ��� ����� Ż�������� �˰� ������
 (�������)
   WHILE ���� LOOP
     �ݺ�ó����(��);
     
   END LOOP;
    - '����'�� ���̸� �ݺ�����, �����̸� �ݺ��� ������
    
���������� WHILE ������ �����Ͻÿ�

     DECLARE
       V_CNT NUMBER:=1;
       V_SUM NUMBER:=0;
     BEGIN
       WHILE V_CNT<=9 LOOP
         V_SUM:=V_CNT*7;
         DBMS_OUTPUT.PUT_LINE('7*'||V_CNT||'='||V_SUM);
         V_CNT:=V_CNT+1;
       END LOOP;
     END;  
     
      DECLARE
        V_DAYS NUMBER:=1;
        V_SUM NUMBER:=0;
        V_CNT NUMBER:=100;
      BEGIN
       WHILE V_SUM<1000000 LOOP
         V_SUM:=V_SUM+V_CNT;        
         V_DAYS:=V_DAYS+1;
         V_CNT:=V_CNT*2;

        END LOOP; 
         DBMS_OUTPUT.PUT_LINE('����= '||V_DAYS);
         DBMS_OUTPUT.PUT_LINE('�ݾ�= '||V_SUM);
      END;  
     
 3) FOR ��
  . �ݺ�Ƚ���� �߿��ϰų� �ݺ�Ƚ���� ��Ȯ�� �˰� �ִ� ���
  (�Ϲ��� FOR���� �������)
    FOR �ε��� IN [REVERSE] �ʱⰪ...������ LOOP
      �ݺ�ó����ɹ�(��);
    END LOOP;
    
  . �ε��� : �ʱⰪ���� �������� ������ ���������� �ý��ۿ��� Ȯ������  
  . �ʱⰪ..������ : �ְ����� ���������� 1�� ����
  . REVERSE : ����(������..�ʱⰪ)���� ������ ����
  
��뿹)�������� 7��
      DECLARE
        V_SUM NUMBER:=0;
      BEGIN
        FOR I IN 1..9 LOOP
          V_SUM:=7*I;
          DBMS_OUTPUT.PUT_LINE('7*'||I||'='||V_SUM);
        END LOOP;  
      END;

  (Ŀ���� FOR���� �������)
    FOR ���ڵ� IN Ŀ���̸�|Ŀ���� SELECT�� LOOP
      ó����ɹ�(��);
    END LOOP;
    . Ŀ���÷� ������ '���ڵ�.Ŀ���÷���'
      
      