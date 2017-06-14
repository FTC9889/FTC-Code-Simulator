package org.firstinspires.ftc.teamcode.subsystems;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider power = new JSlider();
		power.setValue(0);
		power.setMinimum(-100);
		power.setMaximum(100);
		power.setBounds(5, 244, 282, 24);
		contentPane.add(power);
				
		String powerOutput = Integer.toString(power.getValue()/100);
		
		JLabel lblName = new JLabel();
		lblName.setText(powerOutput);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(122, 219, 46, 14);
		contentPane.add(lblName);
		
		add(power);
	}
}
