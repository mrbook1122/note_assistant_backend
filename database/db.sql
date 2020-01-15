create database note;

use note;

create table user
(
    id           int primary key auto_increment,
    name         varchar(50)  not null unique,
    pass         varchar(200) not null,
    avatar       varchar(500) comment '用户头像',
    phone_number varchar(20),
    email        varchar(100)
);

create table notebook
(
    id          int primary key auto_increment,
    create_time datetime not null,
    update_time datetime not null,
    delete_time datetime,
    status      tinyint  not null,
    name        varchar(50),
    user_id     int      not null,
    unique (user_id, name),
    foreign key (user_id) references user (id)
);

create table note
(
    id          int primary key auto_increment,
    create_time datetime not null,
    update_time datetime not null,
    delete_time datetime,
    title       varchar(50),
    content     text,
    status      tinyint  not null,
    url         varchar(500),
    user_id     int      not null,
    notebook_id int      not null,
    foreign key (user_id) references user (id),
    foreign key (notebook_id) references notebook (id)
);