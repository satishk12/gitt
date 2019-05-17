package org.test.thread.common;

import java.lang.Thread.State;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class Util {

	public static void printThreadState(List<Thread> tList) {
		Date time = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		String timeStr = simpleDateFormat.format(time);
		ListIterator<Thread> lItr = tList.listIterator();
		while (lItr.hasNext()) {
			Thread t = lItr.next();
			if (t != null) {
				// ***********Start Code
				System.out.println(
						"Thread State time(" + timeStr + ") Name[" + t.getName() + "] status[" + t.getState() + "]");
				// ***********End Code
				if (t.getState() == State.TERMINATED) { 
					System.out.println(ConsoleColors.RED + " Thread State time(" + timeStr + ") Name[" + t.getName()
							+ "] status[" + t.getState() + "] " + ConsoleColors.RESET);
					lItr.remove();
				}
			}
		}
	}
}
