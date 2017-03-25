package org.firstinspires.ftc.teamcode.subsystems;

public class Drivetrain {

	public DcMotor LDrive, RDrive;
	
	public void init(){
		LDrive = new DcMotor();
		LDrive.setPower(0.1);
		LDrive.setMotorType(DcMotor.MotorType.AndyMark40);
		RDrive = new DcMotor();
		RDrive.setPower(0.1);
		LDrive.setMotorType(DcMotor.MotorType.AndyMark40);
	}
		
}
