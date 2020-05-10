package algorithm;
import java.util.*;

public class algorithm_6359 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int array[]=new int[n+1];
		int dp[]=new int[101];
		int dpp[]=new int[101];
		
		
		for(int i=1;i<=n;i++)
			array[i]=sc.nextInt();
		
		for(int i=1;i<=100;i++) {
			for(int j=1;j*i<=100;j++) {
				if(dp[j*i]==0)
					dp[j*i]=1;
				else
					dp[i*j]=0;
			}
			for(int j=1;j<=i;j++)
				if(dp[j]==1)
					dpp[i]++;
		}

		for(int i=1;i<=n;i++)
			System.out.println(dpp[array[i]]);
	}
}
