import java.util.HashMap;

public class Repository {
    static int j = 0;
    HashMap<Integer, User> mp = new HashMap<>();

    public Repository() {

    }

    public void addUser(int acc, int pwd, int bal) {
        User user = new User(acc, pwd, bal);
        mp.put(user.getAccount(), user);
        j++;
    }

    public boolean edit(User user, int n) {
        int tmp = user.getBalance() + n;
        if (tmp < 0) {
            System.out.println("잔액이 부족합니다.");
            return false;
        } else {
            user.setBalance(tmp);
            return true;
        }
    }

    public User searchUser(int acc) {
        User usr = mp.get(acc);
        if (usr == null) {
            System.out.println("계좌가 존재하지 않습니다.");
            return null;
        } else {
            return usr;
        }
    }
}
