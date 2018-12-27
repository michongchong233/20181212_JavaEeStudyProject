/*選擇DB*/
use dbtest;

/*建立用戶表格*/
create table T41_UserImformation (
	uid int(10) not null auto_increment,
    uname varchar(100) not null,
    password varchar(100) not null,
    gender char(2) not null,
    age int(3),
    birth date, 
    primary key(uid)
);

/*添加測試數據*/
insert into dbtest.T41_UserImformation (uname, password, gender, age, birth) values
('test1', '123', 1, 25, '1993-12-16'),
('test2', '456', 2, 12, '2006-08-03'),
('test3', '789', 2, 36, '1982-02-19');

/*查詢數據*/
select * from dbtest.T41_UserImformation;

/*查詢用戶編號*/
select * from dbtest.T41_UserImformation where uid='1';

/*更新密碼*/
update T41_UserImformation set password='321' where uid=1;
