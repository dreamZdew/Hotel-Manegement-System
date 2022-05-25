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

/*ע�����*/
/*���ע���Ǹ�����Աע��*/

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
		setText("ע�����");
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
		label_username.setText("�û���");

		Label label_password = new Label(composite, SWT.NONE);
		fd_text_password.top = new FormAttachment(label_password, 0, SWT.TOP);
		FormData fd_label_password = new FormData();
		fd_label_password.bottom = new FormAttachment(0, 290);
		fd_label_password.right = new FormAttachment(0, 352);
		fd_label_password.top = new FormAttachment(0, 258);
		fd_label_password.left = new FormAttachment(0, 274);
		label_password.setLayoutData(fd_label_password);
		label_password.setText("����");
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
		warn.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));

		Label label_tip = new Label(composite, SWT.WRAP | SWT.CENTER);
		FormData fd_label_tip = new FormData();
		fd_label_tip.top = new FormAttachment(0, 10);
		fd_label_tip.left = new FormAttachment(0, 58);
		fd_label_tip.bottom = new FormAttachment(0, 177);
		fd_label_tip.right = new FormAttachment(0, 719);
		label_tip.setLayoutData(fd_label_tip);
		label_tip.setFont(SWTResourceManager.getFont("����", 25, SWT.NORMAL));
		label_tip.setAlignment(SWT.CENTER);
		label_tip.setText("�û���Ϊ���ַ����ϵ���ĸ�����»�����ϣ����벻����6λ");

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
					Statement Stmt;
					String sqlQuery;
					try {// �������û����Ƚϣ���ֹ�ظ�
						Stmt = conn.createStatement();
						sqlQuery = "select �û��� from UserPass where �û���=" + username + "";// ��ѯָ��
						Boolean cansign = true;
						ResultSet rs = Stmt.executeQuery(sqlQuery);
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
						if (cansign.equals(true)) {// ����ע��������д�����ݿ�
							sqlQuery = "use HMS insert into UserPass values(" + username + "," + password + ")";// д�����ݿ�ָ��
							Stmt.executeUpdate(sqlQuery);
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
						}

					} catch (SQLException ee) {
						warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
						warn.setText("�޷����ӵ�������");
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
					Enter window = new Enter();
					window.open();
				} catch (Exception ee) {
					ee.printStackTrace();
				}

			}
		});
		button_returnenter.setText("����");
		button_returnenter.setFont(SWTResourceManager.getFont("����", 12, SWT.NORMAL));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
