package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcontroller.internal.RobotCore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class Teleop extends OpMode{

	public Drivetrain drivetrain = new Drivetrain();
	public int AutonState = 0;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		telemetry.addData("init", "");
		drivetrain.init();
	}
	
	@Override
	public void init_loop(){
		telemetry.addData("init_loop", "");
	}

	@Override
	public void loop() {
		// TODO Auto-generated method stub
		telemetry.addData("loop", "");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		telemetry.addData("stop", "");
	}
	
}
