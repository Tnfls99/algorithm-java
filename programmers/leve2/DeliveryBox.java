package programmers.leve2;
import java.util.*;

public class DeliveryBox {
	public int solution(int[] order) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		int wantIdx = 0;
		int boxIdx = 1;

		while(true){
			if(!stack.isEmpty() && order[wantIdx] == stack.peek()){
				answer += 1;

				wantIdx += 1;
				stack.pop();

				continue;
			}

			if(boxIdx > order.length){
				break;
			}

			if(order[wantIdx] == boxIdx){
				answer += 1;
				wantIdx += 1;
				boxIdx += 1;

				continue;
			}

			stack.push(boxIdx);
			boxIdx += 1;
		}

		return answer;

	}

	// 출처 및 참고 : https://velog.io/@as9587/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%97%B0%EC%8A%B5%EB%AC%B8%EC%A0%9C-%ED%83%9D%EB%B0%B0%EC%83%81%EC%9E%90-JAVA-22%EB%85%84-10%EC%9B%94-26%EC%9D%BC
}
