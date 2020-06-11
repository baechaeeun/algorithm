import java.util.*;
public class algorithm_1707 {
	static boolean check=false;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int ts=1;ts<=T;ts++) {
			int V=sc.nextInt();
			int E=sc.nextInt();
			List<Integer>[] list=new ArrayList[V+1];
			check=false;
			
			for(int i=0;i<V+1;i++) {
				list[i]=new ArrayList<>();
			}
			int color[]=new int[V+1];
			
			for(int i=0;i<E;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				
				list[a].add(b);
				list[b].add(a);
			}
			
			for(int i=1;i<V+1;i++) {
				if(check)
					break;
				if(color[i]==0)
					bfs(list,i,1,color);
			}
			System.out.println(check?"NO":"YES");
		}
		
	}
	
	static void bfs(List<Integer>[] list,int start,int RedOrBlue,int[] color) {
		Queue<Integer> q=new LinkedList<>();
		
		q.add(start);
		color[start]=RedOrBlue;
		
		while(!q.isEmpty()) {
			int v=q.poll();
			for(int adj:list[v]) {
				if (color[adj] == 0) {
					q.add(adj);
					color[adj] = color[v] * -1;
					// -1Àº Blue
				} else if (color[adj] + color[v] != 0) {
					check = true;
					return;
				}

			}
		}
	}
}
