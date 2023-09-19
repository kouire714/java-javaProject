show tables;

create table hoiwon (
idx int not null auto_increment primary key,
name varchar(20) not null,
age int default 20,
address varchar(50),
gender char(2) default '여자'
);

desc hoiwon;

insert into hoiwon values (default, '가가가', 40, '경주', '여자');
insert into hoiwon values (default, '나나나', 40, '광주', '남자');
insert into hoiwon values (default, '다다다', 40, '전주', '남자');
insert into hoiwon values (default, '라라라', 40, '나주', '남자');
insert into hoiwon values (default, '마마마', 40, '음성', '남자');
insert into hoiwon values (default, '바바바', 40, '남양주', '남자');
insert into hoiwon values (default, '사사사', 40, '증평', '남자');
insert into hoiwon values (default, '아아아', 40, '괴산', '여자');
insert into hoiwon values (default, '자자자', 40, '청주', '남자');
insert into hoiwon values (default, '차차차', 40, '서울', '남자');
insert into hoiwon values (default, '카카카', 40, '광주', '여자');
insert into hoiwon values (default, '파파파', 40, '인천', '남자');
insert into hoiwon values (default, '하하하', 40, '서울', '남자');

select * from hoiwon;