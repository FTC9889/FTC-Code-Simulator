package org.firstinspires.ftc.teamcode.subsystems;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class WindowMaker extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMaker frame = new WindowMaker("Name");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowMaker(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnOptions = new JButton("Options");
		menuBar.add(btnOptions);
		
		JButton btnHide = new JButton("Hide");
		menuBar.add(btnHide);
		
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Button Pressed\n");
				final JFrame parent = new JFrame();
			    JButton button = new JButton();

			    button.setText("Click me to show dialog!");
			    parent.getContentPane().add(button);
			    parent.pack();
			    parent.setVisible(true);

			    button.addActionListener(new java.awt.event.ActionListener() {
			    	@Override
			    	public void actionPerformed(java.awt.event.ActionEvent evt) {
			    		
			    	}
			    });
			}
		});
		
		btnHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Hide\n");
				
			}
		});		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
