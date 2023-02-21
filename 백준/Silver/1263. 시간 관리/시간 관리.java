
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	
    	int[][] arr = new int[n][2];
    	int max = 0;
    	
    	for(int i = 0;i<n;i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		arr[i][0] = Integer.parseInt(st.nextToken());
    		arr[i][1] = Integer.parseInt(st.nextToken());
    		
    		max = Math.max(max, arr[i][1]);
    	}
    	
    	Arrays.sort(arr, new Comparator<int[]>() {
    		@Override
    		public int compare(int[]o1, int[]o2) {
    			if(o1[1] == o2[1]) {
    				return o1[0] - o2[1];
    			}
    			else {
    				return o2[1] - o1[1];
    			}
    		}
    	});
    	
    	int nH = max;
    	
    	int[] time = new int[max+1];
    	
    	for(int i = 0;i<n;i++) {
    		nH = Math.min(nH, arr[i][1]);
    		nH = nH-arr[i][0];
    	}
    	
       if(nH <0) {
    	   System.out.println(-1);
       }
       else {
    	   System.out.println(nH);
       }
}
    
}
    


