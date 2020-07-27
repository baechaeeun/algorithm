package algorithm_ETC;
import java.util.*;
public class algorithm_11399 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int result=0;
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
			arr.add(sc.nextInt());
		
		Collections.sort(arr);
	
		int tmp=0;
		for(int i=0;i<n;i++) {
			tmp+=arr.get(i);
			result+=tmp;
		}
		System.out.println(result);
	}

}
