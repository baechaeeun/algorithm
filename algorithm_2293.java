package algorithm;
import java.util.*;
public class algorithm_2293 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] array = new int[n + 1];
		int[] dp = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			array[i] = sc.nextInt();
		}

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= array[i])
					dp[j] += dp[j - array[i]];
			}
		}
		
		System.out.println(dp[k]);

	}

}
