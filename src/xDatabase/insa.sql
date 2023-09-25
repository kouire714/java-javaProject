show tables;

create table insa(
  idx  int not null auto_increment primary key,
  name varchar(20) not null,  /* 성명 */
  age  int default 20,				/* 나이 */
  gender char(2) default '여자',	/* 성별 */
  ipsail datetime default now()	/* 입사일 */
);

drop table insa;

desc insa;

insert into insa (name) values ('홍길동');

select * from insa;
