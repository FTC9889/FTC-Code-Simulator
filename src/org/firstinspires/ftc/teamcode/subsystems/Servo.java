package org.firstinspires.ftc.teamcode.subsystems;

public class Servo {
	public Servo(){}
	
	public int CurrentPos = 0;
	
	private double position = 0;
	public double GoToPos = 0;
	
	private int Max = 180;
	private int Min = 0;
	private int TotalAngle = Max-Min;
	
	private boolean Direction_ = true;
	
	public enum Direction{
		FORWARD, REVERSE
	}
	
	public void setPosition(double position){
		if (position <= 0 || position >= 1) {
	         throw new IllegalArgumentException();
	      } else {
	         this.position = position;
	      }
		if(Direction_){
			TotalAngle = Max-Min;
			GoToPos = (TotalAngle/10)*this.position;
		}
	}
	
	public void setDirection(Direction direction){
		if(direction == Direction.FORWARD){
			this.Direction_ = true;
		}else if(direction == Direction.REVERSE){
			this.Direction_= false;
		}
	}
	
	public void MaxMinDegrees(int Max, int Min){
		this.Max = Max;
		this.Min = Min;
	}
}
