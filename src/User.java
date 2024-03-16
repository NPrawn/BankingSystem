
public class User {
    private int account;
    private int password;
    private int balance;

    public User(int acc, int pw, int bal) {
        this.account = acc;
        this.password = pw;
        this.balance = bal;
    }

    public int getAccount() {
        return account;
    }

    public int getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void setAccount(int n) {
        account = n;
    }

    public void setPassword(int n) {
        password = n;
    }

    public void setBalance(int n) {
        balance = n;
    }
}
