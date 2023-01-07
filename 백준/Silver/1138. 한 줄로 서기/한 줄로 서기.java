
import java.util.*;
import java.io.*;


public class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 int n = Integer.parseInt(br.readLine());
		 
		 st = new StringTokenizer(br.readLine());
		 int[] arr = new int[n+1];
		 int first = 11;
		 
		 
		 for(int i = 1;i<=n;i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
			 if(arr[i] == 0) {
				 first = Math.min(first, i);
			 }
		 }
		 
		 Stack<Integer> stack = new Stack<>();
		 
		 int[] line = new int[n+1];
		 boolean[] fin = new boolean[n+1];
		 
		 fin[first] = true;
		 
		 line[1] = first;
		 
		 for(int i = 2;i<=n;i++) {
			 int num = 11;
			 for(int j = 1;j<=n;j++) {
				 int count = 0;
				 if(fin[j] == false) {
					 for(int z = 1;z<i;z++) {
						 if(line[z]>j) count++;
					 }
					 if(count == arr[j]) num = Math.min(num, j);
				 }
			 }
			 
			 line[i] = num;
			 fin[num] = true;
			
			 }
		
		 for(int i = 1;i<=n;i++) {
			 System.out.printf("%d ", line[i]);
		 }
		
	 }

}
