import java.util.*;
import java.io.*;
import java.math.*;




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] day = new int[n+1];
        int[] mon = new int[n+1];

        int[] dp = new int[n+2];

        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            int b = Integer.parseInt(st.nextToken());

            day[i] = a;
            mon[i] = b;
        }

        int ans = 0;

        int max = 0;

        for(int i = 1;i<=n;i++){
           max = Math.max(dp[i], max);

           if(i + day[i] < n+2) dp[i + day[i]] = Math.max(dp[i+day[i]], max + mon[i]);

           ans = Math.max(dp[i], ans);
        }


        ans = Math.max(ans, dp[n+1]);

        System.out.println(ans);



    }
}