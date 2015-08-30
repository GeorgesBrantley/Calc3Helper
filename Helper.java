import java.util.Scanner;

public class Helper {

	// globals
	static Scanner read = new Scanner(System.in);
	static double[] vect1 = new double[3];
	static double[] vect2 = new double[3];
	static double[] ans = new double[3];

	// mains
	public static void main(String[] args) {
		System.out.println("\tCALC3 PROGRAM\n");
		boolean on = true;

		while (on) {
			display(); // function to give the whole shebangbang
			String input = new String();

			// the life juice of the program. starts here.
			try {
				input = read.next();
				Exception wrong = new Exception();
				// inputs!
				switch (input) {
				case "1":
					DotP();
					break;
				case "2":
					CrossP();
					break;
				case "3":
					DotCrossP();
					break;
				case "4":
					Angle();
					break;
				case "5":
					// stop program
					System.out
							.println("Survive Math!");
					System.exit(1);
					break;
				default:
					throw wrong;
				}
			} catch (Exception E) {
				System.out.println("ERROR enter a single number (1-5) ERROR\n");
			}
		}
	} // end of main

	static void display() {
		System.out.println("\tMAIN MENU");
		System.out
				.println("Choose a mathmatical thing \nInput a Number (1-4)\n");
		System.out.println("1. Dot Product");
		System.out.println("2. Cross Product");
		System.out.println("3. Dot Cross Product");
		System.out.println("4. Vector Angles");
		System.out.println("5. Exit\n:");

	}

	static void DotP() {
		System.out.println("\n\tDot Product!\n");
		System.out.println("Please enter all the components of Vector 1");
		System.out.println("Example of input: 3 -2 1.2 (No fractions)");

		// pulls input
		for (int x = 0; x < 3; ++x)
			vect1[x] = read.nextDouble();
		System.out.println("Now do the same for Vector 2");
		for (int x = 0; x < 3; ++x)
			vect2[x] = read.nextDouble();

		System.out.println("\nThe dot Product is: ");
		System.out.println(printV(vect1) + " * " + printV(vect2));

		double dotans = 0;
		for (int x = 0; x < 3; ++x)
			dotans += vect1[x] * vect2[x];

		System.out
				.println(": "
						+ dotans
						+ "\nThank you for using Dot Product!\nBack to main menu.....\n");

	}

	static void CrossP() {
		System.out.println("\n\tCross Product!\n");
		System.out.println("Please enter all the components of Vector 1");
		System.out.println("Example of input: 3 -2 1.2 (No fractions)");

		// pulls input
		for (int x = 0; x < 3; ++x)
			vect1[x] = read.nextDouble();
		System.out.println("Now do the same for Vector 2");
		for (int x = 0; x < 3; ++x)
			vect2[x] = read.nextDouble();

		System.out.println("\nThe Cross Product is: ");
		System.out.println(printV(vect1) + " X " + printV(vect2));

		// uses third array
		ans[0] = vect1[1] * vect2[2] - vect1[2] * vect2[1];
		ans[1] = -1 * (vect1[0] * vect1[2] - vect1[2] * vect2[0]);
		ans[2] = vect1[0] * vect2[1] - vect1[1] * vect2[0];

		System.out.println("      " + printV(ans));
		System.out
				.println("Thank you for crossing your product\nBack to main menu.....\n");
	}

	static void DotCrossP() {
		System.out.println("\n\tDOT Cross Product!\n");
		System.out.println("(Vector 1 X Vector 2) * Vector 3");
		System.out.println("Please enter all the components of Vector 1");
		System.out.println("Example of input: 3 -2 1.2 (No fractions)");
		// vector 3
		double[] vect3 = new double[3];

		// pulls input
		for (int x = 0; x < 3; ++x)
			vect1[x] = read.nextDouble();
		System.out.println("Now do the same for Vector 2");
		for (int x = 0; x < 3; ++x)
			vect2[x] = read.nextDouble();

		System.out.println("Now do the same for Vector 3");
		for (int x = 0; x < 3; ++x)
			vect3[x] = read.nextDouble();

		System.out.println("\nThe DOT Cross Product is: ");
		System.out.println("(" + printV(vect1) + " X " + printV(vect2) + ") * "
				+ printV(vect3));

		// CROSS PRODUCT
		ans[0] = vect1[1] * vect2[2] - vect1[2] * vect2[1];
		ans[1] = -1 * (vect1[0] * vect1[2] - vect1[2] * vect2[0]);
		ans[2] = vect1[0] * vect2[1] - vect1[1] * vect2[0];

		// DOT PRODUCT
		double dotans = 0;
		for (int x = 0; x < 3; ++x)
			dotans += ans[x] * vect3[x];

		// FINAL PRINT
		System.out
				.println(":  "
						+ dotans
						+ "\nThank you for using DOT Cross Product!\nBack to main menu.....\n");
	}

	static void Angle() {
		System.out.println("\n     Finding The Angle Between 2 Vectors!\n");
		System.out.println("Please enter all the components of Vector 1");
		System.out.println("Example of input: 3 -2 1.2 (No fractions)");

		// pulls input
		for (int x = 0; x < 3; ++x)
			vect1[x] = read.nextDouble();
		System.out.println("Now do the same for Vector 2");
		for (int x = 0; x < 3; ++x)
			vect2[x] = read.nextDouble();

		System.out.println("V1: " + printV(vect1) + "\nV2: " + printV(vect2));
		System.out.println("\nThe Angle is: ");
		System.out.println("Cos^-1( (V1 * V2)/(|V1||V2|))");

		double dotans = 0;
		for (int x = 0; x < 3; ++x)
			dotans += vect1[x] * vect2[x];

		// finding magnitude
		double v1 = Math.sqrt(Math.pow(vect1[0], 2) + Math.pow(vect1[1], 2)
				+ Math.pow(vect1[2], 2));
		double v2 = Math.sqrt(Math.pow(vect2[0], 2) + Math.pow(vect2[1], 2)
				+ Math.pow(vect2[2], 2));

		System.out.println(":  " + Math.acos(dotans / (v1 * v2)) * 180
				/ Math.PI + " Degrees");
		System.out
				.println("Thank you for using Angle Finder 2.0\nReturning to the Main Menu\n");
	}

	// returns any vector cause its cool like that
	static String printV(double[] vect) {
		return "<" + vect[0] + "," + vect[1] + "," + vect[2] + ">";
	}

}
