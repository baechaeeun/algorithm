package algorithm_dfs;
import java.util.*;
public class algorithm_11403 {
	static int [][] graph;
	static int [][] path;
	static boolean[] visit;
	static int N;
	
	public static void dfs(int x, int y) {
		visit[y] = true;
		path[x][y] = 1;
		
		for(int i=0; i<N; i++) {
			if(graph[y][i] == 1 && visit[i] == false) {
				dfs(x, i);
			}
		}

	}
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		graph=new int [N][N];
		path=new int[N][N];
		visit=new boolean[N];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				graph[i][j]=sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visit[j] = false;	// 행(i) 마다 경로를 탐색해야 하므로 방문한곳 초기화
			}

			for(int j=0; j<N; j++) {
				if(graph[i][j] == 1 && visit[j] == false) {
					dfs(i, j);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}

	}

}
