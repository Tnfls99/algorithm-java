package 집합과맵;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class NumberCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<Integer> s = new LinkedHashSet<Integer>();
        for(int i=0; i < n; i++){
            s.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for(int i=0; i < m; i++){
            if(s.contains(sc.nextInt())){
                System.out.print(1 + " ");
            }
            else{
                System.out.print(0 + " ");
            }
        }
        System.out.println();
    }
}
