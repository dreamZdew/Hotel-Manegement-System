package org.enter;

import java.sql.Connection;
import java.sql.DriverManager;



public class AboutDB {
	static private String url="jdbc:sqlserver://localhost:1433;DataBaseName=HMS;encrypt=true;trustServerCertificate=true";//�������������ǳ����ģ����������Ͳ��ᰲȫ���
	static private String userName="sa";	
	static private String pwd="123";
	static private Connection conn=null;

	public static Connection loginDB(){
		try {//�˴����ݿ�ο����ݿ�α�P190
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");											
			conn=DriverManager.getConnection(url,userName,pwd);
			return conn;
			
		}catch(Exception ee) {ee.printStackTrace();}
		return conn;
	}
	
	
}
