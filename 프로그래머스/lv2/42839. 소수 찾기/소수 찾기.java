import java.util.*;
import java.io.*;

import java.math.*;


class Solution {
    
    static int ans = 0;
    static boolean[] vis;
    static int[] marr;
    static String[] sarr;
    static int nowi;
    
    static boolean[] viss = new boolean[10000000];
    
    static void num(){
        String num = "";
        
        for(int i = 0;i<nowi;i++){
            num = num.concat(sarr[marr[i]]) ;
        }
        if(num.charAt(0) == '0') return;
        int numm = Integer.parseInt(num);
        
        if(viss[numm] == true) return;
        viss[numm] = true;
      //  System.out.println(numm);
        
        int ok = 0;
        
        if(numm == 1) return;
        for(int i =2;i*i<=numm;i++){
            if(numm%i == 0) {
                ok = 1;
                break;
            }
        }
        if(ok == 0) ans++;
    }
    
    static void make(int n){
        if(n == nowi){
            num();
        }
        else{
            for(int i = 0;i<sarr.length;i++){
                if(vis[i] == false){
                    marr[n] = i;
                    vis[i] = true;
                    make(n+1);
                    vis[i] = false;
                }
            }
        }
    }
    
    public int solution(String numbers) {
        sarr = numbers.split("");
        
        for(int i = 1;i<=sarr.length;i++){
            nowi = i;
            vis = new boolean[sarr.length];
            marr = new int[i];
            make(0);
        }
        
        
        
        
        return ans;
    }
}