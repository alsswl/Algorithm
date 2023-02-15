
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static class xy {
		int x;
		int y;
		
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int l = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	
    	int[][] arr = new int[n][n];
    	
    	
    	for(int i = 0;i<n;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0;j<n;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int res = 0;
    	
    	while(true) {
    		//System.out.println(res);
    		int ok = 0;
    		int nowV = 1;
    		res ++;
    		
    		Stack<xy> stack = new Stack<>();
    		Stack<xy> store = new Stack<>();
    		
    		int[][] vis = new int[n][n];
    		
    		for(int i = 0;i<n;i++) {
    			for(int j = 0;j<n;j++) {
    				
    				if(vis[i][j] == 0) {
    					int all = 0;
    					int na  = 0;
    					
    					vis[i][j] = nowV;
    					stack.push(new xy(i,j));
    					store.push(new xy(i,j));
    					all += arr[i][j];
    					na++;
    					
    					while(stack.isEmpty() != true) {
    						
    						xy now = stack.pop();
    						
    						if(now.x+1<n && vis[now.x+1][now.y] == 0 ) {
    							
    							if(Math.abs(arr[now.x][now.y]-arr[now.x+1][now.y])<=r &&
    									Math.abs(arr[now.x][now.y]-arr[now.x+1][now.y])>=l) {
    								ok = 1;
    								all += arr[now.x+1][now.y];
    								na++;
    								vis[now.x+1][now.y] = nowV;
    								stack.push(new xy(now.x+1,now.y));
    								store.push(new xy(now.x+1,now.y));
    							}
    						}
    						
    						if(now.y+1<n && vis[now.x][now.y+1] == 0 ) {
    							
    							if(Math.abs(arr[now.x][now.y]-arr[now.x][now.y+1])<=r &&
    									Math.abs(arr[now.x][now.y]-arr[now.x][now.y+1])>=l) {
    								ok = 1;
    								vis[now.x][now.y+1] = nowV;
    								all += arr[now.x][now.y+1];
    								na++;
    								stack.push(new xy(now.x,now.y+1));
    								store.push(new xy(now.x,now.y+1));
    							}
    						}
    						
    						if(now.x-1>=0 && vis[now.x-1][now.y] == 0 ) {
    							
    							if(Math.abs(arr[now.x][now.y]-arr[now.x-1][now.y])<=r &&
    									Math.abs(arr[now.x][now.y]-arr[now.x-1][now.y])>=l) {
    								ok = 1;
    								vis[now.x-1][now.y] = nowV;
    								all += arr[now.x-1][now.y];
    								na++;
    								stack.push(new xy(now.x-1,now.y));
    								store.push(new xy(now.x-1,now.y));
    							}
    						}
    						
    						if(now.y-1>=0 && vis[now.x][now.y-1] == 0 ) {
    							
    							if(Math.abs(arr[now.x][now.y]-arr[now.x][now.y-1])<=r &&
    									Math.abs(arr[now.x][now.y]-arr[now.x][now.y-1])>=l) {
    								ok = 1;
    								vis[now.x][now.y-1] = nowV;
    								all += arr[now.x][now.y-1];
    								na++;
    								stack.push(new xy(now.x,now.y-1));
    								store.push(new xy(now.x,now.y-1));
    							}
    						}
    					}
    					
    					//System.out.println(all);
    					//System.out.println(na);
    					
    					while(store.isEmpty() != true) {
    						xy s = store.pop();
    						arr[s.x][s.y] = all/na;
    					}
    					
    					
    					nowV++;
    				}
    			}
    			
    		}
    		/*
    		System.out.println();
    		for(int i = 0;i<n;i++) {System.out.println();
    		for(int j = 0;j<n;j++) {
    			System.out.printf("%d ",arr[i][j]);
    		}
    	}*/
    		if(ok == 0) break;
    	}
    	
    	System.out.println(res-1);
    	
    	
    }
    
}

