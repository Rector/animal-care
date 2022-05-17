CREATE TABLE users (
    id                      bigserial PRIMARY KEY,
    username                VARCHAR(50) NOT NULL,
    password                VARCHAR(80) NOT NULL,
    email                   VARCHAR(100) NOT NULL,
    enabled                 boolean NOT NULL
);

CREATE UNIQUE index ix_users_username ON users (username);

CREATE TABLE roles (
    id                      bigserial PRIMARY KEY,
    name                    VARCHAR(50) NOT NULL
);

CREATE UNIQUE index ix_auth_role ON roles (name);

-- Роли:
--  ADMIN может назначать роли другим пользователям
--  MANAGER пользоватьель, может модерировать объявляения, т.е. разрешать их публикацию
--  USER обычный пользоватьель, может регистрироватьс и создавать объявления
INSERT INTO roles (name)
VALUES
('ROLE_ADMIN'),
('ROLE_MANAGER'),
('ROLE_USER');

CREATE TABLE users_roles (
    user_id                 bigint NOT NULL REFERENCES users (id),
    role_id                 bigint NOT NULL REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
--    todo убрать если будет всё работать
--    foreign key (user_id) references users (id),
--    foreign key (authorities_id) references authorities (id)
);

-- admin password: 100
INSERT INTO users (username, password, email, enabled)
VALUES
('admin', '$2a$10$AVhqGnJVnG.oCtwsbeG62.BRo9Qr/Daxr2uPcgDf76xIj.HMsiMCS', 'admin@mail.ru', true),
-- manager password: 100
('manager', '$2a$10$AVhqGnJVnG.oCtwsbeG62.BRo9Qr/Daxr2uPcgDf76xIj.HMsiMCS', 'manager@mail.ru', true),
-- user password: 100
('user', '$2a$10$AVhqGnJVnG.oCtwsbeG62.BRo9Qr/Daxr2uPcgDf76xIj.HMsiMCS', 'user@mail.ru', true);


INSERT INTO users_roles
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 2),
(2, 3),
(3, 3);

CREATE TABLE animals (
    id                      bigserial PRIMARY KEY,
    type                    VARCHAR(80) NOT NULL,
    name                    VARCHAR(80) NOT NULL,
    gender                  VARCHAR(10) NOT NULL,
    age                     INT NOT NULL,
    condition               VARCHAR(255) NOT NULL,
    description             CHARACTER VARYING
);

INSERT INTO animals (type, name, gender, age, condition, description)
VALUES
('Cat', 'Felix', 'Male', 5, 'Good', 'Looking for a host'),
('Cat', 'Kassandra', 'Female', 4, 'Good', 'Looking for a host'),
('Dog', 'Rex', 'Male', 7, 'Good', 'Looking for a host');