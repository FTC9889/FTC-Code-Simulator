import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.firstinspires.ftc.robotcontroller.internal.RobotCore.eventloop.opmode.OpMode.telemetry;
import org.firstinspires.ftc.teamcode.Teleop;

public class Run {

	private JFrame frame;
	
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	
	
	private static final int MYTHREADS = 30;

	/**
	 * 0 = Stopped
	 * 1 = Initializing
	 * 2 = Running
	 */
	public int mode = 2;
	public boolean isRunning = false;
	private boolean first = true;
	
	public enum State{
		init, init_loop, start, loop, stop
	}

	public static String s = null;
	public static Object[] possibilities = {"TeleOp", "Autonomous1", "Autonomus2", "Autonomus3"};
	public static Teleop OpMode = new Teleop();
	
	static Thread t;
	static Thread i1;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Run window = new Run();
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
	public Run() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 134, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Init");
		btnNewButton.addKeyListener(new KeyAdapter() {
			
		});
		btnNewButton.setBounds(10, 5, 106, 75);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("OpMode Initalized \n");
				mode = 1;
				OpmodeRunner(State.init);
				OpmodeRunner(State.init_loop);
				
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
				OpmodeRunner(State.stop);
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
				OpmodeRunner(State.start);
				OpmodeRunner(State.loop);
				btnNewButton.setVisible(false);
				isRunning = false;
			}
		});
		btnNewButton_2.setBounds(10, 91, 106, 75);
		frame.getContentPane().add(btnNewButton_2);
		
		
		if(first){
			btnNewButton_1.setVisible(false);
			btnNewButton_2.setVisible(false);
			first = false;
		}
		
	}
	
	public void loopingCheck(){
		
	}
		
	public static void OpmodeRunner(State i) {
		// TODO Auto-generated method stub
		if(i == State.init){
			OpMode.init();
		}else if(i == State.init_loop){
			i1 = new Thread(() -> {
	            while (!Thread.interrupted()) {
						OpMode.init_loop();// Not stuck anymore!
	            }
	        });
	        i1.start();
		}else if(i == State.start){
			for(int l = 0; l < 100; l++){
				telemetry.addData("start", "");
				i1.interrupt();
			}
			OpMode.start();
		}else if(i == State.loop){
			t = new Thread(() -> {
	            while (!Thread.interrupted()) {
	            	OpMode.loop();// Not stuck anymore!
	            }
	        });
	        t.start();
		}else if(i == State.stop){	
			OpMode.stop();
			for(int l = 0; l < 100; l++){
				telemetry.addData("stop", "");
				t.interrupt();
				i1.interrupt();
			}
						
			telemetry.addData("OpMode Stopped", "");
			
		}
	}

}
