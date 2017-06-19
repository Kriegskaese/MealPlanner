package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.Application;
import model.Ingredient;
import model.Profile;
import model.TableGenerator;
import view.AddIngredientFrame;
import view.IngredientsTab;

public class IngredientsTabController implements Observer, ActionListener {

	private Application model;
	private IngredientsTab view;

	private AddIngredientFrame addIngredientFrame;
	private int selectedRowIndex;
	private Profile activeProfile = Application.getInstance().getActiveProfile();

	//***************************** Constructor(s) *****************************

	public IngredientsTabController(Application model, IngredientsTab view) {
		this.model = model;
		this.view = view;

		this.model.addObserver(this);
		activeProfile.addObserver(this);

		this.view.getAddButton().addActionListener(this);
		this.view.getDeleteButton().addActionListener(this);
	}

	//************************** External Method(s) ****************************

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_ADD_INGREDIENT) {
			// TODO: While frame exists, the addButton should focus the frame, not open a new one.
			createFrame();
			createController();
			displayFrame();
		}

		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_DELETE_INGREDIENT) {
			rememberSelectedRow();
			deleteSelectedIngredient();
			selectNewRow();
			disableDeleteButtonIfNecessary();
		}
	}

	@Override
	public void update(Observable observable, Object object) {
		if (observable == activeProfile) {
			TableModel newModel = new TableGenerator().getTableModel();
			view.getIngredientsTable().setModel(newModel);
		}
	}

	//*********************** Internal Helper Method(s) ************************

	private void createFrame() {
		List<String> columnNames = model.getActiveProfile().getIngredientsColumnNames();

		addIngredientFrame = new AddIngredientFrame(columnNames);
	}

	private void createController() {
		new AddIngredientFrameController(addIngredientFrame, view);
	}

	private void displayFrame() {
		addIngredientFrame.pack();
		addIngredientFrame.setLocationRelativeTo(null);
		addIngredientFrame.setVisible(true);
	}

	private void rememberSelectedRow() {
		selectedRowIndex = view.getIngredientsTable().getSelectedRow();
	}

	private void deleteSelectedIngredient() {
		Ingredient selectedIngredient = getSelectedIngredient(view.getIngredientsTable());

		activeProfile.removeIngredient(selectedIngredient);
	}

	private void selectNewRow() {
		int nRows = view.getIngredientsTable().getRowCount();

		if (nRows > 0) {
			if (selectedRowIndex < nRows) {
				view.getIngredientsTable().changeSelection(selectedRowIndex, 0, false, false);
			} else {
				view.getIngredientsTable().changeSelection(selectedRowIndex-1, 0, false, false);
			}
		}
	}

	private void disableDeleteButtonIfNecessary() {
		if (view.getIngredientsTable().getRowCount() == 0) {
			view.getDeleteButton().setEnabled(false);
		}
	}

	private Ingredient getSelectedIngredient(JTable table) {
		int selectedRow = table.getSelectedRow();
		int selectedIngredientId = (Integer) table.getModel().getValueAt(selectedRow, 0);

		for (Ingredient ingredient : activeProfile.getIngredients()) {
			if (ingredient.getId() == selectedIngredientId) {
				return ingredient;
			}
		}

		return null; //TODO: How to best handle this case?
	}

}
