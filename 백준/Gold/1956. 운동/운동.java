
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

  static int[][] dix;
  static ArrayList<ArrayList<Node>> list;

  static class Node implements Comparable<Node>{
    int end;
    int length;

    public Node(int end, int length){
      this.end = end;
      this.length = length;
    }

    @Override
    public int compareTo(Node nowNode){
      return length - nowNode.length;
    }
  }

  static void stra(int k){
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(k,0));

    while(!pq.isEmpty()){
      Node now = pq.poll();
      if(now.length > dix[k][now.end]) continue;
      //현재 나온 노드의 도착점까지를 갱신
      ArrayList<Node> nowList = list.get(now.end);
      for(int i = 0;i<nowList.size();i++){
        if(dix[k][nowList.get(i).end] > now.length + nowList.get(i).length){
          dix[k][nowList.get(i).end] = now.length + nowList.get(i).length;
          pq.add(new Node(nowList.get(i).end,now.length + nowList.get(i).length));
        }
      }
    }

  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    list = new ArrayList<>();

    for(int i = 0;i<=v;i++){
      list.add(new ArrayList<>());
    }

    for(int i = 0;i<e;i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int length = Integer.parseInt(st.nextToken());
      list.get(start).add(new Node(end,length));
    }

    dix = new int[v+1][v+1];

    for(int i = 1;i<=v;i++){
      for(int j = 1;j<=v;j++){
        dix[i][j] = Integer.MAX_VALUE;
      }
    }

    for(int i =1;i<=v;i++){
      stra(i);
    }

    int ans = Integer.MAX_VALUE;

    for(int i = 1;i<=v;i++){
      for(int j = 1;j<=v;j++){
        if(dix[i][j] != Integer.MAX_VALUE && dix[j][i] != Integer.MAX_VALUE){
          if(dix[i][j] + dix[j][i] < ans){
            ans = dix[i][j] + dix[j][i];
            //System.out.println(ans);
          }
        }
      }
    }
    
    if(ans == Integer.MAX_VALUE){
      System.out.println(-1);
    }
    else System.out.println(ans);

  }
}
