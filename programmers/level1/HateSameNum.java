package programmers.level1;
import java.util.*;

public class HateSameNum {
    public int[] solution(int []arr) {
      Stack<Integer> stack = new Stack<>();

      for(int num : arr){
        if(stack.empty()){
          stack.add(num);
          continue;
        }

        if(!Objects.equals(stack.peek(), num)){
          stack.add(num);
        }
      }

      int[] answer = new int[stack.size()];

      for(int i = 0; i<stack.size(); i++){
        answer[i] = stack.get(i);
      }

      return answer;
    }
}
