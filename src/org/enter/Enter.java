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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FillLayout;

/*��¼����*/

public class Enter {

	protected Shell shell;
	private Text text_username;
	private Text text_password;
	private Connection conn;

	/**
	 * Launch the application.
	 * 
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
		shell.setLayout(new FormLayout());

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FormLayout());
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0);
		fd_composite.bottom = new FormAttachment(0, 394);
		fd_composite.right = new FormAttachment(0, 778);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);

		Label label_title = new Label(composite, SWT.NONE);
		FormData fd_label_title = new FormData();
		fd_label_title.bottom = new FormAttachment(0, 130);
		fd_label_title.right = new FormAttachment(0, 611);
		fd_label_title.top = new FormAttachment(0, 10);
		fd_label_title.left = new FormAttachment(0, 167);
		label_title.setLayoutData(fd_label_title);
		label_title.setAlignment(SWT.CENTER);
		label_title.setFont(SWTResourceManager.getFont("����", 50, SWT.NORMAL));
		label_title.setText("��������");

		Label warn = new Label(composite, SWT.NONE);
		FormData fd_warn = new FormData();
		fd_warn.bottom = new FormAttachment(0, 313);
		fd_warn.right = new FormAttachment(0, 650);
		fd_warn.top = new FormAttachment(0, 290);
		fd_warn.left = new FormAttachment(0, 128);
		warn.setLayoutData(fd_warn);
		warn.setAlignment(SWT.CENTER);
		warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		warn.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));

		Composite composite_Button = new Composite(composite, SWT.NONE);
		FormData fd_composite_Button = new FormData();
		fd_composite_Button.right = new FormAttachment(0, 569);
		fd_composite_Button.top = new FormAttachment(0, 319);
		fd_composite_Button.left = new FormAttachment(0, 209);
		composite_Button.setLayoutData(fd_composite_Button);
		RowLayout rl_composite_Button = new RowLayout(SWT.HORIZONTAL);
		rl_composite_Button.wrap = false;
		rl_composite_Button.pack = false;
		rl_composite_Button.justify = true;
		composite_Button.setLayout(rl_composite_Button);

		Button button_login = new Button(composite_Button, SWT.NONE);
		button_login.setLayoutData(new RowData(77, SWT.DEFAULT));
		button_login.setBounds(274, 338, 80, 27);
		button_login.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// ���Ĵ洢�û���������

				String username = text_username.getText();
				String password = text_password.getText();
				if (!username.equals("") && !password.equals("")) {
					try {// �˴����ݿ�ο����ݿ�α�P190

						conn = AboutDB.loginDB();
						Statement Stmt = conn.createStatement();
						String sqlQuery = "select �û���,���� from UserPass where �û���='"+username+"' and ���� = '" + password
								+ "' ";// ��ѯָ��
						ResultSet rs = Stmt.executeQuery(sqlQuery);
						while (rs.next()) {
							if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {// ��¼�ж�
								rs.close();
								Stmt.close();
								conn.close();
								shell.close();

								/* �������� */
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
								} catch (Exception ee) {
									ee.printStackTrace();
								}

								break;

							}
						}
						if (!shell.isDisposed()) {
							warn.setText("��½ʧ�ܣ��û��������벻��ȷ");
							text_username.setFocus();

							Runnable timer = new Runnable() {
								@Override
								public void run() {
									if (!shell.isDisposed())
										warn.setText("");
								}
							};

							Display.getDefault().timerExec(3000, timer);

						}

					} catch (Exception ee) {
						warn.setText("�޷����ӵ�������");
						ee.printStackTrace();
					}
				} else {
					warn.setText("�û��������벻��Ϊ��");
					Runnable timer = new Runnable() {
						@Override
						public void run() {
							if (!shell.isDisposed())
								warn.setText("");
						}
					};
					Display.getDefault().timerExec(3000, timer);
				}
			}
		});

		button_login.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));
		button_login.setText("��¼");

		Button button_signup = new Button(composite_Button, SWT.NONE);
		button_signup.setBounds(404, 338, 80, 27);
		button_signup.addSelectionListener(new SelectionAdapter() {// ����ע�ᰴť��ת��ע�����
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
				} catch (Exception ee) {
					ee.printStackTrace();
				}

			}
		});

		button_signup.setText("ע��");
		button_signup.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(0, 248);
		fd_composite_1.right = new FormAttachment(0, 498);
		fd_composite_1.top = new FormAttachment(0, 158);
		fd_composite_1.left = new FormAttachment(0, 280);
		composite_1.setLayoutData(fd_composite_1);
		composite_1.setLayout(new FillLayout(SWT.VERTICAL));
		
		Composite composite_2 = new Composite(composite_1, SWT.NONE);
				RowLayout rl_composite_2 = new RowLayout(SWT.HORIZONTAL);
				rl_composite_2.justify = true;
				rl_composite_2.center = true;
				composite_2.setLayout(rl_composite_2);
		
				Label label_username = new Label(composite_2, SWT.NONE);
				label_username.setLayoutData(new RowData(50, 30));
				label_username.setAlignment(SWT.CENTER);
				label_username.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
				label_username.setText("�û���");
				
						text_username = new Text(composite_2, SWT.BORDER);
						text_username.setLayoutData(new RowData(130, SWT.DEFAULT));
		
		Composite composite_3 = new Composite(composite_1, SWT.NONE);
				RowLayout rl_composite_3 = new RowLayout(SWT.HORIZONTAL);
				rl_composite_3.center = true;
				rl_composite_3.justify = true;
				composite_3.setLayout(rl_composite_3);
		
				Label label_password = new Label(composite_3, SWT.NONE);
				label_password.setLayoutData(new RowData(50, 30));
				label_password.setText("����");
				label_password.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
				label_password.setAlignment(SWT.CENTER);
				
						text_password = new Text(composite_3, SWT.BORDER);
						text_password.setLayoutData(new RowData(130, SWT.DEFAULT));

	}
}
