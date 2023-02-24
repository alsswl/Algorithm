import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    static class num{
        int sum;
        int nowi;
        
        num(int sum, int nowi){
            this.sum = sum;
            this.nowi = nowi;
        }
    }
    public int solution(int[] numbers, int target) {
        
        Stack<num> stack = new Stack<>();
        int n = numbers.length;
        int answer = 0;
        stack.push(new num(numbers[0],0));
        stack.push(new num(numbers[0]*-1,0));
        
        while(stack.isEmpty() != true){
            num num2 = stack.pop();
            if(num2.nowi == n-1){
                if(num2.sum == target) answer++;
                continue;
            }
            stack.push(new num(num2.sum+numbers[num2.nowi+1],num2.nowi+1));
             stack.push(new num(num2.sum-numbers[num2.nowi+1],num2.nowi+1));
        }
        
        return answer;
    }
}