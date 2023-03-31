package programmers.level1;

public class SumBetweenAToB {

  public long solution(int intA, int intB) {

    long a = intA;
    long b = intB;

    if (a == b) {
      return a;
    } else if (a > b) {
      return (a - b + 1) * (a + b) / 2;
    } else {
      return (b - a + 1) * (a + b) / 2;
    }
  }
}
