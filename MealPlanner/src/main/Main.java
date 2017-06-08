package main;

import javax.swing.SwingUtilities;

import controller.ApplicationController;
import model.MealPlannerApp;
import view.MainFrame;

public class Main {
	
	public static void main(String[] arguments) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
        		createMVC();
            }
        });
	}
	
	private static void createMVC() {
		MealPlannerApp mealPlannerApp = MealPlannerApp.getInstance();
		MainFrame mainFrame = new MainFrame(mealPlannerApp);
		new ApplicationController(mealPlannerApp, mainFrame);
	}

}
