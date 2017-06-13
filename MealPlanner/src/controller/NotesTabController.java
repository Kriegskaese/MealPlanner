package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Application;
import view.NotesTab;

public class NotesTabController implements Observer, ActionListener {

	private Application model;
	private NotesTab view;

	public NotesTabController(Application model, NotesTab view) {
		this.model = model;
		this.view = view;

		this.model.addObserver(this);

		// this.view.getNotesArea().getDocument().addDocumentListener(new NoteAreaListener);
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
