package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Application;
import view.EventsTab;

public class EventsTabController implements Observer, ActionListener {

	private Application model;
	private EventsTab view;

	public EventsTabController(Application model, EventsTab view) {
		this.model = model;
		this.view = view;

		this.model.addObserver(this);

		this.view.getAddEventButton().addActionListener(this);
		this.view.getDeleteEventButton().addActionListener(this);
		this.view.getMoveUpEventButton().addActionListener(this);
		this.view.getMoveDownEventButton().addActionListener(this);
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
