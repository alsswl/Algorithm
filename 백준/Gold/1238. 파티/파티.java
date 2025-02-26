
import java.io.*;
import java.util.*;

public class Main {

  public static ArrayList<ArrayList<Node>> rode;
  public static int[][] ans;

  static class Node implements Comparable<Node> {
    int nodeNum;
    int time;

    public Node(int nodeNum,int time){
      this.nodeNum = nodeNum;
      this.time = time;
    }

    @Override
    public int compareTo(Node node){
      return this.time - node.time;
    }
  }

  public static void ds(int n){
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(n,0));

    while(pq.size() != 0){
      Node now = pq.poll();
      if(ans[n][now.nodeNum] < now.time) continue;

      ArrayList<Node> nowList = rode.get(now.nodeNum);

      for(int i = 0;i<nowList.size();i++){
        if(ans[n][nowList.get(i).nodeNum] > now.time + nowList.get(i).time){
          ans[n][nowList.get(i).nodeNum] = now.time + nowList.get(i).time;
          pq.add(new Node(nowList.get(i).nodeNum, now.time + nowList.get(i).time));
        }
      }
    }

  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    rode = new ArrayList<>();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    ans = new int[n+1][n+1];

    for(int i = 0;i<=n;i++){
      rode.add(new ArrayList<>());
      for(int j = 0;j<=n;j++){
        ans[i][j] = Integer.MAX_VALUE;
      }
    }

    for(int i = 0;i<m;i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      rode.get(start).add(new Node(end,cost));
    }

    for(int i = 1;i<=n;i++){
      ds(i);
    }

    int max = 0;

    for(int i = 1;i<=n;i++){
      if(i == x) continue;
      if(max < ans[x][i] + ans[i][x]){
        max = ans[x][i] + ans[i][x];
      }
    }

    System.out.println(max);


  }
}
