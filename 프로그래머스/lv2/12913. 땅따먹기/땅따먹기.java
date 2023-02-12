import java.math.*;
import java.io.*;
import java.util.*;


class Solution {
    int solution(int[][] land) {
      
        int n = land.length;
        
       for(int i = 1;i<n;i++){
           for(int j = 0;j<4;j++){
             int  nowMax = 0;
               for(int z = 0;z<4;z++){
                   if(z != j){
                       nowMax = Math.max(nowMax,land[i-1][z]);
                   }
               }
               land[i][j] = land[i][j] + nowMax;
           }
       }
        
        int max = 0;
      for(int i  = 0;i<4;i++){
          max = Math.max(max,land[n-1][i]);
      }
        
        int answer = max;

        return answer;
    }
}