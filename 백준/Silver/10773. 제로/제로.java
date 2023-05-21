

import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> s = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i= 0; i<n;i++) {
			int k = Integer.parseInt(br.readLine());
			
			if(k == 0) {
				s.pop();
				
			}
			
			else	s.push(k);
			
		}
		
		int ans = 0;
		
		while(s.isEmpty() != true) {
			ans += s.pop();
		}
		
		System.out.println(ans);

	}

}
