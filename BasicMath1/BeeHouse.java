package BasicMath1;

import java.util.Scanner;

public class BeeHouse {
    // 1 -> 2, 3, 4, 5, 6, 7
    // 5 -> 11 -> 17 -> 23
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int count = 1;
    int range = 2;

    if (n == 1){
        System.out.println(1);
    }
    else{
        while(range <= n){
            range = range + (6 * count);
            count++;
        }
        System.out.println(count);
    }
    
    }
}
