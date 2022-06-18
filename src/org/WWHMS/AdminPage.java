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
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.List;

/*主界面*/

public class AdminPage extends Shell {
	private Table table;
	private Text text_username;
	private Text text_password;
	private Text text_confirmpass;
	private Table table_1;
	private Table table_2;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Table table_3;
	private Text text_7;
	private Text text_3;
	private Text text_8;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			AdminPage shell = new AdminPage(display);
			Image image = new Image(display, "././资源文件/Hotel-Room_43669.ico");
			shell.setImage(image);
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
		fd_label_tip.bottom = new FormAttachment(warn, -181);
		fd_label_tip.top = new FormAttachment(0, 10);
		fd_label_tip.left = new FormAttachment(0, 8);
		fd_label_tip.right = new FormAttachment(100, -8);
		label_tip.setLayoutData(fd_label_tip);

		Composite composite_1_1 = new Composite(composite_9, SWT.NONE);
		composite_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_1_1.setLayout(new FillLayout(SWT.VERTICAL));
		FormData fd_composite_1_1 = new FormData();
		fd_composite_1_1.bottom = new FormAttachment(warn, -18);
		fd_composite_1_1.left = new FormAttachment(0, 170);
		fd_composite_1_1.top = new FormAttachment(0, 157);
		fd_composite_1_1.right = new FormAttachment(100, -171);
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
		label_confirmpass.setLayoutData(new RowData(102, 30));
		label_confirmpass.setText("\u786E\u8BA4\u5BC6\u7801");
		label_confirmpass.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_confirmpass.setAlignment(SWT.CENTER);

		text_confirmpass = new Text(composite_2_1_1_1, SWT.BORDER | SWT.PASSWORD);
		text_confirmpass.setLayoutData(new RowData(130, -1));

		Composite composite_1 = new Composite(composite_MainofMain, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_1.setLayout(new BorderLayout(0, 0));

		Composite composite_2 = new Composite(composite_MainofMain, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_2.setLayout(new BorderLayout(0, 0));

		Composite composite_10 = new Composite(composite_2, SWT.NONE);
		composite_10.setLayoutData(BorderLayout.SOUTH);
		composite_10.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_11_1 = new Composite(composite_10, SWT.NONE);
		composite_11_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_11_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_11_1.justify = true;
		composite_11_1.setLayout(rl_composite_11_1);

		Label label_1 = new Label(composite_11_1, SWT.NONE);
		label_1.setText("输入客人编号");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		text_5 = new Text(composite_11_1, SWT.BORDER);
		text_5.setLayoutData(new RowData(362, -1));
		text_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));

		Button btnNewButton_9_1 = new Button(composite_11_1, SWT.NONE);
		btnNewButton_9_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String customer = text_5.getText();
				Shell shell = new Shell();
				// create a dialog with ok and cancel buttons and a question icon
				MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
				dialog.setText("删除客人");
				dialog.setMessage("你确定要删除此客人？");
				// open dialog and await user selection
				int returnCode = dialog.open();
				System.out.println(returnCode);
				if (returnCode == 32) {
					PreparedStatement prep;
					try {
						Connection conn = AboutDB.loginDB();
						prep = conn.prepareStatement("delete from Customer where 客人编号=?");
						prep.setString(1, customer);
						prep.execute();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
						Shell warnshell = new Shell();
						// create a dialog with ok and cancel buttons and a question icon
						MessageBox warndialog = new MessageBox(warnshell, SWT.ICON_ERROR);
						warndialog.setText("删除失败");
						warndialog.setMessage("此客人有订单关联");
						// open dialog and await user selection
						warndialog.open();
					}
				}

			}
		});
		btnNewButton_9_1.setText("删除客人");
		btnNewButton_9_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));

		table_1 = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLayoutData(BorderLayout.CENTER);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		TableColumn tblclmnNewColumn_3 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_3.setWidth(115);
		tblclmnNewColumn_3.setText("客人编号");

		TableColumn tblclmnNewColumn_4 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_4.setWidth(93);
		tblclmnNewColumn_4.setText("姓名");

		TableCursor tableCursor = new TableCursor(table_1, SWT.NONE);

		TableColumn tblclmnNewColumn_5 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("身份证号");

		TableColumn tblclmnNewColumn_6 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("手机号");

		TableColumn tblclmnNewColumn_7 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_7.setWidth(100);
		tblclmnNewColumn_7.setText("性别");

		TableColumn tblclmnNewColumn_8 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_8.setWidth(100);
		tblclmnNewColumn_8.setText("出生日期");

		Composite composite_3 = new Composite(composite_MainofMain, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_3.setLayout(new BorderLayout(0, 0));

		Composite composite_11 = new Composite(composite_3, SWT.NONE);
		composite_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_11.setLayoutData(BorderLayout.SOUTH);
		RowLayout rl_composite_11 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_11.justify = true;
		composite_11.setLayout(rl_composite_11);

		Label label = new Label(composite_11, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setText("\u8F93\u5165\u8BA2\u5355\u53F7");

		text_4 = new Text(composite_11, SWT.BORDER);
		text_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		text_4.setLayoutData(new RowData(362, SWT.DEFAULT));

		Button btnNewButton_9 = new Button(composite_11, SWT.NONE);
		btnNewButton_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String order = text_4.getText();
				Shell shell = new Shell();
				// create a dialog with ok and cancel buttons and a question icon
				MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
				dialog.setText("删除订单");
				dialog.setMessage("你确定要删除此订单？");
				// open dialog and await user selection
				int returnCode = dialog.open();
				System.out.println(returnCode);
				if (returnCode == 32) {
					PreparedStatement prep;
					try {
						Connection conn = AboutDB.loginDB();
						prep = conn.prepareStatement("delete from CustOrder where 订单编号=?  ");
						prep.setString(1, order);
						prep.execute();
						prep = conn.prepareStatement("delete from OrderList where 订单编号=?  ");
						prep.setString(1, order);
						prep.execute();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
						Shell warnshell = new Shell();
						// create a dialog with ok and cancel buttons and a question icon
						MessageBox warndialog = new MessageBox(warnshell, SWT.ICON_ERROR);
						warndialog.setText("删除失败");
						warndialog.setMessage("此客人有订单关联");
						// open dialog and await user selection
						warndialog.open();
					}
				}

			}
		});
		btnNewButton_9.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		btnNewButton_9.setText("删除订单");

		table_2 = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setLayoutData(BorderLayout.CENTER);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);

		TableColumn tableColumn = new TableColumn(table_2, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("订单编号");

		TableColumn tableColumn_1 = new TableColumn(table_2, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("下单时间");

		TableColumn tableColumn_1_1 = new TableColumn(table_2, SWT.NONE);
		tableColumn_1_1.setWidth(100);
		tableColumn_1_1.setText("客人编号");

		TableColumn tableColumn_1_2 = new TableColumn(table_2, SWT.NONE);
		tableColumn_1_2.setWidth(100);
		tableColumn_1_2.setText("房间编号");

		TableColumn tableColumn_1_3 = new TableColumn(table_2, SWT.NONE);
		tableColumn_1_3.setWidth(100);
		tableColumn_1_3.setText("入住时间");

		TableColumn tableColumn_1_4 = new TableColumn(table_2, SWT.NONE);
		tableColumn_1_4.setWidth(100);
		tableColumn_1_4.setText("退房时间");

		TableColumn tableColumn_1_5 = new TableColumn(table_2, SWT.NONE);
		tableColumn_1_5.setWidth(100);
		tableColumn_1_5.setText("订单状态");

		TableColumn tblclmnNewColumn_9 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_9.setWidth(100);
		tblclmnNewColumn_9.setText("价格");

		Composite composite_6 = new Composite(composite_MainofMain, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_6.setLayout(new BorderLayout(0, 0));

		Composite composite_20 = new Composite(composite_6, SWT.NONE);
		composite_20.setLayoutData(BorderLayout.SOUTH);
		composite_20.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_11_1_1 = new Composite(composite_20, SWT.NONE);
		composite_11_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_11_1_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_11_1_1.justify = true;
		composite_11_1_1.setLayout(rl_composite_11_1_1);

		Label label_1_1 = new Label(composite_11_1_1, SWT.NONE);
		label_1_1.setText("输入用户名");
		label_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		label_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		text_6 = new Text(composite_11_1_1, SWT.BORDER);
		text_6.setLayoutData(new RowData(362, -1));
		text_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));

		Button btnNewButton_9_1_1 = new Button(composite_11_1_1, SWT.NONE);
		btnNewButton_9_1_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String userpass = text_6.getText();
				Shell shell = new Shell();
				// create a dialog with ok and cancel buttons and a question icon
				MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
				dialog.setText("删除用户");
				dialog.setMessage("你确定要删除此用户？");
				// open dialog and await user selection
				int returnCode = dialog.open();
				System.out.println(returnCode);
				if (returnCode == 32) {
					PreparedStatement prep;
					try {
						Connection conn = AboutDB.loginDB();
						prep = conn.prepareStatement("delete from UserPass where 用户名=?  ");
						prep.setString(1, userpass);
						prep.execute();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
						Shell warnshell = new Shell();
						// create a dialog with ok and cancel buttons and a question icon
						MessageBox warndialog = new MessageBox(warnshell, SWT.ICON_ERROR);
						warndialog.setText("删除失败");
						// open dialog and await user selection
						warndialog.open();
					}
				}

			}
		});
		btnNewButton_9_1_1.setText("删除用户");
		btnNewButton_9_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));

		List list = new List(composite_6, SWT.BORDER);
		list.setLayoutData(BorderLayout.CENTER);
		
				Composite composite_7 = new Composite(composite_MainofMain, SWT.NONE);
				composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
				composite_7.setLayout(new BorderLayout(0, 0));
				
				Composite composite_21 = new Composite(composite_7, SWT.NONE);
				composite_21.setLayoutData(BorderLayout.SOUTH);
				composite_21.setLayout(new FillLayout(SWT.HORIZONTAL));
				
				Composite composite_11_1_1_1 = new Composite(composite_21, SWT.NONE);
				composite_11_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
				composite_11_1_1_1.setLayout(new FillLayout(SWT.VERTICAL));
				
				Composite composite_22 = new Composite(composite_11_1_1_1, SWT.NONE);
				composite_22.setLayout(new FillLayout(SWT.HORIZONTAL));
				
				Label label_1_1_1 = new Label(composite_22, SWT.NONE);
				label_1_1_1.setAlignment(SWT.CENTER);
				label_1_1_1.setText("输入房间类型");
				label_1_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				label_1_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
				label_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
				
				text_7 = new Text(composite_22, SWT.BORDER);
				text_7.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
				
				Button btnNewButton_9_1_1_1 = new Button(composite_22, SWT.NONE);
				btnNewButton_9_1_1_1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						String roomtype = text_7.getText();
						Shell shell = new Shell();
						// create a dialog with ok and cancel buttons and a question icon
						MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
						dialog.setText("删除房间类型");
						dialog.setMessage("你确定要删除此房间类型？");
						// open dialog and await user selection
						int returnCode = dialog.open();
						System.out.println(returnCode);
						if (returnCode == 32) {
							PreparedStatement prep;
							try {
								Connection conn = AboutDB.loginDB();
								prep = conn.prepareStatement("delete from RoomType where 房间类型=?  ");
								prep.setString(1, roomtype);
								prep.execute();
							} catch (SQLException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
								Shell warnshell = new Shell();
								// create a dialog with ok and cancel buttons and a question icon
								MessageBox warndialog = new MessageBox(warnshell, SWT.ICON_ERROR);
								warndialog.setText("删除失败");
								warndialog.setMessage("有此类型的房间存在，无法删除房间类型");
								// open dialog and await user selection
								warndialog.open();
							}
						}
						
						
						
					}
				});
				btnNewButton_9_1_1_1.setText("删除此房间类型");
				btnNewButton_9_1_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
				
				Composite composite_19_1 = new Composite(composite_11_1_1_1, SWT.NONE);
				composite_19_1.setLayout(new FillLayout(SWT.HORIZONTAL));
				
				Label label_1_1_1_1 = new Label(composite_19_1, SWT.NONE);
				label_1_1_1_1.setAlignment(SWT.CENTER);
				label_1_1_1_1.setText("房间类型");
				label_1_1_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				label_1_1_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
				label_1_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
				
				text_3 = new Text(composite_19_1, SWT.BORDER);
				
				Label label_1_1_1_2 = new Label(composite_19_1, SWT.NONE);
				label_1_1_1_2.setAlignment(SWT.CENTER);
				label_1_1_1_2.setText("价格");
				label_1_1_1_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				label_1_1_1_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
				label_1_1_1_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
				
				text_8 = new Text(composite_19_1, SWT.BORDER);
				
				Button btnNewButton_10 = new Button(composite_19_1, SWT.NONE);
				btnNewButton_10.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
						String roomtype = text_3.getText(),roomprice=text_8.getText();
						Shell shell = new Shell();
						// create a dialog with ok and cancel buttons and a question icon
						MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
						dialog.setText("修改/增加房间类型");
						dialog.setMessage("你确定要修改/增加此房间类型？");
						// open dialog and await user selection
						int returnCode = dialog.open();
						System.out.println(returnCode);
						if (returnCode == 32) {
							PreparedStatement prep;
							
							
							//更新房间类型价格
							try {
								Connection conn = AboutDB.loginDB();
								prep = conn.prepareStatement("UPDATE RoomType SET  房间价格 = ? WHERE 房间类型 = ?  ");
								prep.setString(1, roomprice);prep.setString(2, roomtype);
								prep.execute();
							} catch (SQLException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
							//加入新的房间类型
							try {
								Connection conn = AboutDB.loginDB();
								prep = conn.prepareStatement("insert into RoomType values(?,?)  ");
								prep.setString(1, roomtype);prep.setString(2, roomprice);
								prep.execute();
							} catch (SQLException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
							
							
						}
						
						
						
						
						
					}
				});
				btnNewButton_10.setText("修改或添加房间类型");
				
				table_3 = new Table(composite_7, SWT.BORDER | SWT.FULL_SELECTION);
				table_3.setLayoutData(BorderLayout.CENTER);
				table_3.setHeaderVisible(true);
				table_3.setLinesVisible(true);
				
				TableColumn tblclmnNewColumn_10 = new TableColumn(table_3, SWT.NONE);
				tblclmnNewColumn_10.setWidth(100);
				tblclmnNewColumn_10.setText("房间类型");
				
				TableColumn tblclmnNewColumn_11 = new TableColumn(table_3, SWT.NONE);
				tblclmnNewColumn_11.setWidth(100);
				tblclmnNewColumn_11.setText("价格");

		Composite composite_4 = new Composite(composite_MainofMain, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_4.setLayout(new FillLayout(SWT.VERTICAL));

		Composite composite_12_1 = new Composite(composite_4, SWT.NONE);
		composite_12_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_12_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		Label lblNewLabel_4 = new Label(composite_12_1, SWT.NONE);
		lblNewLabel_4.setText("总用户数");
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_4.setAlignment(SWT.CENTER);

		Label lblNewLabel_1_1 = new Label(composite_12_1, SWT.NONE);
		lblNewLabel_1_1.setText("New Label");
		lblNewLabel_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1_1.setAlignment(SWT.CENTER);

		Composite composite_12 = new Composite(composite_4, SWT.NONE);
		composite_12.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_12.setLayout(new FillLayout(SWT.HORIZONTAL));

		Label lblNewLabel = new Label(composite_12, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel.setText("\u603B\u8BA2\u5355\u6570");

		Label lblNewLabel_1 = new Label(composite_12, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setText("New Label");

		Composite composite_13 = new Composite(composite_4, SWT.NONE);
		composite_13.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_13.setLayout(new FillLayout(SWT.HORIZONTAL));

		Label lblNewLabel_2 = new Label(composite_13, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_2.setText("\u603B\u5BA2\u4EBA\u6570");

		Label lblNewLabel_3 = new Label(composite_13, SWT.NONE);
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_3.setText("New Label");
		
		Composite composite_15_1 = new Composite(composite_4, SWT.NONE);
		composite_15_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_15_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label lblNewLabel_8_1 = new Label(composite_15_1, SWT.NONE);
		lblNewLabel_8_1.setText("总房间类型数量");
		lblNewLabel_8_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_8_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_8_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_8_1.setAlignment(SWT.CENTER);
		
		Label lblNewLabel_9_1 = new Label(composite_15_1, SWT.NONE);
		lblNewLabel_9_1.setText("New Label");
		lblNewLabel_9_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_9_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_9_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_9_1.setAlignment(SWT.CENTER);

		Composite composite_14 = new Composite(composite_4, SWT.NONE);
		composite_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_14.setLayout(new FillLayout(SWT.HORIZONTAL));

		Label lblNewLabel_6 = new Label(composite_14, SWT.NONE);
		lblNewLabel_6.setAlignment(SWT.CENTER);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_6.setText("\u603B\u623F\u95F4\u6570");

		Label lblNewLabel_7 = new Label(composite_14, SWT.NONE);
		lblNewLabel_7.setAlignment(SWT.CENTER);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_7.setText("New Label");

		Composite composite_15 = new Composite(composite_4, SWT.NONE);
		composite_15.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_15.setLayout(new FillLayout(SWT.HORIZONTAL));

		Label lblNewLabel_8 = new Label(composite_15, SWT.NONE);
		lblNewLabel_8.setAlignment(SWT.CENTER);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_8.setText("\u603B\u76C8\u5229");

		Label lblNewLabel_9 = new Label(composite_15, SWT.NONE);
		lblNewLabel_9.setAlignment(SWT.CENTER);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_9.setText("New Label");
		composite_MainofMain.layout();

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

		Button btnNewButton_1 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				table.removeAll();
				try {
					Connection conn = AboutDB.loginDB();
					PreparedStatement prep = conn.prepareStatement(
							"SELECT 房间编号,Room.房间类型,房间价格 FROM Room join RoomType on Room.房间类型=RoomType.房间类型");
					ResultSet rs = prep.executeQuery();
					while (rs.next()) {
						TableItem tableitem = new TableItem(table, SWT.NULL);
						tableitem.setText(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), });

					}
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}

				stackLayoutforMain.topControl = composite_1;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_1.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_1.setText("房间管理");

		Button btnNewButton_2 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				table_1.removeAll();
				try {
					Connection conn = AboutDB.loginDB();
					PreparedStatement prep = conn.prepareStatement(
							"SELECT [客人编号]\r\n" + "      ,[姓名]\r\n" + "      ,[身份证号]\r\n" + "      ,[手机号]\r\n"
									+ "      ,[性别]\r\n" + "      ,[出生日期]\r\n" + "  FROM [dbo].[Customer]");
					ResultSet rs = prep.executeQuery();
					while (rs.next()) {
						TableItem tableitem = new TableItem(table_1, SWT.NULL);
						tableitem.setText(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getString(6) });

					}
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}

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
				table_2.removeAll();
				try {
					Connection conn = AboutDB.loginDB();
					PreparedStatement prep = conn.prepareStatement("SELECT [订单编号]\r\n" + "      ,[下单时间]\r\n"
							+ "      ,[客人编号]\r\n" + "      ,[房间编号]\r\n" + "      ,[入住时间]\r\n" + "      ,[退房时间]\r\n"
							+ "      ,[订单状态]\r\n" + "      ,[价格]\r\n" + "  FROM [dbo].[OrderList]");
					ResultSet rs = prep.executeQuery();
					while (rs.next()) {
						TableItem tableitem = new TableItem(table_2, SWT.NULL);
						tableitem.setText(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });

					}
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}

				stackLayoutforMain.topControl = composite_3;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_3.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_3.setText("订单管理");

		Button btnNewButton_6 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list.removeAll();
				try {
					Connection conn = AboutDB.loginDB();
					PreparedStatement prep = conn.prepareStatement("select 用户名 from UserPass");
					ResultSet rs = prep.executeQuery();
					while (rs.next()) {
						list.add(rs.getString(1));

					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

				stackLayoutforMain.topControl = composite_6;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_6.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_6.setText("用户管理");

		Button btnNewButton_7 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table_3.removeAll();
				try {
					Connection conn = AboutDB.loginDB();
					PreparedStatement prep = conn.prepareStatement("select 房间类型, 房间价格 from RoomType");
					ResultSet rs = prep.executeQuery();
					while (rs.next()) {
						TableItem tableitem = new TableItem(table_3, SWT.NULL);
						tableitem.setText(new String[] { rs.getString(1), rs.getString(2) });

					}
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				
				
				
				stackLayoutforMain.topControl = composite_7;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_7.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_7.setText("房间类型管理");
		
				Button btnNewButton_4 = new Button(composite_Buttons, SWT.NONE);
				btnNewButton_4.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {

						try {
							Connection conn = AboutDB.loginDB();
							PreparedStatement prep = conn.prepareStatement("select SUM(价格) from OrderList");
							ResultSet rs = prep.executeQuery();
							if (rs.next()) {
								lblNewLabel_9.setText(rs.getString(1));
							}
							prep = conn.prepareStatement("select COUNT(*) from OrderList");
							rs = prep.executeQuery();
							if (rs.next()) {
								lblNewLabel_1.setText(rs.getString(1));
							}
							prep = conn.prepareStatement("select COUNT(*) from Customer");
							rs = prep.executeQuery();
							if (rs.next()) {
								lblNewLabel_3.setText(rs.getString(1));
							}
							prep = conn.prepareStatement("select COUNT(*) from Room");
							rs = prep.executeQuery();
							if (rs.next()) {
								lblNewLabel_7.setText(rs.getString(1));
							}
							prep = conn.prepareStatement("select COUNT(*) from UserPass");
							rs = prep.executeQuery();
							if (rs.next()) {
								lblNewLabel_1_1.setText(rs.getString(1));
							}
							prep = conn.prepareStatement("select COUNT(*) from RoomType");
							rs = prep.executeQuery();
							if (rs.next()) {
								lblNewLabel_9_1.setText(rs.getString(1));
							}

						} catch (SQLException ee) {
							// TODO 自动生成的 catch 块
							ee.printStackTrace();
						}

						stackLayoutforMain.topControl = composite_4;
						composite_MainofMain.layout();
					}
				});
				btnNewButton_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				btnNewButton_4.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
				btnNewButton_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
				btnNewButton_4.setText("数据统计");

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

		stackLayoutforMain.topControl = composite_5;

		Composite composite_8 = new Composite(composite_1, SWT.NONE);
		composite_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_8.setLayoutData(BorderLayout.SOUTH);
		composite_8.setLayout(new FillLayout(SWT.VERTICAL));

		Composite composite_18 = new Composite(composite_8, SWT.NONE);
		composite_18.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_17 = new Composite(composite_18, SWT.NONE);
		composite_17.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_17.setLayout(new FillLayout(SWT.HORIZONTAL));

		Label lblNewLabel_10 = new Label(composite_17, SWT.NONE);
		lblNewLabel_10.setAlignment(SWT.CENTER);
		lblNewLabel_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_10.setText("输入客房编号");

		Composite composite_16 = new Composite(composite_18, SWT.NONE);
		composite_16.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_16.setLayout(new FillLayout(SWT.HORIZONTAL));

		text_1 = new Text(composite_16, SWT.BORDER);

		Button btnNewButton_8 = new Button(composite_16, SWT.NONE);
		btnNewButton_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String room = text_1.getText();
				Shell shell = new Shell();
				// create a dialog with ok and cancel buttons and a question icon
				MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
				dialog.setText("删除客房");
				dialog.setMessage("你确定要删除此客房？");
				// open dialog and await user selection
				int returnCode = dialog.open();
				System.out.println(returnCode);
				if (returnCode == 32) {
					PreparedStatement prep;
					try {
						Connection conn = AboutDB.loginDB();
						prep = conn.prepareStatement("delete from Room where 房间编号=?");
						prep.setString(1, room);
						prep.execute();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_8.setText("删除客房");

		Composite composite_19 = new Composite(composite_8, SWT.NONE);
		composite_19.setLayout(new FillLayout(SWT.HORIZONTAL));

		text = new Text(composite_19, SWT.BORDER);

		text_2 = new Text(composite_19, SWT.BORDER);

		Button btnNewButton = new Button(composite_19, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String roomnumber = text.getText(), roomtype = text_2.getText();

				PreparedStatement prep;
				try {
					Connection conn = AboutDB.loginDB();
					prep = conn.prepareStatement("insert into Room values(?,?)");
					prep.setString(1, roomnumber);prep.setString(2, roomtype);
					prep.execute();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setText("添加客房");

		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(BorderLayout.CENTER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("房间编号");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("房间种类");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("价格");
		composite_MainofMain.layout();

		final TableCursor cursor = new TableCursor(table, SWT.FULL_SELECTION);// 鼠标对表格监听
		cursor.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				int cursorrow = table.getSelectionIndex();
				int cursorcol = cursor.getColumn();
				System.out.println(cursorrow + " " + cursorcol);
			}
		});

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
