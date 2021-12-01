2021-1201-02)

��뿹)�������� ���̺� ����� ��������� ��ȸ�Ͽ� �ش� �����
      �����ȣ,�����,�Ի���,�μ���,�������� ����Ͻÿ�.
      
      DECLARE
        CURSOR CUR_JOB_HISTORY IS
            SELECT DISTINCT EMPLOYEE_ID
              FROM HR.JOB_HISTORY;
         V_EID HR.EMPLOYEES.EMPLOYEE_ID%TYPE; --�����ȣ
         V_ENAME HR.EMPLOYEES.EMP_NAME%TYPE; --�����
         V_HDATE DATE; --�Ի���
         V_DEPT HR.DEPARTMENTS.DEPARTMENT_NAME%TYPE; --�μ���
         V_JOBT HR.JOBS.JOB_TITLE%TYPE; --������
        BEGIN
            OPEN CUR_JOB_HISTORY;
            LOOP 
                FETCH CUR_JOB_HISTORY INTO V_EID; --Ŀ������ EMPLOYEEID�� VEID�� ����?
                EXIT WHEN CUR_JOB_HISTORY%NOTFOUND; --Ż������
                SELECT A.EMP_NAME,B.DEPARTMENT_NAME,C.JOB_TITLE,A.HIRE_DATE
                  INTO V_ENAME,V_DEPT,V_JOBT,V_HDATE
                  FROM HR.EMPLOYEES A, HR.DEPARTMENTS B, HR.JOBS C
                 WHERE A.EMPLOYEE_ID=V_EID
                   AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
                   AND A.JOB_ID=C.JOB_ID;
                
                DBMS_OUTPUT.PUT_LINE('�����ȣ : '||V_EID);
                DBMS_OUTPUT.PUT_LINE('����� : '||V_ENAME);
                DBMS_OUTPUT.PUT_LINE('�Ի��� : '||V_HDATE);
                DBMS_OUTPUT.PUT_LINE('�μ��� : '||V_DEPT);
                DBMS_OUTPUT.PUT_LINE('��å�� : '||V_JOBT);
                DBMS_OUTPUT.PUT_LINE('----------------------------');
            END LOOP;
            CLOSE CUR_JOB_HISTORY;
        END;
              

(FOR�� ���)
    DECLARE
        CURSOR CUR_JOB_HISTORY IS
            SELECT DISTINCT EMPLOYEE_ID AS EID
              FROM HR.JOB_HISTORY;
         V_ENAME HR.EMPLOYEES.EMP_NAME%TYPE; --�����
         V_HDATE DATE; --�Ի���
         V_DEPT HR.DEPARTMENTS.DEPARTMENT_NAME%TYPE; --�μ���
         V_JOBT HR.JOBS.JOB_TITLE%TYPE; --������
        BEGIN
            FOR REC IN CUR_JOB_HISTORY LOOP
                SELECT A.EMP_NAME,B.DEPARTMENT_NAME,C.JOB_TITLE,A.HIRE_DATE
                  INTO V_ENAME,V_DEPT,V_JOBT,V_HDATE
                  FROM HR.EMPLOYEES A, HR.DEPARTMENTS B, HR.JOBS C
                 WHERE A.EMPLOYEE_ID=REC.EID
                   AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
                   AND A.JOB_ID=C.JOB_ID;
                
                DBMS_OUTPUT.PUT_LINE('�����ȣ : '||REC.EID);
                DBMS_OUTPUT.PUT_LINE('����� : '||V_ENAME);
                DBMS_OUTPUT.PUT_LINE('�Ի��� : '||V_HDATE);
                DBMS_OUTPUT.PUT_LINE('�μ��� : '||V_DEPT);
                DBMS_OUTPUT.PUT_LINE('��å�� : '||V_JOBT);
                DBMS_OUTPUT.PUT_LINE('----------------------------');
            END LOOP;
        END;
              
