package algorithm_dfs;
import java.util.*;
public class algorithm_11724_bfs {
	static int map[][];
	static int visit[];
	static int N,M;
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		int result=0;
		
		map=new int[N+1][N+1];
		visit=new int[N+1];
		
		for(int i=1;i<=M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			map[a][b]=1;
			map[b][a]=1;
	
		}
		
		for(int i=1;i<=N;i++) {
			if(visit[i]==0) {
				bfs(i);
				result++;
			}
		}
		System.out.println(result);
	}
	public static void bfs(int a) {
		Queue<Integer> q=new LinkedList<>();
		
		q.add(a);
		
		while(!q.isEmpty()) {
			int x=q.poll();
				
			for(int j=1;j<=N;j++) {
				if(map[x][j]==1&&visit[j]==0) {
					q.add(j);
					visit[j]=1;
				}
			}
			
		}
	}

}
