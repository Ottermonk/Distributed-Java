create schema ottermonk;

create table CUSTOMER
(
    CUSTOMER_ID int generated always as identity
        constraint customer_pk
            primary key,
    CUSTOMER_NM VARCHAR(75) not null,
    AGE         int,
    EMAIL       VARCHAR(75) not null
);

create table CUSTOMERORDER
(
    ORDER_ID    int generated always as identity
        constraint order_pk
            primary key,
    CUSTOMER_ID int
        references CUSTOMER (customer_id)
);

create table PRODUCT
(
    PRODUCT_ID int generated always as identity
        constraint product_pk
            primary key,
    PRODUCT_NM VARCHAR(75),
    COST       DOUBLE
);

create table LINEITEM
(
    LINEITEM_ID int generated always as identity
        constraint lineitem_pk
            primary key,
    ORDER_ID    int
        references CUSTOMERORDER (order_id),
    PRODUCT_ID  int
        references PRODUCT (product_id),
    QUANTITY    int
);