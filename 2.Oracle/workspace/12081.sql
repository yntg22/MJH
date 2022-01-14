/* Ƽ�� */
CREATE TABLE reservation  (
   t_no VARCHAR2(255) NOT NULL, /* Ƽ�Ϲ�ȣ */
   time_no NUMBER(5) NOT NULL, /* ������ */
   m_no NUMBER(10) NOT NULL, /* ����ȣ */
   pay_no VARCHAR2(255) NOT NULL, /* ������ȣ */
   use_mileage NUMBER(10), /* ��븶�ϸ��� */
   total_cost NUMBER(10) NOT NULL, /* �������� */
   t_day DATE NOT NULL /* ������ */
);

CREATE UNIQUE INDEX PK_reservation 
   ON reservation  (
      t_no ASC
   );

ALTER TABLE reservation 
   ADD
      CONSTRAINT PK_reservation 
      PRIMARY KEY (
         t_no
      );

/* �¼� */
CREATE TABLE seat (
   seat_no NUMBER(10) NOT NULL, /* �¼���ȣ */
   seat_charge NUMBER(10) NOT NULL, /* �¼� ��� */
   sc_no NUMBER(10) NOT NULL /* �󿵰���ȣ */
);

CREATE UNIQUE INDEX PK_seat
   ON seat (
      seat_no ASC
   );

ALTER TABLE seat
   ADD
      CONSTRAINT PK_seat
      PRIMARY KEY (
         seat_no
      );

/* ���ǹ� */
CREATE TABLE missing (
   mi_no VARCHAR2(255) NOT NULL, /* �Խù� ��ȣ */
   mi_title VARCHAR2(255) NOT NULL, /* ���ǹ� �̸� */
   mi_content VARCHAR2(5) NOT NULL, /* ���ǹ� ���� */
   mi_start DATE NOT NULL, /* ���������� */
   mi_end DATE NOT NULL, /* ���������� */
   emp_no NUMBER NOT NULL, /* ������ȣ */
   mi_owner VARCHAR2(10) NOT NULL /* ������ */
);

CREATE UNIQUE INDEX PK_missing
   ON missing (
      mi_no ASC
   );

ALTER TABLE missing
   ADD
      CONSTRAINT PK_missing
      PRIMARY KEY (
         mi_no
      );

/* ���� */
CREATE TABLE payment  (
   pay_no VARCHAR2(255) NOT NULL, /* ������ȣ */
   pay_wqy VARCHAR2(200) NOT NULL /* ������� */
);

CREATE UNIQUE INDEX PK_payment 
   ON payment  (
      pay_no ASC
   );

ALTER TABLE payment 
   ADD
      CONSTRAINT PK_payment 
      PRIMARY KEY (
         pay_no
      );

/* �������� */
CREATE TABLE announcement (
   an_no VARCHAR2(255) NOT NULL, /* ������ ��ȣ */
   an_title VARCHAR2(255) NOT NULL, /* ���� */
   an_content CLOB NOT NULL, /* ���� */
   an_user VARCHAR2(200) NOT NULL, /* �ۼ��� */
   an_date DATE NOT NULL, /* �ۼ����� */
   emp_no NUMBER NOT NULL /* ������ȣ */
);

CREATE UNIQUE INDEX PK_announcement
   ON announcement (
      an_no ASC
   );

ALTER TABLE announcement
   ADD
      CONSTRAINT PK_announcement
      PRIMARY KEY (
         an_no
      );

/* �Խ��� */
CREATE TABLE BOARD (
   board_no VARCHAR2(255) NOT NULL, /* �Խñ۹�ȣ */
   board_title VARCHAR2(255) NOT NULL, /* ���� */
   board_content CLOB NOT NULL, /* ���� */
   board_date DATE NOT NULL, /* �ۼ����� */
   board_user VARCHAR2(200) NOT NULL /* �ۼ��� */
);

CREATE UNIQUE INDEX PK_BOARD
   ON BOARD (
      board_no ASC
   );

ALTER TABLE BOARD
   ADD
      CONSTRAINT PK_BOARD
      PRIMARY KEY (
         board_no
      );

/* ���� */
CREATE TABLE review (
   review_no VARCHAR2(255) NOT NULL, /* �����ȣ */
   review_content CLOB, /* ���� */
   review_date DATE, /* �ۼ����� */
   review_user VARCHAR2(200), /* �ۼ��� */
   movie_no NUMBER /* ��ȭ ���й�ȣ */
);

CREATE UNIQUE INDEX PK_review
   ON review (
      review_no ASC
   );

ALTER TABLE review
   ADD
      CONSTRAINT PK_review
      PRIMARY KEY (
         review_no
      );

/* ��ȭ */
CREATE TABLE movie (
   movie_no NUMBER NOT NULL, /* ��ȭ ���й�ȣ */
   movie_name VARCHAR2(200), /* ��ȭ���� */
   movie_time DATE, /* ����Ÿ�� */
   movie_term DATE, /* �󿵱Ⱓ */
   movie_summary VARCHAR2(200), /* �ٰŸ� */
   movie_pd VARCHAR2(20), /* ���� */
   movie_acter VARCHAR2(50), /* �⿬�� */
   genre_no NUMBER(3) /* �帣��ȣ */
);

CREATE UNIQUE INDEX PK_movie
   ON movie (
      movie_no ASC
   );

ALTER TABLE movie
   ADD
      CONSTRAINT PK_movie
      PRIMARY KEY (
         movie_no
      );

/* ȯ�� */
CREATE TABLE refund (
   refund_number NUMBER NOT NULL, /* ȯ�ҹ�ȣ */
   t_no VARCHAR2(255) NOT NULL, /* Ƽ�Ϲ�ȣ */
   refund_price NUMBER NOT NULL, /* ȯ�Ұ��� */
   refund_date DATE NOT NULL /* ȯ������ */
);

CREATE UNIQUE INDEX PK_refund
   ON refund (
      refund_number ASC
   );

ALTER TABLE refund
   ADD
      CONSTRAINT PK_refund
      PRIMARY KEY (
         refund_number
      );

/* �󿵰� */
CREATE TABLE screen (
   sc_no NUMBER(10) NOT NULL, /* �󿵰���ȣ */
   sc_name VARCHAR2(20) NOT NULL, /* �󿵰��̸� */
   seat_all NUMBER(10) NOT NULL /* ���¼� */
);

CREATE UNIQUE INDEX PK_screen
   ON screen (
      sc_no ASC
   );

ALTER TABLE screen
   ADD
      CONSTRAINT PK_screen
      PRIMARY KEY (
         sc_no
      );

/* Ƽ�ϰ��� */
CREATE TABLE t_PRICE (
   p_no NUMBER(10) NOT NULL, /* ���ݹ�ȣ */
   p_name VARCHAR2(10) NOT NULL, /* �����̸� */
   p_cost NUMBER(10) NOT NULL /* ���� */
);

CREATE UNIQUE INDEX PK_t_PRICE
   ON t_PRICE (
      p_no ASC
   );

ALTER TABLE t_PRICE
   ADD
      CONSTRAINT PK_t_PRICE
      PRIMARY KEY (
         p_no
      );

/* ������ */
CREATE TABLE employees (
   emp_no NUMBER NOT NULL, /* ������ȣ */
   emp_name VARCHAR2(20) NOT NULL, /* �̸� */
   emp_hp VARCHAR2(20) NOT NULL, /* ����ó */
   emp_salary NUMBER NOT NULL, /* �޿� */
   emp_position VARCHAR2(30) NOT NULL, /* ��å */
   emp_id VARCHAR2(20) NOT NULL, /* ���̵� */
   emp_pass VARCHAR2(20) NOT NULL /* ��й�ȣ */
);

CREATE UNIQUE INDEX PK_employees
   ON employees (
      emp_no ASC
   );

ALTER TABLE employees
   ADD
      CONSTRAINT PK_employees
      PRIMARY KEY (
         emp_no
      );

/* �󿵽ð� */
CREATE TABLE r_time (
   time_no NUMBER(5) NOT NULL, /* ������ */
   time_start DATE NOT NULL, /* ���۽ð� */
   time_end DATE NOT NULL, /* ����ð� */
   movie_no NUMBER NOT NULL, /* ��ȭ ���й�ȣ */
   sc_no NUMBER(10) NOT NULL /* �󿵰���ȣ */
);

CREATE UNIQUE INDEX PK_r_time
   ON r_time (
      time_no ASC
   );

ALTER TABLE r_time
   ADD
      CONSTRAINT PK_r_time
      PRIMARY KEY (
         time_no
      );

/* �� */
CREATE TABLE member (
   m_no NUMBER(10) NOT NULL, /* ����ȣ */
   m_name VARCHAR2(20) NOT NULL, /* �̸� */
   m_bir DATE NOT NULL, /* ������� */
   m_hp VARCHAR2(20) NOT NULL, /* ��ȭ��ȣ */
   m_mileage NUMBER(10), /* ���ϸ��� */
   m_id VARCHAR2(15) NOT NULL, /* ���̵� */
   m_pass VARCHAR2(15) NOT NULL /* ��й�ȣ */
);

CREATE UNIQUE INDEX member
   ON member (
      m_no ASC
   );

ALTER TABLE member
   ADD
      CONSTRAINT member
      PRIMARY KEY (
         m_no
      );

/* �����¼� */
CREATE TABLE booking (
   t_no VARCHAR2(255) NOT NULL, /* Ƽ�Ϲ�ȣ */
   seat_no NUMBER(10) NOT NULL, /* �¼���ȣ */
   bk_cost NUMBER(10) NOT NULL /* �¼����� */
);

CREATE UNIQUE INDEX PK_booking
   ON booking (
      t_no ASC,
      seat_no ASC
   );

ALTER TABLE booking
   ADD
      CONSTRAINT PK_booking
      PRIMARY KEY (
         t_no,
         seat_no
      );

/* �帣 */
CREATE TABLE genre (
   genre_no NUMBER(3) NOT NULL, /* �帣��ȣ */
   genre_name VARCHAR2(10) /* �帣�̸� */
);

CREATE UNIQUE INDEX PK_genre
   ON genre (
      genre_no ASC
   );

ALTER TABLE genre
   ADD
      CONSTRAINT PK_genre
      PRIMARY KEY (
         genre_no
      );

ALTER TABLE reservation 
   ADD
      CONSTRAINT FK_payment_TO_reservation 
      FOREIGN KEY (
         pay_no
      )
      REFERENCES payment  (
         pay_no
      );

ALTER TABLE reservation 
   ADD
      CONSTRAINT FK_r_time_TO_reservation 
      FOREIGN KEY (
         time_no
      )
      REFERENCES r_time (
         time_no
      );

ALTER TABLE reservation 
   ADD
      CONSTRAINT FK_member_TO_reservation 
      FOREIGN KEY (
         m_no
      )
      REFERENCES member (
         m_no
      );

ALTER TABLE seat
   ADD
      CONSTRAINT FK_screen_TO_seat
      FOREIGN KEY (
         sc_no
      )
      REFERENCES screen (
         sc_no
      );

ALTER TABLE missing
   ADD
      CONSTRAINT FK_employees_TO_missing
      FOREIGN KEY (
         emp_no
      )
      REFERENCES employees (
         emp_no
      );

ALTER TABLE announcement
   ADD
      CONSTRAINT FK_employees_TO_announcement
      FOREIGN KEY (
         emp_no
      )
      REFERENCES employees (
         emp_no
      );

ALTER TABLE review
   ADD
      CONSTRAINT FK_movie_TO_review
      FOREIGN KEY (
         movie_no
      )
      REFERENCES movie (
         movie_no
      );

ALTER TABLE movie
   ADD
      CONSTRAINT FK_genre_TO_movie
      FOREIGN KEY (
         genre_no
      )
      REFERENCES genre (
         genre_no
      );

ALTER TABLE refund
   ADD
      CONSTRAINT FK_reservation_TO_refund
      FOREIGN KEY (
         t_no
      )
      REFERENCES reservation  (
         t_no
      );

ALTER TABLE r_time
   ADD
      CONSTRAINT FK_movie_TO_r_time
      FOREIGN KEY (
         movie_no
      )
      REFERENCES movie (
         movie_no
      );

ALTER TABLE r_time
   ADD
      CONSTRAINT FK_screen_TO_r_time
      FOREIGN KEY (
         sc_no
      )
      REFERENCES screen (
         sc_no
      );

ALTER TABLE booking
   ADD
      CONSTRAINT FK_reservation_TO_booking
      FOREIGN KEY (
         t_no
      )
      REFERENCES reservation  (
         t_no
      );

ALTER TABLE booking
   ADD
      CONSTRAINT FK_seat_TO_booking
      FOREIGN KEY (
         seat_no
      )
      REFERENCES seat (
         seat_no
      );
        
        