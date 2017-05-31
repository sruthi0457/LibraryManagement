CREATE TABLE author 
  ( 
     authorid    INTEGER(255), 
     afirstname  VARCHAR(20), 
     amiddlename VARCHAR(20), 
     alastname   VARCHAR(20), 
     contact     INTEGER(255), 
     PRIMARY KEY(authorid) 
  ); 

CREATE TABLE books 
  ( 
     id         INTEGER(255), 
     title      VARCHAR(20), 
     copies     INTEGER(255), 
     bookstaken INTEGER(255), 
     PRIMARY KEY(id) 
  ); 

CREATE TABLE student 
  ( 
     stid       INTEGER(255), 
     firstname  VARCHAR(20), 
     middlename VARCHAR(20), 
     lastname   VARCHAR(20), 
     contact    INTEGER(255), 
     mailid     VARCHAR(40), 
     password   VARCHAR(40), 
     department VARCHAR(20), 
     PRIMARY KEY(stid) 
  ); 
  
CREATE TABLE bookauthor 
  ( 
     id       INTEGER REFERENCES books(id), 
     authorid INTEGER REFERENCES author(authorid), 
     PRIMARY KEY(id, authorid) 
  ); 
  
CREATE TABLE issued 
  ( 
     stid        INTEGER(255) REFERENCES student(stid), 
     id          INTEGER(255) REFERENCES books(id), 
     issuedate   DATE, 
     returndate  DATE, 
     renewaldate DATE, 
     PRIMARY KEY(stid, id) 
  ); 
CREATE TABLE staff 
  ( 
     staffid     INTEGER(255), 
     sfirstname  VARCHAR(20), 
     smiddlename VARCHAR(20), 
     slastname   VARCHAR(20), 
     userid      INTEGER(255), 
     spassword   VARCHAR(40), 
     designation VARCHAR(20), 
     PRIMARY KEY(staffid) 
  ); 

