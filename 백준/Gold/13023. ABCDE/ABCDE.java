import java.util.*;
import java.io.*;
import java.math.*;



public class Main {
    static List<Integer>[] rela;
    static int n;
    static int m;
    static int[][] arr;

    static int[] narr = new int[5];
    static boolean[] vis;

    static void dfs(int l, int k){
        if(l == 4){
            System.out.println(1);
            System.exit(0);
        }
        for(int i = 0;i<rela[k].size();i++){
            if(vis[rela[k].get(i)] == false){
                vis[rela[k].get(i)] = true;
                narr[l+1] = rela[k].get(i);
                dfs(l+1,rela[k].get(i));
                vis[rela[k].get(i)] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rela = new ArrayList[n];

        for(int i = 0;i<n;i++){
            rela[i] = new ArrayList<>();
        }

        arr = new int[m][2];

        vis = new boolean[n];
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            rela[arr[i][0]].add(arr[i][1]);
            rela[arr[i][1]].add(arr[i][0]);
        }

        for(int i = 0;i<m;i++){
            vis = new boolean[n];
            vis[arr[i][0]] = true;
            vis[arr[i][1]] = true;
            narr[0] =arr[i][0];
            narr[1] = arr[i][1];
            dfs(1, arr[i][1]);

            vis = new boolean[n];
            vis[arr[i][0]] = true;
            vis[arr[i][1]] = true;
            narr[1] =arr[i][0];
            narr[0] = arr[i][1];
            dfs(1, arr[i][0]);
        }

        System.out.println(0);

    }
}