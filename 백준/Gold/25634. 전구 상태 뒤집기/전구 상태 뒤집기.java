import java.util.*;
import java.io.*;
import java.math.*;



public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[n];
        int[] tf = new int[n];

        for(int i = 0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i<n;i++){
            tf[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[3][n];
        dp[0][0] = tf[0] * num[0];
        if(tf[0] == 0) dp[1][0] = num[0];

        for(int i = 1;i<n;i++){
            dp[0][i] = dp[0][i-1] + tf[i] * num[i];
        }

        for(int i = 1;i<n;i++){
            int k = Math.max(dp[0][i-1], dp[1][i-1]);
            if(tf[i] == 0){
                dp[1][i] = k + num[i];
            }
            else dp[1][i] = k;
        }

        for(int i = 1;i<n;i++){
            int k = Math.max(dp[2][i-1], dp[1][i-1]);
            dp[2][i] = k + tf[i] * num[i];
        }





       int ans =   Math.max(dp[1][n-1], dp[2][n-1]);

        System.out.println(ans);

    }
}