create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table roles
(
    id   bigint not null
        primary key,
    name varchar(255)
);

alter table roles
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
