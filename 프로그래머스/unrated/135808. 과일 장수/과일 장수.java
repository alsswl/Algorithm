import java.io.*;
import java.util.*;
import java.math.*;


class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        
        int box = score.length/m;
        
        int sum = 0;
        
        for(int i = 1;i<=box;i++){
            sum += score[score.length-m*i];
        }
        
        
        
        int answer = sum*m;
        return answer;
    }
}