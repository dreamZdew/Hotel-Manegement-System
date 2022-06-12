package org.WWHMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.FormAttachment;

/*主界面*/

public class AdminPage extends Shell {
	private Table table;
	private Text text_username;
	private Text text_password;
	private Text text_confirmpass;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			AdminPage shell = new AdminPage(display);
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
	 * 
	 * @param display
	 */
	public AdminPage(Display display) {

		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite.setLayout(new GridLayout(2, false));

		Composite composite_Buttons = new Composite(composite, SWT.NONE);
		composite_Buttons.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		composite_Buttons.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_composite_Buttons = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_composite_Buttons.heightHint = 384;
		composite_Buttons.setLayoutData(gd_composite_Buttons);

		Composite composite_MainofMain = new Composite(composite, SWT.NONE);
		composite_MainofMain.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		final StackLayout stackLayoutforMain = new StackLayout();
		composite_MainofMain.setLayout(stackLayoutforMain);

		GridData gd_composite_MainofMain = new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
		gd_composite_MainofMain.widthHint = 677;
		gd_composite_MainofMain.heightHint = 401;
		composite_MainofMain.setLayoutData(gd_composite_MainofMain);

		Composite composite_1 = new Composite(composite_MainofMain, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_1.setLayout(new BorderLayout(0, 0));

		Composite composite_2 = new Composite(composite_MainofMain, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		lblNewLabel.setBounds(0, 0, 61, 17);
		lblNewLabel.setText("2");

		Composite composite_3 = new Composite(composite_MainofMain, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_1 = new Label(composite_3, SWT.NONE);
		lblNewLabel_1.setBounds(0, 0, 61, 17);
		lblNewLabel_1.setText("3");

		Composite composite_4 = new Composite(composite_MainofMain, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_2 = new Label(composite_4, SWT.NONE);
		lblNewLabel_2.setLocation(106, 71);
		lblNewLabel_2.setSize(279, 133);
		lblNewLabel_2.setText("4");

		Composite composite_5 = new Composite(composite_MainofMain, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_5.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_9 = new Composite(composite_5, SWT.NONE);
		composite_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_9.setLayout(new FormLayout());

		Label warn = new Label(composite_9, SWT.NONE);
		warn.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		warn.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		warn.setAlignment(SWT.CENTER);
		FormData fd_warn = new FormData();
		fd_warn.left = new FormAttachment(0, 77);
		fd_warn.top = new FormAttachment(0, 290);
		fd_warn.right = new FormAttachment(0, 599);
		warn.setLayoutData(fd_warn);

		Composite composite_Button = new Composite(composite_9, SWT.NONE);
		composite_Button.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		fd_warn.bottom = new FormAttachment(composite_Button, -6);
		RowLayout rl_composite_Button = new RowLayout(SWT.HORIZONTAL);
		rl_composite_Button.wrap = false;
		rl_composite_Button.pack = false;
		rl_composite_Button.justify = true;
		composite_Button.setLayout(rl_composite_Button);
		FormData fd_composite_Button = new FormData();
		fd_composite_Button.top = new FormAttachment(0, 319);
		fd_composite_Button.left = new FormAttachment(0, 158);
		fd_composite_Button.right = new FormAttachment(0, 518);
		composite_Button.setLayoutData(fd_composite_Button);

		Button btnCheckButton = new Button(composite_Button, SWT.CHECK);
		btnCheckButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnCheckButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnCheckButton.setText("有管理员权限");

		Button button_tosign = new Button(composite_Button, SWT.NONE);
		button_tosign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// 注册用户

				String username = text_username.getText();
				String password = text_password.getText();

				if (username.length() <= 5 || password.length() < 6) {// 长度条件
					warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					warn.setText("注册失败");
					text_username.setFocus();
					Runnable timer = new Runnable() {
						@Override
						public void run() {
							if (!isDisposed())
								warn.setText("");
						}
					};
					Display.getDefault().timerExec(3000, timer);
				} else {
					Connection conn = AboutDB.loginDB();
					try {// 与已有用户名比较，防止重复

						PreparedStatement prep = conn.prepareStatement("select 用户名 from UserPass where 用户名= ? ");
						prep.setString(1, username);
						Boolean cansign = true;
						ResultSet rs = prep.executeQuery();
						while (rs.next()) {
							if (username.equals(rs.getString(1))) {// 用户名重复
								warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
								warn.setText("用户名已存在，注册失败");
								text_username.setFocus();
								Runnable timer = new Runnable() {
									@Override
									public void run() {
										if (!isDisposed())
											warn.setText("");
									}
								};
								Display.getDefault().timerExec(3000, timer);
								cansign = false;
								break;
							}
						}
						String confirmpass = text_confirmpass.getText();
						if (!confirmpass.equals(password)) {
							cansign = false;
							warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
							warn.setText("两次密码不一致，注册失败");
							text_username.setFocus();
							Runnable timer = new Runnable() {
								@Override
								public void run() {
									if (!isDisposed())
										warn.setText("");
								}
							};
							Display.getDefault().timerExec(3000, timer);
						}
						if (cansign == true) {// 满足注册条件，写入数据库
							String isadmin = "0";
							if (btnCheckButton.getSelection())
								isadmin = "1";
							String salt = MyDigest.usingUUID();
							int time = 10000;
							password = MyDigest.PBKDF2(password, salt, time);
							prep = conn.prepareStatement(" insert into UserPass values( ?, ?, ?, ?)");// 写入数据库指令
							prep.setString(1, username);
							prep.setString(2, password);
							prep.setString(3, salt);
							prep.setString(4, isadmin);
							prep.executeUpdate();

							warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
							warn.setText("注册成功");
							Runnable timer = new Runnable() {
								@Override
								public void run() {
									if (!isDisposed())
										warn.setText("");
								}
							};
							Display.getDefault().timerExec(3000, timer);
							prep.close();
							conn.close();
							rs.close();
						}

					} catch (SQLException ee) {
						warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
						warn.setText("无法连接到服务器");
						ee.printStackTrace();
					}

				}

			}
		});
		button_tosign.setLayoutData(new RowData(77, -1));
		button_tosign.setText("\u6CE8\u518C");
		button_tosign.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));

		Label label_tip = new Label(composite_9, SWT.WRAP | SWT.CENTER);
		label_tip.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_tip.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_tip.setText(
				"\u7528\u6237\u540D\u4E3A\u4E94\u5B57\u7B26\u4EE5\u4E0A\uFF0C\u5BC6\u7801\u4E0D\u5C11\u4E8E6\u4F4D");
		label_tip.setFont(SWTResourceManager.getFont("黑体", 25, SWT.NORMAL));
		label_tip.setAlignment(SWT.CENTER);
		FormData fd_label_tip = new FormData();
		fd_label_tip.top = new FormAttachment(0, 10);
		fd_label_tip.left = new FormAttachment(0, 8);
		fd_label_tip.right = new FormAttachment(100, -8);
		label_tip.setLayoutData(fd_label_tip);

		Composite composite_1_1 = new Composite(composite_9, SWT.NONE);
		fd_label_tip.bottom = new FormAttachment(composite_1_1, -48);
		composite_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_1_1.setLayout(new FillLayout(SWT.VERTICAL));
		FormData fd_composite_1_1 = new FormData();
		fd_composite_1_1.bottom = new FormAttachment(warn, -16);
		fd_composite_1_1.left = new FormAttachment(0, 216);
		fd_composite_1_1.top = new FormAttachment(0, 157);
		fd_composite_1_1.right = new FormAttachment(100, -217);
		composite_1_1.setLayoutData(fd_composite_1_1);

		Composite composite_2_1 = new Composite(composite_1_1, SWT.NONE);
		composite_2_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_2_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_2_1.justify = true;
		rl_composite_2_1.center = true;
		composite_2_1.setLayout(rl_composite_2_1);

		Label label_username = new Label(composite_2_1, SWT.NONE);
		label_username.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_username.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_username.setLayoutData(new RowData(75, 30));
		label_username.setText("\u7528\u6237\u540D");
		label_username.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_username.setAlignment(SWT.CENTER);

		text_username = new Text(composite_2_1, SWT.BORDER);
		text_username.setLayoutData(new RowData(130, -1));

		Composite composite_2_1_1 = new Composite(composite_1_1, SWT.NONE);
		composite_2_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_2_1_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_2_1_1.justify = true;
		rl_composite_2_1_1.center = true;
		composite_2_1_1.setLayout(rl_composite_2_1_1);

		Label label_password = new Label(composite_2_1_1, SWT.NONE);
		label_password.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_password.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_password.setLayoutData(new RowData(75, 30));
		label_password.setText("\u5BC6\u7801");
		label_password.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_password.setAlignment(SWT.CENTER);

		text_password = new Text(composite_2_1_1, SWT.BORDER | SWT.PASSWORD);
		text_password.setLayoutData(new RowData(130, -1));

		Composite composite_2_1_1_1 = new Composite(composite_1_1, SWT.NONE);
		composite_2_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_2_1_1_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_2_1_1_1.justify = true;
		rl_composite_2_1_1_1.center = true;
		composite_2_1_1_1.setLayout(rl_composite_2_1_1_1);

		Label label_confirmpass = new Label(composite_2_1_1_1, SWT.NONE);
		label_confirmpass.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_confirmpass.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_confirmpass.setLayoutData(new RowData(75, 30));
		label_confirmpass.setText("\u786E\u8BA4\u5BC6\u7801");
		label_confirmpass.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_confirmpass.setAlignment(SWT.CENTER);

		text_confirmpass = new Text(composite_2_1_1_1, SWT.BORDER | SWT.PASSWORD);
		text_confirmpass.setLayoutData(new RowData(130, -1));

		Composite composite_6 = new Composite(composite_MainofMain, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_4 = new Label(composite_6, SWT.NONE);
		lblNewLabel_4.setBounds(0, 0, 61, 17);
		lblNewLabel_4.setText("6");

		Composite composite_7 = new Composite(composite_MainofMain, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_5 = new Label(composite_7, SWT.NONE);
		lblNewLabel_5.setBounds(0, 0, 61, 17);
		lblNewLabel_5.setText("7");
		composite_MainofMain.layout();

		Button btnNewButton_1 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforMain.topControl = composite_1;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_1.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_1.setText("客房管理");

		Button btnNewButton_2 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforMain.topControl = composite_2;
				composite_MainofMain.layout();

			}
		});
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_2.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_2.setText("客人管理");

		Button btnNewButton_3 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforMain.topControl = composite_3;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_3.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_3.setText("订单管理");

		Button btnNewButton_4 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforMain.topControl = composite_4;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_4.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_4.setText("数据统计");

		Button btnNewButton_5 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforMain.topControl = composite_5;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_5.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_5.setText("用户注册");

		Button btnNewButton_6 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforMain.topControl = composite_6;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_6.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_6.setText("New Button");

		Button btnNewButton_7 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforMain.topControl = composite_7;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_7.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_7.setText("New Button");

		Button btnNewButton_7_1 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_7_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
				try {
					LoginPage window = new LoginPage();
					window.open();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnNewButton_7_1.setText("返回");
		btnNewButton_7_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_7_1.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_7_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));

		stackLayoutforMain.topControl = composite_1;

		Composite composite_8 = new Composite(composite_1, SWT.NONE);
		composite_8.setLayoutData(BorderLayout.SOUTH);

		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(BorderLayout.CENTER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("客房编号");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("客房种类");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("价格");
		composite_MainofMain.layout();

		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("酒店管理系统（管理员）");
		setSize(800, 450);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
