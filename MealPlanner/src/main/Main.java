package main;

import javax.swing.SwingUtilities;

import controller.MainFrameController;
import model.Application;
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
		Application application = Application.getInstance();
		MainFrame mainFrame = new MainFrame();
		new MainFrameController(application, mainFrame);
	}

}
