package com.qualcomm.robotcore.hardware;

/**
* @author joshua9889
*/

public class hardwareMap{
	
	public static DcMotor dcMotor = new DcMotor();
	public static Servo servo = new Servo();
	public static CRServo crservo = new CRServo();
	public static ServoController servoController = new ServoController();
	public static AccelerationSensor accelerationSensor = new AccelerationSensor();
	public static AnalogInput analogInput = new AnalogInput();
	public static ColorSensor colorSensor = new ColorSensor();
	public static CompassSensor compasssensor = new CompassSensor();
	public static DcMotorController dcMotorController = new DcMotorController();
	public static DeviceInterfaceModule deviceInterfaceModule = new DeviceInterfaceModule();
	public static DigitalChannel digitalChannel = new DigitalChannel();
	public static GyroSensor gyroSensor = new GyroSensor();
	public static I2cDevice i2cDevice = new I2cDevice();
	public static LegacyModule legacyModule = new LegacyModule();
	public static TouchSensorMultiplexer touchSensorMultiplexer = new TouchSensorMultiplexer();
	public static OpticalDistanceSensor opticalDistanceSensor = new OpticalDistanceSensor();
	public static TouchSensor touchSensor = new TouchSensor();
	public static PWMOutput pwmOutput = new PWMOutput();
	public static I2cDeviceSynch i2cDeviceSynch = new I2cDeviceSynch();
	public static AnalogOutput analogOutput = new AnalogOutput();
	public static CompassSensor compassSensor = new CompassSensor();
	public static IrSeekerSensor irSeekerSensor = new IrSeekerSensor();
	public static LightSensor lightSensor = new LightSensor();
	public static UltrasonicSensor ultrasonicSensor = new UltrasonicSensor();
	public static LED led = new LED();

}