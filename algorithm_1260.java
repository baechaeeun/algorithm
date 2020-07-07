package algorithm_dfs;
import java.util.*;
public class algorithm_1260 {
	static int N,M,V;
	static int map[][];
	static int visit[];
	static Queue<Integer> result;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		V=sc.nextInt();
		
		map=new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			map[a][b]=1;
			map[b][a]=1;
		}
		result=new LinkedList<>();
		visit=new int[N+1];
		dfs(V);
		int size=result.size();
		for(int i=0;i<size-1;i++) {
			System.out.print(result.poll());
			System.out.print(" ");
		}
		System.out.println(result.poll());
		
		result=new LinkedList<>();
		visit=new int[N+1];
		bfs(V);
		size=result.size();
		for(int i=0;i<size-1;i++) {
			System.out.print(result.poll());
			System.out.print(" ");
		}
		System.out.println(result.poll());
		
	}
	public static void bfs(int V) {
		Queue<Integer> q=new LinkedList<>();
		
		q.add(V);
		result.add(V);
		visit[V]=1;
		
		while(!q.isEmpty()) {
			int a=q.poll();
			for(int i=1;i<=N;i++) {
				if(map[a][i]==1&&visit[i]==0) {
					q.add(i);
					result.add(i);
					visit[i]=1;
				}
			}
		}
	}
	public static void dfs(int V) {
		result.add(V);
		visit[V]=1;
		
		for(int i=1;i<=N;i++) {
			if(map[V][i]==1&&visit[i]==0) {
				dfs(i);
			}
		}
	}

}
