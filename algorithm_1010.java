package algorithm;
import java.util.*;
public class algorithm_1010 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int n,m;
		
		int dp[][]=new int[31][31];
		
		for(int i=1;i<=30;i++) {
			dp[i][0]=1;
			dp[i][i]=1;
		}
		
		for(int i=2;i<=30;i++) {
			for(int j=1;j<i;j++) {
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		
		for(int i=1;i<=num;i++) {
			n=sc.nextInt();
			m=sc.nextInt();

			System.out.println(dp[m][n]);
			
		}
	}

}
