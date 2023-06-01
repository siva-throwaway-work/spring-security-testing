create sequence user_id_seq start with 10 increment by 50;

create table users (
    id bigint DEFAULT nextval('user_id_seq') not null,
    name varchar not null,
    email varchar not null,
    password varchar not null,
    role varchar not null,
    created_at timestamp,
    updated_at timestamp,
    primary key (id),
    constraint users_email_unique unique(email)
);

insert into users(id, name, email, password, role) values
(1, 'Admin', 'admin@gmail.com', '$2a$10$ZuGgeoawgOg.6AM3QEGZ3O4QlBSWyRx3A70oIcBjYPpUB8mAZWY16', 'ROLE_ADMIN'),
(2, 'Siva', 'siva@gmail.com', '$2a$10$CIXGKN9rPfV/mmBMYas.SemoT9mfVUUwUxueFpU3DcWhuNo5fexYC', 'ROLE_USER');