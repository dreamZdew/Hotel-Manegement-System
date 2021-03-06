package org.WWHMS;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FillLayout;

/*登录界面*/

public class LoginPage {

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
			LoginPage window = new LoginPage();
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
		Image image = new Image(display, "././资源文件/Hotel-Room_43669.ico");
		shell.setImage(image);
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
		shell.setText("欢迎进入酒店管理系统");
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
		label_title.setFont(SWTResourceManager.getFont("宋体", 50, SWT.NORMAL));
		label_title.setText("西气宾馆");

		Label warn = new Label(composite, SWT.NONE);
		FormData fd_warn = new FormData();
		fd_warn.bottom = new FormAttachment(0, 313);
		fd_warn.right = new FormAttachment(0, 650);
		fd_warn.top = new FormAttachment(0, 290);
		fd_warn.left = new FormAttachment(0, 128);
		warn.setLayoutData(fd_warn);
		warn.setAlignment(SWT.CENTER);
		warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		warn.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));

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

		Button btnCheckButton = new Button(composite, SWT.CHECK);
		FormData fd_btnCheckButton = new FormData();
		fd_btnCheckButton.bottom = new FormAttachment(warn, -6);
		fd_btnCheckButton.left = new FormAttachment(0, 336);
		btnCheckButton.setLayoutData(fd_btnCheckButton);
		btnCheckButton.setText("作为管理员登录");

		Button button_login = new Button(composite_Button, SWT.NONE);
		button_login.setLayoutData(new RowData(77, SWT.DEFAULT));
		button_login.setBounds(274, 338, 80, 27);
		button_login.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// 利用sha256存储用户名和密码

				if (btnCheckButton.getSelection()) {// 作为管理员登录
					String username = text_username.getText();
					String password = text_password.getText();
					String salt = null;
					conn = AboutDB.loginDB();
					PreparedStatement prep;
					ResultSet rs;

					if (!username.equals("") && !password.equals("")) {
						try {// 此处数据库参考数据库课本P190
								// 获取盐
							prep = conn.prepareStatement("select 盐 from UserPass where 用户名= ? ");
							prep.setString(1, username);
							rs = prep.executeQuery();
							if (rs.next())
								salt = rs.getString(1);
							// 验证密码
							int time = 10000;
							password = MyDigest.PBKDF2(password, salt, time);
							prep = conn.prepareStatement("select 用户名,密码,有管理员权限 from UserPass where 用户名= ? and 密码 = ? ");
							prep.setString(1, username);
							prep.setString(2, password);
							rs = prep.executeQuery();

							if (rs.next()) {
								if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))
										&& rs.getString(3).equals("1")) {// 登录判定
									rs.close();
									prep.close();
									conn.close();
									shell.close();

									/* 打开管理员界面 */
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
									} catch (Exception ee) {
										ee.printStackTrace();
									}
								} else {
									rs.close();
									prep.close();
									warn.setText("登陆失败，该用户无管理员权限");
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
							} else {
								rs.close();
								prep.close();
								warn.setText("登陆失败，用户名或密码不正确");
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
							warn.setText("无法连接到服务器");
							ee.printStackTrace();
						}
					} else {
						warn.setText("用户名或密码不能为空");
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

				else {// 作为用户登录
					String username = text_username.getText();
					String password = text_password.getText();
					String salt = null;
					conn = AboutDB.loginDB();
					PreparedStatement prep;
					ResultSet rs;

					if (!username.equals("") && !password.equals("")) {
						try {// 此处数据库参考数据库课本P190
								// 获取盐
							prep = conn.prepareStatement("select 盐 from UserPass where 用户名= ? ");
							prep.setString(1, username);
							rs = prep.executeQuery();
							if (rs.next())
								salt = rs.getString(1);
							// 验证密码
							int time = 10000;
							password = MyDigest.PBKDF2(password, salt, time);
							prep = conn.prepareStatement("select 用户名,密码 from UserPass where 用户名= ? and 密码 = ? ");
							prep.setString(1, username);
							prep.setString(2, password);
							rs = prep.executeQuery();

							if (rs.next()) {
								if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {// 登录判定
									rs.close();
									prep.close();
									conn.close();
									shell.close();

									/* 打开主界面 */
									try {
										Display display = Display.getDefault();
										MainPage main = new MainPage(display);
										Image image = new Image(display, "././资源文件/Hotel-Room_43669.ico");
										main.setImage(image);
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
								}
							} else {
								rs.close();
								prep.close();
								warn.setText("登陆失败，用户名或密码不正确");
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
							warn.setText("无法连接到服务器");
							ee.printStackTrace();
						}
					} else {
						warn.setText("用户名或密码不能为空");
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
			}
		});

		button_login.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		button_login.setText("登录");

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
		label_username.setText("用户名");

		text_username = new Text(composite_2, SWT.BORDER);
		text_username.setLayoutData(new RowData(130, SWT.DEFAULT));

		Composite composite_3 = new Composite(composite_1, SWT.NONE);
		RowLayout rl_composite_3 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_3.center = true;
		rl_composite_3.justify = true;
		composite_3.setLayout(rl_composite_3);

		Label label_password = new Label(composite_3, SWT.NONE);
		label_password.setLayoutData(new RowData(50, 30));
		label_password.setText("密码");
		label_password.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_password.setAlignment(SWT.CENTER);

		text_password = new Text(composite_3, SWT.BORDER | SWT.PASSWORD);
		text_password.setLayoutData(new RowData(130, SWT.DEFAULT));

	}
}
