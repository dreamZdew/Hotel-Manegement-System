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

/*主界面*/

public class Main extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

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
		
		Button btnNewButton_1 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_1.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_2.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnNewButton_2.setText("New Button");
		
		Button btnNewButton_3 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_3.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnNewButton_3.setText("New Button");
		
		Button btnNewButton_4 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_4.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnNewButton_4.setText("New Button");
		
		Button btnNewButton_5 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_5.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnNewButton_5.setText("New Button");
		
		Button btnNewButton_6 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_6.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnNewButton_6.setText("New Button");
		
		Button btnNewButton_7 = new Button(composite_Buttons, SWT.NONE);
		btnNewButton_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNewButton_7.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		btnNewButton_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnNewButton_7.setText("New Button");
		
		Composite composite_MainofMain = new Composite(composite, SWT.NONE);
		composite_MainofMain.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_MainofMain.setLayout(new StackLayout());
		GridData gd_composite_MainofMain = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_composite_MainofMain.widthHint = 695;
		gd_composite_MainofMain.heightHint = 401;
		composite_MainofMain.setLayoutData(gd_composite_MainofMain);
		
		Composite composite_1 = new Composite(composite_MainofMain, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_1.setLayout(new FormLayout());
		
		Label lblNewLabel = new Label(composite_1, SWT.WRAP);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.bottom = new FormAttachment(0, 68);
		fd_lblNewLabel.right = new FormAttachment(0, 678);
		fd_lblNewLabel.top = new FormAttachment(0, 10);
		fd_lblNewLabel.left = new FormAttachment(0, 16);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel.setFont(SWTResourceManager.getFont("宋体", 30, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("酒店管理系统");
		
		Composite composite_8 = new Composite(composite_1, SWT.NONE);
		FormData fd_composite_8 = new FormData();
		fd_composite_8.top = new FormAttachment(lblNewLabel, 47);
		fd_composite_8.right = new FormAttachment(100, -187);
		fd_composite_8.left = new FormAttachment(0, 190);
		fd_composite_8.bottom = new FormAttachment(0, 336);
		composite_8.setLayoutData(fd_composite_8);
		composite_8.setLayout(new FormLayout());
		
		Composite composite_9 = new Composite(composite_8, SWT.NONE);
		FormData fd_composite_9 = new FormData();
		fd_composite_9.bottom = new FormAttachment(0, 153);
		fd_composite_9.right = new FormAttachment(0, 80);
		fd_composite_9.top = new FormAttachment(0, 7);
		fd_composite_9.left = new FormAttachment(0, 7);
		composite_9.setLayoutData(fd_composite_9);
		composite_9.setLayout(new FillLayout(SWT.VERTICAL));
		
		Label lblNewLabel_1 = new Label(composite_9, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setText("New Label");
		
		Label lblNewLabel_2 = new Label(composite_9, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setText("New Label");
		
		Label lblNewLabel_3 = new Label(composite_9, SWT.NONE);
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setText("New Label");
		
		Label lblNewLabel_4 = new Label(composite_9, SWT.NONE);
		lblNewLabel_4.setAlignment(SWT.CENTER);
		lblNewLabel_4.setText("New Label");
		
		Composite composite_10 = new Composite(composite_8, SWT.NONE);
		FormData fd_composite_10 = new FormData();
		fd_composite_10.bottom = new FormAttachment(composite_9, 0, SWT.BOTTOM);
		fd_composite_10.top = new FormAttachment(composite_9, 0, SWT.TOP);
		fd_composite_10.right = new FormAttachment(100, -10);
		fd_composite_10.left = new FormAttachment(composite_9, 6);
		
		Label lblNewLabel_5 = new Label(composite_9, SWT.NONE);
		lblNewLabel_5.setAlignment(SWT.CENTER);
		lblNewLabel_5.setText("New Label");
		composite_10.setLayoutData(fd_composite_10);
		composite_10.setLayout(new FillLayout(SWT.VERTICAL));
		
		text = new Text(composite_10, SWT.BORDER);
		
		text_1 = new Text(composite_10, SWT.BORDER);
		
		text_2 = new Text(composite_10, SWT.BORDER);
		
		text_3 = new Text(composite_10, SWT.BORDER);
		
		Button btnNewButton = new Button(composite_10, SWT.NONE);
		btnNewButton.setText("New Button");
		
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
