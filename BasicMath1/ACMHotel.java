package BasicMath1;


// 1 2 3 4 5 6 -> 1
// 7 8 9 10 11 12 -> 2

import java.util.Scanner;

public class ACMHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();
            int xx = 0;
            int yy = 0;
            if (n%h == 0){ // 제일 높은 층의 경우 나머지가 0 이므로 주의해줘야함!
                xx = h * 100;
            }
            else{
                xx = n%h * 100;
            }

            if (n%h == 0){
                yy = n/h;
            }
            else{
                yy = n/h + 1;
            }
            
            System.out.println(String.format("%d%02d", xx, yy));
        }
    }
}
