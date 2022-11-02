create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table category
(
    id        uuid not null
        primary key,
    category  varchar(255),
    deleted   boolean default false,
    image_url varchar(255)
);

alter table category
    owner to postgres;

create table customer
(
    id     uuid not null
        primary key,
    email  varchar(255),
    mobile varchar(255),
    name   varchar(255)
);

alter table customer
    owner to postgres;

create table products
(
    id          uuid not null
        primary key,
    deleted     boolean default false,
    description varchar(255),
    image_url   varchar(255),
    name        varchar(255),
    per_unit    integer,
    price       bigint,
    weight      integer,
    category_id uuid
        constraint fk1cf90etcu98x1e6n9aks3tel3
            references category
);

alter table products
    owner to postgres;

create table cart
(
    id          uuid not null
        primary key,
    category    varchar(255),
    image_url   varchar(255),
    name        varchar(255),
    per_unit    integer,
    price       bigint,
    total       integer,
    weight      integer,
    customer_id uuid not null
        constraint fkdebwvad6pp1ekiqy5jtixqbaj
            references customer,
    product_id  uuid
        constraint fkpu4bcbluhsxagirmbdn7dilm5
            references products
);

alter table cart
    owner to postgres;

create table liked
(
    id          uuid not null
        primary key,
    category    varchar(255),
    image_url   varchar(255),
    name        varchar(255),
    per_unit    integer,
    price       bigint,
    weight      integer,
    customer_id uuid not null
        constraint fk5npgs7sfso7avbtqooj19s8n7
            references customer,
    product_id  uuid
        constraint fk4tgscg55hv7our1fju6yu7o2q
            references products
);

alter table liked
    owner to postgres;

create table recommendation_products
(
    product_id  uuid not null
        primary key
        constraint fkgcotnvs57umhknyvdfatocbfp
            references products,
    category    varchar(255),
    deleted     boolean default false,
    description varchar(255),
    image_url   varchar(255),
    name        varchar(255),
    per_unit    integer,
    price       bigint,
    weight      integer
);

alter table recommendation_products
    owner to postgres;

create table roles
(
    id   bigint not null
        primary key,
    name varchar(255)
);

alter table roles
    owner to postgres;

create table stock_opname
(
    id         integer not null
        primary key,
    last_stock integer,
    stock      integer,
    product_id uuid
        constraint fkstn4tb46y45scxmhp03w58ann
            references products
);

alter table stock_opname
    owner to postgres;

create table top_products
(
    product_id  uuid not null
        primary key
        constraint fkbf43aox9jqdfvq0ss2aidk5qr
            references products,
    category    varchar(255),
    deleted     boolean default false,
    description varchar(255),
    image_url   varchar(255),
    name        varchar(255),
    per_unit    integer,
    price       bigint,
    weight      integer
);

alter table top_products
    owner to postgres;

create table transaction
(
    id               uuid not null
        primary key,
    customer_email   varchar(255),
    customer_mobile  varchar(255),
    customer_name    varchar(255),
    total_price      bigint,
    transaction_date timestamp,
    customer_id      uuid
        constraint fknbpjofb5abhjg5hiovi0t3k57
            references customer
);

alter table transaction
    owner to postgres;

create table detail_transaction
(
    id             uuid not null
        primary key,
    image_url      varchar(255),
    name           varchar(255),
    per_unit       integer,
    price          bigint,
    total          integer,
    weight         integer,
    product_id     uuid
        constraint fkf784xfktx9aaei9fyqxfrxdqj
            references products,
    transaction_id uuid
        constraint fkd6mv4qpm8jsp3lviwupuodmm4
            references transaction
);

alter table detail_transaction
    owner to postgres;

create table users
(
    id       bigint not null
        primary key,
    name     varchar(255),
    password varchar(255),
    username varchar(255)
        constraint uk_r43af9ap4edm43mmtq01oddj6
            unique
);

alter table users
    owner to postgres;

create table users_roles
(
    user_id  bigint not null
        constraint fk2o0jvgh89lemvvo17cbqvdxaa
            references users,
    roles_id bigint not null
        constraint fka62j07k5mhgifpp955h37ponj
            references roles
);

alter table users_roles
    owner to postgres;

create table variant
(
    id         uuid not null
        primary key,
    price      integer,
    variant    varchar(255),
    product_id uuid not null
        constraint fkjycmkw5ahrykd683um9oy53fe
            references products
);

alter table variant
    owner to postgres;

