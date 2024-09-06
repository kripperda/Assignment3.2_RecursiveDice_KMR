/*Die roller class using recursion*/

public class RecDieRoller {

	// dieRoll method
	public static int dieRoll(int roll, int total) {
		int n = (int) (Math.random() * 6) + 1;// generates random number
		System.out.println("Roll " + roll + " = " + n);// Prints each roll
		// Rolls until 2
		if (n == 2) {
			total += n;
			System.out.println("Total = " + total);// Prints total of die rolls summed
			return total;
		} else {
			total += n;
			return dieRoll(roll + 1, total);
		} // end else
	}// end class

	/* Application to run die roll */
	public static void main(String[] args) {

		/* Creates die roller and solves it */
		// Individual die rolls
		int roll = 1;
		int total = 0;
		total = dieRoll(roll, total);
	}// end main
}// end class
