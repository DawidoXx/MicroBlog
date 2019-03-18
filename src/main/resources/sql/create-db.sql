drop schema PUBLIC cascade;
drop table USERS if exists;
drop table AppUser if exists;
create table AppUser (
    uid INTEGER IDENTITY PRIMARY KEY,
    username VARCHAR(100) UNIQUE,
    password VARCHAR(200),
    email VARCHAR(200),
    name VARCHAR(100),
    surname VARCHAR(100)
);
drop table FOLLOWERS if exists;
drop table Follower if exists;
create table Follower(
    fuid INTEGER IDENTITY PRIMARY KEY,
    uid INTEGER NOT NULL,
    uid_followuje INTEGER NOT NULL
);

drop table Post if exists;
drop table POSTS if exists;
create table Post (
    pid INTEGER IDENTITY PRIMARY KEY,
    uid INTEGER NOT NULL,
    datepost VARCHAR(255),
    updateddate VARCHAR(255),
    descr VARCHAR(255)
);


