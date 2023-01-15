
import java.util.*;
import java.io.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for(int i = 0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int b = Integer.parseInt(br.readLine());
        
        int cnt =0 ;
        
        
        for(int i = 0;i<n-1;i++) {
        	if(arr[i]>=b) break;
        	for(int j = i+1;j<n;j++) {
        		if(arr[i] + arr[j] == b) {
        			cnt++;
        		    break;
        		}
        		
        	}
        }
        
        System.out.println(cnt);
        
         
        	
        	
    }
}
