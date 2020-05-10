package algorithm;

import java.util.Scanner;

public class algorithm_2167 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int array[]=new int [n*m+1];
		
		for(int i=1;i<=n*m;i++)
			array[i]=sc.nextInt();
		
		int num=sc.nextInt();
		int i,j,x,y;
		
		for(int a=0;a<num;a++) {
			i=sc.nextInt();
			j=sc.nextInt();
			x=sc.nextInt();
			y=sc.nextInt();
			int sum=0;
			for(int b=i*j;b<=x*y;b++)
				sum+=array[b];
			System.out.println(sum);
		}
	}

}
