package algorithm;
import java.util.*;
public class algorithm_1520 {
	static Scanner sc = new Scanner(System.in);

	static int m = sc.nextInt();
	static int n = sc.nextInt();
	
	static int[][] map = new int[m][n];
	static int[][] end = new int[m][n];
	
	static int count = 0;

	public static void main(String args[]) {
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		move(0,0);
		System.out.println(count);
		
	}
	static void move(int i, int j) {
		// j,i 가 index 범위를 벗어나면 아무것도 하지 않음.
		if(j < 0 || i < 0 || j >= n || i >= m)
			;
		else {
			if(i == m-1 && j == n-1) count++;
			else {
				int go = 0;
				if(i != 0 && map[i][j] > map[i-1][j] && end[i-1][j] != -1) { move(i-1,j); go++;}
				if(i != m-1 && map[i][j] > map[i+1][j] && end[i+1][j] != -1) { move(i+1,j); go++;}
				if(j != 0 && map[i][j] > map[i][j-1] && end[i][j-1] != -1) { move(i,j-1); go++;}
				if(j != n-1 && map[i][j] > map[i][j+1] && end[i][j+1] != -1) { move(i,j+1); go++;}
				
				if(go == 0) end[i][j] = -1;
			}
		}
	}

}
