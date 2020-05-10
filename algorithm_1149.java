package algorithm;
import java.util.*;
public class algorithm_1149 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int array[][]=new int[n][3];
		int dp[][]=new int[n][3];
		
		for(int i=0;i<n;i++) 
			for(int j=0;j<3;j++)
				array[i][j]=sc.nextInt();
		
		dp[0][0]=array[0][0];
		dp[0][1]=array[0][1];
		dp[0][2]=array[0][2];
		
		for(int i=1;i<n;i++) {
			dp[i][0]=array[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1]=array[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2]=array[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
		}
		System.out.println(Math.min(dp[n-1][2],Math.min(dp[n-1][0], dp[n-1][1])));
	}

}
