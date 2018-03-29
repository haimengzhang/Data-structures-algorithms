/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

	private int balance;
	private Account parentAccount;

	public Account (int balance, Account parentAccount) {
		this.balance = balance;
		this.parentAccount = parentAccount;
	}

	/** Initialize an account with the given BALANCE. */
	public Account(int balance) {
		this.balance = balance;
		this.parentAccount = null;
	}

	/** Return the number of dollars in the account. */
	public int getBalance() {
		return this.balance;
	}

	/** Deposits AMOUNT into the current account. */
	public void deposit(int amount) {
		if (amount < 0) {
			System.out.println("Cannot deposit negative amount.");
		} else {
			this.balance = this.balance + amount;
		}
	}

	/** Subtract AMOUNT from the account if possible. If subtracting AMOUNT
	 *	would leave a negative balance, print an error message and leave the
	 *	balance unchanged.
	 */
	public boolean withdraw(int amount) {
		if (amount < 0) {
			System.out.println("Cannot withdraw negative amount.");
			return false;
		} else if (this.totalFunds() < amount) {
			System.out.println("Insufficient funds");
			return false;
		} else {
			if (this.balance < amount) {
				amount -= this.balance;
				this.balance = 0;
				return this.parentAccount.withdraw(amount);
			}
			this.balance -= amount;
			return true;
		}
	}

	public int totalFunds() {
		if (this.parentAccount != null) {
			return this.balance + this.parentAccount.totalFunds();
		}
		return this.balance;
	}

	/** Merge account OTHER into this account by removing all money from OTHER
	 *	and depositing it into this account.
     */
    public void merge(Account other) {
        // TODO Put your own code here
        this.deposit(other.getBalance());
        other.withdraw(other.getBalance());
        this.balance += other.getBalance();
    }
}
