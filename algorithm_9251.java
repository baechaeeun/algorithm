package algorithm;
import java.util.*;
public class algorithm_9251 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		
		int i,j=0;
        int[][] arr = new int[str1.length()+1][str2.length()+1];

		
		for(i=1;i<=str1.length();i++) {
			for(j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					arr[i][j]=arr[i-1][j-1]+1;
				}
				else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
			
		}
		System.out.println(arr[str1.length()][str2.length()]);

	}
}
