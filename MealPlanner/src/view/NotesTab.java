package view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotesTab extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextArea notesArea = new JTextArea();

	public NotesTab() {
		setLayout(new GridLayout(1,1));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		scrollPane.setViewportView(notesArea);

		notesArea.setLineWrap(true);
	}

	public JTextArea getNotesArea() {
		return notesArea;
	}

}
