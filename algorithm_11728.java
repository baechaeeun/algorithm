package algorithm_ETC;
import java.util.*;
import java.io.*;
public class algorithm_11728 {
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] input=br.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1]);
		
		int [] array=new int[n+m];
		
		input=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(input[i]);	
		}
		
		input=br.readLine().split(" ");
		for(int i=0;i<m;i++) {
			array[i+n]=Integer.parseInt(input[i]);
		}
		
		Arrays.sort(array);
		
		for(int i=0;i<n+m;i++)
			System.out.print(array[i]+" ");
	}

}
