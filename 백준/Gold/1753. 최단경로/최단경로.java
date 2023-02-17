
import java.util.*;

import java.io.*;
import java.math.*;

public class Main{
	
	static class Node{
		int end;
		int len;
		
		Node(int end, int len){
			this.end = end;
			this.len = len;
		}
	}
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	
    	int sta = Integer.parseInt(br.readLine());
    	
    	List<Node>[] list = new ArrayList[n+1];
    	
    	for(int i = 1;i<=n;i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	for(int i = 0;i<m;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		
    		list[a].add(new Node(b,c));
    	}
    	
    	
    	
    
    	int[] ans = new int[n+1];
    	
    	
    	for(int i = 1;i<=n;i++) {
    		ans[i] = Integer.MAX_VALUE;
    	}
    	
    	ans[sta] = 0;
    	int now = sta;
    	int[] vis = new int[n+1];
    	vis[now] = 1;
    	
    	while(true) {
    		//System.out.println(list[now].size());
    		for(int i = 0;i<list[now].size();i++) {
    			ans[list[now].get(i).end] = Math.min(ans[list[now].get(i).end],ans[now]+list[now].get(i).len);
    			
    		}
    		
    		now = -1;
    		
    		int min = Integer.MAX_VALUE;
    		
    		for(int i = 1;i<=n;i++) {
    			if(vis[i] == 0) {
    				if(min>ans[i]) {
    					min = ans[i];
    					now = i;
    				}
    			}
    		}
    		
    		if(now == -1) break;
    		vis[now] = 1;
    	}
    	
    	for(int i = 1;i<=n;i++) {
    		if(ans[i] == Integer.MAX_VALUE) {
    			System.out.println("INF");
    		}
    		else
    		System.out.println(ans[i]);
    	}
    	
    }
   

}
    


