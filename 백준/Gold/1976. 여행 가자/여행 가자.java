
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static int[] uni;
	
	static int find(int k) {
		if(uni[k] == k) {
			return k;
		}
		else {
			return uni[k] = find(uni[k]);
		}
		
	}
	
	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	
    	uni = new int[n+1];
    	
    	for(int i = 1;i<=n;i++) {
    		uni[i]= i;
    	}
    	
    	
    	int k;
    	for(int i = 1;i<=n;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1;j<=n;j++) {
    			k = Integer.parseInt(st.nextToken());
    			if(k == 1) {
    				int a = find(i);
    				int b = find(j);
    				if(a!=b) {
    					uni[b] = a;
    				}
    			}
    		}
    	}
    	
    	int[] aa = new int[m];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0;i<m;i++) {
    		aa[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	
    	for(int i = 1;i<m;i++) {
    		if(find(uni[aa[i]]) != find(uni[aa[i-1]])) {
    			System.out.println("NO");
    			return;
    		}
    		
    }
    	System.out.println("YES");

}
    
}
    


