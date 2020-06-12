/*

标题：递增三元组

给定三个整数数组
A = [A1, A2, ... AN], 
B = [B1, B2, ... BN], 
C = [C1, C2, ... CN]，
请你统计有多少个三元组(i, j, k) 满足：

1. 1 <= i, j, k <= N  
2. Ai < Bj < Ck  

【输入格式】
第一行包含一个整数N。
第二行包含N个整数A1, A2, ... AN。
第三行包含N个整数B1, B2, ... BN。
第四行包含N个整数C1, C2, ... CN。

对于30%的数据，1 <= N <= 100  
对于60%的数据，1 <= N <= 1000 
对于100%的数据，1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000 

【输出格式】
一个整数表示答案

【输入样例】
3
1 1 1
2 2 2
3 3 3

【输出样例】
27 


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。

3
1 2 1
3 2 5
1 3 1
2

 */
/*
 *就是从A、B、C三个数组中分别选出一个数a、b、c
 *使得a<b<c
 */
package 第九届;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年6月3日 下午7:30:20


*/

public class t06_递增三元组 {
	static void show(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(new File("src/data/in4.txt") ) );
		Scanner reader=new Scanner(System.in);
		int N=reader.nextInt();
		int A[]=new int[N];
		int B[]=new int[N];
		int C[]=new int[N];
		
		int a[]=new int[N];//记录B数组中第一个大于A[i]的下标
		int b[]=new int[N];//记录C数组中大于B[i]的个数
		
		for (int j = 0; j < N; j++) {
			A[j]=reader.nextInt();
		}
		for (int j = 0; j < N; j++) {
			B[j]=reader.nextInt();
		}
		for (int j = 0; j < N; j++) {
			C[j]=reader.nextInt();
		}
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		show(A);
		show(B);
		show(C);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(A[i]<B[j]) {
					//保存B数组中第一个大于A[i]的下标
					// A中下标与B中下标映射关系
					a[i]=j;
					break;
				}
			}
		}
		show(a);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(B[i]<C[j]) {
					//保存C数组大于B[i]的个数  B中下标与C个数映射关系
					b[i]=N-j;
					break;
				}
			}
		}
		show(b);
		int ans=0;
		for (int i = 0; i < N; i++) {
			//A数组选定一个数A[i] 那么大于这个数字的个数可以在a[i]中找到
			//同时也可以知道这个数在B中的位置为N-a[i] 从而获得C中大于这个数字的个数b[ N-a[i] ]
			for(int j=a[i];j<N;j++) {
				ans+= b[j];
			}
			System.out.println(ans);
		}
		
		//System.out.println(ans);

	}
	/*
10
6 0 9 2 4 6 2 3 4 4
6 4 8 7 6 9 0 7 8 0
1 5 2 9 6 6 0 6 8 3

	 */

}
