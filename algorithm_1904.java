package algorithm;
import java.util.*;
public class algorithm_1904 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int array [] =new int [n+1];
		
		if(n>=1)
			array[1]=1;
		if(n>=2)
			array[2]=2;
		
		for(int i=3;i<=n;i++) {
			array[i]=(array[i-1]+array[i-2])%15746;
		}
		
		System.out.println(array[n]%15746);
	}

}
