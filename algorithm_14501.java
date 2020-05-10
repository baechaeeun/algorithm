package algorithm;
import java.util.*;
public class algorithm_14501 {
	static int n;
	static int[][] array;
	static int[] dp;
	static int max;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		array=new int [n+1][2];
		dp=new int [n+1];
		max=0;
		/*for(int i=1;i<=n;i++) {
				if(i+array[i][0]>n) {
					max=Math.max(max, dp[i]);
					break;
				}
				dp[i+array[i][0]]+=(array[i][1]+dp[i]);
		}*/
		System.out.println(max);
	}
	public static void res(int day) {
		if(day>=n) {
			max=Math.max(max, dp[day]);
			return;
		}
		else {
			dp[day+array[day][0]]+=array[day][1]+dp[day];
			res(day+array[day][0]);
		}
	}
}
