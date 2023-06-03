package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Secrets {

	char z = 'z';

	public String solution(String s, String skip, int index) {
		StringBuilder sb = new StringBuilder();

		List<Character> alphabets = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

		for(int i = 0; i < skip.length(); i++){
			alphabets.remove(Character.valueOf(skip.charAt(i)));
		}

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			int idx = alphabets.indexOf(c);
			if(idx + index >= alphabets.size()){
				sb.append(alphabets.get(((idx + index) - alphabets.size()) % alphabets.size()));
			} else {
				sb.append(alphabets.get(idx + index));
			}
		}

		return sb.toString();
	}
}
