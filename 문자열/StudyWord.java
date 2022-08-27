import java.util.Scanner;

public class StudyWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[26];
        String s = sc.next();
        
        for(int i = 0; i < s.length(); i++){
            if (65 <= s.charAt(i) && s.charAt(i) <= 90){
                arr[s.charAt(i) - 65]++; // 아스키코드를 사용하여 인덱스 값으로 변환하는 것이 포인트!!!
            }
            else{
                arr[s.charAt(i) - 97]++;
            }
        }
        
        int max = -1;
        char ch = '?';

        for(int i = 0; i < 26; i++){
            if (arr[i] > max){
                max = arr[i];
                ch = (char)(i+65);
            }
            else if(arr[i] == max){
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
