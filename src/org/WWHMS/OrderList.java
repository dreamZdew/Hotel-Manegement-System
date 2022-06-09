package org.WWHMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderList {
	private String number;
	private String ordertime;
	private String customernumber;
	private String roomnumber;
	private String intime;
	private String outtime;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getCustomernumber() {
		return customernumber;
	}

	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public static void addtoDatabase(OrderList orderlist) {
		try {//数据库写入数据
			Connection conn = AboutDB.loginDB();
			PreparedStatement prep = conn
					.prepareStatement("insert into OrderList values(?,?,?,?,?,?,?)");
			prep.setString(1,orderlist.getNumber() );
			prep.setString(2,orderlist.getOrdertime() );
			prep.setString(3, orderlist.getCustomernumber());
			prep.setString(4, orderlist.getRoomnumber());
			prep.setString(5, orderlist.getIntime());
			prep.setString(6, orderlist.getOuttime());
			prep.setString(7, "3");//这里加触发器让数据库判断订单状态
			prep.executeUpdate();
			

		} catch (SQLException ee) {
			// TODO 自动生成的 catch 块
			ee.printStackTrace();
		}
		
	}
	
}
