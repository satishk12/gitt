package org.test.thread;

public class TestObj {

	long loopNumber = 0;
	StringBuilder builder = new StringBuilder();

	public void printCount() {
		
//		for (int i = 0; i < 100; i++)
//			for (int j = 0; j < 100; j++)
//				for (int k = 0; k < 100; k++)
//					for (int l = 0; l < 100; l++)
//						for (int m = 0; m < 100; m++)
//							for (int n = 0; n < 100; n++)
//								for (int o = 0; o < 100; o++)
//									for (int p = 0; p < 100; p++)
										for (int q = 0; q < 100; q++)
											for (int r = 0; r < 100; r++)
												for (int s = 0; s < 100; s++)
													for (int t = 0; t < 100; t++) {
														loopNumber++;
													}

		System.out.println("Total Loops exicuted[" + loopNumber + "]");
		System.out.println(builder.toString());
	}

}
