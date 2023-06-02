import java.util.*;
import java.io.*;
import java.math.*;

class xy{
    int x;
    int y;

    xy(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;



        for(int i = 0;i<n;i++){


            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] vis = new int[k][l];
            char[][] arr = new char[k][l];

            Queue<xy> q = new LinkedList<>();
            Queue<xy> fire = new LinkedList<>();

            for(int j = 0;j<k;j++){
                String now = br.readLine();
                arr[j] = now.toCharArray();
                for(int z = 0;z<l;z++){
                    if(arr[j][z] == '@'){
                        vis[j][z] = 1;
                        arr[j][z] = '.';
                        q.offer(new xy(j,z));
                        break;
                    }
                    if(arr[j][z] == '*'){
                        fire.offer(new xy(j,z));

                    }
                }
            }

            int cnt = 0;
            int ok =0;

            while(true){

                cnt++;


               fire.offer(new xy(-1,-1));

               while(fire.isEmpty() != true){
                   xy now = fire.poll();
                   if(now.x == -1) break;

                   if(now.x-1 >=0 && arr[now.x-1][now.y] == '.'){
                       fire.offer(new xy(now.x-1, now.y));
                       arr[now.x-1][now.y] = '*';
                   }
                   if(now.x+1 < k && arr[now.x+1][now.y] == '.'){
                       fire.offer(new xy(now.x+1, now.y));
                       arr[now.x+1][now.y] = '*';
                   }
                   if(now.y-1 >=0 && arr[now.x][now.y-1] == '.'){
                       fire.offer(new xy(now.x, now.y-1));
                       arr[now.x][now.y-1] = '*';
                   }
                   if(now.y+1 < l && arr[now.x][now.y+1] == '.'){
                       fire.offer(new xy(now.x, now.y+1));
                       arr[now.x][now.y+1] = '*';
                   }
               }


                q.offer(new xy(-1,-1));


                while(true){

                    xy now = q.poll();
                    if(now.x == -1) break;

                    if(now.x == k-1 || now.y == l-1|| now.x == 0|| now.y == 0){
                        //System.out.println(cnt);
                        System.out.println(cnt);
                        ok =1;
                        break;
                    }



                    if(now.x +1 < k && arr[now.x + 1][now.y] == '.' && vis[now.x+1][now.y] == 0){
                        q.offer(new xy(now.x+1, now.y));
                        vis[now.x+1][now.y] = 1;

                    }

                    if(now.y +1 < l && arr[now.x][now.y+1] == '.'&& vis[now.x][now.y+1] == 0){
                        q.offer(new xy(now.x, now.y+1));
                        vis[now.x][now.y+1] = 1;


                    }

                    if(now.x -1 >= 0 && arr[now.x - 1][now.y] == '.'&& vis[now.x-1][now.y] == 0){
                        q.offer(new xy(now.x-1, now.y));
                        vis[now.x-1][now.y] = 1;

                    }

                    if(now.y-1 >=0 && arr[now.x][now.y-1] == '.'&& vis[now.x][now.y-1] == 0){
                        q.offer(new xy(now.x, now.y-1));
                        vis[now.x][now.y-1] = 1;

                    }

                }

                if(ok == 1) break;

                if(q.isEmpty() == true){
                   System.out.println("IMPOSSIBLE");
                    break;
                }


            }

        }



    }
}