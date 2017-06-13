package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Application;
import model.Ingredient;
import model.Profile;
import view.IngredientsTab;

public class IngredientsTabController implements Observer, ActionListener {

	private Application model;
	private IngredientsTab view;

	public IngredientsTabController(Application model, IngredientsTab view) {
		this.model = model;
		this.view = view;

		this.model.addObserver(this);

		this.view.getAddButton().addActionListener(this);
		this.view.getDeleteButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_ADD_INGREDIENT) {
			Profile activeProfile = Application.getInstance().getActiveProfile();
			Ingredient ingredient = new Ingredient();
			activeProfile.addIngredient(ingredient);
		}
		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_DELETE_INGREDIENT) {

		}
	}

	@Override
	public void update(Observable observable, Object object) {

	}

}
