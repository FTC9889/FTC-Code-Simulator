package org.firstinspires.ftc.robotcontroller;

import org.firstinspires.ftc.robotcontroller.internal.RobotCore.eventloop.opmode.Team9889_OpMode.telemetry;
import org.firstinspires.ftc.teamcode.Teleop;

public class RunOpModeSimulator {
	
	public enum State{
		init, init_loop, start, loop, stop
	}

	public static String s = null;
	public static Object[] possibilities = {"TeleOp", "Autonomous1", "Autonomus2", "Autonomus3"};
	public static Teleop OpMode = new Teleop();
	
	static Thread t;
	static Thread i1;
	
	public static void run(State i) {
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
			}
			
			for(int l = 0; l < 100; l++){
				telemetry.addData("stop", "");
				i1.interrupt();
			}
			
			telemetry.addData("OpMode Stopped", "");
			
		}
	}
}
