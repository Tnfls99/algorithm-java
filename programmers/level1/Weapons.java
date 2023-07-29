package programmers.level1;

public class Weapons {
	public int solution(int number, int limit, int power) {
		int answer = 0;

		for(int i = 1; i <= number; i++){
			int count = 0;
			for(int j = 1; j * j <= i; j++){
				if(j * j == i) count++;
				else if(i % j == 0) count += 2;
			}

			if(count > limit){
				answer += power;
			} else {
				answer += count;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Weapons weapons = new Weapons();

		weapons.solution(5 ,3, 2);
	}
}