package BasicMath1;

import java.util.Scanner;

public class SugarFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean forFinished = false;
        int n = sc.nextInt();
        if (n%5 == 0){
            System.out.println(n/5);
        }
        else{
            for(int i = n/5; i > -1; i--){
                if((n - 5 * i)% 3 == 0) {
                    System.out.println(i + (n - 5 * i)/ 3);
                    forFinished = true;
                    break;
                }
            }
            if(!forFinished){
                System.out.println(-1);
            }
        }
    }
}
