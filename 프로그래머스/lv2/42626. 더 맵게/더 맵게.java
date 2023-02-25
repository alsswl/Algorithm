import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
       Queue<Integer> q = new  PriorityQueue<>((a,b)->a-b);
        
        Arrays.sort(scoville);
        
        for(int i =0 ;i<scoville.length;i++){
            q.offer(scoville[i]);
        }
        
        int cnt = 0;
        
        while(true){
            if(q.isEmpty() == true) return -1;
            int kk = q.peek();
            if(kk >=K) break;
            int a = q.poll();
             if(q.isEmpty() == true) return -1;
            int b = q.poll();
            cnt++;
            q.offer(a+b*2);
        }
        
        return cnt;
    }
}