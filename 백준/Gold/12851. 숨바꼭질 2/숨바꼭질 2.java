
import java.util.*;

import java.io.*;
import java.math.*;

public class Main{
	
	static class in{
		int pl;
		int sec;
		int bef;
		
		//def가 0이면 마이너스 1이면 플러스-1이면 아무것도
		in(int pl, int sec,int bef){
			this.pl = pl;
			this.sec = sec;
			this.bef = bef;
		}
	}
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int max  = Math.abs(k-n);
    	int[] vis = new int[1000000];
    	if(n>=k) {
    	    System.out.println(n-k);
    	    System.out.println(1);
    	    return;
    	}
    	
    	Queue<in> q = new LinkedList<>();
    	
    	
    	q.offer(new in(n,0,-1));
    	vis[n]= 1;
    	q.offer(new in(-1,-1,-1));
    	int res = Integer.MAX_VALUE;
    	int res2 = 0;
    	
    	while(q.isEmpty() != true) {
    		
    		in x = q.poll();
    		
    		
    		if(x.pl == -1) {
    			if(res != Integer.MAX_VALUE) break;
    			else {
    				q.offer(new in(-1,-1,-1));
    				continue;
    			}
    		}
    		
    		
    		else if(x.pl <k) {
    			vis[x.pl] = 1;
    		    if(x.bef != 0 && Math.abs(x.pl+1-k) <=max && vis[x.pl+1] == 0) {
    		    	
    		    	
    		    	q.offer(new in(x.pl+1,x.sec+1,1));
    		    	if(x.pl+1 == k) {
    		    		if(res>x.sec+1) {
     		    			res = x.sec+1;
    		    			res2 = 1;
    		    		}
    		    		else if(res == x.sec+1) res2++;
    	    		}
    		    }
    		    if(x.bef != 1 && x.pl-1>=0&& vis[x.pl-1] == 0) {
    		    	
    		    	
    		    	q.offer(new in(x.pl-1,x.sec+1,0));
    		    	if(x.pl-1 == k) {  
    		    		if(res>x.sec+1) {
     		    			res = x.sec+1;
    		    			res2 = 1;
    		    		}
    		    		else if(res == x.sec+1) res2++;
    	    		}
    		    }
    			
    		    if(Math.abs(x.pl*2-k) <=max&& vis[x.pl*2] == 0) {
    		    	
    		    	
    		    	q.offer(new in(x.pl*2,x.sec+1,-1));
    		    	if(x.pl*2 == k) {  
    		    		if(res>x.sec+1) {
     		    			res = x.sec+1;
    		    			res2 = 1;
    		    		}
    		    		else if(res == x.sec+1) res2++;
    	    		}
    		    }
    			
    		}
    		
    		else {
    			if(x.pl-1>=0 && x.bef != 1&& vis[x.pl-1] == 0) {
    				
    				
    				q.offer(new in(x.pl-1,x.sec+1,0));
    				if(x.pl-1 == k) {  
    					if(res>x.sec+1) {
     		    			res = x.sec+1;
    		    			res2 = 1;
    		    		}
    		    		else if(res == x.sec+1) res2++;
    	    		}
    			}
    		}
    		
    			
    			
    	}
    	
    	
    System.out.println(res);
    System.out.println(res2);
    
    }
   

}
    


