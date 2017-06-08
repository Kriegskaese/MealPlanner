package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MealPlansTab_ extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public MealPlansTab_() {
		setLayout(new BorderLayout());
		
		JPanel leftPanel = new JPanel();
		add(leftPanel, BorderLayout.LINE_START);
		leftPanel.setLayout(new BorderLayout());
		
		JPanel topLeftPanel = new JPanel();
		leftPanel.add(topLeftPanel, BorderLayout.NORTH);
		topLeftPanel.setLayout(new BoxLayout(topLeftPanel, BoxLayout.Y_AXIS));
		
		// Meal Plans Panel
		JPanel mealPlansPanel = new JPanel();
		topLeftPanel.add(mealPlansPanel);
		configureMealPlansPanel(mealPlansPanel);

		// Calendar Panel
		JPanel calendarPanel = new JPanel();
		topLeftPanel.add(calendarPanel);
		configureCalendarPanel(calendarPanel);

		// Right Panel
		JPanel rightPanel = new JPanel();
		add(rightPanel);
		rightPanel.setLayout(new GridBagLayout());

	}
	
	private void configureCalendarPanel(JPanel panel) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel calendarLabelPanel = new JPanel();
		panel.add(calendarLabelPanel);
		calendarLabelPanel.setLayout(new BorderLayout());
		
		JLabel calendarLabel = new JLabel("Calendar");
		calendarLabelPanel.add(calendarLabel, BorderLayout.LINE_START);
	}
	
	private void configureMealPlansPanel(JPanel panel) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel mealPlansLabelPanel = new JPanel();
		panel.add(mealPlansLabelPanel);
		mealPlansLabelPanel.setLayout(new BorderLayout());
		
		JLabel mealPlansLabel = new JLabel("Meal Plans");
		mealPlansLabelPanel.add(mealPlansLabel, BorderLayout.LINE_START);
		
		JPanel entry1 = createMealPlansEntry("Standard");
		panel.add(entry1);
		
		JPanel entry2 = createMealPlansEntry("Training");
		panel.add(entry2);
		
		JPanel entry3 = createMealPlansEntry("Other");
		panel.add(entry3);
	}
	
	private JPanel createMealPlansEntry(String name) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JCheckBox checkBox = new JCheckBox();
		panel.add(checkBox, BorderLayout.LINE_START);
		
		JLabel label = new JLabel(name);
		panel.add(label);
		
		return panel;
	}

}
