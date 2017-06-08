package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.MealPlannerApp;
import view.MainFrame;

public class ApplicationController implements Observer, ActionListener {
	
	private MealPlannerApp model;
	private MainFrame view;
	
	public ApplicationController(MealPlannerApp model, MainFrame view) {
		this.model = model;
		this.view = view;
		
		this.model.addObserver(this);
		
		this.view.getExitMenuItem().addActionListener(this);
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

}
