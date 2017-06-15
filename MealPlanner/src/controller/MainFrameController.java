package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;

import model.Application;
import model.TableGenerator;
import view.EventsTab;
import view.IngredientsTab;
import view.MainFrame;
import view.NotesTab;
import view.RecipesTab;

public class MainFrameController implements Observer, ActionListener {

	private Application model;
	private MainFrame view;

	public MainFrameController(Application model, MainFrame view) {
		this.model = model;
		this.view = view;

		this.model.addObserver(this);

		this.view.getExitMenuItem().addActionListener(this);

		//setUpMealPlansTabController();
		//setUpShoppingListsTabController();
		//setUpStatisticsTabController();
		setUpNotesTabController();
		setUpCategoriesAndTagsTabController();
		setUpIngredientsTabController();
		setUpRecipesTabController();
		setUpEventsTabController();
		//setUpRulesTabController();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == MainFrame.ACTION_COMMAND_EXIT){
			view.dispose();
		}
	}

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub

	}

	private void setUpIngredientsTabController() {
		// initialize the table displayed in the tab
		JTable ingredientsTable = initializeIngredientsTabTable();

		// create tab and controller
		IngredientsTab ingredientsTab = new IngredientsTab(ingredientsTable);
		new IngredientsTabController(model, ingredientsTab);

		// add the tab to the main frame
		view.addTab(ingredientsTab, "Ingredients");

		// select the first row
		ingredientsTable.changeSelection(0, 0, false, false);

		// disable DeleteButton if table empty
		if (ingredientsTable.getRowCount() == 0) {
			ingredientsTab.getDeleteButton().setEnabled(false);
		}
	}

	private void setUpRecipesTabController() {
		RecipesTab recipesTab = new RecipesTab();
		new RecipesTabController(model, recipesTab);

		// Add the tab to the main frame.
		view.addTab(recipesTab, "Recipes");
	}

	private void setUpEventsTabController() {
		EventsTab eventsTab = new EventsTab();
		new EventsTabController(model, eventsTab);

		// Add the tab to the main frame.
		view.addTab(eventsTab, "Events");
	}

	private void setUpCategoriesAndTagsTabController() {
		// TODO Auto-generated method stub

	}

	private void setUpNotesTabController() {
		NotesTab notesTab = new NotesTab();
		new NotesTabController(model, notesTab);

		// Add the tab to the main frame.
		view.addTab(notesTab, "Notes");
	}

	public JTable initializeIngredientsTabTable() {
		return new JTable(new TableGenerator().getTableModel());
	}

}
