
import java.util.*;
import java.io.*;
import java.math.BigInteger;


 class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 int n = Integer.parseInt(br.readLine());
		 
		 int[][] line = new int[n][2];
		 
		 for(int i =0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 line[i][0] = Integer.parseInt(st.nextToken());
			 line[i][1] = Integer.parseInt(st.nextToken());
		 }
		 
		
		 
		 Arrays.sort(line,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1]-o2[1];
				}
				else {
					return o1[0]-o2[0];
				}
			}
			 
		 });
	
		 
		 int max = 0;
		 int maxNow = 0;
		 
		 int[] dp = new int[n];
		 
		 dp[n-1] = 1;
		 
		 for(int i = n-2;i>=0;i--) {
			 dp[i] = 1;
			 for(int j = i+1;j<n;j++) {
				 if(line[i][1]<=line[j][1]) {
					
					 dp[i] = Math.max(dp[i],dp[j]+1);
				 }
			 }
			 //System.out.println(dp[i]);
			 max = Math.max(max, dp[i]);
		 }
		 
		 System.out.println(n-max);
		 
		 }
	  
	 }


