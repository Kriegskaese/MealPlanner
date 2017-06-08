package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class EventsTab extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] eventsColumnNames = {"Meal Plan", "Name", "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su", "Type"};
	private Object[][] eventsData = {
			{"Standard Plan", "Frühstück", new Boolean(true), new Boolean(true), new Boolean(true),
				new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), "Mahlzeit"},
			{"Standard Plan", "Mittagessen", new Boolean(true), new Boolean(true), new Boolean(true),
					new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), "Mahlzeit"},
			{"Standard Plan", "Abendessen", new Boolean(true), new Boolean(true), new Boolean(true),
						new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), "Mahlzeit"},
			{"Standard Plan", "Einkaufen1", new Boolean(true), new Boolean(true), new Boolean(true),
							new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), "Einkaufszettel"}
	};

	public static final String ACTION_COMMAND_ADD_EVENT = "addEvent";
	public static final String ACTION_COMMAND_DELETE_EVENT = "deleteEvent";
	public static final String ACTION_COMMAND_MOVEUP_EVENT = "moveUpEvent";
	public static final String ACTION_COMMAND_MOVEDOWN_EVENT = "moveDownEvent";

	private JTable eventsTable = new JTable(eventsData, eventsColumnNames);
	private JButton addEventButton = new AddButton(ACTION_COMMAND_ADD_EVENT);
	private JButton deleteEventButton = new DeleteButton(ACTION_COMMAND_DELETE_EVENT);
	private JButton moveUpEventButton = new Button(ACTION_COMMAND_MOVEUP_EVENT, "Move up");
	private JButton moveDownEventButton = new Button(ACTION_COMMAND_MOVEDOWN_EVENT, "Move down");

	public EventsTab() {
		setLayout(new BorderLayout());

		TablePanel tablePanel = new TablePanel(eventsTable, false, addEventButton, deleteEventButton, moveUpEventButton, moveDownEventButton);
		add(tablePanel);
	}

	public JTable getEventsTable() {
		return eventsTable;
	}

	public JButton getAddEventButton() {
		return addEventButton;
	}

	public JButton getDeleteEventButton() {
		return deleteEventButton;
	}

	public JButton getMoveUpEventButton() {
		return moveUpEventButton;
	}

	public JButton getMoveDownEventButton() {
		return moveDownEventButton;
	}

}
