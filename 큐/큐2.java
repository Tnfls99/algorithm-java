package 큐;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.LinkedList;

public class 큐2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<Integer>();
        int last = 0;
        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    last = num;
                    queue.add(num);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(queue.poll()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.peek()).append('\n');
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(last).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
