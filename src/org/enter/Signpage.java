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

/*ע�����*/
/*���ע���Ǹ�����Աע��*/

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
		setText("ע�����");
		setSize(800, 450);
		
		text_username = new Text(this, SWT.BORDER);
		text_username.setBounds(358, 197, 126, 23);
		
		text_password = new Text(this, SWT.BORDER);
		text_password.setBounds(358, 258, 126, 23);
		
		Label label_username = new Label(this, SWT.NONE);
		label_username.setAlignment(SWT.CENTER);
		label_username.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));
		label_username.setBounds(274, 199, 78, 32);
		label_username.setText("�û���");
		
		Label label_password = new Label(this, SWT.NONE);
		label_password.setText("����");
		label_password.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));
		label_password.setAlignment(SWT.CENTER);
		label_password.setBounds(274, 258, 78, 32);
		
		Label label_tip = new Label(this, SWT.NONE);
		label_tip.setFont(SWTResourceManager.getFont("����", 25, SWT.NORMAL));
		label_tip.setAlignment(SWT.CENTER);
		label_tip.setBounds(200, 41, 384, 111);
		label_tip.setText("�û���Ϊ���ַ����ϵ���ĸ�����»�����ϣ����벻����6λ");
		
		Label warn = new Label(this, SWT.NONE);
		warn.setAlignment(SWT.CENTER);
		warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		warn.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));
		warn.setBounds(295, 229, 217, 23);

		Button button_tosign = new Button(this, SWT.NONE);
		button_tosign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//ע��
				
				String username=text_username.getText();
				String password=text_password.getText();
				
				
				if(username.length()<=5||password.length()<6) {//��������
					warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					warn.setText("ע��ʧ��");
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
						try {//�������û����Ƚϣ���ֹ�ظ�
							Stmt = conn.createStatement();
							sqlQuery="select �û��� from UserPass";//��ѯָ��
							Boolean cansign=true;
							ResultSet rs=Stmt.executeQuery(sqlQuery);
							while(rs.next()) {
								if(username.equals(rs.getString(1))){//�û����ظ�
									warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
									warn.setText("�û����Ѵ��ڣ�ע��ʧ��");
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
							if(cansign.equals(true)) {//����ע��������д�����ݿ�
								sqlQuery="use HMS insert into UserPass values("+username+","+password+")";//д�����ݿ�ָ��
								Stmt.executeUpdate(sqlQuery);
								warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
								warn.setText("ע��ɹ�");
								Runnable timer = new Runnable() {
									@Override
									public void run() {if(!isDisposed())warn.setText("");}
								};
								Display.getDefault().timerExec(3000, timer);
							}
							
							
						} catch (SQLException ee) {warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));warn.setText("�޷����ӵ�������");}
						
				}
				
			}
		});
		button_tosign.setBounds(422, 319, 80, 27);
		button_tosign.setText("ע��");
		button_tosign.setFont(SWTResourceManager.getFont("����", 11, SWT.NORMAL));
		
		Button button_returnenter = new Button(this, SWT.NONE);
		button_returnenter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//���ص�½����
				
			    close();
			    try {
					Enter window = new Enter();
					window.open();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			
			}
		});
		button_returnenter.setText("����");
		button_returnenter.setFont(SWTResourceManager.getFont("����", 11, SWT.NORMAL));
		button_returnenter.setBounds(270, 319, 80, 27);


		
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
