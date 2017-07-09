import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Run {

	private JFrame DriverStation;
	
	private JButton topButton;
	private JButton bottomButton;
	
	private String nameInitOpMode = "Init OpMode";
	private String nameStartOpMode = "Start OpMode";
	private String nameStopOpMode = "Stop OpMode";
	
	//check if the opMode is running
	private boolean isRunning = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Run start = new Run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Run() {		
		//Make the frame
		DriverStation = new JFrame();
		DriverStation.setResizable(false);
		DriverStation.setBounds(10, 10, 90, 200);
		DriverStation.getContentPane().setLayout(null);
		DriverStation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame DriverStationTelemetry = new JFrame();
		DriverStationTelemetry.setResizable(false);
		DriverStationTelemetry.setBounds(150, 150, 300, 5);
		DriverStationTelemetry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DriverStationTelemetry.setVisible(true);
		
		//
		//Top Button
		//
		topButton = new JButton(nameInitOpMode);
		topButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(topButton.getText() == nameInitOpMode){
					setOpModeState(OpModeStates.init);	
				}else if(topButton.getText() == nameStopOpMode) {
					setOpModeState(OpModeStates.stop);
				}
				
				//add switching logic for buttons
				//make sure threads will work in this application
				//check logic to inshore that it will work 
			}
		});
		topButton.setBounds(10, 5, 115, 75);
		DriverStation.getContentPane().add(topButton);
		
		//
		//Bottom Button
		//
		bottomButton = new JButton(nameStartOpMode);
		bottomButton.setVisible(false);
		bottomButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(bottomButton.getText() == nameStartOpMode){
					setOpModeState(OpModeStates.start);
				}else if(bottomButton.getText() == nameStopOpMode) {
					setOpModeState(OpModeStates.stop);
				}
			}
		});
		bottomButton.setBounds(10, 91, 115, 75);
		DriverStation.getContentPane().add(bottomButton);	
		DriverStation.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	private void setOpModeState(OpModeStates state) {
		switch(state) {
		case preInit:
			System.out.print("preInit\n");
			isRunning = false;
			break;
		case init:
			System.out.print("init\n");
			topButton.setLabel(nameStopOpMode);
			bottomButton.setLabel(nameStartOpMode);
			
			bottomButton.setVisible(true);
			topButton.setVisible(true);
			break;
		case init_loop:
			System.out.print("init_loop\n");
			break;
		case postInitLoop:
			System.out.print("postInitLoop\n");
			break;
		case start:
			System.out.print("start\n");
			topButton.setLabel(nameInitOpMode);
			bottomButton.setLabel(nameStopOpMode);
			
			topButton.setVisible(false);
			bottomButton.setVisible(true);
			isRunning = true;
			break;
		case loop:
			System.out.print("loop\n");
			checkOpModeThread();
			isRunning = true;
			break;
		case postLoop:
			System.out.print("postLoop\n");
			isRunning = false;
			break;
		case stop:
			System.out.print("stop\n");
			topButton.setLabel(nameInitOpMode);
			bottomButton.setLabel(nameStartOpMode);
			
			topButton.setVisible(true);
			bottomButton.setVisible(false);
			isRunning = false;
			break;
		}
		
		
	}
	
	private enum OpModeStates{
		preInit, init, init_loop, postInitLoop, start, loop, postLoop, stop
	}

	private void checkOpModeThread() {
		
	}
}
