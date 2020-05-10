package algorithm;
import java.util.*;

public class algorithm_9252 {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		String x[] = s1.split("");
		String y[] = s2.split("");
		
		
		int c[][] = new int[x.length+1][y.length+1];
		
		for(int i=0; i<(x.length+1); i++) {
			c[i][0] = 0;
		}
		for(int j=0; j<(y.length+1); j++) {
			c[0][j] = 0;
		}
		
		for(int i=0; i<x.length; i++) {
			for(int j=0; j<y.length; j++) {
				if( x[i].equals(y[j]) ) {
					c[i+1][j+1] = c[i][j] +1;
					
				}
				else {
					c[i+1][j+1] = Math.max(c[i+1][j], c[i][j+1]);
				}
			}
		}
		
		System.out.println(c[x.length][y.length]);
		
		String result = "";
		int a = x.length;
		int b = y.length;
		
		while(c[a][b] != 0) {
			if(c[a][b] == c[a-1][b]) a--;
			else if(c[a][b]==c[a][b-1]) b--;
			else {
				result = x[a-1] + result;
				a--;
				b--;
			}
		}
		System.out.println(result);
		
		
	}

}
