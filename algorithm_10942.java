package algorithm;

import java.util.Scanner;

public class algorithm_10942 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[]=new int[n+1];
		int dp[][]=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++)
			array[i]=sc.nextInt();
		for(int i=1;i<=n;i++)
			dp[i][i]=1;
		
		for(int i=1;i<=n-1;i++) {
			if(array[i]==array[i+1])
				dp[i][i+1]=1;
		}
		
		for(int i=2;i<n;i++) {
			for(int j=1;j<=n-i;j++) {
				if(array[i]==array[i+j]&&dp[i+1][j+i-1]==1)
					dp[i][j]=1;
			}
		}
			
		int num=sc.nextInt();
		int s,e;
		boolean bool;
		
		for(int i=1;i<=num;i++) {
			s=sc.nextInt();
			e=sc.nextInt();
			System.out.println(dp[s][e]);
		}
	}
}
