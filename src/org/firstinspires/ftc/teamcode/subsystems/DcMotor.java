package org.firstinspires.ftc.teamcode.subsystems;

public class DcMotor {
	public DcMotor(){};
		
	private int MotorRPM = 1;
	private double OutputpulseperrevolutionofOutputShaft = 28;
	private double OutputCounts = 0; 
	
	public double GearRatio = 1;
	private double OutputGearboxRPM = 0;
	
	public enum MotorType{
		AndyMark60, AndyMark40, AndyMark20, AndyMark37, AndyMarkCustom, Tetrix
	}
	
	public void setMotorType(MotorType type){
		if(type == MotorType.AndyMark60){
			GearRatio = 60;
			MotorRPM = 6600;
		}else if(type == MotorType.AndyMark40){
			GearRatio = 40;
			MotorRPM = 6600;
		}else if(type == MotorType.AndyMark20){
			GearRatio = 20;
			MotorRPM = 6600;
		}else if(type == MotorType.AndyMark37){
			GearRatio = 3.7;
			MotorRPM = 6600;
		}else if(type == MotorType.Tetrix){
			GearRatio = 1;
			MotorRPM = 147;
		}
		
		OutputGearboxRPM = MotorRPM/GearRatio;
		OutputCounts = GearRatio*OutputpulseperrevolutionofOutputShaft;
		
		System.out.print(OutputGearboxRPM + " RPMs \n");
		System.out.print(OutputCounts + " Output Counts \n");
	}
	
	public Object setPower(double power){
		return null;
	}

	public DcMotor get(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
