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
			Profile activeProfile = Application.getInstance().getActiveProfile();
			activeProfile.addIngredient(new Ingredient());
		}
		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_DELETE_INGREDIENT) {
			Profile activeProfile = Application.getInstance().getActiveProfile();
			Ingredient selectedIngredient = getSelectedIngredient(view.getIngredientsTable());
			activeProfile.removeIngredient(selectedIngredient);
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
		return null; //TODO: How do you best handle this case?
	}

}
