/*選擇DB*/
use dbtest;

/*建立用戶表格*/
create table T55_UserImformation (
	uid int(10) not null auto_increment,
    uname varchar(100) not null,
    price int(10) not null,
    loc varchar(50), 
    des varchar(500),
    primary key(uid)
);

/*查詢數據*/
select * from T55_UserImformation;

/*添加測試數據*/
insert into dbtest.T55_UserImformation (uname, price, loc, des) values
('mickey', '15.5', '戰士', '測試使用號01'),
('mike', '12.6', '法師', '測試使用號02'),
('minny', '20.8', '補師', '測試使用號03');