
import java.util.*;
import java.io.*;


public class Main {
	
	static int min = 10000000;
	static int houseCnt = 0;
	static int[] nowStore;
	static int m = 0;
	
	static void combination(int[][] dis, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			check(dis,visited,n);
			return;
		}
		
		for(int i = start;i<n;i++) {
			visited[i] = true;
			combination(dis,visited,i+1,n,r-1);
			visited[i] = false;
		}
	}
	
	static void check(int[][] dis, boolean[] visited, int n) {
		
		nowStore = new int[m+1];
		int k = 0;
		int now = 0;
		for(int i =0;i<n;i++) {
			if(visited[i]) {
				nowStore[k] = i+1;
				k++;
			}
		}
		
		for(int j = 1;j <=houseCnt;j++) {
			int nowMin = 10000;
			for(int z = 0;z<k;z++) {
				nowMin = Math.min(nowMin, dis[j][nowStore[z]]);
		  }
			
			now += nowMin;
		}
		
		min = Math.min(min, now);
	}
	
	

	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 
		 int[][] house = new int[2*n+1][2];
		 int[][] store = new int[14][2];
		 
		 houseCnt = 0;
		 int storeCnt = 0;
		 
		 
		 int[][] arr = new int[n+1][n+1];
		 
		 for(int i = 1;i<=n;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 1;j<=n;j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
				 if(arr[i][j] == 1) {
					 houseCnt++;
					 house[houseCnt][0] = i;
					 house[houseCnt][1] = j;
				 }
				 if(arr[i][j] == 2) {
					 storeCnt++;
					 store[storeCnt][0] = i;
					 store[storeCnt][1] = j;
				 }
			 }
		 }
		 
		 int[][] dis = new int[houseCnt+1][storeCnt+1];
		 
		 for(int i = 1;i<=houseCnt;i++) {
			 for(int j = 1;j<=storeCnt;j++) {
				 dis[i][j] = Math.abs(house[i][0]-store[j][0])+Math.abs(house[i][1]-store[j][1]);
			 }
		 }
		 
		 
		 
		 
		
		 
		 boolean[] tr = new boolean[storeCnt+1];
		 
		 combination(dis,tr,0,storeCnt,m);
		 
		 
		 System.out.println(min);
		 
		 
		 
		 
	 }

}
