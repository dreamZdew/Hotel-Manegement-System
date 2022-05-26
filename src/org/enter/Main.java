package org.enter;

import java.time.LocalDate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/*主界面*/

public class Main extends Shell {
	private Text text_name;
	private Text text_idnum;
	private Text text_phone;
	private Text text_roomtype;
	private Text text_age;
	private Text text_gender;
	private Text text_birth;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Main shell = new Main(display);
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
	public Main(Display display) {
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
		final StackLayout stackLayout = new StackLayout();
		composite_MainofMain.setLayout(stackLayout);

		GridData gd_composite_MainofMain = new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
		gd_composite_MainofMain.widthHint = 677;
		gd_composite_MainofMain.heightHint = 401;
		composite_MainofMain.setLayoutData(gd_composite_MainofMain);

		Composite composite_1 = new Composite(composite_MainofMain, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_2 = new Composite(composite_MainofMain, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_3 = new Composite(composite_MainofMain, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_4 = new Composite(composite_MainofMain, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_5 = new Composite(composite_MainofMain, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_6 = new Composite(composite_MainofMain, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_7 = new Composite(composite_MainofMain, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		stackLayout.topControl = composite_1;
		composite_MainofMain.layout();

		Button btnNewButton_1 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_1;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_1.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_1.setText("New Button");

		Button btnNewButton_2 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_2;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_2.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_2.setText("New Button");

		Button btnNewButton_3 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_3;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_3.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_3.setText("New Button");

		Button btnNewButton_4 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_4;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_4.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_4.setText("New Button");

		Button btnNewButton_5 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_5;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_5.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_5.setText("New Button");

		Button btnNewButton_6 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_6;
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
				stackLayout.topControl = composite_7;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_7.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_7.setText("New Button");
		RowLayout rl_composite_1 = new RowLayout(SWT.VERTICAL);
		rl_composite_1.justify = true;
		rl_composite_1.center = true;
		composite_1.setLayout(rl_composite_1);

		Label lblNewLabel = new Label(composite_1, SWT.WRAP);
		lblNewLabel.setLayoutData(new RowData(634, SWT.DEFAULT));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel.setFont(SWTResourceManager.getFont("宋体", 30, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("酒店管理系统");

		Label lblNewLabel_warn = new Label(composite_1, SWT.CENTER);
		lblNewLabel_warn.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_warn.setLayoutData(new RowData(242, 32));
		lblNewLabel_warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_warn.setText("");
		lblNewLabel_warn.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_14 = new Composite(composite_1, SWT.NONE);
		composite_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_14 = new RowLayout(SWT.HORIZONTAL);
		composite_14.setLayout(rl_composite_14);

		Composite composite_141 = new Composite(composite_14, SWT.NONE);
		composite_141.setLayoutData(new RowData(SWT.DEFAULT, 260));
		composite_141.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_141.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_name = new Label(composite_141, SWT.NONE);
		lblNewLabel_name.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_name.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_name.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_name.setText("姓名");
		lblNewLabel_name.setAlignment(SWT.CENTER);

		Label lblNewLabel_roomtype = new Label(composite_141, SWT.NONE);
		lblNewLabel_roomtype.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_roomtype.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_roomtype.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_roomtype.setAlignment(SWT.CENTER);
		lblNewLabel_roomtype.setText("房间类型");

		Label lblNewLabel_idnum = new Label(composite_141, SWT.NONE);
		lblNewLabel_idnum.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_idnum.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_idnum.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_idnum.setText("身份证号");
		lblNewLabel_idnum.setAlignment(SWT.CENTER);

		Label lblNewLabel_phone = new Label(composite_141, SWT.NONE);
		lblNewLabel_phone.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_phone.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_phone.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_phone.setText("手机号");
		lblNewLabel_phone.setAlignment(SWT.CENTER);

		Label lblNewLabel_phone_1 = new Label(composite_141, SWT.NONE);
		lblNewLabel_phone_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_phone_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_phone_1.setText("成人数量");
		lblNewLabel_phone_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_phone_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_phone_1_1 = new Label(composite_141, SWT.NONE);
		lblNewLabel_phone_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_phone_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_phone_1_1.setText("儿童数量");
		lblNewLabel_phone_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_phone_1_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_in = new Label(composite_141, SWT.NONE);
		lblNewLabel_in.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_in.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_in.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_in.setText("入住时间");
		lblNewLabel_in.setAlignment(SWT.CENTER);

		Label lblNewLabel_out = new Label(composite_141, SWT.NONE);
		lblNewLabel_out.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_out.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_out.setText("离开时间");
		lblNewLabel_out.setAlignment(SWT.CENTER);
		lblNewLabel_out.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_6 = new Label(composite_141, SWT.NONE);
		lblNewLabel_6.setBackground(composite_141.getBackground());
		lblNewLabel_6.setAlignment(SWT.CENTER);

		Composite composite_142 = new Composite(composite_14, SWT.NONE);
		composite_142.setLayoutData(new RowData(238, 260));
		composite_142.setLayout(new FillLayout(SWT.VERTICAL));

		Composite composite_13 = new Composite(composite_14, SWT.NONE);
		composite_13.setLayoutData(new RowData(90, SWT.DEFAULT));
		composite_13.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		text_name = new Text(composite_142, SWT.BORDER);

		text_roomtype = new Text(composite_142, SWT.BORDER);

		text_idnum = new Text(composite_142, SWT.BORDER);

		FocusListener listener = new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO 自动生成的方法存根
				String idnum = text_idnum.getText();
				if (idnum.length() == 18) // 身份证长度判断
				{// 利用身份证校验码校验
					int b[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
					int sum = 0;
					for (int i = 0; i < 17; i++)
						sum += (idnum.charAt(i) - 48) * b[i];
					sum %= 11;
					sum = 12 - sum;
					if (sum == 12)
						sum = 0;
					if (sum == 11)
						sum = 1;
					// 校验位应该与sum相等，注意考虑sum==10时校验位为X
					if (sum == idnum.charAt(17) - 48
							|| (sum == 10 && (idnum.charAt(17) == 'X' || idnum.charAt(17) == 'x'))) {// 校验码通过
						if (idnum.charAt(16) % 2 == 1)// 性别自动填入
							text_gender.setText("男");
						else
							text_gender.setText("女");
						String birth = idnum.substring(6, 14);
						// 年龄自动填入
						String birthyear = birth.substring(0, 4), birthmonth = birth.substring(4, 6),
								birthday = birth.substring(6, 8);
						int birthyearnum = Integer.parseInt(birthyear), birthmonthnum = Integer.parseInt(birthmonth),
								birthdaynum = Integer.parseInt(birthday);
						text_birth.setText(birthyearnum + "-" + birthmonthnum + "-" + birthdaynum);
						// 算年龄（周岁）
						LocalDate date = LocalDate.now();
						int nowyear = date.getYear(), nowmonth = date.getMonthValue(), nowday = date.getDayOfMonth();
						int age = nowyear - birthyearnum;
						if (nowmonth > birthmonthnum) {
						} else if (nowmonth < birthmonthnum)
							age -= 1;
						else {
							if (nowday < birthdaynum)
								age -= 1;
						}
						text_age.setText(Integer.toString(age));

					} else {// 身份证校验码错误
						lblNewLabel_warn.setText("身份证错误");
						Runnable timer = new Runnable() {
							@Override
							public void run() {
								if (!isDisposed())
									lblNewLabel_warn.setText("");
							}
						};
						Display.getDefault().timerExec(5000, timer);
					}
				} else {// 身份证长度不满足
					lblNewLabel_warn.setText("身份证长度错误");
					Runnable timer = new Runnable() {
						@Override
						public void run() {
							if (!isDisposed())
								lblNewLabel_warn.setText("");
						}
					};
					Display.getDefault().timerExec(5000, timer);
				}

			}

		};
		text_idnum.addFocusListener(listener);

		text_phone = new Text(composite_142, SWT.BORDER);

		text = new Text(composite_142, SWT.BORDER);

		text_1 = new Text(composite_142, SWT.BORDER);

		DateTime dateTime_in = new DateTime(composite_142, SWT.BORDER);

		DateTime dateTime_out = new DateTime(composite_142, SWT.BORDER);

		Button btnNewButton_inputinfo = new Button(composite_142, SWT.NONE);
		btnNewButton_inputinfo.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));
		btnNewButton_inputinfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnNewButton_inputinfo.setText("确认");
		composite_13.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_birth = new Label(composite_13, SWT.NONE);
		lblNewLabel_birth.setText("出生日期");
		lblNewLabel_birth.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_birth.setAlignment(SWT.CENTER);

		text_birth = new Text(composite_13, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_age = new Label(composite_13, SWT.NONE);
		lblNewLabel_age.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_age.setAlignment(SWT.CENTER);
		lblNewLabel_age.setText("年龄");

		text_age = new Text(composite_13, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_gender = new Label(composite_13, SWT.NONE);
		lblNewLabel_gender.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_gender.setText("性别");
		lblNewLabel_gender.setAlignment(SWT.CENTER);

		text_gender = new Text(composite_13, SWT.BORDER | SWT.CENTER);

		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("酒店管理系统");
		setSize(800, 450);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
