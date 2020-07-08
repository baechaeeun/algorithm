package algorithm_dfs;
import java.util.*;
public class algorithm_2146 {
	static int [][] map;
	static int [][] visit;
	static int N;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int count=1; 
	static int result;
	static int num=0;
	static int []arr1;
	static int []arr2;
	static int []arr3;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		visit=new int[N][N];
		result=N*N;
		arr1=new int[N*N];
		arr2=new int[N*N];
		arr3=new int[N*N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}

	
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&visit[i][j]==0) {
					dfs(i,j);
					count++;
				}
			}
		}
	
	
		
		for(int i=0;i<num;i++) {
			visit=new int[N][N];
			int a=arr1[i];
			int b=arr2[i];
			int type=arr3[i];
			result=Math.min(result, bfs(a,b,type));
			
		}

		System.out.println(result);
	}
	public static int bfs(int x,int y,int type) {
		Queue<Integer> qx=new LinkedList<>();
		Queue<Integer> qy=new LinkedList<>();
		int result=0;
		
		qx.add(x);
		qy.add(y);
		
		while(!qx.isEmpty()) {
			int size=qx.size();
			result++;
			
			for(int i=0;i<size;i++) {
				int a=qx.poll();
				int b=qy.poll();

				
				if(map[a][b]>1)
					return result-1;
				
				visit[a][b]=1;
				
				for(int j=0;j<4;j++) {
					int aa=a+dx[j];
					int bb=b+dy[j];
					
					if(aa<0||aa>=N||bb<0||bb>=N)
						continue;
					if(map[aa][bb]!=type&&visit[aa][bb]==0) {
						qx.add(aa);
						qy.add(bb);
					}
				}
			}	
		}
		return N*N;
	}
	public static void dfs(int x,int y) {
		color(x,y);
		visit[x][y]=1;
		map[x][y]=count;
		
		for(int i=0;i<4;i++) {
			int a=x+dx[i];
			int b=y+dy[i];
			
			if(a<0||a>=N||b<0||b>=N)
				continue;
			if(map[a][b]==1&&visit[a][b]==0) {
				dfs(a,b);
			}
		}
		
	}
	public static void color(int x,int y) {
		for(int k=0;k<4;k++) {
			int a=dx[k]+x;
			int b=dy[k]+y;
			
			if(a<0||a>=N||b<0||b>=N)
				continue;
			if(map[a][b]==0) {
				arr1[num]=a;
				arr2[num]=b;
				arr3[num]=count;
				num++;
			}
		}
	}

}
