create table dod_db.USER_TABLE
(
 USER_ID varchar(255),
 USER_TYPE varchar(255),
EMAIL_ID varchar(255),  	
PHONE_NO varchar(255),
PASSWORD varchar(255),
CRETATED_DATE DATE
);

create table dod_db.MARCHANT_TABLE
(
 M_ID varchar(255),			
 M_NAME varchar(255),
BUSINEES_NAME varchar(255),
PHONE_NO varchar(255),
EMAIL_ID varchar(255),
CRETATED_DATE DATE
);

create table dod_db.promotions
(

 PRMS_ID varchar(255),
 M_ID varchar(255),
P_ID varchar(255),
PRMS_DESC varchar(255), 		
ORGI_PRICE varchar(255),
OFFER_PRICE varchar(255),
DIS_PER varchar(255),
START_DATE DATE,
END_DATE DATE,
CRETATED_DATE DATE
);

create table dod_db.USER_PROFILE
(
 USER_ID INT(11),
 USER_TYPE varchar(255),
EMAIL_ID varchar(255),
PHONE_NO varchar(255),
NICKNAME varchar(255),
FIRST_NAME varchar(255),		
LAST_NAME varchar(255),
ADDRESS varchar(255),
CITY varchar(255),
DATE_BIRTH varchar(255),
AGE varchar(255),
ZIPCODE varchar(255),
CRETATED_DATE DATE
);