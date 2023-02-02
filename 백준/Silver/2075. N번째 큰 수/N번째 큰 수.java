
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	

	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	
    	int[][] arr = new int[n][n];
    
    	
    	for(int i = 0;i<n;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0;j<n;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
        
    	int[] mainArr= new int[n];
    	for(int i =0 ;i<n;i++) {
    		mainArr[i] = arr[n-1][i];
    	}
        
    	int max = 0;
    	
    	for(int i = 0;i<n;i++) {
    		max = Integer.MIN_VALUE;
    		for(int j = 0;j<n;j++) {
    			max = Math.max(max,mainArr[j]);
    		}
    		
    		for(int j = 0;j<n;j++) {
    			if(mainArr[j] == max) {
    			    for(int k = 0;k<n;k++) {
    			    	if(mainArr[j] == arr[k][j]) {
    			    		if(k-1>=0) {
    			    			mainArr[j] = arr[k-1][j];
    			    		}
    			    		else {
    			    			mainArr[j] = Integer.MIN_VALUE;
    			    		}
    			    	}
    			    }
    			}
    		}
    	}
    	
    	System.out.println(max);
        
    }
}
