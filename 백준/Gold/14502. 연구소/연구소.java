
import java.util.*;
import java.io.*;


public class Main {
	
	static int[][] arr;
	static int[][] arr2;
	static int max = 0;
	static int[][] bi;
	static int[][] no;
	static int biCnt;
	static int noCnt;
	static int n;
	static int m;
	
	static class xy{
		int x;
		int y;
	 xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	   static void checkNo() {
		Queue<xy> queue = new LinkedList<>();
		
		for(int i = 0;i<=biCnt;i++) {
			queue.offer(new xy(bi[i][0],bi[i][1]));
		}
		
		while(queue.isEmpty()!= true) {
			xy now = queue.poll();
			if(now.x-1>=0&& arr2[now.x-1][now.y] == 0) {
				arr2[now.x-1][now.y] = 2;
				queue.offer(new xy(now.x-1,now.y));
			}
			if(now.y-1>=0&& arr2[now.x][now.y-1] == 0) {
				arr2[now.x][now.y-1] = 2;
				queue.offer(new xy(now.x,now.y-1));
			}
			if(now.x+1<n&& arr2[now.x+1][now.y] == 0) {
				arr2[now.x+1][now.y] = 2;
				queue.offer(new xy(now.x+1,now.y));
			}
			if(now.y+1<m&& arr2[now.x][now.y+1] == 0) {
				arr2[now.x][now.y+1] = 2;
				queue.offer(new xy(now.x,now.y+1));
			}
		}
		int cnt = 0;
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(arr2[i][j] == 0) cnt++;
				
			}
		}
		
		max = Math.max(max,cnt);
		
	}
	
	static void makeWall(boolean[] ok, int k1) {
		arr2 = new int[n][m];
		
		for(int i =0 ;i<n;i++) {
			for(int j = 0;j<m;j++) {
			   arr2[i][j] = arr[i][j];
			}
		}
		
		for(int i =0;i<k1;i++) {
			if(ok[i] == true) {
				arr2[no[i][0]][no[i][1]] = 1;
			}
		}
		
		
		
		checkNo();
		
	}
	
	
	
	static void pick(boolean[] ok,  int k, int all, int r) {
		
		if(r == 0) {
			makeWall(ok,all);
		}
		else {
			for(int i = k;i<all;i++) {
				ok[i] = true;
				pick(ok, i+1,all,r-1);
				ok[i] = false;
			}
		}
	}
	

	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 
		 
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 
		 arr = new int[n][m];
		 
		 no = new int[n*m][2];
		 bi = new int[10][2];
		 noCnt = -1;
		 biCnt = -1;
		 
		 
		 for(int i = 0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 0;j<m;j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
				 
				 if(arr[i][j] == 0) {
					 noCnt++;
					 no[noCnt][0] = i;
					 no[noCnt][1] = j;
				 }
				 if(arr[i][j] == 2) {
					 biCnt ++;
					 bi[biCnt][0] = i;
					 bi[biCnt][1] = j;
				 }
			 }
		 }
		
		 boolean[] ok = new boolean[noCnt+1];
		 pick(ok,0,noCnt+1,3);
	
		System.out.println(max);
	 }

}
