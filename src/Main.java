import java.util.Scanner;

//커밋테스트
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Service sv = new Service();
        boolean p = true;
        while (p) {

            int s;
            System.out.println("1.입금 2.출금 3.이체 4.조회 5.종료");
            System.out.print("실행할 작업을 입력하세요: ");
            s = sc.nextInt();
            switch (s) {
                case 1: // 입금
                    sv.Deposit();
                    break;
                case 2: // 출금
                    sv.Withdraw();
                    break;
                case 3: // 이체
                    sv.Remit();
                    break;
                case 4: // 조회
                    sv.showBalance();
                    break;
                case 5: // 종료
                    System.out.println("시스템을 종료합니다.");
                    p = false;
                    break;
            }
        }
    }
}
