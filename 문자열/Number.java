import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        StringBuffer sbA = new StringBuffer(a);
        StringBuffer sbB = new StringBuffer(b);

        int numA = Integer.parseInt(new StringBuffer(a).reverse().toString());
        int numB = Integer.parseInt(new StringBuffer(b).reverse().toString());

        // if (numA < numB){
        //     System.out.println(numB);
        // }else{
        //     System.out.println(numA);
        // }

        System.out.println(numA > numB ? numA : numB);
    }
}
