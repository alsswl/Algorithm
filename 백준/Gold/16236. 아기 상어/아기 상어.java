
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static int[][] arr;
	static int n;
	static int fish = 2;
	static int ans = 0;
	static int eat = 0;
	
	
	static class node{
		int x;
		int y;
		int sec;
		
		node(int x, int y, int sec) {
			this.x = x;
			this.y = y;
			this.sec = sec;
		}
	}
	
	static void check(int x, int y, int sec) {
		//System.out.println("k0");
		
		boolean[][] vis = new boolean[n][n];
		vis[x][y] = true;
		
		Queue<node> q = new LinkedList<>();
		q.offer(new node(x,y,sec));
		int nows = 0;
		
		int nowi = n+1;
		int nowj = n+1;
		
		
		while(q.isEmpty() != true) {
			//System.out.println(q.size());
			node now =q.poll();
			
			
			if(now.sec != nows) {
				if(nowi != n+1) {
					//System.out.println("50");
					ans += now.sec;
					
					arr[nowi][nowj] = 0;
					eat++;
					if(eat == fish) {
						fish++;
						eat = 0;
					}
					check(nowi, nowj, 0);
					return;
				}
				
				nows = now.sec;
			}
			
			
			if(now.x-1>=0) {
				if(arr[now.x-1][now.y] == 0 || arr[now.x-1][now.y] == fish )
						 {
					if(vis[now.x-1][now.y] == false) {
						vis[now.x-1][now.y] = true;
					    q.offer(new node(now.x-1,now.y,now.sec+1));
					}
					
				}
				else if(arr[now.x-1][now.y] < fish ){
					//System.out.println();
					if(nowi > now.x-1) {
							nowi = now.x-1;
							nowj = now.y;
					}
					else if(nowi == now.x-1) {
						if(nowj > now.y) {
							nowi = now.x-1;
							nowj = now.y;
						}
					}
					//System.out.println(nowi);
					
				}
				
			}
			
			if(now.y-1>=0) {
				if(arr[now.x][now.y-1] == 0 || arr[now.x][now.y-1] == fish) 
						 {
					if(vis[now.x][now.y-1] == false) {
						q.offer(new node(now.x,now.y-1,now.sec+1));
					vis[now.x][now.y-1] = true;
					}
					
				}
				else if(arr[now.x][now.y-1] < fish ){
					//System.out.println(9);
					if(nowi > now.x) {
						nowi = now.x;
						nowj = now.y-1;
				}
				else if(nowi == now.x) {
					if(nowj > now.y-1) {
						nowi = now.x;
						nowj = now.y-1;
					}
				}
					//System.out.println(nowi);
				}
				
			}
			
			
			
			
			if(now.y+1<n) {
				if(arr[now.x][now.y+1] == 0 || arr[now.x][now.y+1] == fish) {
					 if( vis[now.x][now.y+1] == false) {
						 q.offer(new node(now.x,now.y+1,now.sec+1));
					     vis[now.x][now.y+1] = true;
					 }
					
				}
				else if(arr[now.x][now.y+1] < fish ){
					//System.out.println(9);
					if(nowi > now.x) {
						
							nowi = now.x;
							nowj = now.y+1;
					
					
					}else if(nowi == now.x) {
						if(nowj > now.y+1) {
							nowi = now.x;
							nowj = now.y+1;
						}
					}
					//System.out.println(nowi);
				}
				
			}
			
			if(now.x+1<n) {
				if(arr[now.x+1][now.y] == 0 || arr[now.x+1][now.y] == fish )
						  {
					if(vis[now.x+1][now.y] == false) {
						q.offer(new node(now.x+1,now.y,now.sec+1));
					vis[now.x+1][now.y] = true;
					}
					
				}
				else if(arr[now.x+1][now.y] < fish ){
					//System.out.println(9);
					if(nowi > now.x+1) {
						
							nowi = now.x+1;
							nowj = now.y;
					
					
					}else if(nowi == now.x+1) {
						if(nowj > now.y) {
							nowi = now.x+1;
							nowj = now.y;
						}
					}
					//System.out.println(nowi);
				}
				
				
				
			}
			
			
			
		}
		
		if(nowi != n+1) {
			//System.out.println("50");
			ans += nows+1;
			
			arr[nowi][nowj] = 0;
			eat++;
			if(eat == fish) {
				fish++;
				eat = 0;
			}
			check(nowi, nowj, 0);
			return;
		}
		
		
	}
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	 n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	arr = new int[n][n];
    	
    	int x = 0;
    	int y = 0;
    	
    	
    	
    	for(int i = 0;i<n;i++) {
    		 st = new StringTokenizer(br.readLine());
    		for(int j = 0;j<n;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if(arr[i][j] == 9) {
    				x = i;
    				y = j;
    			}
    		}
    	}
    	arr[x][y] = 0;
    	check(x,y,0);
    	
    	System.out.println(ans);
    	
    	
}
    
}
    


