import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> hashmap = new HashMap<>();
        
        for(String now : participant){
            if(hashmap.containsKey(now)){
                hashmap.put(now,hashmap.get(now) +1);
            }
            else{
                hashmap.put(now,1);
            }
        }
        
        for(String now : completion){
            hashmap.put(now,hashmap.get(now)-1);
        }
        
        for(String now : hashmap.keySet()){
            if(hashmap.get(now) != 0){
                return now;
            } 
        }
        return null;
    }
}