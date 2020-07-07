package algorithm_dfs;
import java.util.*;
public class algorithm_1987 {
	static char [][] map;
	static int [][] visit;
	static int R,C;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int max;
	static HashSet<Character> set=new HashSet<>();
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		R=sc.nextInt();
		C=sc.nextInt();
		map=new char[R][C];
		visit=new int[R][C];
		
		for(int i=0;i<R;i++) {
			String st=sc.next();
			for(int j=0;j<C;j++) {
				map[i][j]=st.charAt(j);
			}
		}
		
		set.add(map[0][0]);
		visit[0][0]=1;
		dfs(0,0,1);
		
		System.out.println(max);
	}
	public static void dfs(int x,int y,int res) {
		if(max<res)
			max=res;
		
		for(int i=0;i<4;i++) {
			int a=x+dx[i];
			int b=y+dy[i];
			if(a<0||a>=R||b<0||b>=C)
				continue;
			if(visit[a][b]==1)
				continue;
			int size=set.size();
			set.add(map[a][b]);
			if(size==set.size())
				continue;
			
			visit[a][b]=1;
			dfs(a,b,res+1);
			visit[a][b]=0;
			set.remove(map[a][b]);
		}
	}

}
