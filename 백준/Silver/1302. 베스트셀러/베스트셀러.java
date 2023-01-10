
import java.util.*;
import java.io.*;


 class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int n = Integer.parseInt(br.readLine());
		 
		 String[] books = new String[n];
		 
		 for(int i = 0;i<n;i++) {
			 books[i] = br.readLine();
		 }
		 
		 Arrays.sort(books);
		 int cnt = 1;
		 String same = books[0];
		 String nowString = books[0];
		 int max = 0;
		 
		
		 for(int i =1;i<n;i++) {
			 
			if(books[i].equals(nowString)) {
				cnt++;
				
			}
			if(books[i].equals(nowString)== false || i == n-1){
				if(cnt>max) {
					max = cnt;
					same = nowString;
					
				}cnt = 1;nowString = books[i];
			}
		 }
		
		 System.out.println(same);
		 }
		 
	 }


