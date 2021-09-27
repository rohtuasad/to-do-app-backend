create table to_do_app.user
(
    user_id  uuid
        constraint user_id_pk
            primary key,
    login    varchar(50)
        constraint login_uk
            unique,
    email    varchar(50)
        constraint email_uk
            unique,
    name     varchar(50),
    is_enabled  boolean NOT NULL DEFAULT true,
    password varchar(150)
);