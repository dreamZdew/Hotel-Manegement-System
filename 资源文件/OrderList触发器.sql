CREATE TRIGGER OrderStatementTrig 
 ON OrderList 
 AFTER  INSERT, UPDATE
 AS  
 begin
 declare @now datetime
 set @now=GETDATE()
 update OrderList
 set ����״̬=3
 where ��סʱ��>@now and ����״̬!=0
  update OrderList
 set ����״̬=2
 where ��סʱ��<=@now and �˷�ʱ��>=@now and ����״̬!=0
  update OrderList
 set ����״̬=1
 where �˷�ʱ��<@now and ����״̬!=0
 end
