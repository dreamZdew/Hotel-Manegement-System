CREATE TRIGGER OrderStatementTrig 
 ON OrderList 
 AFTER  INSERT, UPDATE
 AS  
 begin
 declare @now datetime
 set @now=GETDATE()
 update OrderList
 set 订单状态=3
 where 入住时间>@now and 订单状态!=0
  update OrderList
 set 订单状态=2
 where 入住时间<=@now and 退房时间>=@now and 订单状态!=0
  update OrderList
 set 订单状态=1
 where 退房时间<@now and 订单状态!=0
 end
