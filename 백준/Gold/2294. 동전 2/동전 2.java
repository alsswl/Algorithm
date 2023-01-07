
import java.util.*;
import java.io.*;


public class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 int k = Integer.parseInt(st.nextToken());
		 
		 int[] coin1 = new int[n];
		 int[] coin = new int[n];
		 
		 
		 for(int i =0;i<n;i++) {
			 coin1[i] = Integer.parseInt(br.readLine());
		 }
		 Arrays.sort(coin1);
		 int[][] dp = new int[n][k+1];
		 coin[0] = coin1[0];
		 int coinNum = 0;
		 
		 for(int i = 1;i<n;i++) {
			 if(coin1[i-1] != coin1[i]) {
				 coinNum++;
				 coin[coinNum] = coin1[i];
			 }
		 }
		 
		 for(int i = 1;i<=k;i++) {
			 if(i%coin[0] == 0) dp[0][i] = i/coin[0];
			 else dp[0][i] = 100001; 
			
		 }
		 
		 
		 
		 for(int i = 1;i<=coinNum;i++) {
			 for(int j = 1;j<=k;j++) {
				 if(j<coin[i]) {
					 dp[i][j] = dp[i-1][j];
				 }
				 else {
					  if(dp[i][j%coin[i]] != -1) {
						  int min = dp[i-1][j];
						  for(int z = 1;z<=j/coin[i];z++) {
							   min = Math.min(min,dp[i][j-coin[i]*z]+z);
						  }
						  dp[i][j] = min;
				        }
				      else dp[i][j] = dp[i-1][j];
				 }
				
			 }
		 }
		 
		/* for(int i = 0;i<=coinNum;i++) {
			 for(int j = 0;j<=k;j++) {
				 System.out.printf("%d ", dp[i][j]);
			 }
			 System.out.println();
		 }*/
		 
		
		 if(dp[n-1][k] == 100001) System.out.println(-1);
		 else System.out.println(dp[coinNum][k]);
		
	 }

}
