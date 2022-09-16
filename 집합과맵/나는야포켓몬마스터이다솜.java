package 집합과맵;

import java.util.HashMap;
import java.util.Scanner;

public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] list = new String[n+1]; // LinkedList 보다 일반 리스트가 조회에는 더 낫다!
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            String v = sc.nextLine();
            map.put(v, i);
            list[i] = v;
        }
        for(int i = 0; i< m; i++){
            String q = sc.nextLine();
            try{
                Integer.parseInt(q);
                System.out.println(list[Integer.parseInt(q)]);
            }
            catch(NumberFormatException e){
                System.out.println(map.get(q));
            }
        }
    }
}
