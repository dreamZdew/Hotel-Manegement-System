package org.enter;

import java.sql.*;

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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/*主界面*/

public class Main extends Shell {
	private Text text_name;
	private Text text_idnum;
	private Text text_phone;
	private Text text_age;
	private Text text_gender;
	private Text text_birth;
	private Text text_adult;
	private Text text_child;
	private Text text_2;
	private Text text_4;
	private Text text_5;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_3;
	private Text text_6;
	private Text text_7;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Table table;
	private Text text_14;

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
		final StackLayout stackLayoutfor2 = new StackLayout();
		composite_2.setLayout(stackLayoutfor2);

		Composite composite_21 = new Composite(composite_2, SWT.NONE);
		composite_21.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_21 = new RowLayout(SWT.VERTICAL);
		rl_composite_21.justify = true;
		rl_composite_21.center = true;
		composite_21.setLayout(rl_composite_21);

		Label lblNewLabel_1 = new Label(composite_21, SWT.WRAP);
		lblNewLabel_1.setLayoutData(new RowData(634, -1));
		lblNewLabel_1.setText("\u968F\u884C\u4EBA\u5458\u767B\u8BB0");
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("黑体", 30, SWT.NORMAL));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_warn_1 = new Label(composite_21, SWT.CENTER);
		lblNewLabel_warn_1.setLayoutData(new RowData(294, 32));
		lblNewLabel_warn_1.setText("");
		lblNewLabel_warn_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_warn_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_warn_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_211 = new Composite(composite_21, SWT.NONE);
		composite_211.setLayoutData(new RowData(SWT.DEFAULT, 182));
		composite_211.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_211.setLayout(new RowLayout(SWT.HORIZONTAL));

		Composite composite_2111 = new Composite(composite_211, SWT.NONE);
		composite_2111.setLayoutData(new RowData(-1, 159));
		composite_2111.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_2111.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_name_1 = new Label(composite_2111, SWT.NONE);
		lblNewLabel_name_1.setText("\u59D3\u540D");
		lblNewLabel_name_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_name_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_name_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_name_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_idnum_1 = new Label(composite_2111, SWT.NONE);
		lblNewLabel_idnum_1.setText("\u8EAB\u4EFD\u8BC1\u53F7");
		lblNewLabel_idnum_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_idnum_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_idnum_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_idnum_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_phone_2 = new Label(composite_2111, SWT.NONE);
		lblNewLabel_phone_2.setText("\u624B\u673A\u53F7");
		lblNewLabel_phone_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_phone_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_phone_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_phone_2.setAlignment(SWT.CENTER);

		Label lblNewLabel_6_1 = new Label(composite_2111, SWT.NONE);
		lblNewLabel_6_1.setBackground(SWTResourceManager.getColor(0, 120, 215));
		lblNewLabel_6_1.setAlignment(SWT.CENTER);

		Composite composite_2112 = new Composite(composite_211, SWT.NONE);
		composite_2112.setLayoutData(new RowData(238, 158));
		composite_2112.setLayout(new FillLayout(SWT.VERTICAL));

		text_2 = new Text(composite_2112, SWT.BORDER);

		text_4 = new Text(composite_2112, SWT.BORDER);

		text_5 = new Text(composite_2112, SWT.BORDER);

		Button btnNewButton_inputinfo_1 = new Button(composite_2112, SWT.NONE);
		btnNewButton_inputinfo_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnNewButton_inputinfo_1.setText("\u786E\u8BA4");
		btnNewButton_inputinfo_1.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));

		Composite composite_2113 = new Composite(composite_211, SWT.NONE);
		composite_2113.setLayoutData(new RowData(90, -1));
		composite_2113.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_2113.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_birth_1 = new Label(composite_2113, SWT.NONE);
		lblNewLabel_birth_1.setText("\u51FA\u751F\u65E5\u671F");
		lblNewLabel_birth_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_birth_1.setAlignment(SWT.CENTER);

		text_8 = new Text(composite_2113, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_age_1 = new Label(composite_2113, SWT.NONE);
		lblNewLabel_age_1.setText("\u5E74\u9F84");
		lblNewLabel_age_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_age_1.setAlignment(SWT.CENTER);

		text_9 = new Text(composite_2113, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_gender_1 = new Label(composite_2113, SWT.NONE);
		lblNewLabel_gender_1.setText("\u6027\u522B");
		lblNewLabel_gender_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_gender_1.setAlignment(SWT.CENTER);

		text_10 = new Text(composite_2113, SWT.BORDER | SWT.CENTER);

		Composite composite_22 = new Composite(composite_2, SWT.NONE);
		composite_22.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_22 = new RowLayout(SWT.VERTICAL);
		rl_composite_22.justify = true;
		rl_composite_22.center = true;
		composite_22.setLayout(rl_composite_22);

		Label lblNewLabel_1_1 = new Label(composite_22, SWT.WRAP);
		lblNewLabel_1_1.setLayoutData(new RowData(634, -1));
		lblNewLabel_1_1.setText("\u968F\u884C\u4EBA\u5458\u767B\u8BB0");
		lblNewLabel_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1_1.setFont(SWTResourceManager.getFont("黑体", 30, SWT.NORMAL));
		lblNewLabel_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_1_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_warn_1_1 = new Label(composite_22, SWT.CENTER);
		lblNewLabel_warn_1_1.setLayoutData(new RowData(294, 32));
		lblNewLabel_warn_1_1.setText("");
		lblNewLabel_warn_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_warn_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_warn_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_211_1 = new Composite(composite_22, SWT.NONE);
		composite_211_1.setLayoutData(new RowData(-1, 182));
		composite_211_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_211_1.setLayout(new RowLayout(SWT.HORIZONTAL));

		Composite composite_2111_1 = new Composite(composite_211_1, SWT.NONE);
		composite_2111_1.setLayoutData(new RowData(-1, 159));
		composite_2111_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_2111_1.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_name_1_1 = new Label(composite_2111_1, SWT.NONE);
		lblNewLabel_name_1_1.setText("\u59D3\u540D");
		lblNewLabel_name_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_name_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_name_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_name_1_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_idnum_1_1 = new Label(composite_2111_1, SWT.NONE);
		lblNewLabel_idnum_1_1.setText("\u8EAB\u4EFD\u8BC1\u53F7");
		lblNewLabel_idnum_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_idnum_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_idnum_1_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_idnum_1_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_phone_2_1 = new Label(composite_2111_1, SWT.NONE);
		lblNewLabel_phone_2_1.setText("\u624B\u673A\u53F7");
		lblNewLabel_phone_2_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_phone_2_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_phone_2_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_phone_2_1.setAlignment(SWT.CENTER);

		Label lblNewLabel_6_1_1 = new Label(composite_2111_1, SWT.NONE);
		lblNewLabel_6_1_1.setBackground(SWTResourceManager.getColor(0, 120, 215));
		lblNewLabel_6_1_1.setAlignment(SWT.CENTER);

		Composite composite_2112_1 = new Composite(composite_211_1, SWT.NONE);
		composite_2112_1.setLayoutData(new RowData(238, 158));
		composite_2112_1.setLayout(new FillLayout(SWT.VERTICAL));

		text_3 = new Text(composite_2112_1, SWT.BORDER);

		text_6 = new Text(composite_2112_1, SWT.BORDER);

		text_7 = new Text(composite_2112_1, SWT.BORDER);

		Button btnNewButton_inputinfo_1_1 = new Button(composite_2112_1, SWT.NONE);
		btnNewButton_inputinfo_1_1.setText("\u786E\u8BA4");
		btnNewButton_inputinfo_1_1.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));

		Composite composite_2113_1 = new Composite(composite_211_1, SWT.NONE);
		composite_2113_1.setLayoutData(new RowData(90, -1));
		composite_2113_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_2113_1.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblNewLabel_birth_1_1 = new Label(composite_2113_1, SWT.NONE);
		lblNewLabel_birth_1_1.setText("\u51FA\u751F\u65E5\u671F");
		lblNewLabel_birth_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_birth_1_1.setAlignment(SWT.CENTER);

		text_11 = new Text(composite_2113_1, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_age_1_1 = new Label(composite_2113_1, SWT.NONE);
		lblNewLabel_age_1_1.setText("\u5E74\u9F84");
		lblNewLabel_age_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_age_1_1.setAlignment(SWT.CENTER);

		text_12 = new Text(composite_2113_1, SWT.BORDER | SWT.CENTER);

		Label lblNewLabel_gender_1_1 = new Label(composite_2113_1, SWT.NONE);
		lblNewLabel_gender_1_1.setText("\u6027\u522B");
		lblNewLabel_gender_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_gender_1_1.setAlignment(SWT.CENTER);

		text_13 = new Text(composite_2113_1, SWT.BORDER | SWT.CENTER);

		Composite composite_3 = new Composite(composite_MainofMain, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_3 = new RowLayout(SWT.VERTICAL);
		rl_composite_3.center = true;
		rl_composite_3.justify = true;
		composite_3.setLayout(rl_composite_3);

		Composite composite_8 = new Composite(composite_3, SWT.NONE);
		composite_8.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite_8.setLayoutData(new RowData(288, SWT.DEFAULT));
		composite_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Label lblNewLabel_2 = new Label(composite_8, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setText("订单号");
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		text_14 = new Text(composite_8, SWT.BORDER);
		text_14.setLayoutData(new RowData(212, SWT.DEFAULT));

		table = new Table(composite_3, SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new RowData(593, 195));

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

		Composite composite_8_1 = new Composite(composite_3, SWT.NONE);
		composite_8_1.setLayoutData(new RowData(406, 50));
		composite_8_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_8_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_8_1.justify = true;
		composite_8_1.setLayout(rl_composite_8_1);

		Button btnNewButton_inputinfo_1_2 = new Button(composite_8_1, SWT.NONE);
		btnNewButton_inputinfo_1_2.setText("确认");
		btnNewButton_inputinfo_1_2.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));

		Button btnNewButton_inputinfo_1_2_1 = new Button(composite_8_1, SWT.NONE);
		btnNewButton_inputinfo_1_2_1.setText("删除");
		btnNewButton_inputinfo_1_2_1.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));

		Composite composite_4 = new Composite(composite_MainofMain, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

		Composite composite_5 = new Composite(composite_MainofMain, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));

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
		btnNewButton_1.setText("New Button");

		Button btnNewButton_2 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforMain.topControl = composite_2;
				composite_MainofMain.layout();
				stackLayoutfor2.topControl = composite_21;
				composite_2.layout();
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
				stackLayoutforMain.topControl = composite_3;
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
				stackLayoutforMain.topControl = composite_4;
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
				stackLayoutforMain.topControl = composite_5;
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
			PreparedStatement prep = conn.prepareStatement("select 房间类型 from RoomType");
			ResultSet rs = prep.executeQuery();
			boolean hascomboinit = false;
			while (rs.next()) {
				combo_roomtype.add(rs.getString(1));
				if (hascomboinit == false) {
					combo_roomtype.setText(rs.getString(1));
					hascomboinit = true;
				}
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		FocusListener roomtype_listener=new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO 自动生成的方法存根
				String roomtype=combo_roomtype.getText();
				if(roomtype.contains("单人"))text_adult.setText("1");
				else if(roomtype.contains("双人"))text_adult.setText("2");
				else if(roomtype.contains("三人"))text_adult.setText("2");
				
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

		DateTime dateTime_in = new DateTime(composite_9, SWT.BORDER);
		dateTime_in.setLayoutData(new RowData(149, SWT.DEFAULT));
		
		DateTime dateTime = new DateTime(composite_9, SWT.BORDER | SWT.TIME | SWT.SHORT);
		dateTime.setLayoutData(new RowData(80, SWT.DEFAULT));
		
		Composite composite_10 = new Composite(composite_112, SWT.NONE);
		composite_10.setLayout(new RowLayout(SWT.HORIZONTAL));

		DateTime dateTime_out = new DateTime(composite_10, SWT.BORDER);
		dateTime_out.setLayoutData(new RowData(149, SWT.DEFAULT));
		
		DateTime dateTime_1 = new DateTime(composite_10, SWT.BORDER | SWT.TIME | SWT.SHORT);

		Button btnNewButton_inputinfo = new Button(composite_112, SWT.NONE);
		btnNewButton_inputinfo.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));
		btnNewButton_inputinfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//自动生成订单号，查询客户是否存在，若不存在则生产客户编码
				String name = text_name.getText();
				String roomtype = combo_roomtype.getText();
				String idnum = text_idnum.getText();
				String phone = text_phone.getText();

				if ((!text_adult.getText().equals("")) && (!text_child.equals(""))) {
					int adultnum = Integer.parseInt(text_adult.getText());
					int childnum = Integer.parseInt(text_child.getText());
				}
				String time_in = dateTime_in.toString();
				System.out.println(time_in);
				
			}
		});
		btnNewButton_inputinfo.setText("确认");
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
