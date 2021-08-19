create table UserDetail(
 username varchar(255),
 firstname varchar(255),
 lastname varchar(255),
 email varchar(255),
 gender varchar(255),
 dateofbirth date,
 registrationnumber varchar(255),
 membershipstartingdate date,
 membershipendingdate date,
 contactnumber bigint,
 address varchar(255),
 isactive varchar(255) 
 
 );
 alter table UserDetail add password varchar(255);

 
 create table StaffDetail(
 employeeid varchar(255),
 firstname varchar(255),
 lastname varchar(255),
 email varchar(255),
 gender varchar(255),
 dateofbirth date,
 jobjoiningdate date,
 contactnumber bigint,
 address varchar(255),
 isactive varchar(255)
 );
alter table StaffDetail add password varchar(255);

 
 
 create table BookDetail(
 bookid varchar(255),
 bookname varchar(255),
 bookauthor varchar(255),
 bookpublication varchar(255),
 bookedition varchar(255)
 );
 alter table BookDetail add registrationnumber varchar(255);
 
 create table BookInventory(
 bookid varchar(255),
 bookname varchar(255),
 bookauthor varchar(255),
 bookpublication varchar(255),
 bookedition varchar(255),
 bookavailability boolean,
 bookcount int
 );
 
INSERT INTO bookinventory (bookid, bookname, bookauthor,bookpublication,bookedition,bookcount)
VALUES ('ab', 'abcde', 'abcd','a','abcdef',1);

 select * from UserDetail;
 select * from StaffDetail;
 select * from BookDetail;
 select * from BookInventory;
 
 drop table UserDetail;
 drop table StaffDetail;
 drop table bookdetail;
 drop table bookinventory;
 
 truncate table StaffDetail;
 desc  UserDetail;
 
 
