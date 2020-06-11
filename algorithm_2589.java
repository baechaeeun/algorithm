import java.util.*;
public class algorithm_2589 {
	static char map[][];
	static int n,m;
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,1,-1};
	static int max=0;
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new char[n][m];
		
		for(int i=0;i<n;i++) {
			String s=sc.next();
			for(int j=0;j<m;j++) {
				map[i][j]=(char)(s.charAt(j));
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='L')
					bfs(i,j);
			}
		}
		System.out.println(max);
		
	}
	public static void bfs(int i,int j) {
		Queue<Integer> qx=new LinkedList<>();
		Queue<Integer> qy=new LinkedList<>();
		int visit[][]=new int[n][m];
		
		qx.add(i);
		qy.add(j);
		visit[i][j]=1;
		
		int count=0;
		while(!qx.isEmpty()&&!qy.isEmpty()) {
			count++;
			int size=qx.size();
			for(int k=0;k<size;k++) {
				int a=qx.poll();
				int b=qy.poll();
				
				for(int l=0;l<4;l++) {
					int x=a+dx[l];
					int y=b+dy[l];
					
					if(x<0||x>=n||y<0||y>=m)
						continue;
					if(visit[x][y]==1)
						continue;
					if(map[x][y]=='W')
						continue;
					qx.add(x);
					qy.add(y);
					visit[x][y]=1;
				}
			}	
		}
		count--;
		if(max<count)
			max=count;
	}
}
