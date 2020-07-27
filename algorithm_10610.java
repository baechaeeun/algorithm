package algorithm_ETC;
import java.util.*;
public class algorithm_10610 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String st=sc.next();
		ArrayList<Integer> map=new ArrayList<Integer>();
		int n=st.length();
		boolean three=false;
		boolean zero=false;
		for(int i=0;i<n;i++) {
			map.add(st.charAt(i)-'0');
		}
		
		int tmp=0;
		for(int i=0;i<n;i++) {
			if(map.get(i)==0)
				zero=true;
			tmp+=map.get(i);
		}
		
		if(tmp%3==0)
			three=true;
		
		if(!three||!zero) {
			System.out.println(-1);
			return;
		}
		
		Collections.sort(map);
		Collections.reverse(map);
		
		for(int i=0;i<n;i++) {
			System.out.print(map.get(i));
		}
	}

}
