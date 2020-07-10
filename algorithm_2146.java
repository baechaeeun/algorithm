package algorithm_dfs;
import java.util.*;
public class algorithm_2146 {
	static int N;
	static int map[][];
	static int visit[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,1,1};
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		visit=new int[N][N];
		int result=Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
	
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&visit[i][j]==0) {
					dfs(i,j);
					result=Math.min(result, leg_one_to_two());
					leg_two_to_one();
				}
			}
		}
		
		System.out.println(result);
		
	}
	public static void leg_two_to_one() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {		
				if(map[i][j]==2)
					map[i][j]=1;
				}
		}
	}
	public static int leg_one_to_two() {
		Queue<Integer> qx=new LinkedList<>();
		Queue<Integer> qy=new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==2) {
					for(int k=0;k<4;k++) {
						int a=i+dx[k];
						int b=j+dy[k];
						
						if(a<0||a>=N||b<0||b>=N)
							continue;
						if(map[a][b]==0&&visit[a][b]==0) {
							qx.add(a);
							qy.add(b);
							visit[a][b]=1;
						}
					}
				}
			}
		}
		
		int result=0;
		
		while(!qx.isEmpty()) {
			result++;
			int size=qx.size();
			
			for(int i=0;i<size;i++) {
				int a=qx.poll();
				int b=qy.poll();
				visit[a][b]=1;
				
				for(int j=0;j<4;j++) {
					int x=a+dx[j];
					int y=b+dy[j];
					
					if(x<0||x>=N||y<0||y>=N)
						continue;
					if(map[x][y]==1)
						return result;
					else if(map[x][y]==0&&visit[x][y]==0) {
						qx.add(x);
						qy.add(y);
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	public static void dfs(int x,int y) {
		Queue<Integer> qx=new LinkedList<>();
		Queue<Integer> qy=new LinkedList<>();
		
		qx.add(x);
		qy.add(y);
		visit[x][y]=1;
		map[x][y]=2;
		
		while(!qx.isEmpty()) {
			int j=qx.poll();
			int k=qy.poll();
			
			for(int i=0;i<4;i++) {
				int a=j+dx[i];
				int b=k+dy[i];
				
				if(a<0||a>=N||b<0||b>=N)
					continue;
				if(map[a][b]==1&&visit[a][b]==0) {
					qx.add(a);
					qy.add(b);
					visit[a][b]=1;
					map[a][b]=2;
				}
			}
		}
	}
}
