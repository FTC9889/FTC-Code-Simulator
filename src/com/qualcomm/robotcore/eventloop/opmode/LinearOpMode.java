package com.qualcomm.robotcore.eventloop.opmode;

public abstract class LinearOpMode {
	//------------------------------------------------------------------------------------------------
	  // Construction
	  //------------------------------------------------------------------------------------------------

	  public LinearOpMode() {
	  }

	  //------------------------------------------------------------------------------------------------
	  // Operations
	  //------------------------------------------------------------------------------------------------

	  /**
	   * Override this method and place your code here.
	   * <p>
	   * Please do not swallow the InterruptedException, as it is used in cases
	   * where the op mode needs to be terminated early.
	   * @throws InterruptedException
	   */
	  abstract public void runOpMode() throws InterruptedException;

	  /**
	   * Pauses the Linear Op Mode until start has been pressed or until the current thread
	   * is interrupted.
	   */
	  public synchronized void waitForStart() {
	    while (!isStarted()) {
	      synchronized (this) {
	        try {
	          this.wait();
	        } catch (InterruptedException e) {
	          Thread.currentThread().interrupt();
	          return;
	        }
	      }
	    }
	  }
	  /**
	   * Puts the current thread to sleep for a bit as it has nothing better to do. This allows other
	   * threads in the system to run.
	   *
	   * <p>One can use this method when you have nothing better to do in your code as you await state
	   * managed by other threads to change. Calling idle() is entirely optional: it just helps make
	   * the system a little more responsive and a little more efficient.</p>
	   *
	   * <p>{@link #idle()} is conceptually related to waitOneFullHardwareCycle(), but makes no
	   * guarantees as to completing any particular number of hardware cycles, if any.</p>
	   *
	   * @see #opModeIsActive()
	   * @see #waitOneFullHardwareCycle()
	   */
	  public final void idle() {
	    // Otherwise, yield back our thread scheduling quantum and give other threads at
	    // our priority level a chance to run
	    Thread.yield();
	  }
}
