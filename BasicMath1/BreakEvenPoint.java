package BasicMath1;
import java.util.Scanner;

public class BreakEvenPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(c-b <= 0){
            System.out.println(-1);
        }
        else{
            int answer = a / (c-b);
            while(answer*(c-b) - a <= 0){
                answer += 1;
            }
            System.out.println(answer);
        }
    }
}
