import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

    static boolean[] vis;
    static int[] arr;

    static ArrayList<Long> list = new ArrayList<>();


    static void make(int now, int num, int k) {
        if (num == k) {
            change(k);
            return;
        } else {
            for (int i = now ; i <= 9; i++) {
                if (vis[i] == false) {
                    vis[i] = true;
                    arr[num] = i;
                    make(i+1,num + 1,k);
                    vis[i] = false;
                }
            }
        }
    }

    static void change(int k){
        long ans = 0;

        int pp = 0;

        for(int i = 0;i<10;i++){
            if(vis[i]){
                ans += i * Math.pow(10,pp);
                pp++;
            }
        }
        //System.out.println(ans);
        list.add(ans);
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());



        for(int i = 1; i<= 10;i++){
            vis = new boolean[10];
            // 1부터 10까지의 자릿수별로 계산
            arr = new int[i]; // 자릿수 계산할 때마다 배열 재생성
            make(0,0,i);
        }

        Collections.sort(list);

        if(n >= list.size()) System.out.println(-1);
        else System.out.println(list.get(n));

    }
}