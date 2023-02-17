
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
    	
    	StringBuilder sb = new StringBuilder();
    	
    	int[] bef = new int[1000000];
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int max  = Math.abs(k-n);
    	int[] vis = new int[1000000];
    	if(n>=k) {
    	    System.out.println(n-k);
    	    for(int i = n;i>=k;i--) {
    	    	sb.append(i).append(" ");
    	    }
    	    System.out.println(sb);
    	    return;
    	}
    	
    	Queue<in> q = new LinkedList<>();
    	
    	int[] arr = new int[100001];
    	arr[0] = n;
    	
    	q.offer(new in(n,0,-1));
    	vis[n]= 1;
    	
    	int res = Integer.MAX_VALUE;
    	int res2 = 0;
    	
    	while(q.isEmpty() != true) {
    		
    		in x = q.poll();
    		
    		//System.out.println(x.pl);
    		
    	
    		
    		if(x.pl <k) {
    			vis[x.pl] = 1;
    		    if(x.bef != 0 && Math.abs(x.pl+1-k) <=max && vis[x.pl+1] == 0) {
    		    	vis[x.pl+1] = 1;
    		    	bef[x.pl+1] = x.pl;
    		    	q.offer(new in(x.pl+1,x.sec+1,1));
    		    	if(x.pl+1 == k) {
    		    		
    		    		res = x.sec+1;
    		    		System.out.println(res);
    		    	    
    		    	    break;
    	    		}
    		    }
    		    if(x.bef != 1 && x.pl-1>=0&& vis[x.pl-1] == 0) {
    		    	bef[x.pl-1] = x.pl;
    		    	vis[x.pl-1] = 1;
    		    	q.offer(new in(x.pl-1,x.sec+1,0));
    		    	if(x.pl-1 == k) {  
    		    		res = x.sec+1;
    		    		System.out.println(res);
    		    	   
    		    	    break;
    	    		}
    		    }
    			
    		    if(Math.abs(x.pl*2-k) <=max&& vis[x.pl*2] == 0) {
    		    	vis[x.pl*2] = 1;
    		    	bef[x.pl*2] = x.pl;
    		    	q.offer(new in(x.pl*2,x.sec+1,-1));
    		    	if(x.pl*2 == k) {  
    		    		res = x.sec+1;
    		    		System.out.println(res);
    		    	    
    		    	    break;
    	    		}
    		    }
    			
    		}
    		
    		else {
    			if(x.pl-1>=0 && x.bef != 1&& vis[x.pl-1] == 0) {
    				bef[x.pl-1] = x.pl;
    				vis[x.pl-1] = 1;
    				q.offer(new in(x.pl-1,x.sec+1,0));
    				if(x.pl-1 == k) {  
    					res = x.sec+1;
    		    		System.out.println(res);
    		    	    
    		    	    break;
    	    		}
    			}
    		}
    		
    			
    			
    	}
    	int nn = k;
    	
    	Stack<Integer> stack = new Stack<>();
    	stack.push(k);
    	
    	
    	while(true) {
    		stack.push(bef[nn]);
    		nn = bef[nn];
    		if(nn == n) break;
    	}
    	
    	while(stack.isEmpty() != true) {
    		sb.append(stack.pop()).append(" ");
    	}
    	
  
    	System.out.println(sb);
    
    
    }
   

}
    


