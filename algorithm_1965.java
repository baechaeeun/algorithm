package algorithm;
import java.util.*;

public class algorithm_1965 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int result=0;
		
		int array[]=new int[n+1];
		int dp[]=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			array[i]=sc.nextInt();
			dp[i]=1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(array[j]<array[i])
					dp[i]=Math.max(dp[i], dp[j]+1);
			}
			result=Math.max(result, dp[i]);
		}
		System.out.println(result);
	}

}
