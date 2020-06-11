import java.util.*;

public class algorithm_2206 {
	static int n;
    static int m;
    static int[][] arr;
    static boolean[][][] check;  // 벽을 부순 경우와 부수지 않은 경우 둘다 따로 체크하기 위함
    static int[][] num;
    static int[] cx = {-1,1,0,0};
    static int[] cy = {0,0,-1,1};
    
    static class Node{
        int x;
        int y;
        int level;
        boolean broken;
        Node(int x, int y, int level, boolean broken){
            this.x = x;
            this.y = y;
            this.level =level;
            this.broken = broken;
        }
    }
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        check = new boolean[n][m][2];
        arr = new int[n][m];
        num = new int[n][m];

        for(int i=0; i<n; i++){
           String[] temp = scan.next().split("");
           for(int j=0; j<m; j++){
               arr[i][j]=Integer.parseInt(temp[j]);
           }
        }
        bfs(0,0);
    }
	
	public static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        check[x][y][0] = true;  //벽 안부숨
        check[x][y][1] = true;  // 벽 부숨
        queue.add(new Node(x,y,1, false));

        while(!queue.isEmpty()){
            Node v = queue.poll();
            if(v.x == n-1 && v.y == m-1) {
                System.out.println(v.level);
                return;
            }
            for(int i=0; i<4; i++){
                int px = v.x + cx[i];
                int py = v.y + cy[i];
                int plevel = v.level+1;
                if(px>=0 && px<n && py>=0 && py<m){
                    if(arr[px][py] == 0) {  // 벽 아님
                        if (check[px][py][0] == false && v.broken == false) { // 벽을 한번도 안부순 노드
                            queue.add(new Node(px, py, plevel, false));
                            num[px][py] = plevel;
                            check[px][py][0] = true;
                        } else if (check[px][py][1] == false && v.broken == true) { //벽을 한번 부순 노드
                            queue.add(new Node(px, py, plevel, true));
                            num[px][py] = plevel;
                            check[px][py][1] = true;  //벽을 한번이라도 부순 노드는 벽을 안부순 노드보다 일찍 도착하므로 
                                                      //방문 체크를 달리 해주기 위해 3중배열로 처리
                        }
                    }else if(arr[px][py] == 1){ // 벽

                        if (check[px][py][1] ==false && v.broken == false){ // 벽을 한번도 안부순 노드만 벽을 부술 수 있음
                            queue.add(new Node(px,py,plevel, true));
                            num[px][py] = plevel;
                            check[px][py][1] = true;
                        }

                    } // end if(check)
                }// end if(px...)
            }// end for
        }// end while
        System.out.println(-1);
    }
		
}
