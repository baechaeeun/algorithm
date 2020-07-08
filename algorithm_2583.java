package algorithm_dfs;
import java.util.*;
public class algorithm_2583 {
	static int map[][];
	static int visit[][];
	static int M,N,K;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int count=1;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		K=sc.nextInt();
		
		map=new int[M][N];
		visit=new int[M][N];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=1;
			}
		}
		for(int i=0;i<K;i++) {
			int x,y,xx,yy;
			x=sc.nextInt();
			y=sc.nextInt();
			xx=sc.nextInt();
			yy=sc.nextInt();
			
			for(int j=y;j<=yy-1;j++) {
				for(int k=x;k<=xx-1;k++) {
					map[j][k]=0;
				}
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&visit[i][j]==0) {
					dfs(i,j);
					count++;
				}
			}
		}
		
		System.out.println(count-1);
		
		int result[]=new int[count];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0) {
					result[map[i][j]]++;
				}
			}
		}
		
		Arrays.sort(result);
		for(int i=1;i<count-1;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.print(result[count-1]);
		
	}
	public static void dfs(int x, int y) {
		map[x][y]=count;
		visit[x][y]=1;
		
		for(int i=0;i<4;i++) {
			int a=x+dx[i];
			int b=y+dy[i];
			
			if(a<0||a>=M||b<0||b>=N)
				continue;
			if(map[a][b]==1&&visit[a][b]==0)
				dfs(a,b);
		}
		
	}

}
