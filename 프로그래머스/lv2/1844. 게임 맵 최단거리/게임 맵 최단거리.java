import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    static class pair{
        int a;
        int b;
        int c;
        
        pair(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] vis = new int[n][m];
        
        Queue<pair> stack = new LinkedList<>();
        
        stack.offer(new pair(0,0,0));
        
        while(stack.isEmpty() != true){
            pair now = stack.poll();
            
            if(now.a == n-1 && now.b == m-1){
                return now.c+1;
            }
            
            for(int i = 0;i<4;i++){
                if(now.a + dx[i] >= 0 && now.a + dx[i] <n &&  now.b + dy[i] >= 0 && 
                  now.b + dy[i] < m && vis[now.a + dx[i]][now.b + dy[i]] == 0 && 
                  maps[now.a + dx[i]][now.b + dy[i]] == 1){
                    vis[now.a + dx[i]][now.b + dy[i]] = 1;
                    stack.offer(new pair(now.a + dx[i],now.b + dy[i],now.c + 1));
                }
            }
        }
        
        return -1;
    }
}