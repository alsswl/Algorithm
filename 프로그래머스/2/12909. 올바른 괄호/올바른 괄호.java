import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        
        for(int i = 0;i<arr.length;i++){
            stack.push(arr[i]);
        }
        
        while(!stack.isEmpty()){
            char k = stack.pop();
            if(k == ')'){
                stack2.push(')');
            }
            else{
                if(stack2.isEmpty()) return false;
                else stack2.pop();
            }
        }
        
        if(stack2.isEmpty()) return true;
        else return false;

    }
}