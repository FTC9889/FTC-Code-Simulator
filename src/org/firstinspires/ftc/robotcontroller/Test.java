package org.firstinspires.ftc.robotcontroller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import org.firstinspires.ftc.robotcontroller.RunOpModeSimulator.State;

public class Test {

	private JFrame frame;
	
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	
	/**
	 * 0 = Stopped
	 * 1 = Initializing
	 * 2 = Running
	 */
	public int mode = 2;
	public boolean isRunning = false;
	private boolean first = true;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 134, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Init");
		btnNewButton.addKeyListener(new KeyAdapter() {
			
		});
		btnNewButton.setBounds(10, 5, 106, 75);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("OpMode Initalized \n");
				mode = 1;
				RunOpModeSimulator.run(State.init);
				RunOpModeSimulator.run(State.init_loop);
				
				btnNewButton.setVisible(false);
				btnNewButton_1.setVisible(true);
				btnNewButton_2.setVisible(true);
				isRunning = false;
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Stop OpMode");
		btnNewButton_1.setBounds(10, 177, 106, 75);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("OpMode Stop \n");
				mode = 0;
				RunOpModeSimulator.run(State.stop);
				isRunning = false;	
				
				btnNewButton.setVisible(true);
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Start OpMode");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("OpMode Started \n");
				mode = 2;
				RunOpModeSimulator.run(State.start);
				RunOpModeSimulator.run(State.loop);
				btnNewButton.setVisible(false);
				isRunning = false;
			}
		});
		btnNewButton_2.setBounds(10, 91, 106, 75);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RunOpModeSimulator.run(State.stop);
				System.out.print("Simulation Terminated");
				System.exit(1);
			}
		});
		btnNewButton_3.setBounds(10, 272, 106, 23);
		frame.getContentPane().add(btnNewButton_3);
		if(first){
			btnNewButton_1.setVisible(false);
			btnNewButton_2.setVisible(false);
			first = false;
		}
		
	}
	
}
