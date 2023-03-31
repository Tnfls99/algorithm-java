package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreePerson {

  private int answer = 0;

  public int solution(int[] number) {
    boolean[] visited = new boolean[number.length];

    comb(number, visited, 0, 3);

    return this.answer;
  }

  private void comb(int[] number, boolean[] visited, int start, int r) {
    if (r == 0) {
      List<Integer> member = new ArrayList<>();
      for (int i = 0; i < number.length; i++) {
        if (visited[i]) {
          member.add(number[i]);
        }
      }

      if (member.stream().mapToInt(Integer::intValue).sum() == 0) {
        this.answer += 1;
      }
      return;
    } else {
      for (int i = start; i < number.length; i++) {
        visited[i] = true;
        comb(number, visited, i + 1, r - 1);
        visited[i] = false;
      }
    }
  }
}
