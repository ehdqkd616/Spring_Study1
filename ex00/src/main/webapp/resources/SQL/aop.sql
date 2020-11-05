--tbl_user 테이블 생성
create table tbl_user(
 uid2 varchar2(50) primary key --회원아이디
 ,upw varchar2(50) not null --비번
 ,uname varchar2(100) not null --회원이름
 ,upoint number(38) default 0 --메시지가 보내지면 포인터 점수 10점 업데이트 수정
 --default 제약조건은 해당컬럼에 레코드를 저장하지 않아도 기본값 0이 저장됨.
);

select * from tbl_user;

insert into tbl_user (uid2,upw,uname) values('user00','5678','홍길동');
insert into tbl_user (uid2,upw,uname) values('user01','7777','이순신');

update tbl_user set upoint = 0;

--tbl_message 테이블 생성
create table tbl_message(
 mid number(38) primary key
 ,targetid varchar2(50) not null --외래키 제약조건 설정. tbl_user테이블의 uid2
 --컬럼 회원아이디값만 저장
 ,sender varchar2(50) not null --메시지를 보낸사람
 ,message varchar2(4000) not null --보낸 메시지
 ,senddate date --메시지를 보낸 날짜
);

select * from tbl_message;

delete from tbl_message;

drop table tbl_message;--테이블 삭제

--외래키 제약조건 설정
alter table tbl_message add constraint fk_usertarget
foreign key(targetid) references tbl_user(uid2);
--tbl_user테이블의 uid2컬럼에 저장된 회원아이디값만 저장됨.

--mid_no_seq 시퀀스 생성
create sequence mid_no_seq
start with 1 --1부터 시작
increment by 1 --1씩증가
nocache; --임시 저장장소를 사용하지 않겠다

--mid_no_seq 라는 시퀀스 번호값 확인
select mid_no_seq.nextval from dual;

--tbl_board 테이블에 댓글수를 카운터 해서 저장하는 replycnt 컬럼추가
alter table tbl_board
add (replycnt number(38) default 0);
--댓글이 추가되면 +1, 댓글을 삭제하면 -1

select * from tbl_board order by bno desc;

--tbl_reply,tbl_board 테이블의 댓글 개수를 일치되게 변경
update tbl_board set replycnt=(select count(rno) from tbl_reply
where bno=tbl_board.bno)
where bno>0;



