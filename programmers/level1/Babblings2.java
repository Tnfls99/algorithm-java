package programmers.level1;

import java.util.*;

public class Babblings2 {
	public int solution(String[] babbling) {
		List<String> ava = List.of("aya", "ye", "woo", "ma");

		int answer = 0;

		for(String b : babbling) {
			String left = b;

			if(isRepeat(b)){
				continue;
			}

			for(String a : ava) {
				left = left.replace(a, " ");
			}

			left = left.replace(" ", "");

			if(left.length() == 0){
				answer++;
			}
		}

		return answer;
	}

	boolean isRepeat(String b){
		List<String> not = List.of("ayaaya", "yeye", "woowoo", "mama");

		for(String n : not) {
			if(b.contains(n)){
				return true;
			}
		}
		return false;
	}
}
