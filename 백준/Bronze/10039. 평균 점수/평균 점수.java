
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int a = Integer.parseInt(br.readLine());
    	int b = Integer.parseInt(br.readLine());
    	int c = Integer.parseInt(br.readLine());
    	int d = Integer.parseInt(br.readLine());
    	int e = Integer.parseInt(br.readLine());
    	
    	if(a<40) a = 40;
    	if(b<40) b = 40;
    	if(c<40) c = 40;
    	if(d<40) d = 40;
    	if(e<40) e = 40;
    	
    	System.out.println((a+b+c+d+e)/5);
    	
}
    
}
    


