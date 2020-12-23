--gongji.sql
create table gongji(--공지 테이블 작성
 gongji_no int primary key --번호
 ,gongji_name varchar2(30) not null --공지 작성자
 ,gongji_title varchar2(200) not null --공지 제목
 ,gongji_pwd varchar2(20) not null --비번
 ,gongji_cont varchar2(4000) not null --공지내용
 ,gongji_hit int default 0 --조회수
 ,gongji_date date --공지 등록날짜
);

select * from gongji order by gongji_no desc;--공지번호를 기준으로 내림차순 정렬,
--내림차순 정렬하면 큰숫자번호가 먼저 정렬된다.

--g_no_seq 시퀀스 생성
create sequence g_no_seq
start with 1 --1부터 시작
increment by 1 --1씩 증가
nocache;

select g_no_seq.nextval from dual;


/* 문제) 스프링 MVC 순서도에 맞게 AdminGongjiController, AdminGongjiService,
 * AdminGongjiServiceImpl,AdminGongjiDAO,AdminGongjiDAOImpl,GongjiVO.java,
 * admin_gongji.xml, mybatis-config.xml에 GonjiVO빈클래스 객체 별칭명 g까지 만드세요. 
 */