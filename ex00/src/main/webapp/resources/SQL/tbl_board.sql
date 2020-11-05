 create table tbl_board(
 bno number(38) primary key --number(38)은 오라클 자료형으로 최대 자리수 38자까지 정수 번호값을 저장할 수 있다.
 --오라클 가변문자 타입.primary key제약조건은 중복아이디 저장금지, null저장금지
 ,writer varchar2(200) not null --작성자, varchar2는 오라클 가변문자 타입, not null
 --제약조건은 중복자료는 저장을 허용하고 null은 금지
 ,title varchar2(300) not null --제목
 ,content varchar2(4000) not null --내용
 ,viewcnt number(38) default 0 --조회수, default 0 제약조건은 굳이 레코드 값을 지정하지 않아도
 --기본 정수번호값 0이 저장됨.
 ,regdate date --등록 날짜, date는 오라클 날짜타입 
 );
 
 select * from tbl_board order by bno desc;--order by는 정렬문이다. 번호값을 기준으로
 --내림차순정렬(desc), 오름차순정렬(asc:생략가능)
 
 /* 오라클 시퀀스 특징
  *  1.시퀀스는 번호발생기이다. 주로 게시판 번호값 저장용도로 활용됨. 1부터 시작해서 1씩 증가되고,
  * 중복번호값이 없고 한번 발생된 번호값은 다시 발생되지 않는 특징이 있다.
  *  
  *  2.중간에 빈값 번호값이 없다.
  */
 
--bno_seq 시퀀스 생성
create sequence bno_seq
start with 1 --1부터 시작하라는 옵션
increment by 1 --1씩 증가하라는 옵션
nocache; --임시 저장장소를 사용하지 않겠다는 뜻

--시퀀스 번호값 확인
select bno_seq.nextval from dual;
