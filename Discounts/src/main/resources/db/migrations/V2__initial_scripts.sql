
ALTER TABLE promotions drop column location;

ALTER TABLE promotions  add column LO_ID int;

ALTER TABLE promotions
ADD CONSTRAINT fk_locations
FOREIGN KEY (LO_ID)
REFERENCES location(LO_ID)


alter table promotions drop column product_image;

alter table promotions drop column P_ID;

alter table promotions add column P_ID int;

alter table promotions drop column Merchant_ID;

alter table promotions add column Merchant_ID int;

ALTER TABLE promotions
ADD CONSTRAINT fk_merchant
FOREIGN KEY (Merchant_ID)
REFERENCES merchant_profile(ID)