import java.util.*;
import java.io.*;
public class algorithm_2573 {
	static int map[][];
	static int visit[][];
	static int result[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int n,m;
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;

		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
	
		int count=0;
		loop:
		while(true) {
			result=new int[n][m];
			visit=new int[n][m];
			boolean first=false;
			for(int i=1;i<n-1;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]!=0) {
						if(visit[i][j]==0&&first)
							break loop;
						else {
							bfs(i,j);
							first=true;
						}
					}
				}
			}
			count++;
		}
		System.out.println(count);
	}

	public static void bfs(int i,int j) {
		Queue<Integer> qx=new LinkedList<>();
		Queue<Integer> qy=new LinkedList<>();
		visit=new int[n][m];
		
		qx.add(i);
		qy.add(j);
		visit[i][j]=1;
		
		while(!qx.isEmpty()&&!qy.isEmpty()) {
			int a=qx.poll();
			int b=qy.poll();
			
			int res=0;
			for(int k=0;k<4;k++) {
				int x=a+dx[k];
				int y=b+dy[k];
			
				if(x<0||x>=n||y<0||y>=m)
					continue;
				if(map[x][y]==0&&visit[x][y]==0) {
					res++;
					continue;
				}
				if(visit[x][y]==1)
					continue;
				qx.add(x);
				qy.add(y);
				visit[x][y]=1;
			}
			if(map[a][b]-res<=0)
				result[a][b]=0;
			else
				result[a][b]=map[a][b]-res;
		}
	
		
	}
}
