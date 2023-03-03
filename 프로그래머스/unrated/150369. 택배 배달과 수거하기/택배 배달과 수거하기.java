import java.io.*;
import java.util.*;
import java.math.*;


class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        long answer = 0;
        boolean[] vis = new boolean[n];
        
        int end = deliveries.length-1;
        
        while(true){
             int nowCap  = cap;
             int maxj = 0;
        
             for(int j = end;j>=0;j--){
                  if(vis[j] == true) continue;
                 if(deliveries[j] > 0){
                     if(deliveries[j] >= nowCap){
                          deliveries[j]-=nowCap;
                          nowCap = 0;
                         maxj = Math.max(maxj, j+1);
                         break;
                     }
                     else{
                         nowCap -= deliveries[j];
                         deliveries[j] = 0;
                          maxj = Math.max(maxj, j+1);
                     }
                    
                }
                
             }
            
             nowCap  = cap;
            
             for(int j = end;j>=0;j--){
                 if(vis[j] == true) continue;
                 if(pickups[j] > 0){
                     if(pickups[j] >= nowCap){
                          pickups[j]-=nowCap;
                          nowCap = 0;
                         
                         maxj = Math.max(maxj, j+1);
                          break;
                     }
                     else{
                         nowCap -= pickups[j];
                         pickups[j] = 0;
                          maxj = Math.max(maxj, j+1);
                     }
                    
                }
                
             }
            
            for(int j = end;j>=1;j--){
                  
                if( deliveries[j] == 0 && pickups[j] == 0){
                    end = j-1;
                }else break;
                
             }
            
            for(int j = 0;j<n;j++){
              
                
            }
           
            
            
            
            if(maxj == 0) break;
            else answer += maxj*2;
            
           
        }
        
        return answer;
    }
}