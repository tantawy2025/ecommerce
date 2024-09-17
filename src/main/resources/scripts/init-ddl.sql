---------------------  create project schema  -------------------------------------


CREATE SCHEMA IF NOT EXISTS ecommerce;


---------------------  create category table -------------------------------------

CREATE TABLE ecommerce.category
(
    category_id serial,
    category_name character varying NOT NULL,
    category_description character varying,
    PRIMARY KEY (category_id)
);

ALTER TABLE IF EXISTS ecommerce.category
    OWNER to postgres;

---------------------  create merchant table -------------------------------------


CREATE TABLE ecommerce.merchant
(
    merchant_id serial,
    name character varying NOT NULL,
    email character varying NOT NULL,
    address character varying ,
    status boolean DEFAULT true,
    PRIMARY KEY (merchant_id)
);

ALTER TABLE IF EXISTS ecommerce.merchant
    OWNER to postgres;


---------------------  create product table -------------------------------------


CREATE TABLE ecommerce.product
(
    product_id serial,
    product_name character varying NOT NULL,
    sku character varying NOT NULL,
    description text,
    price numeric NOT NULL,
    stock integer,
    status boolean NOT NULL DEFAULT true,
    category_id integer,
    merchant_id integer,
    PRIMARY KEY (product_id),
    CONSTRAINT fk_category FOREIGN KEY (category_id)
        REFERENCES ecommerce.category (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_merchant FOREIGN KEY (merchant_id)
        REFERENCES ecommerce.merchant (merchant_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS ecommerce.product
    OWNER to postgres;

---------------------  create customer table -------------------------------------

CREATE TABLE ecommerce.customer
(
    customer_id serial,
    customer_name character varying NOT NULL,
    email character varying NOT NULL,
    phone character varying NOT NULL,
    address character varying,
    PRIMARY KEY (customer_id)
);

ALTER TABLE IF EXISTS ecommerce.customer
    OWNER to postgres;


---------------------  create order table -------------------------------------

CREATE TABLE ecommerce."order"
(
    order_id serial,
    customer_id integer NOT NULL,
    order_date date,
    total_amount numeric,
    "order-state" bit varying,
    PRIMARY KEY (order_id),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id)
        REFERENCES ecommerce.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);
ALTER TABLE IF EXISTS ecommerce."order"
    RENAME "order-state" TO order_status;

ALTER TABLE IF EXISTS ecommerce."order"
    ADD COLUMN shipping_address character varying;

ALTER TABLE IF EXISTS ecommerce."order"
    ADD COLUMN billing_address character varying;

ALTER TABLE IF EXISTS ecommerce."order"
    ADD COLUMN payment_status character varying;

ALTER TABLE IF EXISTS ecommerce."order"
    OWNER to postgres;

ALTER TABLE IF EXISTS ecommerce."order" DROP COLUMN IF EXISTS order_status;

ALTER TABLE IF EXISTS ecommerce."order"
    ADD COLUMN order_status character varying;

---------------------  create order details table -------------------------------------

CREATE TABLE ecommerce.order_details
(
    order_item_id serial,
    order_id integer,
    product_id integer,
    quantity integer,
    unit_price numeric,
    PRIMARY KEY (order_item_id),
    CONSTRAINT fk_order FOREIGN KEY (order_id)
        REFERENCES ecommerce."order" (order_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_product FOREIGN KEY (product_id)
        REFERENCES ecommerce.product (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS ecommerce.order_details
    OWNER to postgres;



-----------------------------------------------------------------------------------


