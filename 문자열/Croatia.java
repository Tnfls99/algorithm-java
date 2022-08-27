import java.util.Scanner;

public class Croatia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        s = s.replace("c=", "0");
        s = s.replace("c-", "1");
        s = s.replace("dz=", "2");
        s = s.replace("d-", "3");
        s = s.replace("lj", "4");
        s = s.replace("nj", "5");
        s = s.replace("s=", "6");
        s = s.replace("z=", "7");

        System.out.println(s.length());
    }
}
