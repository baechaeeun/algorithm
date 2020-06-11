import java.util.*;
import java.io.*;
public class algorithm_7562 {
	static int num;
	static int dx[]= {-2,-1,1,2,2,1,-1,-2};
	static int dy[]= {1,2,2,1,-1,-2,-2,-1};
	static int sx,sy;
	static int fx,fy;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static boolean finish=false;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count;
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			count=0;
			finish=false;
			num=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			sx=Integer.parseInt(st.nextToken());
			sy=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			fx=Integer.parseInt(st.nextToken());
			fy=Integer.parseInt(st.nextToken());
			
			qx=new LinkedList<Integer>();
			qy=new LinkedList<Integer>();
					
			qx.add(sx);
			qy.add(sy);
					
			bfs(count+1);

		}
		
	}
	public static void bfs(int count) {
		if(finish||qx.isEmpty()||qy.isEmpty())
			return;
		
		int a=qx.poll();
		int b=qy.poll();
			
		for(int i=0;i<8;i++) {
				
			int x=a+dx[i];
			int y=b+dy[i];
				
			if(x>=0&&x<=num&&y>=0&&y<=num) {
				if(x==fx&&y==fy) {
					System.out.println(count);
					finish=true;
					return;
				}
				qx.add(x);
				qy.add(y);
				bfs(count+1);
			}
		}
		
	}
}
