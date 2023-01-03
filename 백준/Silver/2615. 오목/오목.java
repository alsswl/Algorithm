
import java.util.*;
import java.io.*;


class pair {
		long num;
		long count;
		pair(long a, long i) {
			num = a;
			count = i;
		}
	}
public class Main {
	
	static int checkone(int[][] arr,int i, int j) {
		if(arr[i][j] == 1&&arr[i+1][j+1] == 1&&arr[i+2][j+2] == 1&& arr[i+3][j+3] == 1&&arr[i+4][j+4] == 1 ) {
			if(i+5<=18&& j+5<=18&&arr[i+5][j+5] ==1) return 0;
			if(i-1>=0&&j-1>=0&&arr[i-1][j-1] == 1) return 0;
			return 1;
		}
		if(arr[i+4][j] == 1&&arr[i+3][j+1] == 1&&arr[i+2][j+2] == 1&& arr[i+1][j+3] == 1&&arr[i][j+4] == 1) {
			if(i-1>=0&&j+5<=18&&arr[i-1][j+5] == 1) return 0;
			if(i+5<=18&&j-1>=0&&arr[i+5][j-1] == 1) return 0;
			return 2;
		}
		return 0;
	}
	
	static int checktwo(int[][] arr,int i, int j) {
		if(arr[i][j] == 2&&arr[i+1][j+1] == 2&&arr[i+2][j+2] == 2&& arr[i+3][j+3] == 2&&arr[i+4][j+4] == 2) {
			if(i+5<=18&& j+5<=18&&arr[i+5][j+5] ==2) return 0;
			if(i-1>=0&&j-1>=0&&arr[i-1][j-1] == 2) return 0;
			return 3;
		}
		if(arr[i+4][j] == 2&&arr[i+3][j+1] == 2&&arr[i+2][j+2] == 2&& arr[i+1][j+3] == 2&&arr[i][j+4] == 2) {
			if(i-1>=0&&j+5<=18&&arr[i-1][j+5] == 2) return 0;
			if(i+5<=18&&j-1>=0&&arr[i+5][j-1] == 2) return 0;
			return 4;
		}
		return 0;
	}

	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 int[][] arr = new int[19][19];
		 
		for(int i = 0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<19;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		//가로 1
		for(int i = 0;i<19;i++) {
			count = 0;
			for(int j = 0;j<19;j++) {
				if(arr[i][j] == 1) count++;
				else count = 0;
				if(count == 5) {
					if(j-5>=0&&arr[i][j-5] == 1) continue;
					if(j+1<=18&&arr[i][j+1] == 1) continue;
					System.out.println(1);
					System.out.printf("%d %d",i+1,j-4+1);
					return;
				}
			}
		}
		
		//가로 2
				for(int i = 0;i<19;i++) {
					count = 0;
					for(int j = 0;j<19;j++) {
						if(arr[i][j] == 2) count++;
						else count = 0;
						if(count == 5) {
							if(j-5>=0&&arr[i][j-5] == 2) continue;
							if(j+1<=18&&arr[i][j+1] == 2) continue;
							System.out.println(2);
							System.out.printf("%d %d",i+1,j-4+1);
							return;
						}
					}
				}
				
				//세로 1
				for(int i = 0;i<19;i++) {
					count = 0;
					for(int j = 0;j<19;j++) {
						if(arr[j][i] == 1) count++;
						else count = 0;
						if(count == 5) {
							if(j-5>=0&&arr[j-5][i] == 1) continue;
							if(j+1<=18&&arr[j+1][i] == 1) continue;
							System.out.println(1);
							System.out.printf("%d %d",j-4+1,i+1);
							return;
						}
					}
				}
				
				//세로 2
				for(int i = 0;i<19;i++) {
					count = 0;
					for(int j = 0;j<19;j++) {
						if(arr[j][i] == 2) count++;
						else count = 0;
						if(count == 5) {
							if(j-5>=0&&arr[j-5][i] == 2) continue;
							if(j+1<=18&&arr[j+1][i] == 2) continue;
							System.out.println(2);
							System.out.printf("%d %d",j-4+1,i+1);
							return;
						}
					}
				}
	
		for(int i = 0;i<15;i++) {
			for(int j = 0;j<15;j++) {
				int k = checkone(arr,i,j);
				if(k == 0) ;
				else if(k == 1) {
					System.out.println(1);
					System.out.printf("%d %d",i+1,j+1);
					return;
				}
				else {
					System.out.println(1);
					System.out.printf("%d %d",i+4+1,j+1);
					return;
				}
				
			    k = checktwo(arr,i,j);
				if(k == 0);
				else if(k == 3) {
					System.out.println(2);
					System.out.printf("%d %d",i+1,j+1);
					return;
				}
				else {
					System.out.println(2);
					System.out.printf("%d %d",i+4+1,j+1);
					return;
				}
			}
		}
		System.out.println(0);
		 
	 }

}
