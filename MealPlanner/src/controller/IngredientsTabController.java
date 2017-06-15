package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.Application;
import model.Ingredient;
import model.Profile;
import model.TableGenerator;
import view.IngredientsTab;

public class IngredientsTabController implements Observer, ActionListener {

	private Application model;
	private IngredientsTab view;

	public IngredientsTabController(Application model, IngredientsTab view) {
		this.model = model;
		this.view = view;

		this.model.addObserver(this);
		this.model.getActiveProfile().addObserver(this);

		this.view.getAddButton().addActionListener(this);
		this.view.getDeleteButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_ADD_INGREDIENT) {		
			// remember the currently selected row
			int selectedRow = view.getIngredientsTable().getSelectedRow();

			// add ingredient
			Profile activeProfile = Application.getInstance().getActiveProfile();
			activeProfile.addIngredient(new Ingredient());

			// select a new row
			int nRows = view.getIngredientsTable().getRowCount();

			if (nRows == 1) {
				// select the only available row
				view.getIngredientsTable().changeSelection(0, 0, false, false);
			} else {
				// select previously selected row (if none was selected none will be selected)
				view.getIngredientsTable().changeSelection(selectedRow, 0, false, false);
			}
		}

		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_DELETE_INGREDIENT) {
			// remember the currently selected row
			int selectedRow = view.getIngredientsTable().getSelectedRow();

			// delete the ingredient
			Profile activeProfile = Application.getInstance().getActiveProfile();
			Ingredient selectedIngredient = getSelectedIngredient(view.getIngredientsTable());

			activeProfile.removeIngredient(selectedIngredient);

			// set the id for the next ingredient that is going to be created
			int highestId = 0;

			for (Ingredient ingredient : activeProfile.getIngredients()) {
				if (highestId < ingredient.getId()) {
					highestId = ingredient.getId();
				}
			}

			if (activeProfile.getIngredients().size() == 0) {
				Ingredient.setCurrentId(1);
			} else {
				Ingredient.setCurrentId(highestId + 1);
			}

			// select a new row if possible
			int nRows = view.getIngredientsTable().getRowCount();

			if (nRows > 0) {
				if (selectedRow < nRows) {
					view.getIngredientsTable().changeSelection(selectedRow, 0, false, false);
				} else {
					view.getIngredientsTable().changeSelection(selectedRow-1, 0, false, false);
				}
			}
		}
	}

	@Override
	public void update(Observable observable, Object object) {
		//if (object == Application.getInstance().getActiveProfile().getIngredients()) {
		TableModel newModel = new TableGenerator().getTableModel();
		view.getIngredientsTable().setModel(newModel);
		//}
	}

	private Ingredient getSelectedIngredient(JTable table) {
		int selectedRow = table.getSelectedRow();
		int selectedIngredientId = (Integer) table.getModel().getValueAt(selectedRow, 0);

		Profile activeProfile = Application.getInstance().getActiveProfile();

		for (Ingredient ingredient : activeProfile.getIngredients()) {
			if (ingredient.getId() == selectedIngredientId) {
				return ingredient;
			}
		}
		return null; //TODO: How to best handle this case?
	}

}
