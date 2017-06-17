package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Application;
import model.Ingredient;
import model.Profile;
import view.AddAndModifyIngredientFrame;
import view.IngredientsTab;

public class AddAndModifyIngredientFrameController implements Observer, ActionListener {

	private IngredientsTab tableView;
	private AddAndModifyIngredientFrame view;

	public AddAndModifyIngredientFrameController(AddAndModifyIngredientFrame view, IngredientsTab tableView) {
		this.view = view;
		this.tableView = tableView;

		this.view.getCancelButton().addActionListener(this);
		this.view.getOkButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == AddAndModifyIngredientFrame.ACTION_COMMAND_OK) {		
			// remember the currently selected row
			int selectedRow = tableView.getIngredientsTable().getSelectedRow();

			// add ingredient
			Profile activeProfile = Application.getInstance().getActiveProfile();
			activeProfile.addIngredient(new Ingredient());

			// select a new row
			int nRows = tableView.getIngredientsTable().getRowCount();

			if (nRows == 1) {
				// select the only available row
				tableView.getIngredientsTable().changeSelection(0, 0, false, false);
			} else {
				// select previously selected row (if none was selected none will be selected)
				tableView.getIngredientsTable().changeSelection(selectedRow, 0, false, false);
			}

			// enable DeleteButton if table is not empty
			if (tableView.getIngredientsTable().getRowCount() > 0) {
				tableView.getDeleteButton().setEnabled(true);
			}

			// close frame
			closeFrame();
		}
		if (event.getActionCommand() == AddAndModifyIngredientFrame.ACTION_COMMAND_CANCEL) {
			closeFrame();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
	}

	private void closeFrame() {
		view.dispose();
	}

}
