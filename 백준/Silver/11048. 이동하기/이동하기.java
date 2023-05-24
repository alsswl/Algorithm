import java.util.*;
import java.io.*;
import java.math.*;


class xy{
    int x;
    int y;

    int cnt;

    xy(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n,m;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];

        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];


        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                int k = 0;

                if(i-1 >= 1){
                   k = Math.max(k,arr[i-1][j]);
                }
                if(j-1 >= 1){
                    k = Math.max(k,arr[i][j-1]);
                }
                if(i-1 >= 1 && j-1 >=1){
                    k = Math.max(k,arr[i-1][j-1]);
                }

                arr[i][j] = arr[i][j] + k;
            }
        }

        System.out.println(arr[n][m]);




    }
}