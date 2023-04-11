package programmers.leve2;

import java.util.*;

public class DiscountEvent {

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String, Long> wants = new HashMap<>();
		for(int i = 0; i<number.length; i++){
			wants.put(want[i], Long.valueOf(number[i]));
		}

		for(int i = 0; i < discount.length - 9; i++){
			List<String> discountList = Arrays.asList(discount).subList(i, i+10);
			Map<String, Long> counts = new HashMap<>();

			for(String w: want){
				long c = discountList.stream()
					.filter(d -> d.equals(w))
					.count();
				counts.put(w, c);
			}

			if(checkEquals(counts, wants)){
				answer += 1;
			}

		}

		return answer;
	}

	private boolean checkEquals(Map<String, Long> counts, Map<String, Long> wants){
		Set<String> keys = wants.keySet();

		for(String key: keys){
			if(!counts.containsKey(key) || counts.get(key) != wants.get(key)){
				return false;
			}
		}

		return true;
	}
}
