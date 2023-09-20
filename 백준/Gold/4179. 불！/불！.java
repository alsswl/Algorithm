import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;
import java.io.*;
import java.math.*;
public class Main {

    static class pair{
        int a;
        int b;

        pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] vis = new int[n][m];

        char[][] arr = new char[n][m];

        Queue<pair> fire = new LinkedList<>();


        for(int i = 0;i<n;i++){
            String k = br.readLine();
            arr[i] = k.toCharArray();
        }

        Queue<pair> stack = new LinkedList<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] == 'J'){
                    if(i == 0 || i == n-1 || j == 0 || j == m-1){
                        System.out.println(1);
                        System.exit(0);
                    }
                    stack.offer(new pair(i,j));
                    vis[i][j] = 1;
                }
                if(arr[i][j] == 'F'){
                    fire.offer(new pair(i,j));
                }
            }
        }

        fire.offer(new pair(-1,-1));
        stack.offer(new pair(-1,-1));


        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};



        int cnt = 0;

        int ok = 1;

        while(ok == 1){
            cnt++;
            ok = 0;



            //불내기

            int nnn = fire.size();

            while(true){
                pair f = fire.poll();
                if(f.a == -1) break;
                for (int z = 0; z < 4; z++) {
                    if ((f.a + dx[z] >= 0 && f.a + dx[z] < n && f.b + dy[z] >= 0 && f.b + dy[z] < m) &&
                            (arr[f.a + dx[z]][f.b + dy[z]] == '.' || arr[f.a + dx[z]][f.b + dy[z]] == 'J') ) {
                        arr[f.a + dx[z]][f.b + dy[z]] = 'F';
                        fire.offer(new pair(f.a + dx[z], f.b + dy[z]));
                    }
                }
            }

            fire.offer(new pair(-1,-1));


            //지훈이 위치 옮기기



            while(true){

                pair now = stack.poll();
                //System.out.println(now.a);
                if(now.a == -1) break;
                vis[now.a][now.b] = 1;
                //System.out.printf("%d %d\n", now.a , now.b );

                    for(int z = 0;z<4;z++){
                        if(now.a + dx[z] >= 0 && now.a + dx[z] < n &&  now.b + dy[z] >= 0 &&  now.b + dy[z] <m &&
                                (arr[now.a + dx[z]][now.b+ dy[z]] == '.' ) && vis[now.a + dx[z]][now.b+ dy[z]] == 0){
                            vis[now.a + dx[z]][now.b+ dy[z]] = 1;
                            ok = 1;
                            stack.offer(new pair(now.a + dx[z],now.b+ dy[z]));
                            arr[now.a + dx[z]][now.b+ dy[z]] = 'J';

                            //System.out.printf("%d %d\n", now.a + dx[z], now.b + dy[z]);
                            if(now.a + dx[z] == 0 || now.a + dx[z] == n-1 || now.b + dy[z]== 0 || now.b + dy[z]== m-1){
                                System.out.println(cnt+1);
                                System.exit(0);
                            }
                        }
                    }

            }

            stack.offer(new pair(-1,-1));

//            for(int i = 0;i<n;i++){
//                for(int j = 0;j<m;j++){
//                    System.out.printf("%c",arr[i][j]);
//                }
//                System.out.println();
//            }

            //System.out.println();

            //System.out.println(stack.size());
        }

        System.out.println("IMPOSSIBLE");


        }


}
