
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	
    	int[][] arr = new int[n][n];
    	
    	int[][] res = new int[n][n];
    	
    	for(int i = 0 ;i<n;i++) {
    		 st = new StringTokenizer(br.readLine());
    		for(int j = 0;j<n;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	List<Integer>[] list = new ArrayList[n];
    	
    	for(int i = 0;i<n;i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	for(int i = 0 ;i<n;i++) {
   		 
   		for(int j = 0;j<n;j++) {
   			  if(arr[i][j] == 1) {
   				  list[i].add(j);
   			  }
   		   }
   	    }

    	for(int i = 0 ;i<n;i++) {
       		for(int j = 0;j<n;j++) {
       			  Stack<Integer> stack = new Stack<>();
       			  
       			  int[] visit = new int[n];
       			  
       			  stack.push(i);
       			  int ok = 0;
       			  
       			  while(stack.isEmpty() != true) {
       				  int now = stack.pop();
       				  
       				  for(int k = 0;k<list[now].size();k++) {
       					  if(list[now].get(k) != j && visit[list[now].get(k)] == 0) {
       						visit[list[now].get(k)] = 1;
       						  stack.push(list[now].get(k));
       					  }
       					  if(list[now].get(k) == j) {
       						  ok = 1;
       						  break;
       					  }
       				  }
       			  }
       			  
       			  res[i][j] = ok;
       		   }
       	    }
    	
    	
    	for(int i = 0 ;i<n;i++) {
      		 
       		for(int j = 0;j<n;j++) {
       			  System.out.printf("%d ",res[i][j]);
       		   }
       		System.out.println();
       	    }
    	
    }
    
}

