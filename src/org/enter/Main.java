package org.enter;

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
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;

/*主界面*/

public class Main extends Shell {
	private Text text_name;
	private Text text_idnum;
	private Text text_phone;
	private Text text_roomtype;
	private Text text_age;
	private Text text_gender;

	/**
	 * Launch the application.
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
		GridData gd_composite_Buttons = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_composite_Buttons.heightHint = 384;
		composite_Buttons.setLayoutData(gd_composite_Buttons);
		
		Composite composite_MainofMain = new Composite(composite, SWT.NONE);
		composite_MainofMain.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		final StackLayout stackLayout = new StackLayout();
		composite_MainofMain.setLayout(stackLayout);
		
		GridData gd_composite_MainofMain = new GridData(SWT.RIGHT, SWT.CENTER, true, true, 1, 1);
		gd_composite_MainofMain.widthHint = 677;
		gd_composite_MainofMain.heightHint = 401;
		composite_MainofMain.setLayoutData(gd_composite_MainofMain);
		
		Composite composite_1 = new Composite(composite_MainofMain, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_1.setLayout(new BorderLayout(0, 0));
		
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
		
		stackLayout.topControl=composite_1;
		composite_MainofMain.layout();
		
		Button btnNewButton_1 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					stackLayout.topControl=composite_1;
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
				stackLayout.topControl=composite_2;
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
				stackLayout.topControl=composite_3;
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
				stackLayout.topControl=composite_4;
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
				stackLayout.topControl=composite_5;
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
				stackLayout.topControl=composite_6;
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
				stackLayout.topControl=composite_7;
				composite_MainofMain.layout();
			}
		});
		btnNewButton_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_7.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_7.setText("New Button");
		
		
		
		Label lblNewLabel = new Label(composite_1, SWT.WRAP);
		lblNewLabel.setLayoutData(BorderLayout.NORTH);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel.setFont(SWTResourceManager.getFont("宋体", 30, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("酒店管理系统");
		
		Composite composite_11 = new Composite(composite_1, SWT.NONE);
		composite_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_11.setLayoutData(BorderLayout.SOUTH);
		
		Composite composite_12 = new Composite(composite_1, SWT.NONE);
		composite_12.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_12.setLayoutData(BorderLayout.WEST);
		
		Composite composite_13 = new Composite(composite_1, SWT.NONE);
		composite_13.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_13.setLayoutData(BorderLayout.EAST);
		
		text_age = new Text(composite_13, SWT.BORDER | SWT.CENTER);
		text_age.setBounds(0, 108, 50, 20);
		
		text_gender = new Text(composite_13, SWT.BORDER | SWT.CENTER);
		text_gender.setBounds(0, 148, 50, 20);
		
		Label lblNewLabel_age = new Label(composite_13, SWT.NONE);
		lblNewLabel_age.setAlignment(SWT.CENTER);
		lblNewLabel_age.setBounds(0, 88, 50, 20);
		lblNewLabel_age.setText("年龄");
		
		Label lblNewLabel_gender = new Label(composite_13, SWT.NONE);
		lblNewLabel_gender.setText("性别");
		lblNewLabel_gender.setAlignment(SWT.CENTER);
		lblNewLabel_gender.setBounds(0, 128, 50, 20);
		
		Label lblNewLabel_warn = new Label(composite_13, SWT.CENTER);
		lblNewLabel_warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_warn.setBounds(0, 0, 50, 88);
		lblNewLabel_warn.setText("");lblNewLabel_warn.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		
		Composite composite_14 = new Composite(composite_1, SWT.NONE);
		composite_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_14.setLayoutData(BorderLayout.CENTER);
		composite_14.setLayout(new FormLayout());
		
		Composite composite_141 = new Composite(composite_14, SWT.NONE);
		composite_141.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		FormData fd_composite_141 = new FormData();
		fd_composite_141.bottom = new FormAttachment(0, 287);
		fd_composite_141.right = new FormAttachment(0, 80);
		fd_composite_141.top = new FormAttachment(0, 7);
		fd_composite_141.left = new FormAttachment(0, 7);
		composite_141.setLayoutData(fd_composite_141);
		composite_141.setLayout(new FillLayout(SWT.VERTICAL));
		
		Label lblNewLabel_name = new Label(composite_141, SWT.NONE);
		lblNewLabel_name.setText("姓名");
		lblNewLabel_name.setAlignment(SWT.CENTER);
		
		Label lblNewLabel_roomtype = new Label(composite_141, SWT.NONE);
		lblNewLabel_roomtype.setAlignment(SWT.CENTER);
		lblNewLabel_roomtype.setText("房间类型");
		
		Label lblNewLabel_idnum = new Label(composite_141, SWT.NONE);
		lblNewLabel_idnum.setText("身份证号");
		lblNewLabel_idnum.setAlignment(SWT.CENTER);
		
		Label lblNewLabel_phone = new Label(composite_141, SWT.NONE);
		lblNewLabel_phone.setText("手机号");
		lblNewLabel_phone.setAlignment(SWT.CENTER);
		
		Label lblNewLabel_in = new Label(composite_141, SWT.NONE);
		lblNewLabel_in.setText("入住时间");
		lblNewLabel_in.setAlignment(SWT.CENTER);
		
		Label lblNewLabel_out = new Label(composite_141, SWT.NONE);
		lblNewLabel_out.setText("离开时间");
		lblNewLabel_out.setAlignment(SWT.CENTER);
		
		Label lblNewLabel_6 = new Label(composite_141, SWT.NONE);
		lblNewLabel_6.setText("New Label");
		lblNewLabel_6.setAlignment(SWT.CENTER);
		
		Composite composite_142 = new Composite(composite_14, SWT.NONE);
		FormData fd_composite_142 = new FormData();
		fd_composite_142.bottom = new FormAttachment(0, 287);
		fd_composite_142.right = new FormAttachment(0, 539);
		fd_composite_142.top = new FormAttachment(0, 7);
		fd_composite_142.left = new FormAttachment(0, 86);
		composite_142.setLayoutData(fd_composite_142);
		composite_142.setLayout(new FillLayout(SWT.VERTICAL));
		
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
				String idnum=text_idnum.getText();
				if(idnum.length()==18) {//身份证长度判断
					if(idnum.charAt(16)%2==1)
						text_gender.setText("男");
					else
						text_gender.setText("女");
					String birth=idnum.substring(6, 14);
					System.out.println(birth);
				}else {//身份证长度不满足
					lblNewLabel_warn.setText("身\n份\n证\n错\n误");
					Runnable timer = new Runnable() {@Override public void run() {if(!isDisposed())lblNewLabel_warn.setText("");}};
				Display.getDefault().timerExec(3000, timer);}

			}
			 
		 };
		 text_idnum.addFocusListener(listener);
		
		text_phone = new Text(composite_142, SWT.BORDER);
		
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
