2021-1130-03)�б⹮
 - ���α׷��� ���� �� Ư�� ������ �Ǵ��Ͽ� ���� ������ �ٲٴ� ���
 - IF��, CASE WHEN THEN�� ����
 1)IF ��
  - ���α׷��־���� IF���� ���ϱ�� ����
  (�������-1)
  IF ����1 THEN
     ��ɹ�1;
 [ELSIF ����2 THEN
     ��ɹ�2;]
 [ELSE
     ��ɹ�n;]
  END IF;   
  
  (�������-2)--��øIF(���϶� �Ǵٸ� ������ �ٿ��ٶ�)
  IF ����1 THEN
     IF ����2 THEN
        ��ɹ�1;
    [ELSE
        ��ɹ�2;]
     END IF;
 [ELSE
    ��ɹ�n;]
  END IF;  
  
��뿹)������̺��� ������ �μ��ڵ带 �����Ͽ� �ش� �μ��� ù��° �˻��� ������
      �޿��� 3000���ϸ� '�����޿� ����'
            3001-6000�̸� '�߰��޿� ����'
            6001-10000�̸� '�����޿� ����'
            �� �̻��̸� '�ֻ��� �޿� ����'�� ����Ͻÿ�
      Alias�� �μ���ȣ,�����,�޿�,����̴�. 
      
      DECLARE
        V_DID HR.EMPLOYEES.DEPARTMENT_ID%TYPE;
        V_ENAME HR.EMPLOYEES.EMP_NAME%TYPE;
        V_SALARY NUMBER:=0;
        V_REMARKS VARCHAR2(100);       
      BEGIN
        V_DID:=TRUNC(DBMS_RANDOM.VALUE(10,119),-1) --�μ���ȣ
        SELECT EMP_NAME,SALARY INTO V_ENAME.V_SALARY
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID=V_DID
           AND ROWNUM=1;
        IF V_SALARY<=3000 THEN
           V_REMARKS:='�����޿� ����';
        ELSIF V_SALARY<=6000 THEN
              V_REMARKS:='�߰��޿� ����';
        ELSIF V_SALARY<=1000 THEN
              V_REMARKS:='�����޿� ����';
        ELSE
              V_REMARKS:='�ֻ��� �޿� ����';
        END IF;   
        
        DBMS_OUTPUT.PUT_LINE('�μ���ȣ : '||V_DID);
        DBMS_OUTPUT.PUT_LINE('����� : '||V_ENAME);
        DBMS_OUTPUT.PUT_LINE('�޿� : '||V_SALARY);
        DBMS_OUTPUT.PUT_LINE('��� : '||V_REMARKS);
      END;
      
��뿹)�����ϳ��� �Է� �޾�
      100-97 : A+
      96-94 : A0,
      93-90 : A-,
      89-97 : B+,
      86-84 : B0,
      83-80 : B-
      �� ���ϴ� F�� ���
      
      ACCEPT P_SCORE PROMPT '�����Է� : '
      DECLARE
        V_SCORE NUMBER:=TO_NUMBER('&P_SCORE');
        V_RES VARCHAR2(100);
      BEGIN
        IF V_SCORE>=90 THEN
           IF V_SOCRE>=97 THEN
              V_RES:='A+�Դϴ�';
           ELSIF V_SCORE>=94 THEN
                 V_RES:='A0�Դϴ�';
           ELSE
              V_RES:='A-�Դϴ�';
           END IF;
        ELSIF V_SCORE>=80 THEN
           IF V_SOCRE>=87 THEN
              V_RES:='B+�Դϴ�';
           ELSIF V_SCORE>=84 THEN
                 V_RES:='B0�Դϴ�';
           ELSE
              V_RES:='B-�Դϴ�';
           END IF;
         ELSE    
             V_RES:='F �Դϴ�';
         END IF;
         
         DBMS_OUTPUT.PUT.LINE(V_SCORE||'����'||V_RES);
       END;  
       
 2)CASE WHEN ~ THEN ��
  - ���ߺб������� �ڹ��� SWITCH~CASE���� ����
  (�������1)
  CASE ǥ����
      WHEN ���1 THEN
           ��ɹ�1;
      WHEN ���2 THEN
           ��ɹ�2;
           :
      ELSE
           ��ɹ�n;
  END CASE; 
  
  (�������2)
  CASE WHEN ǥ����1 THEN
            ��ɹ�1;
       WHEN ǥ����2 THEN
            ��ɹ�2;
            :
       ELSE
            ��ɹ�n;
  END CASE;  