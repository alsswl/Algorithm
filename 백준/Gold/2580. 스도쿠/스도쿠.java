import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int[][] arr;
    static int ok = 0;

    static boolean check(int a, int b,int kk){


        // 가로로 한개만 있는 경우
        for(int i = 0;i<9;i++){
            if(arr[a][i] == kk) return false;
        }

        //세로로 하나만 있는 경우

        for(int i = 0;i<9;i++){
            if(arr[i][b] == kk) return false;
        }

        //네모로 하나만 있는 경우

        int k = a/3;
        int l = b/3;


        for(int i = 3*k;i<=3*(k+1)-1;i++){
            for(int j = 3*l;j<=3*(l+1)-1;j++){
                if(arr[i][j] == kk) return false;
              }
            }
          return true;
        }

        static StringBuilder sb = new StringBuilder();

        static void stq(int a, int b){
            //System.out.println(b);
             if(b == 9){
                 stq(a+1,0);
                 return;
             }
              if(a == 9){
                 for(int i = 0;i<9;i++){
                     for(int j = 0;j<9;j++){
                         sb.append(arr[i][j]).append(" ");
                     }
                     sb.append("\n");
                 }

                 System.out.println(sb);
                 System.exit(0);
                 return;
             }

              if(arr[a][b] == 0){
                 for(int i = 1;i<=9;i++){
                     if(check(a,b,i)){
                         arr[a][b] = i;
                         stq(a,b+1);
                     }
                 }
                 arr[a][b] = 0;
                 return;
             }
            stq(a,b+1);
        }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[9][9];

        for(int i = 0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<9;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        stq(0,0);

    }
}