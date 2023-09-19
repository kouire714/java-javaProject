show tables;

create table hoiwon (
  idx  int not null auto_increment primary key,
  name varchar(20) not null,
  age  int  default 20,
  address varchar(50),
  gender  char(2) default '여자'
);

desc hoiwon;

insert into hoiwon values (default, '가가가', 40, '경주','남자');
insert into hoiwon values (default, '나나나', 24, '광주','여자');
insert into hoiwon values (default, '다다다', 34, '전주','남자');
insert into hoiwon values (default, '라라라', 41, '나주','여자');
insert into hoiwon values (default, '마마마', 45, '음성','남자');
insert into hoiwon values (default, '바바바', 34, '남양주','남자');
insert into hoiwon values (default, '사사사', 45, '증평','남자');
insert into hoiwon values (default, '아아아', 42, '괴산','여자');
insert into hoiwon values (default, '자자자', 43, '청주','남자');
insert into hoiwon values (default, '차차차', 44, '서울','남자');
insert into hoiwon values (default, '카카카', 45, '광주','여자');
insert into hoiwon values (default, '파파파', 34, '인천','남자');
insert into hoiwon values (default, '하하하', 34, '서울','여자');

select * from hoiwon;

delete from hoiwon where name = '홍길동';
