
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[][] arr = new int[n][2];
    	
    	for(int i = 0;i<n;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0;j<2;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	Arrays.sort(arr,new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[]o2) {
    			if(o1[0] == o2[0]) {
    				return o1[1] - o2[1];
    			}
    			else {
    				return o1[0]- o2[0];
    			}
    		}
    	});
    	
    	long sta = arr[0][0];
    	long end = arr[0][1];
    	long ans = 0;
    	
    	/*for(int i =0;i<n;i++) {
    		 System.out.printf("%d %d\n",arr[i][0],arr[i][1]);
    	}*/
    	
    	for(int i = 0;i<n;i++) {
    	    if(end<arr[i][0]) {
    	    	ans += end-sta;
    	    	sta = arr[i][0];
    	    	end = arr[i][1];
    	    }
    	    else {
    	    	end = Math.max(end,arr[i][1]);
    	    }
    	  //  System.out.println(ans);
    	}
    	
    	ans += end-sta;
    	
    	System.out.println(ans);
    	
    	
}
    
}
    


