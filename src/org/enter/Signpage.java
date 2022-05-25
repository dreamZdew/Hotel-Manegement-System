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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;

/*注册界面*/
/*这个注册是给管理员注册*/

public class Signpage extends Shell {

	private Text text_username;
	private Text text_password;
	private Connection conn;

	/**
	 * Launch the application.
	 * 
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
	 * 
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
		setLayout(new FillLayout(SWT.VERTICAL));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FormLayout());

		text_username = new Text(composite, SWT.BORDER);
		FormData fd_text_username = new FormData();
		fd_text_username.bottom = new FormAttachment(0, 222);
		fd_text_username.right = new FormAttachment(0, 484);
		fd_text_username.left = new FormAttachment(0, 358);
		text_username.setLayoutData(fd_text_username);

		text_password = new Text(composite, SWT.BORDER);
		FormData fd_text_password = new FormData();
		fd_text_password.bottom = new FormAttachment(0, 281);
		fd_text_password.right = new FormAttachment(0, 484);
		fd_text_password.left = new FormAttachment(0, 358);
		text_password.setLayoutData(fd_text_password);

		Label label_username = new Label(composite, SWT.NONE);
		fd_text_username.top = new FormAttachment(label_username, 0, SWT.TOP);
		FormData fd_label_username = new FormData();
		fd_label_username.bottom = new FormAttachment(0, 231);
		fd_label_username.right = new FormAttachment(0, 352);
		fd_label_username.top = new FormAttachment(0, 199);
		fd_label_username.left = new FormAttachment(0, 274);
		label_username.setLayoutData(fd_label_username);
		label_username.setAlignment(SWT.CENTER);
		label_username.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_username.setText("用户名");

		Label label_password = new Label(composite, SWT.NONE);
		fd_text_password.top = new FormAttachment(label_password, 0, SWT.TOP);
		FormData fd_label_password = new FormData();
		fd_label_password.bottom = new FormAttachment(0, 290);
		fd_label_password.right = new FormAttachment(0, 352);
		fd_label_password.top = new FormAttachment(0, 258);
		fd_label_password.left = new FormAttachment(0, 274);
		label_password.setLayoutData(fd_label_password);
		label_password.setText("密码");
		label_password.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_password.setAlignment(SWT.CENTER);

		Label warn = new Label(composite, SWT.NONE);
		FormData fd_warn = new FormData();
		fd_warn.bottom = new FormAttachment(0, 252);
		fd_warn.right = new FormAttachment(0, 658);
		fd_warn.top = new FormAttachment(0, 229);
		fd_warn.left = new FormAttachment(0, 119);
		warn.setLayoutData(fd_warn);
		warn.setAlignment(SWT.CENTER);
		warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		warn.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));

		Label label_tip = new Label(composite, SWT.WRAP | SWT.CENTER);
		FormData fd_label_tip = new FormData();
		fd_label_tip.top = new FormAttachment(0, 10);
		fd_label_tip.left = new FormAttachment(0, 58);
		fd_label_tip.bottom = new FormAttachment(0, 177);
		fd_label_tip.right = new FormAttachment(0, 719);
		label_tip.setLayoutData(fd_label_tip);
		label_tip.setFont(SWTResourceManager.getFont("黑体", 25, SWT.NORMAL));
		label_tip.setAlignment(SWT.CENTER);
		label_tip.setText("用户名为五字符以上的字母数字下划线组合，密码不少于6位");

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

		Button button_tosign = new Button(composite_Button, SWT.NONE);
		button_tosign.setLayoutData(new RowData(77, SWT.DEFAULT));
		button_tosign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// 注册

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
					conn = AboutDB.loginDB();
					Statement Stmt;
					String sqlQuery;
					try {// 与已有用户名比较，防止重复
						Stmt = conn.createStatement();
						sqlQuery = "select 用户名 from UserPass where 用户名=" + username + "";// 查询指令
						Boolean cansign = true;
						ResultSet rs = Stmt.executeQuery(sqlQuery);
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
						if (cansign.equals(true)) {// 满足注册条件，写入数据库
							sqlQuery = "use HMS insert into UserPass values(" + username + "," + password + ")";// 写入数据库指令
							Stmt.executeUpdate(sqlQuery);
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
						}

					} catch (SQLException ee) {
						warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
						warn.setText("无法连接到服务器");
					}

				}

			}
		});
		button_tosign.setText("注册");
		button_tosign.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));

		Button button_returnenter = new Button(composite_Button, SWT.NONE);
		button_returnenter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// 返回登陆界面

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
		button_returnenter.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
