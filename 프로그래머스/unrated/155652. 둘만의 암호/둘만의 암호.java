import java.util.*;
import java.io.*;
import java.math.*;


class Solution {
    public String solution(String s, String skip, int index) {
        
        char[] skipC = skip.toCharArray();
        char[] sC = s.toCharArray();
        char[] ans = new char[sC.length];
        
        for(int i = 0;i<sC.length;i++){
            for(int j = 0;j<index;j++){
                do{
                    sC[i]++;
                    if(sC[i]>'z'){
                        sC[i]-=26;
                    }
                    
                }while(skip.contains(String.valueOf(sC[i])));
            }
        }
        
        String answer = new String(sC);
        return answer;
    }
}
