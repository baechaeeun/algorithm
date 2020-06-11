import java.io.*;
import java.util.*;
public class algorithm_3055 {
	static char map[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static boolean visitS[][];
	static boolean visitW[][];
	static int R,C;
	static int count=0;
	
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		map=new char[R][C];
		visitS=new boolean[R][C];
		visitW=new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String s=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		bfs();
		
		System.out.println(count);
	}
	
	public static void bfs() {
		Queue<int[]> waterqueue=new LinkedList<>();
		Queue<int[]> queue=new LinkedList<>();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='*'&&!visitW[i][j])
					waterqueue.offer(new int[] {i,j});
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='S'&&!visitS[i][j])
					queue.offer(new int[] {i,j});
			}
		}
		
		while(true) {
			count++;
			int watersize=waterqueue.size();
			
			for(int a=0;a<watersize;a++) {
				int qx=waterqueue.peek()[0];
				int qy=waterqueue.peek()[1];
				
				waterqueue.poll();
				
				for(int i=0;i<4;i++) {
					int nx=qx+dx[i];
					int ny=qy+dy[i];
					
					if(nx<0||ny<0||nx>=R||ny>=C)
						continue;
					
					if(map[nx][ny]=='D'||map[nx][ny]=='X')
						continue;
					
					if(visitW[nx][ny])
						continue;
					
					waterqueue.offer(new int[] {nx,ny});
					visitW[nx][ny]=true;
					map[nx][ny]='*';
				}
			}
			
			if(queue.isEmpty()) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			
			int size=queue.size();
			for(int a=0;a<size;a++) {
				int sx=queue.peek()[0];
				int sy=queue.peek()[1];
				queue.poll();
				for(int i=0;i<4;i++) {
					int nx=sx+dx[i];
					int ny=sy+dy[i];
					
					if(nx<0||ny<0||nx>=R||ny>=C)
						continue;
					if(map[nx][ny]=='*'||map[nx][ny]=='X')
						continue;
					if(visitS[nx][ny])
						continue;
					if(map[nx][ny]=='D')
						return;
					queue.offer(new int[] {nx,ny});
					visitS[nx][ny]=true;
				}
			}
			
			
		}
			
				
			
		
	}

}
