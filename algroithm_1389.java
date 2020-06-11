import java.util.*;
import java.io.*;
public class algroithm_1389 {
	static int map[][];
	static int res[][];
	static int visit[][];
	static int N,M;
	public static void main(String args[])throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[]friends=(LinkedList<Integer>[])new LinkedList[N+1];
		for(int i=1;i<=N;i++)
			friends[i]=new LinkedList<Integer>();
		
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			friends[u].add(v);
			friends[v].add(u);
		}
		int[]visit=new int[N+1];
		int[]result=new int[N+1];

		int min=Integer.MAX_VALUE;
		for(int i=1;i<=N;i++)
			{
			visit=new int[N+1];
			bfs(i,visit,friends);
			result[i]=sum(visit,N,i);
			min=Integer.min(min, result[i]);

			}
		

		for(int i=1;i<=N;i++){
			if(min==result[i]){
				System.out.println(i);
				return;
			}
		}


		
	}
	public static void bfs(int i,int[]visit,LinkedList<Integer>[]friends)

 {
			Queue<Integer> q=new LinkedList<>();
			int count=1;
			q.add(i);
			
			while(!q.isEmpty()) {
				int size=q.size();
				for(int j=0;j<size;j++) {
					int x=q.remove();
					for(int idx:friends[x]){
						if(visit[idx]==0){
							visit[idx]=count;
							q.add(idx);
						}
					}

				}
				count++;
			}
		
	}
	static int sum(int[]visit,int N,int idx){
		int sum=0;
		for(int i=1;i<=N;i++){
			if(idx==i){
				
			}else{
				sum+=visit[i];
			}
		}
		return sum;
	}

}
