import java.util.*;


public class algorithm_14502 {

	static int map[][];
	static int input[][];
	static int virus[][];
	
	static int N ;
	static int M ;
	static int answer=0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		input = new int[N][M];
		virus = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				input[i][j] = map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < N ; i ++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				if( input[i][j] == 0 ) {
					
					map[i][j] = 1 ;
					
					dfs(1);
					
					map[i][j] = 0 ;
					
				}
			}
		}
		System.out.println(answer);	
	}
	
	static public void dfs(int count){
		
		if( count == 3 )
		{
			bfs();
			return;
			
		}else{
			for(int i = 0 ; i < N ; i ++)
			{
				for(int j = 0 ; j < M ; j++)
				{
					if( map[i][j] == 0 ) {
						
						map[i][j] = 1 ;
						dfs(count+1);
						map[i][j] = 0 ;
						
					}
				}
			}			
			
		}
		
		
	}
	
	
	static public void bfs(){
		
		Queue<Integer> qx = new LinkedList();
		Queue<Integer> qy = new LinkedList();
		
		for(int i = 0 ; i < N ; i ++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				virus[i][j] = map[i][j];
			}
		}
		
		for(int i = 0 ; i < N ; i ++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				if(virus[i][j] == 2) {
					
					qx.add(i);
					qy.add(j);
					
					
					int [] dx = {0,0,-1,1};
					int [] dy = {-1,1,0,0};
					
					
					
					while(!qx.isEmpty() && !qy.isEmpty()){
						
						int DataX = qx.poll();
						int DataY = qy.poll();
						
						
						for(int k = 0 ; k < 4 ; k++){
							
							int X = DataX + dx[k];
							int Y = DataY + dy[k];
						
						    if( X>=0 && X <N && Y>=0 && Y<M )
						    {
						    	if(virus[X][Y] == 0) {
						    		virus[X][Y] = 2 ; 
						    		qx.add(X);
						    		qy.add(Y);
						    	}
						    }
						}
					}
				}
			}
		}
		
		int count = 0 ;
		
		for(int i = 0 ; i < N ; i ++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				if( virus[i][j] == 0 ) {
					
					count++;
				}
			}
		}
		
		if(answer < count ) {
			answer = count;
		}
	}

}

