import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
       //  System.out.println(44);
        int k = puddles.length;
        
        boolean[][] vis = new boolean[n+1][m+1];
        
        int[][] dp  = new int[n+1][m+1];
        
        for(int i = 0;i<k;i++){
            vis[puddles[i][1]][puddles[i][0]] = true;
}
        
        
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(vis[i][j] == true) dp[i][j] = 0;
                else{
                    if(i-1>=1 && j-1>=1){
                        dp[i][j] = dp[i-1][j]% 1000000007 + dp[i][j-1]% 1000000007;
}
                    else if(i-1<1 && j-1>=1){
                        dp[i][j] =  dp[i][j-1]% 1000000007;
}
                     else if(i-1>=1 && j-1<1){
                        dp[i][j] = dp[i-1][j]% 1000000007;
}
                    else{
                        dp[i][j] = 1;
}
}
                dp[i][j] = dp[i][j]% 1000000007;
}
            
}
        
        
        int answer = (dp[n][m] % 1000000007);
        return answer;
    }
}