
import java.util.*;
import java.io.*;


public class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int n = Integer.parseInt(br.readLine());
		 String string = br.readLine();
		 int k = string.length();
		 
		 char[][] arr = new char[n][k];
		 arr[0] = string.toCharArray();
		 for(int i = 1;i<n;i++) {
			String string2 = br.readLine();
			arr[i] = string2.toCharArray();
		 }
		
		 int dif = 0;
		 
		 for(int i = 1;i<=k;i++) {
			 for(int j = 0;j<n-1;j++) {
				 for(int z = j+1;z<n;z++) {
					 dif = 0;
					 for(int g = 1;g<=i;g++) {
						 if(arr[j][k-g] != arr[z][k-g]) {
							 dif = 1;
							 break;
						 }
					 }
					 if(dif == 0) break; 
				 }
				 if(dif == 0) break;
			 }
			 if(dif == 1) {
				 System.out.println(i);
				 break;
			 }
		 }
		 
		 
		 
		 
	 }

}
