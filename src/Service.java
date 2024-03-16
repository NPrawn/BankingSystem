import java.util.Scanner;

public class Service {
    Scanner sc = new Scanner(System.in);
    Repository rp = new Repository();

    public Service() {
        rp.addUser(11111111, 1111, 1000);
        rp.addUser(22222222, 2222, 1000);
        rp.addUser(33333333, 3333, 1000);
    }

    public boolean checkPassword(User user) {
        int pwd;
        System.out.print("비밀번호: ");
        pwd = sc.nextInt();
        if (user.getPassword() == pwd) {
            return true;
        } else {
            System.out.println("비밀번호가 틀립니다.");
            return false;
        }
    }

    public void showBalance() {
        int acc;
        System.out.print("조회할 계좌: ");
        acc = sc.nextInt();
        User usr = rp.searchUser(acc);
        if (usr == null) {
            return;
        }
        if (this.checkPassword(usr)) {
            System.out.println("계좌잔액: " + usr.getBalance());
        }
    }

    public void Deposit() {
        int acc, n;
        System.out.print("입금할 계좌: ");
        acc = sc.nextInt();
        User usr = rp.searchUser(acc);
        if (usr == null) {
            return;
        }
        System.out.print("입금할 금액: ");
        n = sc.nextInt();
        if (rp.edit(usr, n)) {
            System.out.println(n + "원이 입금되었습니다.");
            System.out.println("잔액: " + usr.getBalance());
        } else {
            System.out.println("입금 실패");
        }
    }

    public void Withdraw() {
        int acc, pwd, n;
        System.out.print("출금할 계좌: ");
        acc = sc.nextInt();
        User usr = rp.searchUser(acc);
        if (usr == null) {
            return;
        }
        if (!this.checkPassword(usr)) {
            return;
        }
        System.out.print("출금할 금액: ");
        n = sc.nextInt();
        if (rp.edit(usr, -n)) {
            System.out.println(n + "원이 출금되었습니다.");
            System.out.println("잔액: " + usr.getBalance());
        }
    }

    public void Remit() {
        int sacc, n, racc;
        System.out.print("출금할 계좌: ");
        sacc = sc.nextInt();
        User susr = rp.searchUser(sacc);
        if (susr == null) {
            return;
        }
        if (!this.checkPassword(susr)) {
            return;
        }
        System.out.print("이체할 계좌: ");
        racc = sc.nextInt();
        User rusr = rp.searchUser(racc);
        if (rusr == null) {
            return;
        }
        System.out.print("이체할 금액: ");
        n = sc.nextInt();
        rp.edit(rusr, n);
        rp.edit(susr, -n);
        System.out.println("계좌에서 " + n + "원이 이체되었습니다.");
        System.out.println("잔액: " + susr.getBalance());
    }
}
