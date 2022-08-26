import java.util.Scanner;

public class Asci{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char c = sc.nextLine().charAt(0);
        int num = (int)c;

        System.out.println(num);
    }
}