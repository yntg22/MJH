2021-1130-02)PL/SQL
 - Procedural Language SQL
 - ǥ�� SQL�� ���������� ���(����,�ݺ���,�б⹮ ��)�� �������� �ʾ�
   ����� �������̾���
 - ������ ���డ���� ���·� ����Ǿ� ����(���� ��Ʈ��ũ�� ȿ���� ���)
 - ���ȭ, ĸ��ȭ ��� ����
 - ǥ�ع����� ���� �� DBMS�� ��������
 - �͸���(Anonymous block), stored Procedure, User defined
   Function, Package, Trigger �� ����
   
1. �͸���(Anonymous block)
  - PL/SQL�� �⺻ ���� ����
  - �����Ҽ� ����
 (ǥ������)
    DECLARE
      ����� --����,���,Ŀ�� ���� 
    BEGIN
      ����� --ó���� ����� ���������� ���
            --SQL��, �ݺ���, �б⹮ ��
      
      [EXCEPTION
        ����ó����;]--���ܹ߻��� ó���� ��� ���       
    END;    --����� ���� ����
    
��뿹)Ű����� �⵵�� �Է� �޾� ����� ����� �����ϴ� �͸� ��� �ۼ�  
      ����:4�� ����̸鼭 100�� ����� �ƴ� �� �Ǵ� 400�� ����� ��
      
      ACCEPT P_YEAR PROMPT '�⵵�Է� : '
      DECLARE
        V_YEAR NUMBER:=TO_NUMBER('&P_YEAR');
        V_RES VARCHAR2(200);
      BEGIN
        IF (MOD(V_YEAR,4)=0 AND MOD(V_YEAR,100)!=0) OR (
            MOD(V_YEAR,400)=0) THEN
            V_RES:=V_YEAR||'���� �����Դϴ�.';
        ELSE
            V_RES:=V_YEAR||'���� ����Դϴ�.';
        END IF;
        DBMS_OUTPUT.PUT_LINE(V_RES);
      END;
 1)����, ��� ����
  (�������)
   �ĺ��� [CONSTANT] ������Ÿ��|����Ÿ�� [:=�ʱⰪ];
   .'�ĺ���':������ �Ǵ� �����
   .'������Ÿ��':SQL���� ����ϴ� ��� ������Ÿ��
    - PLS_INTEGER, BINARY_INTEGER : 4BYTE ����(2147483647~-2147483648)
    - BOOLEAN ������
   .'����Ÿ��'
    - �÷����� : ���̺��.�÷���%TYPE : �ش� �÷��� ������ ������Ÿ�԰� ũ��� ��������
    - ������ : ���̺��%ROWTYPE : �ش� �� ��ü�� �����Ͽ� ���� ����(C����� ����ü��
              ���� Ÿ��)
   .��������� 'CONSTANT' ����Ͽ� �ݵ�� �ʱⰪ�� �����ؾ� ��
   
��뿹)ȸ�����̺��� ���ϸ����� ��ȸ�Ͽ� 5000�̻��̸� 'VIPȸ��',
      �� �����̸� '�Ϲ�ȸ��'�� ����� ����ϴ� �͸����� �ۼ�
      ����� �÷��� ȸ����ȣ,ȸ����,���ϸ���,���
      --SELECT INTO FROM WHERE : �͸��Ͽ��� ���Ǵ� SELECT�� ����
      
      DECLARE
        V_MID MEMBER.MEM_ID%TYPE;
        V_NAME MEMBER.MEM_NAME%TYPE;
        V_MILE MEMBER.MEM_MILEAGE%TYPE;
        V_BIGO VARCHAR2(30);
      BEGIN
        SELECT MEM_ID, MEM_NAME, MEM_MILEAGE 
          INTO V_MID, V_NAME, V_MILE
          FROM MEMBER
         WHERE ROWNUM=1; 
        IF V_MILE >= 5000 THEN
           V_BIGO:='VIPȸ��';
        ELSE
           V_BIGO:='�Ϲ�ȸ��';
        END IF;
        
        DBMS_OUTPUT.PUT_LINE('ȸ����ȣ : '||V_MID); 
        DBMS_OUTPUT.PUT_LINE('ȸ���� : '||V_NAME);
        DBMS_OUTPUT.PUT_LINE('���ϸ��� : '||V_MILE);
        DBMS_OUTPUT.PUT_LINE('��� : '||V_BIGO);
        DBMS_OUTPUT.PUT_LINE('--------------------------');
      END;
      
      (Ŀ�� ���)
        DECLARE
          V_BIGO VARCHAR2(30);
          CURSOR CUR_MEMBER IS
            SELECT MEM_ID,MEM_NAME,MEM_MILEAGE
              FROM MEMBER;
      BEGIN
        FOR REC IN CUR_MEMBER LOOP
            IF REC.MEM_MILEAGE >5000 THEN
               V_BIGO:='VIPȸ��';
            ELSE
               V_BIGO:='�Ϲ�ȸ��'; 
           END IF;
           DBMS_OUTPUT.PUT_LINE('ȸ����ȣ : '||REC.MEM_ID); 
           DBMS_OUTPUT.PUT_LINE('ȸ���� : '||REC.MEM_NAME);
           DBMS_OUTPUT.PUT_LINE('���ϸ��� : '||REC.MEM_MILEAGE);
           DBMS_OUTPUT.PUT_LINE('��� : '||V_BIGO);
           DBMS_OUTPUT.PUT_LINE('--------------------------');
         END LOOP;  
      END;
      
      
      
   