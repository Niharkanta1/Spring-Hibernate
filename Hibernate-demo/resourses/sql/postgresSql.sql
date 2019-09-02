DROP TABLE IF EXISTS student;

CREATE SEQUENCE student_seq;

CREATE TABLE student (
  id int NOT NULL DEFAULT NEXTVAL ('student_seq'),
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
)  ;

ALTER SEQUENCE student_seq RESTART WITH 1;


<!-- One-to-One mapping tables -->

CREATE SEQUENCE instructor_seq;

CREATE TABLE instructor (
  id int NOT NULL DEFAULT NEXTVAL ('instructor_seq'),
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  instructor_detail_id int DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_DETAIL FOREIGN KEY (instructor_detail_id) REFERENCES instructor_detail (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)  ;

ALTER SEQUENCE instructor_seq RESTART WITH 1000;

CREATE INDEX FK_DETAIL_idx ON instructor (instructor_detail_id);

CREATE SEQUENCE instructor_detail_seq;

CREATE TABLE instructor_detail (
  id int NOT NULL DEFAULT NEXTVAL ('instructor_detail_seq'),
  youtube_channel varchar(128) DEFAULT NULL,
  hobby varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
)  ;

ALTER SEQUENCE instructor_detail_seq RESTART WITH 1;

<!-- One-to-Many Mapping -->
CREATE SEQUENCE course_seq;

CREATE TABLE course (
  id int NOT NULL DEFAULT NEXTVAL ('course_seq'),
  title varchar(128) DEFAULT NULL,
  instructor_id int DEFAULT NULL, 
  PRIMARY KEY (id), 
  CONSTRAINT TITLE_UNIQUE UNIQUE  (title),  
  CONSTRAINT FK_INSTRUCTOR 
  FOREIGN KEY (instructor_id) 
  REFERENCES instructor (id)  
  ON DELETE NO ACTION ON UPDATE NO ACTION
)  ;

ALTER SEQUENCE course_seq RESTART WITH 200;

CREATE INDEX FK_INSTRUCTOR_idx ON course (instructor_id);

<!-- One-to-Many Unidirectional -->

CREATE SEQUENCE review_seq;

CREATE TABLE review (
  id int NOT NULL DEFAULT NEXTVAL ('review_seq'),
  comment varchar(256) DEFAULT NULL,
  course_id int DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_COURSE 
  FOREIGN KEY (course_id) 
  REFERENCES course (id) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
);

ALTER SEQUENCE review_seq RESTART WITH 1;

CREATE INDEX FK_COURSE_ID_idx ON review (course_id);

<!-- Many-to-Many Mapping -->
DROP TABLE IF EXISTS student;

CREATE SEQUENCE student_seq;

CREATE TABLE student (
  id int NOT NULL DEFAULT NEXTVAL ('student_seq'),
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

ALTER SEQUENCE student_seq RESTART WITH 1;

DROP TABLE IF EXISTS course_student;

CREATE TABLE course_student (
  course_id int NOT NULL,
  student_id int NOT NULL,
  PRIMARY KEY (course_id,student_id) ,
  CONSTRAINT FK_COURSE_05 FOREIGN KEY (course_id) 
  REFERENCES course (id) 
  ON DELETE NO ACTION ON UPDATE NO ACTION, 
  CONSTRAINT FK_STUDENT FOREIGN KEY (student_id) 
  REFERENCES student (id) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX FK_STUDENT_idx ON course_student (student_id);

