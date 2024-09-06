
public class DiceRoll {

	/**
	 * The number of times that the experiment "roll for a given total" is to be
	 * repeated. The program performs this many experiments, and prints the average
	 * of the result, for each possible roll value,
	 */
	public static final int DiceRolls = 1000;

	public static void main(String[] args) {
		double average; // The average number of rolls to get a given total.
		System.out.println("Total On Dice     Average Number of Rolls");
		System.out.println("-------------     -----------------------");
		for (int dice = 1; dice <= 6; dice++) {
			average = getAverageRollCount(dice);
			System.out.printf("%10d%20.3f\n", dice, average);
			// Use 10 spaces to output dice, and use 20 spaces to output
			// average, with 3 digits after the decimal.
		}
	}

	/**
	 * Find the average number of times a pair of dice must be rolled to get a given
	 * total. The experiment of rolling for the given total is repeated
	 * NUMBER_OF_EXPERIMENTS times and the average number of rolls over all the
	 * experiments is computed. Precondition: The given total must be between 2 and
	 * 12, inclusive.
	 * 
	 * @param roll the total that we want to get on the dice
	 * @return the average number of rolls that it takes to get the specified total
	 */
	public static double getAverageRollCount(int roll) {
		int rollCountThisExperiment; // Number of rolls in one experiment.
		int rollTotal; // Total number of rolls in all the experiments.
		double averageRollCount; // Average number of rolls per experiment.
		rollTotal = 0;
		for (int i = 0; i < DiceRolls; i++) {
			rollCountThisExperiment = rollFor(roll);
			rollTotal += rollCountThisExperiment;
		}
		averageRollCount = ((double) rollTotal) / DiceRolls;
		return averageRollCount;
	}

	/**
	 * Simulates rolling a pair of dice until a given total comes up. Precondition:
	 * The desired total is between 2 and 12, inclusive.
	 * 
	 * @param N the total that we want to get on the dice
	 * @return the number of times the dice are rolled before the desired total
	 *         occurs
	 * @throws IllegalArgumentException if the parameter, N, is not a number that
	 *                                  could possibly come up on a pair of dice
	 */
	public static int rollFor(int N) {

		int die; // Numbers between 1 and 6 representing the dice.
		int roll; // Total showing on dice.
		int rollCount; // Number of rolls made.
		rollCount = 0;
		do {
			die = (int) (Math.random() * 6) + 1;
			roll = die;
			rollCount++;
		} while (roll != N);
		return rollCount;
	}

} // end DiceRollStats
