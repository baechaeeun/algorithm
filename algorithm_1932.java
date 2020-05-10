package algorithm;
import java.util.*;

public class algorithm_1932 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[][]=new int[n+1][n+1];
		int dp[][]=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=i;j++)
				array[i][j]=sc.nextInt();
		
		dp[1][1]=array[1][1];
		
		for(int i=2;i<=n;i++)
			for(int j=1;j<=i;j++) {
				if(j==1)
					dp[i][j]=array[i][j]+dp[i-1][1];
				else if(j==i)
					dp[i][j]=array[i][j]+dp[i-1][i-1];
				else
					dp[i][j]=array[i][j]+Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		int max=0;
		for(int i=1;i<=n;i++)
			max=Math.max(max, dp[n][i]);
		System.out.println(max);
	}
}
