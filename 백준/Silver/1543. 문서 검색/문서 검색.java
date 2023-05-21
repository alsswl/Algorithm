

import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String f = br.readLine();
		String k = br.readLine();
		
		int cnt = 0;
		
		char[] arr = f.toCharArray();
		char[] kk = k.toCharArray();
		
		for(int i = 0;i<arr.length;i++) {
			
			//System.out.println(i);
			if(arr[i] == kk[0]) {
				int ok = 1;
				
				for(int j = 0;j<kk.length;j++) {
					if(i+j>arr.length-1) {
						ok = 0;
						break;
					}
					if(arr[i+j] != kk[j]) {
						ok = 0;
						break;
					}
				}
				if(ok == 1) {
					i += kk.length-1;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		

  }
}
