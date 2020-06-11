import java.util.*;
public class algorithm_13460 {
	static char [][] map;
	static int [][]input;
	static int n,m;
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			String s=sc.next();
			for(int j=0;j<m;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		
	}

}
