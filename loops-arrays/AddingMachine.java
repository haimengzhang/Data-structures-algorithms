import java.util.*;

public class AddingMachine {

	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean isPreviousZero = false;
		int total = 0;
		int subtotal = 0;
		int input;
		int last = 1;
		int MAXIMUM_NUMBER_OF_INPUTS = 100;
    // TODO Add code here and elsewhere to complete AddingMachine
		int[] inputs = new int[MAXIMUM_NUMBER_OF_INPUTS];
		while (true) {
			input = scanner.nextInt();
			if (input == 0) {
				if (isPreviousZero) {
					System.out.println("total " + total);
					for (int i = 0; i < last - 1; i++) {
						System.out.println(inputs[i]);
					}
					return;
				} else {
					System.out.println("subtotal " + subtotal);
					total += subtotal;
					subtotal = 0;
					isPreviousZero = true;
				}
			}
			subtotal += input;
			if (input != 0) {
				isPreviousZero = false;
				inputs[last-1] = input;
				last++;
			}
		   
		}
	}

}
