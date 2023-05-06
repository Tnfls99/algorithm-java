package programmers.leve2;
import java.util.*;

public class Delivery {

	boolean[] visited;
	int[] distance;
	List<List<Node>> graph;

	public int solution(int n, int[][] road, int K) {

		visited = new boolean[n+1];
		graph = new ArrayList<>();
		distance = new int[n+1];

		// 각 노드에 인접노드를 넣기 위한 자료 생성
		for(int i = 0; i < n+1; i++){
			graph.add(new ArrayList<>());
		}

		// 간선 정보를 기반으로 그래프를 채운다.
		for(int i = 0; i < road.length; i++){
			int a = road[i][0];
			int b = road[i][1];
			int cost = road[i][2];

			graph.get(a).add(new Node(b, cost));
			graph.get(b).add(new Node(a, cost));
		}

		// 최단거리 그래프 초기화
		for(int i = 0; i < n+1; i++){
			distance[i] = Integer.MAX_VALUE;
		}

		dijkstra();

		int answer = 0;
		for(int i = 1; i < distance.length; i++){
			if(distance[i] <= K){
				answer += 1 ;
			}
		}
		return answer;
	}

	void dijkstra(){
		distance[1] = 0;

		PriorityQueue<Node> q = new PriorityQueue<>();

		q.add(new Node(1, 0));

		while(!q.isEmpty()){
			Node n = q.poll();

			if(visited[n.idx]){
				continue;
			}

			visited[n.idx] = true;

			for(int i = 0; i < graph.get(n.idx).size(); i++){
				Node next = graph.get(n.idx).get(i);

				if(distance[next.idx] > distance[n.idx] + next.cost){
					distance[next.idx] = distance[n.idx] + next.cost;
					q.add(new Node(next.idx, distance[next.idx]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int idx;
	int cost;

	Node(int idx, int cost){
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node compareNode){
		if(this.cost < compareNode.cost){
			return -1;
		}
		return 1;
	}
}
