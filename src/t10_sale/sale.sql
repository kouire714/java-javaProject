show tables;

/* 상품테이블(product) */
create table product (
	idx  int not null auto_increment primary key,	/* 상품 고유번호 */
	pName varchar(20) not null,			/* 상품명 */
	price int not null							/* 상품가격 */
);

desc product;

insert into product values (default, '냉장고', 800000);

select * from product;

/* 판매 테이블 */
create table sale (
  idx   int not null auto_increment primary key,	/* 판매테이블 고유번호 */
  pName varchar(20) not null,							/* 판매 상품명 */
  ea		int not null default 0,						/* 판매 수량 */
  pDate datetime	not null default now()	/* 판매 날짜 */
);

desc sale;

insert into sale values (default, '냉장고', 2, default);

select * from sale;