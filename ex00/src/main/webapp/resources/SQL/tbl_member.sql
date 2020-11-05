--명령어 실행 단축키 Alt+X--

--tbl_member테이블 생성. 한줄 주석문기호
create table tbl_member(
 userid varchar2(50) primary key --회원아이디. varchar2는
 --오라클 가변문자 타입.primary key제약조건은 중복아이디 저장금지, null저장금지
 ,userpw varchar2(50) not null --회원비번, not null제약조건은 빈값금지(null저장금지)
 ,username varchar2(50) not null --회원이름
 ,email varchar2(100) --이메일
 ,regdate date --가입날짜, date는 날짜타입
 ,updatedate date --수정날짜, 
 );
 
 select * from tbl_member; --테이블의 모든 컬럼(필드) 자료를 검색
 
 --sysdate 오라클 날짜함수
 select sysdate from dual;
 /* 오라클 날짜함수 : sysdate
  * mysql 날짜함수 : now()
  * dual테이블은 오라클 설치시 설치되는 임시테이블로서 주로 오라클 함수, 연산, 
  * 객제 시퀀스 값 등 확인용도로 사용된다.
  * 시퀀스란 오라클에서 번호 발생기이다. 주로 게시판 번호값 저장용도로 활용된다.
  */
 
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

