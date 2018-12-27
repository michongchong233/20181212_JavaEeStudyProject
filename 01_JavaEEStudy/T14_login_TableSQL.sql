/*建立用戶表格*/
create table T14_login (
	uid int(10) not null auto_increment,
	uname varchar(255) not null,
	password varchar(255) not null,
	primary key(uid)
);

/*添加測試數據*/
insert into dbtest.T14_login(uname, password)
values('Mickey', '2333'), ('Jennifer', '123456'), ('Mike', '0000');

/*查詢數據*/
select * from T14_login where uname='Mickey' and password='2333';

/*查詢用戶編號*/
select * from t14_login where uid=1;