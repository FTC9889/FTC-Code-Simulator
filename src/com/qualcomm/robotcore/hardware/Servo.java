package com.qualcomm.robotcore.hardware;

/**
* @author joshua9889
*/

public class Servo implements HardwareDevice{
	
	private double mposition = 0.0;
	private String ServoName = null;
	
	public Servo(){
		
	}
	
	public final void setPosition(int position){
		mposition = position;
	}
	
	public final double getPosition(){
		return mposition;
	}

	@Override
	public Servo get(String name) {
		// TODO Auto-generated method stub
		ServoName = name;
		return null;
	}

	@Override
	public Manufacturer getManufacturer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeviceName() {
		// TODO Auto-generated method stub
		return ServoName;
	}

	@Override
	public String getConnectionInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetDeviceConfigurationForOpMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
}
