
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static int[] arr ;
	static int[][] add;
	
	
	static int plus(int a, int b) {
		
		int res = 0;
		
		for(int i = a;i<=b;i++) {
		    res += arr[i];
		}
		
		return res;
	}
	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        
        for(int i = 1;i<=n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        
        add = new int[m+1][2];
        
        for(int i = 0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	add[i][0] = Integer.parseInt(st.nextToken());
        	add[i][1] = Integer.parseInt(st.nextToken());
        	
        }
        
        for(int i = 0;i<m;i++) {
        	System.out.println(plus(add[i][0] , add[i][1]));
        }
        
        
      
        	
    }
}
