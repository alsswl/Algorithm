
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

  static int r;
  static int[] vis;
  static int[] end;
  static int[] arr;
  static int ans = 0;

  static void dfs(int cur){
    vis[cur] = 1;
    if(vis[arr[cur]] == 0){
      dfs(arr[cur]);
    }
    int next= arr[cur];

    if(end[next] == 0 && vis[next] == 1){
      int now = arr[next];
      int per = 1;
      while(next != now){
        per++;
        now = arr[now];
      }
      ans += per;
    }
    end[cur] = 1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int k = Integer.parseInt(br.readLine());

    for (int q = 0; q < k; q++) {
      ans = 0;

      r = Integer.parseInt(br.readLine());
      arr = new int[r + 1];
      vis = new int[r + 1];
      end = new int[r + 1];
      st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= r; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      for(int i =1;i<=r;i++){
        if(end[i] == 0){
          dfs(i);
        }
      }
      System.out.println(r - ans);

    }
  }
}
