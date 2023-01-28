
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static int n;
	
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb;
	
	static void print() {
		for(int i = 0;i<n;i++) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		sb.append("\n");
	}
	
	static void makeArr(int k) {
		if(k == n) print();
		else {
			for(int i = 1;i<=n;i++) {
				if(visit[i] == false) {
					arr[k] = i;
					visit[i] = true;
					makeArr(k+1);
					visit[i] = false;
				}
			}
		}
	}
	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        visit = new boolean[n+1];
        
        makeArr(0);
        
        System.out.println(sb);
        
        
        
      
        	
    }
}
