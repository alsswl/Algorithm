import java.util.*;
import java.io.*;
import java.math.*;



public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][n];

        dp[0][0] = 1;
        dp[1][0] = arr[0];

        int ans = 1;

        for(int i = 1;i<n;i++){
            int ze = 0;
            int w = 0;

            for(int j = 0;j<i;j++){
                if(dp[1][j] >= arr[i]) {
                    if (ze <= dp[0][j]) {
                        ze = dp[0][j];
                        if (w < dp[1][j]) {
                            w = dp[1][j];
                        }
                    }
                }
            }

            dp[0][i] = ze+1;
            dp[1][i] = w + arr[i];

            ans = Math.max(dp[0][i], ans);

        }

        System.out.println(ans);


    }
}