
import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        Arrays.sort(arr);
        for(int i = arr.length-1;i>=0;i--) {
        	stack.push(arr[i]);
        }
        
        int length = arr.length;
        
        char[] ans = new char[length];
        
        int ok = 0;
        
      //  System.out.println(arr[length-1]);
        
        for(int i = 0;i<length/2+1;i++) {
        	if(stack.isEmpty() == true) break;
        	char now = stack.pop();
        	if(stack.size()!=0&&stack.peek() == now) {
        		stack.pop();
        		ans[i] = now;
        		ans[length-i-1] = now;
        		//System.out.println(i);
        	}
        	else {
        		if(length%2 == 1) {
        			if(ok == 0) {
        				ok  = 1;
        				ans[length/2] = now;
        				i--;
        				
        			}
        			else {
        				System.out.printf("I'm Sorry Hansoo");
        				return;
        			}
        		}
        		
        		else {
    				System.out.printf("I'm Sorry Hansoo");
    				return;
    			}
        	}
        }
        
        System.out.println(ans);
        
        
        	
    }
}
