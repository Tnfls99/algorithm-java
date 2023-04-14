package programmers.leve2;
import java.util.*;

public class Triangle {
	public int[] solution(int n) {

		int[][] triangle = new int[n][n];
		int x = -1;
		int y = 0;
		int num = 1;
		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				if(i % 3 == 0){
					x += 1;
				} else if (i % 3 == 1){
					y += 1;
				} else{
					x -= 1;
					y -= 1;
				}

				triangle[x][y] = num;
				num += 1;
			}
		}

		List<Integer> arr = new ArrayList<>();
		for(int i = 0; i < triangle.length; i++){
			for(int j = 0; j < triangle[0].length; j++){
				if(triangle[i][j] != 0){
					arr.add(triangle[i][j]);
				}
			}
		}

		int[] answer = new int[arr.size()];

		for(int i = 0; i < arr.size(); i++){
			if(arr.get(i) != 0){
				answer[i] = arr.get(i);
			}
		}

		return answer;
	}
}
