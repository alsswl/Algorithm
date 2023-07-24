import java.util.*;
import java.io.*;
import java.math.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new LinkedList[n+1];
        List<Integer>[] list2 = new LinkedList[n+1];

        for(int i = 0;i<=n;i++){
            list[i] = new LinkedList<Integer>();
            list2[i] = new LinkedList<Integer>();
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
            list2[a].add(b);
        }

        LinkedList<Integer> ans = new LinkedList<>();

        int[] vis = new int[n+1];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1;i<=n;i++){// 처음부터 비어있는 리스트 탐색해서 큐에 넣기
            if(list[i].size() == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now + " ");

            for(int j = 0;j<list2[now].size();j++){
                int kk = list2[now].get(j);
                if(list[kk].size() != 0){
                    list[kk].remove(0);
                }
                if(list[kk].size() == 0) q.offer(kk);
            }

        }


        System.out.println(sb);



    }
}