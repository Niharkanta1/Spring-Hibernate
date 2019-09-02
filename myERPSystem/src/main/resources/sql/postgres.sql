CREATE TABLE Student(
   ID INT PRIMARY KEY NOT NULL,
   firstName TEXT NOT NULL,
   lastName TEXT,
   userId text not null,
   password text
);

INSERT INTO STUDENT VALUES (1,'admin','owner','admin','password');