--gongji.sql
create table gongji(--���� ���̺� �ۼ�
 gongji_no int primary key --��ȣ
 ,gongji_name varchar2(30) not null --���� �ۼ���
 ,gongji_title varchar2(200) not null --���� ����
 ,gongji_pwd varchar2(20) not null --���
 ,gongji_cont varchar2(4000) not null --��������
 ,gongji_hit int default 0 --��ȸ��
 ,gongji_date date --���� ��ϳ�¥
);

select * from gongji order by gongji_no desc;--������ȣ�� �������� �������� ����,
--�������� �����ϸ� ū���ڹ�ȣ�� ���� ���ĵȴ�.

--g_no_seq ������ ����
create sequence g_no_seq
start with 1 --1���� ����
increment by 1 --1�� ����
nocache;

select g_no_seq.nextval from dual;


/* ����) ������ MVC �������� �°� AdminGongjiController, AdminGongjiService,
 * AdminGongjiServiceImpl,AdminGongjiDAO,AdminGongjiDAOImpl,GongjiVO.java,
 * admin_gongji.xml, mybatis-config.xml�� GonjiVO��Ŭ���� ��ü ��Ī�� g���� ���弼��. 
 */





