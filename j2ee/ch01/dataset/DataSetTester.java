package j2ee.ch01.dataset;

import java.util.Scanner;

public class DataSetTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DataSet data = new DataSet();
		boolean done = false;
		while (!done)  {
			System.out.print("Enter value, Q to quit: ");
			String input = in.next();
			if (input.equalsIgnoreCase("Q"))
				done = true;
			else {
				double x = Double.parseDouble(input);
				data.add(x);
			}
		}
		System.out.println("Average = " + data.getAverage());
		System.out.println("Maximum = " + data.getMaximum());
		in.close();
	}

}
