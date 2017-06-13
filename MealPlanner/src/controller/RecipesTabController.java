package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Application;
import view.RecipesTab;

public class RecipesTabController implements Observer, ActionListener {
	
	private Application model;
	private RecipesTab view;

	public RecipesTabController(Application model, RecipesTab view) {
		this.model = model;
		this.view = view;

		this.model.addObserver(this);

		this.view.getAddRecipeButton().addActionListener(this);
		this.view.getDeleteRecipeButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
