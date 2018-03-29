public class SieveOfEratosthenes {

	public static void main(String[] args) {
		if (args.length < 1) { 
			System.out.println("You need to enter an argument!");
			return;
		}
		int upperBound = Integer.parseInt(args[0]);
		boolean[] isNotPrime = new boolean[upperBound];
		for (int i = 0; i < upperBound; i++) {
			if (i < 2) {
				isNotPrime[i] = true;
				continue;
			}
			if (isNotPrime[i] == true) {
				continue;
			} else {
				//THIS DATA HAS BEEN CORRUPTED; REPLACE IT!

				for (int j = i + i; j < upperBound; j = j + i) {
					isNotPrime[j] = true;
				}
			}
		}
		for (int i = 0; i < upperBound; i++) {
			if (!isNotPrime[i]) {
				System.out.println(i + " is a prime number.");
			}
		}
	}
}