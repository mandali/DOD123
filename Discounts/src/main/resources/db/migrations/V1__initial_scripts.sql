
create table dod_db.promotions
(
 PRMS_ID INT(11),
 Merchant_ID varchar(255),
 P_ID varchar(255),
 PRMS_DESC varchar(255) ,
 product_image varchar(255),
 original_price varchar(255) ,
 location varchar(255),
 DISCOUNT varchar(255) ,
 CRETATED_DATE DATE ,
 START_DATE DATE  ,
 END_DATE DATE   ,
 CAT_ID int(11),
 BRD_ID int(11),
 FOREIGN KEY (BRD_ID) REFERENCES brand(BRD_ID),
 FOREIGN KEY (CAT_ID) REFERENCES category(CAT_ID));

create table dod_db.user_table
(
 USER_ID varchar(255),
 USER_TYPE varchar(255),
EMAIL_ID varchar(255),  	
PHONE_NO varchar(255),
PASSWORD varchar(255),
CRETATED_DATE DATE
);

create table dod_db.merchant_profile
(
 ID INT(11),
 logo varchar(255),
 first_name varchar(255),
last_name varchar(255),
email_id varchar(255),
mobile_number varchar(255),

business_name varchar(255),
business_off_addr varchar(255),
landline_no varchar(255),
city varchar(255),
state varchar(255),
country varchar(255),
street varchar(255),
town varchar(255),
zipcode varchar(255),
description varchar(255),
tags varchar(255),
nickname varchar(255),
password varchar(255),
confirmpassword varchar(255),
created_date DATE
);

create table dod_db.user_profile_table
(
 USER_ID varchar(255),
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

create table dod_db.beacons_table
(
 BEACONS_ID varchar(255),			
 LOCATION varchar(255),
LATTITUDE varchar(255),
LONGITUDE varchar(255),
CRETATED_DATE DATE
); 
 
 create table dod_db.category
(
CAT_ID int(11),
CAT_NAME  varchar(255) not null,
CAT_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (CAT_ID)
);


create table dod_db.consumer_profile
(
 id INT(11),
 email_id varchar(255),
phone_no varchar(255),
city varchar(255),
age varchar(255),
password varchar(255),		
confirmpassword varchar(255),
createddate DATE
);
create table dod_db.mar_becons_proms_table
(
 M_ID varchar(255),			
 PRMS_ID varchar(255),
BECONS_ID varchar(255),
CRETATED_DATE DATE
);

create table dod_db.mar_becons_table
(
 MAR_BECONS_ID varchar(255),			
 M_ID varchar(255),
BECONS_ID varchar(255),
ISACTIVE TINYINT(4),
LOCATION varchar(255),
CRETATED_DATE DATE
);

create table dod_db.mar_bus_table
(
 MAR_BECONS_ID varchar(255),			
 M_ID varchar(255),
BUS_NAME varchar(255),
LOCATION TINYINT(4),
LATTITUDE varchar(255),
LONGITUDE varchar(255),
DESCRIPTION varchar(255),
CRETATED_DATE DATE
);

create table dod_db.otp_table
(
 Id INT(11),			
 USER_ID varchar(255),
OTP_NO varchar(255),
EXP_DATE DATE,
CRETATED_DATE DATE
);

create table dod_db.product_catagory_table
(			
 P_ID varchar(255),
CATAGORY_ID varchar(255),
CRETATED_DATE DATE
);
create table dod_db.product_table
(			
 P_ID varchar(255),
 P_DESC varchar(255),
 P_IMAGE TINYBLOB,
IMAGE_LOC varchar(255),
CRETATED_DATE DATE
);

create table dod_db.country
(
CO_ID int(11), 
CO_NAME varchar(255) not null,
PRIMARY KEY (CO_ID),
CO_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table dod_db.cities
(
CT_ID int(11), 
CT_NAME varchar(255) not null,
CO_ID int(11),
PRIMARY KEY (CT_ID),
FOREIGN KEY (CO_ID) REFERENCES country(CO_ID),
CT_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


create table dod_db.location
(
LO_ID int(11), 
LO_NAME varchar(255) not null,
LO_LAT varchar(255),
LO_LONG varchar(255),
CO_ID int(11),
CT_ID int(11),
PRIMARY KEY (LO_ID),
FOREIGN KEY (CO_ID) REFERENCES country(CO_ID),
FOREIGN KEY (CT_ID) REFERENCES cities(CT_ID),
LO_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table brand(
BRD_ID int(11),
BRD_NAME VARCHAR(255),
BRD_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
BRD_RATING VARCHAR(255),
BRD_IMAGE VARCHAR(255),
BRD_DESC VARCHAR(255),
PRIMARY KEY (BRD_ID)
);

create table category_brand
(
BRD_ID int(11),
CAT_ID int(11),
PRIMARY KEY (BRD_ID,CAT_ID),
FOREIGN KEY (BRD_ID) REFERENCES brand(BRD_ID),
FOREIGN KEY (CAT_ID) REFERENCES category(CAT_ID)
);


