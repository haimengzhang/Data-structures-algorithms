public class ModNCounter {

	private int myCount;
	private int myN;

	public ModNCounter(int n) {
		myCount = 0;
		myN = n;
	}

	public void increment() {
		myCount = (myCount + 1) % myN;
	}

	public void reset() {
		myCount = 0;
	}

	public int value() {
		return myCount;
	}

}
