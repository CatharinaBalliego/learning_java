create database customer_db;

use customer_db;

create table customer_tb (
custormer_id int primary key auto_increment,
customer_name varchar(100) not null);

select * from customer_tb;


insert into customer_tb (customer_name) values ("Federzoni"), ("Pacheco"), ("Casa Lua");


alter table customer_tb rename column custormer_id to customer_id