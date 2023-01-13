
import java.util.*;
import java.io.*;

public class Main{
	static int m ;
    static int n ;
    static int h ;
	
	static class xyz{
		int i;
		int j;
		int k;
		int time;
		
		xyz(int i, int j, int k,int time){
			this.i = i;
			this.j = j;
			this.k = k;
			this.time = time;
		}
	}
	
	static int check(int[][][] arr) {
		int zero = 0;
		  for(int i = 0;i<h;i++) {
	        	for(int j = 0;j<n;j++) {
	        		for(int k = 0;k<m;k++) {
	        			if(arr[i][j][k] == 0) zero++;
	        		}
	        	}
	        }
		  return zero;
	}
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
         m = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());
         h = Integer.parseInt(st.nextToken());
        
        int[][][] arr = new int[h][n][m];
        
        for(int i = 0;i<h;i++) {
        	for(int j = 0;j<n;j++) {
        		st = new StringTokenizer(br.readLine());
        		for(int k = 0;k<m;k++) {
        			arr[i][j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        }
        
        Queue<xyz> queue = new LinkedList<>();
        int day = 0;
        int nowzero = 0;
        int kk = 0;
        if(check(arr) == 0) {
        	System.out.println(0);
        	return;
        }
        
        int max = 0;
        
      
        	for(int i = 0;i<h;i++) {
            	for(int j = 0;j<n;j++) {
            		for(int k = 0;k<m;k++) {
            			if(arr[i][j][k] ==1 ) {
            				queue.offer(new xyz(i,j,k,0));
            			}
            		}
            	}
            }
        	
        	while(queue.isEmpty()!= true) {
        		xyz now = queue.poll();
        		max = Math.max(max,now.time);
        		if(now.i-1>=0&&arr[now.i-1][now.j][now.k] == 0) {
        			arr[now.i-1][now.j][now.k] = 1;
        			queue.offer(new xyz(now.i-1,now.j,now.k,now.time+1));
        		}
        		if(now.i+1<h&&arr[now.i+1][now.j][now.k] == 0) {
        			arr[now.i+1][now.j][now.k] = 1;
        			queue.offer(new xyz(now.i+1,now.j,now.k,now.time+1));
        		}
        		if(now.j-1>=0&&arr[now.i][now.j-1][now.k] == 0) {
        			arr[now.i][now.j-1][now.k] = 1;
        			queue.offer(new xyz(now.i,now.j-1,now.k,now.time+1));
        		}
        		if(now.j+1<n&&arr[now.i][now.j+1][now.k] == 0) {
        			arr[now.i][now.j+1][now.k] = 1;
        			queue.offer(new xyz(now.i,now.j+1,now.k,now.time+1));
        		}
        		if(now.k-1>=0&&arr[now.i][now.j][now.k-1] == 0) {
        			arr[now.i][now.j][now.k-1] = 1;
        			queue.offer(new xyz(now.i,now.j,now.k-1,now.time+1));
        		}
        		if(now.k+1<m&&arr[now.i][now.j][now.k+1] == 0) {
        			arr[now.i][now.j][now.k+1] = 1;
        			queue.offer(new xyz(now.i,now.j,now.k+1,now.time+1));
        		}
        	}
        	
        	nowzero = check(arr);
        	if(nowzero == 0) {
        		System.out.println(max);
        		return;
        	}
        	else {
        		System.out.println(-1);
        		return;
        	}
        	
        	
    }
}
