package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Application;
import model.Ingredient;
import model.Profile;
import view.AddIngredientFrame;
import view.IngredientsTab;

public class AddIngredientFrameController implements ActionListener {

	private IngredientsTab tableView;
	private AddIngredientFrame view;
	private Profile activeProfile = Application.getInstance().getActiveProfile();
	private int selectedRowIndex;
	private Ingredient addedIngredient;

	//***************************** Constructor(s) *****************************

	public AddIngredientFrameController(AddIngredientFrame view, IngredientsTab tableView) {
		this.view = view;
		this.tableView = tableView;

		this.view.getCancelButton().addActionListener(this);
		this.view.getOkButton().addActionListener(this);
	}

	//************************** External Method(s) ****************************

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == AddIngredientFrame.ACTION_COMMAND_OK) {		
			rememberSelectedRow();
			createIngredient();
			//setIngredientProperties();
			selectNewRow();
			enableDeleteButtonIfNecessary();
			closeFrame();
		}
		if (event.getActionCommand() == AddIngredientFrame.ACTION_COMMAND_CANCEL) {
			closeFrame();
		}
	}

	//*********************** Internal Helper Method(s) ************************

	private void rememberSelectedRow() {
		selectedRowIndex = tableView.getIngredientsTable().getSelectedRow();
	}

	private void createIngredient() {
		addedIngredient = new Ingredient();
		activeProfile.addIngredient(addedIngredient);
	}

	private void setIngredientProperties() {
		int nTextFields = view.getTextFields().size();

		for (int i = 1; i < nTextFields; i++) {
			int lastIngredientIndex = activeProfile.getIngredients().size() - 1;
			Ingredient lastIngredient = activeProfile.getIngredients().get(lastIngredientIndex);
			lastIngredient.setPropertyValue(i, view.getTextFields().get(i));
		}
	}

	private void selectNewRow() {
		int newSelectedRowIndex = Math.max(0, selectedRowIndex);

		tableView.getIngredientsTable().changeSelection(newSelectedRowIndex, 0, false, false);
	}

	private void enableDeleteButtonIfNecessary() {
		if (tableView.getIngredientsTable().getRowCount() > 0) {
			tableView.getDeleteButton().setEnabled(true);
		}
	}

	private void closeFrame() {
		view.dispose();
	}

}
