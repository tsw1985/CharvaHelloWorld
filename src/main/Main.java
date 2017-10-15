package main;

import charva.awt.BorderLayout;
import charva.awt.Color;
import charva.awt.Container;
import charva.awt.Toolkit;
import charva.awt.event.ActionEvent;
import charva.awt.event.ActionListener;
import charvax.swing.JButton;
import charvax.swing.JFrame;
import charvax.swing.JLabel;

public class Main {

	// API: http://www.pitman.co.za/projects/charva/api/allclasses-noframe.html
	public static void main(String[] args) {

		Toolkit toolKit = Toolkit.getDefaultToolkit();
		
		System.setProperty("charva.color", "");
		JFrame fr = new JFrame();
		fr.setTitle("Hello World");
		fr.setBackground(Color.blue);
		fr.setSize(toolKit.getScreenSize());
		Container contentPane = fr.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JLabel("Hello World"), BorderLayout.CENTER);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		contentPane.add(exitButton, BorderLayout.SOUTH);
		fr.show();

	}

}