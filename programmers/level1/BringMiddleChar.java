package programmers.leve1;

public class BringMiddleChar {
  public String solution(String s) {
    if(s.length() % 2 == 0){
      String s1 = String.valueOf(s.charAt(s.length() / 2 - 1));
      String s2 = String.valueOf(s.charAt(s.length() / 2));
      return String.valueOf(s1 + s2);
    }
    return String.valueOf(s.charAt(s.length()/2));
  }
}
