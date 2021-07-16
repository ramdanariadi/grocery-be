create table category (
    id int4 not null,
    category varchar(255),
    primary key (id)
);

create table product (
    id int4 not null,
    description varchar(255),
    name varchar(255),
    price int8,
    category_id int4,
    primary key (id)
);

create table stock_opname (
   id int4 not null,
   last_stock int4,
   stock int4,
   product_id int4,
   primary key (id)
);

alter table product
    add constraint FK1mtsbur82frn64de7balymq9s
        foreign key (category_id)
            references category;

alter table stock_opname
    add constraint FKpfirr3oq131ty8bskeo2rxyx7
        foreign key (product_id)
            references product;
