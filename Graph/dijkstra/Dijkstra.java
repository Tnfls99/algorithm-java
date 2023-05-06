package Graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {

	boolean[] visited;
	List<List<Node>> graph;
	int[] distance;

	public static void main(String[] args){
		Dijkstra dijkstra = new Dijkstra();

		int[][] road = new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		dijkstra.run(5, road, 3);
	}

	public void run(int n, int[][] road, int k){
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

		dijkstra(n);

		int answer = 0;
		for(int i = 1; i < distance.length; i++){
			if(distance[i] <= k){
				answer += 1 ;
			}
		}

		System.out.println(Arrays.toString(distance));
	}

	void dijkstra(int n){
		distance[1] =  0;
		visited[1] = true;

		for(int i = 1; i < n+1; i++){
			int minIdx = getSmallestIndex(n);
			visited[minIdx] = true;

			for(int j = 0; j < graph.get(minIdx).size(); j++){
				Node node = graph.get(minIdx).get(j);

				if(distance[node.idx] > distance[minIdx] + node.cost){
					distance[node.idx] = distance[minIdx] + node.cost;
				}
			}
		}
	}

	int getSmallestIndex(int n){
		int minDist = Integer.MAX_VALUE;
		int minIdx = 1;

		for(int i = 2; i < n+1; i++){
			if(visited[i]){
				continue;
			}

			if(distance[i] < minDist){
				minDist = distance[i];
				minIdx = i;
			}
		}

		return minIdx;

		// int min = Integer.MAX_VALUE;
		// int idx = 1;
		//
		// // 가장 작은 거리애 있는 인덱스값 찾기
		// for (int j = 2; j <= n; j++) {
		// 	if(!visited[j] && min > distance[j]) {
		// 		idx = j;
		// 		min = distance[j];
		// 	}
		// }
		//
		// return idx;
	}
}

class Node {
	int idx;
	int cost;

	Node (int idx, int cost){
		this.idx = idx;
		this.cost = cost;
	}
}
