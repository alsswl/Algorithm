
import java.util.*;
import java.io.*;


public class Main {
	
	static int[][] arr;
	static int white = 0;
	static int blue = 0;
	
	static int checkOk(int size, int x, int y) {
		
		int now = arr[x][y];
		
		for(int i = x;i<x+size;i++) {
			for(int j = y;j<y+size;j++) {
				if(now != arr[i][j]) return -1;
			}
		}
		return now;
	}
	
	
	static void divide(int size, int x, int y) {
		int k = checkOk(size,x,y);
		
		if(k == 0) {
			white++;
		}
		else if(k == 1) {
			blue++;
		}
		else {
			size/= 2;
			divide(size,x+size,y);
			divide(size,x+size,y+size);
			divide(size,x,y+size);
			divide(size,x,y);
		}
		
	}
	

	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st ;
		 
		 int n = Integer.parseInt(br.readLine());
		 arr = new int[n][n];
		 
		 for(int i = 0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 0;j<n;j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 divide(n,0,0);
		 
		 System.out.println(white);
		 System.out.println(blue);
		 
		
		
	 }

}
