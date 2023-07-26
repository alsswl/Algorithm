import java.io.*;
import java.util.*;
import java.math.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[m];

            for(int j = 0;j<m;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int mon = Integer.parseInt(br.readLine());

            int[] dp = new int[mon +1];

            for(int j = 0;j<m;j++){
                for(int k = arr[j];k<=mon;k++){
                    if(k-arr[j] > 0){
                        dp[k] += dp[k-arr[j]];
                    }
                    else if(k - arr[j] == 0){
                        dp[k]++;
                    }
                }
            }

            System.out.println(dp[mon]);


        }


    }
}