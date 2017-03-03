-- DDL INICIAL -- DDL v0.1
-- CREATE TABLES E PRIMARY KEYS -- 
CREATE TABLE TB_CITY
  (
    IDCITY  NUMERIC NOT NULL ,
    IDSTATE NUMERIC NOT NULL ,
    UF      CHARACTER VARYING (4) ,
    NAME    CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_CITY ADD CONSTRAINT TB_CITY_PK PRIMARY KEY ( IDCITY ) ;


CREATE TABLE TB_CUSTOMER
  (
    IDCUSTOMER   NUMERIC NOT NULL ,
    IDUSERSELLER NUMERIC NOT NULL ,
    IDCITY       NUMERIC NOT NULL ,
    FIRSTNAME    CHARACTER VARYING (50) ,
    LASTNAME     CHARACTER VARYING (50) ,
    EMAIL        CHARACTER VARYING (50) ,
    ACTIVE       boolean ,
    NEIGHBORHOOD CHARACTER VARYING (150) ,
    ANUMERIC      CHARACTER VARYING (10) ,
    INSERTDATE   DATE
  ) ;
ALTER TABLE TB_CUSTOMER ADD CONSTRAINT TB_CUSTOMER_PK PRIMARY KEY ( IDCUSTOMER ) ;


CREATE TABLE TB_CUSTOMER_HISTORY
  (
    IDCUSTOMERHISTORY NUMERIC NOT NULL ,
    IDCUSTOMER        NUMERIC NOT NULL ,
    IDCITY            NUMERIC NOT NULL ,
    IDOPERATION       NUMERIC NOT NULL ,
    FIRSTNAME         CHARACTER VARYING (50) ,
    LASTNAME          CHARACTER VARYING (50) ,
    EMAIL             CHARACTER VARYING (50) ,
    ACTIVE            boolean ,
    NEIGHBORHOOD      CHARACTER VARYING (150) ,
    ANUMERIC           CHARACTER VARYING (10) ,
    DDD_PHONE         CHARACTER VARYING (2) ,
    PHONE_NUMERIC      CHARACTER VARYING (10) ,
    DDD_CELLPHONE     CHARACTER VARYING (2) ,
    CELLPHONENUMERIC   CHARACTER VARYING (10) ,
    INSERTDATE        DATE
  ) ;
ALTER TABLE TB_CUSTOMER_HISTORY ADD CONSTRAINT TB_CUSTOMER_HISTORY_PK PRIMARY KEY ( IDCUSTOMERHISTORY ) ;


CREATE TABLE TB_CUSTOMER_OPERATION
  (
    IDOPERATION NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (20)
  ) ;
ALTER TABLE TB_CUSTOMER_OPERATION ADD CONSTRAINT TB_EMPLOYEE_OPERATION_PKv3 PRIMARY KEY ( IDOPERATION ) ;


CREATE TABLE TB_EMPLOYEE
  (
    IDEMPLOYEE     NUMERIC NOT NULL ,
    IDCITY         NUMERIC NOT NULL ,
    FIRSTNAME      CHARACTER VARYING (50) ,
    LASTNAME       CHARACTER VARYING (50) ,
    EMAIL          CHARACTER VARYING (50) ,
    ACTIVE         boolean ,
    NEIGHBORHOOD   CHARACTER VARYING (150) ,
    ANUMERIC        CHARACTER VARYING (10) ,
    INSERTDATE     DATE ,
    WORKCARDNUMERIC CHARACTER VARYING (6) ,
    WORKCARDSERIES CHARACTER VARYING (8) ,
    EMPLOYMENTDATE DATE ,
	RESIGNATIONDATE DATE ,
    SALARY         NUMERIC
  ) ;
ALTER TABLE TB_EMPLOYEE ADD CONSTRAINT TB_EMPLOYEE_PK PRIMARY KEY ( IDEMPLOYEE ) ;


CREATE TABLE TB_EMPLOYEE_HISTORY
  (
    IDEMPLOYEEHISTORY NUMERIC NOT NULL ,
    IDEMPLOYEE        NUMERIC NOT NULL ,
    IDCITY            NUMERIC NOT NULL ,
    IDOPERATION       NUMERIC NOT NULL ,
    FIRSTNAME         CHARACTER VARYING (50) ,
    LASTNAME          CHARACTER VARYING (50) ,
    EMAIL             CHARACTER VARYING (50) ,
    ACTIVE            boolean ,
    NEIGHBORHOOD      CHARACTER VARYING (150) ,
    ANUMERIC           CHARACTER VARYING (10) ,
    INSERTDATE        DATE ,
    DDD_PHONE         CHARACTER VARYING (2) ,
    PHONE_NUMERIC      CHARACTER VARYING (10) ,
    DDD_CELLPHONE     CHARACTER VARYING (2) ,
    CELLPHONENUMERIC   CHARACTER VARYING (10) ,
    WORKCARDNUMERIC    CHARACTER VARYING (6) ,
    WORKCARDSERIES    CHARACTER VARYING (8) ,
    EMPLOYMENTDATE    DATE ,
    SALARY            NUMERIC
  ) ;
ALTER TABLE TB_EMPLOYEE_HISTORY ADD CONSTRAINT TB_EMPLOYEE_HISTORY_PK PRIMARY KEY ( IDEMPLOYEEHISTORY ) ;


CREATE TABLE TB_EMPLOYEE_OPERATION
  (
    IDOPERATION NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_EMPLOYEE_OPERATION ADD CONSTRAINT TB_OPERATION_TYPE_PK PRIMARY KEY ( IDOPERATION ) ;


CREATE TABLE TB_EXPENSE
  (
    IDEXPENSE          NUMERIC NOT NULL ,
    IDFORNECEDOR       NUMERIC NOT NULL ,
    IDEXPENSEITEM      NUMERIC NOT NULL ,
    IDEXPENSETYPE      NUMERIC NOT NULL ,
    IDEXPENSESTATUS    NUMERIC NOT NULL ,
    DESCRIPTION        CHARACTER VARYING (250) ,
    AMOUNT             NUMERIC ,
    UNITVALUE          NUMERIC ,
    SERVICEVALUE       NUMERIC ,
    SERVICEDESCRIPTION CHARACTER VARYING (500) ,
    EXPENSEDATE        DATE ,
    INSERTDATE         DATE
  ) ;
ALTER TABLE TB_EXPENSE ADD CONSTRAINT TB_EXPENSE_PK PRIMARY KEY ( IDEXPENSE ) ;


CREATE TABLE TB_EXPENSE_HISTORY
  (
    IDEXPENSEHISTORY   NUMERIC NOT NULL ,
    IDEXPENSE          NUMERIC NOT NULL ,
    IDOPERATION        NUMERIC NOT NULL ,
    IDPROVIDER         NUMERIC NOT NULL ,
    IDEXPENSEITEM      NUMERIC NOT NULL ,
    IDEXPENSETYPE      NUMERIC NOT NULL ,
    IDEXPENSESTATUS    NUMERIC NOT NULL ,
    DESCRIPTION        CHARACTER VARYING (250) ,
    AMOUNT             NUMERIC ,
    UNITVALUE          NUMERIC ,
    SERVICEVALUE       NUMERIC ,
    SERVICEDESCRIPTION CHARACTER VARYING (500) ,
    EXPENSEDATE        DATE ,
    DDD_PHONE          CHARACTER VARYING (2) ,
    PHONE_NUMERIC       CHARACTER VARYING (10) ,
    DDD_CELLPHONE      CHARACTER VARYING (2) ,
    CELLPHONENUMERIC    CHARACTER VARYING (10) ,
    INSERTDATE         DATE
  ) ;
ALTER TABLE TB_EXPENSE_HISTORY ADD CONSTRAINT TB_EXPENSE_HISTORY_PK PRIMARY KEY ( IDEXPENSEHISTORY ) ;


CREATE TABLE TB_EXPENSE_ITEM
  (
    IDEXPENSEITEM NUMERIC NOT NULL ,
    CODE          CHARACTER VARYING (4) ,
    DESCRIPTION   CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_EXPENSE_ITEM ADD CONSTRAINT TB_EXPENSE_ITEM_PK PRIMARY KEY ( IDEXPENSEITEM ) ;


CREATE TABLE TB_EXPENSE_OPERATION
  (
    IDOPERATION NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_EXPENSE_OPERATION ADD CONSTRAINT TB_OPERATION_PROVIDER_PK PRIMARY KEY ( IDOPERATION ) ;


CREATE TABLE TB_EXPENSE_PAYMENT
  (
    IDEXPENSEPAYMENT NUMERIC NOT NULL ,
    IDEXPENSE        NUMERIC NOT NULL ,
    VALUE            NUMERIC ,
    PAYMENTDATE      DATE ,
    INSERTDATE       DATE
  ) ;
ALTER TABLE TB_EXPENSE_PAYMENT ADD CONSTRAINT TB_EXPENSE_PAYMENT_PK PRIMARY KEY ( IDEXPENSEPAYMENT ) ;

CREATE TABLE TB_EXPENSE_STATUS
  (
    IDEXPENSESTATUS NUMERIC NOT NULL ,
    CODE            CHARACTER VARYING (4) ,
    DESCRIPTION     CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_EXPENSE_STATUS ADD CONSTRAINT TB_EXPENSE_STATUS_PK PRIMARY KEY ( IDEXPENSESTATUS ) ;


CREATE TABLE TB_EXPENSE_TYPE
  (
    IDEXPENSETYPE NUMERIC NOT NULL ,
    CODE          CHARACTER VARYING (4) ,
    DESCRIPTION   CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_EXPENSE_TYPE ADD CONSTRAINT TB_EXPENSE_TYPE_PK PRIMARY KEY ( IDEXPENSETYPE ) ;


CREATE TABLE TB_ORDER
  (
    IDORDER     NUMERIC NOT NULL ,
    IDCUSTOMER  NUMERIC NOT NULL ,
	IDORDERSTATUS NUMERIC NOT NULL ,
    DELIVERDATE DATE ,
	ACTIVE      boolean,	
    TOTALVALUE  NUMERIC
  ) ;
ALTER TABLE TB_ORDER ADD CONSTRAINT TB_ORDER_PK PRIMARY KEY ( IDORDER ) ;


CREATE TABLE TB_ORDER_HISTORY
  (
    IDORDERHISTORY NUMERIC NOT NULL ,
    IDORDERITEM    NUMERIC NOT NULL ,
    IDOPERATION    NUMERIC NOT NULL ,
    AMOUNT         NUMERIC ,
    UNITVALUE      NUMERIC ,
    INSERTDATE     DATE
  ) ;
ALTER TABLE TB_ORDER_HISTORY ADD CONSTRAINT TB_ORDER_HISTORY_PK PRIMARY KEY ( IDORDERHISTORY ) ;


CREATE TABLE TB_ORDER_ITEM
  (
    IDORDERITEM NUMERIC NOT NULL ,
    IDORDER     NUMERIC NOT NULL ,
    IDPRODUCT   NUMERIC NOT NULL ,
    AMOUNT      NUMERIC ,
    UNITVALUE   NUMERIC ,
    INSERTDATE  DATE ,
    ACTIVE      boolean
  ) ;
ALTER TABLE TB_ORDER_ITEM ADD CONSTRAINT TB_ORDER_ITEM_PK PRIMARY KEY ( IDORDERITEM ) ;


CREATE TABLE TB_ORDER_OPERATION
  (
    IDOPERATION NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_ORDER_OPERATION ADD CONSTRAINT TB_ORDER_OPERATION_PK PRIMARY KEY ( IDOPERATION ) ;


CREATE TABLE TB_ORDER_PAYMENT
  (
    IDORDERPAYMENT  NUMERIC NOT NULL ,
    IDORDER         NUMERIC NOT NULL ,
    VALUE           NUMERIC ,
    PAYMENTDATE     DATE ,
    INSERTDATE      DATE
  ) ;
ALTER TABLE TB_ORDER_PAYMENT ADD CONSTRAINT TB_ORDER_PAYMENT_PK PRIMARY KEY ( IDORDERPAYMENT ) ;


CREATE TABLE TB_ORDER_STATUS
  (
    IDORDERSTATUS NUMERIC NOT NULL ,
    CODE            CHARACTER VARYING (4) ,
    DESCRIPTION     CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_ORDER_STATUS ADD CONSTRAINT TB_ORDER_STATUS_PK PRIMARY KEY ( IDORDERSTATUS ) ;


CREATE TABLE TB_PHONE
  (
    IDPHONE     NUMERIC NOT NULL ,
    IDCUSTOMER  NUMERIC NOT NULL ,
    IDEMPLOYEE  NUMERIC NOT NULL ,
    IDPROVIDER  NUMERIC NOT NULL ,
    IDUSER      NUMERIC NOT NULL ,
    DDD         CHARACTER VARYING (2) ,
    PNUMERIC     CHARACTER VARYING (10) ,
    IDPHONETYPE NUMERIC NOT NULL
  ) ;
ALTER TABLE TB_PHONE ADD CONSTRAINT TB_PHONE_PK PRIMARY KEY ( IDPHONE ) ;


CREATE TABLE TB_PHONE_TYPE
  (
    IDPHONETYPE NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_PHONE_TYPE ADD CONSTRAINT TB_PHONE_TYPE_PK PRIMARY KEY ( IDPHONETYPE ) ;


CREATE TABLE TB_PRODUCT
  (
    IDPRODUCT        NUMERIC NOT NULL ,
    IDSALETYPE       NUMERIC NOT NULL ,
    IDSTOCKTYPE      NUMERIC NOT NULL ,
    IDPRODUCTIONTYPE NUMERIC NOT NULL ,
    CODE             CHARACTER VARYING (4) ,
    DESCRIPTION      CHARACTER VARYING (50) ,
    AMOUNT           NUMERIC ,
    PHOTO            CHARACTER VARYING (250) ,
    INSERTDATE       DATE
  ) ;
ALTER TABLE TB_PRODUCT ADD CONSTRAINT TB_PRODUCT_PK PRIMARY KEY ( IDPRODUCT ) ;


CREATE TABLE TB_PRODUCTION_TYPE
  (
    IDPRODUCTIONTYPE NUMERIC NOT NULL ,
    CODE             CHARACTER VARYING (4) ,
    DESCRIPTION      CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_PRODUCTION_TYPE ADD CONSTRAINT TB_PRODUCTION_TYPE_PK PRIMARY KEY ( IDPRODUCTIONTYPE ) ;


CREATE TABLE TB_PRODUCT_HISTORY
  (
    IDPRODUCTHISTORY NUMERIC NOT NULL ,
    IDPRODUCT        NUMERIC NOT NULL ,
    IDOPERATION      NUMERIC NOT NULL ,
    IDSALETYPE       NUMERIC NOT NULL ,
    IDSTOCKTYPE      NUMERIC NOT NULL ,
    IDPRODUCTIONTYPE NUMERIC NOT NULL ,
    DESCRIPTION      CHARACTER VARYING (50) ,
    AMOUNT           NUMERIC ,
    PHOTO            CHARACTER VARYING (250) ,
    INSERTDATE       DATE
  ) ;
ALTER TABLE TB_PRODUCT_HISTORY ADD CONSTRAINT TB_PRODUCT_HISTORY_PK PRIMARY KEY ( IDPRODUCTHISTORY ) ;


CREATE TABLE TB_PRODUCT_OPERATION
  (
    IDOPERATION NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_PRODUCT_OPERATION ADD CONSTRAINT TB_EMPLOYEE_OPERATION_PK PRIMARY KEY ( IDOPERATION ) ;


CREATE TABLE TB_PROVIDER
  (
    IDPROVIDER   NUMERIC NOT NULL ,
    IDCITY       NUMERIC NOT NULL ,
    FIRSTNAME    CHARACTER VARYING (50) ,
    LASTNAME     CHARACTER VARYING (50) ,
    EMAIL        CHARACTER VARYING (50) ,
    ACTIVE       boolean ,
    NEIGHBORHOOD CHARACTER VARYING (150) ,
    ANUMERIC      CHARACTER VARYING (10) ,
    INSERTDATE   DATE
  ) ;
ALTER TABLE TB_PROVIDER ADD CONSTRAINT TB_EMPLOYEE_PKv2 PRIMARY KEY ( IDPROVIDER ) ;


CREATE TABLE TB_PROVIDER_HISTORY
  (
    IDPROVIDERHISTORY NUMERIC NOT NULL ,
    IDPROVIDER        NUMERIC NOT NULL ,
    IDCITY            NUMERIC NOT NULL ,
    IDOPERATION       NUMERIC NOT NULL ,
    FIRSTNAME         CHARACTER VARYING (50) ,
    LASTNAME          CHARACTER VARYING (50) ,
    EMAIL             CHARACTER VARYING (50) ,
    ACTIVE            boolean ,
    NEIGHBORHOOD      CHARACTER VARYING (150) ,
    ANUMERIC           CHARACTER VARYING (10) ,
    DDD_PHONE         CHARACTER VARYING (2) ,
    PHONE_NUMERIC      CHARACTER VARYING (10) ,
    DDD_CELLPHONE     CHARACTER VARYING (2) ,
    CELLPHONENUMERIC   CHARACTER VARYING (10) ,
    INSERTDATE        DATE
  ) ;
ALTER TABLE TB_PROVIDER_HISTORY ADD CONSTRAINT TB_EMPLOYEE_HISTORY_PKv2 PRIMARY KEY ( IDPROVIDERHISTORY ) ;


CREATE TABLE TB_PROVIDER_OPERATION
  (
    IDOPERATION NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_PROVIDER_OPERATION ADD CONSTRAINT TB_EMPLOYEE_OPERATION_PKv4 PRIMARY KEY ( IDOPERATION ) ;


CREATE TABLE TB_SALE_TYPE
  (
    IDSALETYPE  NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_SALE_TYPE ADD CONSTRAINT TB_SALE_TYPE_PK PRIMARY KEY ( IDSALETYPE ) ;


CREATE TABLE TB_STATE
  (
    IDSTATE NUMERIC NOT NULL ,
    UF      CHARACTER VARYING (10) ,
    NAME    CHARACTER VARYING (20)
  ) ;
ALTER TABLE TB_STATE ADD CONSTRAINT TB_STATE_PK PRIMARY KEY ( IDSTATE ) ;


CREATE TABLE TB_STOCK_TYPE
  (
    IDSTOCKTYPE NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_STOCK_TYPE ADD CONSTRAINT TB_STOCK_TYPE_PK PRIMARY KEY ( IDSTOCKTYPE ) ;


CREATE TABLE TB_USER
  (
    IDUSER       NUMERIC NOT NULL ,
    IDUSERTYPE   NUMERIC NOT NULL ,
    IDICITY      NUMERIC NOT NULL ,
    FIRSTNAME    CHARACTER VARYING (50) ,
    LASTNAME     CHARACTER VARYING (50) ,
    NEIGHBORHOOD CHARACTER VARYING (150) ,
    ANUMERIC      CHARACTER VARYING (10) ,
    EMAIL        CHARACTER VARYING (50) ,
    INSERTDATE   DATE ,
    USERNAME     CHARACTER VARYING (12) ,
    ACTIVE       boolean ,
    PASSWORD     CHARACTER VARYING (50) ,
    RG           CHARACTER VARYING (9) ,
    CPF          CHARACTER VARYING (11) ,
    BIRTHDATE    DATE
  ) ;
ALTER TABLE TB_USER ADD CONSTRAINT TB_USER_PK PRIMARY KEY ( IDUSER ) ;


CREATE TABLE TB_USER_HISTORY
  (
    IDUSERHISTORY   NUMERIC NOT NULL ,
    IDUSER          NUMERIC NOT NULL ,
	IDUSERTYPE  	NUMERIC NOT NULL ,
    IDCITY          NUMERIC NOT NULL ,
    IDOPERATION     NUMERIC NOT NULL ,
    FIRSTNAME       CHARACTER VARYING (50) ,
    LASTNAME        CHARACTER VARYING (50) ,
    NEIGHBORHOOD    CHARACTER VARYING (150) ,
    ANUMERIC         CHARACTER VARYING (10) ,
    EMAIL           CHARACTER VARYING (50) ,
    DDD_PHONE       CHARACTER VARYING (2) ,
    PHONE_NUMERIC    CHARACTER VARYING (10) ,
    DDD_CELLPHONE   CHARACTER VARYING (2) ,
    CELLPHONENUMERIC CHARACTER VARYING (10) ,
    INSERTDATE      DATE ,
    USERNAME        CHARACTER VARYING (12) ,
    ACTIVE          boolean ,
	PASSWORD     CHARACTER VARYING (50) ,
    RG              CHARACTER VARYING (9) ,
    CPF             CHARACTER VARYING (11) ,
    BIRTHDATE       DATE
  ) ;
ALTER TABLE TB_USER_HISTORY ADD CONSTRAINT TB_USER_HISTORY_PK PRIMARY KEY ( IDUSERHISTORY ) ;


CREATE TABLE TB_USER_OPERATION
  (
    IDOPERATION NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_USER_OPERATION ADD CONSTRAINT TB_EMPLOYEE_OPERATION_PKv2 PRIMARY KEY ( IDOPERATION ) ;


CREATE TABLE TB_USER_TYPE
  (
    IDUSERTYPE  NUMERIC NOT NULL ,
    CODE        CHARACTER VARYING (4) ,
    DESCRIPTION CHARACTER VARYING (50)
  ) ;
ALTER TABLE TB_USER_TYPE ADD CONSTRAINT TB_USER_TYPE_PK PRIMARY KEY ( IDUSERTYPE ) ;




-- FOREIGN KEYS --
ALTER TABLE TB_CITY ADD CONSTRAINT CITY_STATE_FK FOREIGN KEY ( IDSTATE ) REFERENCES TB_STATE ( IDSTATE ) ;
ALTER TABLE TB_CUSTOMER ADD CONSTRAINT CUSTOMER_CITY_FK FOREIGN KEY ( IDCITY ) REFERENCES TB_CITY ( IDCITY ) ;
ALTER TABLE TB_CUSTOMER_HISTORY ADD CONSTRAINT CUSTOMER_HISTORY_CITY_FK FOREIGN KEY ( IDCITY ) REFERENCES TB_CITY ( IDCITY ) ;
ALTER TABLE TB_CUSTOMER_HISTORY ADD CONSTRAINT CUSTOMER_HISTORY_CSTMR_FK FOREIGN KEY ( IDCUSTOMER ) REFERENCES TB_CUSTOMER ( IDCUSTOMER ) ;
ALTER TABLE TB_CUSTOMER_HISTORY ADD CONSTRAINT CUSTOMER_HISTORY_CSTMR_OP_FK FOREIGN KEY ( IDOPERATION ) REFERENCES TB_CUSTOMER_OPERATION ( IDOPERATION ) ;
ALTER TABLE TB_CUSTOMER ADD CONSTRAINT CUSTOMER_USER_FK FOREIGN KEY ( IDUSERSELLER ) REFERENCES TB_USER ( IDUSER ) ;
ALTER TABLE TB_PROVIDER ADD CONSTRAINT EMPLOYEE_CITY_FK FOREIGN KEY ( IDCITY ) REFERENCES TB_CITY ( IDCITY ) ;
ALTER TABLE TB_EMPLOYEE_HISTORY ADD CONSTRAINT EMPLOYEE_HISTORY_CITY_FK FOREIGN KEY ( IDCITY ) REFERENCES TB_CITY ( IDCITY ) ;
ALTER TABLE TB_EMPLOYEE_HISTORY ADD CONSTRAINT EMPLOYEE_HISTORY_EMP_FK FOREIGN KEY ( IDEMPLOYEE ) REFERENCES TB_EMPLOYEE ( IDEMPLOYEE ) ;
ALTER TABLE TB_EMPLOYEE_HISTORY ADD CONSTRAINT EMPLOYEE_HISTORY_EMP_OP_FK FOREIGN KEY ( IDOPERATION ) REFERENCES TB_EMPLOYEE_OPERATION ( IDOPERATION ) ;
ALTER TABLE TB_EXPENSE ADD CONSTRAINT EXPENSE_EXPENSE_ITEM_FK FOREIGN KEY ( IDEXPENSEITEM ) REFERENCES TB_EXPENSE_ITEM ( IDEXPENSEITEM ) ;
ALTER TABLE TB_EXPENSE ADD CONSTRAINT EXPENSE_EXPENSE_STATUS_FK FOREIGN KEY ( IDEXPENSESTATUS ) REFERENCES TB_EXPENSE_STATUS ( IDEXPENSESTATUS ) ;
ALTER TABLE TB_EXPENSE ADD CONSTRAINT EXPENSE_EXPENSE_TYPE_FK FOREIGN KEY ( IDEXPENSETYPE ) REFERENCES TB_EXPENSE_TYPE ( IDEXPENSETYPE ) ;
ALTER TABLE TB_EXPENSE_HISTORY ADD CONSTRAINT EXPENSE_HISTORY_EXP_FK FOREIGN KEY ( IDEXPENSE ) REFERENCES TB_EXPENSE ( IDEXPENSE ) ;
ALTER TABLE TB_EXPENSE_HISTORY ADD CONSTRAINT EXPENSE_HISTORY_EXP_IT_FK FOREIGN KEY ( IDEXPENSEITEM ) REFERENCES TB_EXPENSE_ITEM ( IDEXPENSEITEM ) ;
ALTER TABLE TB_EXPENSE_HISTORY ADD CONSTRAINT EXPENSE_HISTORY_EXP_OP_FK FOREIGN KEY ( IDOPERATION ) REFERENCES TB_EXPENSE_OPERATION ( IDOPERATION ) ;
ALTER TABLE TB_EXPENSE_HISTORY ADD CONSTRAINT EXPENSE_HISTORY_EXP_STAT_FK FOREIGN KEY ( IDEXPENSESTATUS ) REFERENCES TB_EXPENSE_STATUS ( IDEXPENSESTATUS ) ;
ALTER TABLE TB_EXPENSE_HISTORY ADD CONSTRAINT EXPENSE_HISTORY_EXP_TYPE_FK FOREIGN KEY ( IDEXPENSETYPE ) REFERENCES TB_EXPENSE_TYPE ( IDEXPENSETYPE ) ;
ALTER TABLE TB_EXPENSE_HISTORY ADD CONSTRAINT EXPENSE_HISTORY_PROVIDER_FK FOREIGN KEY ( IDPROVIDER ) REFERENCES TB_PROVIDER ( IDPROVIDER ) ;
ALTER TABLE TB_EXPENSE_PAYMENT ADD CONSTRAINT EXPENSE_PAYMENT_EXP_FK FOREIGN KEY ( IDEXPENSE ) REFERENCES TB_EXPENSE ( IDEXPENSE ) ;
ALTER TABLE TB_EXPENSE ADD CONSTRAINT EXPENSE_PROVIDER_FK FOREIGN KEY ( IDFORNECEDOR ) REFERENCES TB_PROVIDER ( IDPROVIDER ) ;
ALTER TABLE TB_ORDER ADD CONSTRAINT ORDER_CUSTOMER_FK FOREIGN KEY ( IDCUSTOMER ) REFERENCES TB_CUSTOMER ( IDCUSTOMER ) ;
ALTER TABLE TB_ORDER_HISTORY ADD CONSTRAINT ORDER_HISTORY_ODER_OP_FK FOREIGN KEY ( IDOPERATION ) REFERENCES TB_ORDER_OPERATION ( IDOPERATION ) ;
ALTER TABLE TB_ORDER_HISTORY ADD CONSTRAINT ORDER_HISTORY_ORDER_ITEM_FK FOREIGN KEY ( IDORDERITEM ) REFERENCES TB_ORDER_ITEM ( IDORDERITEM ) ;
ALTER TABLE TB_ORDER_ITEM ADD CONSTRAINT ORDER_ITEM_ORDER_FK FOREIGN KEY ( IDORDER ) REFERENCES TB_ORDER ( IDORDER ) ;
ALTER TABLE TB_ORDER_ITEM ADD CONSTRAINT ORDER_ITEM_PRODUCT_FK FOREIGN KEY ( IDPRODUCT ) REFERENCES TB_PRODUCT ( IDPRODUCT ) ;
ALTER TABLE TB_ORDER_PAYMENT ADD CONSTRAINT ORDER_PAYMENT_ORDER_FK FOREIGN KEY ( IDORDER ) REFERENCES TB_ORDER ( IDORDER ) ;
ALTER TABLE TB_ORDER ADD CONSTRAINT ORDER_ORDER_STAT_FK FOREIGN KEY ( IDORDERSTATUS ) REFERENCES TB_ORDER_STATUS ( IDORDERSTATUS ) ;
ALTER TABLE TB_ORDER_HISTORY ADD CONSTRAINT ORDER_HST_ORD_STAT_FK FOREIGN KEY ( IDORDERSTATUS ) REFERENCES TB_ORDER_STATUS ( IDORDERSTATUS ) ;
ALTER TABLE TB_PHONE ADD CONSTRAINT PHONE_CUSTOMER_FK FOREIGN KEY ( IDCUSTOMER ) REFERENCES TB_CUSTOMER ( IDCUSTOMER ) ;
ALTER TABLE TB_PHONE ADD CONSTRAINT PHONE_EMPLOYEE_FK FOREIGN KEY ( IDEMPLOYEE ) REFERENCES TB_EMPLOYEE ( IDEMPLOYEE ) ;
ALTER TABLE TB_PHONE ADD CONSTRAINT PHONE_PHONE_TYPE_FK FOREIGN KEY ( IDPHONETYPE ) REFERENCES TB_PHONE_TYPE ( IDPHONETYPE ) ;
ALTER TABLE TB_PHONE ADD CONSTRAINT PHONE_PROVIDER_FK FOREIGN KEY ( IDPROVIDER ) REFERENCES TB_PROVIDER ( IDPROVIDER ) ;
ALTER TABLE TB_PHONE ADD CONSTRAINT PHONE_USER__FK FOREIGN KEY ( IDUSER ) REFERENCES TB_USER ( IDUSER ) ;
ALTER TABLE TB_PRODUCT_HISTORY ADD CONSTRAINT PRODUCT_HISTORY_PRODTYPE_TP_FK FOREIGN KEY ( IDPRODUCTIONTYPE ) REFERENCES TB_PRODUCTION_TYPE ( IDPRODUCTIONTYPE ) ;
ALTER TABLE TB_PRODUCT_HISTORY ADD CONSTRAINT PRODUCT_HISTORY_PRODUCT_FK FOREIGN KEY ( IDPRODUCT ) REFERENCES TB_PRODUCT ( IDPRODUCT ) ;
ALTER TABLE TB_PRODUCT_HISTORY ADD CONSTRAINT PRODUCT_HISTORY_PRODUCT_OP_FK FOREIGN KEY ( IDOPERATION ) REFERENCES TB_PRODUCT_OPERATION ( IDOPERATION ) ;
ALTER TABLE TB_PRODUCT_HISTORY ADD CONSTRAINT PRODUCT_HISTORY_SALE_TYPE_FK FOREIGN KEY ( IDSALETYPE ) REFERENCES TB_SALE_TYPE ( IDSALETYPE ) ;
ALTER TABLE TB_PRODUCT_HISTORY ADD CONSTRAINT PRODUCT_HISTORY_STOCK_TYPE_FK FOREIGN KEY ( IDSTOCKTYPE ) REFERENCES TB_STOCK_TYPE ( IDSTOCKTYPE ) ;
ALTER TABLE TB_PRODUCT ADD CONSTRAINT PRODUCT_PRODUCTION_TYPE_FK FOREIGN KEY ( IDPRODUCTIONTYPE ) REFERENCES TB_PRODUCTION_TYPE ( IDPRODUCTIONTYPE ) ;
ALTER TABLE TB_PRODUCT ADD CONSTRAINT PRODUCT_SALE_TYPE_FK FOREIGN KEY ( IDSALETYPE ) REFERENCES TB_SALE_TYPE ( IDSALETYPE ) ;
ALTER TABLE TB_PRODUCT ADD CONSTRAINT PRODUCT_STOCK_TYPE_FK FOREIGN KEY ( IDSTOCKTYPE ) REFERENCES TB_STOCK_TYPE ( IDSTOCKTYPE ) ;
ALTER TABLE TB_PROVIDER_HISTORY ADD CONSTRAINT PROVIDER_HISTORY_CITY_FK FOREIGN KEY ( IDCITY ) REFERENCES TB_CITY ( IDCITY ) ;
ALTER TABLE TB_PROVIDER_HISTORY ADD CONSTRAINT PROVIDER_HISTORY_PROV_FK FOREIGN KEY ( IDPROVIDER ) REFERENCES TB_PROVIDER ( IDPROVIDER ) ;
ALTER TABLE TB_PROVIDER_HISTORY ADD CONSTRAINT PROVIDER_HISTORY_PROV_OP_FK FOREIGN KEY ( IDOPERATION ) REFERENCES TB_PROVIDER_OPERATION ( IDOPERATION ) ;
ALTER TABLE TB_EMPLOYEE ADD CONSTRAINT TB_EMPLOYEE_TB_CITY_FK FOREIGN KEY ( IDCITY ) REFERENCES TB_CITY ( IDCITY ) ;
ALTER TABLE TB_USER ADD CONSTRAINT USER_CITY_FK FOREIGN KEY ( IDICITY ) REFERENCES TB_CITY ( IDCITY ) ;
ALTER TABLE TB_USER_HISTORY ADD CONSTRAINT USER_HISTORY_CITY_FK FOREIGN KEY ( IDCITY ) REFERENCES TB_CITY ( IDCITY ) ;
ALTER TABLE TB_USER_HISTORY ADD CONSTRAINT USER_HISTORY_OPERATION_TYPE_FK FOREIGN KEY ( IDUSER ) REFERENCES TB_USER ( IDUSER ) ;
ALTER TABLE TB_USER_HISTORY ADD CONSTRAINT USER_HISTORY_USER_OPERATION_FK FOREIGN KEY ( IDOPERATION ) REFERENCES TB_USER_OPERATION ( IDOPERATION ) ;
ALTER TABLE TB_USER_HISTORY ADD CONSTRAINT USER_HISTORY_USER_TYPE_FK FOREIGN KEY ( IDUSERTYPE ) REFERENCES TB_USER_TYPE ( IDUSERTYPE ) ;
ALTER TABLE TB_USER ADD CONSTRAINT USER_USER_TYPE_FK FOREIGN KEY ( IDUSERTYPE ) REFERENCES TB_USER_TYPE ( IDUSERTYPE ) ;
