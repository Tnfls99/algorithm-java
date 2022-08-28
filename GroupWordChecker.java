import java.util.ArrayList;
import java.util.Scanner;

public class GroupWordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = n;
        sc.nextLine();

        for(int i=0; i < n; i++){
            String s = sc.nextLine();
            ArrayList<Character> arr = new ArrayList<Character>(s.length());
            for(int j=0; j < s.length(); j++){
                char c = s.charAt(j);
                if(arr.size() == 0 || !arr.contains(c)){
                    arr.add(c);
                }
                else if(arr.contains(c) && arr.get(arr.size()-1) != c){
                    count -= 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
