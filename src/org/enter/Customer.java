package org.enter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	private String number;
	private String name;
	private String id;
	private String phone;
	private String gender;
	private String birthday;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public static Customer inputdata(Customer customer) {
		try {//数据库写入客人数据
			Connection conn = AboutDB.loginDB();
			PreparedStatement prep = conn
					.prepareStatement("select 姓名,身份证号,客人编号,手机号 from Customer where 姓名= ? and 身份证号= ? ");
			prep.setString(1, customer.getName());
			prep.setString(2, customer.getId());
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {// 数据库中已有此客户
				customer.setNumber(rs.getString(3));
				String tempphone = rs.getString(4);
				// 更新数据库中的手机号
				if (!customer.getPhone().equals("")) {// 如果输入框不为空，则写入数据库
					prep = conn.prepareStatement("update Customer set 手机号=? where 姓名= ? and 身份证号= ?   ");
					prep.setString(1, customer.getPhone());
					prep.setString(2, customer.getName());
					prep.setString(3, customer.getId());
					prep.executeUpdate();
					prep.close();
					rs.close();
				} else// 否则读取数据库中的手机号
					customer.setPhone(tempphone);
				prep.close();
				conn.close();
			} else {// 生成客人编号，存入数据库
				prep.close();
				rs.close();
				customer.setNumber(Long.toString(System.currentTimeMillis()));
				prep = conn.prepareStatement("insert into Customer values(?,?,?,?,?,?) ");
				prep.setString(1, customer.getNumber());
				prep.setString(2, customer.getName());
				prep.setString(3, customer.getId());
				prep.setString(4, customer.getPhone());
				prep.setString(5, customer.getGender());
				prep.setString(6, customer.getBirthday());
				prep.executeUpdate();
				prep.close();
				conn.close();
			}

		} catch (SQLException ee) {
			// TODO 自动生成的 catch 块
			ee.printStackTrace();
		}
		return customer;
	}
	
	
}
