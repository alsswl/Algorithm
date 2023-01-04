
import java.util.*;
import java.io.*;


public class Main {
	static int[][] arr;
	static int ze = 0;
	static int one = 0;
	static int ma = 0;
	
	static int colorCheck(int size, int x,int y) {
		int now = arr[x][y];
			 
		for(int i = x;i<size+x;i++) {
			for(int j = y;j<size+y;j++) {
				if(arr[i][j] != now) return 2;
			}
		}
		return now;
		 }
	
	static void three(int size,int x, int y) {
		int k = colorCheck(size,x,y);
		
		if(k == 0) {
			ze++;
		}
		else if(k == 1) {
			one++;
		}
		else if(k == -1) {
			ma++;
		}
		else {
			three(size/3,x,y);
			three(size/3,x+size/3,y);
			three(size/3,x+size/3*2,y);
			three(size/3,x,y+size/3);
			three(size/3,x+size/3,y+size/3);
			three(size/3,x+size/3*2,y+size/3);
			three(size/3,x,y+size/3*2);
			three(size/3,x+size/3,y+size/3*2);
			three(size/3,x+size/3*2,y+size/3*2);
		}
	}


	 public static void main(String[] args) throws IOException {
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		 StringTokenizer st ;
	
		 
		 arr = new int[n][n];

	
		 for(int i = 0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 0;j<n;j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 three(n,0,0);
		 
		 System.out.println(ma);
		 System.out.println(ze);
		 System.out.println(one);
		 
		
		 
		 
		 
		
	 }

}
