/* 티켓 */
CREATE TABLE reservation  (
   t_no VARCHAR2(255) NOT NULL, /* 티켓번호 */
   time_no NUMBER(5) NOT NULL, /* 상영정보 */
   m_no NUMBER(10) NOT NULL, /* 고객번호 */
   pay_no VARCHAR2(255) NOT NULL, /* 결제번호 */
   use_mileage NUMBER(10), /* 사용마일리지 */
   total_cost NUMBER(10) NOT NULL, /* 결제가격 */
   t_day DATE NOT NULL /* 발행일 */
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

/* 좌석 */
CREATE TABLE seat (
   seat_no NUMBER(10) NOT NULL, /* 좌석번호 */
   seat_charge NUMBER(10) NOT NULL, /* 좌석 요금 */
   sc_no NUMBER(10) NOT NULL /* 상영관번호 */
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

/* 유실물 */
CREATE TABLE missing (
   mi_no VARCHAR2(255) NOT NULL, /* 게시물 번호 */
   mi_title VARCHAR2(255) NOT NULL, /* 유실물 이름 */
   mi_content VARCHAR2(5) NOT NULL, /* 유실물 상태 */
   mi_start DATE NOT NULL, /* 보관시작일 */
   mi_end DATE NOT NULL, /* 보관종료일 */
   emp_no NUMBER NOT NULL, /* 직원번호 */
   mi_owner VARCHAR2(10) NOT NULL /* 수령인 */
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

/* 결제 */
CREATE TABLE payment  (
   pay_no VARCHAR2(255) NOT NULL, /* 결제번호 */
   pay_wqy VARCHAR2(200) NOT NULL /* 결제방법 */
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

/* 공지사항 */
CREATE TABLE announcement (
   an_no VARCHAR2(255) NOT NULL, /* 공지글 번호 */
   an_title VARCHAR2(255) NOT NULL, /* 제목 */
   an_content CLOB NOT NULL, /* 내용 */
   an_user VARCHAR2(200) NOT NULL, /* 작성자 */
   an_date DATE NOT NULL, /* 작성일자 */
   emp_no NUMBER NOT NULL /* 직원번호 */
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

/* 게시판 */
CREATE TABLE BOARD (
   board_no VARCHAR2(255) NOT NULL, /* 게시글번호 */
   board_title VARCHAR2(255) NOT NULL, /* 제목 */
   board_content CLOB NOT NULL, /* 내용 */
   board_date DATE NOT NULL, /* 작성일자 */
   board_user VARCHAR2(200) NOT NULL /* 작성자 */
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

/* 리뷰 */
CREATE TABLE review (
   review_no VARCHAR2(255) NOT NULL, /* 리뷰번호 */
   review_content CLOB, /* 내용 */
   review_date DATE, /* 작성일자 */
   review_user VARCHAR2(200), /* 작성자 */
   movie_no NUMBER /* 영화 구분번호 */
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

/* 영화 */
CREATE TABLE movie (
   movie_no NUMBER NOT NULL, /* 영화 구분번호 */
   movie_name VARCHAR2(200), /* 영화제목 */
   movie_time DATE, /* 러닝타임 */
   movie_term DATE, /* 상영기간 */
   movie_summary VARCHAR2(200), /* 줄거리 */
   movie_pd VARCHAR2(20), /* 감독 */
   movie_acter VARCHAR2(50), /* 출연진 */
   genre_no NUMBER(3) /* 장르번호 */
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

/* 환불 */
CREATE TABLE refund (
   refund_number NUMBER NOT NULL, /* 환불번호 */
   t_no VARCHAR2(255) NOT NULL, /* 티켓번호 */
   refund_price NUMBER NOT NULL, /* 환불가격 */
   refund_date DATE NOT NULL /* 환불일자 */
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

/* 상영관 */
CREATE TABLE screen (
   sc_no NUMBER(10) NOT NULL, /* 상영관번호 */
   sc_name VARCHAR2(20) NOT NULL, /* 상영관이름 */
   seat_all NUMBER(10) NOT NULL /* 총좌석 */
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

/* 티켓가격 */
CREATE TABLE t_PRICE (
   p_no NUMBER(10) NOT NULL, /* 가격번호 */
   p_name VARCHAR2(10) NOT NULL, /* 가격이름 */
   p_cost NUMBER(10) NOT NULL /* 가격 */
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

/* 관리자 */
CREATE TABLE employees (
   emp_no NUMBER NOT NULL, /* 직원번호 */
   emp_name VARCHAR2(20) NOT NULL, /* 이름 */
   emp_hp VARCHAR2(20) NOT NULL, /* 연락처 */
   emp_salary NUMBER NOT NULL, /* 급여 */
   emp_position VARCHAR2(30) NOT NULL, /* 직책 */
   emp_id VARCHAR2(20) NOT NULL, /* 아이디 */
   emp_pass VARCHAR2(20) NOT NULL /* 비밀번호 */
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

/* 상영시간 */
CREATE TABLE r_time (
   time_no NUMBER(5) NOT NULL, /* 상영정보 */
   time_start DATE NOT NULL, /* 시작시간 */
   time_end DATE NOT NULL, /* 종료시간 */
   movie_no NUMBER NOT NULL, /* 영화 구분번호 */
   sc_no NUMBER(10) NOT NULL /* 상영관번호 */
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

/* 고객 */
CREATE TABLE member (
   m_no NUMBER(10) NOT NULL, /* 고객번호 */
   m_name VARCHAR2(20) NOT NULL, /* 이름 */
   m_bir DATE NOT NULL, /* 생년월일 */
   m_hp VARCHAR2(20) NOT NULL, /* 전화번호 */
   m_mileage NUMBER(10), /* 마일리지 */
   m_id VARCHAR2(15) NOT NULL, /* 아이디 */
   m_pass VARCHAR2(15) NOT NULL /* 비밀번호 */
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

/* 예약좌석 */
CREATE TABLE booking (
   t_no VARCHAR2(255) NOT NULL, /* 티켓번호 */
   seat_no NUMBER(10) NOT NULL, /* 좌석번호 */
   bk_cost NUMBER(10) NOT NULL /* 좌석가격 */
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

/* 장르 */
CREATE TABLE genre (
   genre_no NUMBER(3) NOT NULL, /* 장르번호 */
   genre_name VARCHAR2(10) /* 장르이름 */
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
        
        