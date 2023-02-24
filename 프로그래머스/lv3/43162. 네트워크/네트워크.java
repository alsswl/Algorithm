import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    static int[] uni;
    
    static int find(int n){
        if(uni[n] == n) return n;
        else{
            return uni[n] = find(uni[n]);
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        uni = new int[n];
        
        for(int i =0 ;i<n;i++){
            uni[i] = i;
        }
        
        for(int i  = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(computers[i][j] == 1){
                    int a = find(i);
                    int b = find(j);
                    
                    if(a < b){
                        uni[b] = uni[a];
                    }
                    else if(a > b){
                        uni[a] = uni[a];
                    }
                }
            }
        }
        
        for(int i = 1;i<n;i++){
            int a = find(i);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0;i<n;i++){
            map.put(uni[i],i);
        }
        
        return map.size();
     
    }
}