package org.WWHMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

/*ע�����*/
/*���ע���Ǹ�����Աע��*/

public class SignupPage extends Shell {

	private Text text_username;
	private Text text_password;
	private Connection conn;
	private Text text_confirmpass;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			SignupPage shell = new SignupPage(display);
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
	public SignupPage(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("ע�����");
		setSize(800, 450);
		setLayout(new FillLayout(SWT.VERTICAL));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FormLayout());

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

		Button button_tosign = new Button(composite_Button, SWT.NONE);
		button_tosign.setLayoutData(new RowData(77, SWT.DEFAULT));
		button_tosign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// ע��

				String username = text_username.getText();
				String password = text_password.getText();

				if (username.length() <= 5 || password.length() < 6) {// ��������
					warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					warn.setText("ע��ʧ��");
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
					try {// �������û����Ƚϣ���ֹ�ظ�

						PreparedStatement prep = conn.prepareStatement("select �û��� from UserPass where �û���= ? ");
						prep.setString(1, username);
						Boolean cansign = true;
						ResultSet rs = prep.executeQuery();
						while (rs.next()) {
							if (username.equals(rs.getString(1))) {// �û����ظ�
								warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
								warn.setText("�û����Ѵ��ڣ�ע��ʧ��");
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
							warn.setText("�������벻һ�£�ע��ʧ��");
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
						if (cansign == true) {// ����ע��������д�����ݿ�

							prep = conn.prepareStatement(" insert into UserPass values( ?, ?)");// д�����ݿ�ָ��
							prep.setString(1, username);
							prep.setString(2, password);
							prep.executeUpdate();
							warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
							warn.setText("ע��ɹ�");
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
						warn.setText("�޷����ӵ�������");
						ee.printStackTrace();
					}

				}

			}
		});
		button_tosign.setText("ע��");
		button_tosign.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));

		Button button_returnenter = new Button(composite_Button, SWT.NONE);
		button_returnenter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// ���ص�½����

				close();
				try {
					LoginPage window = new LoginPage();
					window.open();
				} catch (Exception ee) {
					ee.printStackTrace();
				}

			}
		});
		button_returnenter.setText("����");
		button_returnenter.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));

		Label label_tip = new Label(composite, SWT.WRAP | SWT.CENTER);
		FormData fd_label_tip = new FormData();
		fd_label_tip.bottom = new FormAttachment(0, 151);
		fd_label_tip.right = new FormAttachment(0, 722);
		fd_label_tip.top = new FormAttachment(0, 10);
		fd_label_tip.left = new FormAttachment(0, 61);
		label_tip.setLayoutData(fd_label_tip);
		label_tip.setFont(SWTResourceManager.getFont("����", 25, SWT.NORMAL));
		label_tip.setAlignment(SWT.CENTER);
		label_tip.setText("�û���Ϊ���ַ����ϣ����벻����6λ");

		Composite composite_1 = new Composite(composite, SWT.NONE);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(label_tip, 5);
		fd_composite_1.left = new FormAttachment(0, 270);
		fd_composite_1.bottom = new FormAttachment(0, 273);
		fd_composite_1.right = new FormAttachment(0, 514);
		composite_1.setLayoutData(fd_composite_1);
		composite_1.setLayout(new FillLayout(SWT.VERTICAL));

		Composite composite_2 = new Composite(composite_1, SWT.NONE);
		RowLayout rl_composite_2 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_2.center = true;
		rl_composite_2.justify = true;
		composite_2.setLayout(rl_composite_2);

		Label label_username = new Label(composite_2, SWT.NONE);
		label_username.setLayoutData(new RowData(75, 30));
		label_username.setAlignment(SWT.CENTER);
		label_username.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_username.setText("�û���");

		text_username = new Text(composite_2, SWT.BORDER);
		text_username.setLayoutData(new RowData(130, SWT.DEFAULT));

		Composite composite_2_1 = new Composite(composite_1, SWT.NONE);
		RowLayout rl_composite_2_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_2_1.center = true;
		rl_composite_2_1.justify = true;
		composite_2_1.setLayout(rl_composite_2_1);

		Label label_password = new Label(composite_2_1, SWT.NONE);
		label_password.setLayoutData(new RowData(75, 30));
		label_password.setText("����");
		label_password.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_password.setAlignment(SWT.CENTER);

		text_password = new Text(composite_2_1, SWT.BORDER);
		text_password.setLayoutData(new RowData(130, SWT.DEFAULT));

		Composite composite_2_1_1 = new Composite(composite_1, SWT.NONE);
		RowLayout rl_composite_2_1_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_2_1_1.justify = true;
		rl_composite_2_1_1.center = true;
		composite_2_1_1.setLayout(rl_composite_2_1_1);

		Label label_confirmpass = new Label(composite_2_1_1, SWT.NONE);
		label_confirmpass.setLayoutData(new RowData(75, 30));
		label_confirmpass.setText("ȷ������");
		label_confirmpass.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_confirmpass.setAlignment(SWT.CENTER);

		text_confirmpass = new Text(composite_2_1_1, SWT.BORDER);
		text_confirmpass.setLayoutData(new RowData(130, SWT.DEFAULT));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
