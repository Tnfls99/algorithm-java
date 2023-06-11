package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {

	public int solution(int[][] jobs) {

		List<Integer> history = new ArrayList<>();

		Arrays.sort(jobs, (o1, o2) -> {
			if(o1[0] == o2[0]){
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		PriorityQueue<Job> queue = new PriorityQueue<>();
		queue.offer(new Job(jobs[0][0], jobs[0][1]));
		int curTime = jobs[0][0];

		int in = 1;

		while(!queue.isEmpty()){
			Job curJob = queue.poll();
			history.add(curTime - curJob.request + curJob.time);
			curTime += curJob.time;

			for(int i = in; i < jobs.length; i++){
				if(curTime >= jobs[i][0]){
					queue.offer(new Job(jobs[i][0], jobs[i][1]));
					in += 1;
				}
			}

			if(queue.isEmpty() && in < jobs.length){
				queue.offer(new Job(jobs[in][0], jobs[in][1]));
				curTime = jobs[in][0];
				in += 1;
			}
		}

		return (int) history.stream()
			.mapToInt(Integer::intValue)
			.average()
			.orElse(0);
	}
}

class Job implements Comparable<Job>{
	int request;
	int time;

	public Job(int request, int time){
		this.request = request;
		this.time = time;
	}

	public int compareTo(Job o){
		return this.time - o.time;
	}

	public String toString(){
		return "request : " + request + ", time : " + time;
	}
}
