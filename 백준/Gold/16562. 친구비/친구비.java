
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] mon = new int[n+1];
    int[] vis = new int[n+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1;i<=n;i++){
      mon[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    for(int i = 0;i<=n;i++){
      list.add(new ArrayList<>());
    }

    for(int i = 1;i<=m;i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
      list.get(b).add(a);
    }
    int ans = 0;

    for(int i = 1;i<=n;i++){
      Stack<Integer> stack = new Stack<>();
      int nowMon = 10000000;
      if(vis[i] == 0){
        vis[i] = 1;
        stack.push(i);
        while(!stack.isEmpty()){
          int now = stack.pop();
          vis[now] = 1;
          if(nowMon > mon[now]){
            nowMon = mon[now];
          }
          for(int j = 0;j<list.get(now).size();j++){
            if(vis[list.get(now).get(j)] == 0){
              stack.push(list.get(now).get(j));
            }
          }
        }
        ans += nowMon;
      }
    }

    if(k < ans){
      System.out.println("Oh no");
    }
    else{
      System.out.println(ans);
    }
  }
}
