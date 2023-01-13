
import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[6][2];
        
        int maxw = 0;
        int maxh = 0;
        
        int[] way = new int[2];
        int wayw = 0;
        int wayh = 0;
        
        for(int i = 0;i<6;i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        	
        	if(arr[i][0] == 1 || arr[i][0] == 2) {
        	    if(maxw <= arr[i][1]) {
        	    	maxw = arr[i][1];
        	    	wayw = arr[i][0];
        	    	
        	    }
        	}
        	
        	
        	
        	if(arr[i][0] == 3 || arr[i][0] == 4) {
        	    if(maxh <= arr[i][1]) {
        	    	maxh = arr[i][1];
        	    	wayh = arr[i][0];
        	    }
        	}
        	
        	
        }
        
        int minw = 500;
        int minh = 500;
        
        for(int i = 0;i<6;i++) {
        	if((arr[i][1] == maxw||arr[i][1] == maxh)){
        		
        		if(arr[(i+1)%6][1] == maxh||arr[(i+1)%6][1] == maxw) {
        		    minw = arr[(i+3)%6][1];
        		    minh = arr[(i+4)%6][1];
        	}
        		
        	}
        		
        	}
        
        int res = (maxw*maxh - minw*minh)*n;
        
       
        System.out.println(res);
       
        	
    }
}
