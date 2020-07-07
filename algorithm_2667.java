package algorithm_dfs;
import java.util.*;
public class algorithm_2667 {

static int N;
	static int [][] map;
	static int [][] visit;
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,-1,1};
	static int [] result;
	static int sum=1;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		visit=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String st=sc.next();
			for(int j=0;j<N;j++) {
				map[i][j]=st.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&visit[i][j]==0) {
					dfs(i,j);
					sum++;
				}
			}
		}
		
		System.out.println(sum-1);
		result=new int[sum];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0) {
					result[map[i][j]]++;
				}
			}
		}
		
		Arrays.sort(result);
		for(int i=1;i<sum;i++) {
			System.out.println(result[i]);
		}
	}
	public static void dfs(int x,int y) {
		map[x][y]=sum;
		visit[x][y]=1;
		
		for(int i=0;i<4;i++) {
			int a=x+dx[i];
			int b=y+dy[i];
			
			if(a>=0&&a<N&&b>=0&&b<N) {
				if(map[a][b]==1&&visit[a][b]==0) {
					dfs(a,b);
				}
			}
		}
	}

}
