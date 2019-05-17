/**
 * 
 */
package org.test.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.test.thread.common.RunnableImpl;
import org.test.thread.common.TestObj;
import org.test.thread.common.Util;

/**
 * @author satishk
 *
 */
public class ThreadStateTest {

	public static TestObj testObj = new TestObj();
	public static Thread mainThread;
	public static Thread t1;
	public static Thread t2;
	public static Thread t3;

	public static void main(String... args) throws InterruptedException {
		System.out.println("Starting Main....");

		mainThread = Thread.currentThread();

		t1 = new Thread(new RunnableImpl());
		t1.setName("T1");
		t2 = new Thread(new RunnableImpl());
		t2.setName("T2");
		t3 = new Thread(new RunnableImpl());
		t3.setName("T3");
		List<Thread> tList = new ArrayList(Arrays.asList(t1, t2, t3, mainThread));
		Util.printThreadState(tList);

		t1.start();
		t1.join(1000);

		t2.start();
		t2.join();

		t3.start();

		boolean doNotStop = true;
		while (doNotStop) {
			Util.printThreadState(tList);
			if (t1.isAlive() || t2.isAlive()) {
				doNotStop = true;
			} else {
				doNotStop = false;
			}
			Thread.sleep(1000);
		}
		// Thread.sleep(1000);
		Util.printThreadState(tList);
		System.out.println("Ending Main....");
	}

}
