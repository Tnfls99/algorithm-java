package 집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            int t = Integer.parseInt(st.nextToken());
            map.put(t, map.getOrDefault(t, 0)+1);    
        }
        
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for(int j = 0; j < m; j++){
            int t = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(t, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
