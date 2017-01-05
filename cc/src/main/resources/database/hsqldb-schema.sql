create table CHAT_ROOM (
    ID varchar(25) not null,
    NAME varchar(25)  not null,
    DESCRIPTION varchar(80) null,
    constraint PK_CHAT_ROOM primary key (ID)
);