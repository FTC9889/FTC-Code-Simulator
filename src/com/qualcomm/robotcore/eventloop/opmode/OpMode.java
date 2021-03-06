package com.qualcomm.robotcore.eventloop.opmode;

import java.util.concurrent.TimeUnit;

/**
 * @author joshua9889
 * @date 7/8/017
 */
public abstract class OpMode {
	private long startTime;
	
	public OpMode() {
	    startTime = System.nanoTime();
	  }

	  /**
	   * User defined init method
	   * <p>
	   * This method will be called once when the INIT button is pressed.
	   */
	  abstract public void init();

	  /**
	   * User defined init_loop method
	   * <p>
	   * This method will be called repeatedly when the INIT button is pressed.
	   * This method is optional. By default this method takes no action.
	   */
	  public void init_loop() {};

	  /**
	   * User defined start method.
	   * <p>
	   * This method will be called once when the PLAY button is first pressed.
	   * This method is optional. By default this method takes not action.
	   * Example usage: Starting another thread.
	   *
	   */
	  public void start() {};

	  /**
	   * User defined loop method
	   * <p>
	   * This method will be called repeatedly in a loop while this op mode is running
	   */
	  abstract public void loop();

	  /**
	   * User defined stop method
	   * <p>
	   * This method will be called when this op mode is first disabled
	   *
	   * The stop method is optional. By default this method takes no action.
	   */
	  public void stop() {};

	  /**
	   * Requests that this OpMode be shut down if it the currently active opMode, much as if the stop
	   * button had been pressed on the driver station; if this is not the currently active OpMode,
	   * then this function has no effect. Note as part of this processing, the OpMode's {@link #stop()}
	   * method will be called, as that is part of the usual shutdown logic. Note that {@link #requestOpModeStop()}
	   * may be called from <em>any</em> thread.
	   *
	   * @see #stop()
	   */
	  public final void requestOpModeStop() {
		  
	  }

	  /**
	   * Get the number of seconds this op mode has been running
	   * <p>
	   * This method has sub millisecond accuracy.
	   * @return number of seconds this op mode has been running
	   */
	  public double getRuntime() {
	    final double NANOSECONDS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);
	    return (System.nanoTime() - startTime) / NANOSECONDS_PER_SECOND;
	  }

	  /**
	   * Reset the start time to zero.
	   */
	  public void resetStartTime() {
	    startTime = System.nanoTime();
	  }
}
