create database customer_db;

use customer_db;

create table customer_tb (
customer_id int primary key auto_increment,
customer_name varchar(100) not null);

select * from customer_tb;


insert into customer_tb (customer_name) values ("Federzoni"), ("Pacheco"), ("Casa Lua");

create table customer_type_tb (
customer_type_id int primary key auto_increment,
customer_type_name varchar(100) not null);

insert into customer_type_tb (customer_type_name) values ("Stationer"), ("Buildin Supplies"),("Market"),("Restaurant"), ("Clothes Shop");

alter table customer_tb add column customer_type_id int ;
alter table customer_tb add constraint  foreign key `fk_customer_type` (customer_type_id) references customer_type_tb(customer_type_id);

update customer_tb set customer_type_id = 3
where customer_id  = 1;

update customer_tb set customer_type_id = 2 where customer_id = 2;

update customer_tb set customer_type_id = 1 where customer_id = 3;

alter table customer_tb add register_dt datetime  default CURRENT_TIMESTAMP,
 add  modification_dt  datetime on update CURRENT_TIMESTAMP,
 add  company_code int(4) ;
 
 drop trigger trigger_company_code;
 DELIMITER $$
  create trigger trigger_company_code before insert on customer_tb for each row
  begin
  set new.company_code=FLOOR(5 + RAND()*(9000));
 end $$
 

 insert into customer_tb (customer_name, customer_type_id) value ('Maritaca', 5)
 


 