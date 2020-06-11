
import java.util.*;
public class algorithm_2644 {
	static int n;
	static int a,b;
	static int map[][];
	static int input[];
	static boolean check[];
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n+1][n+1];
		
		check=new boolean[n+1];
		input=new int[n+1];
		
		a=sc.nextInt();
		b=sc.nextInt();
		
		int num=sc.nextInt();
		
		for(int i=1;i<=num;i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				map[x][y]=map[y][x]=1;
		}
		bfs();
		
	}
	
	public static void bfs() {
		Queue<Integer> qx=new LinkedList<Integer>();

		qx.add(a);
		check[a]=true;
		
		while(!qx.isEmpty()) {
			int x=qx.remove();
			
			for(int i=1;i<=n;i++) {
				if(map[x][i]==1&&!check[i]) {
					input[i]=input[x]+1;
					check[i]=true;
					qx.add(i);
				}
			}
		}
		
		if(input[b]==0)
			System.out.println(-1);
		else
			System.out.println(input[b]);
	}

}
