import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int k = triangle.length;
        
        int[][] dp = new int[k][k];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 0;i<k-1;i++){
            for(int j = 0;j<=i;j++){
                dp[i+1][j] = Math.max(dp[i+1][j],
                                      triangle[i+1][j] + dp[i][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1],
                                      triangle[i+1][j+1] + dp[i][j]);
            }
        }
        
        int max = 0;
        
        for(int i = 0;i<k;i++){
            max = Math.max(dp[k-1][i],max);
        }
        int answer = max;
        return answer;
    }
}