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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/*主界面*/

public class CheckoutPage extends Shell {
	private Table table;
	private int cursorrow,cursorcol;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			CheckoutPage shell = new CheckoutPage(display);
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
	public CheckoutPage(Display display) {

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

		Composite composite_MainofCheck = new Composite(composite, SWT.NONE);
		composite_MainofCheck.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		final StackLayout stackLayoutforCheck = new StackLayout();
		composite_MainofCheck.setLayout(stackLayoutforCheck);


		GridData gd_composite_MainofCheck = new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
		gd_composite_MainofCheck.widthHint = 677;
		gd_composite_MainofCheck.heightHint = 401;
		composite_MainofCheck.setLayoutData(gd_composite_MainofCheck);

		Composite composite_1 = new Composite(composite_MainofCheck, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		RowLayout rl_composite_1 = new RowLayout(SWT.VERTICAL);
		rl_composite_1.center = true;
		rl_composite_1.justify = true;
		composite_1.setLayout(rl_composite_1);

		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setLayoutData(new RowData(150, 39));
		lblNewLabel.setText("双击结算指定订单");
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new RowData(672, 237));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		final TableCursor cursor = new TableCursor(table, SWT.FULL_SELECTION);//鼠标对表格监听
		cursor.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				cursorrow = table.getSelectionIndex();
				cursorcol = cursor.getColumn();
				TableItem t = table.getItem(cursorrow);
				System.out.println(t.getText(0));
			}
		});

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("订单编号");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("下单时间");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("客人编号");

		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("房间编号");

		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("入住时间");

		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("退房时间");

		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("订单状态");

		Composite composite_2 = new Composite(composite_MainofCheck, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_2.setLayout(new RowLayout(SWT.VERTICAL));
		
		Composite composite_21 = new Composite(composite_2, SWT.NONE);
		composite_21.setLayoutData(new RowData(452, 110));
		
		Label lblNewLabel_3 = new Label(composite_21, SWT.NONE);
		lblNewLabel_3.setBounds(49, 36, 61, 17);
		lblNewLabel_3.setText("订单号");
		
		Label lblNewLabel_4 = new Label(composite_21, SWT.NONE);
		lblNewLabel_4.setBounds(116, 36, 326, 17);
		lblNewLabel_4.setText("New Label");
		
		Composite composite_22 = new Composite(composite_2, SWT.NONE);
		composite_22.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite_22.setLayoutData(new RowData(345, 34));
		
		Composite composite_4 = new Composite(composite_22, SWT.NONE);
		composite_4.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Label lblNewLabel_1 = new Label(composite_4, SWT.NONE);
		lblNewLabel_1.setText("入住时间");
		
		text = new Text(composite_4, SWT.BORDER);
		
		Composite composite_4_1 = new Composite(composite_22, SWT.NONE);
		composite_4_1.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Label lblNewLabel_1_1 = new Label(composite_4_1, SWT.NONE);
		lblNewLabel_1_1.setText("退房时间");
		
		text_1 = new Text(composite_4_1, SWT.BORDER);
		
		Composite composite_23 = new Composite(composite_2, SWT.NONE);
		composite_23.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite_23.setLayoutData(new RowData(354, SWT.DEFAULT));
		
		Label lblNewLabel_2 = new Label(composite_23, SWT.NONE);
		lblNewLabel_2.setText("New Label");
		
		text_2 = new Text(composite_23, SWT.BORDER);
		composite_MainofCheck.layout();

		Button btnNewButton_1 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
				try {
					Connection conn = AboutDB.loginDB();
					PreparedStatement prep = conn.prepareStatement("SELECT 订单编号,下单时间,客人编号,房间编号,入住时间,退房时间,订单状态 FROM OrderList");
					ResultSet rs = prep.executeQuery();
					while (rs.next()) {
						TableItem tableitem = new TableItem(table, SWT.NULL);
						tableitem.setText(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7) });

					}
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				stackLayoutforCheck.topControl = composite_1;
				composite_MainofCheck.layout();
			}
		});
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_1.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_1.setText("选择订单");

		Button btnNewButton_2 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayoutforCheck.topControl = composite_2;
				composite_MainofCheck.layout();
			}
		});
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_2.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_2.setText("结算订单");

		try {
			Connection conn = AboutDB.loginDB();
			PreparedStatement prep = conn.prepareStatement("SELECT 订单编号,下单时间,客人编号,房间编号,入住时间,退房时间,订单状态 FROM OrderList");
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				TableItem tableitem = new TableItem(table, SWT.NULL);
				tableitem.setText(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7) });

			}
		} catch (SQLException ee) {
			// TODO 自动生成的 catch 块
			ee.printStackTrace();
		}
		
		
		stackLayoutforCheck.topControl=composite_1;
		composite_MainofCheck.layout();
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
