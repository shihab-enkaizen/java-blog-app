create table users
(
    id        bigint not null  constraint users_pk primary key,
    username  varchar(255),
    email     varchar(255),
    password  varchar(255),
    dob       timestamp,
    firstname Varchar(255),
    lastname  varchar(255),
    role      varchar(255)
);

create table billingaddress
(
    id      bigint not null
        constraint billingaddress_pk primary key,
    city    varchar(255),
    address varchar(255),
    userid  bigint constraint billingaddress_fk_userid references users

);

create table cardinformations
(
    id             bigint not null constraint cardinformations_pk primary key,
    cardnumber     varchar(255),
    cvc            varchar(5),
    expiredate     timestamp,
    cardholdername varchar(255),
    userid         bigint constraint cardinformations_fk_userid references users

);
--
-- create table blogs
-- (
--     id          bigint not null constraint users_pk primary key,
--     title       varchar(255),
--     status      varchar(255),
--     description text,
--     publishdate timestamp,
--     userid      bigint,
--
--     constraint blogs_fk_userid foreign key (userid) references users;
-- );
--
-- create table blogreactions
-- (
--     id          bigint not null constraint users_pk primary key,
--     reaction    varchar(255),
--     createdat   timestamp,
--     userid      bigint,
--     blogid      bigint,
--
--     constraint blogreactions_fk_blogid foreign key (blogid) references blogs,
--     constraint blogreactions_fk_userid foreign key (userid) references users;
-- );
--
-- create table comments
-- (
--     id          bigint not null constraint users_pk primary key,
--     comment     varchar(255),
--     createdat   timestamp,
--     userid      bigint,
--     blogid      bigint,
--
--     constraint comments_fk_blogid foreign key (blogid) references blogs,
--     constraint comments_fk_userid foreign key (userid) references users;
-- );
--
-- create table commentreactions
-- (
--     id          bigint not null constraint users_pk primary key,
--     reaction    varchar(255),
--     createdat   timestamp,
--     userid      bigint,
--     commentid   bigint,
--
--     constraint commentreactions_fk_blogid foreign key (commentid) references comments,
--     constraint commentreactions_fk_userid foreign key (userid) references users;
-- );