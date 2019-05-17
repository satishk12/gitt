package org.test.thread.common;

import org.test.thread.ThreadStateTest;

public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		ThreadStateTest.testObj.printCount();
		System.out.println("Running Thread 1[" + ThreadStateTest.mainThread.getState() + "]");
		// System.out.println("Running Thread 1[" + TestMain.t2.getState() + "]");
	}

}
