import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0;i<progresses.length;i++){
            int a = (100-progresses[i])/speeds[i];
            int b = (100-progresses[i])%speeds[i];
            if(b != 0) a++;
            
            q.add(a);
            day[i] = a;
        }
        
        LinkedList<Integer> answ = new LinkedList<>();
        
        while(!q.isEmpty()){
            int num = 1;
            int k = q.poll();
            while(true){
                if(q.isEmpty() || k < q.peek()) break;
                q.poll();
                num++;
            }
            answ.add(num);
        }
        
        int[] ans = new int[answ.size()];
        
        for(int i = 0;i<answ.size();i++){
            ans[i] = answ.get(i);
        }
        
        return ans;
    }
}