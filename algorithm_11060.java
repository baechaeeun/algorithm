package algorithm;
import java.util.*;
public class algorithm_11060 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[]=new int[n+1];
		int dp[]=new int[n+1];
		
		for(int i=2;i<=n;i++)
			dp[i]=1001;
		
		for(int i=1;i<n;i++) {
			if(array[i]<=1000) {
				int next=i+array[i];
				if(next>1000)
					next=1000;
				for(int j=1;j<=next;j++) {
					dp[j]=Math.min(dp[j], dp[i]+1);
				}
			}
		}
		if(dp[n]>=1000)
			System.out.println(-1);
		else
			System.out.println(dp[n]);
	}

}
