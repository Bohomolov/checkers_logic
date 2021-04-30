CREATE SCHEMA THR;

CREATE table THR.all_credentials
(
    id    INT          NOT NULL PRIMARY KEY,
    login VARCHAR(50)  NOT NULL,
    pass  VARCHAR(50)  NOT NULL,
    uniq  VARCHAR(255) NOT NULL,
    role  INT          NOT NULL
);

CREATE table THR.roles
(
    id   INT         NOT NULL,
    role varchar(50) NOT NULL
);

INSERT INTO THR.roles (id, role) VALUES (1,'user');
INSERT INTO THR.roles (id, role) VALUES (2,'admin');

CREATE table THR.info
(
    id    INT          NOT NULL PRIMARY KEY,
    lastOnline VARCHAR(255)  ,
    token VARCHAR(255)
);

INSERT INTO THR.all_credentials (id, login, pass, uniq, role) VALUES (1,'test','2345uikjbvcxvbn','ftgybhunjmik',1);
INSERT INTO THR.info (id, lastOnline, token) VALUES (SELECT id FROM THR.all_credentials WHERE login = 'test'),'3423424234234234','sdfijisjdfi23');