declare @in datetime,@out datetime
set @in='2022-6-8'
set @out='2022-6-10'


select ������ from Room where ��������='���˼�' and ������ not in

(select distinct a.������ from OrderList a join Room b on a.������=b.������ and ��������='���˼�' and ((@out>=��סʱ�� and @out<=�˷�ʱ��) or (@in>=��סʱ�� and @in<=�˷�ʱ��)) and (����״̬=3 or ����״̬=2 or ����״̬=1))