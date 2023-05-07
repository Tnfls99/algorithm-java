package ShortestDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	List<List<Node>> graph = new ArrayList<>();
	int[] distance;
	boolean[] visited;

	public void solution() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] info = bufferedReader.readLine().split(" ");
		int v = Integer.parseInt(info[0]);
		int e = Integer.parseInt(info[1]);

		int start = Integer.parseInt(bufferedReader.readLine());

		init(v);
		initGraph(bufferedReader, e);

		dijkstra(start, v);

		printAnswer(start);
	}

	public void init(int v){
		for(int i = 0; i < v+1; i++){
			graph.add(new ArrayList<>());
		}

		distance = new int[v+1];
		visited = new boolean[v+1];

		for(int i = 0; i < v+1; i++){
			distance[i] = Integer.MAX_VALUE;
		}
	}

	public void initGraph(BufferedReader bufferedReader, int e) throws IOException {
		for(int i = 0; i < e; i++){
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int first = Integer.parseInt(stringTokenizer.nextToken());
			int second = Integer.parseInt(stringTokenizer.nextToken());
			int cost = Integer.parseInt(stringTokenizer.nextToken());

			graph.get(first).add(new Node(second, cost));
		}
	}

	public void dijkstra(int start, int v){
		distance[start] = 0;

		PriorityQueue<Node> queue = new PriorityQueue<>();

		queue.add(new Node(start, 0));

		while(!queue.isEmpty()){
			Node cur = queue.poll();

			if(visited[cur.idx]){
				continue;
			}

			visited[cur.idx] = true;

			for(int i = 0; i < graph.get(cur.idx).size(); i++){
				Node next = graph.get(cur.idx).get(i);

				if(distance[next.idx] > distance[cur.idx] + next.cost){
					distance[next.idx] = distance[cur.idx] + next.cost;
					queue.add(new Node(next.idx, distance[next.idx]));
				}
			}
		}
	}

	public void printAnswer(int start){
		for(int i = 1; i < distance.length; i++){
			if(i != start && distance[i] == Integer.MAX_VALUE){
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
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
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}
