package org.enter;

import java.sql.Connection;
import java.sql.DriverManager;



public class AboutDB {
	static private String url="jdbc:sqlserver://localhost:1433;DataBaseName=HMS;encrypt=true;trustServerCertificate=true";//后面两个参数是抄来的，好像这样就不会安全检查
	static private String userName="sa";	
	static private String pwd="123";
	static private Connection conn=null;

	public static Connection loginDB(){
		try {//此处数据库参考数据库课本P190
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");											
			conn=DriverManager.getConnection(url,userName,pwd);
			return conn;
			
		}catch(Exception ee) {ee.printStackTrace();}
		return conn;
	}
	
	
}
