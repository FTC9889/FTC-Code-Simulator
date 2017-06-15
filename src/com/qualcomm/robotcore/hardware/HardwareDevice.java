package com.qualcomm.robotcore.hardware;

/**
* @author joshua9889
*/

public interface HardwareDevice {
	public abstract Object get(String name);
	
	enum Manufacturer {
	    Unknown, Other, Lego, HiTechnic, ModernRobotics, Adafruit, Matrix, Lynx, AMS
	  }

	  /**
	   * Returns an indication of the manufacturer of this device.
	   * @return the device's manufacturer
	   */
	  Manufacturer getManufacturer();

	  /**
	   * Returns a string suitable for display to the user as to the type of device.
	   * Note that this is a device-type-specific name; it has nothing to do with the
	   * name by which a user might have configured the device in a robot configuration.
	   *
	   * @return device manufacturer and name
	   */
	  String getDeviceName();

	  /**
	   * Get connection information about this device in a human readable format
	   *
	   * @return connection info
	   */
	  String getConnectionInfo();

	  /**
	   * Version
	   *
	   * @return get the version of this device
	   */
	  int getVersion();

	  /**
	   * Resets the device's configuration to that which is expected at the beginning of an OpMode.
	   * For example, motors will reset the their direction to 'forward'.
	   */
	  void resetDeviceConfigurationForOpMode();

	  /**
	   * Closes this device
	   */
	  void close();
}
