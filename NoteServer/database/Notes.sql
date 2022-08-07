use master
go

drop database NOTES
go

create database NOTES
go

use NOTES
go
create table USERS(
    username varchar(255) NOT NULL primary key,
    pass varchar(255),
)

go 

create table NOTES(
    username varchar(255),
    note_id int identity(1,1) primary key,
    files_path varchar(255),
    files_type varchar(255),

)

alter table NOTES add constraint fk_usrn
    foreign key (username)
    references USERS(username)

go