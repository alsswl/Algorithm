import java.util.*;
import java.io.*;
import java.math.*;



public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer>[] rela = new ArrayList[n];
        int root = 0;

        for(int i = 0;i<n;i++){
            rela[i] = new ArrayList<>();
        }

        for(int i = 0;i<n;i++){
            int k = Integer.parseInt(st.nextToken());
            if(k == -1){
                root = i;
            }
            else{
                rela[k].add(i);
            }
        }

        int del = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        stack.push(root);

        int cnt = 0;

        while (stack.isEmpty() != true){
            int kk = stack.pop();

            if(kk == del) continue;
            if(rela[kk].size() == 0) cnt++;
            if(rela[kk].size() == 1 && rela[kk].get(0) == del) cnt++;

            for(int i = 0;i<rela[kk].size();i++){
                stack.push(rela[kk].get(i));
            }
        }

        System.out.println(cnt);

    }
}