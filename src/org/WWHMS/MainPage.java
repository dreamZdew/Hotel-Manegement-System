package org.WWHMS;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/*主界面*/

public class MainPage extends Shell {
	private Text text_name;
	private Text text_idnum;
	private Text text_phone;
	private Text text_age;
	private Text text_gender;
	private Text text_birth;
	private Text text_adult;
	private Text text_child;
	private Text text_othername;
	private Text text_otherid;
	private Text text_otherphone;
	private Text text_otherbirth;
	private Text text_otherage;
	private Text text_othergender;
	private Table table;
	private int cursorrow,cursorcol;
	private Table table_1;
	private Text text;
	private Text text_1;
	private Text text_3;
	private Text text_4;
	private Text text_2;
	private Text text_totalprice;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MainPage shell = new MainPage(display);
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
	public MainPage(Display display) {

		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(new FillLayout(SWT.HORIZONTAL));

		OrderList orderlist = new OrderList();

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

		Composite composite_2 = new Composite(composite_MainofMain, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_2 = new RowLayout(SWT.VERTICAL);
		rl_composite_2.justify = true;
		rl_composite_2.center = true;
		composite_2.setLayout(rl_composite_2);

		Label lblNewLabel_1 = new Label(composite_2, SWT.WRAP);
		lblNewLabel_1.setLayoutData(new RowData(634, -1));
		lblNewLabel_1.setText("\u968F\u884C\u4EBA\u5458\u767B\u8BB0");
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("黑体", 30, SWT.NORMAL));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_warn_1 = new Label(composite_2, SWT.CENTER);
		lblNewLabel_warn_1.setLayoutData(new RowData(294, 32));
		lblNewLabel_warn_1.setText("");
		lblNewLabel_warn_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_warn_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_warn_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_22 = new Composite(composite_2, SWT.NONE);
		composite_22.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite_22.setLayoutData(new RowData(385, 39));
		composite_22.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_roomtypel_22 = new Label(composite_22, SWT.NONE);
		lblNewLabel_roomtypel_22.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_roomtypel_22.setAlignment(SWT.CENTER);
		lblNewLabel_roomtypel_22.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_roomtypel_22.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_roomtypel_22.setText("房间类型");

		Label lblNewLabel_roomtype_22 = new Label(composite_22, SWT.NONE);
		lblNewLabel_roomtype_22.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_roomtype_22.setAlignment(SWT.CENTER);
		lblNewLabel_roomtype_22.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_roomtype_22.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_roomtype_22.setText("");

		Label lblNewLabel_roomnumberl_22 = new Label(composite_22, SWT.NONE);
		lblNewLabel_roomnumberl_22.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_roomnumberl_22.setAlignment(SWT.CENTER);
		lblNewLabel_roomnumberl_22.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_roomnumberl_22.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_roomnumberl_22.setText("房间号");

		Label lblNewLabel_roomnumber_22 = new Label(composite_22, SWT.NONE);
		lblNewLabel_roomnumber_22.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_roomnumber_22.setAlignment(SWT.CENTER);
		lblNewLabel_roomnumber_22.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_roomnumber_22.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_roomnumber_22.setText("");

		Composite composite_21 = new Composite(composite_2, SWT.NONE);
		composite_21.setLayoutData(new RowData(SWT.DEFAULT, 201));
		composite_21.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_21.setLayout(new RowLayout(SWT.HORIZONTAL));

		Composite composite_211 = new Composite(composite_21, SWT.NONE);
		composite_211.setLayoutData(new RowData(-1, 159));
		composite_211.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_211.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_name_1 = new Label(composite_211, SWT.NONE);
		lblNewLabel_name_1.setText("\u59D3\u540D");
		lblNewLabel_name_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_name_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_name_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_name_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_idnum_1 = new Label(composite_211, SWT.NONE);
		lblNewLabel_idnum_1.setText("\u8EAB\u4EFD\u8BC1\u53F7");
		lblNewLabel_idnum_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_idnum_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_idnum_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_idnum_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_phone_2 = new Label(composite_211, SWT.NONE);
		lblNewLabel_phone_2.setText("\u624B\u673A\u53F7");
		lblNewLabel_phone_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_phone_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_phone_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_phone_2.setAlignment(SWT.CENTER);

		Label lblNewLabel_6_1 = new Label(composite_211, SWT.NONE);
		lblNewLabel_6_1.setBackground(SWTResourceManager.getColor(0, 120, 215));
		lblNewLabel_6_1.setAlignment(SWT.CENTER);

		Composite composite_212 = new Composite(composite_21, SWT.NONE);
		composite_212.setLayoutData(new RowData(238, 158));
		composite_212.setLayout(new FillLayout(SWT.VERTICAL));

		text_othername = new Text(composite_212, SWT.BORDER);

		text_otherid = new Text(composite_212, SWT.BORDER);
		FocusListener otherid_listener = new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO 自动生成的方法存根
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO 自动生成的方法存根
				Idnumber idnumber = new Idnumber();
				idnumber.idnum = text_otherid.getText();
				if (idnumber.islegal(idnumber.idnum)) {
					text_othergender.setText(idnumber.gender);
					text_otherbirth.setText(idnumber.birth);
					text_otherage.setText(idnumber.sage);
				} else {
					lblNewLabel_warn_1.setText("身份证错误");
					Runnable timer = new Runnable() {
						@Override
						public void run() {
							if (!isDisposed())
								lblNewLabel_warn_1.setText("");
						}
					};
					Display.getDefault().timerExec(5000, timer);
				}
			}
		};
		text_otherid.addFocusListener(otherid_listener);

		text_otherphone = new Text(composite_212, SWT.BORDER);

		Button btnNewButton_inputother = new Button(composite_212, SWT.NONE);
		btnNewButton_inputother.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Idnumber idnumber = new Idnumber();
				idnumber.idnum = text_otherid.getText();

				if ((!text_othername.getText().equals("")) && (!text_otherid.getText().equals(""))
						&& (!text_otherbirth.getText().equals("")) && (!text_otherage.getText().equals(""))
						&& (!text_othergender.getText().equals("")) && idnumber.islegal(idnumber.idnum)) {// 随行人员必要信息不为空
					Customer customer = new Customer();
					customer.setAge(Integer.parseInt(text_otherage.getText()));
					customer.setBirthday(text_otherbirth.getText());
					customer.setGender(text_othergender.getText());
					customer.setId(text_otherid.getText());
					customer.setName(text_othername.getText());
					customer.setPhone(text_otherphone.getText());
					customer = Customer.inputdata(customer);

					TableItem tableitem = new TableItem(table, SWT.NULL);
					tableitem.setText(new String[] { customer.getNumber(), customer.getName(),
							orderlist.getRoomnumber(), customer.getPhone(), customer.getId() });
					text_otherage.setText("");
					text_otherbirth.setText("");
					text_othergender.setText("");
					text_othername.setText("");
					text_otherphone.setText("");
					text_otherid.setText("");

					lblNewLabel_warn_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					lblNewLabel_warn_1.setText("添加随行人员成功");
					Runnable timer = new Runnable() {
						@Override
						public void run() {
							if (!isDisposed())
								lblNewLabel_warn_1.setText("");
						}
					};
					Display.getDefault().timerExec(5000, timer);
					text_othername.setFocus();

				} else {// 缺乏必要信息
					lblNewLabel_warn_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblNewLabel_warn_1.setText("缺乏必要信息");
					Runnable timer = new Runnable() {
						@Override
						public void run() {
							if (!isDisposed())
								lblNewLabel_warn_1.setText("");
						}
					};
					Display.getDefault().timerExec(5000, timer);
				}
			}
		});
		btnNewButton_inputother.setText("添加随行人员");
		btnNewButton_inputother.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));

		Composite composite_213 = new Composite(composite_21, SWT.NONE);
		composite_213.setLayoutData(new RowData(99, -1));
		composite_213.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_213.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_birth_1 = new Label(composite_213, SWT.NONE);
		lblNewLabel_birth_1.setText("\u51FA\u751F\u65E5\u671F");
		lblNewLabel_birth_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_birth_1.setAlignment(SWT.CENTER);

		text_otherbirth = new Text(composite_213, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_age_1 = new Label(composite_213, SWT.NONE);
		lblNewLabel_age_1.setText("\u5E74\u9F84");
		lblNewLabel_age_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_age_1.setAlignment(SWT.CENTER);

		text_otherage = new Text(composite_213, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_gender_1 = new Label(composite_213, SWT.NONE);
		lblNewLabel_gender_1.setText("\u6027\u522B");
		lblNewLabel_gender_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_gender_1.setAlignment(SWT.CENTER);

		text_othergender = new Text(composite_213, SWT.BORDER | SWT.CENTER);

		Composite composite_3 = new Composite(composite_MainofMain, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_3 = new RowLayout(SWT.VERTICAL);
		rl_composite_3.center = true;
		rl_composite_3.justify = true;
		composite_3.setLayout(rl_composite_3);

		Composite composite_31 = new Composite(composite_3, SWT.NONE);
		RowLayout rl_composite_31 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_31.wrap = false;
		composite_31.setLayout(rl_composite_31);
		composite_31.setLayoutData(new RowData(288, 38));
		composite_31.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_2 = new Label(composite_31, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_2.setLayoutData(new RowData(SWT.DEFAULT, 27));
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setText("订单号");
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label showordernum = new Label(composite_31, SWT.NONE);
		showordernum.setAlignment(SWT.CENTER);
		showordernum.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		showordernum.setLayoutData(new RowData(242, 27));
		showordernum.setText("");
		showordernum.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		showordernum.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblNewLabel_3 = new Label(composite_3, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setLayoutData(new RowData(268, SWT.DEFAULT));
		lblNewLabel_3.setText("双击删除客人");

		table = new Table(composite_3, SWT.FULL_SELECTION | SWT.MULTI);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new RowData(593, 195));

		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("客人编号");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("姓名");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("房间号");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(125);
		tblclmnNewColumn_2.setText("手机号");

		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(200);
		tblclmnNewColumn_3.setText("身份证号");

		Composite composite_32 = new Composite(composite_3, SWT.NONE);
		composite_32.setLayoutData(new RowData(406, 50));
		composite_32.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_32 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_32.justify = true;
		composite_32.setLayout(rl_composite_32);

		final TableCursor cursor = new TableCursor(table, SWT.FULL_SELECTION);// 鼠标对表格监听
		cursor.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				cursorrow = table.getSelectionIndex();
				cursorcol = cursor.getColumn();
				if (cursorrow != 0)
					table.remove(cursorrow);
			}
		});

		Button btnNewButton_inputinfo_1_2 = new Button(composite_32, SWT.NONE);
		btnNewButton_inputinfo_1_2.setLayoutData(new RowData(158, SWT.DEFAULT));
		btnNewButton_inputinfo_1_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// 将订单插入数据库，链接客人和订单

				OrderList.addtoDatabase(orderlist);// 订单插入数据库

				// 链接客人和订单
				for (int i = 0; i < table.getItemCount(); i++) {
					TableItem t = table.getItem(i);
					System.out.println(t.getText(0));
					try {// 数据库写入数据
						Connection conn = AboutDB.loginDB();
						PreparedStatement prep = conn.prepareStatement("insert into CustOrder values(?,?)");
						prep.setString(1, t.getText(0));
						prep.setString(2, orderlist.getNumber());
						prep.executeUpdate();
					} catch (SQLException ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					}
				}

			}
		});
		btnNewButton_inputinfo_1_2.setText("确认订单");
		btnNewButton_inputinfo_1_2.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));

		Composite composite_4 = new Composite(composite_MainofMain, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_4 = new RowLayout(SWT.VERTICAL);
		rl_composite_4.justify = true;
		rl_composite_4.center = true;
		composite_4.setLayout(rl_composite_4);

		Label lblNewLabel_4 = new Label(composite_4, SWT.NONE);
		lblNewLabel_4.setLayoutData(new RowData(150, 39));
		lblNewLabel_4.setText("\u53CC\u51FB\u7ED3\u7B97\u6307\u5B9A\u8BA2\u5355");
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_4.setAlignment(SWT.CENTER);

		table_1 = new Table(composite_4, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLayoutData(new RowData(672, 237));
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);

		TableColumn tblclmnNewColumn_5 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("\u8BA2\u5355\u7F16\u53F7");

		TableColumn tblclmnNewColumn_1_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_1_1.setWidth(100);
		tblclmnNewColumn_1_1.setText("\u4E0B\u5355\u65F6\u95F4");

		TableColumn tblclmnNewColumn_2_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_2_1.setWidth(100);
		tblclmnNewColumn_2_1.setText("\u5BA2\u4EBA\u7F16\u53F7");

		TableColumn tblclmnNewColumn_3_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_3_1.setWidth(100);
		tblclmnNewColumn_3_1.setText("\u623F\u95F4\u7F16\u53F7");

		TableColumn tblclmnNewColumn_4_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_4_1.setWidth(100);
		tblclmnNewColumn_4_1.setText("\u5165\u4F4F\u65F6\u95F4");

		TableColumn tblclmnNewColumn_5_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_5_1.setWidth(100);
		tblclmnNewColumn_5_1.setText("\u9000\u623F\u65F6\u95F4");

		TableColumn tblclmnNewColumn_6 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("\u8BA2\u5355\u72B6\u6001");

		Composite composite_5 = new Composite(composite_MainofMain, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_5 = new RowLayout(SWT.VERTICAL);
		rl_composite_5.center = true;
		composite_5.setLayout(rl_composite_5);

		Composite composite_51 = new Composite(composite_5, SWT.NONE);
		composite_51.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_51.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_51.setLayout(new GridLayout(2, false));
		composite_51.setLayoutData(new RowData(619, 110));

		Label lblNewLabel_3_1 = new Label(composite_51, SWT.NONE);
		lblNewLabel_3_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_3_1.setAlignment(SWT.CENTER);
		lblNewLabel_3_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel_3_1.setText("\u8BA2\u5355\u53F7");

		Label lblNewLabel_4_1 = new Label(composite_51, SWT.NONE);
		GridData gd_lblNewLabel_4_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_4_1.heightHint = 40;
		gd_lblNewLabel_4_1.widthHint = 540;
		lblNewLabel_4_1.setLayoutData(gd_lblNewLabel_4_1);
		lblNewLabel_4_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_4_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_4_1.setAlignment(SWT.CENTER);
		lblNewLabel_4_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel_4_1.setText("");

		Label lblNewLabel_3_1_1 = new Label(composite_51, SWT.NONE);
		lblNewLabel_3_1_1.setText("客人姓名");
		lblNewLabel_3_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel_3_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_3_1_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_4_1_1 = new Label(composite_51, SWT.NONE);
		GridData gd_lblNewLabel_4_1_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_4_1_1.widthHint = 539;
		gd_lblNewLabel_4_1_1.heightHint = 34;
		lblNewLabel_4_1_1.setLayoutData(gd_lblNewLabel_4_1_1);
		lblNewLabel_4_1_1.setAlignment(SWT.CENTER);
		lblNewLabel_4_1_1.setText("");
		lblNewLabel_4_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_4_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel_4_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_52 = new Composite(composite_5, SWT.NONE);
		composite_52.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_52.setLayoutData(new RowData(527, 34));
		composite_52.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_4_1 = new Composite(composite_52, SWT.NONE);
		composite_4_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_4_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		RowLayout rl_composite_4_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_4_1.justify = true;
		composite_4_1.setLayout(rl_composite_4_1);

		Label lblNewLabel_1_1 = new Label(composite_4_1, SWT.NONE);
		lblNewLabel_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1_1.setText("\u5165\u4F4F\u65F6\u95F4");

		text = new Text(composite_4_1, SWT.BORDER);
		text.setLayoutData(new RowData(120, SWT.DEFAULT));

		Composite composite_4_1_1 = new Composite(composite_52, SWT.NONE);
		composite_4_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_4_1_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_4_1_1.justify = true;
		composite_4_1_1.setLayout(rl_composite_4_1_1);

		Label lblNewLabel_1_1_1 = new Label(composite_4_1_1, SWT.NONE);
		lblNewLabel_1_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1_1_1.setText("\u9000\u623F\u65F6\u95F4");

		text_1 = new Text(composite_4_1_1, SWT.BORDER);
		text_1.setLayoutData(new RowData(120, SWT.DEFAULT));

		Composite composite_52_1 = new Composite(composite_5, SWT.NONE);
		composite_52_1.setLayoutData(new RowData(345, 34));
		composite_52_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_4_1_2 = new Composite(composite_52_1, SWT.NONE);
		composite_4_1_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_4_1_2 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_4_1_2.justify = true;
		composite_4_1_2.setLayout(rl_composite_4_1_2);

		Label lblNewLabel_1_1_2 = new Label(composite_4_1_2, SWT.NONE);
		lblNewLabel_1_1_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1_1_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1_1_2.setText("房间种类");

		text_3 = new Text(composite_4_1_2, SWT.BORDER);

		Composite composite_4_1_1_1 = new Composite(composite_52_1, SWT.NONE);
		composite_4_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_4_1_1_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_4_1_1_1.justify = true;
		composite_4_1_1_1.setLayout(rl_composite_4_1_1_1);

		Label lblNewLabel_1_1_1_1 = new Label(composite_4_1_1_1, SWT.NONE);
		lblNewLabel_1_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1_1_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1_1_1_1.setText("价格");

		text_4 = new Text(composite_4_1_1_1, SWT.BORDER);

		Composite composite_52_1_1 = new Composite(composite_5, SWT.NONE);
		composite_52_1_1.setLayoutData(new RowData(345, 34));
		composite_52_1_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_4_1_2_1 = new Composite(composite_52_1_1, SWT.NONE);
		composite_4_1_2_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_4_1_2_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_4_1_2_1.justify = true;
		composite_4_1_2_1.setLayout(rl_composite_4_1_2_1);

		Label lblNewLabel_1_1_2_1 = new Label(composite_4_1_2_1, SWT.NONE);
		lblNewLabel_1_1_2_1.setText("总时间");
		lblNewLabel_1_1_2_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1_1_2_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		text_2 = new Text(composite_4_1_2_1, SWT.BORDER);

		Composite composite_4_1_1_1_1 = new Composite(composite_52_1_1, SWT.NONE);
		composite_4_1_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_4_1_1_1_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_4_1_1_1_1.justify = true;
		composite_4_1_1_1_1.setLayout(rl_composite_4_1_1_1_1);

		Label lblNewLabel_1_1_1_1_1 = new Label(composite_4_1_1_1_1, SWT.NONE);
		lblNewLabel_1_1_1_1_1.setText("总价格");
		lblNewLabel_1_1_1_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1_1_1_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		text_totalprice = new Text(composite_4_1_1_1_1, SWT.BORDER);

		Label lblNewLabel_5 = new Label(composite_5, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_5.setLayoutData(new RowData(192, 33));
		lblNewLabel_5.setAlignment(SWT.CENTER);
		lblNewLabel_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Button btnNewButton = new Button(composite_5, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!text_totalprice.getText().equals("") && !lblNewLabel_4_1.getText().equals("")) {
					Double.parseDouble(text_totalprice.getText());
					String checkordernum = lblNewLabel_4_1.getText();
					try {
						Connection conn = AboutDB.loginDB();
						PreparedStatement prep = conn
								.prepareStatement("select 订单状态 from OrderList where 订单编号=? and 订单状态!=0");
						prep.setString(1, checkordernum);
						ResultSet rs = prep.executeQuery();
						
						
						
						if (rs.next()) {
							prep = conn.prepareStatement("update OrderList set 订单状态=0 where 订单编号=?");
							prep.setString(1, checkordernum);
							prep.executeUpdate();
							lblNewLabel_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
							lblNewLabel_5.setText("结算成功");
							Runnable timer = new Runnable() {
								@Override
								public void run() {
									if (!isDisposed())
										lblNewLabel_5.setText("");
								}
							};
							Display.getDefault().timerExec(5000, timer);
						}else {
							lblNewLabel_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
							lblNewLabel_5.setText("找不到订单，或已结算");
							Runnable timer = new Runnable() {
								@Override
								public void run() {
									if (!isDisposed())
										lblNewLabel_5.setText("");
								}
							};
							Display.getDefault().timerExec(5000, timer);
						}

						
					} catch (Exception ee) {
						// TODO: handle exception
						ee.printStackTrace();
					}
				} else {
					lblNewLabel_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblNewLabel_5.setText("信息不完全，结算失败");
					Runnable timer = new Runnable() {
						@Override
						public void run() {
							if (!isDisposed())
								lblNewLabel_5.setText("");
						}
					};
					Display.getDefault().timerExec(5000, timer);
				}
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		btnNewButton.setLayoutData(new RowData(153, 60));
		btnNewButton.setText("结算");

		Composite composite_6 = new Composite(composite_MainofMain, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_7 = new Composite(composite_MainofMain, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		stackLayoutforMain.topControl = composite_1;
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
		btnNewButton_1.setText("新建订单");

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
		btnNewButton_2.setText("随行人员");

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
		btnNewButton_3.setText("查看订单");

		Button btnNewButton_4 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table_1.removeAll();
				try {
					Connection conn = AboutDB.loginDB();
					PreparedStatement prep = conn
							.prepareStatement("SELECT 订单编号,下单时间,客人编号,房间编号,入住时间,退房时间,订单状态 FROM OrderList where 订单状态!=0");
					ResultSet rs = prep.executeQuery();
					while (rs.next()) {
						TableItem tableitem = new TableItem(table_1, SWT.NULL);
						tableitem.setText(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) });

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
		btnNewButton_4.setText("结算订单");

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
		btnNewButton_5.setText("缴费");

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

		Composite composite_11 = new Composite(composite_1, SWT.NONE);
		composite_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_11 = new RowLayout(SWT.HORIZONTAL);
		composite_11.setLayout(rl_composite_11);

		Composite composite_111 = new Composite(composite_11, SWT.NONE);
		composite_111.setLayoutData(new RowData(SWT.DEFAULT, 260));
		composite_111.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_111.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_name = new Label(composite_111, SWT.NONE);
		lblNewLabel_name.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_name.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_name.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_name.setText("姓名");
		lblNewLabel_name.setAlignment(SWT.CENTER);

		Label lblNewLabel_roomtype = new Label(composite_111, SWT.NONE);
		lblNewLabel_roomtype.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_roomtype.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_roomtype.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_roomtype.setAlignment(SWT.CENTER);
		lblNewLabel_roomtype.setText("房间类型");

		Label lblNewLabel_idnum = new Label(composite_111, SWT.NONE);
		lblNewLabel_idnum.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_idnum.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_idnum.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_idnum.setText("身份证号");
		lblNewLabel_idnum.setAlignment(SWT.CENTER);

		Label lblNewLabel_phone = new Label(composite_111, SWT.NONE);
		lblNewLabel_phone.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_phone.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_phone.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_phone.setText("手机号");
		lblNewLabel_phone.setAlignment(SWT.CENTER);

		Label lblNewLabel_adult = new Label(composite_111, SWT.NONE);
		lblNewLabel_adult.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_adult.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_adult.setText("成人数量");
		lblNewLabel_adult.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_adult.setAlignment(SWT.CENTER);

		Label lblNewLabel_child = new Label(composite_111, SWT.NONE);
		lblNewLabel_child.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_child.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_child.setText("儿童数量");
		lblNewLabel_child.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_child.setAlignment(SWT.CENTER);

		Label lblNewLabel_in = new Label(composite_111, SWT.NONE);
		lblNewLabel_in.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_in.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_in.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_in.setText("入住时间");
		lblNewLabel_in.setAlignment(SWT.CENTER);

		Label lblNewLabel_out = new Label(composite_111, SWT.NONE);
		lblNewLabel_out.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_out.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_out.setText("离开时间");
		lblNewLabel_out.setAlignment(SWT.CENTER);
		lblNewLabel_out.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_6 = new Label(composite_111, SWT.NONE);
		lblNewLabel_6.setBackground(composite_111.getBackground());
		lblNewLabel_6.setAlignment(SWT.CENTER);

		Composite composite_112 = new Composite(composite_11, SWT.NONE);
		composite_112.setLayoutData(new RowData(238, 260));
		composite_112.setLayout(new FillLayout(SWT.VERTICAL));

		Composite composite_113 = new Composite(composite_11, SWT.NONE);
		composite_113.setLayoutData(new RowData(99, SWT.DEFAULT));
		composite_113.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		text_name = new Text(composite_112, SWT.BORDER);

		Combo combo_roomtype = new Combo(composite_112, SWT.READ_ONLY);

		try {
			Connection conn = AboutDB.loginDB();
			PreparedStatement prep = conn.prepareStatement("select 房间类型 from RoomType order by 房间价格");
			ResultSet rs = prep.executeQuery();
			boolean hascomboinit = false;
			while (rs.next()) {
				combo_roomtype.add(rs.getString(1));
				if (hascomboinit == false) {
					combo_roomtype.setText(rs.getString(1));
					hascomboinit = true;
				}
			}
			conn.close();
			rs.close();
			prep.close();
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		FocusListener roomtype_listener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO 自动生成的方法存根
				String roomtype = combo_roomtype.getText();
				if (roomtype.contains("单人"))
					text_adult.setText("1");
				else if (roomtype.contains("双人"))
					text_adult.setText("2");
				else if (roomtype.contains("三人"))
					text_adult.setText("3");

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO 自动生成的方法存根

			}
		};
		combo_roomtype.addFocusListener(roomtype_listener);

		text_idnum = new Text(composite_112, SWT.BORDER);

		FocusListener idnum_listener = new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO 自动生成的方法存根
				Idnumber idnumber = new Idnumber();
				idnumber.idnum = text_idnum.getText();
				if (idnumber.islegal(idnumber.idnum)) {
					text_gender.setText(idnumber.gender);
					text_birth.setText(idnumber.birth);
					text_age.setText(idnumber.sage);
				}

				else {
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
			}
		};

		text_idnum.addFocusListener(idnum_listener);

		text_phone = new Text(composite_112, SWT.BORDER);

		text_adult = new Text(composite_112, SWT.BORDER);
		text_adult.setText("1");

		text_child = new Text(composite_112, SWT.BORDER);
		text_child.setText("0");

		Composite composite_9 = new Composite(composite_112, SWT.NONE);
		RowLayout rl_composite_9 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_9.wrap = false;
		composite_9.setLayout(rl_composite_9);

		DateTime date_in = new DateTime(composite_9, SWT.BORDER);
		date_in.setLayoutData(new RowData(149, SWT.DEFAULT));

		DateTime time_in = new DateTime(composite_9, SWT.BORDER | SWT.TIME | SWT.SHORT);
		time_in.setLayoutData(new RowData(80, SWT.DEFAULT));

		Composite composite_10 = new Composite(composite_112, SWT.NONE);
		composite_10.setLayout(new RowLayout(SWT.HORIZONTAL));

		DateTime date_out = new DateTime(composite_10, SWT.BORDER);
		date_out.setLayoutData(new RowData(149, SWT.DEFAULT));

		DateTime time_out = new DateTime(composite_10, SWT.BORDER | SWT.TIME | SWT.SHORT);
		time_out.setLayoutData(new RowData(80, SWT.DEFAULT));

		Button btnNewButton_inputinfo = new Button(composite_112, SWT.NONE);
		btnNewButton_inputinfo.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));
		TableItem firsttableitem = new TableItem(table, SWT.NULL);
		btnNewButton_inputinfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.clearAll();
				// 自动生成订单号，查询客户是否存在，若不存在则生产客户编码
				Idnumber idnumber = new Idnumber();
				idnumber.idnum = text_idnum.getText();

				if ((!text_adult.getText().equals("")) && (!text_child.getText().equals(""))
						&& (!text_name.getText().equals("")) && (!text_idnum.getText().equals(""))
						&& (!text_age.getText().equals("")) && (!text_gender.getText().equals(""))
						&& (!text_birth.getText().equals("")) && idnumber.islegal(idnumber.idnum)) {// 必要信息不为空
					Customer customer = new Customer();
					customer.setName(text_name.getText());
					customer.setId(text_idnum.getText());
					customer.setPhone(text_phone.getText());
					customer.setBirthday(text_birth.getText());
					customer.setGender(text_gender.getText());
					customer.setAge(Integer.parseInt(text_age.getText()));

					String roomtype = combo_roomtype.getText();

					int adultnum = Integer.parseInt(text_adult.getText());
					int childnum = Integer.parseInt(text_child.getText());

					// 格式化入住退房时间并录入
					String datetime_in = Integer.toString(date_in.getYear()) + "-"
							+ Integer.toString(date_in.getMonth() + 1) + "-" + Integer.toString(date_in.getDay()) + " "
							+ Integer.toString(time_in.getHours()) + ":" + Integer.toString(time_in.getMinutes()) + ":"
							+ Integer.toString(time_in.getSeconds());
					String datetime_out = Integer.toString(date_out.getYear()) + "-"
							+ Integer.toString(date_out.getMonth() + 1) + "-" + Integer.toString(date_out.getDay())
							+ " " + Integer.toString(time_out.getHours()) + ":"
							+ Integer.toString(time_out.getMinutes()) + ":" + Integer.toString(time_out.getSeconds());

					customer = Customer.inputdata(customer);

					boolean cancreateorder = false;
					// 判断是否有空房间
					// 在订单数据库中搜索指定时间空闲的房间
					/* 搜索预约状态和正在进行状态的订单，找出空房间 */
					try {
						Connection conn = AboutDB.loginDB();
						PreparedStatement prep = conn
								.prepareStatement(" declare @in datetime,@out datetime, @type nvarchar(10)\r\n"
										+ "set @in= ? \r\n" + "set @out= ? \r\n" + "set @type=? \r\n" + "\r\n"
										+ "select 房间编号 from Room where 房间类型=@type and 房间编号 not in\r\n" + "\r\n"
										+ "(select distinct a.房间编号 from OrderList a join Room b on \r\n"
										+ "a.房间编号=b.房间编号 \r\n" + "and 房间类型=@type \r\n"
										+ "and ((@out>=入住时间 and @out<=退房时间) or (@in>=入住时间 and @in<=退房时间)) \r\n"
										+ "and (订单状态=3 or 订单状态=2 or 订单状态=1)) ");
						orderlist.setIntime(datetime_in);
						orderlist.setOuttime(datetime_out);
						prep.setString(1, orderlist.getIntime());
						prep.setString(2, orderlist.getOuttime());
						prep.setString(3, roomtype);
						ResultSet rs = prep.executeQuery();
						if (rs.next()) {// 已找到空房间
							orderlist.setRoomnumber(rs.getString(1));
							cancreateorder = true;
						} else {// 未找到空房间
							lblNewLabel_warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
							lblNewLabel_warn.setText("未找到空房间");
							Runnable timer = new Runnable() {
								@Override
								public void run() {
									if (!isDisposed())
										lblNewLabel_warn.setText("");
								}
							};
							Display.getDefault().timerExec(5000, timer);
						}

					} catch (Exception ee) {
						// TODO: handle exception
						ee.printStackTrace();
					}

					if (cancreateorder == true) {// 有空房间，能创建订单
						// 将房间类型和房间号放在随行人员添加界面上
						lblNewLabel_roomtype_22.setText(roomtype);
						// 将客户插入table，订单数据生成，显示在订单表上
						LocalDateTime localdatetime = LocalDateTime.now();// 订单生成时间

						firsttableitem.setText(new String[] { customer.getNumber(), customer.getName(),
								orderlist.getRoomnumber(), customer.getPhone(), customer.getId() });

						orderlist.setNumber(Long.toString(System.currentTimeMillis()));
						orderlist.setCustomernumber(customer.getNumber());
						orderlist.setOrdertime(localdatetime.getYear() + "-" + localdatetime.getMonthValue() + "-"
								+ localdatetime.getDayOfMonth() + " " + localdatetime.getHour() + ":"
								+ localdatetime.getMinute() + ":" + localdatetime.getSecond());
						showordernum.setText(orderlist.getNumber());
						lblNewLabel_roomnumber_22.setText(orderlist.getRoomnumber());
						if (adultnum + childnum > 1) {
							stackLayoutforMain.topControl = composite_2;
							composite_MainofMain.layout();
						} else {
							stackLayoutforMain.topControl = composite_3;
							composite_MainofMain.layout();
						}

						// 将订单数据写入数据库，链接客人和订单

						//
					}

				} else {// 缺乏必要信息
					lblNewLabel_warn.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblNewLabel_warn.setText("缺乏必要信息");
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
		});
		btnNewButton_inputinfo.setText("生成订单");
		composite_113.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_birth = new Label(composite_113, SWT.NONE);
		lblNewLabel_birth.setText("出生日期");
		lblNewLabel_birth.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_birth.setAlignment(SWT.CENTER);

		text_birth = new Text(composite_113, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_age = new Label(composite_113, SWT.NONE);
		lblNewLabel_age.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_age.setAlignment(SWT.CENTER);
		lblNewLabel_age.setText("年龄");

		text_age = new Text(composite_113, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_gender = new Label(composite_113, SWT.NONE);
		lblNewLabel_gender.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_gender.setText("性别");
		lblNewLabel_gender.setAlignment(SWT.CENTER);

		text_gender = new Text(composite_113, SWT.BORDER | SWT.CENTER);

		final TableCursor cursor_table_1 = new TableCursor(table_1, SWT.FULL_SELECTION);// 鼠标对表格监听
		cursor_table_1.addMouseListener(new MouseAdapter() {// 结算订单
			public void mouseDown(MouseEvent e) {
				cursorrow = table_1.getSelectionIndex();
				cursorcol = cursor_table_1.getColumn();
				TableItem t = table_1.getItem(cursorrow);
				System.out.println(t.getText(0));
				lblNewLabel_4_1.setText(t.getText(0));
				String custnum = null, custname = null, roomnum = null, intime = null, outtime = null,
						roomtype = null, totaltime, price = null, totalprice;
				try {
					Connection conn = AboutDB.loginDB();
					PreparedStatement prep = conn
							.prepareStatement("SELECT 下单时间,客人编号,房间编号,入住时间,退房时间 FROM OrderList WHERE 订单编号=?");
					prep.setString(1, t.getText(0));
					ResultSet rs = prep.executeQuery();
					if (rs.next()) {
						rs.getString(1);
						custnum = rs.getString(2);
						roomnum = rs.getString(3);
						intime = rs.getString(4);
						outtime = rs.getString(5);
					}
					prep.close();
					rs.close();
					prep = conn.prepareStatement("SELECT 房间类型 FROM Room WHERE 房间编号=?");
					prep.setString(1, roomnum);
					rs = prep.executeQuery();
					if (rs.next()) {
						roomtype = rs.getString(1);
					}
					prep = conn.prepareStatement("SELECT 姓名 FROM Customer WHERE 客人编号=?");
					prep.setString(1, custnum);
					rs = prep.executeQuery();
					if (rs.next()) {
						custname = rs.getString(1);
					}
					prep = conn.prepareStatement("SELECT 房间价格 FROM Roomtype WHERE 房间类型=?");
					prep.setString(1, roomtype);
					rs = prep.executeQuery();
					if (rs.next()) {
						price = rs.getString(1);
					}
					lblNewLabel_4_1_1.setText(custname);
					text.setText(intime);
					text_1.setText(outtime);
					text_3.setText(roomtype);
					text_4.setText(price);

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss.S");
					LocalDateTime datein = LocalDateTime.parse(intime, dtf);
					LocalDateTime dateout = LocalDateTime.parse(outtime, dtf);

					Duration duration = java.time.Duration.between(datein, dateout);
					System.out.println(duration.toDays());
					System.out.println(duration.toHoursPart());
					totaltime = String.valueOf(duration.toDays());
					String totaltimehourpart = String.valueOf(duration.toHoursPart());
					text_2.setText(totaltime + "天" + totaltimehourpart + "小时");

					double totalp = Double.valueOf(price) * Double.valueOf(totaltime);

					totalprice = String.valueOf(totalp);
					text_totalprice.setText(totalprice);

				} catch (Exception ee) {
					// TODO: handle exception
					ee.printStackTrace();
				}

				stackLayoutforMain.topControl = composite_5;
				composite_MainofMain.layout();
			}
		});

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
