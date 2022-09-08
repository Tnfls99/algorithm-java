package 집합과맵;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class 문자열집합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        sc.nextLine();
        Set<String> s = new LinkedHashSet<String>();

        for(int i = 0; i < n; i++){
            s.add(sc.nextLine());
        }
        for(int i = 0; i<m; i++){
            if(s.contains(sc.nextLine())){
                count++;
            }
        }
        System.out.println(count);
    }
}
