
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int k = Integer.parseInt(st.nextToken());
    	int n = Integer.parseInt(st.nextToken());
    	
    	int arr[] = new int[k];
    	
    	long ans = 0;
    	
    	for(int i = 0;i<k;i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    		ans = Math.max(ans,arr[i]);
    	}
    	
    	if(ans == 1) {
    		System.out.println(1);
    		return;
    	}
    	
    	
    	long pl = 1;
    	long pr = ans;
    	long mid = ans/2;
    	long midBef = ans/2;
        
    	do {
    		//System.out.println(mid);
    	    long bra = 0;
    		long bra2 = 0;
    		for(int i = 0;i<k;i++) {
    			bra += arr[i]/mid;
    		}
    		
    		for(int i = 0;i<k;i++) {
    			bra2 += arr[i]/(mid+1);
    		}
    		
    		if(bra2<n && bra>=n) break;
    		
    		else if(bra>=n) {
    			pl = mid+1;
    			mid = (pl+pr)/2;
    		}
    		else { 
    			pr = mid-1;
    			mid = (pl+pr)/2;
    		}
    		
    	}while(pr>=pl);
    	
    	
    	System.out.println(mid);
    	
    	
    	}
    	
        
    }

