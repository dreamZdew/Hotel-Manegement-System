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
		try {//���ݿ�д���������
			Connection conn = AboutDB.loginDB();
			PreparedStatement prep = conn
					.prepareStatement("select ����,���֤��,���˱��,�ֻ��� from Customer where ����= ? and ���֤��= ? ");
			prep.setString(1, customer.getName());
			prep.setString(2, customer.getId());
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {// ���ݿ������д˿ͻ�
				customer.setNumber(rs.getString(3));
				String tempphone = rs.getString(4);
				// �������ݿ��е��ֻ���
				if (!customer.getPhone().equals("")) {// ��������Ϊ�գ���д�����ݿ�
					prep = conn.prepareStatement("update Customer set �ֻ���=? where ����= ? and ���֤��= ?   ");
					prep.setString(1, customer.getPhone());
					prep.setString(2, customer.getName());
					prep.setString(3, customer.getId());
					prep.executeUpdate();
					prep.close();
					rs.close();
				} else// �����ȡ���ݿ��е��ֻ���
					customer.setPhone(tempphone);
				prep.close();
				conn.close();
			} else {// ���ɿ��˱�ţ��������ݿ�
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
			// TODO �Զ����ɵ� catch ��
			ee.printStackTrace();
		}
		return customer;
	}
	
	
}
