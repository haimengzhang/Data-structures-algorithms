import java.util.HashMap;

public class Fibonacci {
	int callsToFib;
	int result;

	HashMap<Integer, Integer> nacci = new HashMap<>();

	public Fibonacci(int n){
		this.callsToFib = 0;
		this.result = fib(n);
	}
	
	private int fib(int n) {
		callsToFib++;
		if (nacci.containsKey(n))
			return nacci.get(n);
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			int returnValue = fib(n - 1) + fib(n - 2);
			nacci.put(n, returnValue);
			return returnValue;
		}
	}

}
