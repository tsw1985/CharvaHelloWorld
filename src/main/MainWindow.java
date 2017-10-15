package main;

import charva.awt.BorderLayout;
import charva.awt.Color;
import charva.awt.Container;
import charva.awt.Toolkit;
import charva.awt.event.ActionEvent;
import charva.awt.event.ActionListener;
import charvax.swing.JButton;
import charvax.swing.JFrame;
import charvax.swing.JMenu;
import charvax.swing.JMenuBar;
import charvax.swing.JMenuItem;

public class MainWindow extends JFrame{
	
	public Toolkit toolKit = Toolkit.getDefaultToolkit();

	public MainWindow(){
		initFrame();
		Container container = initContainer(this);
		if ( container != null ){
			add(container,BorderLayout.CENTER);
			initMenuBar(this);
		}
	}
	
	private void initMenuBar(JFrame frame){
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem addUser,editUser,listAllUsers,exit;
		
		addUser = new JMenuItem("Add User");
		editUser = new JMenuItem("Edit User");
		listAllUsers = new JMenuItem("List all users");
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		fileMenu.add(addUser);
		fileMenu.add(editUser);
		fileMenu.add(listAllUsers);
		fileMenu.add(exit);
		
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		
		
		
		
	}

	private Container initContainer(JFrame fr) {
		
		Container contentPane = fr.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//contentPane.add(new JLabel("Hello World main"), BorderLayout.CENTER);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		contentPane.add(exitButton, BorderLayout.SOUTH);
		return contentPane;
	}

	private void initFrame() {
		System.setProperty("charva.color", "");
		setTitle("Book Phones");
		setBackground(Color.blue);
		setSize(toolKit.getScreenSize());
		
	}
	
	
	
	
}
