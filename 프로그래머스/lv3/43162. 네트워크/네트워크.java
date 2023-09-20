import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    
    
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        
       List<Integer>[] re = new LinkedList[n];
        
       for(int i = 0;i<n;i++){
           re[i] = new LinkedList<Integer>();
       }
        
       for(int i = 0;i<n;i++){
           for(int j = 0;j<n;j++){
               if(computers[i][j] == 1){
                   re[i].add(j);
                   //re[j].add(i);
               }
           }
       }
        
        Stack<Integer> stack = new Stack<>();
        
        int[] vis = new int[n];
        
        cnt = 0;
        
        for(int i = 0;i<n;i++){
           if(vis[i] == 0){
               stack.push(i);
               
               while(stack.isEmpty() != true){
                   //System.out.println("dd");
                   
                   int k = stack.pop();
                   
                   for(int j = 0;j<re[k].size();j++){
                   if(vis[re[k].get(j)] == 0){
                       stack.push(re[k].get(j));
                       vis[re[k].get(j)] = 1;
                   }
                }
                   
               }
               
               
               cnt++;
           }
            
   }
        
        return cnt;
                                               
                                               
     
    }
}