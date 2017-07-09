package org.firstinspires.ftc.robotcore.external;

public class Telemetry {
	
	private boolean _isLinear = false;
	private String outputData;
	
	public Telemetry(boolean isLinear) {
		_isLinear = isLinear;
	}
	
	public void addData(String name, String data) {
		outputData = outputData + "\n" + name +  ": " + data;
		if(!_isLinear)
			updateTelemetry();
	}
	
	public void clearData() {
		outputData ="";
	}
	
	public void updateTelemetry() {
		System.out.print(outputData);
	}
}
