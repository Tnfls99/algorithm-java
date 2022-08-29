package BasicMath1;
// 1/1 1/2 2/1 3/1 2/2 1/3 1/4 2/3 3/2 4/2
// 1    2   3   4   5   6   7   8   9   10

// 1 2 6 7
// 3 5 8 
// 4 9 
//   10


// 1/1 -> 1 1
// 1/2 2/1 -> 2 2, 3
// 3/1 2/2 1/3 -> 3

import java.util.Scanner;

public class FoundFraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int cross_count = 1;
        int sum = 0;

        while(true){
            if(x <= sum + cross_count){
                if(cross_count % 2 == 1){
                    System.out.println(
                        (cross_count - (x - sum - 1) + "/" + (x - sum))
                    );
                    break;
                }
                else{
                    System.out.println((x-sum) + "/" + (cross_count - (x-sum-1)));
                    break;
                }
            }
            else{
                sum += cross_count;
                cross_count++;
            }
        }
        

        
    }
}
