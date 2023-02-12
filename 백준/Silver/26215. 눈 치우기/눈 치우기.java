
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static int n;
	static int[] arr;
	
	static int check() {
		int res = 0;
		for(int i = n-1;i>=0;i--) {
			if(arr[i] != 0) {
				res = 1;
				break;
			}
		}
		//0이면 다 0이고 1이면 아직 아니다
		return res;
	}
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	 arr = new int[n];
    	 int res =0 ;
    	
    	for(int i = 0;i<n;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	if(n == 1) {
    		if(arr[0] >1440)  {
				System.out.println(-1);
				return;
			}
    		else {
    			System.out.println(arr[0]);
				return;
    		}
    	}
    	
    	
    	while(check() == 1){
    		
    		Arrays.sort(arr);
    		
    		if(arr[n-2] == 0) {
    			res += arr[n-1];
    			break;
    		}
    		else {
    			res += arr[n-2];
    			arr[n-1]-= arr[n-2];
    			arr[n-2] = 0;
    		}
    		
    		
    		
    	}
    	if(res > 1440) {
    			System.out.println(-1);
    			return;
    		}
    	System.out.println(res);
    	
    	
    	}
    	
        
    }

