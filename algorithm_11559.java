package algorithm_dfs;
import java.util.*;
public class algorithm_11559 {
	static char map[][];
	static int visit[][];
	static int result;
	static int count;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static char color;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		map=new char[12][6];
		result=0;
		
		for(int i=0;i<12;i++) {
			String st=sc.next();
			for(int j=0;j<6;j++) {
				map[i][j]=st.charAt(j);
			}
		}
		
		
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(map[i][j]!='.') {
					visit=new int[12][6];
					count=1;
					color=map[i][j];
					qx=new LinkedList<>();
					qy=new LinkedList<>();
					dfs(i,j);
					
					if(count>=4) {
						int size=qx.size();
						for(int k=0;k<size;k++) {
							int a=qx.poll();
							int b=qy.poll();
							map[a][b]='.';
						}
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}
	public static void dfs(int x,int y) {
		
		for(int i=0;i<4;i++) {
			int a=x+dx[i];
			int b=y+dy[i];
			
			if(a<0||a>=12||b<0||b>=6)
				continue;
			if(visit[a][b]==1)
				continue;
			if(map[a][b]==color) {
				count++;
				visit[a][b]=1;
				qx.add(a);
				qy.add(b);
				dfs(a,b);
			}
			
		}
	}

}
