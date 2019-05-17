/**
 * 
 */
package org.test.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author satishk
 *
 */
public class TestMain {

	public static TestObj testObj = new TestObj();
	public static Thread mainThread;
	public static Thread t1;
	public static Thread t2;
	public static Thread t3;

	public static void main(String... args) throws InterruptedException {
		System.out.println("Starting Main....");

		mainThread = Thread.currentThread();
		
		t1 = new Thread(new Thread1());
		t1.setName("T1");
		t2 = new Thread(new Thread1());
		t2.setName("T2");
		t3 = new Thread(new Thread1());
		t3.setName("T3");
		List<Thread> tList = Arrays.asList(t1, t2,t3,mainThread);
		printThreadState(tList);

		t1.start();
		t1.join(1000);
		
		t2.start();
		t2.join();
		
		t3.start();

		boolean doNotStop = true;
		while (doNotStop) {
			printThreadState(tList);
			if (t1.isAlive() || t1.isAlive()) {
				doNotStop = true;
			} else {
				doNotStop = false;
			}
			Thread.sleep(1000);	
		}
		//Thread.sleep(1000);
		printThreadState(tList);
		System.out.println("Ending Main....");
	}

	public static void printThreadState(List<Thread> tList) {
		Date time = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		String timeStr = simpleDateFormat.format(time);
		for (Thread thread : tList) {
			System.out.println("Thread State time(" + timeStr + ") Name[" + thread.getName() + "] status["
					+ thread.getState() + "]");
		}
	}
}

class Thread1 implements Runnable {

	@Override
	public void run() {
		TestMain.testObj.printCount();
		System.out.println("Running Thread 1[" + TestMain.mainThread.getState() + "]");
		// System.out.println("Running Thread 1[" + TestMain.t2.getState() + "]");
	}
}
