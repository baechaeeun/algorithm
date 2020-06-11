import java.util.*;
public class algorithm_5014 {
	static int F,S,G;
	static int [] move=new int[2];
	static int []map;
	static int []visit;
	static int max;
	static int count=0;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		F=sc.nextInt();
		S=sc.nextInt();
		G=sc.nextInt();
		move[0]=sc.nextInt();
		move[1]=-(sc.nextInt());
		
		map=new int[F+1];
		visit=new int[F+1];
		
		System.out.println(bfs()?count:"use the stairs");
		
		
	}
	public static boolean bfs() {
		Queue<Integer> q=new LinkedList<>();
		
		q.add(S);
		visit[S]=1;
		
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				int a=q.poll();
				
				if(a==G)
					return true;
				
				for(int j=0;j<2;j++) {
					int x=a+move[j];
					if(1>x||F<x)
						continue;
					if(visit[x]==1)
						continue;
					q.add(x);
					visit[x]=1;
				
				}
			}
			count++;
		}
		return false;
	}

}
