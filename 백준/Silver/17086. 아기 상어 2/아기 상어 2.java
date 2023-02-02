import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	static int n;
	static int m;
	static int[][] arr;
	
	
	static class  Xy{
		int x;
		int y;
		int cnt;
		
		Xy(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int check(int x, int y) {
		
		boolean[][] visit = new boolean[n+1][m+1];
		
	     Queue<Xy> q = new LinkedList<>();
		
	     q.offer(new Xy(x,y,0));
	     
	     while(q.isEmpty() != true) {
	    	
	    	 Xy nowQ = q.poll();
	    	 
	    	 if(arr[nowQ.x][nowQ.y] == 1) {
	    		 return nowQ.cnt;
	    	 }

	    	 if(nowQ.x -1 >= 1 && visit[nowQ.x-1][nowQ.y] == false) {
	    		 q.offer(new Xy(nowQ.x-1,nowQ.y,nowQ.cnt+1));
	    		 visit[nowQ.x-1][nowQ.y] = true;
	    	 }
	    	 
	    	 if(nowQ.y -1 >= 1&& visit[nowQ.x][nowQ.y-1] == false) {
	    		 q.offer(new Xy(nowQ.x,nowQ.y-1,nowQ.cnt+1));
	    		 visit[nowQ.x][nowQ.y-1] = true;
	    	 }
	    	 
	    	 if(nowQ.x +1 <= n&& visit[nowQ.x+1][nowQ.y] == false) {
	    		 q.offer(new Xy(nowQ.x+1,nowQ.y,nowQ.cnt+1));
	    		 visit[nowQ.x+1][nowQ.y] = true;
	    	 }
	    	 
	    	 if(nowQ.y +1 <= m&& visit[nowQ.x][nowQ.y+1] == false) {
	    		 q.offer(new Xy(nowQ.x,nowQ.y+1,nowQ.cnt+1));
	    		 visit[nowQ.x][nowQ.y+1] = true;
	    	 }
	    	 
	    	 if(nowQ.x -1 >= 1 && nowQ.y -1 >= 1&& visit[nowQ.x-1][nowQ.y-1] == false) {
	    		 q.offer(new Xy(nowQ.x-1,nowQ.y-1,nowQ.cnt+1));
	    		 visit[nowQ.x-1][nowQ.y-1] = true;
	    	 }
	    	 if(nowQ.x -1 >= 1 && nowQ.y +1 <= m&& visit[nowQ.x-1][nowQ.y+1] == false) {
	    		 q.offer(new Xy(nowQ.x-1,nowQ.y+1,nowQ.cnt+1));
	    		 visit[nowQ.x-1][nowQ.y+1] = true;
	    	 }
	    	 if(nowQ.x +1 <= n && nowQ.y -1 >= 1&& visit[nowQ.x+1][nowQ.y-1] == false) {
	    		 q.offer(new Xy(nowQ.x+1,nowQ.y-1,nowQ.cnt+1));
	    		 visit[nowQ.x+1][nowQ.y-1] = true;
	    	 }
	    	 if(nowQ.x +1 <= n && nowQ.y +1 <= m&& visit[nowQ.x+1][nowQ.y+1] == false) {
	    		 q.offer(new Xy(nowQ.x+1,nowQ.y+1,nowQ.cnt+1));
	    		 visit[nowQ.x+1][nowQ.y+1] = true;
	    	 }
	    	
	     }
	     return 0;
	}
	


	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max = 0;
        
        arr = new int[n+1][m+1];
        
        for(int i = 1;i<=n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1;j<=m;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 1;i<=n;i++) {
        	for(int j = 1;j<=m;j++) {
        		if(arr[i][j] == 0) {
        			Stack<Xy> stack1 = new Stack<>();
        			int k = check(i,j);
        			 
        			max = Math.max(max, k);
        		}
        	}
        }
        
        System.out.println(max);
        
        
    }
}
