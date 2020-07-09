package algorithm_dfs;
import java.util.*;
public class algorithm_14502 {
	static int map[][];
	static int visit[][];
	static int virus[][];
	static int N,M;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int result;
	static int resultTmp;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		map=new int[N][M];
		visit=new int[N][M];
		virus=new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		Wall(0);
		
		System.out.println(result);
		
	}
	public static void Wall(int count) {
		if(count==3) {
			VirusSafe();
			return;
		}
		
		else {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0) {
						map[i][j]=1;
						Wall(count+1);
						map[i][j]=0;
					}
				}
			}
		}
	}
	public static void VirusSafe() {
		for(int i = 0 ; i < N ; i ++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				virus[i][j] = map[i][j];
			}
		}
		visit=new int[N][M];
		
		for(int i=0;i<N;i++) { //바이러스 전파
			for(int j=0;j<M;j++) {
				if(virus[i][j]==2&&visit[i][j]==0){
					dfs1(i,j);
				}
			}
		}
		
		resultTmp=0;
		for(int i = 0 ; i < N ; i ++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				if( virus[i][j] == 0 ) {
					
					resultTmp++;
				}
			}
		}
		result=Math.max(result, resultTmp);
		
	}
	public static void dfs1(int x,int y) {
		visit[x][y]=1;
		virus[x][y]=2;
		
		for(int i=0;i<4;i++) {
			int a=x+dx[i];
			int b=y+dy[i];
			
			if(a<0||a>=N||b<0||b>=M)
				continue;
			if(virus[a][b]==0&&visit[a][b]==0)
				dfs1(a,b);
		}
		
	}

}
