import java.util.*;
import java.io.*;
import java.math.*;

class Node{
    Node left;
    Node right;

    int id;

    Node(Node l, Node r,  int id){
        left = l;
        right = r;

        this.id = id;
    }
}


public class Main {


    static Node root;

    static void insert(Node nn, int n){
        if(nn.id > n && nn.left == null){
            nn.left = new Node(null, null,n);
            return;
        }
        if(nn.id < n && nn.right == null){
            nn.right = new Node(null, null, n);
            return;
        }
        {
            if(nn.id > n){
                insert(nn.left, n);
            }
            else {
                 insert(nn.right, n);
            }
        }
    }

    static void pr(Node n){

        if(n.left != null) pr(n.left);
        if(n.right != null) pr(n.right);
        System.out.println(n.id);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ro = Integer.parseInt(br.readLine());

        root = new Node(null, null,  ro);


        while(true){
            String n = br.readLine();
            if(n == null || n.equals("")) break;

            int k = Integer.parseInt(n);

            insert(root, k);
            //System.out.println(k);
        }


        //System.out.println("kk");
        pr(root);



    }
}