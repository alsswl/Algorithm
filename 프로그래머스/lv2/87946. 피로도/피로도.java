import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    static boolean vis[];
    static int[] arr;
    static int n;
    static int ans = 0;
    static int[][] dun;
    static int kk;
    
    static void check(){
        
        //System.out.println(kk);
        int now = kk;
        int cnt = 0;
        
        for(int i = 0;i<n;i++){
            if(now < dun[arr[i]][0]) break;
            cnt++;
            now -= dun[arr[i]][1];
        }
        
        ans = Math.max(ans, cnt);
        
    }
    
    static void ary(int k){
        if(k == n){
            check();
        }
        else{
            for(int i = 0;i<n;i++){
                if(vis[i] == false){
                    arr[k] = i;
                    vis[i] = true;
                    ary(k+1);
                    vis[i] = false;
                }
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        kk = k;
        n = dungeons.length;
        dun = new int[n][2];
        for(int i = 0;i<n;i++){
            dun[i][0] = dungeons[i][0];
            dun[i][1] = dungeons[i][1];
        }
        vis = new boolean[n];
        arr = new int[n];
        ary(0);
        
        int answer = ans;
        return answer;
    }
}