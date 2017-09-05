package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenu viewMenu = new JMenu("View");
	private JMenu helpMenu = new JMenu("Help");
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JMenuItem exitMenuItem = new JMenuItem("Exit");

	public static final String ACTION_COMMAND_EXIT = "closeApplication";

	//***************************** Constructor(s) *****************************

	public MainFrame() {
		configureFrame();

		setJMenuBar(menuBar);
		configureMenuBar();

		add(tabbedPane);

		pack();

		setLocationRelativeTo(null);
		setVisible(true);
	}

	//************************** External Method(s) ****************************

	public void addTab(JPanel tab, String tabName) {
		tabbedPane.addTab(tabName, tab);
	}

	//*********************** Internal Helper Method(s) ************************

	private void configureFrame() {
		setTitle("Meal Planner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void configureMenuBar() {
		menuBar.add(fileMenu);
		configureFileMenu();

		menuBar.add(editMenu);
		configureEditMenu();

		menuBar.add(viewMenu);
		configureViewMenu();

		menuBar.add(helpMenu);
		configureHelpMenu();
	}

	private void configureFileMenu() {
		JMenuItem profilesMenuItem = new JMenuItem("Profiles");
		fileMenu.add(profilesMenuItem);

		JMenuItem propertiesMenuItem = new JMenuItem("Properties");
		fileMenu.add(propertiesMenuItem);

		fileMenu.addSeparator();

		fileMenu.add(exitMenuItem);
		exitMenuItem.setActionCommand(ACTION_COMMAND_EXIT);
	}

	private void configureEditMenu() {
		JMenuItem undoMenuItem = new JMenuItem("Undo");
		editMenu.add(undoMenuItem);

		JMenuItem redoMenuItem = new JMenuItem("Redo");
		editMenu.add(redoMenuItem);

		editMenu.addSeparator();

		JMenuItem cutMenuItem= new JMenuItem("Cut");
		editMenu.add(cutMenuItem);

		JMenuItem copyMenuItem = new JMenuItem("Copy");
		editMenu.add(copyMenuItem);

		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		editMenu.add(pasteMenuItem);
	}

	private void configureViewMenu() {
		JMenuItem menuBarMenuItem = new JMenuItem("Menubar");
		viewMenu.add(menuBarMenuItem);
	}

	private void configureHelpMenu() {
		JMenuItem aboutMenuItem = new JMenuItem("About");
		helpMenu.add(aboutMenuItem);
	}

	private void configureProfileSelectionPanel() {

	}

	//************************ Getter(s) and Setter(s) *************************

	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

}
