
import java.util.*;
import java.io.*;


class Main{
	
 public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ;
    
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new LinkedList<>();
    
    int n = Integer.parseInt(br.readLine());
    
    int i;
    int keep = 0;
    
    for(i = 0;i<n;i++) {
    	st = new StringTokenizer(br.readLine());
    	String now = st.nextToken();
    	if(now.equals("push")) {
    		int a = Integer.parseInt(st.nextToken());
    		queue.offer(a);
    		keep = a;
    		
    	}
    	else if(now.equals("pop")) {
    		if(queue.isEmpty() == false)
    			{int k = queue.poll();
    		sb.append(k).append("\n");}
    		else sb.append(-1).append("\n");
    		
    		
    	}
    	else if(now.equals("size")) {
    		sb.append(queue.size()).append("\n");
    	}
    	else if(now.equals("empty")) {
    		if(queue.isEmpty() == true) {
    			sb.append(1).append("\n");
    		}
    		else {
    			sb.append(0).append("\n");
    		}
    		
    	}
    	else if(now.equals("front")) {
    		if(queue.isEmpty() == false)
    			sb.append(queue.peek()).append("\n");
    		else sb.append(-1).append("\n");
    		
    	}
    	else if(now.equals("back")) {
    		if(queue.isEmpty() == false)
    			sb.append(keep).append("\n");
    		else sb.append(-1).append("\n");
    	}
    	
    	
    }
    	

    
    
    
    System.out.println(sb);
  
 
    
 }


 
 
 }    

