import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int k : nums){
            set.add(k);
        }
        int a = set.size();
        
        if(a >= nums.length/2){
            return nums.length/2;
        }
        else{
            return a;
        }
    }
}