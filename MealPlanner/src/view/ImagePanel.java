package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton button;
	private String imageLocation;
	private String text;
	private Dimension size;
	private Image image;
	private JLabel label;


	public ImagePanel(JButton button, String imageLocation, String text, Dimension size) {
		this.button = button;
		this.imageLocation = imageLocation;
		this.text = text;
		this.size = size;

		configureImagePanel();
		configureImagePanelContent();
	}

	private void configureImagePanelContent() {
		try {
			image = ImageIO.read(new File(imageLocation));
			configureButton();
			add(button);
		} catch (IOException exception) {
			label = new JLabel(this.text);
			configureLabel();
			add(label);
		}
	}

	private void configureImagePanel() {
		setLayout(new BorderLayout());
		setMaximumSize(size);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	private void configureButton() {
		button.setIcon(new ImageIcon(image));
		button.setBorder(null);
		button.setText(null);
		button.setPreferredSize(size);
	}

	private void configureLabel() {
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(size);
	}

}
