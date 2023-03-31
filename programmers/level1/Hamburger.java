package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hamburger {

  public int solution(int[] ingredient) {
    int answer = 0;
    List<Integer> hamburger = new ArrayList<>(Arrays.asList(1, 2, 3, 1));
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < ingredient.length; i++) {
      list.add(ingredient[i]);
      if (list.size() >= 4) {
        if (list.subList(list.size() - 4, list.size()).equals(hamburger)) {
          answer += 1;
          list.subList(list.size() - 4, list.size()).clear();
        }
      }
    }
    return answer;
  }
}
