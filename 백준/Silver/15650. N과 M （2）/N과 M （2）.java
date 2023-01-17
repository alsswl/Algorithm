
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static boolean[] visit;
	static int n;
	static int m;
	static StringBuilder sb;
	
	static int[] arr;
	
	static void print() {
		for(int i = 0;i<m;i++) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		sb.append("\n");
	}
	
	static void re(int sta,int k) {
		
		if(k == m) {
			print();
		}
		else {
			for(int i = sta;i<=n;i++) {
			if(visit[i] == false) {
				arr[k] = i;
				visit[i] = true;
			    re(i+1,k+1);
			    visit[i] = false;
			}
			
		}
		}
		
	}
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visit = new boolean[n+1];
        
        arr = new int[m];
        
        re(1,0);
        
        System.out.println(sb);
        	
        	
    }
}
