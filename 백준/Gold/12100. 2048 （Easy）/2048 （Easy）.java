import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int n;
    static int[][] arr2;
    static int[][] arr;

    static int max = 0;

    static void left(){

        //같은 것 합쳐주기

        for(int i= 0;i<n;i++){
            for(int j = 0;j<n-1;j++){
                if(arr[i][j] == 0) continue;
                int k;
                int ok = 0;
                for(k = j+1;k<n;k++){
                    if(arr[i][k] != 0) {
                        ok = 1;
                        break;
                    }
                }
                if(ok == 1 && arr[i][j] == arr[i][k]){
                    arr[i][j] = arr[i][j]*2;
                    arr[i][k] = 0;
                }
            }
        }

        //당기기
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int k =0;
                if(arr[i][j] == 0){
                    for(k = j+1;k<n;k++){
                       if(arr[i][k] != 0) {
                           arr[i][j] = arr[i][k];
                           arr[i][k] = 0;
                           break;
                       }
                    }

                }

            }
        }
    }

    static void right(){

        //같은 것 합쳐주기

        for(int i= 0;i<n;i++){
            for(int j = n-1;j>=1;j--){
                if(arr[i][j] == 0) continue;
                int k;
                int ok = 0;
                for(k = j-1;k>=0;k--){
                    if(arr[i][k] != 0) {
                        ok = 1;
                        break;
                    }
                }
                if(ok == 1 && arr[i][j] == arr[i][k]){
                    arr[i][j] = arr[i][j]*2;
                    arr[i][k] = 0;
                }
            }
        }

        //당기기
        for(int i = 0;i<n;i++){
            for(int j = n-1;j>=0;j--){
                int k =0;
                if(arr[i][j] == 0){
                    for(k = j-1;k>=0;k--){
                        if(arr[i][k] != 0) {
                            arr[i][j] = arr[i][k];
                            arr[i][k] = 0;
                            break;
                        }
                    }

                }

            }
        }
    }

    static void up(){

        //같은 것 합쳐주기

        for(int i= 0;i<n;i++){
            for(int j = 0;j<n-1;j++){
                if(arr[j][i] == 0) continue;
                int k;
                int ok = 0;
                for(k = j+1;k<n;k++){
                    if(arr[k][i] != 0) {
                        ok = 1;
                        break;
                    }
                }
                if(ok == 1 && arr[j][i] == arr[k][i]){
                    arr[j][i] = arr[j][i]*2;
                    arr[k][i] = 0;
                }
            }
        }

        //당기기
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int k =0;
                if(arr[j][i] == 0){
                    for(k = j+1;k<n;k++){
                        if(arr[k][i] != 0) {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = 0;
                            break;
                        }
                    }

                }

            }
        }
    }

    static void down(){

        //같은 것 합쳐주기

        for(int i= 0;i<n;i++){
            for(int j = n-1;j>=1;j--){
                if(arr[j][i] == 0) continue;
                int k;
                int ok = 0;
                for(k = j-1;k>=0;k--){
                    if(arr[k][i] != 0) {
                        ok = 1;
                        break;
                    }
                }
                if(ok == 1&& arr[j][i] == arr[k][i]){
                    arr[j][i] = arr[j][i]*2;
                    arr[k][i] = 0;
                }
            }
        }

        //당기기
        for(int i = 0;i<n;i++){
            for(int j = n-1;j>=0;j--){
                int k =0;
                if(arr[j][i] == 0){
                    for(k = j-1;k>=0;k--){
                        if(arr[k][i] != 0) {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = 0;
                            break;
                        }
                    }

                }

            }
        }
    }


    static int[] now = new int[5];

    static void jo(int n){
        if(n == 5){
            check();
           // print();
        }
        else{
            for(int i = 1;i<=4;i++){

                    now[n] = i;
                    jo(n+1);

            }
        }
    }

    static void print(){
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    static void check(){

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = arr2[i][j];
            }
        }

         //arr = arr2.clone();

        for(int i = 0;i<5;i++){
            //print();
            if(now[i] == 1){
                left();
                //print();
            }
            else if(now[i] == 2){
                right();
            }
            else if(now[i] == 3){
                up();
               // print();
            }
            else{
                down();
            }
        }

        /*

        for(int i = 0;i<5;i++) {
            System.out.printf(now[i] + " ");
        }
        System.out.println();*/

        /*for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();*/

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                max = Math.max(max,arr[i][j]);
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        arr2 = new int[n][n];
        arr = new int[n][n];


        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        jo(0);

        System.out.println(max);

    }
}