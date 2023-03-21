
import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
   
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int a = Integer.parseInt(br.readLine());
      int b = Integer.parseInt(br.readLine());
      
      int start = (a/100)*100;
      
      //System.out.println(start);
      
      for(int i = 0;i<=99;i++) {
    	  
    	  if((start + i)%b == 0) {
    		  if(i<=9) {
    			  System.out.printf("0" + i);
    		  }
    		  else System.out.println(i);
    		  return;
    		  
    	  }
      }
      
      
      
   }
}

