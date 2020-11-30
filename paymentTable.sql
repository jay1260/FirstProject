-- NUM : �⺻Ű
-- ID : member ���̺� ID ����
-- regDate : Date�� �ƴ� String ���·� ���
-- time : String ���·� ���
-- name : ���� ������ Ʈ���̳� �̸����� ���
-- kind : ���� ������ Ʈ���̳��� � ������ ���
-- business : ���� ������ Ʈ���̳��� ���� ���η� ���
create table payment(
    num number constraint payment_num_pk primary key,
    id varchar2(200) constraint payment_id_fk references member(id) on delete cascade,
    regDate varchar2(200),
    time varchar2(200),
    name varchar2(200),
    kind varchar2(200),
    business varchar2(200)
);

-- payment num Sequence
create sequence pay_test_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache
;
