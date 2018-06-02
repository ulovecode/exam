# exam
###exam考试系统后端
####使用技术:
    swagger2
    springboot
    redis
    oracle
    vue前后端分离
    定时器
    ....
    
####数据库脚本
 ```

create table USER_INFO
(
  USERID       VARCHAR2(30)                      not null
    primary key,
  REALNAME     VARCHAR2(50)                      not null,
  PASSWD       VARCHAR2(30) default '123456'     not null,
  LOGIN_DTIME  TIMESTAMP(6) default systimestamp not null,
  LOGOUT_DTIME TIMESTAMP(6) default systimestamp not null,
  LOGIN_HOST   VARCHAR2(30) default '127.0.0.1'  not null
)
/

create table STUDENT
(
  SNO              VARCHAR2(20)                      not null
    primary key,
  IDNO             VARCHAR2(30)
    unique,
  PASSWD           VARCHAR2(30) default '123456'     not null,
  MAJOR            VARCHAR2(100)                     not null,
  CLASSNO          VARCHAR2(20)                      not null,
  SNAME            VARCHAR2(100)                     not null,
  PYNAME           VARCHAR2(20),
  GENDER           VARCHAR2(10)                      not null
    check (gender in ('男', '女')),
  BIRTHDAY         VARCHAR2(20)                      not null,
  HIGH_SCHOOL      VARCHAR2(80)                      not null,
  HIGH_SCORE       NUMBER(9) default 0               not null,
  INSOURCE         VARCHAR2(20)                      not null,
  INTYPE           VARCHAR2(20)                      not null,
  NATION           VARCHAR2(20),
  POLITICAL_STATUS VARCHAR2(30),
  TEL              VARCHAR2(20)                      not null,
  QQ               VARCHAR2(30),
  EMAIL            VARCHAR2(100),
  DESCRIPT         VARCHAR2(1000),
  REC_DTIME        TIMESTAMP(6) default SYSTIMESTAMP not null,
  PIC              VARCHAR2(100) default NULL
)
/

create table COURSE
(
  COURSE_ID NUMBER(9) generated as identity
    primary key,
  CNAME     VARCHAR2(100) not null
    unique,
  CTYPE     VARCHAR2(20),
  CREDIT    NUMBER(9)
    check (credit > 0 and credit < 10),
  TIMES     NUMBER(9)
    check (times > 0 and times < 200),
  STAGE     VARCHAR2(30),
  DESCRIPT  VARCHAR2(1000)
)
/

create table ITEM
(
  ITEM_ID    NUMBER(18) generated as identity
    primary key,
  COURSE_ID  NUMBER(9)                         not null
    references COURSE,
  ITEM_TYPE  VARCHAR2(10)                      not null
    check (item_type in ('单选', '多选')),
  QUESTION   VARCHAR2(4000)                    not null,
  OPTIONA    VARCHAR2(200)                     not null,
  OPTIONB    VARCHAR2(200)                     not null,
  OPTIONC    VARCHAR2(200)                     not null,
  OPTIOND    VARCHAR2(200)                     not null,
  OPTIONE    VARCHAR2(200),
  OPTIONF    VARCHAR2(200),
  OPTIONG    VARCHAR2(200),
  ANSWER     VARCHAR2(10),
  DIFFICULTY NUMBER(9)
    check (difficulty between 1 and 5),
  KNOWLEDGE  VARCHAR2(200),
  CLUE       VARCHAR2(1000),
  REC_DTIME  TIMESTAMP(6) default SYSTIMESTAMP not null
)
/

create table PAPER
(
  PAPER_ID  NUMBER(18) generated as identity
    primary key,
  COURSE_ID NUMBER(9)                         not null
    references COURSE,
  TITLE     VARCHAR2(50)                      not null
    unique,
  GRADE     VARCHAR2(10)                      not null,
  STAGE     VARCHAR2(50),
  TESTDATE  DATE,
  PSTATUS   VARCHAR2(30) default '待审核'        not null
    check (pstatus in ('待审核', '启用', '正考中', '正考完', '补考中', '补考结束')),
  DESCRIPT  VARCHAR2(3000),
  PAPERTIME TIMESTAMP(6) default SYSTIMESTAMP not null
)
/

create table PAPER_ITEM
(
  PAPER_ID NUMBER(18) not null
    references PAPER,
  ITEM_ID  NUMBER(18) not null
    references ITEM,
  primary key (PAPER_ID, ITEM_ID)
)
/

create table PAPER_ANSWER
(
  PAPER_ID NUMBER(18)   not null
    references PAPER,
  ITEM_ID  NUMBER(18)   not null
    references ITEM,
  SNO      VARCHAR2(20) not null
    references STUDENT,
  ANSWER   VARCHAR2(20) not null,
  ANSWER2  VARCHAR2(20),
  NOTE     VARCHAR2(20)
    check (note in ('正考', '补考')),
  primary key (PAPER_ID, ITEM_ID, SNO)
)
/

create table SCORE
(
  PAPER_ID NUMBER(18)   not null
    references PAPER,
  SNO      VARCHAR2(20) not null
    references STUDENT,
  ANSNUM   NUMBER(9)    not null
    check (ansnum >= 0),
  CORRECT  NUMBER(9)    not null
    check (correct >= 0),
  SCORE    NUMBER(9)    not null
    check (score >= 0),
  primary key (PAPER_ID, SNO)
)
/

create procedure pro_add_paper_itme(
  P_COURSE_ID in NUMBER,
  P_TITLE     in VARCHAR2,
  P_GRADE     in VARCHAR2,
  P_STAGE     in VARCHAR2,
  P_TESTDATE  in DATE,
  P_DESCRIPT  in VARCHAR2

) as
  V_PAPER_ID number;
  begin
    insert into PAPER (COURSE_ID, TITLE, GRADE, STAGE, TESTDATE, DESCRIPT)
    values (P_COURSE_ID, P_TITLE, P_GRADE, P_STAGE, P_TESTDATE, P_DESCRIPT);


    select "ISEQ$$_92004".currval
    into V_PAPER_ID
    from dual;
    insert into PAPER_ITEM (PAPER_ID, ITEM_ID)
      select
        V_PAPER_ID,
        ITEM_ID
      from ITEM
      where COURSE_ID = P_COURSE_ID AND ROWNUM <= 5;
    commit;
  end;
/

create procedure pro_delete_paper(
  P_PAPER_ID int
) as begin
  delete PAPER_ITEM
  WHERE PAPER_ID = P_PAPER_ID;
  delete PAPER
  where PAPER_ID = P_PAPER_ID;
  commit;
end;
/

create procedure pro_change_pstatus as
  begin
    update PAPER
    set PSTATUS = '正考完'
    where PAPER_ID in (
      select PAPER_ID
      from PAPER
      where PSTATUS = '正考中' and TESTDATE <= sysdate - 1 / 24 + 8 / 24
    );

    update PAPER
    set PSTATUS = '正考中'
    where PAPER_ID in (
      select PAPER_ID
      from PAPER
      where PSTATUS = '启用' and sysdate + 8 / 24 between TESTDATE and TESTDATE + 1 / 24
    );
    commit;
  end;
/


``` 