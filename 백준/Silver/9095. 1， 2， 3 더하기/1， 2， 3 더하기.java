
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int ca = Integer.parseInt(br.readLine());
        
        
        
        for(int i = 0;i<ca;i++) {
        	
        	int n = Integer.parseInt(br.readLine());
        	int[] dp = new int[n+4];
        	
        	dp[1] = 1;
        	dp[2] = 2;
        	dp[3] = 4;
        	
        	if(n<=3) {
        		System.out.println(dp[n]);
        	}
        	
        	else {
        		for(int j = 4;j<=n;j++) {
        			dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
        		}
        		System.out.println(dp[n]);
        	}
        	
        }
        
         
        	
        	
    }
}
