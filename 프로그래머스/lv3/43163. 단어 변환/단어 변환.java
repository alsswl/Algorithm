import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    static int check(String a, String b){
        int len = 0;
         for(int j = 0;j<a.length();j++){
                    if(a.charAt(j) != b.charAt(j)){
                        len++;
                    }
                }
        return len;
    }
    
    static boolean[] vis;
    static int ans = 0;
    
    static void bfs(String now, int cnt, String[] words, String target){
        
        for(int i = 0;i<words.length; i++){
            if(vis[i] == false){
                int nn =check(now,words[i]);
            if(nn == 1){
                if(words[i].equals(target)) {
                    ans = cnt+1;
                    return;
                }
                vis[i] = true;
                bfs(words[i], cnt+1, words, target);
                vis[i] = false;
            }
            } 
            
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        int n = words.length;
        
        //System.out.println(k);
        
        vis = new boolean[n];
        
       
        int answer = 0;
       
        bfs(begin, 0, words, target);
       
        return ans;
    }
}