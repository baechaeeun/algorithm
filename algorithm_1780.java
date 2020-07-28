package algorithm_ETC;
import java.util.*;
import java.io.*;
public class algorithm_1780 {
	static int arr[][];
	static int result[]=new int[3];
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
	
		fd(n,arr,0,0);
		
		for(int i=0;i<3;i++) {
			System.out.println(result[i]);
		}
		
		
	}
	public static void fd(int n,int [][]arr,int x,int y) {
		int i, j, tmp;
		boolean is_same = true;

		// n이 1일때 까지 작아지면, 그 값을 카운트해주고 함수를 종료한다.
		if (n == 1) 
		{
			add(arr[x][y]);
			return;
		}
		else 
		{
			// 행렬 전체가 같은 값을 가지는지 확인하는 부분
			tmp = arr[x][y];
			for (i = 0; i < n; i++)
				for (j = 0; j < n; j++)
					if (arr[x + i][y + j] != tmp)
						is_same = false;

			// 모두 같은 값을 가지면, 해당 변수 값을 증가시키고 종료
			if (is_same) 
			{
				add(tmp);
				return;
			}
			// 모두 같지 않으면, 9등분으로 나누어서 각각 재귀함수 호출
			else 
			{
				for (i = 0; i < n; i += n/3)
					for (j = 0; j < n; j += n/3)
						fd(n/3,arr, x + i, y + j);
			}
		}

	}
	public static void add(int tmp) {
		switch (tmp) {
		case -1: result[0] ++;
		break;
		case 0: result[1] ++;
		break;
		case 1: result[2]++;
		break;	
	}
	}

}
