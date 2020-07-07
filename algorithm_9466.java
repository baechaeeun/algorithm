package algorithm_dfs;
import java.util.*;
import java.io.*;
public class algorithm_9466 {
	static int T;
	static int num;
	static int [] arr;
	//static int [] visit;
	static int [] res;
	//static HashSet<Integer> res=new HashSet<>();
	static HashSet<Integer> set=new HashSet<>();
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int result=0;
			num=sc.nextInt();
			arr=new int[num+1];
			res=new int[num+1];
			
			for(int j=1;j<=num;j++)
				arr[j]=sc.nextInt();
			
			for(int j=1;j<=num;j++) {
				if(res[j]==0) {
					set=new HashSet<>();
					set.add(j);
					dfs(j,arr[j]);
				}
			}
			for(int j=1;j<=num;j++)
				if(res[j]==0)
					result++;
			System.out.println(result);
		}
	}
	public static void dfs(int start,int now) {
		int size=set.size();
		set.add(now);
		
		if(start==now) {
			for(int i:set) {
				res[i]=1;
			}
			return;
		}
		
		if(size==set.size())
			return;

		dfs(start,arr[now]);

	}
}
