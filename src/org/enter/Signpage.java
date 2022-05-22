package org.enter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/*注册界面*/
/*这个注册是给管理员注册*/

public class Signpage extends Shell {

	private Text text_username;
	private Text text_password;
	private Connection conn;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Signpage shell = new Signpage(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Signpage(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("注册界面");
		setSize(800, 450);
		
		text_username = new Text(this, SWT.BORDER);
		text_username.setBounds(358, 197, 126, 23);
		
		text_password = new Text(this, SWT.BORDER);
		text_password.setBounds(358, 258, 126, 23);
		
		Label label_username = new Label(this, SWT.NONE);
		label_username.setAlignment(SWT.CENTER);
		label_username.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label_username.setBounds(274, 199, 78, 32);
		label_username.setText("用户名");
		
		Label label_password = new Label(this, SWT.NONE);
		label_password.setText("密码");
		label_password.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label_password.setAlignment(SWT.CENTER);
		label_password.setBounds(274, 258, 78, 32);
		
		Label label_tip = new Label(this, SWT.NONE);
		label_tip.setFont(SWTResourceManager.getFont("黑体", 25, SWT.NORMAL));
		label_tip.setAlignment(SWT.CENTER);
		label_tip.setBounds(200, 41, 384, 111);
		label_tip.setText("用户名为五字符以上的字母数字下划线组合，密码不少于6位");
		
		Label warn = new Label(this, SWT.NONE);
		warn.setAlignment(SWT.CENTER);
		warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		warn.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		warn.setBounds(295, 229, 217, 23);

		Button button_tosign = new Button(this, SWT.NONE);
		button_tosign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//注册
				
				String username=text_username.getText();
				String password=text_password.getText();
				
				
				if(username.length()<=5||password.length()<6) {//长度条件
					warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					warn.setText("注册失败");
					text_username.setFocus();
					Runnable timer = new Runnable() {
						@Override
						public void run() {if(!isDisposed())warn.setText("");}
					};
					Display.getDefault().timerExec(3000, timer);
				}
				else {
					 conn=AboutDB.loginDB();
						Statement Stmt;
						String sqlQuery;
						try {//与已有用户名比较，防止重复
							Stmt = conn.createStatement();
							sqlQuery="select 用户名 from UserPass";//查询指令
							Boolean cansign=true;
							ResultSet rs=Stmt.executeQuery(sqlQuery);
							while(rs.next()) {
								if(username.equals(rs.getString(1))){//用户名重复
									warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
									warn.setText("用户名已存在，注册失败");
									text_username.setFocus();
									Runnable timer = new Runnable() {
										@Override
										public void run() {if(!isDisposed())warn.setText("");}
									};
									Display.getDefault().timerExec(3000, timer);
									cansign=false;
									break;
								}
							}
							if(cansign.equals(true)) {//满足注册条件，写入数据库
								sqlQuery="use HMS insert into UserPass values("+username+","+password+")";//写入数据库指令
								Stmt.executeUpdate(sqlQuery);
								warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
								warn.setText("注册成功");
								Runnable timer = new Runnable() {
									@Override
									public void run() {if(!isDisposed())warn.setText("");}
								};
								Display.getDefault().timerExec(3000, timer);
							}
							
							
						} catch (SQLException ee) {warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));warn.setText("无法连接到服务器");}
						
				}
				
			}
		});
		button_tosign.setBounds(422, 319, 80, 27);
		button_tosign.setText("注册");
		button_tosign.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		
		Button button_returnenter = new Button(this, SWT.NONE);
		button_returnenter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//返回登陆界面
				
			    close();
			    try {
					Enter window = new Enter();
					window.open();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			
			}
		});
		button_returnenter.setText("返回");
		button_returnenter.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_returnenter.setBounds(270, 319, 80, 27);


		
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
