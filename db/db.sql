--oracle  '||'&'||'  =>    &

DROP TABLE item ;
commit;
CREATE TABLE item (
id NUMBER(10) NOT NULL PRIMARY KEY,
auctionId NUMBER(10) NOT NULL ,
title NVARCHAR2(2000) NOT NULL ,
currentBid NUMBER(10) NULL ,
startDate dateTime NOT NULL ,
closeDate dateTime NOT NULL ,
estimatedValue NUMBER(10) NOT NULL ,
incrementPrice NUMBER(10) NULL ,
status NUMBER(1) NOT NULL ,
lotDetails NVARCHAR2(2000) NOT NULL ,
legalTerms NVARCHAR2(2000) NOT NULL ,
shipping NVARCHAR2(2000) NOT NULL ,
winningBidderId NUMBER(10) NULL ,
createdDate dateTime NOT NULL ,
updatedDate dateTime NOT NULL
)
;
commit;
COMMENT ON COLUMN item.id IS '商品id';
COMMENT ON COLUMN item.auctionId IS '拍賣會id';
COMMENT ON COLUMN item.title IS '商品訊息';
COMMENT ON COLUMN item.currentBid IS '當前標價';
COMMENT ON COLUMN item.startDate IS '商品 開始日期';
COMMENT ON COLUMN item.closeDate IS '商品結束日期';
COMMENT ON COLUMN item.estimatedValue IS '估計價值';
COMMENT ON COLUMN item.incrementPrice IS '下次最小標價';
COMMENT ON COLUMN item.status IS '0.結標 1.拍賣中';
COMMENT ON COLUMN item.lotDetails IS 'LOTDETAILS訊息';
COMMENT ON COLUMN item.legalTerms IS 'LEGALTERMS訊息';
COMMENT ON COLUMN item.shipping IS 'SHIPPING訊息';
COMMENT ON COLUMN item.winningBidderId IS '當前贏家id Bidder_ID';
COMMENT ON COLUMN item.createdDate IS '資料建立的時間';
COMMENT ON COLUMN item.updatedDate IS '最後修改時間';
drop sequence seq_item;
create sequence seq_item;
commit;
--seq_item.nextval
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);
insert into item values (seq_item.nextval,1,'商品訊息',1,sysdate,(sysdate + 10),10000,100,1,'lotdetails訊息','legalterms訊息','shipping訊息',1,sysdate,sysdate);

commit;

-------------------------------------


DROP TABLE category ;
commit;
CREATE TABLE category (
id NUMBER(10) NOT NULL PRIMARY KEY,
name NVARCHAR2(2000) NOT NULL 
)
;
commit;
COMMENT ON COLUMN category.id IS '第一級目錄id';
COMMENT ON COLUMN category.name IS '第一級目錄名稱';
commit;
drop sequence seq_category;
create sequence seq_category;
commit;

--seq_category.nextval
INSERT INTO category VALUES (seq_category.nextval, 'Celebrity');
INSERT INTO category VALUES (seq_category.nextval, 'Entertainm');
INSERT INTO category VALUES (seq_category.nextval, 'Music');
INSERT INTO category VALUES (seq_category.nextval, 'Travel');
INSERT INTO category VALUES (seq_category.nextval, 'Sports');
INSERT INTO category VALUES (seq_category.nextval, 'Fashion');
INSERT INTO category VALUES (seq_category.nextval, 'Business Experiences');
INSERT INTO category VALUES (seq_category.nextval, 'Art '||'&'||' Collectibles');
INSERT INTO category VALUES (seq_category.nextval, 'Food');
INSERT INTO category VALUES (seq_category.nextval, 'Wellness '||'&'||' Beauty');
commit;

-------------------------------------

DROP TABLE subcategory ;
commit;
CREATE TABLE subcategory (
id NUMBER(10) PRIMARY KEY NOT NULL,
categoryId NUMBER(10) NULL ,
name NVARCHAR2(2000) NOT NULL
)
;
commit;
COMMENT ON COLUMN subcategory.id IS '第二級目錄id';
COMMENT ON COLUMN subcategory.categoryId IS '第一級目錄id';
COMMENT ON COLUMN subcategory.name IS '第二級目錄名稱';
commit;
drop sequence seq_subcategory;
create sequence seq_subcategory;
commit;
--seq_subcategory.nextval
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '1', 'Meet '||'&'||' Gre');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '1', 'One-on-One');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '1', 'Set Visits');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '1', 'Awards Shows '||'&'||' Events ');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '1', 'Virtual Experiences ');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '2', 'Set Visits');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '2', 'Walk-Ons '||'&'||' Auditions');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '2', 'In the Audience');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '2', 'Premieres '||'&'||' Screenings');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '2', 'Broadway '||'&'||' Theatre');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '2', 'Awards Shows '||'&'||' Events');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '2', 'Children '||'&'||' Teens');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '2', 'Memorabilia');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '3', 'Concerts '||'&'||' Events');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '3', 'Meet the Artist');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '3', 'Guitars '||'&'||' Instruments');
INSERT INTO subcategory VALUES (seq_subcategory.nextval, '3', 'Memorabilia');
commit;


-------------------------------------
DROP TABLE subcategory_item ;
commit;
CREATE TABLE subcategory_item (
id NUMBER(10) NOT NULL PRIMARY KEY,
itemId NUMBER(10) NOT NULL ,
subCategoryId NUMBER(10) NOT NULL 
)
;
commit;
COMMENT ON COLUMN subcategory_item.id IS '中間表id';
COMMENT ON COLUMN subcategory_item.itemId IS '商品id';
COMMENT ON COLUMN subcategory_item.subCategoryId IS '第二級目錄id';
commit;
drop sequence seq_subcategory_item;
create sequence seq_subcategory_item;
commit;
--seq_subcategory_item.nextval

INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '1', '1');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '2', '2');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '3', '1');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '4', '1');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '5', '1');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '6', '1');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '7', '1');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '8', '1');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '9', '1');
INSERT INTO subcategory_item VALUES (seq_subcategory_item.nextval, '10', '1');
commit;

-------------------------------------
DROP TABLE picture ;
commit;
CREATE TABLE picture (
id NUMBER(10)  NOT NULL PRIMARY KEY,
itemId NUMBER(10)  NOT NULL ,
priority NUMBER(10)  NOT NULL ,
photoPath NVARCHAR2(200) NOT NULL ,
createdDate dateTime NOT NULL 
)
;
commit;
COMMENT ON COLUMN picture.id IS '圖片id，自動編號';
COMMENT ON COLUMN picture.itemId IS '商品id';
COMMENT ON COLUMN picture.priority IS '圖片顯示的優先權';
COMMENT ON COLUMN picture.photoPath IS '圖片路徑';
COMMENT ON COLUMN picture.createdDate IS '建立時間';
commit;
drop sequence seq_picture;
create sequence seq_picture;
commit;

-------------------------------------

DROP TABLE bidlog ;
commit;
CREATE TABLE bidlog (
id NUMBER(10) PRIMARY KEY NOT NULL,
bidderId NUMBER(10) NOT NULL ,
itemId NUMBER(10) NOT NULL ,
price NUMBER(10) NOT NULL ,
bidtime dateTime NOT NULL 
)
;
COMMENT ON COLUMN bidlog.id IS 'bid歷史紀錄id';
COMMENT ON COLUMN bidlog.bidderId IS '競標者id';
COMMENT ON COLUMN bidlog.itemId IS '商品id';
COMMENT ON COLUMN bidlog.price IS '價格';
COMMENT ON COLUMN bidlog.bidtime IS '競價時間';
commit;
drop sequence seq_bidlog;
create sequence seq_bidlog;
commit;
--seq_bidlog.nextval

INSERT INTO bidlog VALUES (seq_bidlog.nextval, '3', '6', '111', sysdate);
INSERT INTO bidlog VALUES (seq_bidlog.nextval, '3', '6', '200', sysdate);
INSERT INTO bidlog VALUES (seq_bidlog.nextval, '3', '1', '150', sysdate);
INSERT INTO bidlog VALUES (seq_bidlog.nextval, '3', '1', '205', sysdate);
commit;



-------------------------------------

DROP TABLE bidder ;
commit;
CREATE TABLE bidder (
id NUMBER(10) NOT NULL PRIMARY KEY,
firstName NVARCHAR2(20) NULL ,
lastName NVARCHAR2(20) NULL ,
screenName NVARCHAR2(20) NOT NULL ,
passWord NVARCHAR2(20) NOT NULL ,
email NVARCHAR2(20) NOT NULL ,
promoCode NVARCHAR2(20) NULL 
)
;
commit;
COMMENT ON COLUMN bidder.id IS '投標者id';
COMMENT ON COLUMN bidder.firstName IS 'firstName';
COMMENT ON COLUMN bidder.lastName IS 'lastName';
COMMENT ON COLUMN bidder.screenName IS 'screenName';
COMMENT ON COLUMN bidder.passWord IS 'passWord';
COMMENT ON COLUMN bidder.email IS 'email';
COMMENT ON COLUMN bidder.promoCode IS 'promoCode';

commit;
drop sequence seq_bidder;
create sequence seq_bidder;
commit;


INSERT INTO bidder VALUES (seq_bidder.nextval, 'lin', 'tommy', 'yudady', '123456', '111', '123456');
INSERT INTO bidder VALUES (seq_bidder.nextval, 'lin', 'kevin', 'kevin', '123456', '111', '123456');
INSERT INTO bidder VALUES (seq_bidder.nextval, 'lin', 'tommy', 'yudady', '111', '111', '111');
commit;

-------------------------------------
DROP TABLE operator ;
commit;
CREATE TABLE operator (
id NUMBER(10) NOT NULL PRIMARY KEY,
name NVARCHAR2(2000) NOT NULL,
passWord NVARCHAR2(2000) NOT NULL
)
;
COMMENT ON COLUMN operator.id IS '後台管理者帳號id, 拍賣商家ID';
COMMENT ON COLUMN operator.name IS '公司名稱';
COMMENT ON COLUMN operator.passWord IS '密碼';

commit;
drop sequence seq_operator;
create sequence seq_operator;
commit;
commit;

INSERT INTO operator VALUES (seq_operator.nextval, '123', '123');
--seq_operator.nextval
----------------------------------------------------------------
DROP TABLE watching ;
CREATE TABLE watching (
id NUMBER(10) NOT NULL PRIMARY KEY,
bidderId NUMBER(10) NOT NULL ,
itemId NUMBER(10) NOT NULL 
)
;
COMMENT ON COLUMN watching.id IS '關注id';
COMMENT ON COLUMN watching.bidderId IS '投標者id';
COMMENT ON COLUMN watching.itemId IS '商品Id';

commit;
drop sequence seq_watching;
create sequence seq_watching;
commit;
--Seq_watching.NEXTVAL

commit;





----------------------------------------------------------------
DROP TABLE auction ;
CREATE TABLE auction (
id NUMBER(10) NOT NULL PRIMARY KEY,
title NVARCHAR2(2000) NOT NULL ,
brief NVARCHAR2(2000) NOT NULL ,
webSite NVARCHAR2(2000) NOT NULL ,
auctionLogoPath NVARCHAR2(2000) NOT NULL ,
startDate DATETIME NOT NULL ,
closeDate DATETIME NOT NULL
)
;
COMMENT ON COLUMN auction.id IS '拍賣會id';
COMMENT ON COLUMN auction.title IS '主題';
COMMENT ON COLUMN auction.brief IS '描述';
COMMENT ON COLUMN auction.webSite IS '網址';
COMMENT ON COLUMN auction.auctionLogoPath IS 'logo';
COMMENT ON COLUMN auction.startDate IS '拍賣會 開始日期';
COMMENT ON COLUMN auction.closeDate IS '拍賣會 結束日期';

commit;
drop sequence seq_auction;
create sequence seq_auction;
commit;
--seq_auction.NEXTVAL
INSERT INTO auction VALUES (seq_auction.nextval,'1','1','1','1',sysdate, sysdate);
commit;






