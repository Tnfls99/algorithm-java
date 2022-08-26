import java.util.Scanner;

public class FindChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for(int i = 97; i < 123; i++){
            int idx = s.indexOf((char)i);
            System.out.print(idx + " ");
        }
        System.out.println();
    }
}
