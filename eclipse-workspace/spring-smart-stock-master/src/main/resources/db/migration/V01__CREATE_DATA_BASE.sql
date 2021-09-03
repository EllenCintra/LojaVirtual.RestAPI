create table public.product
(
    id bigserial not null
        constraint product_pkey
            primary key,
    details text not null,
    name varchar(255) not null,
    price real not null,
    stock bigint not null
);

create table public.stock_history
(
    id bigserial not null
        constraint stock_history_pkey
            primary key,
    date date not null,
    quantity bigint not null,
    type varchar(255) not null,
    product_id bigint not null
        constraint history_product_fk
            references product
);

create table photo
(
    id uuid not null
        constraint photo_pkey
            primary key,
    data oid,
    file_type varchar(255),
    main boolean,
    product_id bigint not null
        constraint photo_product_fk
            references product
);



