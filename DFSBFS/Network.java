package DFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {

  private int answer = 0;
  private Map<Integer, List<Integer>> graph = new HashMap<>();
  private Map<Integer, Boolean> visited = new HashMap<>();

  public int solution(int n, int[][] computers) {
    int comNum = computers.length;

    for(int i = 0; i < comNum; i++){
      visited.put(i, false);
      List<Integer> list = this.graph.getOrDefault(i, new ArrayList<>());
      for(int j = 0; j < computers[i].length; j++){
        if(computers[i][j] == 1 && i != j){
          list.add(j);
        }
      }
      this.graph.put(i, list);
    }

    for(int i = 0; i < comNum; i++){
      if(!this.visited.get(i)){
        dfs(i);
        answer += 1;
      }
    }

    return this.answer;
  }

  private void dfs(int v){
    this.visited.put(v, true);
    List<Integer> list = this.graph.get(v);

    list.forEach(l -> {
      if(!this.visited.get(l)){
        dfs(l);
      }
    });
  }
}
