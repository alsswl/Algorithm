import java.util.*;
import java.io.*;
import java.math.*;



public class Main {
    static class two{
        int a;
        int b;

        two(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//시간

        int m = Integer.parseInt(st.nextToken());//최소움직임

        int[] arr = new int[n];

        two[][] dp = new two[m+1][n];

        int cnt = 0;
        int max = 0;

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] == 1) cnt++;

            dp[0][i] = new two(cnt,1);
            max = Math.max(max, cnt);
        }


        //i는 옮긴 횟수
        for(int i = 1;i<=m;i++){
            for(int j = 0;j<n;j++){
                if(j == 0){
                    if(dp[i-1][j].b != arr[j]){
                        dp[i][j] = new two(1,arr[j]);
                    }
                    else{
                        dp[i][j] = new two(0,arr[j]);
                    }
                }
                else{
                    int k = 0;
                    int l = 0;
                    if(dp[i][j-1].b == arr[j]) k = dp[i][j-1].a+1;
                    else k = dp[i][j-1].a;

                    if(dp[i-1][j-1].b != arr[j]) l = dp[i-1][j-1].a+1;
                    else l = dp[i-1][j-1].a;

                    if(k>=l){
                        dp[i][j]  = new two(k,dp[i][j-1].b);
                    }
                    else{
                        dp[i][j] = new two(l,arr[j]);
                    }
                }
                max = Math.max(max, dp[i][j].a);
            }
        }

       /* for(int i = 0;i<=m;i++){
            for(int j = 0;j<n;j++){
                System.out.printf("(%d %d)",dp[i][j].a,dp[i][j].b);
            }
            System.out.println();
        }*/

        System.out.println(max);


    }
}