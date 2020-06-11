import java.util.*;

public class algorithm_2206 {
	static int n;
    static int m;
    static int[][] arr;
    static boolean[][][] check;  // ���� �μ� ���� �μ��� ���� ��� �Ѵ� ���� üũ�ϱ� ����
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
        check[x][y][0] = true;  //�� �Ⱥμ�
        check[x][y][1] = true;  // �� �μ�
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
                    if(arr[px][py] == 0) {  // �� �ƴ�
                        if (check[px][py][0] == false && v.broken == false) { // ���� �ѹ��� �Ⱥμ� ���
                            queue.add(new Node(px, py, plevel, false));
                            num[px][py] = plevel;
                            check[px][py][0] = true;
                        } else if (check[px][py][1] == false && v.broken == true) { //���� �ѹ� �μ� ���
                            queue.add(new Node(px, py, plevel, true));
                            num[px][py] = plevel;
                            check[px][py][1] = true;  //���� �ѹ��̶� �μ� ���� ���� �Ⱥμ� ��庸�� ���� �����ϹǷ� 
                                                      //�湮 üũ�� �޸� ���ֱ� ���� 3�߹迭�� ó��
                        }
                    }else if(arr[px][py] == 1){ // ��

                        if (check[px][py][1] ==false && v.broken == false){ // ���� �ѹ��� �Ⱥμ� ��常 ���� �μ� �� ����
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
