
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static class node{
		int a;
		int b;
		
		node(int a, int b){
			this.a = a;
			this.b = b;
		}
	}

	static class node2{
		int k;
		int l;
		
		node2(int k, int l){
			this.k = k;
			this.l = l;
		}
	}
	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	List<node>[] list = new ArrayList[n+1];
    	
    	for(int i = 1;i<=n;i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	for(int i = 0;i<n-1;i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int a =  Integer.parseInt(st.nextToken());
    		int b =  Integer.parseInt(st.nextToken());
    		int c =  Integer.parseInt(st.nextToken());
    		
    		list[a].add(new node(b,c));
    		list[b].add(new node(a,c));
    		
    	}
    	
    	for(int i = 0;i<m;i++) {
             st = new StringTokenizer(br.readLine());
    		
    		int k =  Integer.parseInt(st.nextToken());
    		int l =  Integer.parseInt(st.nextToken());
    		//System.out.println(k);
    		//System.out.println(l);
    		
    		Stack<node2> stack = new Stack<>();
    		
    		stack.push(new node2(k,0));
    		int[] vis = new int[n+1];
    		vis[k] = 1;
    		
    		while(stack.isEmpty() != true) {
    			
    			node2 now = stack.pop();
    			//System.out.println(now.k);
    			if(now.k == l) {
    				System.out.println(now.l);
    				break;
    			}
    			
    			for(int j = 0;j<list[now.k].size();j++) {
    				if(vis[list[now.k].get(j).a] == 0 ) {
    					vis[list[now.k].get(j).a] = 1;
    					stack.push(new node2(list[now.k].get(j).a,now.l+list[now.k].get(j).b));
    				}
    			}
    		}
    	}
    	
}
    
}
    


