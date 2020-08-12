--tbl_reply 테이블 생성
create table tbl_reply(
 rno number(38) primary key --댓글번호, number(38)은 오라클 자료형으로 최대 자리수 38자
 --까지 정수숫자값을 저장할 수 있다. primary key는 기본키 제약조건으로 중복번호 금지, null금지
 ,bno number(38) default 0 --bno컬럼은 외래키 제약조건을 설정. tbl_board 게시판 테이블
 --의 번호값만 저장됨. 즉 tbl_board테이블의 bno컬럼 번호가 주인키가 되는 것이고, tbl_reply테이블
 --컬럼의 bno는 종속키가 된다.
 ,replyer varchar2(100) not null --댓글 작성자
 ,replytext varchar2(4000) not null --댓글 내용
 ,regdate date --댓글 등록 날짜, date는 오라클 날짜타입
 ,updatedate date --댓글 수정 날짜
);

select * from tbl_reply order by rno desc;
--order by 정렬문으로 rno댓글번호를 기준으로 내림차순정렬하면 큰숫자번호가 먼저 정렬된다
--반대는 오름차순 정렬(asc:생략가능하다.)

--bno컬럼에 외래키 설정
alter table tbl_reply add constraint fk_board
foreign key(bno) references tbl_board(bno);
--foreign key는 외래키

--rno_seq 댓글 시퀀스 생성
create sequence rno_seq
start with 1 --1부터 시작
increment by 1 --1씩 증가
nocache; --임시 메로리를 사용하지 않겠다는 뜻

--rno_seq 시퀀스 번호값 확인
select rno_seq.nextval from dual;
--시퀀스명.nextval로 시퀀스 다음번호 값을 확인.





