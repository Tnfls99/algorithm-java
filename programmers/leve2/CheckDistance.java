package programmers.leve2;

import java.util.*;

public class CheckDistance {

	private static final String PERSON = "P";
	private static final String EMPTY = "O";
	private static final String PARTITION = "X";

	public int[] solution(String[][] places) {
		List<String[][]> info = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			// 대기실 하나씩 순회
			// ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"]
			String[][] waitingRoom = new String[5][5];
			for (int j = 0; j < 5; j++) {
				String line = places[i][j]; // POOOP
				for (int k = 0; k < 5; k++) {
					String s = String.valueOf(line.charAt(k));
					waitingRoom[j][k] = s;
				}
			}
			info.add(waitingRoom);
		}

		int[] answer = new int[5];

		for (int i = 0; i < 5; i++) {
			int a = checkDistance(info.get(i));
			answer[i] = a;
		}

		return answer;
	}

	private int checkDistance(String[][] info) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (info[i][j].equals(PERSON)) {
					// 가로 체크
					// 1. 바로 옆에 사람이 있는 경우
					if (i < 4 && info[i + 1][j].equals(PERSON)) {
						return 0;
					}
					// 2. 두칸 옆에 사람이 있는 경우
					if (i < 3 && info[i + 2][j].equals(PERSON)) {
						if (!info[i + 1][j].equals(PARTITION)) { // 사람이 있는데 파티션도 없을 경우
							return 0;
						}
					}
					// 세로 체크
					// 1. 바로 밑에 사람이 있는 경우
					if (j < 4 && info[i][j + 1].equals(PERSON)) {
						return 0;
					}
					// 2. 두칸 밑에 사람이 있는 경우
					if (j < 3 && info[i][j + 2].equals(PERSON)) {
						if (!info[i][j + 1].equals(PARTITION)) { // 근데 사이에 파티션도 없을 경우
							return 0;
						}
					}
					// 대각선 체크
					// 대각선 왼쪽 아래
					if (i > 0 && j < 4 && info[i - 1][j + 1].equals(PERSON)) {
						if (!info[i - 1][j].equals(PARTITION) || !info[i][j + 1].equals(
							PARTITION)) { // 대각선 아래에 사람이 있는데 빈 테이블이 있을 경우
							return 0;
						}
					}
					// 대각선 오른쪽 아래
					if (i < 4 && j < 4 && info[i + 1][j + 1].equals(PERSON)) {
						if (!info[i][j + 1].equals(PARTITION) || !info[i + 1][j].equals(
							PARTITION)) { // 대각선 오랜쪽 아래에 사람이 있는데 빈 테이블이 있을 경우
							return 0;
						}
					}
				}
			}
		}

		return 1;
	}
}
