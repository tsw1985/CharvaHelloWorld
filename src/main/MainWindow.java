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

public class MainWindow extends JFrame{
	
	public Toolkit toolKit = Toolkit.getDefaultToolkit();

	public MainWindow(){
		initFrame();
		initContainer(this);
	}

	private void initContainer(JFrame fr) {
		Container contentPane = fr.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JLabel("Hello World main"), BorderLayout.CENTER);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		contentPane.add(exitButton, BorderLayout.SOUTH);
		
		
	}

	private void initFrame() {
		System.setProperty("charva.color", "");
		setTitle("Book Phones");
		setBackground(Color.blue);
		setSize(toolKit.getScreenSize());
		
	}
	
	
	
	
}
