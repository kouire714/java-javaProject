select * from test1;

show tables;

create table test1 (
	idx int not null auto_increment primary key,
	name varchar(20) not null
);

desc hoiwon;

select * from hoiwon;

insert into hoiwon values (default, '홍길동');
insert into hoiwon values (default, '김말숙');
insert into hoiwon values (default, '이기자');
insert into hoiwon values (default, '소나무');
insert into hoiwon values (default, '대나무', 35);
insert into hoiwon values (default, '대추나무', 40, '경주');
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

drop table hoiwon; -- 테이블의 구조까지 완전히 삭제한다.(데이터를 포함)

-- 컬럼추가(add column)
-- hoiwon테이블에 age컬럼을 추가(int, default 15)
alter table hoiwon add column age int default 15; -- 테이블에 필드 추가(add column)

-- hoiwon테이블에 addr컬럼을 추가(varchar(50))
alter table hoiwon add column addr varchar(50);

-- hoiwon테이블의 addr컬럼을 address로 변경(change / modify)하시오.
alter table hoiwon change column addr address varchar(50);

-- hoiwon테이블의 addr컬럼의 varchar(50)을 30Byte로 변경(change / modify)하시오.
alter table hoiwon modify column address varchar(30);

-- 컬럼 삭제(drop column)
alter table hoiwon drop column address;

-- address 컬럼을 추가(varchar(30) default '청주')
alter table hoiwon add column address varchar(30) default '청주';

-- 성별(gender)필드 추가(add column)
alter table hoiwon add column gender char(2) default '여자';

-- hoiwon 테이블을 exam 테이블로 이름변경(rename)
alter table hoiwon rename exam;
alter table exam rename hoiwon;

-- exam테이블을 삭제하시오(구조를 완전삭제)
drop table aaa;

-----------------------------------------------------------------------------------
-- DML(데이터 조작어)

desc hoiwon;

// hoiwon테이블 내용보기
select * from hoiwon;

insert into hoiwon values (default,'가나다', 55, '제주');

-- hoiwon테이블의 '성명/나이' 정보의 모든 레코드를 보여주시오.
select name,age from hoiwon;

-- 홍길동의 나이를 25세로 변경(update 테이블명 set 필드명='변경내용' where __조건__;)
update test1 set age=25 where name='홍길동';

-- 홍길동의 성별을 남자로 변경
update test1 set gender='남자' where name='홍길동';

-- '이기자'의 성별을 남자로 변경
update test1 set gender='남자' where name='이기자';

-- '소나무/대나무/가나다/나나나/마마마'의 성별을 '남자'로 변경
update test1 set gender='남자' where name='소나무' or name='대나무' or name='가나다' or name='나나나' or name='마마마';

-- '파파파/차차차/사사사'의 성별을 '남자'로 변경
update test1 set gender='남자' where name in ('파파파','차차차','사사사');

-- 정렬 : order by 필드명 옵션___ : 옵션생략시는 오름차순(asc), 내림차순(desc)
-- 성명 오름차순으로 출력?

select * from test1 order by name;
select * from test1 order by name desc;

-- 나이 내림차순 ...
select * from test1 order by age desc;

-- 성별 오름차순 ...
select * from test1 order by gender;

-- 성별 오름차순 ... 그런데, 성별이 같으면 두번째 키는 성명 내림차순 출력 .....
select * from test1 order by gender, name desc;

-- 성별 내림차순 출력, 단 성별이 같으면 나이가 적은사람을 우선적으로 출력하시오.
select * from test1 order by gender desc, age;

-- 1차 성별 내림차순, 2차 주소 오름차순, 3차 나이 내림차순, 4차 idx내림차순 출력하시오.
select * from test1 order by gender desc, address, age desc, idx desc;

-- 나이가 30대만 출력하시오?(30~39) : between __ and __
select * from test1 where age >= 30 and age < 40;
select * from test1 where age between 30 and 39;

-- 나이가 30대이면서 남자만 출력하시오?(30~39)
select * from test1 where age >= 30 and age < 40 and gender='남자';

-- 나이가 30대이면서 남자만 이름 내림차순 출력하시오?(30~39)
select * from test1 where age >= 30 and age < 40 and gender='남자' order by name desc;

-- 나이가 30대 이거나 50대 인 자료만 출력?
select * from test1 where (age >= 30 and age < 40) or (age >= 50 and age < 60);

-- 서울에 살거나 부산에 사는 사람을 출력?
select * from test1 where address='서울' or address='청주';
select * from test1 where address in ('서울', '청주');

-- 서울에 살거나 청주에 사는 사람중에서 나이가 20대 이하만 출력?
select * from test1 where address='서울' or address='청주' and age <= 20;
select * from test1 where address in ('서울', '청주') and age <= 20;

-- 서울에 살거나 나이가 20대인 남자만 출력?
select * from test1 where address='서울' or (age >= 20 and age < 30) and gender='남자';

-- '성'이 '가'씨만 출력?(like연산자 : %(복수개의 와일드카드)), _(단수개의 와일드카드)
select * from test1 where name like '가%';

-- 주소의 마지막 글자가 '주'로 끝나는 자료 출력?
select * from test1 where address like '%주'

-- 이름중에서 '나'자를 포함한 모든 자료 출력?
select * from test1 where name like '%나%';

-- 이름중에서 두번째 글짜가 '나'자를 포함한 모든 자료 출력?
select * from test1 where name like '_나%';

-- 이름중에서 두번째 글짜가 '나'자를 포함한 자료의 '성명/주소'를 출력?
select name, address from test1 where name like '_나%';

-- 자료를 10개만 출력하시오?(제한 : limit)
select * from test1 limit 10;

-- 인덱스번호 4에서부터 5개?
select * from test1 limit 4,5;

-- 주소의 마지막 글자가 '주'로 끝나는 자료의 나이를 1살씩 추가해 주시오?
update test1 set age=age+1 where address like '%주'

-- 서울에 사는 남자?
select * from test1 where address='서울' and gender='남자';

-- 서울에 사는 남자를 삭제하시오?
delete from test1 where address='서울' and gender='남자';

-- 나이가 많은 사람 5명만 출력하세요?
select * from test1 order by age desc limit 5;