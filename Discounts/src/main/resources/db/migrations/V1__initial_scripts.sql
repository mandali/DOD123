create table dod_db.merchant_profile
(
ID int NOT NULL AUTO_INCREMENT,
logo varchar(255),
first_name varchar(255),
last_name varchar(255),
email_id varchar(255) NOT NULL,
mobile_number varchar(255) NOT NULL,
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
password varchar(255) NOT NULL,
confirmpassword varchar(255) NOT NULL,
created_date DATE,
PRIMARY KEY (ID),
UNIQUE (email_id),
UNIQUE(mobile_number)
);


create table dod_db.product
(			
 P_ID int NOT NULL AUTO_INCREMENT,
 P_DESC varchar(255),
 IMAGE_LOC varchar(255),
 CRETATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 M_ID int,
 PRIMARY KEY (P_ID),
 FOREIGN KEY (M_ID) REFERENCES merchant_profile(ID)
);


 
 create table dod_db.category
(
CAT_ID int NOT NULL AUTO_INCREMENT,
CAT_NAME  varchar(255) not null,
CAT_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
CAT_RANK smallint,
CAT_IMAGE varchar(255),
PRIMARY KEY (CAT_ID)
);


create table dod_db.consumer_profile
(
 id int NOT NULL AUTO_INCREMENT,
 email_id varchar(255),
phone_no varchar(255),
city varchar(255),
age varchar(255),
password varchar(255),		
confirmpassword varchar(255),
createddate DATE,
PRIMARY KEY (id),
UNIQUE (email_id),
UNIQUE(phone_no)
);




create table dod_db.otp_table
(
 Id int NOT NULL AUTO_INCREMENT,			
 USER_ID varchar(255),
OTP_NO varchar(255),
EXP_DATE DATE,
CRETATED_DATE DATE,
PRIMARY KEY (Id),
UNIQUE(USER_ID)
);


create table dod_db.country
(
CO_ID int NOT NULL AUTO_INCREMENT, 
CO_NAME varchar(255) not null,
PRIMARY KEY (CO_ID),
CO_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table dod_db.cities
(
CT_ID int NOT NULL AUTO_INCREMENT, 
CT_NAME varchar(255) not null,
CO_ID int,
PRIMARY KEY (CT_ID),
FOREIGN KEY (CO_ID) REFERENCES country(CO_ID),
CT_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


create table dod_db.location
(
LO_ID int NOT NULL AUTO_INCREMENT, 
LO_NAME varchar(255) not null,
LO_LAT varchar(255),
LO_LONG varchar(255),
CO_ID int,
CT_ID int,
PRIMARY KEY (LO_ID),
FOREIGN KEY (CO_ID) REFERENCES country(CO_ID),
FOREIGN KEY (CT_ID) REFERENCES cities(CT_ID),
LO_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table brand(
BRD_ID int NOT NULL AUTO_INCREMENT,
BRD_NAME VARCHAR(255),
BRD_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
BRD_RATING VARCHAR(255),
BRD_IMAGE VARCHAR(255),
BRD_DESC VARCHAR(255),
PRIMARY KEY (BRD_ID)
);

create table category_brand
(
BRD_ID int,
CAT_ID int,
PRIMARY KEY (BRD_ID,CAT_ID),
FOREIGN KEY (BRD_ID) REFERENCES brand(BRD_ID),
FOREIGN KEY (CAT_ID) REFERENCES category(CAT_ID)
);

create table dod_db.promotions
(
 PRMS_ID int NOT NULL AUTO_INCREMENT,
 PRMS_DESC varchar(255) ,
 original_price varchar(255) ,
 DISCOUNT varchar(255) ,
 CRETATED_DATE DATE ,
 START_DATE DATE  ,
 END_DATE DATE   ,
 CAT_ID int,
 BRD_ID int,
 P_ID int,
 Merchant_ID int,
 LO_ID int,
 PRIMARY KEY (PRMS_ID),
 FOREIGN KEY (BRD_ID) REFERENCES brand(BRD_ID),
 FOREIGN KEY (CAT_ID) REFERENCES category(CAT_ID),
 FOREIGN KEY (LO_ID) REFERENCES location(LO_ID),
 FOREIGN KEY (Merchant_ID) REFERENCES merchant_profile(ID),
 FOREIGN KEY (P_ID) REFERENCES product(P_ID),
 PRMS_DISC_TXT varchar(1000));


create table promotions_summary(
SUMMARY_ID int NOT NULL AUTO_INCREMENT,
CREATED_DATE timestamp, 
CAT_ID int(11), 
PRM_COUNT int, 
MIN_DISCOUNT int, 
MAX_DISCOUNT int, 
BRD_ID int(11),
FOREIGN KEY (CAT_ID) REFERENCES category(CAT_ID),
FOREIGN KEY (BRD_ID) REFERENCES brand(BRD_ID),
PRIMARY KEY (SUMMARY_ID));





create table beacon
(
B_ID int NOT NULL AUTO_INCREMENT,
B_NAME varchar(255),
B_STATUS varchar(255),
BRD_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
B_UID varchar(2000),
B_MAJ int,
B_MIN int,
primary key(B_ID)
);

create table merchant_beacon
(
BC_ID int NOT NULL AUTO_INCREMENT,
B_ID int,
M_ID int,
PRIMARY KEY (BC_ID),
FOREIGN KEY (B_ID) REFERENCES beacon(B_ID),
FOREIGN KEY (M_ID) REFERENCES merchant_profile(ID),
UNIQUE (B_ID,M_ID));

create table merchant_ailes
(
A_ID int NOT NULL AUTO_INCREMENT,
M_ID int,
A_NAME varchar(255),
A_X int,
A_Y int,
A_FLOOR int,
LO_ID int,
PRIMARY KEY (A_ID),
FOREIGN KEY (M_ID) REFERENCES merchant_profile(ID),
FOREIGN KEY(LO_ID) REFERENCES location(LO_ID),
UNIQUE (A_ID,M_ID,LO_ID));


create table merchant_pm_bc(
MPB_ID int NOT NULL AUTO_INCREMENT,
M_ID int,
P_ID int,
BC_ID int,
A_ID  int,
FOREIGN KEY (BC_ID) REFERENCES beacon(B_ID),
FOREIGN KEY (M_ID) REFERENCES merchant_profile(ID),
FOREIGN KEY (P_ID)  REFERENCES promotions(PRMS_ID),
FOREIGN KEY (A_ID)  REFERENCES merchant_ailes(A_ID),
PRIMARY KEY (MPB_ID),
UNIQUE (M_ID, P_ID, BC_ID)
);

