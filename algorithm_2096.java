package algorithm;
import java.util.*;

public class algorithm_2096 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i,j,max,min,n = sc.nextInt();
		int d[][] = new int[n+1][4], a[][] = new int[n+1][4];
		for(i=1;i<=n;i++)
			for(j=1;j<=3;j++)
				a[i][j] = sc.nextInt();
		
		d[0][1] = d[0][2] = d[0][3] = 0;	
		
		for(i=1;i<=n;i++){
			d[i][1] = Max(d[i-1][1], d[i-1][2])+a[i][1];
			d[i][2] = Max(d[i][1]-a[i][1], d[i-1][3])+a[i][2];
			d[i][3] = Max(d[i-1][2], d[i-1][3])+a[i][3];
		}
		max = Max(d[n][1],Max(d[n][2], d[n][3]));
		
		for(i=1;i<=n;i++){
			d[i][1] = Min(d[i-1][1], d[i-1][2])+a[i][1];
			d[i][2] = Min(d[i][1]-a[i][1], d[i-1][3])+a[i][2];
			d[i][3] = Min(d[i-1][2], d[i-1][3])+a[i][3];
		}
		min = Min(d[n][1],Min(d[n][2], d[n][3]));
		
		System.out.println(max+" "+min);
		sc.close();
	}
	public static int Max(int a, int b) { return a > b ? a : b; }
	public static int Min(int a, int b) { return a < b ? a : b; }
}
