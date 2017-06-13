package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Ingredient;
import model.MealPlannerApp;
import model.Profile;
import view.IngredientsTab;

public class IngredientsTabController implements Observer, ActionListener {
	
	private MealPlannerApp model;
	private IngredientsTab view;
	
	public IngredientsTabController(MealPlannerApp model, IngredientsTab view) {
		this.model = model;
		this.view = view;
		
		this.model.addObserver(this);
		
		this.view.getAddButton().addActionListener(this);
		this.view.getDeleteButton().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_ADD_INGREDIENT) {
			Profile activeProfile = MealPlannerApp.getInstance().getActiveProfile();
			System.out.println("add");
			activeProfile.addIngredient(new Ingredient());
		}
		if (event.getActionCommand() == IngredientsTab.ACTION_COMMAND_DELETE_INGREDIENT) {
			
		}
	}

	@Override
	public void update(Observable observable, Object object) {
		
	}

}
