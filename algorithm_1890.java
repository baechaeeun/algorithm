package algorithm;
import java.util.*;
public class algorithm_1890 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[][]=new int[n+1][n+1];
		long dp[][]=new long [n+1][n+1];
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				array[i][j]=sc.nextInt();
		
		dp[1][1]=1;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++) {
				if(dp[i][j]==0)
					continue;
				if(j+array[i][j]<=n)
					dp[i][j+array[i][j]]+=dp[i][j];
				if(i+array[i][j]<=n)
					dp[i+array[i][j]][j]+=dp[i][j];
			}
		
		System.out.println(dp[n][n]);
	}

}
