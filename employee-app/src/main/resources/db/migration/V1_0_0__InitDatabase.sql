CREATE TABLE IF NOT EXISTS SY_ROLE
(
    ID_ROLE     SERIAL PRIMARY KEY,
    DESCRIPTION VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS SY_USER
(
    USERNAME VARCHAR(100) PRIMARY KEY,
    PASS     VARCHAR(255) NOT NULL,
    EMAIL    VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS SY_USER_ROLE
(
    USERNAME VARCHAR(100),
    ID_ROLE  INTEGER,
    PRIMARY KEY (USERNAME, ID_ROLE),
    CONSTRAINT fk_user_role_user
        FOREIGN KEY (USERNAME) references SY_USER (USERNAME),
    CONSTRAINT fk_user_role_role
        FOREIGN KEY (ID_ROLE) references SY_ROLE (ID_ROLE)
);

CREATE TABLE IF NOT EXISTS SY_GRANT
(
    ID_GRANT SERIAL PRIMARY KEY,
    NAME     varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS SY_ROLE_GRANT
(
    ID_ROLE  INTEGER,
    ID_GRANT INTEGER,
    PRIMARY KEY (ID_ROLE, ID_GRANT),
    CONSTRAINT fk_role_grant_role
        FOREIGN KEY (ID_ROLE) references SY_ROLE (ID_ROLE),
    CONSTRAINT fk_role_grant_grant
        FOREIGN KEY (ID_GRANT) references SY_GRANT (ID_GRANT)
);

CREATE TABLE IF NOT EXISTS EMPLOYEE
(
    ID_EMPLOYEE       SERIAL PRIMARY KEY,
    NAME              varchar(100) NOT NULL,
    LASTNAME          varchar(100) NOT NULL,
    BIRTHDATE         DATE         NOT NULL,
    REGISTRATION_DATE DATE         NOT NULL
);