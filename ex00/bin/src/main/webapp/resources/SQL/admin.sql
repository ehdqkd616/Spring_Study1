--admin.sql
create table admin(--관리자 테이블 생성
  admin_no number(38) 
  ,admin_id varchar2(50) primary key --관리자 아이디
  ,admin_pwd varchar2(100) not null --관리자 비번
  ,admin_name varchar2(100) not null --관리자 이름
  ,admin_date date --등록날짜
);

--admin_no_seq 시퀀스 생성
create sequence admin_no_seq
start with 1
increment by 1
nocache;

insert into admin values(admin_no_seq.nextval, 'admin','1234','관리자',
sysdate);

select * from admin;

-- 오라클 sysdate날짜함수 값을 확인
select sysdate from dual;

