import java.util.Scanner;

public class Sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;
        sc.nextLine();
        String line = sc.nextLine();
        for(int i = 0; i < n; i++){
            answer = answer + Character.getNumericValue(line.charAt(i));
        }
        System.out.println(answer);
    }
}
