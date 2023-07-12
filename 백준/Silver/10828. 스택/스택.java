import java.util.*;
import java.io.*;


class Main{
	
 public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ;
    
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    
    int n = Integer.parseInt(br.readLine());
    
    int i;
    int keep = 0;
    
    for(i = 0;i<n;i++) {
    	st = new StringTokenizer(br.readLine());
    	String now = st.nextToken();
    	if(now.equals("push")) {
    		int a = Integer.parseInt(st.nextToken());
    		stack.push(a);
    		
    	}
    	else if(now.equals("pop")) {
    		if(stack.isEmpty() == false)
    			{int k = stack.pop();
    		sb.append(k).append("\n");}
    		else sb.append(-1).append("\n");
    		
    		
    	}
    	else if(now.equals("size")) {
    		sb.append(stack.size()).append("\n");
    	}
    	else if(now.equals("empty")) {
    		if(stack.isEmpty() == true) {
    			sb.append(1).append("\n");
    		}
    		else {
    			sb.append(0).append("\n");
    		}
    		
    	}
    	else if(now.equals("top")) {
    		if(stack.isEmpty() == true) {
    			sb.append(-1).append("\n");
    		}
    		else {
    			sb.append(stack.peek()).append("\n");
    		}
    		
    	}
    
    }

    System.out.println(sb);
  
  
 }


 }    

