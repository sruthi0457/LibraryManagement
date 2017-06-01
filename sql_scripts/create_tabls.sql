-- This table is about the details of authors of books in the library

CREATE TABLE author 
  ( 
     authorid    INTEGER(255) COMMENT "id of the author",
     afirstname  VARCHAR(20) COMMENT "first name of the author",
     amiddlename VARCHAR(20) COMMENT "middle name of the author",
     alastname   VARCHAR(20) COMMENT "last name of the author",
     contact     INTEGER(255) COMMENT "phone number of the author",
     PRIMARY KEY(authorid)    COMMENT "primary key of the table is author id"
  ); 

-- This table gives list of all the books in library
  
CREATE TABLE books 
  ( 
     id         INTEGER(255) COMMENT "id of the book",
     title      VARCHAR(20) COMMENT "title of the book",
     copies     INTEGER(255) COMMENT "number of copies of each book", 
     bookstaken INTEGER(255) COMMENT "number of copies of each book taken by the students",
     PRIMARY KEY(id)         COMMENT "primary key of the table is book id"
  ); 
-- This table gives the details of the students in the college

CREATE TABLE student 
  ( 
     stid       INTEGER(255) COMMENT "id of a student",
     firstname  VARCHAR(20) COMMENT "first name of the student",
     middlename VARCHAR(20) COMMENT "middle name of the student",
     lastname   VARCHAR(20) COMMENT "last name of the student",
     contact    INTEGER(255) COMMENT "phone number of the student",
     mailid     VARCHAR(40) COMMENT "email address of the student",
     password   VARCHAR(40) COMMENT "password of the email of the student",
     department VARCHAR(20) COMMENT "department of the student",
     PRIMARY KEY(stid)      COMMENT "primary key of the table is student id"
  ); 

-- This table is about the books and their authors  

CREATE TABLE bookauthor 
  ( 
     book_id       INTEGER  COMMENT "id of the book which is primary key in table books",
     author_id INTEGER  COMMENT "id of the author which is primary key in table author", 
     FOREIGN KEY(book_id) REFERENCES books(id),
     FOREIGN KEY(author_id) REFERENCES author(authorid),
     PRIMARY KEY(book_id, author_id) COMMENT "composite primary key is book id and author id"
     
  ); 

-- This table is about the details of the books issued to the students
  
CREATE TABLE issued 
  ( 
     st_id        INTEGER(255)  COMMENT "id of the student which is primary key in table student",
     book_id          INTEGER(255) COMMENT "id of the book which is primary key in table books",
     issuedate   DATE COMMENT "date on which book is issued to the book",
     returndate  DATE COMMENT "date on which student should return the book",
     renewaldate DATE COMMENT "date of renewal of the book",
     FOREIGN KEY(st_id) REFERENCES student(stid),
     FOREIGN KEY(book_id) REFERENCES books(id),
     PRIMARY KEY(st_id, book_id) COMMENT "composite primary key is student id and book id" 
  ); 
  
-- This table gives the details of the staff in the library
  
CREATE TABLE staff 
  ( 
     staffid     INTEGER(255) COMMENT "id of the employee",
     sfirstname  VARCHAR(20) COMMENT "first name of the employee",
     smiddlename VARCHAR(20) COMMENT "middle name of the employee",
     slastname   VARCHAR(20) COMMENT "last name of the employee",
     userid      INTEGER(255) COMMENT "user id of the employee to log in",
     spassword   VARCHAR(40) COMMENT "password of the employee to log in",
     designation VARCHAR(20) COMMENT "designation of the employee",
     PRIMARY KEY(staffid)    COMMENT "primary key of the table is id of the staff"
  ); 

