
import java.util.*;
import java.io.*;


public class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st  = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 int k = Integer.parseInt(st.nextToken());
		 
		 int[] arrN = new int[n];
		 
		 for(int i = 0;i<n;i++) {
			 arrN[i] = Integer.parseInt(br.readLine());
		 }
		 
		 int[][] arr = new int[n][k+1];
		 
		 for(int i = arrN[0];i<=k;i++) {
			 if(i%arrN[0] == 0) arr[0][i] = 1;
		 }
		 
		 for(int i = 1;i<n;i++) {
			 for(int j = 1;j<=k;j++) {
				 if(j < arrN[i]) {
					 arr[i][j] = arr[i-1][j];
				 }
				 else if(j == arrN[i]) {
					 arr[i][j] = arr[i-1][j]+1;
				 }
				 else {
					 arr[i][j] = arr[i-1][j] + arr[i][j-arrN[i]];
				 }
			 }
		 }
		 
		 System.out.println(arr[n-1][k]);
		 
		 
		
	 }

}
