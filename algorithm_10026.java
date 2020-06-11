import java.util.*;

public class algorithm_10026 {
	static char map[][];

	static int input[][];
	static int count=1;
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	static int n;
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		
		map=new char[n][n];
		input=new int[n][n];
		
		for(int i=0;i<n;i++) {
			String s=sc.next();
			for(int j=0;j<n;j++){
				map[i][j]=s.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(input[i][j]==0)
					bfs(i,j);
			}
		}
		System.out.print(count+" ");
		
		count=1;
		input=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]=='G')
					map[i][j]='R';
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(input[i][j]==0)
					bfs(i,j);
			}
		}
		System.out.print(count);
		
	}
	public static void bfs(int i,int j) {
		Queue<Integer> qx=new LinkedList();
		Queue<Integer> qy=new LinkedList();
		
		qx.add(i);
		qy.add(j);
		
		input[i][j]=count;
		
		char c=map[i][j];
		
		while(!qx.isEmpty()&&!qy.isEmpty()) {
			int x=qx.poll();
			int y=qy.poll();
			
			for(int w=0;w<4;w++) {
				int a=x+dx[w];
				int b=y+dy[w];
				if(a>=0&&a<n&&b>=0&&b<n) {
					if(map[a][b]==c) {
						qx.add(a);
						qy.add(b);
						
						input[a][b]=count;
					}
				}
			}
		}
		
		count++;
	}

}
