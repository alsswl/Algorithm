
import java.util.*;
import java.io.*;


public class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int n = Integer.parseInt(br.readLine());
		 
		 int[] arr= new int[n];
		 
		 for(int i =0;i<n;i++) {
			 arr[i] = Integer.parseInt(br.readLine());
		 }
		 
		 boolean[] num = new boolean[10001];
		 
		 num[1] = true;
		 int nowN;
		 for(int i = 2;i<=10000;i++) {
			 nowN = i;
			 if(num[i] == false) {
				 while(nowN+i<=10000) {
			       nowN += i;
				   num[nowN] = true;
				 }
			 }
		 }
		 
		 for(int i = 0;i<n;i++) {
			 for(int j = arr[i]/2+1;j>=1;j--) {
				 if(num[j] == false) {
					 if(num[arr[i]-j] == false) {
						 if(j>=arr[i]-j) {
							 System.out.printf("%d %d\n",arr[i]-j,j);
						 }
						 else {
							 System.out.printf("%d %d\n",j,arr[i]-j);
						 }
						 
						 break;
					 }
				 }
			 }
		 }
		 
	 }

}
