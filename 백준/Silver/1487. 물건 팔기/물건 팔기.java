
import java.util.*;
import java.io.*;


public class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st  ;
		 
		 int n = Integer.parseInt(br.readLine());
		 
		 int[][] arr = new int[n][2];
		 
		 Stack<Integer> stack = new Stack<>();
		 
		 for(int i = 0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 arr[i][0] = Integer.parseInt(st.nextToken());
			 arr[i][1] = Integer.parseInt(st.nextToken());
			 
			 stack.push(arr[i][0]);
			 
			 
		 }
		 
		 int max = 0;
		 int maxMon = 1000000;
		 
		 while(stack.isEmpty() != true) {
			 int mon = stack.pop();
			 int gain = 0;
			 
			 for(int i =0;i<n;i++) {
				 if(arr[i][0]>=mon&&arr[i][1]-mon<=0) {
					 gain+=(mon- arr[i][1]);
				 }
			 }
			
			 if(max==gain) {
				 max = gain;
				 maxMon = Math.min(maxMon, mon);
			 }
			 else if(max<gain) {
				 max = gain;
				 maxMon = mon;
			 }
		 }
		 
		 if(max == 0) System.out.println(0);
		 else System.out.println(maxMon);
		 
	
		 
		
	 }

}
