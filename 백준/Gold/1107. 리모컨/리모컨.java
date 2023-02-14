
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static int[] arr;
	static int length;
	static int m;
	
	static int checkOk(int num) {//0이면 가능 1이면 불가
		if(num == 0) {
			for(int i = 0;i<m;i++) {
				if(arr[i] == 0) return 1;
			}
			return 0;
		}
		
		int k = 0;
		for(int i = 0;i<8;i++) {
			
			if((int)(num/(int)Math.pow(10,i)) == 0) {
				k = i;
				break;
			}
		}
		
		
		for(int i = 1;i<=k;i++) {
			int ok = 0;
			for(int j = 0;j<m;j++) {
				
				if((num%(int)Math.pow(10,i))/(int)Math.pow(10,i-1) == arr[j]) {
					ok = 1;
					return 1;
				}
			}
		}
		return 0;
	}
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
         m = Integer.parseInt(br.readLine());
         
         if(n == 0&& m == 0) 
         {
        	 System.out.println(1);
        	 return;
         }
        
         StringTokenizer st = null;
    	
         if(m != 0) {
    		 st = new StringTokenizer(br.readLine());
    	}
    	
    	arr = new int[m];
    	

    	for(int i = 0;i<m;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int min = -1;
    	int max = 0;
    	
    	for(int i = n;i>=0;i--) {
    		if(checkOk(i) == 0) {
    			//System.out.println(i);
    			min = i;
    			break;
    		}
    	}
    	
    	//System.out.println(min);
    	int zz = 0;
    	
    	for(int i = 0;i<m;i++) {
    		if(arr[i] == 0) zz = 1;
    	}
    	
    	if((zz != 0 || m != 9) && m!= 10) {
    		//System.out.println(checkOk(1));
    		for(int i = n;i<=50000002;i++) {
    			//System.out.println(checkOk(0));
    		if(checkOk(i) == 0) {
    			max = i;
    			break;
    		}
    	}
    	}
    	
    	
    	
    	
    	
    	
    	
    	int res = Integer.MAX_VALUE;
    	
    	if(zz == 0 && m == 9) {
    		res = 1+ n;
    	}
    	
    	int k = 0;
    	if(max != 0) {
    		 k = 0;
        	for(int i = 0;i<8;i++) {
    			if(max/(int)Math.pow(10,i) == 0) {
    				k = i;
    				break;
    			}
    		}
        	
        	res = k + (max-n);
    	}
    	
    	//
    	k = 0;
    	
   
    	
    	for(int i = 0;i<8;i++) {
			if(min/(int)Math.pow(10,i) == 0) {
				k = i;
				break;
			}
		}
    	
    	
    	if(min == 0) k = 1;
    	
    	//System.out.println(res);
    	
    	
    	
    	if(min != -1)res = Math.min(res,k+(n-min));
    	res = Math.min(res, Math.abs(n-100));
    	
    	System.out.println(res);
    	
    	
    }
    
}

