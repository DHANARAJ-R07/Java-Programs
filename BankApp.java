abstract class Account {
    double balance = 0;

    abstract void deposit(double amount);
    abstract void withdraw(double amount);
}

class MyAccount extends Account {

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class BankApp {
    public static void main(String[] args) {
        MyAccount acc = new MyAccount();

        acc.deposit(1000);
        acc.withdraw(400);

        System.out.println("Balance: " + acc.balance);
    }
}