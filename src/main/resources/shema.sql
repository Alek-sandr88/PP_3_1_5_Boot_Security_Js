# CREATE TABLE IF NOT EXISTS users
# (
#     id       bigint auto_increment not null,
#     username varchar(255)          not null,
#     lastname varchar(255)          not null,
#     password varchar(500)          not null,
#     email    varchar(255),
#     primary key (id)
#     );
#
# CREATE TABLE IF NOT EXISTS roles
# (
#     id   bigint auto_increment not null,
#     name varchar(255),
#     primary key (id)
#     );
#
# CREATE TABLE IF NOT EXISTS user_roles
# (
#     user_id bigint not null,
#     role_id bigint not null,
#     primary key (user_id, role_id),
#     foreign key (user_id) references users (id),
#     foreign key (role_id) references roles (id)
#     )