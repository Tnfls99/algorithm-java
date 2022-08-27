import java.util.Scanner;

public class CountWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        s = s.trim();

        if (s == ""){
            System.out.println(0);
        }
        else{
            String[] arr = s.split(" ");

            System.out.println(arr.length);
        }
    }
}
