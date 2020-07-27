package algorithm_ETC;
import java.util.*;
public class algorithm_2875 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		
		int team=0, mod;
		
		team=N/2;
		team=Math.min(team, M);
		
		mod=N-team*2+M-team;
		
		while(K!=0) {
			if(mod>0) {
				mod--;
				K--;
			}
			else if(mod==0) {
				team--;
				mod+=2;
				K--;
			}
		}
		System.out.println(team);
	}

}
