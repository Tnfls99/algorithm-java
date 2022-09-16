package 집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 듣보잡 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            set1.add(br.readLine());
        }
        for(int i = 0; i < m; i++){
            set2.add(br.readLine());
        }

        set1.retainAll(set2);
        String[] list = new String[set1.size()];
        set1.toArray(list);
        Arrays.sort(list);
        System.out.println(list.length);
        for(String s : list){
            System.out.println(s);
        }
    }
}
