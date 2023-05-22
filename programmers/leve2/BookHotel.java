package programmers.leve2;

import java.util.*;
import java.time.*;

class BookHotel {
	public int solution(String[][] bookTimes) {

		Arrays.sort(bookTimes, (o1, o2) -> {
			if(o1[0].equals(o2[0])){
				return o1[1].compareTo(o2[1]);
			}
			return o1[0].compareTo(o2[0]);
		});


		List<LocalDateTime> useList = new ArrayList<>();

		for(String[] bookTime : bookTimes){
			String[] start = bookTime[0].split(":");
			String[] end = bookTime[1].split(":");

			LocalDateTime startTime = LocalDateTime.of(2023, 5, 22, Integer.parseInt(start[0]), Integer.parseInt(start[1]));
			LocalDateTime endTime = LocalDateTime.of(2023, 5, 22, Integer.parseInt(end[0]), Integer.parseInt(end[1])).plusMinutes(10);

			Collections.sort(useList);

			boolean isAdded = false;
			for(int i = 0; i < useList.size(); i++){
				if(useList.get(i).equals(startTime) || useList.get(i).isBefore(startTime)){
					useList.set(i, endTime);
					isAdded = true;
					break;
				}
			}

			if(!isAdded){
				useList.add(endTime);
			}

		}

		return useList.size();
	}
}