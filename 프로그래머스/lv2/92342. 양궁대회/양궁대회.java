import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    static int[] answer;
    static int nn;
    static int m;
    static int[] now;
    static int[] ln;
    static int[] ap;
    static int max = 0;
    
    
    static void lnss(){
        
        ln = new int[11];
        for(int i = 0;i<nn;i++){
            ln[now[i]]++;
        }
        score();
    }
    
    static void score(){
        int aps = 0;
        int lns = 0;
        
        for(int i = 0;i<=10;i++){
            if(ap[i] == 0 && ln[i] == 0) continue;
            if(ap[i] >= ln[i]){
                aps += (10-i);
            }
            if(ap[i] < ln[i]){
                lns += (10-i);
            }
        }
        if(max<(lns-aps)) {
            //System.out.println(lns-aps);
            max = lns - aps;
            answer = ln.clone();
        }
        else if(max == (lns-aps)){
            ansans();
        }
        
    }
    
    static void ansans(){
        for(int i = 10;i>=0;i--){
            if(answer[i] < ln[i]){
                answer = ln.clone();
                break;
            }
            else if(answer[i] > ln[i]){
                break;
            }
        }
    }
    
    
    static void pick(int k, int h){
        if(k == nn){
            lnss();
        }
        else{
            for(int i = 10;i >=h ;i--){
                now[k] = i;
                pick(k+1,i);
            }
        }
    }
    
    public int[] solution(int n, int[] info) {
        ap = info.clone();
        nn = n;
        int m = info.length;
        
        answer = new int[11];
        now = new int[n];
        ln = new int[11];
        
        pick(0,0);
        
        if(max == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
}