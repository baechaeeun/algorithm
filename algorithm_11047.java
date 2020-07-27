package algorithm_ETC;
import java.io.*;
import java.util.*;
public class algorithm_11047 {
	static int coinNum;
	static int target;
	static int inputCoin[];
	static int min;
	
	public static void main(String args[])throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		coinNum=Integer.parseInt(st.nextToken());
		target=Integer.parseInt(st.nextToken());
		inputCoin=new int[coinNum];
		for(int i=0;i<coinNum;i++)
			inputCoin[i]=Integer.parseInt(br.readLine());
		
		System.out.println(getMinNum(target));
	}
	
	public static int getMinNum(int target) {
		for(int i=coinNum-1;i>=0;i--) {
			if(target/inputCoin[i]>0) {
				min+=target/inputCoin[i];
				target=target%inputCoin[i];
			}
		}
		return min;
	}
}
