import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    static int nn;
    static int ww;
    static int ans;
    
    static void check(int k,int[][] wires){
        List<Integer>[] list = new ArrayList[nn+1];
        for(int i = 0;i<=nn;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0;i<wires.length;i++){
            if(i == k) continue;
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        
        boolean[] vis = new boolean[nn+1];
        
        
        int cnt = 0;
        
        
        for(int i = 1;i<=nn;i++){
            Stack<Integer> stack = new Stack<>();
            
            if(vis[i] == false){
                cnt++;
                stack.push(i);
                vis[i] = true;
                while(stack.isEmpty() != true){
                    int now = stack.pop();
                    for(int j = 0;j<list[now].size();j++){
                        if(vis[list[now].get(j)] == false){
                            vis[list[now].get(j)] = true;
                            stack.push(list[now].get(j));
                            cnt++;
                        }
                    }
                }
                break;
            }
        }
        
        //System.out.println(cnt);
        
        ans = Math.min(ans, Math.abs(nn-2*cnt));
    }
    
    public int solution(int n, int[][] wires) {
        
        nn = n;
        ww = wires.length;
        ans = n;
        
        for(int i = 0;i <wires.length;i++){
            check(i, wires);
        }
        int answer = ans;
        return answer;
    }
}