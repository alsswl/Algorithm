
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i = 0;i<n;i++) {
    		int k = Integer.parseInt(br.readLine());
    		
    		
    		
    		int[][] arr = new int[2][k];
    		int[][] dp = new int[2][k];
    		
    		for(int j =0 ;j<2;j++) {
    			st = new StringTokenizer(br.readLine());
    			for(int z = 0;z<k;z++) {
    				arr[j][z] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		dp[0][0] = arr[0][0];
    		dp[1][0] = arr[1][0];
    		int max = Math.max(dp[0][0],dp[1][0]);
    		
    		for(int j = 1;j<k;j++) {
    			int nowMax =0 ;
    			if(j-2>=0) {
    				nowMax = Math.max(dp[0][j-2],dp[1][j-2]);
    				dp[0][j] = Math.max(nowMax,dp[1][j-1])+arr[0][j];
    			    dp[1][j] = Math.max(nowMax,dp[0][j-1])+arr[1][j];
    			}
    			else {
    				dp[0][j] = dp[1][j-1]+arr[0][j];
    			    dp[1][j] = dp[0][j-1]+arr[1][j];
    			}
    			
    		
    			max = Math.max(max,Math.max(dp[0][j],dp[1][j]));
    			
    		}
    		System.out.println(max);
    		
    		
    	}
    	
    	
    	}
    	
        
    }

