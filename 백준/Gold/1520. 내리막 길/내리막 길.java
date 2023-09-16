import java.util.*;
import java.io.*;
import java.math.*;
public class Main {

    static class pair{
        int a;
        int b;

        pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    static int n;
    static int m;
    static int[][] arr;

    static int ans;

    static int[] dx;

    static int[] dy;

    static int[][] vis;

    static int dfs(pair now){

        


        if(now.a == n-1 && now.b == m-1){
            return 1;
        }
        
        vis[now.a][now.b] = 0;

        for(int i = 0;i<4;i++){
            if(now.a + dx[i] >= 0 && now.a + dx[i] < n  && now.b + dy[i] >= 0 &&
                    now.b + dy[i] <m ){
                if(arr[now.a][now.b] > arr[now.a + dx[i]][now.b + dy[i]]){

                    if(vis[now.a + dx[i]][now.b + dy[i]] == -1) {
                        int k = dfs(new pair(now.a + dx[i], now.b + dy[i]));
                        vis[now.a][now.b] += k;
                    }

                    else{
                        vis[now.a][now.b] += vis[now.a + dx[i]][now.b + dy[i]];
                    }

                }
            }
        }

        return vis[now.a][now.b];
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<pair> stack = new Stack<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        vis = new int[n][m];



        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                vis[i][j] = -1;
            }
        }

        stack.push(new pair(0,0));

        dx = new int[]{0, 0, 1, -1};
        dy = new int[]{1, -1, 0, 0};
        ans = 0;


        System.out.println(dfs(new pair(0,0)));

    }
}
