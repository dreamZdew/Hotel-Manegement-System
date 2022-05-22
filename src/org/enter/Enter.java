package org.enter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;




/*��¼����*/

public class Enter {

	protected Shell shell;
	private Text text_username;
	private Text text_password;
	private Connection conn;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Enter window = new Enter();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 450);
		shell.setText("��ӭ����Ƶ����ϵͳ");
		
		text_username = new Text(shell, SWT.BORDER);
		text_username.setBounds(358, 197, 126, 23);
		
		text_password = new Text(shell, SWT.BORDER);
		text_password.setBounds(358, 258, 126, 23);
		
		Label label_username = new Label(shell, SWT.NONE);
		label_username.setAlignment(SWT.CENTER);
		label_username.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));
		label_username.setBounds(274, 199, 78, 32);
		label_username.setText("�û���");
		
		Label label_password = new Label(shell, SWT.NONE);
		label_password.setText("����");
		label_password.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));
		label_password.setAlignment(SWT.CENTER);
		label_password.setBounds(274, 258, 78, 32);
		
		Label label_title = new Label(shell, SWT.NONE);
		label_title.setAlignment(SWT.CENTER);
		label_title.setFont(SWTResourceManager.getFont("����", 50, SWT.NORMAL));
		label_title.setBounds(170, 49, 444, 89);
		label_title.setText("��������");
		
		Label warn = new Label(shell, SWT.NONE);
		warn.setAlignment(SWT.CENTER);
		warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		warn.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));
		warn.setBounds(267, 229, 250, 23);
		
		Button button_signup = new Button(shell, SWT.NONE);
		button_signup.addSelectionListener(new SelectionAdapter() {//����ע�ᰴť��ת��ע�����
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shell.close();
				try {
					Display display = Display.getDefault();
					Signpage signpage = new Signpage(display);
					signpage.open();
					signpage.layout();
					while (!signpage.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception ee) {ee.printStackTrace();}
				
			}
		});
		
		Button button_login = new Button(shell, SWT.NONE);
		button_login.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//���Ĵ洢�û���������
				
				String username=text_username.getText();
				String password=text_password.getText();
				
				try {//�˴����ݿ�ο����ݿ�α�P190

					conn=AboutDB.loginDB();
					Statement Stmt = conn.createStatement();
					String sqlQuery="select * from UserPass";//��ѯָ��
					ResultSet rs=Stmt.executeQuery(sqlQuery);
					while(rs.next()) {
						if(username.equals(rs.getString(1))&&password.equals(rs.getString(2))){//��¼�ж� �����õ��û��������� test 123��test2 123
							rs.close();Stmt.close();conn.close();
							shell.close();
							
							/*��������*/
							try {
							Display display = Display.getDefault();
							Main main = new Main(display);
							main.open();
							main.layout();
							while (!main.isDisposed()) {
								if (!display.readAndDispatch()) {
									display.sleep();
								}
							}
							}catch(Exception ee) {ee.printStackTrace();}
							
							
							break;
							
						}
					}
					if(text_username.getVisible()==true) {
						warn.setText("��½ʧ�ܣ��û��������벻��ȷ");
						text_username.setFocus();
						
						
						Runnable timer = new Runnable() {
							@Override
							public void run() {if(!shell.isDisposed())warn.setText("");}
						};
						
						Display.getDefault().timerExec(3000, timer);
						

					
					}
				
					
				}catch(Exception ee) {warn.setText("�޷����ӵ�������");}
				
			}
		});
		
		button_login.setFont(SWTResourceManager.getFont("����", 11, SWT.NORMAL));
		button_login.setBounds(274, 338, 80, 27);
		button_login.setText("��¼");
		

		button_signup.setText("ע��");
		button_signup.setFont(SWTResourceManager.getFont("����", 11, SWT.NORMAL));
		button_signup.setBounds(404, 338, 80, 27);

	}
}
