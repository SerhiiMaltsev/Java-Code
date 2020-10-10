
/**
 * Homework 4 Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis
 * 			 Image resizing from 1:00 - 2:00 https://www.google.com/search?ei=s91_XoquFvSwytMP4tSvuAU&q=java+image+resize&oq=java+image+resize&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgQIABBHOgUIABCRAjoFCAAQgwE6BAgAEENQ9NghWKPzIWCF9SFoAHAEeACAAdABiAHEFJIBBjAuMTYuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjK04ilqb7oAhV0mHIEHWLqC1cQ4dUDCAs&uact=5#kpvalbx=_399_XvGJMuiyytMPitKb2As18
 * 			 https://docs.oracle.com/javase/tutorial/uiswing/
 */

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class PhotoViewer extends JFrame {

	/**
	 * Library library that contains photos that will be displayed
	 */
	private Library library;

	/**
	 * Setter for the library
	 * 
	 * @param Library l the value that will be set to the library
	 */
	public void setImageLibrary(Library l) {
		this.library = l;
	}

	/**
	 * Getter for the library with images
	 * 
	 * @return the library with photos
	 */
	public Library getImageLibrary() {
		return this.library;
	}

	/**
	 * GUI components
	 */
	private JLabel label = new JLabel("img1.jpg");
	private JButton button1 = new JButton("Previous");
	private JButton button2 = new JButton("Next");
	private JLabel photoCaption = new JLabel("Cat 1");

	private JRadioButton radioButton1 = new JRadioButton("1");
	private JRadioButton radioButton2 = new JRadioButton("2");
	private JRadioButton radioButton3 = new JRadioButton("3");
	private JRadioButton radioButton4 = new JRadioButton("4");
	private JRadioButton radioButton5 = new JRadioButton("5");

	// Following lines of code are used to resize image
	private ImageIcon imagex = new ImageIcon("images\\img1.jpg");
	Image ImageTypeImage = imagex.getImage();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Image ModifiedImage = ImageTypeImage.getScaledInstance((int) (screenSize.width * 0.2),
			(int) (screenSize.height * 0.2), java.awt.Image.SCALE_SMOOTH);
	private ImageIcon image = new ImageIcon(ModifiedImage);
	private JLabel imageLabel = new JLabel(image);

	private Photo currentPhoto;

	/**
	 * Used to add and to set the size and location of all elements of the GUI to
	 * the pane
	 * 
	 * @param pane that will be used to add elements
	 */
	public void addComponentsToPlane(Container pane) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension((int) (screenSize.width * 0.4), (int) (screenSize.height * 0.4)));

		label.setBounds((int) (screenSize.width * 0.185), (int) (screenSize.height * 0.005),
				(int) (screenSize.width * 0.07), (int) (screenSize.height * 0.07));
		panel.add(label);

		button1.setBounds((int) (screenSize.width * 0.02), (int) (screenSize.height * 0.13),
				(int) (screenSize.width * 0.07), (int) (screenSize.height * 0.07));
		panel.add(button1);

		button2.setBounds((int) (screenSize.width * 0.31), (int) (screenSize.height * 0.13),
				(int) (screenSize.width * 0.07), (int) (screenSize.height * 0.07));
		panel.add(button2);

		imageLabel.setBounds((int) (screenSize.width * 0.1), (int) (screenSize.height * 0.08),
				(int) (screenSize.width * 0.2), (int) (screenSize.height * 0.2));

		panel.add(imageLabel);

		currentPhoto = library.getPhotos().get(0);

		photoCaption.setBounds((int) (screenSize.width * 0.185), (int) (screenSize.height * 0.27),
				(int) (screenSize.width * 0.07), (int) (screenSize.height * 0.07));
		panel.add(photoCaption);

		radioButton1.setBounds((int) (screenSize.width * 0.1), (int) (screenSize.height * 0.34),
				(int) (screenSize.width * 0.03), (int) (screenSize.height * 0.02));
		panel.add(radioButton1);

		radioButton2.setBounds((int) (screenSize.width * 0.145), (int) (screenSize.height * 0.34),
				(int) (screenSize.width * 0.03), (int) (screenSize.height * 0.02));
		panel.add(radioButton2);

		radioButton3.setBounds((int) (screenSize.width * 0.19), (int) (screenSize.height * 0.34),
				(int) (screenSize.width * 0.03), (int) (screenSize.height * 0.02));
		panel.add(radioButton3);

		radioButton4.setBounds((int) (screenSize.width * 0.235), (int) (screenSize.height * 0.34),
				(int) (screenSize.width * 0.03), (int) (screenSize.height * 0.02));
		panel.add(radioButton4);

		radioButton5.setBounds((int) (screenSize.width * 0.28), (int) (screenSize.height * 0.34),
				(int) (screenSize.width * 0.03), (int) (screenSize.height * 0.02));
		panel.add(radioButton5);

		radioButton1.setSelected(true);

		pane.add(panel);

		/**
		 * Action listener for the "next" button
		 */
		class ButtonListener2 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				// following changes the current photo to the next one
				int numberOfCurrentPhoto = library.getPhotos().indexOf(currentPhoto);
				if (numberOfCurrentPhoto + 1 < library.getPhotos().size()) {
					currentPhoto = library.getPhotos().get(numberOfCurrentPhoto + 1);
				} else {
					currentPhoto = library.getPhotos().get(0);
				}

				label.setText(currentPhoto.getFilename()); // changes text of the file name label
				photoCaption.setText(currentPhoto.getCaption()); // changes text of the photo caption label

				// Following lines of code are used to resize image
				image = new ImageIcon("images\\" + currentPhoto.getFilename());
				Image ImageTypeImage = image.getImage();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Image ModifiedImage = ImageTypeImage.getScaledInstance((int) (screenSize.width * 0.2),
						(int) (screenSize.height * 0.2), java.awt.Image.SCALE_SMOOTH);
				image = new ImageIcon(ModifiedImage);
				imageLabel.setIcon(image);

				// Deselect all radio buttons
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);

				int r = currentPhoto.getRating();

				// Select the correct radio button
				switch (r) {
				case 1:
					radioButton1.setSelected(true);
					break;
				case 2:
					radioButton2.setSelected(true);
					break;
				case 3:
					radioButton3.setSelected(true);
					break;
				case 4:
					radioButton4.setSelected(true);
					break;
				case 5:
					radioButton5.setSelected(true);
					break;
				}
			}
		}

		/**
		 * Action listener for the "previous" button
		 */
		class ButtonListener1 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				// following changes the current photo to the next one
				int numberOfCurrentPhoto = library.getPhotos().indexOf(currentPhoto);
				if (numberOfCurrentPhoto + 1 > 1) {
					currentPhoto = library.getPhotos().get(numberOfCurrentPhoto - 1);
				} else {
					currentPhoto = library.getPhotos().get(library.getPhotos().size() - 1);
				}

				label.setText(currentPhoto.getFilename()); // changes text of the file name label
				photoCaption.setText(currentPhoto.getCaption()); // changes text of the photo caption label

				// Following lines of code are used to resize image
				image = new ImageIcon("images\\" + currentPhoto.getFilename());
				Image ImageTypeImage = image.getImage();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Image ModifiedImage = ImageTypeImage.getScaledInstance((int) (screenSize.width * 0.2),
						(int) (screenSize.height * 0.2), java.awt.Image.SCALE_SMOOTH);
				image = new ImageIcon(ModifiedImage);
				imageLabel.setIcon(image);

				// Deselect all radio buttons
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);

				int r = currentPhoto.getRating();

				// Select the correct radio button
				switch (r) {
				case 1:
					radioButton1.setSelected(true);
					break;
				case 2:
					radioButton2.setSelected(true);
					break;
				case 3:
					radioButton3.setSelected(true);
					break;
				case 4:
					radioButton4.setSelected(true);
					break;
				case 5:
					radioButton5.setSelected(true);
					break;
				}
			}
		}

		/**
		 * Action listener for the first radio button
		 */
		class RadioButton1Listener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Deselect all radio buttons
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);

				radioButton1.setSelected(true); // Select the correct radio button

				// Changes the rating of the current photo
				library.getPhotos().get(library.getPhotos().indexOf(currentPhoto)).setRating(1);

			}

		}

		/**
		 * Action listener for the second radio button
		 */
		class RadioButton2Listener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Deselect all radio buttons
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);

				radioButton2.setSelected(true); // Select the correct radio button

				// Changes the rating of the current photo
				library.getPhotos().get(library.getPhotos().indexOf(currentPhoto)).setRating(2);

			}

		}

		/**
		 * Action listener for the third radio button
		 */
		class RadioButton3Listener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Deselect all radio buttons
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);

				radioButton3.setSelected(true); // Select the correct radio button

				// Changes the rating of the current photo
				library.getPhotos().get(library.getPhotos().indexOf(currentPhoto)).setRating(3);

			}

		}

		/**
		 * Action listener for the fourth radio button
		 */
		class RadioButton4Listener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Deselect all radio buttons
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);

				radioButton4.setSelected(true); // Select the correct radio button

				// Changes the rating of the current photo
				library.getPhotos().get(library.getPhotos().indexOf(currentPhoto)).setRating(4);

			}

		}

		/**
		 * Action listener for the fifth radio button
		 */
		class RadioButton5Listener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Deselect all radio buttons
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);

				radioButton5.setSelected(true); // Select the correct radio button

				// Changes the rating of the current photo
				library.getPhotos().get(library.getPhotos().indexOf(currentPhoto)).setRating(5);

			}

		}

		radioButton1.addActionListener(new RadioButton1Listener());
		radioButton2.addActionListener(new RadioButton2Listener());
		radioButton3.addActionListener(new RadioButton3Listener());
		radioButton4.addActionListener(new RadioButton4Listener());
		radioButton5.addActionListener(new RadioButton5Listener());

		button1.setActionCommand("click");
		button1.addActionListener(new ButtonListener1());
		button2.setActionCommand("click");
		button2.addActionListener(new ButtonListener2());
	}

	/**
	 * Main method that creates library and invokes GUI
	 */
	public static void main(String[] args) {

		PhotoViewer myViewer = new PhotoViewer();

		myViewer.setImageLibrary(new Library("cats", 123));

		String imageDirectory = "images\\";

		Photo p1 = new Photo("img1.jpg", "Cat 1", "2015-06-30", 1);
		p1.loadImageData(imageDirectory + "img1.jpg");
		Photo p2 = new Photo("img2.jpg", "Cat 2", "2016-06-30", 2);
		p2.loadImageData(imageDirectory + "img2.jpg");
		Photo p3 = new Photo("img3.jpg", "Cat 3", "2017-06-30", 3);
		p3.loadImageData(imageDirectory + "img3.jpg");
		Photo p4 = new Photo("img4.jpg", "Cat 4", "2018-06-30", 4);
		p4.loadImageData(imageDirectory + "img4.jpg");
		Photo p5 = new Photo("img5.jpg", "Cat 5", "2019-06-30", 5);
		p5.loadImageData(imageDirectory + "img5.jpg");

		myViewer.getImageLibrary().addPhoto(p1);
		myViewer.getImageLibrary().addPhoto(p2);
		myViewer.getImageLibrary().addPhoto(p3);
		myViewer.getImageLibrary().addPhoto(p4);
		myViewer.getImageLibrary().addPhoto(p5);

		myViewer.addComponentsToPlane(myViewer.getContentPane());
		myViewer.pack();
		myViewer.setTitle("HW4");
		myViewer.setVisible(true);
	}
}
