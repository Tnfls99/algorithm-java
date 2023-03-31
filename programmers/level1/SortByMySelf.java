package programmers.level1;

import java.util.Arrays;
import java.util.List;

public class SortByMySelf {

  public String[] solution(String[] strings, int n) {
    List<String> strs = Arrays.asList(strings);

    sort(strs, n);

    return strs.toArray(new String[0]);
  }

  private void sort(List<String> strings, int n) {
    strings.sort((str1, str2) -> {
      char c1 = str1.charAt(n);
      char c2 = str2.charAt(n);

      if (c1 > c2) {
        return 1;
      } else if (c2 > c1) {
        return -1;
      } else {
        return str1.compareTo(str2);
      }
    });
  }

}
