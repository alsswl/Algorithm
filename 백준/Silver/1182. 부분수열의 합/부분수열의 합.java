import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

    static int[] vis;
    static int[] arr;
    static int n;
    static int k;

    static int ans;


    static void ok(){
        int cnt = 0;

        for(int i = 0;i<n;i++){
            if(vis[i] == 1){
                cnt += arr[i];
            }
        }

        if(cnt == k) ans++;
    }

    static void check(int p, int i){
        if(i == p){
            ok();
        }
        else{
            for(int z = i;z<n;z++){
                if(vis[z] == 0){
                    vis[z] = 1;
                    check(p,z+1);
                    vis[z] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ans = 0;

        vis = new int[n];
        arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1;i<=n;i++){
            check(i,0);
        }

        System.out.println(ans);




    }
}