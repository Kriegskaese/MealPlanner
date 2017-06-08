package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import model.MealPlannerApp;

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

	public MainFrame(MealPlannerApp model) {
		configureFrame();

		setJMenuBar(menuBar);
		configureMenuBar();

		add(tabbedPane);
		configureTabbedPane();

		pack();

		setLocationRelativeTo(null);
		setVisible(true);
	}

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

	private void configureTabbedPane() {
		tabbedPane.addTab("Mealplans", new MealPlansTab_());
		tabbedPane.addTab("Shopping Lists", new ShoppingListsTab_());
		tabbedPane.addTab("Statistics", new StatisticsTab());
		tabbedPane.addTab("Notes", new NotesTab());
		tabbedPane.addTab("Categories & Tags", new TagsAndCategoriesTab());
		tabbedPane.addTab("Ingredients", new IngredientsTab());
		tabbedPane.addTab("Recipes", new RecipesTab());
		tabbedPane.addTab("Events", new EventsTab());
		tabbedPane.addTab("Rules", new RulesTab());

		Color configurationTabsColor = Color.LIGHT_GRAY;
		for (int i = 4; i <= 8; i++) {
			tabbedPane.setBackgroundAt(i, configurationTabsColor);
		}
	}

	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

}
