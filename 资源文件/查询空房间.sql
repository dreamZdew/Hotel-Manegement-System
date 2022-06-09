declare @in datetime,@out datetime
set @in='2022-6-8'
set @out='2022-6-10'


select 房间编号 from Room where 房间类型='单人间' and 房间编号 not in

(select distinct a.房间编号 from OrderList a join Room b on a.房间编号=b.房间编号 and 房间类型='单人间' and ((@out>=入住时间 and @out<=退房时间) or (@in>=入住时间 and @in<=退房时间)) and (订单状态=3 or 订单状态=2 or 订单状态=1))