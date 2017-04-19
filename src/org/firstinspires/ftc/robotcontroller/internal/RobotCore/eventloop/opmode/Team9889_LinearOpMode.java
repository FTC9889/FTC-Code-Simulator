package org.firstinspires.ftc.robotcontroller.internal.RobotCore.eventloop.opmode;

import org.firstinspires.ftc.robotcontroller.Test;

public abstract class Team9889_LinearOpMode {
	long Time = 0;    
		
	private Test input = new Test();
	
	public abstract void runOpMode();
	
	public void sleep(long milliseconds){
		try {
			System.out.print("Sleep: " + milliseconds + " milliseconds \n");
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int milliseconds(){
		return (int) ((System.nanoTime() - Time)/0.000000001);
	}
	
	public void waitForStart(){
		 
		
		this.Time = System.nanoTime();
	}
	
	public static class telemetry{

		public static void addData(String StringCaption, Object value){
			System.out.print(StringCaption + ": " + value + "\n");
		}
		
	}

	public boolean opModeIsActive(){
		return input.isRunning;
	}
}

