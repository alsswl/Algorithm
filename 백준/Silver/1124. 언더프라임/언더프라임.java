
import java.util.*;
import java.io.*;


public class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int a = Integer.parseInt(st.nextToken());
		 int b = Integer.parseInt(st.nextToken());
		 
		 boolean[] num = new boolean[100001];
		 int under = 0;
		 
		 num[1] = true;
		 num[0] = true;
		 int nowN;
		 for(int i = 2;i<=100000;i++) {
			 nowN = i;
			 if(num[i] == false) {
				 while(nowN+i<=100000) {
			       nowN += i;
				   num[nowN] = true;
				 }
			 }
		 }
		 
		 for(int i = a;i<=b;i++) {
			 int cnt = 0;
			 int now = i;
			 while(now != 1) {
				 for(int j = 2;j<=now;j++) {
					// System.out.println(j);
					 if(num[j] == false&& now%j == 0) {
						
						 now /= j;
						 cnt++;
						 break;
					 }
				 }
			 }
			
			 if(num[cnt] == false) under++;
		 }
		 
		System.out.println(under);
			 
		 }
		 
	 }


