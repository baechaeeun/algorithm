package algorithm_dfs;
import java.util.*;
public class algorithm_2468 {
	static int [][] map;
	static int [][] visit;
	static int n;
	static int max=0;
	static int result=0;
	static int count;
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,-1,1};
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		map=new int[n][n];
		visit=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
				if(max<map[i][j])
					max=map[i][j];
			}
		}
		
		for(int i=0;i<=max;i++) {
			count=0;
			visit=new int[n][n];
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(i<map[j][k]&&visit[j][k]==0) {
						dfs(j,k,i);
						count++;
					}
				}
			}
			if(result<count)
				result=count;
		}
		
		System.out.println(result);
	}
	public static void dfs(int x,int y,int height) {
		visit[x][y]=1;
		
		for(int i=0;i<4;i++) {
			int a=x+dx[i];
			int b=y+dy[i];
			
			if(a<0||a>=n||b<0||b>=n)
				continue;
			if(height<map[a][b]&&visit[a][b]==0)
				dfs(a,b,height);
		}
	}

}
