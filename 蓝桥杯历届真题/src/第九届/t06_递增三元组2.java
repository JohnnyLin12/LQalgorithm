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
1 3 1
3 2 5
4 2 6

3
1 1 3
2 3 5
2 4 6
 */
/*
 *这道题就是从A、B、C三个数组中分别选出一个数a、b、c
 *使得a<b<c
 
由于是A、B、C是降序排好序的 使用O(n)的双指针法

 首先比较B[p]与C[k]
如果k<N&&B[p]>=C[k] k右移直到第一个大于B[p]的位置

 然后k不动  b[p]记录N-k即C数组中大于B[p]的个数  
 前缀和数组记录截止到B[p]时  C数组中大于B[p]的个数累加和 
s[p]=(p==0?0:s[p-1])+b[p] 

然后p右移
 重复上述步骤 直至p或k>=N。


 
 
 比较A[i]与B[j]也是类似的
首先比较A[i]与B[j]
如果j<N&&A[i]>=B[j] j右移直到第一个大于A[i]的位置
 然后j不动 ans+=s[N-1]-(j==0?0:s[j-1]) 得到[j,N-1)区间C大于Bd的总个数

然后p右移
重复上述步骤 直至i或j>=N



 */
package 第九届;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月29日 下午8:55:23


*/

public class t06_递增三元组2 {
//	static void show(int a[]) {
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i]+" ");
//		}
//		System.out.println();
//	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(new File("src/data/in8.txt") ) );
		Scanner reader=new Scanner(System.in);
		int N=reader.nextInt();
		int A[]=new int[N];
		int B[]=new int[N];
		int C[]=new int[N];
		
		int b[]=new int[N];//记录C数组中大于B[i]的个数
		long s[]=new long[N];//记录前缀和(累加和) 超过整型范围 用long存储
		
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
		
		
		int p=0;
		int k=0;
		while(p<N) {
			while(k<N&&C[k]<=B[p]) {
				k++;
			}
			b[p]=N-k;
			s[p]=(p==0?0:s[p-1])+b[p];
			p++;
		}
		
		long ans=0;
		int i=0;
		int j=0;
		while(i<N) {
			while(j<N&&B[j]<=A[i]) {
				j++;
			}
			ans+=s[N-1]-(j==0?0:s[j-1]);
			i++;
		}
		System.out.println(ans);
		

	}

}
