package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Application;
import view.IngredientsTab;
import view.MainFrame;

public class MainFrameController implements Observer, ActionListener {
	
	private Application model;
	private MainFrame view;
	
	public MainFrameController(Application model, MainFrame view) {
		this.model = model;
		this.view = view;
		
		this.model.addObserver(this);
		
		this.view.getExitMenuItem().addActionListener(this);
		
		setUpIngredientsTabController();
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
		IngredientsTab ingredientsTab = new IngredientsTab();
		
		// Add the tab to the main frame.
		view.addTab(ingredientsTab, "Ingredients");
		
		new IngredientsTabController(model, ingredientsTab);
	}

}
