import java.util.*;
import java.io.*;
import java.math.*;



public class Main {

    static int check(int n){
        int ok = 0;
        for(int i = 2;i*i<=n;i++){
            if(n %i == 0){
                ok =1 ;
                break;
            }
        }
        if(ok == 0) return 1;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Stack<Integer> j = new Stack<Integer>();
        Stack<Integer> t = new Stack<Integer>();

        int[] vis = new int[1001];
        int cnt = 0;


        for(int i = a;i<=b;i++){
            if(check(i) == 1) {
                //System.out.println(i);
                t.push(i);
                vis[i] = 1;
            }
        }

        for(int i = c;i<=d;i++){
            if(check(i) == 1) {
                //System.out.println(i);
                j.push(i);
                if(vis[i] == 1){

                    j.pop();
                    t.pop();
                    cnt++;
                }

            }
        }

        //System.out.println(j.size());
        //System.out.println(t.size());




             if(cnt % 2 == 0){
                 if(t.isEmpty() == true) {

                     System.out.println("yj");
                     return;
                 }
                while(true){

                    t.pop();
                    if(j.isEmpty() == true) {

                        System.out.println("yt");
                        break;
                    }
                    j.pop();
                    if(t.isEmpty() == true) {
                        System.out.println("yj");
                        break;
                    }
                }
            }
            else if(cnt % 2 == 1){
                 if(j.isEmpty() == true) {
                     System.out.println("yt");
                     return;
                 }

                while(true){
                    j.pop();
                    if(t.isEmpty() == true) {
                        System.out.println("yj");
                        break;
                    }
                    t.pop();
                    if(j.isEmpty() == true) {
                        System.out.println("yt");
                        break;
                    }
                }
            }





    }
}