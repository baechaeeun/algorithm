package algorithm;
import java.util.*;
import java.util.Arrays;

public class algorithm_2294 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		int sum=sc.nextInt();
		int []array=new int [num+1];
		int []dp=new int[sum+1];
		int result=0;
		
		for(int i=1;i<=num;i++)
			array[i]=sc.nextInt();
		for(int i=1;i<=sum;i++) {
			dp[i]=100001;
		}
		
		
		for(int i=1;i<=num;i++) {
			for(int j=array[i];j<=sum;j++)
				dp[j]=Math.min(dp[j], dp[j-array[i]]+1);
		}
		
		if(dp[sum]==100001)
			dp[sum]=-1;
		System.out.println(dp[sum]);
	}

}
