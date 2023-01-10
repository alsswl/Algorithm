
import java.util.*;
import java.io.*;


 class Main {
	static class xy{
		int x;
		int y;
		
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 
		 while(true) {
			 st = new StringTokenizer(br.readLine());
			  int w = Integer.parseInt(st.nextToken());
		      int h = Integer.parseInt(st.nextToken());
		      if(w == 0&& h == 0) break;
		     
		      Queue<xy> queue = new LinkedList<>();
		      
		      int[][] arr = new int[h][w];
		      for(int i = 0;i<h;i++) {
		    	  st = new StringTokenizer(br.readLine());
		    	  for(int j = 0;j<w;j++) {
		    		  arr[i][j] = Integer.parseInt(st.nextToken());
		    	  }
		      }
		      
		      
		      boolean[][] visit = new boolean[h][w];
		      int island = 0;
		      
		      for(int i =0 ;i<h;i++) {
		    	  for(int j = 0;j<w;j++) {
		    		  if(arr[i][j] == 1 && visit[i][j] == false) {
		    			 queue.offer(new xy(i,j));
		    			 island++;
		    			 while(queue.isEmpty()!= true) {
		    				 xy now = queue.poll();
		    				 if(now.x-1>=0&&arr[now.x-1][now.y]==1&&visit[now.x-1][now.y] == false) { 
		    					 queue.offer(new xy(now.x-1,now.y));
		    					 visit[now.x-1][now.y] = true;
		    				 }
		    				 if(now.y-1>=0&&arr[now.x][now.y-1]==1&&visit[now.x][now.y-1] == false) {
		    					 queue.offer(new xy(now.x,now.y-1));
		    					 visit[now.x][now.y-1] = true;
		    				 }
		    				 if(now.x+1<h&&arr[now.x+1][now.y]==1&&visit[now.x+1][now.y] == false) {
		    					 queue.offer(new xy(now.x+1,now.y));
		    					 visit[now.x+1][now.y] = true;
		    				 }
		    				 if(now.y+1<w&&arr[now.x][now.y+1]==1&&visit[now.x][now.y+1] == false) { 
		    					 queue.offer(new xy(now.x,now.y+1));
		    					 visit[now.x][now.y+1] = true;
		    				 }
		    				 if(now.x-1>=0&&now.y-1>=0&&arr[now.x-1][now.y-1]==1&&visit[now.x-1][now.y-1] == false) {
		    					 queue.offer(new xy(now.x-1,now.y-1));
		    					 visit[now.x-1][now.y-1] = true;
		    				 }
		    				 if(now.x-1>=0&&now.y+1<w&&arr[now.x-1][now.y+1]==1&&visit[now.x-1][now.y+1] == false) {
		    					 queue.offer(new xy(now.x-1,now.y+1));
		    					 visit[now.x-1][now.y+1] = true;
		    				 }
		    				 if(now.x+1<h&&now.y-1>=0&&arr[now.x+1][now.y-1]==1&&visit[now.x+1][now.y-1] == false) { 
		    					 queue.offer(new xy(now.x+1,now.y-1));
		    					 visit[now.x+1][now.y-1] = true;
		    				 }
		    				 if(now.x+1<h&&now.y+1<w&&arr[now.x+1][now.y+1]==1&&visit[now.x+1][now.y+1] == false) {
		    					 queue.offer(new xy(now.x+1,now.y+1));
		    					 visit[now.x+1][now.y+1] = true;
		    				 }
		    				 
		    			 }
		    		  }
		    	  }
		      }
		      
		      System.out.println(island);
		 }
		
		 
		
			 
		 }
		 
	 }


